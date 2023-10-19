package dk.mada.jaxrs.model.types;

import java.util.Set;

import org.jspecify.annotations.Nullable;

/**
 * Special type for optional special handing of types named LocalTime as if they are LocalTime. This is an (invalid, and
 * thus not properly passed through) example from the Quarkus openapi extension:
 *
 * LocalTime: format: local-time type: string externalDocs: description: As defined by 'partial-time' in RFC3339 url:
 * https://xml2rfc.ietf.org/public/rfc/html/rfc3339.html#anchor14 example: 13:45.30.123456789
 */
public final class TypeLocalTime implements Type {
    /** The single instance of this object. */
    @Nullable private static TypeLocalTime instance;
    /** The OpenApi custom format used for this type. */
    public static final String OPENAPI_CUSTOM_FORMAT = "local-time";

    private TypeLocalTime() {
    }

    /** {@return the type object representing local-time} */
    public static synchronized TypeLocalTime get() {
        if (instance == null) {
            instance = new TypeLocalTime();
        }
        return instance;
    }

    @Override
    public TypeName typeName() {
        return TypeNames.LOCAL_TIME;
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
