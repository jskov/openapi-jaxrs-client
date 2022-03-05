package dk.mada.jaxrs.model.types;

import static java.util.stream.Collectors.joining;

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

    /** {@return information about the type names} */
    public static String info() {
        String sep = System.lineSeparator() + "  ";
        return new StringBuilder("Type names:").append(sep)
                .append(NAME_TO_INSTANCES.keySet().stream()
                    .sorted((a, b) -> a.compareToIgnoreCase(b))
                    .collect(joining(sep)))
                .toString();
    }
}
