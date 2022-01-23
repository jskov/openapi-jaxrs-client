package dk.mada.jaxrs.openapi;

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
import dk.mada.jaxrs.model.types.TypeLocalTime;
import dk.mada.jaxrs.model.types.TypeMap;
import dk.mada.jaxrs.model.types.TypeObject;
import dk.mada.jaxrs.model.types.TypeSet;
import dk.mada.jaxrs.model.types.Types;
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
	private static final String REF_COMPONENTS_SCHEMAS = "#/components/schemas/";
	private static final Logger logger = LoggerFactory.getLogger(TypeConverter.class);

	private final Types types;
	private final ParserOpts parserOpts;
	private final GeneratorOpts generatorOpts;

	public TypeConverter(Types types, ParserOpts parserOpts, GeneratorOpts generatorOpts) {
		this.types = types;
		this.parserOpts = parserOpts;
		this.generatorOpts = generatorOpts;
	}

	public Type toType(Schema<?> schema) {
		String schemaType = schema.getType();
		String schemaFormat = schema.getFormat();

		logger.debug("type/format: {}/{}", schemaType, schemaFormat);
		logger.debug("ref {}", schema.get$ref());
		
		Type type = Primitive.find(schemaType, schemaFormat);
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
		
		if (schema instanceof NumberSchema ns) {
			return TypeBigDecimal.get();
		}
		
		if (schema instanceof DateTimeSchema) {
			return TypeDateTime.get(generatorOpts);
		}

		if (schema instanceof DateSchema) {
			logger.debug(" {} : TypeDate", schema.getName());
			return TypeDate.get();
		}
		
		if (schema instanceof ObjectSchema o) {
			return TypeObject.get();
		}
		
		if (schema instanceof StringSchema s) {
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
