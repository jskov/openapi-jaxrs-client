package dk.mada.jaxrs.model.types;

import java.util.Set;

import dk.mada.jaxrs.model.types.TypeNames.TypeName;

/**
 * Special type for handing number schema.
 */
public final class TypeBigDecimal implements Type {
    /** The single instance of this object. */
    private static final TypeBigDecimal INSTANCE = new TypeBigDecimal();

    private TypeBigDecimal() {
    }

    /** {@return the single instance} */
    public static TypeBigDecimal get() {
        return INSTANCE;
    }

    @Override
    public TypeName typeName() {
        return TypeNames.BIG_DECIMAL;
    }

    @Override
    public Set<String> neededImports() {
        return Set.of("java.math.BigDecimal");
    }

    @Override
    public boolean isBigDecimal() {
        return true;
    }
}
