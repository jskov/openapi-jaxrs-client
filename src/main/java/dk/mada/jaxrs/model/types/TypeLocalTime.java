package dk.mada.jaxrs.model.types;

import java.util.Set;

import dk.mada.jaxrs.model.types.TypeNames.TypeName;

/**
 * Special type for optional special handing of types named LocalTime
 * as if they are LocalTime. This is an (invalid, and thus not properly
 * passed through) example from the Quarkus openapi extension:
 *
 *  LocalTime:
 *    format: local-time
 *    type: string
 *    externalDocs:
 *      description: As defined by 'partial-time' in RFC3339
 *      url: https://xml2rfc.ietf.org/public/rfc/html/rfc3339.html#anchor14
 *    example: 13:45.30.123456789
 */
public final class TypeLocalTime implements Type {
    public static final TypeName TYPE_LOCAL_TIME = TypeNames.of("LocalTime");
    public static final String OPENAPI_CUSTOM_FORMAT = "local-time";
    private static final TypeLocalTime INSTANCE = new TypeLocalTime();

    private TypeLocalTime() {
    }

    public static TypeLocalTime get() {
        return INSTANCE;
    }

    @Override
    public TypeName typeName() {
        return TYPE_LOCAL_TIME;
    }

    @Override
    public Set<String> neededImports() {
        return Set.of("java.time.LocalTime");
    }

    @Override
    public boolean isTime() {
        return true;
    }
}
