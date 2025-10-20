package dk.mada.jaxrs.generator.mpclient.dto;

import dk.mada.jaxrs.generator.mpclient.GeneratorOpts;
import dk.mada.jaxrs.generator.mpclient.dto.PropertyConverter.DtoCtxProps;
import dk.mada.jaxrs.generator.mpclient.dto.tmpl.CtxProperty;
import dk.mada.jaxrs.generator.mpclient.imports.Imports;
import dk.mada.jaxrs.generator.mpclient.imports.Jackson;
import dk.mada.jaxrs.generator.mpclient.imports.Jsonb;
import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.SubtypeSelector;
import dk.mada.jaxrs.model.types.Primitive;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeContainer;
import dk.mada.jaxrs.model.types.TypeMap;
import dk.mada.jaxrs.model.types.TypeName;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Defines the subject matter of a DTO.
 */
public class DtoSubjectDefiner {
    private static final Logger logger = LoggerFactory.getLogger(DtoSubjectDefiner.class);

    /** The generator options. */
    private final GeneratorOpts opts;
    /** The property converter. */
    private final PropertyConverter propertyConverter;

    /**
     * Constructs a new instance.
     *
     * @param opts              the generator options
     * @param propertyConverter the property converter
     */
    DtoSubjectDefiner(GeneratorOpts opts, PropertyConverter propertyConverter) {
        this.opts = opts;
        this.propertyConverter = propertyConverter;
    }

    /**
     * The base parts of a DTO subject.
     *
     * @param dto      the DTO
     * @param type     the DTO type
     * @param isEnum   flag for enums
     * @param isRecord flag for records
     * @param imports  the imports for the DTO
     */
    record DtoSubjectBase(Dto dto, Type type, boolean isEnum, boolean isRecord, Imports imports) {}

    /**
     * The DTO subject
     *
     * @param base              the subject base
     * @param isPrimitiveEquals flag for use of primitive equals
     * @param extendsName       optional type this DTO extends
     * @param subtypeSelector   optional subtype selector (would be parent type for those with extends)
     * @param ctxProperties     the ctx properties of the DTO
     */
    record DtoSubject(
            DtoSubjectBase base,
            boolean isPrimitiveEquals,
            Optional<String> extendsName,
            Optional<SubtypeSelector> subtypeSelector,
            DtoCtxProps ctxProperties) {
        public Imports imports() {
            return base.imports();
        }

        public Dto dto() {
            return base.dto();
        }

        public Type type() {
            return base.type();
        }

        public List<CtxProperty> ctxProps() {
            return ctxProperties.props();
        }

        public List<CtxProperty> ctxPropsOpenApiOrder() {
            return ctxProperties.propsOpenapiOrder();
        }
    }

    /**
     * Defines a subject for the DTO.
     *
     * @param dto the DTO to define a subject for
     * @return the DTO subject
     */
    public DtoSubject defineDtoSubject(Dto dto) {
        Type dtoType = dto.reference().refType();

        // Parent extension is a parameter for determining DTO rendering type - so needs to be computed early, imports
        // added later
        Optional<String> extendsParent = getExtends(dto);
        Optional<SubtypeSelector> subtypeSelector = dto.subtypeSelector();

        boolean canRenderAsRecord = extendsParent.isEmpty() && subtypeSelector.isEmpty();
        boolean isRecord = opts.isDtoRecords() && canRenderAsRecord;
        boolean isEnum = dto.isEnum();

        boolean isPrimitiveEquals = isTypePrimitiveEquals(dtoType);
        Imports dtoImports;
        if (isEnum) {
            dtoImports = Imports.newEnum(opts, !isPrimitiveEquals);
        } else if (isRecord) {
            dtoImports = Imports.newRecord(opts);
        } else {
            dtoImports = Imports.newDto(opts);
        }

        // Now imports are available, add for those needed by DTOs extending a container
        if (!extendsParent.isEmpty()
                && dto.reference().refType() instanceof TypeContainer tc) {
            dtoImports.addContainerImplementationType(tc);
            dtoImports.add(tc.innerType());
        }

        DtoSubjectBase base = new DtoSubjectBase(dto, dtoType, isEnum, isRecord, dtoImports);
        DtoCtxProps dtoProps = propertyConverter.defineCtxProperties(base);

        if (!dtoProps.props().isEmpty()) {
            dtoImports.add(Jackson.JSON_PROPERTY, Jsonb.JSONB_PROPERTY);
        }

        return new DtoSubject(base, isPrimitiveEquals, extendsParent, subtypeSelector, dtoProps);
    }

    private boolean isTypePrimitiveEquals(Type t) {
        return t.isPrimitive(Primitive.INT);
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
        Set<Type> extendsTypes = dto.extendsTypes();
        logger.debug("See DTO {} with parents {}", dtoName, extendsTypes);

        if (extendsTypes.size() == 1) {
            Type singleParentType = List.copyOf(extendsTypes).getFirst();
            String singleParentName;
            if (singleParentType instanceof TypeContainer tc) {
                singleParentName = tc.containerImplementationDeclaration();
            } else {
                singleParentName = singleParentType.typeName().name();
            }
            logger.debug(" : single parent {}", singleParentName);
            return Optional.of(singleParentName);
        } else {
            if (logger.isDebugEnabled()) {
                extendsTypes.forEach(p -> {
                    TypeName tn = p.typeName();
                    if (p instanceof Dto d) {
                        tn = d.openapiId();
                    }
                    logger.debug(" parent {} : {}", tn, p);
                });
            }
        }
        return Optional.empty();
    }
}
