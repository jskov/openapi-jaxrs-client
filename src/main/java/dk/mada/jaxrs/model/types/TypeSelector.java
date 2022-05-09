package dk.mada.jaxrs.model.types;

import java.util.Map;

import org.immutables.value.Value.Immutable;

/**
 * Type selection information - not a type per se.
 * Maps a string to a type.
 */
@Immutable
public interface TypeSelector {
    static TypeSelector of(String propertyName, Map<String, Reference> typeMapping) {
        return ImmutableTypeSelector.builder()
                .propertyName(propertyName).typeMapping(typeMapping).build();
    }

    /** {@return the name of the property holding the type selector} */
    String propertyName();

    /** {@return the mapping from names to types} */
    Map<String, Reference> typeMapping();
}
