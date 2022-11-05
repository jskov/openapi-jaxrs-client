package dk.mada.jaxrs.model.types;

import java.util.Set;

/**
 * Special type for handing date schema.
 */
public final class TypeDate implements Type {
    /** The single instance of this object. */
    private static final TypeDate INSTANCE = new TypeDate();

    private TypeDate() {
    }

    /** {@return the type object representing a date} */
    public static TypeDate get() {
        return INSTANCE;
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
