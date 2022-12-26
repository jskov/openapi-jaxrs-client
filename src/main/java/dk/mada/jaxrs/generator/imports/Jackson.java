package dk.mada.jaxrs.generator.imports;

import java.util.Optional;

import dk.mada.jaxrs.generator.imports.Imports.ImportRenderPrefs;

/**
 * Jackson imports and their paths for CodeHaus and FasterXml.
 */
public enum Jackson implements TypedImport {
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
    /** JsonIgnoreProperties. */
    JSON_IGNORE_PROPERTIES(
        "org.codehaus.jackson.annotate.JsonIgnoreProperties",
        "com.fasterxml.jackson.annotation.JsonIgnoreProperties"),
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
    /** JsonSubTypes. */
    JSON_SUB_TYPES(
        "org.codehaus.jackson.annotate.JsonSubTypes",
        "com.fasterxml.jackson.annotation.JsonSubTypes"),
    /** JsonTypeInfo. */
    JSON_TYPE_INFO(
        "org.codehaus.jackson.annotate.JsonTypeInfo",
        "com.fasterxml.jackson.annotation.JsonTypeInfo"),
    /** JsonValue. */
    JSON_VALUE(
        "org.codehaus.jackson.annotate.JsonValue",
        "com.fasterxml.jackson.annotation.JsonValue"),
    /** SerializerProvider. */
    SERIALIZER_PROVIDER(
        "org.codehaus.jackson.map.SerializerProvider",
        "com.fasterxml.jackson.databind.SerializerProvider");

    /** The CodeHaus import path. */
    private final String codehausImport;
    /** The FasterXml import path. */
    private final String fasterXmlImport;

    Jackson(String codehausImport, String fasterXmlImport) {
        this.codehausImport = codehausImport;
        this.fasterXmlImport = fasterXmlImport;
    }

    /**
     * {@return the import path suitable for the active jackson implementation}
     * @param irp the import rendering preferences
     */
    @Override
    public Optional<String> path(ImportRenderPrefs irp) {
        if (!irp.isJackson()) {
            return Optional.empty();
        }
        return irp.isJacksonCodehaus() ? Optional.of(codehausImport) : Optional.of(fasterXmlImport);
    }
}
