package dk.mada.jaxrs.model;

import java.util.List;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

@Immutable
public interface Dto {
	String name();
	/** The name the DTO was identified by in the schema */
	String openapiName();
	List<Property> properties();
	
	@Nullable
	List<String> enumValues();
	default boolean isEnum() {
		return enumValues() != null;
	}
}
