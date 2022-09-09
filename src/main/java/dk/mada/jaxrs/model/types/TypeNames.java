package dk.mada.jaxrs.model.types;

import static java.util.stream.Collectors.joining;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Contains all declared type names.
 */
public final class TypeNames {
    /** TypeName instances indexed by their name. */
    private static final Map<String, TypeName> NAME_TO_INSTANCES = new HashMap<>();

    /** Rewritten type names. */
    private static final Map<String, String> RENAMING = new HashMap<>();

    private TypeNames() {
    }

    /**
     * Reset static content before running generator.
     * This is required when multiple unit tests are run in the
     * same VM.
     * FIXME: The proper solution is to inject an instance of this object instead.
     */
    public static void resetForTesting() {
        RENAMING.clear();
        NAME_TO_INSTANCES.clear();
    }
    
    /**
     * Adds a rename mapping for a type name.
     *
     * This will make the TypeName instance for 'typeName' return
     * the name 'newTypeName'.
     *
     * This method should only be used after DTOs have been consolidated.
     *
     * @param typeName the name of the type to rename
     * @param newTypeName the types new name
     */
    public static void rename(String typeName, String newTypeName) {
        RENAMING.put(typeName, newTypeName);
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

    /** {@return information about the type names} */
    public static String info() {
        String sep = System.lineSeparator() + "  ";
        return new StringBuilder("Type names:").append(sep)
                .append(NAME_TO_INSTANCES.keySet().stream()
                    .sorted((a, b) -> a.compareToIgnoreCase(b))
                    .collect(joining(sep)))
                .toString();
    }

    /**
     * A type name.
     */
    public static final class TypeName implements Comparable<TypeName> {
        /** The type name at time of declaration. */
        private String name;

        /**
         * Creates a new type name instance.
         *
         * @param name the name of the type
         */
        private TypeName(String name) {
            this.name = name;
        }

        /**
         * Returns the name of the type.
         *
         * The name may be changed between the time of declaration,
         * and the use for rendering.
         *
         * @return the name of the type
         */
        public String name() {
            return RENAMING.getOrDefault(name, name);
        }

        @Override
        public int compareTo(TypeName other) {
            return name.compareTo(other.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            TypeName other = (TypeName) obj;
            return Objects.equals(name, other.name);
        }
    }
}
