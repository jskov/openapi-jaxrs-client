package dk.mada.jaxrs.openapi;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
 *
 * The MP @Schema name is also changed, using its own namespace.
 * This is needed to avoid @Schema declaring a different name
 * than that assigned to the DTO.
 * May need a separate switch.
 */
public class ConflictRenamer {
    private static final Logger logger = LoggerFactory.getLogger(ConflictRenamer.class);

    /** Type names. */
    private final TypeNames typeNames;
    /** Naming. */
    private final Naming naming;
    /** Schema names in their OpenApi document declaration order. */
    private List<String> schemaNamesDeclarationOrder;
    /** Assigned type names. */
    private Set<String> namespaceTypes = new HashSet<>();
    /** Assigned MP schema names. */
    private Set<String> namespaceMpSchemas = new HashSet<>();

    /**
     * Constructs a new instance.
     *
     * @param typeNames the type names instance
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
    public Collection<Dto> renameDtos(Collection<Dto> dtos) {
        if (naming.isRenameCaseConflicts()) {
            logger.debug("Renaming DTOs to avoid on-disk conflicts");
            return dtos.stream()
                .sorted(this::schemaOrderComparitor)
                .map(this::assignUniqueName)
                .toList();
        } else {
            return dtos;
        }
    }
    
    public Map<String, String> getRemap() {
        return typeRenaming;
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
    
    private Map<String, String> typeRenaming = new HashMap<>();

    private Dto assignUniqueName(Dto dto) {
        String oldTypeName = dto.name();
        String newTypeName = assignUniqueName(namespaceTypes, oldTypeName);
        String newSchemaName = assignUniqueName(namespaceMpSchemas, dto.mpSchemaName());

        if (oldTypeName.equals(newTypeName)) {
            return dto;
        }
         
        typeNames.rename(oldTypeName, newTypeName);
        typeRenaming.put(oldTypeName, newTypeName);
        logger.info(" {} -> {}", oldTypeName, newTypeName);
        
        return Dto.builderFrom(dto)
                .typeName(typeNames.of(newTypeName))
                .name(newTypeName)
                .mpSchemaName(newSchemaName)
                .build();
    }

    private String assignUniqueName(Set<String> namespace, String name) {
        String newName = name;
        while (isInConflict(namespace, newName)) {
            newName = naming.renameConflictingName(newName);
        }
        namespace.add(newName);
        return newName;
    }

    private boolean isInConflict(Set<String> namespace, String name) {
        return namespace.stream()
                .anyMatch(s -> s.equalsIgnoreCase(name));
    }
}
