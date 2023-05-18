package dk.mada.jaxrs.model.types;

import java.util.Set;

import org.jspecify.annotations.Nullable;

import dk.mada.jaxrs.generator.GeneratorOpts;

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
     * @param opts the generator options
     */
    public static synchronized TypeDateTime get(GeneratorOpts opts) {
        if (opts.isUseZonedDateTime() && opts.isUseLocalDateTime()) {
            throw new IllegalArgumentException("You can only select one date-time implementation!");
        }

        if (opts.isUseZonedDateTime()) {
            if (instanceZoned == null) {
                instanceZoned = new TypeDateTime(TypeNames.ZONED_DATE_TIME, "java.time.ZonedDateTime");
            }
            return instanceZoned;
        }
        if (opts.isUseLocalDateTime()) {
            if (instanceLocal == null) {
                instanceLocal = new TypeDateTime(TypeNames.LOCAL_DATE_TIME, "java.time.LocalDateTime");
            }
            return instanceLocal;
        }

        if (instanceOffset == null) {
            instanceOffset = new TypeDateTime(TypeNames.OFFSET_DATE_TIME, "java.time.OffsetDateTime");
        }
        return instanceOffset;
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
