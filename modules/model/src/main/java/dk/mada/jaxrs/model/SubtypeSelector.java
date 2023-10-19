package dk.mada.jaxrs.model;

import java.util.Map;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.model.types.Reference;

/**
 * Sub-type selection information.
 */
@Immutable
public interface SubtypeSelector {
    /**
     * Creates a new subtype selector instance.
     *
     * @param propertyName the name of the property containing the sub-type selection
     * @param typeMapping  the sub-type mapping
     * @return a new instance
     */
    static SubtypeSelector of(String propertyName, Map<String, Reference> typeMapping) {
        return ImmutableSubtypeSelector.builder()
                .propertyName(propertyName).typeMapping(typeMapping).build();
    }

    /** {@return the name of the property holding the type selector} */
    String propertyName();

    /** {@return the mapping from names to types} */
    Map<String, Reference> typeMapping();
}
