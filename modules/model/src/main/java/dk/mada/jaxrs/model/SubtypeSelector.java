package dk.mada.jaxrs.model;

import dk.mada.jaxrs.model.types.Reference;
import java.util.Map;

/**
 * Sub-type selection information.
 *
 * @param propertyName the name of the property holding the type selector
 * @param typeMapping the mapping from names to types
 */
public record SubtypeSelector(String propertyName, Map<String, Reference> typeMapping) {}
