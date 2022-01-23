package dk.mada.jaxrs.model.types;

import java.util.Set;

import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.model.types.TypeNames.TypeName;

/**
 * Special type for handing date-time schema.
 */
public class TypeDateTime implements Type {
    private static final TypeDateTime INSTANCE_OFFSET = new TypeDateTime("OffsetDateTime", "java.time.OffsetDateTime");
    private static final TypeDateTime INSTANCE_ZONED = new TypeDateTime("ZonedDateTime", "java.time.ZonedDateTime");

    private final TypeName typeName;
    private final Set<String> neededImports;

    public TypeDateTime(String typeName, String importName) {
        this.typeName = TypeNames.of(typeName);
        this.neededImports = Set.of(importName);
    }

    public static TypeDateTime get(GeneratorOpts opts) {
        return opts.isUseZonedDateTime() ? INSTANCE_ZONED : INSTANCE_OFFSET;
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
