package dk.mada.jaxrs.generator.dto;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.Generator;
import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.generator.Imports;
import dk.mada.jaxrs.generator.Templates;
import dk.mada.jaxrs.generator.dto.tmpl.CtxDto;
import dk.mada.jaxrs.generator.dto.tmpl.CtxDtoExt;
import dk.mada.jaxrs.generator.dto.tmpl.CtxEnum;
import dk.mada.jaxrs.generator.dto.tmpl.CtxExtra;
import dk.mada.jaxrs.generator.dto.tmpl.CtxProperty;
import dk.mada.jaxrs.generator.dto.tmpl.CtxPropertyExt;
import dk.mada.jaxrs.generator.dto.tmpl.CtxEnum.CtxEnumEntry;
import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.Info;
import dk.mada.jaxrs.model.Model;
import dk.mada.jaxrs.model.Property;
import dk.mada.jaxrs.model.types.Primitive;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeArray;
import dk.mada.jaxrs.model.types.TypeMap;
import dk.mada.jaxrs.model.types.TypeRef;
import dk.mada.jaxrs.model.types.TypeSet;
import dk.mada.jaxrs.model.types.Types;
import dk.mada.jaxrs.naming.EnumNamer;
import dk.mada.jaxrs.naming.Identifiers;
import dk.mada.jaxrs.naming.Naming;
import dk.mada.jaxrs.naming.EnumNamer.EnumNameValue;
import dk.mada.jaxrs.openapi._OpenapiGenerator;

public class DtoGenerator {
	private static final Logger logger = LoggerFactory.getLogger(DtoGenerator.class);

	public enum ExtraTemplate {
		_LocalDateJacksonDeserializer,
		_LocalDateJacksonSerializer,
		_OffsetDateTimeJacksonDeserializer,
		_OffsetDateTimeJacksonSerializer
	}
	
	private final Naming naming;
	private final Types types;
	private final GeneratorOpts opts;
	private final Templates templates;
	private final Model model;
	private final Identifiers identifiers = new Identifiers();
	private final EnumSet<ExtraTemplate> extraTemplates = EnumSet.noneOf(ExtraTemplate.class);


	public DtoGenerator(Naming naming, GeneratorOpts opts, Templates templates, Model model) {
		this.naming = naming;
		this.opts = opts;
		this.templates = templates;
		this.model = model;
		
		types = model.types();
	}
	
	public void generateDtoClasses(Path dtoDir) throws IOException {
		Files.createDirectories(dtoDir);
		types.getActiveDtos().stream()
			.sorted((a, b) -> a.name().compareTo(b.name()))
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
		var imports = Imports.newExtras(types, opts, tmpl);
		
		Info info = model.info();
		return CtxExtra.builder()
				.appName(info.title())
				.appDescription(info.description())
				.version(info.version())
				.infoEmail(info.contact().email())
				.generatedDate(opts.getGeneratedAtTime())
				.generatorClass(Generator.GENERATOR_CLASS)
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
		
		boolean isEnum = dto.isEnum();
		var dtoImports = isEnum ? Imports.newEnum(types, opts) : Imports.newPojo(types, opts);

		List<CtxProperty> vars = dto.properties().stream()
			.map(p -> toCtxProperty(dtoImports, p))
			.collect(toList());
		
		CtxEnum ctxEnum = null;
		Type dtoType = derefType(dto.dtoType());
		if (isEnum) {
			List<CtxEnumEntry> entries = new EnumNamer(naming, opts, dtoType, dto.enumValues())
					.getEntries().stream()
					.map(e -> toEnumEntry(dtoType, e))
					.collect(toList());
			
			ctxEnum = new CtxEnum(entries);
		}

		dtoImports.addPropertyImports(dto.properties());

		String customLocalDateDeserializer = null;
		String customLocalDateSerializer = null;
		
		if (opts.isUseJacksonLocalDateSerializer()
				&& (dtoType.isDate()
					|| dto.properties().stream().anyMatch(p -> p.type().isDate()))) {
			extraTemplates.add(ExtraTemplate._LocalDateJacksonDeserializer);
			extraTemplates.add(ExtraTemplate._LocalDateJacksonSerializer);

			customLocalDateDeserializer = ExtraTemplate._LocalDateJacksonDeserializer.name();
			customLocalDateSerializer = ExtraTemplate._LocalDateJacksonSerializer.name();
			
			dtoImports.jackson("JsonDeserialize", "JsonSerialize");
		}

		String customOffsetDateTimeDeserializer = null;
		String customOffsetDateTimeSerializer = null;

		if (opts.isUseJacksonOffsetDateTimeSerializer()
				&& (dtoType.isDateTime()
					|| dto.properties().stream().anyMatch(p -> p.type().isDateTime()))) {
			extraTemplates.add(ExtraTemplate._OffsetDateTimeJacksonDeserializer);
			extraTemplates.add(ExtraTemplate._OffsetDateTimeJacksonSerializer);

			customOffsetDateTimeDeserializer = ExtraTemplate._OffsetDateTimeJacksonDeserializer.name();
			customOffsetDateTimeSerializer = ExtraTemplate._OffsetDateTimeJacksonSerializer.name();
			
			dtoImports.jackson("JsonDeserialize", "JsonSerialize");
		}
		
		CtxDtoExt mada = CtxDtoExt.builder()
				.jacksonJsonSerializeOptions(opts.getJsonSerializeOptions())
				.jsonb(opts.isJsonb())
				.customLocalDateDeserializer(customLocalDateDeserializer)
				.customLocalDateSerializer(customLocalDateSerializer)
				.customOffsetDateTimeDeserializer(customOffsetDateTimeDeserializer)
				.customOffsetDateTimeSerializer(customOffsetDateTimeSerializer)
				.build();
		
		return CtxDto.builder()
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
				.dataType(dtoType.typeName().name())
				
				.jackson(opts.isJackson())
				
				.generatorClass(Generator.GENERATOR_CLASS)
				.generatedDate(opts.getGeneratedAtTime())
				
				.madaDto(mada)
				
				.build();
	}

	private CtxEnumEntry toEnumEntry(Type enumType, EnumNameValue e) {
		String strValue = e.value();
		if (enumType != Primitive.INT) {
			strValue = "\"" + strValue + "\"";
		}
		return new CtxEnumEntry(e.name(), strValue);
	}

	private CtxProperty toCtxProperty(Imports dtoImports, Property p) {
		String name = p.name();
		String varName = identifiers.makeValidVariableName(name);

		String nameCamelized = _OpenapiGenerator.camelize(varName);
		String nameSnaked = _OpenapiGenerator.underscore(nameCamelized).toUpperCase();
		
		logger.trace("Property {} -> {} / {} / {}", name, varName, nameCamelized, nameSnaked);

		Type propType = derefType(p.type());
		logger.trace(" {}", propType);

		String defaultValue = null;
		boolean isRequired = p.isRequired();
		boolean isArray = false;
		boolean isMap = false;
		boolean isSet = false;
		boolean isDate = propType.isDate();
		boolean isDateTime = propType.isDateTime();
		String innerType = null;
		
		if (propType instanceof TypeArray ca) {
			isArray = true;
			innerType = ca.mappedInnerType().typeName().name();
			defaultValue = "new ArrayList<>()";
		}
		if (propType instanceof TypeMap cm) {
			isMap = true;
			innerType = cm.innerType().typeName().name();
			defaultValue = "new HashMap<>()";
		}
		if (propType instanceof TypeSet cs) {
			isSet = true;
			innerType = cs.innerType().typeName().name();
			defaultValue = "new HashSet<>()";
			
			// In templates, array is used for both set and list
			isArray = true;
		}

		boolean isContainer = isArray || isMap || isSet;
		
		String typeName = propType.wrapperTypeName().name();

		String getterPrefix = getterPrefix(p);
		String getter = getterPrefix + nameCamelized;
		String setter = "set" + nameCamelized;
		String extGetter = getter;
		String extSetter = setter;
		boolean isUseBigDecimalForDouble =
				opts.isUseBigDecimalForDouble()
				&& propType == Primitive.DOUBLE;
		if (isUseBigDecimalForDouble) {
			getter = getter+"Double";
			setter = setter+"Double";
			
			dtoImports.jackson("JsonIgnore");
			dtoImports.add("java.math.BigDecimal");
		}

		boolean isUseEmptyCollections =
				opts.isUseEmptyCollections()
				&& isContainer
				&& !isRequired;
		if (isUseEmptyCollections) {
			getter = getter+"Nullable";
		}

		List<String> schemaEntries = new ArrayList<>();
		if (isRequired) {
			schemaEntries.add("required = true");
		}
		if (p.isNullable()) {
			schemaEntries.add("nullable = true");
		}
		if (p.isReadonly()) {
			schemaEntries.add("accessMode = AccessMode.READ_ONLY");
			dtoImports.add("io.swagger.v3.oas.annotations.media.Schema.AccessMode");
		}
		if (isNotBlank(p.description())) {
			schemaEntries.add("description = \"" + p.description() + "\"");
		}
		if (isNotBlank(p.example())) {
			schemaEntries.add("example = \"" + p.example() + "\"");
		}
		String schemaOptions = null;
		if (!schemaEntries.isEmpty()) {
			schemaOptions = String.join(", ", schemaEntries);
			dtoImports.add("io.swagger.v3.oas.annotations.media.Schema");
		}
		
		CtxPropertyExt mada = CtxPropertyExt.builder()
				.innerDatatypeWithEnum(innerType)
				.schemaOptions(schemaOptions)
				.isUseBigDecimalForDouble(isUseBigDecimalForDouble)
				.isUseEmptyCollections(isUseEmptyCollections)
				.getter(extGetter)
				.setter(extSetter)
				.build();
		
		return CtxProperty.builder()
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
				.isDateTime(isDateTime)
				.defaultValue(defaultValue)
				.required(isRequired)
				.example(p.example())
				.madaProp(mada)
				.build();
	}

	private Type derefType(Type t) {
		Type mapped = types.map(t);
		if (mapped instanceof TypeRef tr) {
			return tr.dereference();
		}
		return mapped;
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
