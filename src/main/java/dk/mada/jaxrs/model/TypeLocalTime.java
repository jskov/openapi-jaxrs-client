package dk.mada.jaxrs.model;

import java.util.Set;

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
 *
 * FIXME: catch
 *
 */
public class TypeLocalTime implements Type {
	public static final String TYPE_LOCAL_TIME = "LocalTime";
	private static final TypeLocalTime object = new TypeLocalTime();
	
	private TypeLocalTime() {
	}

	public static TypeLocalTime get() {
		return object;
	}
	
	@Override
	public String typeName() {
		return TYPE_LOCAL_TIME;
	}
	
	@Override
	public Set<String> neededImports() {
		return Set.of("java.time.LocalTime");
	}
}
