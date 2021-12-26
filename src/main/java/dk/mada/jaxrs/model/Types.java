package dk.mada.jaxrs.model;

import static java.util.stream.Collectors.toSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Types {
	private final Set<Type> types;
	
	public Types(Collection<Type> types) {
		this.types = new HashSet<>(types);
	}

	public Set<String> getTypeNames() {
		return types.stream()
			.map(t -> t.name())
			.collect(toSet());
	}
	
	
	@Override
	public String toString() {
		return "Types [types=" + types + "]";
	}
}
