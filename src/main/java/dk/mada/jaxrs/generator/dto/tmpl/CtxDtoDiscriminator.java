package dk.mada.jaxrs.generator.dto.tmpl;

import java.util.List;

import org.immutables.value.Value.Immutable;

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

    record ModelMapping(String modelName, String mappingName) {
    }

    /** {@return the name of a custom LocalDateDeserializer, or null} */
    List<ModelMapping> mappedModels();
}
