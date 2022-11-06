package dk.mada.jaxrs.model.types;

import java.util.Set;

/**
 * Special type for handing UUID type.
 */
public final class TypeUUID implements Type {
    /** The single instance of this object. */
    private static final TypeUUID INSTANCE = new TypeUUID();

    private TypeUUID() {
    }

    /** {@return the type object representing a UUID} */
    public static TypeUUID get() {
        return INSTANCE;
    }

    @Override
    public Set<String> neededImports() {
        return Set.of("java.util.UUID");
    }

    @Override
    public TypeName typeName() {
        return TypeNames.UUID;
    }
}
