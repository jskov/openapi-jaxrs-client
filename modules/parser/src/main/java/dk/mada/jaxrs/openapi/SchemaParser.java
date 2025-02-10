package dk.mada.jaxrs.openapi;

import java.util.List;
import java.util.Objects;

import org.jspecify.annotations.Nullable;

import dk.mada.jaxrs.model.types.TypeLocalTime;
import io.swagger.v3.oas.models.SpecVersion;
import io.swagger.v3.oas.models.media.Schema;

/**
 * OpenApi Schema parser.
 *
 * Specifications are available at https://spec.openapis.org/
 */
public interface SchemaParser {
    /** {@return the OpenApi schema this parser operates on} */
    Schema<?> schema(); // NOSONAR

    /** {@return the schema name, or null} */
    default @Nullable String name() {
        return schema().getName();
    }

    /** {@return the schema type, or null} */
    @Nullable String type();

    /** {@return the schema format, or null} */
    @Nullable String format();

    /** {@return the schema for the contained items} */
    default Schema<?> itemsSchema() { // NOSONAR
        return Objects.requireNonNull(schema().getItems(), "No type for nested items- guard by isArray");
    }

    /** {@return true if the schema defines a composition by anyOf} */
    boolean isAnyOf();

    /** {@return the anyOf schemas} */
    @SuppressWarnings("rawtypes")
    default List<Schema> anyOfSchemas() {
        return Objects.requireNonNull(schema().getAnyOf(), "No anyOf schemas - guard by isAnyOf");
    }

    /** {@return true if the schema defines a composition by oneOf} */
    boolean isOneOf();

    /** {@return the oneOf schemas} */
    @SuppressWarnings("rawtypes")
    default List<Schema> oneOfSchemas() {
        return Objects.requireNonNull(schema().getOneOf(), "No oneOf schemas - guard by isOneOf");
    }

    /** {@return true if the schema defines an array} */
    boolean isArray();

    /**
     * {@return true if the schema defines a date}
     *
     * @param acceptBrokenType if true, allows null/date to be recognized as a date
     */
    boolean isDate(boolean acceptBrokenType);

    /**
     * {@return if the schema defines a date-time}
     *
     * @param acceptBrokenType if true, allows null/date-time to be recognized as a date-time
     */
    boolean isDateTime(boolean acceptBrokenType);

    /** {@return true if the schema defines a map} */
    boolean isMap();

    /** {@return the schema defining the inner type of a map} */
    @SuppressWarnings("rawtypes")
    default Schema<?> mapInnerSchema() {
        return (Schema<?>) schema().getAdditionalProperties();
    }

    /** {@return true if the type is nullable} */
    boolean isNullable();

    /** {@return true if the schema defines a number} */
    boolean isNumber();

    /** {@return true if the schema defines an object} */
    boolean isObject();

    /** {@return true if the schema contains a reference to another type} */
    default boolean isRef() {
        return schema().get$ref() != null;
    }

    /** {@return true if the schema defines a string} */
    boolean isString();

    /** {@return true if this schema defines (just) time} */
    default boolean isTime() {
        return isString()
                && (TypeLocalTime.CUSTOM_TIME_FORMAT_QUARKUS.equals(format())
                        || TypeLocalTime.TIME_FORMAT_OPENAPI.equals(format()));
    }

    /** {@return true if the schema defines unique items (is a set)} */
    default boolean isUnique() {
        Boolean isUnique = schema().getUniqueItems();
        return isUnique != null && isUnique.booleanValue();
    }

    /**
     * {@return true if this schema represents a combination of types}
     *
     * TODO: probably close to new array of types? TODO: rename, something like isCombinedType
     */
    default boolean isAllOf() {
        return schema().getAllOf() != null;
    }

    /** {@return true if the schema is a binary stream of data} */
    boolean isBinary();

    /** {@return true if this schema defines an enumeration} */
    default boolean isEnumeration() {
        return schema().getEnum() != null;
    }

    /** {@return enumeration values} */
    default List<String> enumerationValues() {
        return Objects.requireNonNull(schema().getEnum(), "must guard call with isEnumeration()").stream()
                .map(Objects::toString)
                .toList();
    }

    /**
     * {@return a parser suitable for the given schema}
     *
     * Uses the schema's specification version to determine the parser implementation to use.
     *
     * @param schema the schema to provide a parser for
     */
    static SchemaParser of(Schema<?> schema) {
        SpecVersion specVersion = schema.getSpecVersion();
        return switch (specVersion) {
        case SpecVersion.V30 -> new SchemaParserV30(schema);
        case SpecVersion.V31 -> new SchemaParserV31(schema);
        default -> throw new IllegalStateException("Unhandled spec version " + specVersion);
        };
    }
}
