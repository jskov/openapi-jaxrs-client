package dk.mada.jaxrs.openapi;

import org.jspecify.annotations.Nullable;

import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.BinarySchema;
import io.swagger.v3.oas.models.media.ComposedSchema;
import io.swagger.v3.oas.models.media.DateSchema;
import io.swagger.v3.oas.models.media.DateTimeSchema;
import io.swagger.v3.oas.models.media.FileSchema;
import io.swagger.v3.oas.models.media.MapSchema;
import io.swagger.v3.oas.models.media.NumberSchema;
import io.swagger.v3.oas.models.media.ObjectSchema;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;

/**
 * OpenApi V3.0.x parser details.
 *
 * https://spec.openapis.org/oas/v3.0.4.html (or newer from https://spec.openapis.org/)
 */
public final class SchemaParserV30 implements SchemaParser {
    /** The schema being parsed. */
    private final Schema<?> schema;

    /**
     * Creates new parser instance.
     *
     * @param schema the schema to parse
     */
    public SchemaParserV30(Schema<?> schema) {
        this.schema = schema;
    }

    @Override
    public Schema<?> schema() {
        return schema;
    }

    @Override
    public @Nullable String type() {
        String schemaType = schema.getType();
        if (schemaType == null) {
            schemaType = schema.get$ref();
        }
        return schemaType;
    }

    @Override
    public @Nullable String format() {
        return schema.getFormat();
    }

    @Override
    public boolean isArray() {
        return schema instanceof ArraySchema;
    }

    @Override
    public boolean isAnyOf() {
        return schema instanceof ComposedSchema
                && schema().getAnyOf() != null;
    }

    @Override
    public boolean isOneOf() {
        return schema instanceof ComposedSchema
                && schema().getOneOf() != null;
    }

    @Override
    public boolean isBinary() {
        return schema instanceof BinarySchema || schema instanceof FileSchema;
    }

    @Override
    public boolean isDate(boolean acceptBrokenType) {
        return "date".equals(format())
                && (acceptBrokenType || schema() instanceof DateSchema);
    }

    @Override
    public boolean isDateTime(boolean acceptBrokenType) {
        return "date-time".equals(format())
                && (acceptBrokenType || schema() instanceof DateTimeSchema);
    }

    @Override
    public boolean isMap() {
        return schema instanceof MapSchema;
    }

    @Override
    public boolean isNullable() {
        Boolean nullable = schema.getNullable();
        return nullable != null && nullable.booleanValue();
    }

    @Override
    public boolean isNumber() {
        return schema instanceof NumberSchema;
    }

    @Override
    public boolean isObject() {
        return schema instanceof ObjectSchema;
    }

    @Override
    public boolean isString() {
        return schema instanceof StringSchema;
    }
}
