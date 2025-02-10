package dk.mada.jaxrs.model.types;

import java.util.Set;
import org.jspecify.annotations.Nullable;

/**
 * Special type for handing date schema.
 */
public final class TypeDate implements Type {
    /** The single instance of this object. */
    @Nullable private static TypeDate instance;

    private TypeDate() {}

    /** {@return the type object representing a date} */
    public static synchronized TypeDate get() {
        if (instance == null) {
            instance = new TypeDate();
        }
        return instance;
    }

    @Override
    public TypeName typeName() {
        return TypeNames.LOCAL_DATE;
    }

    @Override
    public Set<String> neededImports() {
        return Set.of("java.time.LocalDate");
    }

    @Override
    public boolean isDate() {
        return true;
    }
}
