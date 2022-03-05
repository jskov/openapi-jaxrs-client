package dk.mada.jaxrs.model.types;

import static java.util.stream.Collectors.toSet;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.types.TypeNames.TypeName;

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
    /** DTOs from the specification. */
    private final Map<TypeName, Dto> dtos = new HashMap<>();
    /**
     * Types that (via their type name) have been mapped to
     * some other types.
     */
    private final Map<TypeName, Type> remappedDtoTypes = new HashMap<>();

    /**
     * Makes sure a type is dereferenced.
     *
     * @param type the type to dereference
     * @return the dereferenced type
     */
    public DereferencedType dereference(Type type) {
        if (type instanceof TypeReference tr) {
            return new DereferencedType(tr.refType(), tr.validation());
        } else {
            return new DereferencedType(type, null);
        }
    }

    /**
     * Maps type - if no mapping found, return input type
     * @param t
     * @return
     */
    public Type map(Type t) {
        logger.info("Bad call", new IllegalStateException("call ParserTypes"));
        Type mappedType = find(t.typeName());
        if (mappedType != null) {
            return mappedType;
        } else {
            return t;
        }
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

    /** {@return information about the model} */
    public String info() {
        StringBuilder sb = new StringBuilder("Types:").append(NL);

        sb.append(" DTOs: ").append(NL);
        dtos.keySet().stream()
            .sorted()
            .forEach(tn -> {
                Dto dto = dtos.get(tn);
                sb.append("  ").append(tn.name())
                    .append(": ").append(dto.name()).append(" - ").append(dto.dtoType()).append(NL);
            });

        return sb.toString();
    }
}
