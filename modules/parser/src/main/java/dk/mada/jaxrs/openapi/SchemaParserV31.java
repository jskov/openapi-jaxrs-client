package dk.mada.jaxrs.openapi;

import java.util.Set;

import org.jspecify.annotations.Nullable;

import io.swagger.v3.oas.models.media.Schema;

/**
 * OpenApi V3.1.x parser details.
 *
 * https://spec.openapis.org/oas/v3.1.1.html (or newer from https://spec.openapis.org/)
 */
public final class SchemaParserV31 implements SchemaParser {
    /** The schema being parsed. */
    private final Schema<?> schema;
    /** The schema type. */
    private final @Nullable String type;
    /** Flag for type's ability be null. */
    private final boolean nullable;

    /**
     * Creates new parser instance.
     *
     * @param schema the schema to parse
     */
    public SchemaParserV31(Schema<?> schema) {
        this.schema = schema;

        // Instead of a flag for nullable, the V3.1 specification
        // encodes this as an extra type element (e.g. non-nullable: [string], nullable: [string, null])
        String schemaType;
        Set<String> schemaTypes = schema.getTypes();

        if (schemaTypes == null) {
            // This is legacy behavior in mada parser/resolver. Probably not super...
            schemaType = schema.get$ref();
            nullable = false;
        } else if (schemaTypes.size() == 1) {
            schemaType = schemaTypes.iterator().next();
            nullable = false;
        } else if (schemaTypes.size() == 2 && schemaTypes.contains("null")) {
            schemaType = schemaTypes.stream()
                    .filter(s -> !"null".equals(s))
                    .findFirst()
                    .orElseThrow(() -> new IllegalStateException("No non-null type?! " + schemaTypes));
            nullable = true;
        } else {
            // see https://github.com/swagger-api/swagger-core/wiki/Swagger-2.X---OpenAPI-3.1
            throw new IllegalStateException("The mada parser does not yet handle the array data types in " + schema);
        }
        type = schemaType;
    }

    @Override
    public Schema<?> schema() {
        return schema;
    }

    @Override
    public @Nullable String type() {
        return type;
    }

    @Override
    public @Nullable String format() {
        return schema.getFormat();
    }

    @Override
    public boolean isArray() {
        return schema().getItems() != null && isTypeArray();
    }

    // Note that there are two types:
    // <ul>
    // <li> /api/interfaces/super (object/anyOf)
    // <li> /api/interfaces/list (array/anyOf)
    @Override
    public boolean isAnyOf() {
        var anyOf = schema().getAnyOf();
        return (anyOf != null && !anyOf.isEmpty() && (isTypeArray() || isObject()));
    }

    @Override
    public boolean isOneOf() {
        var oneOf = schema().getOneOf();
        return (oneOf != null && !oneOf.isEmpty() && isObject());
    }

    @Override
    public boolean isBinary() {
        return "binary".equals(format()) && isString();
    }

    @Override
    public boolean isDate(boolean acceptBrokenType) {
        return "date".equals(format())
                && (acceptBrokenType || isString());
    }

    @Override
    public boolean isDateTime(boolean acceptBrokenType) {
        return "date-time".equals(format())
                && (acceptBrokenType || isString());
    }

    @Override
    public boolean isMap() {
        return schema.getAdditionalProperties() instanceof Schema<?>
                && isObject();
    }

    @Override
    public boolean isNullable() {
        return nullable;
    }

    private boolean isTypeArray() {
        return typesContainsJust("array");
    }

    @Override
    public boolean isNumber() {
        return typesContainsJust("number");
    }

    @Override
    public boolean isObject() {
        return typesContainsJust("object");
    }

    @Override
    public boolean isString() {
        return typesContainsJust("string");
    }

    private boolean typesContainsJust(String typeName) {
        Set<String> types = schema.getTypes();
        return types != null && types.size() == 1 && types.contains(typeName);
    }
}
