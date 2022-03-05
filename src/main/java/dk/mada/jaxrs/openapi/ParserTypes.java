package dk.mada.jaxrs.openapi;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.types.Primitive;
import dk.mada.jaxrs.model.types.Type;
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

        Type remappedType = remappedDtoTypes.get(tn);
        if (remappedType != null) {
            logger.trace(" {} -> remapped {}", tn, remappedType);
            return remappedType;
        }
        */

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
