package dk.mada.jaxrs.model;

import java.util.Set;

public interface Type {
	String typeName();

	default Set<String> neededImports() {
		return Set.of();
	}
	
	default boolean isBigDecimal() { return false; }
	default boolean isDate() { return false; }
	default boolean isDateTime() { return false; }
	default boolean isTime() { return false; }
}
