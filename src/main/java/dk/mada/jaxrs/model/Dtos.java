package dk.mada.jaxrs.model;

import static java.util.stream.Collectors.toSet;

import java.util.HashSet;
import java.util.Set;

public class Dtos {
	private final Set<Dto> dtos = new HashSet<>();
	
	public void addDto(Dto dto) {
		dtos.add(dto);
	}

	public Set<String> getDtoNames() {
		return dtos.stream()
			.map(t -> t.name())
			.collect(toSet());
	}
	
	public Set<Dto> get() {
		return dtos;
	}
	
	public Dto dereference(RefDto ref) {
		String openapiName = ref.openapiName();
		return dtos.stream()
			.filter(d -> openapiName.equals(d.openapiName()))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("No type referenced found by name " + openapiName));
	}
	
	@Override
	public String toString() {
		return "Types [types=" + dtos + "]";
	}
}
