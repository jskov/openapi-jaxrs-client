package dk.mada.jaxrs.naming;

import java.util.List;
import java.util.Map;
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
    /** Prefix for regular expression input. */
    private static final String REGEXP = "REGEXP/";
    /** Identifiers. */
    private static final Identifiers IDENTIFIERS = new Identifiers();

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
                .map(NamingRules::toRule)
                .toList();
    }

    /**
     * Simple operations that operate on the input string.
     */
    private static final Map<String, NamingRule> SIMPLE_OPS = Map.of(
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
     * Operations that operate on the input string and a single
     * operation argument.
     */
    private static final Map<String, Function<String, NamingRule>> OPS_ARG = Map.of(
            // Appends argument to input string
            "APPEND", arg -> new NamingRule("APPEND:" + arg, s -> s + arg),
            // Prepends argument to input string
            "PREPEND", arg -> new NamingRule("PREPEND:" + arg, s -> arg + s),
            // Replaces input string with argument
            "LITERAL", arg -> new NamingRule("LITERAL:" + arg, s -> arg)
            );

    /**
     * Created a single naming rules based on a single rule configuration.
     *
     * @param ruleConfiguration the rule configuration
     * @return the resulting naming rule
     */
    public static NamingRule toRule(String ruleConfiguration) {
        String opConfig = ruleConfiguration.trim();
        String opName = opConfig.replaceAll("/.*", "");

        NamingRule simpleOpRule = SIMPLE_OPS.get(opName);
        if (simpleOpRule != null) {
            return simpleOpRule;
        }

        if (!opConfig.endsWith("/")) {
            throw new IllegalArgumentException("Operations with arguments must end with /, saw: '" + opConfig + "'");
        }

        String oneArgValue = opConfig.substring(opName.length() + 1, opConfig.length() - 1);
        
        Function<String, NamingRule> oneArgOperation = OPS_ARG.get(opName);
        if (oneArgOperation != null) {
            return oneArgOperation.apply(oneArgValue);
        }
        
//        if (opConfig.startsWith(APPEND)) {
//            if (!opConfig.endsWith("/")) {
//                throw new IllegalArgumentException("APPEND must end with /, saw: " + opConfig);
//            }
//            return new NamingRule(opConfig, s -> s + opConfig.substring(APPEND.length(), opConfig.length() - 1));
//        }
//        if (opConfig.startsWith(PREPEND)) {
//            if (!opConfig.endsWith("/")) {
//                throw new IllegalArgumentException("PREPEND must end with /, saw: " + opConfig);
//            }
//            return new NamingRule(opConfig, s -> opConfig.substring(PREPEND.length(), opConfig.length() - 1) + s);
//        }
//        if (opConfig.startsWith(LITERAL)) {
//            if (!opConfig.endsWith("/")) {
//                throw new IllegalArgumentException("LITERAL must end with /, saw: " + opConfig);
//            }
//            return new NamingRule(opConfig, s -> opConfig.substring(LITERAL.length(), opConfig.length() - 1));
//        }
        if (opConfig.startsWith(REGEXP)) {
            if (!opConfig.endsWith("/")) {
                throw new IllegalArgumentException("REGEXP must end with /, saw: " + opConfig);
            }
            String pr = opConfig.substring(REGEXP.length());

            Pattern prPattern = Pattern.compile("([^/]*)/([^/]*)/");
            Matcher m = prPattern.matcher(pr);
            if (!m.matches()) {
                throw new IllegalArgumentException("REGEXP Bad pattern/replacement section, saw: " + pr);
            }

            String pattern = m.group(1);
            String replacement = m.group(2);

            logger.debug(" REGEXP: {} / {}", pattern, replacement);

            Pattern p = Pattern.compile(pattern);
            return new NamingRule(opConfig, s -> p.matcher(s).replaceAll(replacement));
        }
        throw new IllegalArgumentException("Unknown naming rule: '" + opConfig + "'");
    }
}
