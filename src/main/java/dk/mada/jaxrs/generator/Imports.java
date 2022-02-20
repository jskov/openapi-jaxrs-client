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
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeArray;
import dk.mada.jaxrs.model.types.Types;

/**
 * Keeps track of imports for a single template, taking
 * generator options into consideration.
 */
public final class Imports {
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
    @SuppressWarnings("unused")
    private static final Logger logger = LoggerFactory.getLogger(Imports.class);
    private static final String JAVA_UTIL_OBJECTS = "java.util.Objects";
    public static final Set<String> LIST_TYPES = Set.of("java.util.List", "java.util.ArrayList");
    public static final Set<String> MAP_TYPES = Set.of("java.util.Map", "java.util.HashMap");
    public static final Set<String> SET_TYPES = Set.of("java.util.Set", "java.util.LinkedHashSet");
    private static final Set<String> CONTAINER_IMPLEMENTATION_TYPES = Set.of(
            "java.util.ArrayList",
            "java.util.HashMap",
            "java.util.LinkedHashSet");

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

    private final GeneratorOpts opts;
    @SuppressWarnings("unused")
    private final Types types;
    private final SortedSet<String> importedClasses = new TreeSet<>();
    private final boolean includeDtoImports;

    private Imports(Types types, GeneratorOpts opts, boolean includeDtoImports) {
        this.types = types;
        this.opts = opts;
        this.includeDtoImports = includeDtoImports;
    }

    public SortedSet<String> get() {
        return importedClasses;
    }

    public static Imports newApi(Types types, GeneratorOpts opts) {
        return new Imports(types, opts, true)
                .javax("javax.ws.rs.*");
    }

    public static Imports newPojo(Types types, GeneratorOpts opts) {
        return new Imports(types, opts, false)
                .add(JAVA_UTIL_OBJECTS)
                .jackson(opts.isUseJsonSerializeOptions(), JSON_SERIALIZE)
                .jackson(JSON_PROPERTY, JSON_PROPERTY_ORDER)
                .jsonb("javax.json.bind.annotation.JsonbProperty", "javax.json.bind.annotation.JsonbPropertyOrder");
    }

    /**
     * Creates a new instance for enumeration types.
     *
     * @param types the types instance
     * @param opts the generator options
     * @return a new imports instance loaded with enumeration imports
     */
    public static Imports newEnum(Types types, GeneratorOpts opts) {
        return new Imports(types, opts, false)
                   .addEnumImports();
    }

    /**
     * Adds imports needed for extra templates.
     *
     * @param types the types model
     * @param opts the generator options
     * @param tmpl the template to add imports for
     * @return a new imports instance
     */
    public static Imports newExtras(Types types, GeneratorOpts opts, ExtraTemplate tmpl) {
        var imports = new Imports(types, opts, false);

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
     * @return this
     */
    public Imports addEnumImports() {
        return this.add(opts.isJackson(), JAVA_UTIL_OBJECTS)
            .jackson(opts.isUseJsonSerializeOptions(), JSON_SERIALIZE)
            .jackson(JSON_CREATOR, JSON_VALUE)
            .jsonb("javax.json.Json", "javax.json.JsonString", "javax.json.bind.adapter.JsonbAdapter")
            .jsonb("javax.json.bind.annotation.JsonbTypeAdapter");
    }

    public void addPropertyImports(Collection<Property> properties) {
        properties
        .forEach(p -> add(p.type()));
    }

    public Imports javax(String name) {
        if (opts.isJakarta()) {
            name = name.replace("javax", "jakarta");
        }
        importedClasses.add(name);
        return this;
    }

    public Imports jackson(boolean enable, String... classes) {
        if (enable) {
            jackson(classes);
        }
        return this;
    }

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

    public Imports jsonb(boolean enable, String... classes) {
        if (enable && opts.isJsonb()) {
            add(classes);
        }
        return this;
    }

    public Imports jsonb(String... classes) {
        if (opts.isJsonb()) {
            add(classes);
        }
        return this;
    }

    public Imports addAll(Collection<Type> addTypes) {
        addTypes.forEach(this::add);
        return this;
    }

    public Imports add(Type type) {
        importedClasses.addAll(type.neededImports());

        addDtoImport(type);
        if (type instanceof TypeArray ta) {
            addDtoImport(ta.mappedInnerType());
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

    public Imports add(String... classes) {
        importedClasses.addAll(Arrays.asList(classes));
        return this;
    }

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
