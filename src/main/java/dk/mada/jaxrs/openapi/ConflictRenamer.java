package dk.mada.jaxrs.openapi;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.Dtos;
import dk.mada.jaxrs.model.types.TypeNames;
import dk.mada.jaxrs.naming.Naming;

/**
 * Renames types to avoid on-disk conflicts.
 *
 * It changes the name of DTOs and adds renaming mapping
 * to the TypeNames so the generators will get the new
 * names.
 */
public class ConflictRenamer {
    private static final Logger logger = LoggerFactory.getLogger(ConflictRenamer.class);

    /** Type names. */
    private final TypeNames typeNames;
    /** Naming. */
    private final Naming naming;

    /** Assigned DTO names. */
    private Set<String> assignedDtoNames = new HashSet<>();
    /** Schema names in their OpenApi document declaration order. */
    private List<String> schemaNamesDeclarationOrder;


    /**
     * Constructs a new instance.
     *
     * @param naming the naming instance
     * @param schemaNamesDeclarationOrder the OpenApi schema declaration order
     */
    public ConflictRenamer(TypeNames typeNames, Naming naming, List<String> schemaNamesDeclarationOrder) {
        this.typeNames = typeNames;
        this.naming = naming;
        this.schemaNamesDeclarationOrder = schemaNamesDeclarationOrder;
    }

    /**
     * Rename DTOs if necessary.
     *
     * @param dtos the DTOs to rename
     * @return the renamed DTOs
     */
    public Dtos renameDtos(List<Dto> dtos) {
        List<Dto> renamedDtos = dtos;
        if (naming.isRenameCaseConflicts()) {
            logger.debug("Renaming DTOs to avoid on-disk conflicts");
            renamedDtos = dtos.stream()
                .sorted(this::schemaOrderComparitor)
                .map(this::assignUniqueName)
                .toList();
        }
        return new Dtos(renamedDtos);
    }

    /**
     * Order two DTOs by either their name or their declaration
     * order in the OpenApi document.
     *
     * @param a the first DTO
     * @param b the second DTO
     * @return their comparison order
     */
    private int schemaOrderComparitor(Dto a, Dto b) {
        switch (naming.getRenameCaseConflictSchemaOrder()) {
        case DOCUMENT_ORDER:
            int aIndex = schemaNamesDeclarationOrder.indexOf(a.openapiId().name());
            int bIndex = schemaNamesDeclarationOrder.indexOf(b.openapiId().name());
            return Integer.compare(aIndex, bIndex);
        case NAME_ORDER:
            return a.openapiId().compareTo(b.openapiId());
        default:
            throw new IllegalStateException("Unhandled schema order " + naming.getRenameCaseConflictSchemaOrder());
        }

    }

    private Dto assignUniqueName(Dto dto) {
        return Dto.builderFrom(dto)
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
            typeNames.rename(name, newName);
            logger.debug(" {} -> {}", name, newName);
        }

        return newName;
    }

    private boolean isInConflict(String name) {
        return assignedDtoNames.stream()
                .anyMatch(s -> s.equalsIgnoreCase(name));
    }
}
