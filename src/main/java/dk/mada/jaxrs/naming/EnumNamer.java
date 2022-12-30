package dk.mada.jaxrs.naming;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.model.types.Primitive;
import dk.mada.jaxrs.model.types.Type;

/**
 * Uses default naming, but provides alternatives in case of naming conflicts.
 *
 * First tries to append the non-upper-cased value to the default naming. This allows the client to make (some) sense of
 * the enumeration values
 *
 * If this fails, falls back to numbering of conflicting names.
 */
public final class EnumNamer {
    private static final Logger logger = LoggerFactory.getLogger(EnumNamer.class);

    /** Naming. */
    private final Naming naming;
    /** Enumeration value type. */
    private final Type enumValueType;
    /** Suffix number counter per name prefix. */
    private final Map<String, AtomicInteger> nameNumbering = new HashMap<>();
    /** Name to values. These are ordered by the enumeration values. */
    private final List<EnumNameValue> nameToValues = new ArrayList<>();
    /** Values of the enumeration. */
    private final List<String> values;
    /** The assigned names of the values. */
    private final Set<String> assignedNames = new HashSet<>();

    /** Flag for all values are numbers. */
    private boolean allNumbers;

    /**
     * An enumeration name-to-value assignment.
     *
     * @param name  the assigned name to the enumeration entry
     * @param value the value of the enumeration entry
     */
    public record EnumNameValue(String name, String value) {
    }

    /**
     * Constructs a new enumeration namer instance.
     *
     * @param naming        the naming policies
     * @param enumValueType the enumeration type
     * @param values        the values of the enumeration
     */
    public EnumNamer(Naming naming, Type enumValueType, List<String> values) {
        this.naming = naming;
        this.enumValueType = enumValueType;
        this.values = values;
        this.allNumbers = isAllValuesNumbers(values);

        assignNames();
    }

    private static boolean isAllValuesNumbers(List<String> values) {
        for (String v : values) {
            try {
                Integer.parseInt(v);
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return true;
    }

    /** {@return the assigned names-to-values} */
    public List<EnumNameValue> getEntries() {
        return nameToValues;
    }

    private void assignNames() {
        // Group by default names to detect conflicts
        Map<String, List<String>> conflicts = values.stream()
                .collect(groupingBy(this::simpleNamer));

        for (String v : values) {
            final String defaultName = simpleNamer(v);
            String name;

            List<String> cfn = conflicts.get(defaultName);
            if (cfn == null || cfn.size() == 1) {
                // no conflict
                name = defaultName;
            } else {
                // conflict
                // first try if case sensitive variant works
                long uniquelyNamed = cfn.stream()
                        .map(n -> caseSensitiveNamer(defaultName, n))
                        .distinct()
                        .collect(counting());
                if (uniquelyNamed == cfn.size()) {
                    name = caseSensitiveNamer(defaultName, v);
                } else {
                    // if not, fall back to numbering
                    name = numberingNamer(defaultName);
                }
            }

            logger.trace(" {} -> {} -> {}", v, defaultName, name);

            nameToValues.add(new EnumNameValue(name, v));

            if (!assignedNames.add(name)) {
                logger.error("Conflicts when assigning enum names from: {}", values);
                logger.error("Name {} assigned twice", name);
                throw new IllegalStateException("Enum name conflict on " + name + " from " + values);
            }
        }

        logger.debug("CONFLICTS: {}", conflicts);
        logger.debug("Assigned: {}", nameToValues);
    }

    private String simpleNamer(String n) {
        if (enumValueType == Primitive.INT || allNumbers) {
            return naming.convertEnumNumberName(n);
        }

        return naming.convertEnumName(n);
    }

    /**
     * Provides a case sensitive renaming.
     *
     * May provide the reader of the type with better clues than just abstract numbering.
     *
     * Appends the (case-sensitive) original name as a suffix to the (case in-sensitive) prefix.
     *
     * Still has to map non-chars to _, so may still result in conflicts.
     *
     * @param prefix the (case in-sensitive) prefix
     * @param suffix the suffix to append
     * @return the combined name
     */
    private String caseSensitiveNamer(String prefix, String suffix) {
        String simplified = suffix.replaceAll("[^a-zA-Z0-9]", "_");

        return prefix + "_" + simplified;
    }

    /**
     * Assign numbers to conflicting names.
     *
     * Simply (and very abstractly) adds a counter to resolve name conflicts.
     *
     * @param defaultName the default name
     * @return the name assigned
     */
    private String numberingNamer(String defaultName) {
        nameNumbering.computeIfAbsent(defaultName, n -> new AtomicInteger(0));
        return defaultName + "_" + nameNumbering.get(defaultName).incrementAndGet();
    }
}
