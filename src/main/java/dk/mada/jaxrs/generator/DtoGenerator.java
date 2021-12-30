package dk.mada.jaxrs.generator;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.tmpl.dto.CtxDto;
import dk.mada.jaxrs.generator.tmpl.dto.CtxDtoExt;
import dk.mada.jaxrs.generator.tmpl.dto.CtxEnum;
import dk.mada.jaxrs.generator.tmpl.dto.CtxEnum.CtxEnumEntry;
import dk.mada.jaxrs.generator.tmpl.dto.CtxProperty;
import dk.mada.jaxrs.generator.tmpl.dto.CtxPropertyExt;
import dk.mada.jaxrs.generator.tmpl.dto.ImmutableCtxDto;
import dk.mada.jaxrs.generator.tmpl.dto.ImmutableCtxDtoExt;
import dk.mada.jaxrs.generator.tmpl.dto.ImmutableCtxEnum;
import dk.mada.jaxrs.generator.tmpl.dto.ImmutableCtxEnumEntry;
import dk.mada.jaxrs.generator.tmpl.dto.ImmutableCtxProperty;
import dk.mada.jaxrs.generator.tmpl.dto.ImmutableCtxPropertyExt;
import dk.mada.jaxrs.model.ContainerArray;
import dk.mada.jaxrs.model.ContainerMap;
import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.Info;
import dk.mada.jaxrs.model.Model;
import dk.mada.jaxrs.model.Primitive;
import dk.mada.jaxrs.model.Property;
import dk.mada.jaxrs.openapi._OpenapiGenerator;

public class DtoGenerator {
	private static final Logger logger = LoggerFactory.getLogger(DtoGenerator.class);

	private static final SortedSet<String> POJO_TEMPLATE_IMPORTS = new TreeSet<>(Set.of(
			"java.util.Objects"
			));
	private static final SortedSet<String> ENUM_TEMPLATE_IMPORTS = new TreeSet<>(Set.of(
			));

	private final GeneratorOpts opts;
	private final Templates templates;
	private final Model model;
	private final Identifiers identifiers = new Identifiers();

	public DtoGenerator(GeneratorOpts opts, Templates templates, Model model) {
		this.opts = opts;
		this.templates = templates;
		this.model = model;
	}
	
	public void generateDtoClasses(Path dtoDir) throws IOException {
		Files.createDirectories(dtoDir);
		model.types().get()
			.forEach(type -> {
				String name = type.name();
				logger.info(" generate type {}", name);

				Path dtoFile = dtoDir.resolve(dtoOutputName(type));
				
				CtxDto ctx = toCtx(type);
				
				templates.writeDto(ctx, dtoFile);
			});
	}
	
	private String dtoOutputName(Dto dto) {
		return dto.name() + ".java";
	}
	
	private CtxDto toCtx(Dto dto) {
		Info info = model.info();
		
		List<CtxProperty> vars = dto.properties().stream()
			.map(this::toCtxProperty)
			.collect(toList());
		
		CtxEnum ctxEnum = null;
		if (dto.isEnum()) {
			List<CtxEnumEntry> values = dto.enumValues().stream()
					.map(this::toEnumEntry)
					.collect(toList());
			ctxEnum = ImmutableCtxEnum.builder()
					.enumVars(values)
					.build();
		}
		
		SortedSet<String> dtoImports = new TreeSet<>();
		if (dto.isEnum()) {
			dtoImports.addAll(ENUM_TEMPLATE_IMPORTS);
		} else {
			dtoImports.addAll(POJO_TEMPLATE_IMPORTS);
		}
		dto.properties().stream()
			.forEach(p -> dtoImports.addAll(p.type().neededImports()));

		if (vars.stream().anyMatch(p -> p.mada().isRenderApiModelProperty())) {
			dtoImports.add("io.swagger.annotations.ApiModelProperty");
		}
		
		if (vars.stream().anyMatch(p -> p.mada().isUseBigDecimalForDouble())) {
			dtoImports.add("org.codehaus.jackson.annotate.JsonIgnore");
			dtoImports.add("java.math.BigDecimal");
		}

		if (opts.isJacksonFasterxml()) {
			dtoImports.add("com.fasterxml.jackson.annotation.JsonProperty");
			dtoImports.add("com.fasterxml.jackson.annotation.JsonPropertyOrder");
		}
		
		if (opts.isJacksonCodehaus()) {
			dtoImports.add("org.codehaus.jackson.annotate.JsonProperty");
			dtoImports.add("org.codehaus.jackson.annotate.JsonPropertyOrder");
		}		 
		
		String jacksonJsonSerializeOptions = opts.getJsonSerializeOptions();
		if (jacksonJsonSerializeOptions != null) {
			dtoImports.add("org.codehaus.jackson.map.annotate.JsonSerialize");
		}
		
		CtxDtoExt mada = ImmutableCtxDtoExt.builder()
				.jacksonJsonSerializeOptions(jacksonJsonSerializeOptions)
				.build();
		
		return ImmutableCtxDto.builder()
				.appName(info.title())
				.appDescription(info.description())
				.version(info.version())
				.infoEmail(info.contact().email())
				
				.imports(dtoImports)

				.packageName(opts.dtoPackage())
				.classname(dto.name())
				.classVarName("other")
				
				.vars(vars)
				
				.allowableValues(ctxEnum)
				.dataType("String")
				
				.jackson(opts.isJackson())
				
				.generatorClass(this.getClass().getName())
				.generatedDate(opts.getGeneratedAtTime())
				
				.mada(mada)
				
				.build();
	}

	private CtxEnumEntry toEnumEntry(String v) {
		return ImmutableCtxEnumEntry.builder()
				.name(v)
				.value("\"" + v + "\"")
				.build();
	}

	private CtxProperty toCtxProperty(Property p) {
		String name = p.name();
		String varName = identifiers.makeValidVariableName(name);

		String nameCamelized = _OpenapiGenerator.camelize(varName);
		String nameSnaked = _OpenapiGenerator.underscore(nameCamelized).toUpperCase();
		
		logger.info("Property {} -> {} / {} / {}", name, varName, nameCamelized, nameSnaked);
		
		String defaultValue = null;
		boolean isArray = false;
		boolean isMap = false;
		String innerType = null;
		if (p.type() instanceof ContainerArray ca) {
			isArray = true;
			innerType = ca.innerType().typeName();
			defaultValue = "new ArrayList<>()";
		}
		if (p.type() instanceof ContainerMap cm) {
			isMap = true;
			innerType = cm.innerType().typeName();
			defaultValue = "new HashMap<>()";
		}

		String typeName = p.type().typeName();
		if (p.type() instanceof Primitive prim) {
			typeName = prim.wrapperType();
		}

		String getter = "get" + nameCamelized;
		String setter = "set" + nameCamelized;
		String extGetter = getter;
		String extSetter = setter;
		boolean isUseBigDecimalForDouble = opts.isUseBigDecimalForDouble()
				&& p.type() == Primitive.DOUBLE;
		if (isUseBigDecimalForDouble) {
			getter = getter+"Double";
			setter = setter+"Double";
		}

		boolean isRequired = p.isRequired();
		boolean isRenderApiModelProperty = isRequired
				|| isNotBlank(p.example())
				|| isNotBlank(p.description());
		
		CtxPropertyExt mada = ImmutableCtxPropertyExt.builder()
				.innerDatatypeWithEnum(innerType)
				.isRenderApiModelProperty(isRenderApiModelProperty)
				.isUseBigDecimalForDouble(isUseBigDecimalForDouble)
				.getter(extGetter)
				.setter(extSetter)
				.build();
		
		return ImmutableCtxProperty.builder()
				.baseName(name)
				.datatypeWithEnum(typeName)
				.name(varName)
				.nameInCamelCase(nameCamelized)
				.nameInSnakeCase(nameSnaked)
				.getter(getter)
				.setter(setter)
				.description(p.description())
				.isArray(isArray)
				.isMap(isMap)
				.defaultValue(defaultValue)
				.required(isRequired)
				.example(p.example())
				.mada(mada)
				.build();
	}
	
	private boolean isNotBlank(String s) {
		return s != null && !s.isBlank();
	}
}
