package dk.mada.jaxrs.openapi;

import java.util.Collections;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Schema;

/**
 * Transforms OpenApi dtos (models) to local model objects.
 *
 * DefaultGenerator:processModels DefaultCodegen:fromModel DefaultCodegen:fromProperty
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
     * The types are added to the Types instance as the specification is processed.
     *
     * @param specification the OpenApi specification
     */
    public void transform(OpenAPI specification) {
        readSpec(specification);
    }

    private void readSpec(OpenAPI specification) {
        @SuppressWarnings("rawtypes")
        Map<String, Schema> allDefinitions = getSchemas(specification);
        logger.debug("See schemas: {}", allDefinitions.keySet());

        allDefinitions.entrySet().stream()
                .sorted((a, b) -> a.getKey().compareTo(b.getKey()))
                .forEach(e -> typeConverter.createDto(e.getKey(), e.getValue()));
    }

    /**
     * Get schemas.
     *
     * From ModelUtils.getSchemas
     *
     * @param openAPI the OpenAPI document
     * @return the schemas mapped by name
     */
    @SuppressWarnings("rawtypes")
    private static Map<String, Schema> getSchemas(OpenAPI openAPI) {
        if (openAPI != null && openAPI.getComponents() != null && openAPI.getComponents().getSchemas() != null) {
            return openAPI.getComponents().getSchemas();
        }
        return Collections.emptyMap();
    }
}
