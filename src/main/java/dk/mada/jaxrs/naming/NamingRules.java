package dk.mada.jaxrs.naming;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Constructs naming rules from user input.
 */
public final class NamingRules {
    private static final Logger logger = LoggerFactory.getLogger(NamingRules.class);
    /** Pattern for syntax split of two operator arguments. */
    private static final Pattern PATTERN_TWO_ARGS = Pattern.compile("([^/]*)/([^/]*)");
    /** Identifiers. */
    private static final Identifiers IDENTIFIERS = new Identifiers();

    /**
     * Simple operations that operate on the input string.
     */
    private static final Map<String, NamingRule> OPS_INPUT = Map.of(
            // Variable name operators
            "OPERATIONNAME-EDGE", new NamingRule("OPERATIONNAME-EDGE", IDENTIFIERS::makeValidEdgeVariableName),
            "PARAMETERNAME-EDGE", new NamingRule("PARAMETERNAME-EDGE", IDENTIFIERS::makeValidEdgeVariableName),
            "PROPERTYNAME-EDGE", new NamingRule("PROPERTYNAME-EDGE", IDENTIFIERS::makeValidEdgeVariableName),
            "PROPERTYNAME", new NamingRule("PROPERTYNAME", IDENTIFIERS::makeValidVariableName),
            "PARAMETERNAME", new NamingRule("PARAMETERNAME", IDENTIFIERS::makeValidVariableName),
            "OPERATIONNAME", new NamingRule("OPERATIONNAME", IDENTIFIERS::makeValidVariableName),
            // Type name operators
            "TYPENAME-EDGE", new NamingRule("TYPENAME-EDGE", IDENTIFIERS::makeValidEdgeTypeName),
            "TYPENAME", new NamingRule("TYPENAME", IDENTIFIERS::makeValidTypeName),
            // Case operators
            "UPCASE", new NamingRule("UPCASE", String::toUpperCase),
            "DOWNCASE", new NamingRule("DOWNCASE", String::toLowerCase));

    /**
     * Operations that operate on the input string and a single operation argument.
     */
    private static final Map<String, Function<String, NamingRule>> OPS_INPUT_ARG = Map.of(
            // Appends argument to input string
            "APPEND", arg -> new NamingRule("APPEND:" + arg, s -> s + arg),
            // Prepends argument to input string
            "PREPEND", arg -> new NamingRule("PREPEND:" + arg, s -> arg + s),
            // Replaces input string with argument
            "LITERAL", arg -> new NamingRule("LITERAL:" + arg, s -> arg));

    /**
     * Operations that operate on the input string and two operation arguments.
     */
    private static final Map<String, BiFunction<String, String, NamingRule>> OPS_INPUT_BIARG = Map.of(
            // Applies regular expression replacement to input string
            "REGEXP", NamingRules::regexpOperation);

    private NamingRules() {
    }

    record NamingRule(String name, UnaryOperator<String> converter) {
    }

    /**
     * Builds a list of rules based on input configuration.
     *
     * The caller of this method will then be able to compute a named based on an input string, and applying the list of
     * returned naming rules sequentially to this string.
     *
     * @param ruleConfigurations the rule configurations, separated by ;
     * @return a list of naming rules to be applied sequentially
     */
    public static List<NamingRule> toRules(String ruleConfigurations) {
        return Stream.of(ruleConfigurations.split(";"))
                .filter(s -> !s.isBlank())
                .map(NamingRules::toRule)
                .toList();
    }

    /**
     * Created a single naming rules based on a single rule configuration.
     *
     * @param ruleConfiguration the rule configuration
     * @return the resulting naming rule
     */
    public static NamingRule toRule(String ruleConfiguration) {
        String opConfig = ruleConfiguration.trim();
        String opName = opConfig.replaceFirst("/.*", "");

        // First handle simple input operations
        NamingRule simpleOpRule = OPS_INPUT.get(opName);
        if (simpleOpRule != null) {
            return simpleOpRule;
        }

        // If no match, check for operation arguments
        if (!opConfig.contains("/")) {
            throw new IllegalArgumentException("Unknown naming rule: '" + opConfig + "'");
        }
        if (!opConfig.endsWith("/")) {
            throw new IllegalArgumentException("Operations with arguments must end with /, saw: '" + opConfig + "'");
        }

        // Look for a matching single-argument operation
        String value = opConfig.substring(opName.length() + 1, opConfig.length() - 1);
        Function<String, NamingRule> oneArgOperation = OPS_INPUT_ARG.get(opName);
        if (oneArgOperation != null) {
            logger.debug(" Single-argument operation value: '{}'", value);
            return oneArgOperation.apply(value);
        }

        // If no single-argument operation, look for two-argument operations
        BiFunction<String, String, NamingRule> twoArgOperation = OPS_INPUT_BIARG.get(opName);
        if (twoArgOperation == null) {
            throw new IllegalArgumentException("Unknown naming rule: '" + opConfig + "'");
        }

        // Split value argument into two
        Matcher m = PATTERN_TWO_ARGS.matcher(value);
        if (!m.matches()) {
            throw new IllegalArgumentException("Bad input for operations with two arguments, saw: '" + opConfig + "'");
        }

        value = m.group(1);
        String value2 = m.group(2);

        logger.debug(" Bi-argument operation values: '{}' / '{}'", value, value2);
        return twoArgOperation.apply(value, value2);
    }

    private static NamingRule regexpOperation(String pattern, String replacement) {
        Pattern p = Pattern.compile(pattern);
        return new NamingRule("REGEXP:" + pattern, s -> p.matcher(s).replaceAll(replacement));
    }
}
