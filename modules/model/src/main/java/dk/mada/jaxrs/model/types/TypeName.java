package dk.mada.jaxrs.model.types;

import dk.mada.jaxrs.model.naming.Naming;

/**
 * A type name. Used for referencing the types seen in the OpenApi document.
 *
 * @param name the name of the type
 */
public record TypeName(String name) implements Comparable<TypeName> {
    @Override
    public int compareTo(TypeName other) {
        return name.compareTo(other.name);
    }

    /** {@return true if this type name is internal to the parser} */
    public boolean isInternalParserName() {
        return Naming.isParserInternalName(name);
    }
}
