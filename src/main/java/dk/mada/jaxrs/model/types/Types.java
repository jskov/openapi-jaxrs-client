package dk.mada.jaxrs.model.types;

import static java.util.stream.Collectors.toSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.types.TypeNames.TypeName;
import dk.mada.jaxrs.openapi.ParserOpts;

public class Types {
	private static final Logger logger = LoggerFactory.getLogger(Types.class);
	private final Map<TypeName, Type> mappedToJseTypes = new HashMap<>();
	private final Map<TypeName, Dto> parsedDtos = new HashMap<>();

	public Types(ParserOpts parserOpts, GeneratorOpts generatorOpts) {
		TypeDateTime typeDateTime = TypeDateTime.get(generatorOpts);
	
		if (parserOpts.isJseBigDecimal()) {
			mappedToJseTypes.put(TypeBigDecimal.BIG_DECIMAL, TypeBigDecimal.get());
		}
		if (parserOpts.isJseLocalDate()) {
			mappedToJseTypes.put(TypeDate.TYPE_LOCAL_DATE, TypeDate.get());
		}
		if (parserOpts.isJseLocalTime()) {
			mappedToJseTypes.put(TypeLocalTime.TYPE_LOCAL_TIME, TypeLocalTime.get());
		}
		if (parserOpts.isJseLocalDateTime()) {
			mappedToJseTypes.put(TypeNames.of("LocalDateTime"), typeDateTime);
		}
		if (parserOpts.isJseOffsetDateTime()) {
			mappedToJseTypes.put(TypeNames.of("OffsetDateTime"), typeDateTime);
		}
		if (parserOpts.isJseZonedDateTime()) {
			mappedToJseTypes.put(TypeNames.of("ZonedDateTime"), typeDateTime);
		}
		
		logger.info("JSE type overrides: {}", mappedToJseTypes);
	}
	
	public Type get(TypeName tn) {
		Type jseType = mappedToJseTypes.get(tn);
		if (jseType != null) {
			return jseType;
		}
		
		// FIXME: remapping here
		
		Dto dto = parsedDtos.get(tn);
		if (dto != null) {
			return dto;
		}

		throw new IllegalArgumentException("No type referenced found by name " + tn);
	}
	
	public Set<Dto> getActiveDtos() {
		return parsedDtos.entrySet().stream()
				.filter(e -> !mappedToJseTypes.containsKey(e.getKey()))
				.map(e -> e.getValue())
				.collect(toSet());
	}

	public void addDto(Dto dto) {
		parsedDtos.put(dto.openapiId(), dto);
	}
	
	public TypeRef findDto(String name) {
		return TypeRef.of(TypeNames.of(name), this);
	}

	public void consolidateDtos() {
		// TODO: override references with better types when possible
	}
}
