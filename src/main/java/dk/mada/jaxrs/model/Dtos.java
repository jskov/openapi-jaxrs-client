package dk.mada.jaxrs.model;

import static java.util.stream.Collectors.toSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Dtos {
	private final Set<Dto> types;
	
	public Dtos(Collection<Dto> types) {
		this.types = new HashSet<>(types);
	}

	public Set<String> getDtoNames() {
		return types.stream()
			.map(t -> t.name())
			.collect(toSet());
	}
	
	public Set<Dto> get() {
		return types;
	}
	
	@Override
	public String toString() {
		return "Types [types=" + types + "]";
	}
}
