package dk.mada.jaxrs.generator.mpclient.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.api.exceptions.GeneratorBadInputException;
import dk.mada.jaxrs.generator.mpclient.GeneratorOpts;
import dk.mada.jaxrs.generator.mpclient.GeneratorOpts.PropertyConflictResolution;
import dk.mada.jaxrs.generator.mpclient.imports.Imports;
import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.Property;
import dk.mada.jaxrs.model.Validation;
import dk.mada.jaxrs.model.types.Primitive;
import dk.mada.jaxrs.model.types.Type;

/**
 * Defines the subject matter of a DTO.
 */
public class DtoSubjectDefiner {
    private static final Logger logger = LoggerFactory.getLogger(DtoSubjectDefiner.class);

    /** The generator options. */
    private final GeneratorOpts opts;

    /** The selected conflict resolution. */
    private final PropertyConflictResolution resolution;

    DtoSubjectDefiner(GeneratorOpts opts) {
        this.opts = opts;

        resolution = opts.getPropertyConflictResolution();
    }

    record DtoSubject(Dto dto, Type type, boolean isEnum, boolean isPrimitiveEquals, Optional<String> extendsName,
            List<Property> properties, Imports imports) {
    }

    public DtoSubject defineDtoSubject(Dto dto) {
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
        String dtoName = dto.name();
        Map<String, Property> combinedProps = addCombinedProperties(dtoName, new HashMap<>(), dto);

        // If this Dto extends more than one other Dto
        // it cannot be done in Java. So fold properties
        // from the parents into this Dto.
        List<Dto> externalDtos = dto.extendsParents();
        if (externalDtos.size() > 1) {
            externalDtos.forEach(ed -> addCombinedProperties(dtoName, combinedProps, ed));

            if (logger.isDebugEnabled()) {
                List<String> extendsParentNames = externalDtos.stream()
                        .map(Dto::name)
                        .toList();

                logger.debug(" - {} now comines properties from {}", dto.name(), extendsParentNames);
            }
        }

        return List.copyOf(combinedProps.values());
    }

    private Map<String, Property> addCombinedProperties(String parentDtoName, Map<String, Property> combinedProps, Dto dto) {
        String dtoName = dto.name();
        for (Property newProp : dto.properties()) {
            String propName = newProp.name();
            logger.debug(" {} : {}", dtoName, propName);
            if (combinedProps.containsKey(propName)) {
                Property prevProp = combinedProps.get(propName);

                String msg = "Dto " + parentDtoName + " in conflict with subtype " + dtoName + " about property " + propName + " ";

                // Always assert that the types match. Cannot imagine this needs an option - and if so, it should be separate.
                Type prevType = prevProp.reference().refType();
                Type newType = newProp.reference().refType();
                if (!prevType.equals(newType)) {
                    GeneratorBadInputException.failBadInput(msg + "type", GeneratorOpts.GENERATOR_USE_PROPERTY_CONFLICT_RESOLUTION);
                }

                if (resolution == PropertyConflictResolution.FIRST) {
                    continue;
                }

                Validation resolvedVal = getV(prevProp);
                Validation newVal = getV(newProp);
                if (!resolvedVal.equals(newVal)) {
                    logger.warn("Must resolve validation!");
                    logger.debug("  new validation:  {}", newVal);
                    logger.debug("  conflicts with: {}", resolvedVal);
                    if (resolution == PropertyConflictResolution.CLEAR) {
                        resolvedVal = Validation.NO_VALIDATION;
                    } else if (resolution == PropertyConflictResolution.FAIL) {
                        GeneratorBadInputException.failBadInput(msg + "validation",
                                GeneratorOpts.GENERATOR_USE_PROPERTY_CONFLICT_RESOLUTION);
                    }
                }

                Optional<String> resolvedDescription = prevProp.description();
                Optional<String> newDescription = newProp.description();
                if (!resolvedDescription.equals(newDescription)) {
                    logger.warn("Must resolve description!");
                    logger.debug("  new description: {}", newDescription);
                    logger.debug("  conflicts with: {}", resolvedDescription);
                    if (resolution == PropertyConflictResolution.CLEAR) {
                        resolvedDescription = Optional.empty();
                    } else if (resolution == PropertyConflictResolution.FAIL) {
                        GeneratorBadInputException.failBadInput(msg + "description",
                                GeneratorOpts.GENERATOR_USE_PROPERTY_CONFLICT_RESOLUTION);
                    }
                }

                Optional<String> resolvedExample = prevProp.example();
                Optional<String> newExample = newProp.example();
                if (!resolvedExample.equals(newExample)) {
                    logger.warn("Must resolve example!");
                    logger.debug("  new example: {}", newExample);
                    logger.debug("  conflicts with: {}", resolvedExample);
                    if (resolution == PropertyConflictResolution.CLEAR) {
                        resolvedExample = Optional.empty();
                    } else if (resolution == PropertyConflictResolution.FAIL) {
                        GeneratorBadInputException.failBadInput(msg + "example", GeneratorOpts.GENERATOR_USE_PROPERTY_CONFLICT_RESOLUTION);
                    }
                }

                Property resolvedProp = Property.builderFrom(prevProp)
                        .description(resolvedDescription)
                        .example(resolvedExample)
                        .validation(resolvedVal)
                        .build();
                combinedProps.put(propName, resolvedProp);
            } else {
                combinedProps.put(propName, newProp);
            }
        }
        return combinedProps;
    }

    private Validation getV(Property p) {
        Validation v = p.validation();
        if (v.isEmptyValidation()) {
            v = p.reference().validation();
        }
        return v;
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
