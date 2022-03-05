package dk.mada.jaxrs.openapi;

import static java.util.stream.Collectors.joining;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.model.Validation;
import dk.mada.jaxrs.model.types.TypeNames;
import dk.mada.jaxrs.model.types.TypeNames.TypeName;

/**
 * Constructs and keeps track of parser references.
 */
public class ParserTypeRefs {
    private static final Logger logger = LoggerFactory.getLogger(ParserTypeRefs.class);
    /** Newline. */
    private static final String NL = System.lineSeparator();

    /** Parser references created for a given type name. */
    private final Map<TypeName, ValidationRefs> parserReferences = new HashMap<>();

    /**
     * Make a new DTO parser reference.
     *
     * Created from the schema definition, so has no validation.
     *
     * @param name the name of the DTO type
     * @return the parser reference
     */
    public ParserTypeRef makeDtoRef(String name) {
        TypeName tn = TypeNames.of(name);
        parserReferences.computeIfAbsent(tn, t -> new ValidationRefs());
        ValidationRefs validationRefs = parserReferences.get(tn);
        return validationRefs.getOrAdd(Validation.NO_VALIDATION, tn);
    }

    /** {@return information about parser references} */
    public String info() {
        StringBuilder sb = new StringBuilder("Parser references:").append(NL);
        parserReferences.keySet().stream()
            .sorted()
            .forEach(tn -> {
                sb.append(" ").append(tn.name()).append(":").append(NL);
                ValidationRefs vr = parserReferences.get(tn);
                sb.append(vr.info());
            });
        return sb.toString();
    }

    /** Parser references mapped by validation requirements. */
    private static class ValidationRefs {
        /** Parser references, mapped by their validation. */
        private final Map<Validation, Set<ParserTypeRef>> refsByValidation = new HashMap<>();

        public ParserTypeRef getOrAdd(Validation validation, TypeName tn) {
            Set<ParserTypeRef> refs = refsByValidation.computeIfAbsent(validation, v -> new HashSet<ParserTypeRef>());

            for (ParserTypeRef ref : refs) {
                if (ref.validation().equals(validation)
                    && ref.refTypeName().equals(tn)) {
                    logger.info(" found type reference {}", ref);
                    return ref;
                }
            }

            ParserTypeRef newRef = ParserTypeRef.of(tn, validation);
            refs.add(newRef);
            logger.info(" created type reference {}", newRef);
            return newRef;
        }

        public String info() {
            StringBuilder sb = new StringBuilder();
            refsByValidation.keySet().stream()
                .forEach(v -> {
                    String refs = refsByValidation.get(v).stream()
                            .map(r -> "ref@" + r.hashCode())
                            .sorted()
                            .collect(joining(", "));
                    sb.append("  ").append(v).append(NL)
                      .append("    ").append(refs).append(NL);
                });
            return sb.toString();
        }
    }
}
