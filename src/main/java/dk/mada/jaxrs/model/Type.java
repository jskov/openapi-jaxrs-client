package dk.mada.jaxrs.model;

import java.util.Set;

public interface Type {
	String typeName();

	default Set<String> neededImports() {
		return Set.of();
	}
}
