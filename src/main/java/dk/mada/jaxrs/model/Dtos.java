package dk.mada.jaxrs.model;

import static java.util.stream.Collectors.toSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.openapi.ParserOpts;

public class Dtos {
	private static final Logger logger = LoggerFactory.getLogger(Dtos.class);

	private final Set<String> openapiNames;
	private final Set<Dto> dtos = new HashSet<>();
	private final Map<String, Type> mappedToJseTypes = new HashMap<>();
	
	public Dtos(ParserOpts opts, GeneratorOpts generatorOpts, Set<String> openapiNames) {
		this.openapiNames = new HashSet<>(openapiNames);
		
		TypeDateTime typeDateTime = TypeDateTime.get(generatorOpts);

		if (opts.isJseBigDecimal()) {
			mappedToJseTypes.put(TypeBigDecimal.BIG_DECIMAL, TypeBigDecimal.get());
		}
		if (opts.isJseLocalDate()) {
			mappedToJseTypes.put(TypeDate.TYPE_LOCAL_DATE, TypeDate.get());
		}
		if (opts.isJseLocalTime()) {
			mappedToJseTypes.put(TypeLocalTime.TYPE_LOCAL_TIME, TypeLocalTime.get());
		}
		if (opts.isJseLocalDateTime()) {
			mappedToJseTypes.put("LocalDateTime", typeDateTime);
		}
		if (opts.isJseOffsetDateTime()) {
			mappedToJseTypes.put("OffsetDateTime", typeDateTime);
		}
		if (opts.isJseZonedDateTime()) {
			mappedToJseTypes.put("ZonedDateTime", typeDateTime);
		}
		
		logger.info("JSE type overrides: {}", mappedToJseTypes);
		openapiNames.removeAll(mappedToJseTypes.keySet());
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

		Type jseType = mappedToJseTypes.get(openapiName);
		if (jseType != null) {
			return jseType;
		}
		
		return dtos.stream()
			.filter(d -> openapiName.equals(d.openapiName()))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("No type referenced found by name " + openapiName));
	}
	
	public RefDto findSibling(String name) {
		if (!openapiNames.contains(name) && !mappedToJseTypes.keySet().contains(name)) {
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
