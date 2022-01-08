package dk.mada.jaxrs.generator;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.EnumSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.EnumNamer.EnumNameValue;
import dk.mada.jaxrs.generator.tmpl.dto.CtxDto;
import dk.mada.jaxrs.generator.tmpl.dto.CtxDtoExt;
import dk.mada.jaxrs.generator.tmpl.dto.CtxEnum;
import dk.mada.jaxrs.generator.tmpl.dto.CtxEnum.CtxEnumEntry;
import dk.mada.jaxrs.generator.tmpl.dto.CtxExtra;
import dk.mada.jaxrs.generator.tmpl.dto.CtxProperty;
import dk.mada.jaxrs.generator.tmpl.dto.CtxPropertyExt;
import dk.mada.jaxrs.generator.tmpl.dto.ImmutableCtxDto;
import dk.mada.jaxrs.generator.tmpl.dto.ImmutableCtxDtoExt;
import dk.mada.jaxrs.generator.tmpl.dto.ImmutableCtxEnum;
import dk.mada.jaxrs.generator.tmpl.dto.ImmutableCtxEnumEntry;
import dk.mada.jaxrs.generator.tmpl.dto.ImmutableCtxExtra;
import dk.mada.jaxrs.generator.tmpl.dto.ImmutableCtxProperty;
import dk.mada.jaxrs.generator.tmpl.dto.ImmutableCtxPropertyExt;
import dk.mada.jaxrs.model.ContainerArray;
import dk.mada.jaxrs.model.ContainerMap;
import dk.mada.jaxrs.model.ContainerSet;
import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.Info;
import dk.mada.jaxrs.model.Model;
import dk.mada.jaxrs.model.Primitive;
import dk.mada.jaxrs.model.Property;
import dk.mada.jaxrs.model.Type;
import dk.mada.jaxrs.model.TypeDate;
import dk.mada.jaxrs.openapi._OpenapiGenerator;

public class DtoGenerator {
	private static final Logger logger = LoggerFactory.getLogger(DtoGenerator.class);

	private static final String GENERATOR_CLASS = DtoGenerator.class.getName();
	
	enum ExtraTemplate {
		_LocalDateJacksonDeserializer,
		_LocalDateJacksonSerializer
	}
	
	private final GeneratorOpts opts;
	private final Templates templates;
	private final Model model;
	private final Identifiers identifiers = new Identifiers();
	private final EnumSet<ExtraTemplate> extraTemplates = EnumSet.noneOf(ExtraTemplate.class);

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
				
				logger.info("{} ctx: {}", name, ctx);
				
				templates.writeDto(ctx, dtoFile);
			});
		
		extraTemplates.forEach(tmpl -> {
			logger.info(" generate extra {}", tmpl);

			CtxExtra ctx = makeCtxExtra(tmpl);
			
			String tmplName = tmpl.name();
			Path extraFile = dtoDir.resolve(tmplName + ".java");
			templates.writeExtra(tmplName, ctx, extraFile);
		});
	}
	
	private CtxExtra makeCtxExtra(ExtraTemplate tmpl) {
		var imports = Imports.newExtras(opts, tmpl);
		
		Info info = model.info();
		return ImmutableCtxExtra.builder()
				.appName(info.title())
				.appDescription(info.description())
				.version(info.version())
				.infoEmail(info.contact().email())
				.generatedDate(opts.getGeneratedAtTime())
				.generatorClass(GENERATOR_CLASS)
				.imports(imports.get())
				.jacksonCodehaus(opts.isJacksonCodehaus())
				.jacksonFasterxml(opts.isJacksonFasterxml())
				.jsonb(opts.isJsonb())
				.packageName(opts.dtoPackage())
				.cannedLocalDateSerializerDTF(opts.getJacksonLocalDateWireFormat())
				.build();
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
		boolean isEnum = dto.isEnum();
		if (isEnum) {
			List<CtxEnumEntry> entries = new EnumNamer(dto.dtoType(), dto.enumValues())
					.getEntries().stream()
					.map(e -> toEnumEntry(dto.dtoType(), e))
					.collect(toList());
			
			ctxEnum = ImmutableCtxEnum.builder()
					.enumVars(entries)
					.build();
		}
		
		var dtoImports = isEnum ? Imports.newEnum(opts) : Imports.newPojo(opts);

		dtoImports.addPropertyImports(dto.properties());
		dtoImports.addCtxPropImports(vars);

		String customLocalDateDeserializer = null;
		String customLocalDateSerializer = null;
		
		if (opts.isUseJacksonLocalDateSerializer()
				&& (dto.dtoType() == TypeDate.get()
					|| dto.properties().stream().anyMatch(p -> p.type() == TypeDate.get()))) {
			extraTemplates.add(ExtraTemplate._LocalDateJacksonDeserializer);
			extraTemplates.add(ExtraTemplate._LocalDateJacksonSerializer);

			customLocalDateDeserializer = ExtraTemplate._LocalDateJacksonDeserializer.name();
			customLocalDateSerializer = ExtraTemplate._LocalDateJacksonSerializer.name();
			
			dtoImports.jackson("JsonDeserialize", "JsonSerialize");
		}
		
		CtxDtoExt mada = ImmutableCtxDtoExt.builder()
				.jacksonJsonSerializeOptions(opts.getJsonSerializeOptions())
				.jsonb(opts.isJsonb())
				.customLocalDateDeserializer(customLocalDateDeserializer)
				.customLocalDateSerializer(customLocalDateSerializer)
				.build();
		
		return ImmutableCtxDto.builder()
				.appName(info.title())
				.appDescription(info.description())
				.version(info.version())
				.infoEmail(info.contact().email())
				
				.imports(dtoImports.get())

				.packageName(opts.dtoPackage())
				.classname(dto.name())
				.classVarName("other")
				
				.vars(vars)
				
				.allowableValues(ctxEnum)
				.dataType(dto.dtoType().typeName())
				
				.jackson(opts.isJackson())
				
				.generatorClass(GENERATOR_CLASS)
				.generatedDate(opts.getGeneratedAtTime())
				
				.madaDto(mada)
				
				.build();
	}

	private CtxEnumEntry toEnumEntry(Type enumType, EnumNameValue e) {
		String strValue = e.value();
		if (enumType != Primitive.INT) {
			strValue = "\"" + strValue + "\"";
		}
		return ImmutableCtxEnumEntry.builder()
				.name(e.name())
				.value(strValue)
				.build();
	}

	private CtxProperty toCtxProperty(Property p) {
		String name = p.name();
		String varName = identifiers.makeValidVariableName(name);

		String nameCamelized = _OpenapiGenerator.camelize(varName);
		String nameSnaked = _OpenapiGenerator.underscore(nameCamelized).toUpperCase();
		
		logger.trace("Property {} -> {} / {} / {}", name, varName, nameCamelized, nameSnaked);
		
		String defaultValue = null;
		boolean isRequired = p.isRequired();
		boolean isArray = false;
		boolean isMap = false;
		boolean isSet = false;
		boolean isDate = p.type() instanceof TypeDate;
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
		if (p.type() instanceof ContainerSet cs) {
			isSet = true;
			innerType = cs.innerType().typeName();
			defaultValue = "new HashSet<>()";
			
			// In templates, array is used for both set and list
			isArray = true;
		}

		boolean isContainer = isArray || isMap || isSet;
		
		String typeName = p.type().typeName();
		if (p.type() instanceof Primitive prim) {
			typeName = prim.wrapperType();
		}

		String getterPrefix = getterPrefix(p);
		String getter = getterPrefix + nameCamelized;
		String setter = "set" + nameCamelized;
		String extGetter = getter;
		String extSetter = setter;
		boolean isUseBigDecimalForDouble =
				opts.isUseBigDecimalForDouble()
				&& p.type() == Primitive.DOUBLE;
		if (isUseBigDecimalForDouble) {
			getter = getter+"Double";
			setter = setter+"Double";
		}

		boolean isUseEmptyCollections =
				opts.isUseEmptyCollections()
				&& isContainer
				&& !isRequired;
		if (isUseEmptyCollections) {
			getter = getter+"Nullable";
		}

		boolean isRenderApiModelProperty =
				isRequired
				|| isNotBlank(p.example())
				|| isNotBlank(p.description());
		
		CtxPropertyExt mada = ImmutableCtxPropertyExt.builder()
				.innerDatatypeWithEnum(innerType)
				.isRenderApiModelProperty(isRenderApiModelProperty)
				.isUseBigDecimalForDouble(isUseBigDecimalForDouble)
				.isUseEmptyCollections(isUseEmptyCollections)
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
				.isSet(isSet)
				.isContainer(isContainer)
				.isDate(isDate)
				.defaultValue(defaultValue)
				.required(isRequired)
				.example(p.example())
				.madaProp(mada)
				.build();
	}

	private String getterPrefix(Property p) {
		boolean isBoolean = p.type() == Primitive.BOOLEAN;
		String getterPrefix = "get";
		if (isBoolean && !opts.isUseBooleanGetPrefix()) {
			getterPrefix = "is";
		}
		return getterPrefix;
	}
	
	private boolean isNotBlank(String s) {
		return s != null && !s.isBlank();
	}
}
