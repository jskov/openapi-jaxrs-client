package dk.mada.jaxrs.model.types;

import java.util.Set;

import dk.mada.jaxrs.model.types.TypeNames.TypeName;

/**
 * Special type for handing date schema.
 */
public final class TypeDate implements Type {
    public static final TypeName TYPE_LOCAL_DATE = TypeNames.of("LocalDate");
    private static final TypeDate INSTANCE = new TypeDate();

    private TypeDate() {
    }

    public static TypeDate get() {
        return INSTANCE;
    }

    @Override
    public TypeName typeName() {
        return TYPE_LOCAL_DATE;
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
