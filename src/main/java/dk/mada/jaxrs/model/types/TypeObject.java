package dk.mada.jaxrs.model.types;

import dk.mada.jaxrs.model.types.TypeNames.TypeName;

/**
 * Special type for handing object type.
 */
public final class TypeObject implements Type {
    private static final TypeObject INSTANCE = new TypeObject();

    private TypeObject() {
    }

    public static TypeObject get() {
        return INSTANCE;
    }

    @Override
    public TypeName typeName() {
        return TypeNames.of("Object");
    }
}
