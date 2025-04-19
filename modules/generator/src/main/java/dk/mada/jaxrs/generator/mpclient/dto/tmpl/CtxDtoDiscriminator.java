package dk.mada.jaxrs.generator.mpclient.dto.tmpl;

import java.util.List;
import java.util.Map;
import org.jspecify.annotations.Nullable;

/**
 * Custom extensions. In separate (mada.) context so they are easier to spot in the templates.
 * @param propertyBaseName the name of the property with the selector string
 * @param mappedModels the list of mapped models
 */
public record CtxDtoDiscriminator(String propertyBaseName, List<ModelMapping> mappedModels) {

    /**
     * Defines a mapping between a model (DTO) name and a name used in the serialization stream.
     *
     * @param modelName        the name of the model
     * @param mappingName      the way it is referred to in the stream
     * @param vendorExtensions map of vendor extensions
     */
    public record ModelMapping(String modelName, String mappingName, @Nullable Map<String, String> vendorExtensions) {}
}
