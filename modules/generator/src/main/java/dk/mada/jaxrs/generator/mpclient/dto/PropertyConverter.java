package dk.mada.jaxrs.generator.mpclient.dto;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.generator.api.exceptions.GeneratorBadInputException;
import dk.mada.jaxrs.generator.mpclient.GeneratorOpts;
import dk.mada.jaxrs.generator.mpclient.GeneratorOpts.PropertyConflictResolution;
import dk.mada.jaxrs.generator.mpclient.GeneratorOpts.PropertyOrder;
import dk.mada.jaxrs.generator.mpclient.dto.DtoSubjectDefiner.DtoSubjectBase;
import dk.mada.jaxrs.generator.mpclient.dto.tmpl.CtxProperty;
import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.Property;
import dk.mada.jaxrs.model.Validation;
import dk.mada.jaxrs.model.types.Type;

/**
 * Converts DTO properties to CtxProperties.
 */
public class PropertyConverter {
    private static final Logger logger = LoggerFactory.getLogger(PropertyConverter.class);

    /** The property generator. */
    private final PropertyGenerator propertyGenerator;
    /** The property order. */
    private final PropertyOrder order;
    /** The selected conflict resolution. */
    private final PropertyConflictResolution resolution;

    /**
     * Constructs new instance.
     *
     * @param opts              the generator options
     * @param propertyGenerator the property generator
     */
    public PropertyConverter(GeneratorOpts opts, PropertyGenerator propertyGenerator) {
        this.propertyGenerator = propertyGenerator;
        order = opts.getPropertyOrder();
        resolution = opts.getPropertyConflictResolution();
    }

    record DtoCtxProps(List<CtxProperty> props, List<CtxProperty> propsOpenapiOrder) {
    }

    public DtoCtxProps defineCtxProperties(DtoSubjectBase base) {
        List<Property> propsToRender = findRenderedProperties(base.dto());

        base.imports().addPropertyImports(propsToRender);

        Comparator<? super CtxProperty> propertySorter = propertySorter();

        Stream<CtxProperty> propsStream = propsToRender.stream()
                .map(p -> propertyGenerator.toCtxProperty(base, p));

        if (propertySorter != null) {
            propsStream = propsStream.sorted(propertySorter);
        }
        List<CtxProperty> props = propsStream.toList();
        List<CtxProperty> ctxPropsOpenapiOrder = getPropsOpenApiOrder(propsToRender, props);

        if (logger.isDebugEnabled()) {
            logger.debug(" -- properties summary:");
            propsToRender
                    .forEach(p -> logger.debug(" {} : {}", p.name(), p.reference().refType()));
        }

        return new DtoCtxProps(props, ctxPropsOpenapiOrder);
    }

    private List<CtxProperty> getPropsOpenApiOrder(List<Property> propsToRender, List<CtxProperty> props) {
        // Make the context properties accessible by name
        Map<String, CtxProperty> byName = props.stream()
                .collect(Collectors.toMap(CtxProperty::baseName, p -> p));

        // Then map the openapi properties to context properties, keeping the order
        return propsToRender.stream()
                .map(p -> byName.get(p.name()))
                .toList();
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

    private @Nullable Comparator<? super CtxProperty> propertySorter() {
        switch (order) {
        case DOCUMENT_ORDER:
            return null;
        case ALPHABETICAL_ORDER:
            return (a, b) -> a.name().compareTo(b.name());
        case ALPHABETICAL_NOCASE_ORDER:
            return (a, b) -> a.name().compareToIgnoreCase(b.name());
        default:
            throw new IllegalStateException("Unhandled ordering " + order);
        }
    }
}
