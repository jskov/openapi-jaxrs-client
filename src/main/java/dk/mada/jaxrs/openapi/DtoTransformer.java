package dk.mada.jaxrs.openapi;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Schema;

/**
 * Transforms OpenApi dtos (models) to local model objects.
 *
 *  DefaultGenerator:processModels
 *  DefaultCodegen:fromModel
 *  DefaultCodegen:fromProperty
 */
public class DtoTransformer {
    private static final Logger logger = LoggerFactory.getLogger(DtoTransformer.class);

    /** Type converter. */
    private final TypeConverter typeConverter;

    /**
     * Constructs new DTO transformer.
     *
     * @param typeConverter the type converter instance
     */
    public DtoTransformer(TypeConverter typeConverter) {
        this.typeConverter = typeConverter;
    }

    /**
     * Transforms OpenApi specification to types model.
     *
     * The types are added to the Types instance as the specification
     * is processed.
     *
     * @param specification the OpenApi specification
     */
    public void transform(OpenAPI specification) {
        readSpec(specification);
    }

    private void readSpec(OpenAPI specification) {
        @SuppressWarnings("rawtypes")
        Map<String, Schema> allDefinitions = OpenapiGeneratorUtils.getSchemas(specification);
        logger.debug("See schemas: {}", allDefinitions.keySet());

        allDefinitions.forEach(typeConverter::createDto);
    }
}
