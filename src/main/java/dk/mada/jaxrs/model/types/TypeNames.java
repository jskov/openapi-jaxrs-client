package dk.mada.jaxrs.model.types;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains all declared type names.
 */
public final class TypeNames {
    /** TypeName instances indexed by their name. */
    private static final Map<String, TypeName> NAME_TO_INSTANCES = new HashMap<>();

    private TypeNames() {
    }

    public record TypeName(String name) implements Comparable<TypeName> {
        @Override
        public int compareTo(TypeName other) {
            return name.compareTo(other.name);
        }
    }

    /**
     * Creates a new type name.
     *
     * @param name name of the type
     * @return a new TypeName instance
     */
    public static TypeName of(String name) {
        return NAME_TO_INSTANCES.computeIfAbsent(name, TypeName::new);
    }
}
