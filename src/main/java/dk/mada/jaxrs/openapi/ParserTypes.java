package dk.mada.jaxrs.openapi;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.types.Primitive;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeArray;
import dk.mada.jaxrs.model.types.TypeBigDecimal;
import dk.mada.jaxrs.model.types.TypeDate;
import dk.mada.jaxrs.model.types.TypeDateTime;
import dk.mada.jaxrs.model.types.TypeLocalTime;
import dk.mada.jaxrs.model.types.TypeMap;
import dk.mada.jaxrs.model.types.TypeNames;
import dk.mada.jaxrs.model.types.TypeObject;
import dk.mada.jaxrs.model.types.TypeSet;
import dk.mada.jaxrs.model.types.TypeUUID;
import dk.mada.jaxrs.model.types.TypeNames.TypeName;

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
    public Collection<Dto> getDtos() {
        return parsedDtos.values();
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
        /* FIXME
        Type jseType = mappedToJseTypes.get(tn);
        if (jseType != null) {
            logger.trace(" {} -> jse {}", tn, jseType);
            return jseType;
        }
         */

        Type remappedType = remappedDtoTypes.get(tn);
        if (remappedType != null) {
            logger.trace(" {} -> remapped {}", tn, remappedType);
            return remappedType;
        }

        Dto dto = parsedDtos.get(tn);
        if (dto != null) {
            logger.trace(" {} -> dto {}", tn, dto);
            return dto;
        }

        Primitive p = Primitive.find(tn);
        if (p != null) {
            return p;
        }

        return null;
    }
    

    /**
     * Collection types such as ListDto are changed to {@code List<Dto>}.
     */
    public void consolidateDtos() {
        logger.info("Consolidate DTOs");
        for (Dto dto : getDtos()) {
            String name = dto.name();
            Type t = dto.dtoType();
            TypeName openapiName = dto.openapiId();

            logger.info(" consider {} : {} {}/{}", name, dto.getClass(), t.getClass(), t);

            if (t instanceof TypeArray ta) {
                remapDto(openapiName, TypeArray.of(ta.innerType()));
            } else if (t instanceof TypeSet ts) {
                remapDto(openapiName, TypeSet.of(ts.innerType()));
            } else if (t instanceof TypeMap) {
                // no remapping of maps
                // a DTO with properties of the same type may be represented like this
            } else if (unmappedToJseTypes.contains(openapiName)) {
                // no remapping of kept types
            } else if (dto.isEnum()) {
                // no remapping of enums
            } else if (!(t instanceof TypeObject)) {
                remapDto(openapiName, t);
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
        sb.append(" DTOs: ").append(NL);
        parsedDtos.keySet().stream()
            .sorted()
            .forEach(tn -> {
                Dto dto = parsedDtos.get(tn);
                sb.append("  ").append(tn.name())
                    .append(": ").append(dto.name()).append(" - ").append(dto.dtoType()).append(NL);
            });

        return sb.toString();
    }
}
