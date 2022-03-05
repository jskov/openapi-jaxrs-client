package dk.mada.jaxrs.model.types;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.GeneratorOpts;
import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.types.TypeNames.TypeName;
import dk.mada.jaxrs.openapi.ParserOpts;

/**
 * Types used in the model for the specification.
 *
 * Some types will (depending on user options) be converted to
 * standard JSE types based on their name.
 * This is mainly used for some specifications
 * where the OpenApi types are not used directly in properties,
 * but instead use a reference to a standalone DTO with the same
 * representation.
 *
 * As the specification has been parsed, the DTOs are consolidated;
 * ListFoo-types are changed to {@code List<Foo>}. Again, this is due to some
 * specifications not using array on the property, but instead references
 * a standalone list-type.
 */
public class Types {
    private static final Logger logger = LoggerFactory.getLogger(Types.class);

    /** Newline. */
    private static final String NL = System.lineSeparator();

    /**
     * Types mapped to JSE standard types.
     */
    private final Map<TypeName, Type> mappedToJseTypes = new HashMap<>();
    /**
     * JSE standard types that were not mapped (because the user opted
     * to keep them as DTOs).
     */
    private final Set<TypeName> unmappedToJseTypes = new HashSet<>();
    /** DTOs from the specification. */
    private final Map<TypeName, Dto> dtos = new HashMap<>();
    /**
     * Types that (via their type name) have been mapped to
     * some other types.
     */
    private final Map<TypeName, Type> remappedDtoTypes = new HashMap<>();

    /**
     * Flags that transformation of the specification has completed
     * and thus that all type references can be safely dereferenced.
     */
    private boolean dereferencingSafe;

    /**
     * Constructs instance.
     *
     * @param parserOpts the parser options
     * @param generatorOpts the generator options
     */
    public Types(ParserOpts parserOpts, GeneratorOpts generatorOpts) {
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

    /**
     * Marks parsing transformation complete.
     */
    public void parsingCompleted() {
        dereferencingSafe = true;
    }

    /**
     * Asserts that parsing has completed and that
     * type dereferencing is safe.
     */
    public void assertDereferencingSafe() {
        if (!dereferencingSafe) {
            throw new IllegalStateException("Parsing is not completed, so dereferencing is not safe!");
        }
    }

    /**
     * Asserts that parsing is in process.
     *
     * Used to marked methods that should be moved to a
     * parser-specific model instead.
     */
    public void assertParsing() {
        if (dereferencingSafe) {
            throw new IllegalStateException("Should only be called during parsing!");
        }
    }

    /**
     * Makes sure a type is dereferenced.
     *
     * @param type the type to dereference
     * @return the dereferenced type
     */
    public DereferencedType dereference(Type type) {
        assertDereferencingSafe();
        if (type instanceof TypeRef tr) {
            return new DereferencedType(get(tr.refTypeName()), tr.validation());
        } else {
            return new DereferencedType(type, null);
        }
    }

    private void mapJse(boolean doMap, TypeName tn, Type t) {
        if (doMap) {
            mappedToJseTypes.put(tn, t);
        } else {
            unmappedToJseTypes.add(tn);
        }
    }

    /**
     * Maps type - if no mapping found, return input type
     * @param t
     * @return
     */
    public Type map(Type t) {
        Type mappedType = find(t.typeName());
        if (mappedType != null) {
            return mappedType;
        } else {
            return t;
        }
    }

    /**
     * Get a type from a type name.
     *
     * @param tn the type name to get
     * @return the associated type
     * @throws IllegalArgumentException if there is no type associated with the given type name
     */
    public Type get(TypeName tn) {
        assertParsing();
        Type t = find(tn);
        if (t == null) {
            throw new IllegalArgumentException("No type referenced found by name " + tn);
        }
        return t;
    }

    private Type find(TypeName tn) {
        Type jseType = mappedToJseTypes.get(tn);
        if (jseType != null) {
            logger.trace(" {} -> jse {}", tn, jseType);
            return jseType;
        }

        Type remappedType = remappedDtoTypes.get(tn);
        if (remappedType != null) {
            logger.trace(" {} -> remapped {}", tn, remappedType);
            return remappedType;
        }

        Dto dto = dtos.get(tn);
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
     * Get active DTOs.
     *
     * Returns list of DTO types that have not been mapped
     * to other types.
     * That is, DTOs that should be rendered.
     *
     * @return the list of DTOs to render.
     */
    public Set<Dto> getActiveDtos() {
        return dtos.entrySet().stream()
                .filter(e -> !mappedToJseTypes.containsKey(e.getKey()))
                .filter(e -> !remappedDtoTypes.containsKey(e.getKey()))
                .map(e -> e.getValue())
                .collect(toSet());
    }

    /**
     * Registers a new DTO.
     *
     * @param dtoRef the DTO reference to register.
     */
    public void addDto(TypeReference dtoRef) {
        Type refType = dtoRef.refType();
        if (refType instanceof Dto dto) {
            dtos.put(dto.openapiId(), dto);
        } else {
            throw new IllegalStateException("Trying to handle as DTO: " + refType);
        }
    }

    /**
     * Collection types such as ListDto are changed to {@code List<Dto>}.
     */
    public void consolidateDtos() {
        assertParsing();
        logger.info("Consolidate DTOs");
        for (Dto dto : getActiveDtos()) {
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
        StringBuilder sb = new StringBuilder("Types:").append(NL);

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
        dtos.keySet().stream()
            .sorted()
            .forEach(tn -> {
                Dto dto = dtos.get(tn);
                sb.append("  ").append(tn.name())
                    .append(": ").append(dto.name()).append(" - ").append(dto.dtoType()).append(NL);
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
