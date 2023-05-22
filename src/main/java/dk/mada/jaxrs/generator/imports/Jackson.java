package dk.mada.jaxrs.generator.imports;

import java.util.Optional;

import dk.mada.jaxrs.generator.imports.Imports.ImportRenderPrefs;

/**
 * Jackson imports and their paths for CodeHaus and FasterXml.
 */
public enum Jackson implements TypedImport {
    /** DeserializationContext. */
    DESERIALIZATION_CONTEXT(
            "com.fasterxml.jackson.databind.DeserializationContext"),
    /** JsonCreator. */
    JSON_CREATOR(
            "com.fasterxml.jackson.annotation.JsonCreator"),
    /** JsonDeserialize. */
    JSON_DESERIALIZE(
            "com.fasterxml.jackson.databind.annotation.JsonDeserialize"),
    /** JsonDeserializer. */
    JSON_DESERIALIZER(
            "com.fasterxml.jackson.databind.JsonDeserializer"),
    /** JsonGenerator. */
    JSON_GENERATOR(
            "com.fasterxml.jackson.core.JsonGenerator"),
    /** JsonIgnore. */
    JSON_IGNORE(
            "com.fasterxml.jackson.annotation.JsonIgnore"),
    /** JsonIgnoreProperties. */
    JSON_IGNORE_PROPERTIES(
            "com.fasterxml.jackson.annotation.JsonIgnoreProperties"),
    /** JsonParser. */
    JSON_PARSER(
            "com.fasterxml.jackson.core.JsonParser"),
    /** JsonProcessingException. */
    JSON_PROCESSING_EXCEPTION(
            "com.fasterxml.jackson.core.JsonProcessingException"),
    /** JsonProperty. */
    JSON_PROPERTY(
            "com.fasterxml.jackson.annotation.JsonProperty"),
    /** JsonPropertyOrder. */
    JSON_PROPERTY_ORDER(
            "com.fasterxml.jackson.annotation.JsonPropertyOrder"),
    /** JsonSerialize. */
    JSON_SERIALIZE(
            "com.fasterxml.jackson.databind.annotation.JsonSerialize"),
    /** JsonSerializer. */
    JSON_SERIALIZER(
            "com.fasterxml.jackson.databind.JsonSerializer"),
    /** JsonSubTypes. */
    JSON_SUB_TYPES(
            "com.fasterxml.jackson.annotation.JsonSubTypes"),
    /** JsonTypeInfo. */
    JSON_TYPE_INFO(
            "com.fasterxml.jackson.annotation.JsonTypeInfo"),
    /** JsonValue. */
    JSON_VALUE(
            "com.fasterxml.jackson.annotation.JsonValue"),
    /** SerializerProvider. */
    SERIALIZER_PROVIDER(
            "com.fasterxml.jackson.databind.SerializerProvider");

    /** The FasterXml import path. */
    private final String fasterXmlImport;

    Jackson(String fasterXmlImport) {
        this.fasterXmlImport = fasterXmlImport;
    }

    /**
     * {@return the import path suitable for the active jackson implementation}
     *
     * @param irp the import rendering preferences
     */
    @Override
    public Optional<String> path(ImportRenderPrefs irp) {
        if (!irp.isJackson()) {
            return Optional.empty();
        }
        return Optional.of(fasterXmlImport);
    }
}
