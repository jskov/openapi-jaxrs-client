package dk.mada.jaxrs.model.types;

import java.util.Set;

import org.jspecify.annotations.Nullable;

/**
 * Special type for handing date-time schema.
 */
public final class TypeDateTime implements Type {
    /** The single instance of the LocalDateTime object. */
    @Nullable private static TypeDateTime instanceLocal;
    /** The single instance of the OffsetDateTime object. */
    @Nullable private static TypeDateTime instanceOffset;
    /** The single instance of the ZonedDateTime object. */
    @Nullable private static TypeDateTime instanceZoned;

    /** The Java variants of date-time implementations. */
    public enum DateTimeVariant {
        /** LocalDateTime. */
        LOCAL,
        /** OffsetDateTime. */
        OFFSET,
        /** ZonedDateTime. */
        ZONED;
    }

    /** The type name. */
    private final TypeName typeName;
    /** The imports needed for this type. */
    private final Set<String> neededImports;

    private TypeDateTime(TypeName typeName, String importName) {
        this.typeName = typeName;
        this.neededImports = Set.of(importName);
    }

    /**
     * {@return the type object representing a date-time}
     *
     * @param variant the desired variant
     */
    public static synchronized TypeDateTime get(DateTimeVariant variant) {
        switch (variant) {
        case LOCAL:
            if (instanceLocal == null) {
                instanceLocal = new TypeDateTime(TypeNames.LOCAL_DATE_TIME, "java.time.LocalDateTime");
            }
            return instanceLocal;
        case OFFSET:
            if (instanceOffset == null) {
                instanceOffset = new TypeDateTime(TypeNames.OFFSET_DATE_TIME, "java.time.OffsetDateTime");
            }
            return instanceOffset;
        case ZONED:
            if (instanceZoned == null) {
                instanceZoned = new TypeDateTime(TypeNames.ZONED_DATE_TIME, "java.time.ZonedDateTime");
            }
            return instanceZoned;
        default:
            throw new IllegalStateException("Unhandled variant " + variant);
        }
    }

    @Override
    public TypeName typeName() {
        return typeName;
    }

    @Override
    public Set<String> neededImports() {
        return neededImports;
    }

    @Override
    public boolean isDateTime() {
        return true;
    }
}
