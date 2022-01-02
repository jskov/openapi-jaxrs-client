package dk.mada.jaxrs.model;

import static java.util.stream.Collectors.toSet;

import java.util.HashSet;
import java.util.Set;

import dk.mada.jaxrs.openapi.ParserOpts;

public class Dtos {
	private final ParserOpts opts;
	private final Set<String> openapiNames;
	private final Set<Dto> dtos = new HashSet<>();
	private final Set<String> mappedToTypes = new HashSet<>();
	
	public Dtos(ParserOpts opts, Set<String> openapiNames) {
		this.openapiNames = new HashSet<>(openapiNames);
		this.opts = opts;
		
		if (opts.isLocalTimeHandling()) {
			openapiNames.remove(TypeLocalTime.TYPE_LOCAL_TIME);
			mappedToTypes.add(TypeLocalTime.TYPE_LOCAL_TIME);
		}
	}
	
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
	
	public Type dereference(RefDto ref) {
		String openapiName = ref.openapiName();
		
		if (TypeLocalTime.TYPE_LOCAL_TIME.equals(openapiName)
				&& opts.isLocalTimeHandling()) {
			return TypeLocalTime.get();
		}
		
		return dtos.stream()
			.filter(d -> openapiName.equals(d.openapiName()))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("No type referenced found by name " + openapiName));
	}
	
	public RefDto findSibling(String name) {
		if (!openapiNames.contains(name) && !mappedToTypes.contains(name)) {
			return null;
		}
		
		return ImmutableRefDto.builder()
				.openapiName(name)
				.dtos(this)
				.build();
	}
	
	@Override
	public String toString() {
		return "Types [types#=" + dtos.size() + "]";
	}
}
