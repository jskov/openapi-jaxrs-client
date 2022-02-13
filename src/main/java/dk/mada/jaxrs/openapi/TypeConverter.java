package dk.mada.jaxrs.openapi;

import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.model.types.Primitive;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeArray;
import dk.mada.jaxrs.model.types.TypeBigDecimal;
import dk.mada.jaxrs.model.types.TypeByteArray;
import dk.mada.jaxrs.model.types.TypeDate;
import dk.mada.jaxrs.model.types.TypeDateTime;
import dk.mada.jaxrs.model.types.TypeEnum;
import dk.mada.jaxrs.model.types.TypeLocalTime;
import dk.mada.jaxrs.model.types.TypeMap;
import dk.mada.jaxrs.model.types.TypeNames;
import dk.mada.jaxrs.model.types.TypeNames.TypeName;
import dk.mada.jaxrs.model.types.TypeObject;
import dk.mada.jaxrs.model.types.TypeSet;
import dk.mada.jaxrs.model.types.Types;
import dk.mada.jaxrs.naming.Naming;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.BinarySchema;
import io.swagger.v3.oas.models.media.DateSchema;
import io.swagger.v3.oas.models.media.DateTimeSchema;
import io.swagger.v3.oas.models.media.FileSchema;
import io.swagger.v3.oas.models.media.MapSchema;
import io.swagger.v3.oas.models.media.NumberSchema;
import io.swagger.v3.oas.models.media.ObjectSchema;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.StringSchema;

/**
 * Converts a specification schema to an internal model type.
 */
public class TypeConverter {
    private static final Logger logger = LoggerFactory.getLogger(TypeConverter.class);
    /** Component schema prefix. */
    private static final String REF_COMPONENTS_SCHEMAS = "#/components/schemas/";

    /** Types. */
    private final Types types;
    /** Naming. */
    private final Naming naming;
    /** Parser options. */
    private final ParserOpts parserOpts;
    /** Generator options. */
    private final GeneratorOpts generatorOpts;

    /**
     * Constructs a new type converter.
     *
     * This operated by looking up types, creating if missing, in the
     * types instance.
     *
     * @param types the types instance
     * @param naming the naming instance
     * @param parserOpts the parser options
     * @param generatorOpts the generator options
     */
    public TypeConverter(Types types, Naming naming, ParserOpts parserOpts, GeneratorOpts generatorOpts) {
        this.types = types;
        this.naming = naming;
        this.parserOpts = parserOpts;
        this.generatorOpts = generatorOpts;
    }

    /**
     * Converts a OpenApi schema to an internal model type.
     *
     * @param schema the OpenApi schema to convert
     * @return the found/created internal model type
     */
    public Type toType(Schema<?> schema) {
        return toType(schema, null);
    }

    public Type toType(Schema<?> schema, String propertyName) {
        String schemaType = schema.getType();
        String schemaFormat = schema.getFormat();

        logger.debug("type/format: {}/{} {}", schemaType, schemaFormat, schema.getClass());
        logger.debug("ref {}", schema.get$ref());

        Type type = Primitive.find(schemaType, schemaFormat);

        if (schema.getEnum() != null) {
            if (propertyName == null || type == null) {
                logger.warn("Found enumaration type but no property name provided");
            } else {
                String enumTypeName = naming.convertPropertyEnumTypeName(propertyName);
                TypeName typeName = TypeNames.of(enumTypeName);

                List<String> enumValues = schema.getEnum().stream()
                        .map(Objects::toString)
                        .toList();
                logger.info(" ENUM: {} {} {}", typeName, type, enumValues);
                return TypeEnum.of(typeName, type, enumValues);
            }
        }

        if (type != null) {
            return type;
        }

        type = findDto(schema.get$ref());

        if (type != null) {
            return type;
        }

        if (schema instanceof ArraySchema a) {
            Type innerType = toType(a.getItems());

            Boolean isUnique = a.getUniqueItems();
            if (isUnique != null && isUnique.booleanValue()) {
                return TypeSet.of(innerType);
            }

            if (innerType instanceof TypeByteArray && parserOpts.isUnwrapByteArrayList()) {
                return TypeByteArray.getArray();
            }

            return TypeArray.of(types, innerType);
        }

        if (schema instanceof BinarySchema || schema instanceof FileSchema) {
            return TypeByteArray.getArray();
        }

        if (schema instanceof MapSchema m) {
            Object additionalProperties = m.getAdditionalProperties();
            if (additionalProperties instanceof Schema<?> innerSchema) {
                Type innerType = toType(innerSchema);
                return TypeMap.of(innerType);
            }
        }

        if (schema instanceof NumberSchema) {
            return TypeBigDecimal.get();
        }

        if (schema instanceof DateTimeSchema) {
            return TypeDateTime.get(generatorOpts);
        }

        if (schema instanceof DateSchema) {
            logger.debug(" {} : TypeDate", schema.getName());
            return TypeDate.get();
        }

        if (schema instanceof ObjectSchema) {
            return TypeObject.get();
        }

        if (schema instanceof StringSchema) {
            if (TypeLocalTime.OPENAPI_CUSTOM_FORMAT.equals(schemaFormat)) {
                return TypeLocalTime.get();
            }

            return Primitive.STRING;
        }

        throw new IllegalStateException("No type found for " + schema);
    }

    private Type findDto(String ref) {
        if (ref != null && ref.startsWith(REF_COMPONENTS_SCHEMAS)) {
            String openapiId = ref.substring(REF_COMPONENTS_SCHEMAS.length());
            return types.findDto(openapiId);
        }
        return null;
    }
}
