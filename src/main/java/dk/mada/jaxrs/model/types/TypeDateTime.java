package dk.mada.jaxrs.model.types;

import java.util.Set;

import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.model.types.TypeNames.TypeName;

/**
 * Special type for handing date-time schema.
 *
 * TODO: opts should be a constructor input
 */
public final class TypeDateTime implements Type {
    /** The single instance of the LocalDateTime object. */
    private static final TypeDateTime INSTANCE_LOCAL = new TypeDateTime(TypeNames.LOCAL_DATE_TIME, "java.time.LocalDateTime");
    /** The single instance of the OffsetDateTime object. */
    private static final TypeDateTime INSTANCE_OFFSET = new TypeDateTime(TypeNames.OFFSET_DATE_TIME, "java.time.OffsetDateTime");
    /** The single instance of the ZonedDateTime object. */
    private static final TypeDateTime INSTANCE_ZONED = new TypeDateTime(TypeNames.ZONED_DATE_TIME, "java.time.ZonedDateTime");

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
     * @param opts the generator options
     */
    public static TypeDateTime get(GeneratorOpts opts) {
        if (opts.isUseZonedDateTime() && opts.isUseLocalDateTime()) {
            throw new IllegalArgumentException("You can only select one date-time implementation!");
        }
        if (opts.isUseZonedDateTime()) {
            return INSTANCE_ZONED;
        }
        if (opts.isUseLocalDateTime()) {
            return INSTANCE_LOCAL;
        }

        return INSTANCE_OFFSET;
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
