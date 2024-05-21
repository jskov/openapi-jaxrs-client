package dk.mada.jaxrs.generator.mpclient.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

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

    record DtoSubject(Dto dto, Type type, boolean isEnum, boolean isRecord, boolean isPrimitiveEquals, Optional<String> extendsName,
            List<Property> properties, Imports imports) {
    }

    /**
     * Defines a subject for the DTO.
     *
     * @param dto the DTO to define a subject for
     * @return the DTO subject
     */
    public DtoSubject defineDtoSubject(Dto dto) {
        Type dtoType = dto.reference().refType();
        
        boolean canRenderAsRecord = true;
        boolean isRecord = opts.isDtoRecords() && canRenderAsRecord;
        boolean isEnum = dto.isEnum();

        List<Property> propsToRender = findRenderedProperties(dto);

        boolean isPrimitiveEquals = isTypePrimitiveEquals(dtoType);
        Imports dtoImports;
        if (isEnum) {
            dtoImports = Imports.newEnum(opts, !isPrimitiveEquals);
        } else if (isRecord) {
            dtoImports = Imports.newRecord(opts, !propsToRender.isEmpty());
        } else {
            dtoImports = Imports.newDto(opts, !propsToRender.isEmpty());
        }

        dtoImports.addPropertyImports(propsToRender);

        if (logger.isDebugEnabled()) {
            logger.debug(" -- properties summary:");
            propsToRender
                    .forEach(p -> logger.debug(" {} : {}", p.name(), p.reference().refType()));
        }

        return new DtoSubject(dto, dtoType, isEnum, isRecord, isPrimitiveEquals, getExtends(dto), propsToRender, dtoImports);
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
        Map<String, OrderedProperty> combinedProps = addCombinedProperties(dtoName, new HashMap<>(), dto);

        // If this Dto extends more than one other Dto
        // it cannot be done in Java. So fold properties
        // from the parents into this Dto.
        Set<Dto> externalDtos = dto.extendsParents();
        if (externalDtos.size() > 1) {
            externalDtos.forEach(ed -> addCombinedProperties(dtoName, combinedProps, ed));
        }

        return combinedProps.values().stream()
                .sorted((a, b) -> Integer.compare(a.order, b.order))
                .map(OrderedProperty::prop)
                .toList();
    }

    /**
     * Wrapper for the property keeping track of the order the property was discovered in.
     *
     * @param order the OpenApi document order-index of the property
     * @param prop  the property
     */
    record OrderedProperty(int order, Property prop) {
    }

    private Map<String, OrderedProperty> addCombinedProperties(String parentDtoName, Map<String, OrderedProperty> combinedProps, Dto dto) {
        String dtoName = dto.name();
        for (Property newProp : dto.properties()) {
            String propName = newProp.name();
            String propSrc = parentDtoName.equals(dtoName) ? parentDtoName : parentDtoName + "/" + dtoName;
            logger.debug(" {} : {}", propSrc, propName);
            if (combinedProps.containsKey(propName)) {
                OrderedProperty prevOrderedProp = combinedProps.get(propName);
                Property prevProp = prevOrderedProp.prop();

                String msg = "Dto " + parentDtoName + " in conflict with subtype " + dtoName + " about property " + propName + " ";

                assertSameType(msg, prevProp, newProp);

                if (resolution == PropertyConflictResolution.FIRST) {
                    continue;
                }

                Validation resolvedValidation = getResolvedValidation(msg, prevProp, newProp);
                Optional<String> resolvedDescription = getResolvedDescription(msg, prevProp, newProp);
                Optional<String> resolvedExample = getResolvedExample(msg, prevProp, newProp);

                Property resolvedProp = Property.builderFrom(prevOrderedProp.prop)
                        .description(resolvedDescription)
                        .example(resolvedExample)
                        .validation(resolvedValidation)
                        .build();
                combinedProps.put(propName, new OrderedProperty(prevOrderedProp.order, resolvedProp));
            } else {
                int propertyNumber = combinedProps.size();
                combinedProps.put(propName, new OrderedProperty(propertyNumber, newProp));
            }
        }
        return combinedProps;
    }

    private void assertSameType(String conflictionMsg, Property prevProp, Property newProp) {
        // Always assert that the types match. Cannot imagine this needs an option - and if so, it should be separate.
        Type prevType = prevProp.reference().refType();
        Type newType = newProp.reference().refType();
        if (!prevType.equals(newType)) {
            GeneratorBadInputException.failBadInput(conflictionMsg + "type", GeneratorOpts.GENERATOR_USE_PROPERTY_CONFLICT_RESOLUTION);
        }
    }

    private Validation getResolvedValidation(String conflictionMsg, Property prevProp, Property newProp) {
        Validation resolvedValidation = getV(prevProp);
        Validation newValidation = getV(newProp);
        if (!resolvedValidation.equals(newValidation)) {
            if (resolution == PropertyConflictResolution.CLEAR) {
                logger.debug("  clearing valiation: {} / {}", resolvedValidation, newValidation);
                resolvedValidation = Validation.NO_VALIDATION;
            } else if (resolution == PropertyConflictResolution.FAIL) {
                GeneratorBadInputException.failBadInput(conflictionMsg + "validation",
                        GeneratorOpts.GENERATOR_USE_PROPERTY_CONFLICT_RESOLUTION);
            }
        }
        return resolvedValidation;
    }

    private Validation getV(Property p) {
        Validation v = p.validation();
        if (v.isEmptyValidation()) {
            v = p.reference().validation();
        }
        return v;
    }

    private Optional<String> getResolvedDescription(String conflictionMsg, Property prevProp, Property newProp) {
        Optional<String> resolvedDescription = prevProp.description();
        Optional<String> newDescription = newProp.description();
        if (!resolvedDescription.equals(newDescription)) {
            if (resolution == PropertyConflictResolution.CLEAR) {
                logger.debug("  clearing description: {} / {}", resolvedDescription, newDescription);
                resolvedDescription = Optional.empty();
            } else if (resolution == PropertyConflictResolution.FAIL) {
                GeneratorBadInputException.failBadInput(conflictionMsg + "description",
                        GeneratorOpts.GENERATOR_USE_PROPERTY_CONFLICT_RESOLUTION);
            }
        }
        return resolvedDescription;
    }

    private Optional<String> getResolvedExample(String conflictionMsg, Property prevProp, Property newProp) {
        Optional<String> resolvedExample = prevProp.example();
        Optional<String> newExample = newProp.example();
        if (!resolvedExample.equals(newExample)) {
            if (resolution == PropertyConflictResolution.CLEAR) {
                logger.debug("  clearing example: {} / {}", resolvedExample, newExample);
                resolvedExample = Optional.empty();
            } else if (resolution == PropertyConflictResolution.FAIL) {
                GeneratorBadInputException.failBadInput(conflictionMsg + "example",
                        GeneratorOpts.GENERATOR_USE_PROPERTY_CONFLICT_RESOLUTION);
            }
        }
        return resolvedExample;
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
        String dtoName = dto.name();
        Set<Dto> parents = dto.extendsParents();
        logger.debug("See DTO {} with parents {}", dtoName, parents);

        if (parents.size() == 1) {
            String singleParentName = parents.iterator().next().name();
            logger.debug(" : single parent {}", singleParentName);
            return Optional.of(singleParentName);
        } else {
            if (logger.isDebugEnabled()) {
                parents.forEach(p -> logger.debug(" parent {} : {}", p.openapiId(), p));
            }
        }
        return Optional.empty();
    }
}
