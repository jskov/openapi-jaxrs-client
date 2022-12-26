package dk.mada.jaxrs.generator.dto.tmpl;

import java.util.List;
import java.util.Map;

import org.immutables.value.Value.Immutable;
import org.jspecify.annotations.Nullable;

/**
 * Custom extensions. In separate (mada.) context so they are
 * easier to spot in the templates.
 */
@Immutable
public interface CtxDtoDiscriminator {
    /** {@return a builder for this type} */
    static ImmutableCtxDtoDiscriminator.Builder builder() {
        return ImmutableCtxDtoDiscriminator.builder();
    }

    /** {@return the name of the property with the selector string} */
    String propertyBaseName();

    /**
     * Defines a mapping between a model (DTO) name and a name
     * used in the serialization stream.
     *
     * @param modelName the name of the model
     * @param mappingName the way it is referred to in the stream
     * @param vendorExtensions map of vendor extensions
     */
    record ModelMapping(String modelName, String mappingName, @Nullable Map<String, String> vendorExtensions) {
    }

    /** {@return the list of mapped models} */
    List<ModelMapping> mappedModels();
}
