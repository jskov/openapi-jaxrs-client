package dk.mada.jaxrs.model;

import java.util.Set;

/**
 * Special type for handing date schema.
 */
public class TypeDate implements Type {
	private static final TypeDate object = new TypeDate();
	
	private TypeDate() {
	}

	public static TypeDate get() {
		return object;
	}
	
	@Override
	public String typeName() {
		return "LocalDate";
	}
	
	@Override
	public Set<String> neededImports() {
		return Set.of("java.time.LocalDate");
	}
}
