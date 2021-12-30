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
import dk.mada.jaxrs.generator.tmpl.dto.CtxEnum;
import dk.mada.jaxrs.generator.tmpl.dto.CtxEnum.CtxEnumEntry;
import dk.mada.jaxrs.generator.tmpl.dto.CtxProperty;
import dk.mada.jaxrs.generator.tmpl.dto.ImmutableCtxDto;
import dk.mada.jaxrs.generator.tmpl.dto.ImmutableCtxEnum;
import dk.mada.jaxrs.generator.tmpl.dto.ImmutableCtxEnumEntry;
import dk.mada.jaxrs.generator.tmpl.dto.ImmutableCtxProperty;
import dk.mada.jaxrs.model.ContainerArray;
import dk.mada.jaxrs.model.ContainerMap;
import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.Info;
import dk.mada.jaxrs.model.Model;
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
	
	private String dtoOutputName(Dto type) {
		return type.name() + ".java";
	}
	
	private CtxDto toCtx(Dto type) {
		Info info = model.info();
		
		List<CtxProperty> vars = type.properties().stream()
			.map(this::toCtxProperty)
			.collect(toList());
		
		CtxEnum ctxEnum = null;
		if (type.isEnum()) {
			List<CtxEnumEntry> values = type.enumValues().stream()
					.map(this::toEnumEntry)
					.collect(toList());
			ctxEnum = ImmutableCtxEnum.builder()
					.enumVars(values)
					.build();
		}
		
		SortedSet<String> dtoImports = new TreeSet<>();
		if (type.isEnum()) {
			dtoImports.addAll(ENUM_TEMPLATE_IMPORTS);
		} else {
			dtoImports.addAll(POJO_TEMPLATE_IMPORTS);
		}
		type.properties().stream()
			.forEach(p -> dtoImports.addAll(p.type().neededImports()));

		if (vars.stream().anyMatch(CtxProperty::isRenderApiModelProperty)) {
			dtoImports.add("io.swagger.annotations.ApiModelProperty");
		}

		if (opts.isJacksonFasterxml()) {
			dtoImports.add("com.fasterxml.jackson.annotation.JsonProperty");
			dtoImports.add("com.fasterxml.jackson.annotation.JsonPropertyOrder");
		}
		
		if (opts.isJacksonCodehaus()) {
			dtoImports.add("org.codehaus.jackson.annotate.JsonProperty");
			dtoImports.add("org.codehaus.jackson.annotate.JsonPropertyOrder");
		}		 
		
		return ImmutableCtxDto.builder()
				.appName(info.title())
				.appDescription(info.description())
				.version(info.version())
				.infoEmail(info.contact().email())
				
				.imports(dtoImports)

				.packageName(opts.dtoPackage())
				.classname(type.name())
				.classVarName("other")
				
				.vars(vars)
				
				.allowableValues(ctxEnum)
				.dataType("String")
				
				.jackson(opts.isJackson())
				
				.generatorClass(this.getClass().getName())
				.generatedDate(opts.getGeneratedAtTime())
				
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

		boolean isRenderApiModelProperty = p.isRequired()
				|| isNotBlank(p.example())
				|| isNotBlank(p.description());
		
		return ImmutableCtxProperty.builder()
				.baseName(name)
				.datatypeWithEnum(p.type().typeName())
				.name(varName)
				.nameInCamelCase(nameCamelized)
				.nameInSnakeCase(nameSnaked)
				.getter("get" + nameCamelized)
				.setter("set" + nameCamelized)
				.description(p.description())
				.isArray(isArray)
				.isMap(isMap)
				.innerDatatypeWithEnum(innerType)
				.defaultValue(defaultValue)
				.isRenderApiModelProperty(isRenderApiModelProperty)
				.required(p.isRequired())
				.build();
	}
	
	private boolean isNotBlank(String s) {
		return s != null && !s.isBlank();
	}
}
