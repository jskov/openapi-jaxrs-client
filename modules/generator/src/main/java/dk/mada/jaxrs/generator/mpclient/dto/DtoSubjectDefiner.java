package dk.mada.jaxrs.generator.mpclient.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.mpclient.GeneratorOpts;
import dk.mada.jaxrs.generator.mpclient.imports.Imports;
import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.Property;
import dk.mada.jaxrs.model.types.Primitive;
import dk.mada.jaxrs.model.types.Type;

/**
 * Defines the subject matter of a DTO.
 */
public class DtoSubjectDefiner {
    private static final Logger logger = LoggerFactory.getLogger(DtoSubjectDefiner.class);

    record DtoSubject(Dto dto, Type type, boolean isEnum, boolean isPrimitiveEquals, Optional<String> extendsName,
            List<Property> properties, Imports imports) {
    }

    public DtoSubject defineDtoSubject(GeneratorOpts opts, Dto dto) {
        Type dtoType = dto.reference().refType();
        boolean isEnum = dto.isEnum();

        boolean isPrimitiveEquals = isTypePrimitiveEquals(dtoType);
        var dtoImports = isEnum ? Imports.newEnum(opts, !isPrimitiveEquals) : Imports.newDto(opts);

        List<Property> propsToRender = findRenderedProperties(dto);
        dtoImports.addPropertyImports(propsToRender);

        return new DtoSubject(dto, dtoType, isEnum, isPrimitiveEquals, getExtends(dto), propsToRender, dtoImports);
    }

    private boolean isTypePrimitiveEquals(Type t) {
        return t.isPrimitive(Primitive.INT);
    }

    /**
     * Returns list of properties to render for the Dto.
     *
     * If the Dto has multiple parents, the properties of these parents are folded into this Dto's properties (because it
     * cannot extend multiple parents).
     *
     * @param dto the Dto to get properties for
     * @return the properties to be rendered for the Dto
     */
    private List<Property> findRenderedProperties(Dto dto) {
        Map<String, Property> combinedProps = addCombinedProperties(new HashMap<>(), dto);

        // If this Dto extends more than one other Dto
        // it cannot be done in Java. So fold properties
        // from the parents into this Dto.
        List<Dto> externalDtos = dto.extendsParents();
        if (externalDtos.size() > 1) {
            externalDtos.forEach(ed -> addCombinedProperties(combinedProps, ed));

            if (logger.isDebugEnabled()) {
                List<String> extendsParentNames = externalDtos.stream()
                        .map(Dto::name)
                        .toList();

                logger.debug(" - {} now comines properties from {}", dto.name(), extendsParentNames);
            }
        }

        return List.copyOf(combinedProps.values());
    }

    private Map<String, Property> addCombinedProperties(Map<String, Property> combinedProps, Dto dto) {
    	
    	dto.properties().forEach(p -> combinedProps.put(p.name(), p));
    	return combinedProps;
    }
    
    /**
     * Compute if the Dto should extend a parent.
     *
     * This is only relevant if the Dto has exactly one parent Dto.
     *
     * Otherwise the properties of parent Dtos will be folded into the Dto.
     *
     * @param dto the Dto to compute extends for.
     * @return an optional parent Dto name
     * @see findRenderedProperties
     */
    private Optional<String> getExtends(Dto dto) {
        if (dto.extendsParents().size() == 1) {
            return Optional.of(dto.extendsParents().get(0).name());
        }
        return Optional.empty();
    }

}
