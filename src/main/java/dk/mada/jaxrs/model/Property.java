package dk.mada.jaxrs.model;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

@Immutable
public interface Property {
	String name();
	Type type();
	@Nullable
	String description();
	@Nullable
	String example();
	
	boolean isRequired();
}
