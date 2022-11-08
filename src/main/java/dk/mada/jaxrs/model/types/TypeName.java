package dk.mada.jaxrs.model.types;

/**
 * A type name.
 * Used for referencing the types seen in the OpenApi document.
 *
 * @param name the name of the type
 */
public record TypeName(String name) implements Comparable<TypeName> {
    @Override
    public int compareTo(TypeName other) {
        return name.compareTo(other.name);
    }
}
