package dk.mada.jaxrs.openapi;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toSet;

import dk.mada.jaxrs.model.Dto;
import dk.mada.jaxrs.model.naming.Naming;
import dk.mada.jaxrs.model.types.Primitive;
import dk.mada.jaxrs.model.types.Reference;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeArray;
import dk.mada.jaxrs.model.types.TypeBigDecimal;
import dk.mada.jaxrs.model.types.TypeByteArray;
import dk.mada.jaxrs.model.types.TypeDate;
import dk.mada.jaxrs.model.types.TypeDateTime;
import dk.mada.jaxrs.model.types.TypeInterface;
import dk.mada.jaxrs.model.types.TypeLocalTime;
import dk.mada.jaxrs.model.types.TypeName;
import dk.mada.jaxrs.model.types.TypeNames;
import dk.mada.jaxrs.model.types.TypePlainObject;
import dk.mada.jaxrs.model.types.TypeReference;
import dk.mada.jaxrs.model.types.TypeSet;
import dk.mada.jaxrs.model.types.TypeUUID;
import dk.mada.jaxrs.openapi.Parser.LeakedGeneratorOpts;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Types found while parsing.
 *
 * This is only used to collect the types. When parsing is completed, they will be moved to the model's Types container
 * after being resolved and mapped.
 */
public class ParserTypes {
    private static final Logger logger = LoggerFactory.getLogger(ParserTypes.class);

    /** Newline. */
    private static final String NL = System.lineSeparator();

    /** The type names. */
    private final TypeNames typeNames;

    /** DTOs parsed from the specification. */
    private final Map<TypeName, Dto> parsedDtos = new HashMap<>();

    /** Interfaces needed by the DTOs. */
    private final Map<TypeName, TypeInterface> interfaces = new HashMap<>();

    /**
     * Types mapped to JSE standard types.
     */
    private final Map<TypeName, Type> mappedToJseTypes = new HashMap<>();

    /**
     * JSE standard types that were not mapped (because the user opted to keep them as DTOs).
     */
    private final Set<TypeName> unmappedToJseTypes = new HashSet<>();

    /**
     * Types that (via their type name) have been mapped to some other types.
     */
    private final Map<TypeName, Type> remappedDtoTypes = new HashMap<>();

    /** The DTO package name. */
    private final String dtoPackageName;

    /**
     * Create new instance.
     *
     * @param typeNames     the type names instance
     * @param parserOpts    the parser options
     * @param leakedGenOpts the leaked generator options
     */
    public ParserTypes(TypeNames typeNames, ParserOpts parserOpts, LeakedGeneratorOpts leakedGenOpts) {
        this.typeNames = typeNames;
        TypeDateTime typeDateTime = leakedGenOpts.dateTimeType();

        dtoPackageName = leakedGenOpts.dtoPackage();

        mapJse(true, TypeNames.OBJECT, TypePlainObject.get());
        mapJse(parserOpts.isJseBigDecimal(), TypeNames.BIG_DECIMAL, TypeBigDecimal.get());
        mapJse(parserOpts.isJseInputStream(), TypeNames.INPUT_STREAM, TypeByteArray.getStream());
        mapJse(parserOpts.isJseUUID(), TypeNames.UUID, TypeUUID.get());
        mapJse(parserOpts.isJseLocalDate(), TypeNames.LOCAL_DATE, TypeDate.get());
        mapJse(parserOpts.isJseLocalTime(), TypeNames.LOCAL_TIME, TypeLocalTime.get());
        mapJse(parserOpts.isJseLocalDateTime(), TypeNames.LOCAL_DATE_TIME, typeDateTime);
        mapJse(parserOpts.isJseOffsetDateTime(), TypeNames.OFFSET_DATE_TIME, typeDateTime);
        mapJse(parserOpts.isJseZonedDateTime(), TypeNames.ZONED_DATE_TIME, typeDateTime);

        logger.debug("JSE type overrides: {}", mappedToJseTypes.keySet());
        logger.debug("JSE types kept: {}", unmappedToJseTypes);
    }

    private void mapJse(boolean doMap, TypeName tn, Type t) {
        if (doMap) {
            mappedToJseTypes.put(tn, t);
        } else {
            unmappedToJseTypes.add(tn);
        }
    }

    /**
     * Get or make a new interface type.
     *
     * @param tn        the type name of the interface
     * @param anyOfRefs the types referenced by the interface
     * @return an existing or new interface type
     */
    public TypeInterface getOrMakeInterface(TypeName tn, List<ParserTypeRef> anyOfRefs) {
        Set<TypeName> usedTypeNames =
                anyOfRefs.stream().map(ParserTypeRef::typeName).collect(toSet());
        return interfaces.computeIfAbsent(tn, k -> TypeInterface.of(dtoPackageName, tn, usedTypeNames));
    }

    /** {@return all the interfaces} */
    public Set<TypeInterface> getInterfaces() {
        return interfaces.values().stream().collect(toSet());
    }

    /**
     * {@return the interfaces implemented by a given type name}
     *
     * @param tn the type name to look for.
     **/
    public List<TypeInterface> getInterfacesImplementedBy(TypeName tn) {
        return interfaces.values().stream()
                .filter(ti -> ti.implementations().contains(tn))
                .sorted((a, b) -> a.typeName().compareTo(b.typeName()))
                .toList();
    }

    /**
     * Registers a new DTO.
     *
     * @param dto the DTO to register.
     */
    public void addDto(Dto dto) {
        parsedDtos.put(dto.openapiId(), dto);
    }

    /** {@return the defined DTOs} */
    public Set<Dto> getActiveDtos() {
        return parsedDtos.entrySet().stream()
                .filter(e -> !mappedToJseTypes.containsKey(e.getKey()))
                .filter(e -> !remappedDtoTypes.containsKey(e.getKey()))
                .filter(e -> excludeInternalDtoProperties(e.getKey()))
                .map(Entry::getValue)
                .collect(toSet());
    }

    private boolean excludeInternalDtoProperties(TypeName tn) {
        return !tn.name().contains(Naming.PARSER_INTERNAL_PROPERTIES_NAME_MARKER);
    }

    /**
     * Get a type from a type name.
     *
     * @param tn the type name to get
     * @return the associated type
     * @throws IllegalArgumentException if there is no type associated with the given type name
     */
    public Type get(TypeName tn) {
        return find(tn).orElseThrow(
                        () -> new IllegalArgumentException("No type referenced found by name " + tn.name()));
    }

    /**
     * Find a type from a type name.
     *
     * @param tn the type name to get
     * @return the associated type, or empty
     */
    public Optional<Type> find(TypeName tn) {
        String conversion = "na";
        String name = tn.name();

        Type type = mappedToJseTypes.get(tn);
        if (type != null) {
            conversion = "jse";
        }

        if (type == null) {
            type = remappedDtoTypes.get(tn);
            if (type != null) {
                conversion = "remapped";

                // now lookup again, as the type may have been remapped more than once
                while (true) {
                    Type derefType = remappedDtoTypes.get(type.typeName());
                    if (derefType == type || derefType == null) {
                        break;
                    } else {
                        // go around again
                        type = derefType;
                    }
                }
            }
        }

        if (type == null) {
            type = parsedDtos.get(tn);
            if (type != null) {
                conversion = "dto";
            }
        }

        if (type == null) {
            type = Primitive.find(tn);
            if (type != null) {
                conversion = "primitive";
            }
        }

        logger.debug("find {} -> {} : {}", name, conversion, type);
        return Optional.ofNullable(type);
    }

    /**
     * Collection types such as ListDto are changed to {@code List<Dto>}.
     */
    public void consolidateContainerDtos() {
        logger.debug("== Consolidate container DTOs");
        for (Dto dto : parsedDtos.values()) {
            String name = dto.name();
            Reference ref = dto.reference();
            Type type = ref.refType();

            TypeName openapiName = dto.openapiId();

            Type newType;
            if (type instanceof TypeArray ta) {
                newType = remapDto(openapiName, TypeArray.of(typeNames, ta.innerType()));
            } else if (type instanceof TypeSet ts) {
                newType = remapDto(openapiName, TypeSet.of(typeNames, ts.innerType()));
            } else {
                // Note that TypeMap is not changed
                newType = null;
            }

            if (newType != null) {
                logger.debug(" : remapped {} : {}", name, newType);
            } else {
                logger.debug(" : keep {}", name);
            }
        }
    }

    /**
     * Remaps a DTO to a new type.
     *
     * The target type gets stripped from empty validation references.
     *
     * @param openapiName the DTOs OpenApi name
     * @param newType     the type to remap the DTO to
     * @return the actual type remapped to (may have fewer validation references)
     */
    public Type remapDto(TypeName openapiName, Type newType) {
        Type targetType = newType;

        // Flatten targets that are just reference pointers
        boolean replaced;
        do {
            replaced = false;
            if (targetType instanceof TypeReference tr && tr.validation().isEmptyValidation()) {
                logger.trace("  removing empty reference!");
                targetType = tr.refType();
                replaced = true;
            }
        } while (replaced);

        logger.debug("  remap {} to {}", openapiName, targetType);

        Type oldType = remappedDtoTypes.put(openapiName, targetType);
        if (oldType != null) {
            throw new IllegalStateException(
                    "Dto " + openapiName + " remapped twice from " + oldType + " to " + targetType);
        }

        return targetType;
    }

    /** {@return information about the model} */
    public String info() {
        StringBuilder sb = new StringBuilder("Parser Types:").append(NL);
        sb.append(" Unmapped JSE: ");
        sb.append(unmappedToJseTypes.stream().sorted().map(TypeName::name).collect(joining(", ")))
                .append(NL);

        sb.append(" Mapped JSE: ").append(NL);
        mappedToJseTypes.keySet().stream().sorted().forEach(tn -> {
            Type t = mappedToJseTypes.get(tn);
            sb.append("  ").append(tn.name()).append(": ").append(t).append(NL);
        });

        sb.append(" Interfaces:").append(NL);
        interfaces.entrySet().stream()
                .sorted((a, b) -> a.getKey().compareTo(b.getKey()))
                .forEach(e -> {
                    TypeName tn = e.getKey();
                    TypeInterface ints = e.getValue();
                    sb.append("  ")
                            .append(tn.name())
                            .append(": ")
                            .append(ints.implementations())
                            .append(NL);
                });

        sb.append(" DTOs:").append(NL);
        parsedDtos.entrySet().stream()
                .sorted((a, b) -> a.getKey().compareTo(b.getKey()))
                .forEach(e -> {
                    TypeName tn = e.getKey();
                    Dto dto = e.getValue();
                    sb.append("  ")
                            .append(tn.name())
                            .append(": ")
                            .append(dto.name())
                            .append(" - ")
                            .append(dto.reference())
                            .append(NL);
                });

        sb.append(" Remapped DTOs: ").append(NL);
        remappedDtoTypes.keySet().stream().sorted().forEach(tn -> {
            Type t = remappedDtoTypes.get(tn);
            sb.append("  ").append(tn.name()).append(": ").append(t).append(NL);
        });

        return sb.toString();
    }
}
