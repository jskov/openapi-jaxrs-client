package dk.mada.jaxrs.openapi;

import static java.util.stream.Collectors.toMap;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.types.TypeName;
import dk.mada.jaxrs.model.types.TypeNames;
import dk.mada.jaxrs.model.types.TypePlainObject;
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

    /** Naming. */
    private final Naming naming;
    /** Schema names in their OpenApi document declaration order. */
    private List<String> schemaNamesDeclarationOrder;
    /** Assigned type names. */
    private Set<String> namespaceTypes = new HashSet<>();
    /** Assigned MP schema names. */
    private Set<String> namespaceMpSchemas = new HashSet<>();

    private Map<String, ConflictRenamed> renameMap = Map.of();

    private Map<Dto, Dto> conflictRenamedDtos;

    private final TypeNames typeNames;

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
    public Collection<Dto> computeDtoNameOverrides(Collection<Dto> dtos) {
        if (naming.isRenameCaseConflicts()) {
            logger.debug("Renaming DTOs to avoid on-disk conflicts");
            renameMap = dtos.stream()
                    .sorted(this::schemaOrderComparitor)
                    .map(this::assignUniqueName)
                    .filter(cr -> cr != null)
                    .collect(toMap(cr -> cr.originalDtoName(), cr -> cr));
        }
        
        conflictRenamedDtos = dtos.stream()
            .collect(toMap(dto -> dto, dto -> renameDto(dto)));

        return conflictRenamedDtos.values();
    }
    
    public Dto getConflictRenamedDto(Dto dto) {
        if (conflictRenamedDtos == null) {
            return dto;
        }
        // This handles some breakage in the TypeConverter
        // plain Object? Triggered by the primitives test.
        if (dto.typeName().equals(TypeNames.OBJECT)) {
            return dto;
        }
        Dto renamedDto = conflictRenamedDtos.get(dto);
        if (renamedDto == null) {
            throw new IllegalStateException("Did not find renamed DTO for " + dto.name());
        }
        return renamedDto;
    }

    private Dto renameDto(Dto dto) {
        final String originalName = dto.name();

        String name = originalName;
        TypeName typeName = dto.typeName();
        String mpSchemaName = dto.mpSchemaName();

        ConflictRenamed renaming = renameMap.get(originalName);
        if (renaming != null) {
            name = renaming.dtoName();
            typeName = typeNames.of(name);
            mpSchemaName = renaming.mpSchemaName();
            logger.info(" - renaming DTO {} -> {}/{}", originalName, name, mpSchemaName);
        }
        
        return Dto.builderFrom(dto)
                .typeName(typeName)
                .name(name)
                .mpSchemaName(mpSchemaName)
                .build();
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
    
    record ConflictRenamed(String originalDtoName, String dtoName, String mpSchemaName) {
    }
    
    private ConflictRenamed assignUniqueName(Dto dto) {
        String oldTypeName = dto.name();
        String oldMpSchemaName = dto.mpSchemaName();

        String newTypeName = assignUniqueName(namespaceTypes, oldTypeName);
        String newMpSchemaName = assignUniqueName(namespaceMpSchemas, oldMpSchemaName);

        if (oldTypeName.equals(newTypeName)
                && oldMpSchemaName.equals(newMpSchemaName)) {
            return null;
        }
         
        ConflictRenamed cr = new ConflictRenamed(oldTypeName, newTypeName, newMpSchemaName);
        logger.info(" {} -> {}", oldTypeName, cr);
        return cr;
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
