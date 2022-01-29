package dk.mada.jaxrs.model.types;

import java.util.Set;

import dk.mada.jaxrs.model.types.TypeNames.TypeName;

/**
 * Special type for handing number schema.
 */
public final class TypeBigDecimal implements Type {
    public static final TypeName BIG_DECIMAL = TypeNames.of("BigDecimal");
    private static final TypeBigDecimal INSTANCE = new TypeBigDecimal();

    private TypeBigDecimal() {
    }

    public static TypeBigDecimal get() {
        return INSTANCE;
    }

    @Override
    public TypeName typeName() {
        return BIG_DECIMAL;
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
