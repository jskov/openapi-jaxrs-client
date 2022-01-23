package dk.mada.jaxrs.model.api;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.model.types.Type;

@Immutable
public interface Parameter {
	public static ImmutableParameter.Builder builder() {
		return ImmutableParameter.builder();
	}
	
	String name();
	Type type();

	@Nullable
	String description();
	boolean isRequired();
	
	boolean isHeaderParam();
	boolean isPathParam();
	boolean isQueryParam();
}
