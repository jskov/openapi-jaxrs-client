package dk.mada.jaxrs.generator;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.model.Property;
import dk.mada.jaxrs.model.types.Reference;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeContainer;

/**
 * Keeps track of imports for a single template, taking
 * generator options into consideration.
 */
public final class Imports {
    private static final Logger logger = LoggerFactory.getLogger(Imports.class);

    private static final String JSON_DESERIALIZE = "JsonDeserialize";
    private static final String JSON_CREATOR = "JsonCreator";
    private static final String JSON_IGNORE = "JsonIgnore";
    private static final String JSON_PROPERTY = "JsonProperty";
    private static final String JSON_PROPERTY_ORDER = "JsonPropertyOrder";
    private static final String JSON_SERIALIZE = "JsonSerialize";
    private static final String JSON_VALUE = "JsonValue";
    private static final String LOCAL_DATE_TIME = "java.time.LocalDateTime";
    private static final String ZONE_ID = "java.time.ZoneId";
    private static final String DATE_TIME_PARSE_EXCEPTION = "java.time.format.DateTimeParseException";
    private static final String JSON_DESERIALIZER = "JsonDeserializer";
    private static final String DESERIALIZATION_CONTEXT = "DeserializationContext";
    private static final String JSON_PARSER = "JsonParser";
    private static final String JSON_PROCESSING_EXCEPTION = "JsonProcessingException";
    private static final String JSON_SERIALIZER = "JsonSerializer";
    private static final String SERIALIZER_PROVIDER = "SerializerProvider";
    private static final String JSON_GENERATOR = "JsonGenerator";
    private static final String OFFSET_DATE_TIME = "java.time.OffsetDateTime";
    private static final String DATE_TIME_FORMATTER = "java.time.format.DateTimeFormatter";
    private static final String LOCAL_DATE = "java.time.LocalDate";
    private static final String IOEXCEPTION = "java.io.IOException";
    private static final String JAVA_UTIL_OBJECTS = "java.util.Objects";
    /** Imports needed for list types. */
    public static final Set<String> LIST_TYPES = Set.of("java.util.List", "java.util.ArrayList");
    /** Imports needed for map types. */
    public static final Set<String> MAP_TYPES = Set.of("java.util.Map", "java.util.HashMap");
    /** Imports needed for set types. */
    public static final Set<String> SET_TYPES = Set.of("java.util.Set", "java.util.LinkedHashSet");
    private static final Set<String> CONTAINER_IMPLEMENTATION_TYPES = Set.of(
            "java.util.ArrayList",
            "java.util.HashMap",
            "java.util.LinkedHashSet");

    /** Jackson codehaus imports. */
    private static final Map<String, String> JACKSON_CODEHAUS = new HashMap<>();
    static {
        JACKSON_CODEHAUS.putAll(Map.of(
                DESERIALIZATION_CONTEXT, "org.codehaus.jackson.map.DeserializationContext",
                JSON_CREATOR,            "org.codehaus.jackson.annotate.JsonCreator",
                JSON_DESERIALIZE,        "org.codehaus.jackson.map.annotate.JsonDeserialize",
                JSON_DESERIALIZER,       "org.codehaus.jackson.map.JsonDeserializer",
                JSON_GENERATOR,          "org.codehaus.jackson.JsonGenerator",
                JSON_IGNORE,             "org.codehaus.jackson.annotate.JsonIgnore"));
        JACKSON_CODEHAUS.putAll(Map.of(
                JSON_PARSER,               "org.codehaus.jackson.JsonParser",
                JSON_PROCESSING_EXCEPTION, "org.codehaus.jackson.JsonProcessingException",
                JSON_PROPERTY,             "org.codehaus.jackson.annotate.JsonProperty",
                JSON_PROPERTY_ORDER,       "org.codehaus.jackson.annotate.JsonPropertyOrder",
                JSON_SERIALIZE,            "org.codehaus.jackson.map.annotate.JsonSerialize",
                JSON_SERIALIZER,           "org.codehaus.jackson.map.JsonSerializer",
                JSON_VALUE,                "org.codehaus.jackson.annotate.JsonValue",
                SERIALIZER_PROVIDER,       "org.codehaus.jackson.map.SerializerProvider"));
    }

    /** Jackson fasterxml imports. */
    private static final Map<String, String> JACKSON_FASTERXML = new HashMap<>();
    static {
        JACKSON_FASTERXML.putAll(Map.of(
                DESERIALIZATION_CONTEXT,   "com.fasterxml.jackson.databind.DeserializationContext",
                JSON_CREATOR,              "com.fasterxml.jackson.annotation.JsonCreator",
                JSON_DESERIALIZE,          "com.fasterxml.jackson.databind.annotation.JsonDeserialize",
                JSON_DESERIALIZER,         "com.fasterxml.jackson.databind.JsonDeserializer",
                JSON_GENERATOR,            "com.fasterxml.jackson.core.JsonGenerator",
                JSON_IGNORE,               "com.fasterxml.jackson.annotation.JsonIgnore",
                JSON_PARSER,               "com.fasterxml.jackson.core.JsonParser",
                JSON_PROCESSING_EXCEPTION, "com.fasterxml.jackson.core.JsonProcessingException"));

        JACKSON_FASTERXML.putAll(Map.of(
                JSON_PROPERTY,           "com.fasterxml.jackson.annotation.JsonProperty",
                JSON_PROPERTY_ORDER,     "com.fasterxml.jackson.annotation.JsonPropertyOrder",
                JSON_SERIALIZE,          "com.fasterxml.jackson.databind.annotation.JsonSerialize",
                JSON_SERIALIZER,         "com.fasterxml.jackson.databind.JsonSerializer",
                JSON_VALUE,              "com.fasterxml.jackson.annotation.JsonValue",
                SERIALIZER_PROVIDER,     "com.fasterxml.jackson.databind.SerializerProvider"));
    }

    /** Generator options. */
    private final GeneratorOpts opts;

    /** Set of classes to be imported.*/
    private final SortedSet<String> importedClasses = new TreeSet<>();

    /** Flag selecting if imports should be added for DTOs. */
    private final boolean includeDtoImports;

    /** External type mapping. */
    private final Map<String, String> externalTypeMapping;

    private Imports(GeneratorOpts opts, boolean includeDtoImports) {
        this.opts = opts;
        this.includeDtoImports = includeDtoImports;

        externalTypeMapping = opts.getExternalTypeMapping();
    }

    /** {@return a sorted set of classes to import} */
    public SortedSet<String> get() {
        return importedClasses;
    }

    /**
     * Creates a new instance for API files.
     *
     * Adds common imports need by all APIs.
     *
     * @param opts the generator options
     * @return a new imports instance loaded with enumeration imports
     */
    public static Imports newApi(GeneratorOpts opts) {
        return new Imports(opts, true)
                .javax("javax.ws.rs.*");
    }

    /**
     * Creates a new instance for DTO files.
     *
     * Adds common imports need by all DTOs.
     *
     * @param opts the generator options
     * @return a new imports instance loaded with enumeration imports
     */
    public static Imports newDto(GeneratorOpts opts) {
        return new Imports(opts, false)
                .add(JAVA_UTIL_OBJECTS)
                .add(opts.isUseRegisterForReflection(), "io.quarkus.runtime.annotations.RegisterForReflection")
                .jackson(opts.isUseJsonSerializeOptions(), JSON_SERIALIZE)
                .jackson(JSON_PROPERTY, JSON_PROPERTY_ORDER)
                .jsonb("javax.json.bind.annotation.JsonbProperty", "javax.json.bind.annotation.JsonbPropertyOrder");
    }

    /**
     * Creates a new instance for enumeration types.
     *
     * @param opts the generator options
     * @return a new imports instance loaded with enumeration imports
     */
    public static Imports newEnum(GeneratorOpts opts) {
        return new Imports(opts, false)
                   .addEnumImports(true);
    }

    /**
     * Adds imports needed for interface templates.
     *
     * @param opts the generator options
     * @return a new imports instance
     */
    public static Imports newInterface(GeneratorOpts opts) {
        return new Imports(opts, false)
                .add("org.eclipse.microprofile.openapi.annotations.media.Schema");
    }

    /**
     * Adds imports needed for extra templates.
     *
     * @param opts the generator options
     * @param tmpl the template to add imports for
     * @return a new imports instance
     */
    public static Imports newExtras(GeneratorOpts opts, ExtraTemplate tmpl) {
        var imports = new Imports(opts, false);

        if (tmpl == ExtraTemplate.LOCAL_DATE_JACKSON_DESERIALIZER) {
            imports
            .add(IOEXCEPTION, LOCAL_DATE, DATE_TIME_FORMATTER)
            .jackson(JSON_PARSER, DESERIALIZATION_CONTEXT, JSON_DESERIALIZER);
        }
        if (tmpl == ExtraTemplate.LOCAL_DATE_JACKSON_SERIALIZER) {
            imports
            .add(IOEXCEPTION, LOCAL_DATE, DATE_TIME_FORMATTER)
            .jackson(JSON_GENERATOR, SERIALIZER_PROVIDER, JSON_SERIALIZER, JSON_PROCESSING_EXCEPTION);
        }
        if (tmpl == ExtraTemplate.LOCAL_DATE_TIME_JACKSON_DESERIALIZER) {
            imports
            .add(IOEXCEPTION, LOCAL_DATE_TIME)
            .add(DATE_TIME_FORMATTER)
            .jackson(JSON_PARSER, DESERIALIZATION_CONTEXT, JSON_DESERIALIZER, JSON_PROCESSING_EXCEPTION);
        }
        if (tmpl == ExtraTemplate.LOCAL_DATE_TIME_JACKSON_SERIALIZER) {
            imports
            .add(IOEXCEPTION, LOCAL_DATE_TIME, DATE_TIME_FORMATTER)
            .jackson(JSON_GENERATOR, SERIALIZER_PROVIDER, JSON_SERIALIZER, JSON_PROCESSING_EXCEPTION);
        }
        if (tmpl == ExtraTemplate.OFFSET_DATE_TIME_JACKSON_DESERIALIZER) {
            imports
            .add(IOEXCEPTION, LOCAL_DATE_TIME, OFFSET_DATE_TIME)
            .add(DATE_TIME_FORMATTER, DATE_TIME_PARSE_EXCEPTION, ZONE_ID)
            .jackson(JSON_PARSER, DESERIALIZATION_CONTEXT, JSON_DESERIALIZER, JSON_PROCESSING_EXCEPTION);
        }
        if (tmpl == ExtraTemplate.OFFSET_DATE_TIME_JACKSON_SERIALIZER) {
            imports
            .add(IOEXCEPTION, OFFSET_DATE_TIME, DATE_TIME_FORMATTER)
            .jackson(JSON_GENERATOR, SERIALIZER_PROVIDER, JSON_SERIALIZER, JSON_PROCESSING_EXCEPTION);
        }
        return imports;
    }

    /**
     * Adds imports needed for rendering an enumeration.
     *
     * @param includeTypeAdapter flag to include typeAdaptor
     * @return this
     */
    public Imports addEnumImports(boolean includeTypeAdapter) {
        return add(opts.isJackson(), JAVA_UTIL_OBJECTS)
            .jackson(opts.isUseJsonSerializeOptions(), JSON_SERIALIZE)
            .jackson(JSON_CREATOR, JSON_VALUE)
            .jsonb("javax.json.Json", "javax.json.JsonString", "javax.json.bind.adapter.JsonbAdapter")
            .jsonb(includeTypeAdapter, "javax.json.bind.annotation.JsonbTypeAdapter");
    }

    /**
     * Add imports for the types referenced by properties.
     *
     * @param properties the properties to add imports for
     */
    public void addPropertyImports(Collection<Property> properties) {
        properties
            .forEach(p -> add(p.reference()));
    }

    /**
     * Adds imports for javax-class.
     *
     * If jakarta-option is selected, will replace "javax" with "jakarta".
     *
     * @param name the class to add import for
     * @return the imports instance
     */
    public Imports javax(String name) {
        if (opts.isJakarta()) {
            name = name.replace("javax", "jakarta");
        }
        importedClasses.add(name);
        return this;
    }

    /**
     * Adds optional imports if Jackson is the selected serializer.
     *
     * @param enable option to control if the classes should be added
     * @param classes the classes to add imports for
     * @return the imports instance
     */
    public Imports jackson(boolean enable, String... classes) {
        if (enable) {
            jackson(classes);
        }
        return this;
    }

    /**
     * Adds imports if the Jackson is the selected serializer.
     *
     * @param classes the classes to add imports for
     * @return the imports instance
     */
    public Imports jackson(String... classes) {
        if (!opts.isJackson()) {
            return this;
        }

        boolean isCodehaus = opts.isJacksonCodehaus();
        for (String c : classes) {
            String mapped;
            if (isCodehaus) {
                mapped = JACKSON_CODEHAUS.get(c);
            } else {
                mapped = JACKSON_FASTERXML.get(c);
            }
            if (mapped == null) {
                throw new IllegalStateException("No jackson import mapping for " + c);
            }
            add(mapped);
        }
        return this;
    }

    /**
     * Adds optional imports if Jsonb is the selected serializer.
     *
     * @param enable option to control if the classes should be added
     * @param classes the classes to add imports for
     * @return the imports instance
     */
    public Imports jsonb(boolean enable, String... classes) {
        if (enable && opts.isJsonb()) {
            add(classes);
        }
        return this;
    }

    /**
     * Adds imports if Jsonb is the selected serializer.
     *
     * @param classes the classes to add imports for
     * @return the imports instance
     */
    public Imports jsonb(String... classes) {
        if (opts.isJsonb()) {
            add(classes);
        }
        return this;
    }

    /**
     * Adds imports for a reference.
     *
     * If the reference is externally mapped, just adds an import of the class.
     *
     * Otherwise adds imports for dependency and container-wrapper classes as well.
     *
     * @param ref the reference to add imports for
     * @return the imports instance
     */
    public Imports add(Reference ref) {
        String typeName = ref.typeName().name();
        String mappedToExternalType = externalTypeMapping.get(typeName);
        if (mappedToExternalType != null) {
            logger.info("mapping type {} to {}", typeName, mappedToExternalType);
            add(mappedToExternalType);
            return this;
        }

        Type type = ref.refType();
        importedClasses.addAll(type.neededImports());
        addDtoImport(type);
        if (type instanceof TypeContainer tc) {
            addDtoImport(tc.innerType());
        }

        return this;
    }

    /**
     * Adds import for Schema.
     *
     * @return the imports instance
     */
    public Imports addSchema() {
        return add("org.eclipse.microprofile.openapi.annotations.media.Schema");
    }

    private void addDtoImport(Type type) {
        if (includeDtoImports && type.isDto()) {
            String name = type.typeName().name();
            importedClasses.add(opts.dtoPackage() + "." + name);
        }
    }

    /**
     * Adds imports for the specified (fully qualified) class names.
     *
     * @param classes the classes to add imports for
     * @return the imports instance
     */
    public Imports add(String... classes) {
        importedClasses.addAll(Arrays.asList(classes));
        return this;
    }

    /**
     * Adds optional imports for the specified (fully qualified) class names.
     *
     * @param include option to control if the classes should be added
     * @param classes the classes to add imports for
     * @return the imports instance
     */
    public Imports add(boolean include, String... classes) {
        if (include) {
            add(classes);
        }
        return this;
    }

    /**
     * Remove container implemenetations (e.g. ArrayList) from
     * imports for use in Api files.
     * Maybe need a better way to handle this.
     */
    public void trimContainerImplementations() {
        importedClasses.removeAll(CONTAINER_IMPLEMENTATION_TYPES);
    }
}
