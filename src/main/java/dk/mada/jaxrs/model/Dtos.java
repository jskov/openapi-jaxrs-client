package dk.mada.jaxrs.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import dk.mada.jaxrs.model.types.DereferencedType;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeReference;

/**
 * DTOs in the model.
 */
public class Dtos {
    /** Newline. */
    private static final String NL = System.lineSeparator();

    /** DTOs from the specification. */
    private final Set<Dto> dtos;

    /**
     * Create a new instance.
     *
     * @param dtos the DTOs of the model
     */
    public Dtos(Collection<Dto> dtos) {
        this.dtos = Collections.unmodifiableSet(new HashSet<>(dtos));
    }

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

    /** {@return the DTOs to render} */
    public Set<Dto> getActiveDtos() {
        return dtos;
    }

    /** {@return information about the model} */
    public String info() {
        StringBuilder sb = new StringBuilder("Types:").append(NL);

        sb.append(" DTOs: ").append(NL);
        dtos.stream()
            .sorted((a, b) -> a.name().compareTo(b.name()))
            .forEach(dto -> {
                sb.append("  ").append(dto.name())
                    .append(": ").append(dto.dtoType()).append(NL);
            });

        return sb.toString();
    }
}
