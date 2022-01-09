package dk.mada.jaxrs.model.types;

import java.util.HashMap;
import java.util.Map;

public class TypeNames {
	public record TypeName(String name) {};

	private static final Map<String, TypeName> nameToInstances = new HashMap<>();
	
	public static TypeName of(String name) {
		return nameToInstances.computeIfAbsent(name, TypeName::new);
	}
}
