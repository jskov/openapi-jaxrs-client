package dk.mada.jaxrs.model;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * DTOs in the model.
 */
public class Dtos {
    /** Newline. */
    private static final String NL = System.lineSeparator();

    /** DTOs from the specification. */
    private final Set<Dto> dtoItems;

    /**
     * Create a new instance.
     *
     * @param dtos the DTOs of the model
     */
    public Dtos(Collection<Dto> dtos) {
        this.dtoItems = Collections.unmodifiableSet(new HashSet<>(dtos));
    }

    /** {@return the DTOs to render} */
    public Set<Dto> getActiveDtos() {
        return dtoItems;
    }

    /** {@return information about the model} */
    public String info() {
        StringBuilder sb = new StringBuilder("Types:").append(NL);

        sb.append(" DTOs: ").append(NL);
        dtoItems.stream()
                .sorted((a, b) -> a.name().compareTo(b.name()))
                .forEach(dto -> {
                    sb.append("  ").append(dto.name())
                            .append(": ").append(dto.reference()).append(NL);
                    dto.properties().stream()
                            .sorted((a, b) -> a.name().compareTo(b.name()))
                            .forEach(prop -> sb.append("    ").append(prop.name()).append(": ").append(prop.reference()).append(NL));
                });

        return sb.toString();
    }
}
