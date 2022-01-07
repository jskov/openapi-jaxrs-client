package dk.mada.jaxrs.generator;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

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
	
	private static final SortedSet<String> POJO_TEMPLATE_IMPORTS = new TreeSet<>(Set.of(
			"java.util.Objects"
			));
	private static final SortedSet<String> ENUM_TEMPLATE_IMPORTS = new TreeSet<>(Set.of(
			));

	private final GeneratorOpts opts;
	private final Templates templates;
	private final Model model;
	private final Identifiers identifiers = new Identifiers();
	private final Set<String> extraTemplates = new HashSet<>();

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
		
		extraTemplates.forEach(name -> {
			logger.info(" generate extra {}", name);

			CtxExtra ctx = makeCtxExtra(name);
			
			Path extraFile = dtoDir.resolve(name + ".java");
			templates.writeExtra(name, ctx, extraFile);
		});
	}
	
	private CtxExtra makeCtxExtra(String name) {
		SortedSet<String> imports = new TreeSet<>();
		
		String jacksonLocalDateWireFormat = opts.getJacksonLocalDateWireFormat();
		if (jacksonLocalDateWireFormat != null) {
			imports.add("java.io.IOException");
			imports.add("java.time.LocalDate");
			imports.add("java.time.format.DateTimeFormatter");
			
			if (opts.isJacksonCodehaus()) {
				if (name.contains("Deseria")) {
					imports.add("org.codehaus.jackson.JsonParser");
					imports.add("org.codehaus.jackson.map.DeserializationContext");
					imports.add("org.codehaus.jackson.map.JsonDeserializer");
				} else {
					imports.add("org.codehaus.jackson.JsonGenerator");
					imports.add("org.codehaus.jackson.map.SerializerProvider");
					imports.add("org.codehaus.jackson.map.JsonSerializer");
					imports.add("org.codehaus.jackson.JsonProcessingException");
				}
			} else {
				if (name.contains("Deseria")) {
					imports.add("com.fasterxml.jackson.core.JsonParser");
					imports.add("com.fasterxml.jackson.databind.DeserializationContext");
					imports.add("com.fasterxml.jackson.databind.JsonDeserializer");
				} else {
					imports.add("com.fasterxml.jackson.core.JsonGenerator");
					imports.add("com.fasterxml.jackson.core.JsonProcessingException");
					imports.add("com.fasterxml.jackson.databind.JsonSerializer");
					imports.add("com.fasterxml.jackson.databind.SerializerProvider");
				}
			}
		}

		Info info = model.info();
		return ImmutableCtxExtra.builder()
				.appName(info.title())
				.appDescription(info.description())
				.version(info.version())
				.infoEmail(info.contact().email())
				.generatedDate(opts.getGeneratedAtTime())
				.generatorClass(GENERATOR_CLASS)
				.imports(imports)
				.jacksonCodehaus(opts.isJacksonCodehaus())
				.jacksonFasterxml(opts.isJacksonFasterxml())
				.jsonb(opts.isJsonb())
				.packageName(opts.dtoPackage())
				.cannedLocalDateSerializerDTF(jacksonLocalDateWireFormat)
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
		
		SortedSet<String> dtoImports = new TreeSet<>();
		if (isEnum) {
			dtoImports.addAll(ENUM_TEMPLATE_IMPORTS);
		} else {
			dtoImports.addAll(POJO_TEMPLATE_IMPORTS);
		}
		dto.properties().stream()
			.forEach(p -> dtoImports.addAll(p.type().neededImports()));

		if (vars.stream().anyMatch(p -> p.madaProp().isRenderApiModelProperty())) {
			dtoImports.add("io.swagger.annotations.ApiModelProperty");
		}
		
		if (vars.stream().anyMatch(p -> p.madaProp().isUseBigDecimalForDouble())) {
			dtoImports.add("org.codehaus.jackson.annotate.JsonIgnore");
			dtoImports.add("java.math.BigDecimal");
		}

		String customLocalDateDeserializer = null;
		String customLocalDateSerializer = null;
		
		if (opts.isUseJacksonLocalDateSerializer()
				&& dto.properties().stream().anyMatch(p -> p.type() == TypeDate.get())) {
			extraTemplates.add("_LocalDateJacksonDeserializer");
			extraTemplates.add("_LocalDateJacksonSerializer");

			customLocalDateDeserializer = "_LocalDateJacksonDeserializer";
			customLocalDateSerializer = "_LocalDateJacksonSerializer";
			
			if (opts.isJacksonFasterxml()) {
				dtoImports.add("com.fasterxml.jackson.databind.annotation.JsonDeserialize");
				dtoImports.add("com.fasterxml.jackson.databind.annotation.JsonSerialize");
			} else {
				dtoImports.add("org.codehaus.jackson.map.annotate.JsonDeserialize");
				dtoImports.add("org.codehaus.jackson.map.annotate.JsonSerialize");
			}
		}
		
		if (opts.isJacksonFasterxml()) {
			if (isEnum) {
				dtoImports.add("java.util.Objects");
				dtoImports.add("com.fasterxml.jackson.annotation.JsonValue");
				dtoImports.add("com.fasterxml.jackson.annotation.JsonCreator");
			} else {
				dtoImports.add("com.fasterxml.jackson.annotation.JsonProperty");
				dtoImports.add("com.fasterxml.jackson.annotation.JsonPropertyOrder");
			}
		}
		
		if (opts.isJacksonCodehaus()) {
			if (isEnum) {
				dtoImports.add("java.util.Objects");
				dtoImports.add("org.codehaus.jackson.annotate.JsonValue");
				dtoImports.add("org.codehaus.jackson.annotate.JsonCreator");
			} else {
				dtoImports.add("org.codehaus.jackson.annotate.JsonProperty");
				dtoImports.add("org.codehaus.jackson.annotate.JsonPropertyOrder");
			}
		}		 

		if (opts.isJsonb()) {
			if (isEnum) {
				dtoImports.add("javax.json.Json");
				dtoImports.add("javax.json.JsonString");
				dtoImports.add("javax.json.bind.adapter.JsonbAdapter");
				dtoImports.add("javax.json.bind.annotation.JsonbTypeAdapter");
			} else {
				dtoImports.add("javax.json.bind.annotation.JsonbProperty");
				dtoImports.add("javax.json.bind.annotation.JsonbPropertyOrder");
			}
		}

		String jacksonJsonSerializeOptions = opts.getJsonSerializeOptions();
		if (jacksonJsonSerializeOptions != null) {
			dtoImports.add("org.codehaus.jackson.map.annotate.JsonSerialize");
		}
		
		CtxDtoExt mada = ImmutableCtxDtoExt.builder()
				.jacksonJsonSerializeOptions(jacksonJsonSerializeOptions)
				.jsonb(opts.isJsonb())
				.customLocalDateDeserializer(customLocalDateDeserializer)
				.customLocalDateSerializer(customLocalDateSerializer)
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
		
		logger.info("Property {} -> {} / {} / {}", name, varName, nameCamelized, nameSnaked);
		
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
