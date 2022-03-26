package dk.mada.jaxrs.openapi;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.Dtos;
import dk.mada.jaxrs.naming.Naming;

/**
 * Renames types to avoid on-disk conflicts.
 */
public class ConflictRenamer {
    private static final Logger logger = LoggerFactory.getLogger(ConflictRenamer.class);

    /** Naming. */
    private final Naming naming;

    private Set<String> assignedDtoNames = new HashSet<>();
    
    /**
     * Constructs a new instance.
     *
     * @param naming the naming instance
     */
    public ConflictRenamer(Naming naming) {
        this.naming = naming;
    }

    /**
     * Rename DTOs if necessary.
     *
     * @param dtos
     * @return
     */
    public Dtos renameDtos(List<Dto> dtos) {
        List<Dto> renamedDtos = dtos;
        if (naming.isRenameCaseConflicts()) {
            logger.debug("Renaming DTOs to avoid on-disk conflicts");
            renamedDtos = dtos.stream()
                .sorted((a, b) -> a.openapiId().compareTo(b.openapiId()))
                .map(this::assignUniqueName)
                .toList();
        }
        return new Dtos(renamedDtos);
    }

    private Dto assignUniqueName(Dto dto) {
        return Dto.builder().from(dto)
                .name(assignUniqueName(dto.name()))
                .build();
    }

    private String assignUniqueName(String name) {
        String newName = name;
        while (isInConflict(newName)) {
            newName = naming.renameConflictingName(newName);
        }
        assignedDtoNames.add(newName);

        if (!name.equals(newName)) {
            logger.debug(" {} -> {}", name, newName);
        }

        return newName;
    }

    private boolean isInConflict(String name) {
        return assignedDtoNames.stream()
                .anyMatch(s -> s.equalsIgnoreCase(name));
    }
}
