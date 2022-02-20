package dk.mada.jaxrs.model.types;

import java.util.Set;

import dk.mada.jaxrs.model.types.TypeNames.TypeName;

/**
 * Special type for handing UUID type.
 */
public final class TypeUUID implements Type {
    /** The type name for UUID. */
    public static final TypeName TYPENAME_UUID = TypeNames.of("UUID");

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
        return TYPENAME_UUID;
    }
}
