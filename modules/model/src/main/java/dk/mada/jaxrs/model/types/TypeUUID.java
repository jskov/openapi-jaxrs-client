package dk.mada.jaxrs.model.types;

import java.util.Set;
import org.jspecify.annotations.Nullable;

/**
 * Special type for handing UUID type.
 */
public final class TypeUUID implements Type {
    /** The single instance of this object. */
    @Nullable private static TypeUUID instance;

    private TypeUUID() {}

    /** {@return the type object representing a UUID} */
    public static synchronized TypeUUID get() {
        if (instance == null) {
            instance = new TypeUUID();
        }
        return instance;
    }

    @Override
    public Set<String> neededImports() {
        return Set.of("java.util.UUID");
    }

    @Override
    public TypeName typeName() {
        return TypeNames.UUID;
    }

    @Override
    public boolean isUUID() {
        return true;
    }
}
