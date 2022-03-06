package dk.mada.jaxrs.openapi;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.types.Primitive;
import dk.mada.jaxrs.model.types.Reference;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeArray;
import dk.mada.jaxrs.model.types.TypeBigDecimal;
import dk.mada.jaxrs.model.types.TypeDate;
import dk.mada.jaxrs.model.types.TypeDateTime;
import dk.mada.jaxrs.model.types.TypeLocalTime;
import dk.mada.jaxrs.model.types.TypeMap;
import dk.mada.jaxrs.model.types.TypeNames;
import dk.mada.jaxrs.model.types.TypeNames.TypeName;
import dk.mada.jaxrs.model.types.TypeObject;
import dk.mada.jaxrs.model.types.TypeSet;
import dk.mada.jaxrs.model.types.TypeUUID;

/**
 * Types found while parsing.
 *
 * This is only used to collect the types. When parsing
 * is completed, they will be moved to the model's Types
 * container after being resolved and mapped.
 */
public class ParserTypes {
    private static final Logger logger = LoggerFactory.getLogger(ParserTypes.class);

    /** Newline. */
    private static final String NL = System.lineSeparator();

    /** DTOs parsed from the specification. */
    private final Map<TypeName, Dto> parsedDtos = new HashMap<>();

    /**
     * Types mapped to JSE standard types.
     */
    private final Map<TypeName, Type> mappedToJseTypes = new HashMap<>();

    /**
     * JSE standard types that were not mapped (because the user opted
     * to keep them as DTOs).
     */
    private final Set<TypeName> unmappedToJseTypes = new HashSet<>();

    /**
     * Types that (via their type name) have been mapped to
     * some other types.
     */
    private final Map<TypeName, Type> remappedDtoTypes = new HashMap<>();

    /**
     * Create new instance.
     *
     * @param parserOpts the parser options
     * @param generatorOpts the generator options
     */
    public ParserTypes(ParserOpts parserOpts, GeneratorOpts generatorOpts) {
        TypeDateTime typeDateTime = TypeDateTime.get(generatorOpts);

        mapJse(parserOpts.isJseBigDecimal(),     TypeBigDecimal.TYPENAME_BIG_DECIMAL, TypeBigDecimal.get());
        mapJse(parserOpts.isJseUUID(),           TypeUUID.TYPENAME_UUID,              TypeUUID.get());
        mapJse(parserOpts.isJseLocalDate(),      TypeDate.TYPENAME_LOCAL_DATE,        TypeDate.get());
        mapJse(parserOpts.isJseLocalTime(),      TypeLocalTime.TYPENAME_LOCAL_TIME,   TypeLocalTime.get());
        mapJse(parserOpts.isJseLocalDateTime(),  TypeNames.of("LocalDateTime"),       typeDateTime);
        mapJse(parserOpts.isJseOffsetDateTime(), TypeNames.of("OffsetDateTime"),      typeDateTime);
        mapJse(parserOpts.isJseZonedDateTime(),  TypeNames.of("ZonedDateTime"),       typeDateTime);

        logger.info("JSE type overrides: {}", mappedToJseTypes.keySet());
        logger.info("JSE types kept: {}", unmappedToJseTypes);
    }

    private void mapJse(boolean doMap, TypeName tn, Type t) {
        if (doMap) {
            mappedToJseTypes.put(tn, t);
        } else {
            unmappedToJseTypes.add(tn);
        }
    }

    /**
     * Registers a new DTO.
     *
     * @param dto the DTO to register.
     */
    public void addDto(Dto dto) {
        parsedDtos.put(dto.openapiId(), dto);
    }

    /** {@return the defined DTOs} */
    public Set<Dto> getActiveDtos() {
        return parsedDtos.entrySet().stream()
                .filter(e -> !mappedToJseTypes.containsKey(e.getKey()))
                .filter(e -> !remappedDtoTypes.containsKey(e.getKey()))
                .map(Entry::getValue)
                .collect(toSet());
    }

    /**
     * Get a type from a type name.
     *
     * @param tn the type name to get
     * @return the associated type
     * @throws IllegalArgumentException if there is no type associated with the given type name
     */
    public Type get(TypeName tn) {
        Type t = find(tn);
        if (t == null) {
            throw new IllegalArgumentException("No type referenced found by name " + tn);
        }
        return t;
    }

    private Type find(TypeName tn) {
        String conversion = "na";
        String name = tn.name();

        Type type = mappedToJseTypes.get(tn);
        if (type != null) {
            conversion = "jse";
        }

        if (type == null) {
            type = remappedDtoTypes.get(tn);
            if (type != null) {
                conversion = "remapped";
            }
        }

        if (type == null) {
            type = parsedDtos.get(tn);
            if (type != null) {
                conversion = "dto";
            }
        }

        if (type == null) {
            type = Primitive.find(tn);
            if (type != null) {
                conversion = "primitive";
            }
        }

        logger.info("find {} -> {} : {}", name, conversion, type);
        return type;
    }

    /**
     * Collection types such as ListDto are changed to {@code List<Dto>}.
     */
    public void consolidateDtos() {
        logger.info("Consolidate DTOs");
        for (Dto dto : parsedDtos.values()) {
            String name = dto.name();
            Reference ref = dto.reference();
            Type type = ref.refType();

            TypeName openapiName = dto.openapiId();

            logger.debug(" consider {} : {} {}/{}", name, dto.getClass(), type.getClass(), type);

            if (type instanceof TypeArray ta) {
                remapDto(openapiName, TypeArray.of(ta.innerType()));
            } else if (type instanceof TypeSet ts) {
                remapDto(openapiName, TypeSet.of(ts.innerType()));
            } else if (type instanceof TypeMap) {
                // no remapping of maps
                // a DTO with properties of the same type may be represented like this
            } else if (unmappedToJseTypes.contains(openapiName)) {
                // no remapping of kept types
            } else if (dto.isEnum()) {
                // no remapping of enums
            } else if (!(type instanceof TypeObject)) {
                remapDto(openapiName, type);
            }
        }
    }

    private void remapDto(TypeName openapiName, Type newType) {
        logger.info("  remap {} to {}", openapiName, newType);
        Type oldType = remappedDtoTypes.put(openapiName, newType);
        if (oldType != null) {
            throw new IllegalStateException("Dto " + openapiName + " remapped twice from " + oldType + " to " + newType);
        }
    }

    /** {@return information about the model} */
    public String info() {
        StringBuilder sb = new StringBuilder("Parser Types:").append(NL);
        sb.append(" Unmapped JSE: ");
        sb.append(unmappedToJseTypes.stream()
                    .sorted()
                    .map(TypeName::name)
                    .collect(joining(", "))).append(NL);

        sb.append(" Mapped JSE: ").append(NL);
        mappedToJseTypes.keySet().stream()
            .sorted()
            .forEach(tn -> {
                Type t = mappedToJseTypes.get(tn);
                sb.append("  ").append(tn.name())
                    .append(": ").append(t).append(NL);
            });

        sb.append(" DTOs: ").append(NL);
        parsedDtos.keySet().stream()
            .sorted()
            .forEach(tn -> {
                Dto dto = parsedDtos.get(tn);
                sb.append("  ").append(tn.name())
                    .append(": ").append(dto.name()).append(" - ").append(dto.reference()).append(NL);
            });

        sb.append(" Remapped DTOs: ").append(NL);
        remappedDtoTypes.keySet().stream()
            .sorted()
            .forEach(tn -> {
                Type t = remappedDtoTypes.get(tn);
                sb.append("  ").append(tn.name())
                    .append(": ").append(t).append(NL);
            });

        return sb.toString();
    }
}
