package dk.mada.jaxrs.model;

import java.util.List;
import java.util.SortedSet;

import org.immutables.value.Value.Immutable;

@Immutable
public interface Dto {
	String name();
	SortedSet<String> imports();
	List<Property> properties();
}
