package dk.mada.jaxrs.generator.tmpl.dto;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

/**
 * Context for a DTO property.
 */
@Immutable
public interface CtxProperty {
	String name();
	String baseName();
	String nameInCamelCase();
	String nameInSnakeCase();
	String datatypeWithEnum();
	String getter();
	String setter();
	
	@Nullable
	String defaultValue();

	@Nullable
	String description();
	
	boolean isArray();
	boolean isMap();
	default boolean isContainer() {
		return isArray() || isMap();
	}
	
	boolean required();
	
	@Nullable
	String example();
	
	CtxPropertyExt mada();
}
