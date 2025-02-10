package dk.mada.jaxrs.model.types;

import java.util.Set;
import org.jspecify.annotations.Nullable;

/**
 * Special type for handing number schema.
 */
public final class TypeBigDecimal implements Type {
    /** The single instance of this object. */
    @Nullable private static TypeBigDecimal instance;

    private TypeBigDecimal() {}

    /** {@return the single instance} */
    public static synchronized TypeBigDecimal get() {
        if (instance == null) {
            instance = new TypeBigDecimal();
        }
        return instance;
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
