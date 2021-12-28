package dk.mada.jaxrs.model;

import java.util.List;
import java.util.SortedSet;

import org.immutables.value.Value.Immutable;

@Immutable
public interface Dto {
	String name();
	/** The name the DTO was identified by in the schema */
	String openapiName();
	SortedSet<String> imports();
	List<Property> properties();
}
