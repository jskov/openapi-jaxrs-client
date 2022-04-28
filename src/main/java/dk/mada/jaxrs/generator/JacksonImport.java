package dk.mada.jaxrs.generator;

/**
 * Jackson imports and their paths for CodeHaus and FasterXml.
 */
public enum JacksonImport {
    /** DeserializationContext. */
    DESERIALIZATION_CONTEXT(
        "org.codehaus.jackson.map.DeserializationContext",
        "com.fasterxml.jackson.databind.DeserializationContext"),
    /** JsonCreator. */
    JSON_CREATOR(
        "org.codehaus.jackson.annotate.JsonCreator",
        "com.fasterxml.jackson.annotation.JsonCreator"),
    /** JsonDeserialize. */
    JSON_DESERIALIZE(
        "org.codehaus.jackson.map.annotate.JsonDeserialize",
        "com.fasterxml.jackson.databind.annotation.JsonDeserialize"),
    /** JsonDeserializer. */
    JSON_DESERIALIZER(
        "org.codehaus.jackson.map.JsonDeserializer",
        "com.fasterxml.jackson.databind.JsonDeserializer"),
    /** JsonGenerator. */
    JSON_GENERATOR(
        "org.codehaus.jackson.JsonGenerator",
        "com.fasterxml.jackson.core.JsonGenerator"),
    /** JsonIgnore. */
    JSON_IGNORE(
        "org.codehaus.jackson.annotate.JsonIgnore",
        "com.fasterxml.jackson.annotation.JsonIgnore"),
    /** JsonParser. */
    JSON_PARSER(
        "org.codehaus.jackson.JsonParser",
        "com.fasterxml.jackson.core.JsonParser"),
    /** JsonProcessingException. */
    JSON_PROCESSING_EXCEPTION(
        "org.codehaus.jackson.JsonProcessingException",
        "com.fasterxml.jackson.core.JsonProcessingException"),
    /** JsonProperty. */
    JSON_PROPERTY(
        "org.codehaus.jackson.annotate.JsonProperty",
        "com.fasterxml.jackson.annotation.JsonProperty"),
    /** JsonPropertyOrder. */
    JSON_PROPERTY_ORDER(
        "org.codehaus.jackson.annotate.JsonPropertyOrder",
        "com.fasterxml.jackson.annotation.JsonPropertyOrder"),
    /** JsonSerialize. */
    JSON_SERIALIZE(
        "org.codehaus.jackson.map.annotate.JsonSerialize",
        "com.fasterxml.jackson.databind.annotation.JsonSerialize"),
    /** JsonSerializer. */
    JSON_SERIALIZER(
        "org.codehaus.jackson.map.JsonSerializer",
        "com.fasterxml.jackson.databind.JsonSerializer"),
    /** JsonValue. */
    JSON_VALUE(
        "org.codehaus.jackson.annotate.JsonValue",
        "com.fasterxml.jackson.annotation.JsonValue"),
    /** SerializerProvider. */
    SERIALIZER_PROVIDER(
        "org.codehaus.jackson.map.SerializerProvider",
        "com.fasterxml.jackson.databind.SerializerProvider");

    /** The CodeHaus import path. */
    private final String codeHausImport;
    /** The FasterXml import path. */
    private final String fasterXmlImport;

    JacksonImport(String codehausImport, String fasterxmlImport) {
        this.codeHausImport = codehausImport;
        this.fasterXmlImport = fasterxmlImport;
    }

    /**
     * {@return the import path suitable for the active jackson implementation}
     * @param opts the generator options.
     */
    public String importPath(GeneratorOpts opts) {
        return opts.isJacksonCodehaus() ? codeHausImport : fasterXmlImport;
    }
}
