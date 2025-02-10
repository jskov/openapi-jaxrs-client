package dk.mada.jaxrs.openapi;

import static java.util.stream.Collectors.joining;

import dk.mada.jaxrs.model.Validation;
import dk.mada.jaxrs.model.types.Type;
import dk.mada.jaxrs.model.types.TypeName;
import dk.mada.jaxrs.model.types.TypeNames;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Constructs and keeps track of parser references.
 */
public class ParserTypeRefs {
    private static final Logger logger = LoggerFactory.getLogger(ParserTypeRefs.class);
    /** Newline. */
    private static final String NL = System.lineSeparator();

    /** Parser references created for a given type name. */
    private final Map<TypeName, ValidationRefs> parserReferences = new HashMap<>();
    /** Type names. */
    private final TypeNames typeNames;

    /**
     * Constructs new instance.
     *
     * @param typeNames the type names instance
     */
    public ParserTypeRefs(TypeNames typeNames) {
        this.typeNames = typeNames;
    }

    /**
     * Makes a new parser reference to a DTO.
     *
     * Created from a property/parameter reference, so it does have validation.
     *
     * @param name       the name of the DTO type
     * @param validation the validation requirements of the reference
     * @return the parser reference
     */
    public ParserTypeRef makeDtoRef(String name, Validation validation) {
        TypeName tn = typeNames.of(name);
        return of(TypeUnknownAtParseTime.get(), tn, validation);
    }

    /**
     * Makes a new parser reference to a primitive/special type.
     *
     * @param type       the type to make a reference to
     * @param validation the validation requirements of the reference
     * @return the parser reference
     */
    public ParserTypeRef of(Type type, Validation validation) {
        TypeName tn;
        if (type instanceof ParserTypeRef ptr) {
            tn = ptr.refTypeName();
        } else {
            tn = type.typeName();
        }
        return of(type, tn, validation);
    }

    private ParserTypeRef of(Type type, TypeName tn, Validation validation) {
        parserReferences.computeIfAbsent(tn, t -> new ValidationRefs());
        ValidationRefs validationRefs = parserReferences.get(tn);
        return validationRefs.getOrAdd(validation, type, tn);
    }

    /** {@return information about parser references} */
    public String info() {
        StringBuilder sb = new StringBuilder("Parser references:").append(NL);
        parserReferences.entrySet().stream()
                .sorted((a, b) -> a.getKey().compareTo(b.getKey()))
                .forEach(e -> {
                    TypeName tn = e.getKey();
                    ValidationRefs vr = e.getValue();
                    sb.append(" ").append(tn.name()).append(":").append(NL);
                    sb.append(vr.info());
                });
        return sb.toString();
    }

    /** Parser references mapped by validation requirements. */
    private static final class ValidationRefs {
        /** Parser references, mapped by their validation. */
        private final Map<Validation, Set<ParserTypeRef>> refsByValidation = new HashMap<>();

        private ParserTypeRef getOrAdd(Validation validation, Type type, TypeName tn) {
            Set<ParserTypeRef> refs = refsByValidation.computeIfAbsent(validation, v -> new HashSet<ParserTypeRef>());

            for (ParserTypeRef ref : refs) {
                if (ref.validation().equals(validation)
                        && Objects.equals(ref.refTypeName(), tn)
                        && Objects.equals(ref.refType(), type)) {
                    logger.debug(" found type reference {}", ref);
                    return ref;
                }
            }

            ParserTypeRef newRef = ParserTypeRef.of(type, tn, validation);
            refs.add(newRef);
            logger.debug(" created type reference {}", newRef);
            return newRef;
        }

        public String info() {
            StringBuilder sb = new StringBuilder();
            refsByValidation.entrySet().stream().forEach(e -> {
                Validation v = e.getKey();
                Set<ParserTypeRef> ptrs = e.getValue();

                String refs = ptrs.stream()
                        .map(r -> "ref@" + Integer.toHexString(r.hashCode()))
                        .sorted()
                        .collect(joining(", "));
                sb.append("  ").append(v).append(NL).append("    ").append(refs).append(NL);
            });
            return sb.toString();
        }
    }
}
