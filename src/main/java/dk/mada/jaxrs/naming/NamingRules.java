package dk.mada.jaxrs.naming;

import java.util.List;
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
    /** Prefix for literal string append. */
    private static final String APPEND = "APPEND/";
    /** Prefix for literal string prepend. */
    private static final String PREPEND = "PREPEND/";
    /** Prefix for literal string input. */
    private static final String LITERAL = "LITERAL/";
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
     * The caller of this method will then be able to compute a named based on an input string, and applying the list of returned naming
     * rules sequentially to this string.
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
     * Created a single naming rules based on a single rule configuration.
     *
     * @param ruleConfiguration the rule configuration
     * @return the resulting naming rule
     */
    public static NamingRule toRule(String ruleConfiguration) {
        String r = ruleConfiguration.trim();
        if ("PROPERTYNAME-EDGE".equals(r) || "PARAMETERNAME-EDGE".equals(r) || "OPERATIONNAME-EDGE".equals(r)) {
            return new NamingRule(r, IDENTIFIERS::makeValidEdgeVariableName);
        }
        if ("PROPERTYNAME".equals(r) || "PARAMETERNAME".equals(r) || "OPERATIONNAME".equals(r)) {
            return new NamingRule(r, IDENTIFIERS::makeValidVariableName);
        }
        if ("TYPENAME-EDGE".equals(r)) {
            return new NamingRule(r, IDENTIFIERS::makeValidEdgeTypeName);
        }
        if ("TYPENAME".equals(r)) {
            return new NamingRule(r, IDENTIFIERS::makeValidTypeName);
        }
        if ("UPCASE".equals(r)) {
            return new NamingRule(r, String::toUpperCase);
        }
        if ("DOWNCASE".equals(r)) {
            return new NamingRule(r, String::toLowerCase);
        }
        if (r.startsWith(APPEND)) {
            if (!r.endsWith("/")) {
                throw new IllegalArgumentException("APPEND must end with /, saw: " + r);
            }
            return new NamingRule(r, s -> s + r.substring(APPEND.length(), r.length() - 1));
        }
        if (r.startsWith(PREPEND)) {
            if (!r.endsWith("/")) {
                throw new IllegalArgumentException("PREPEND must end with /, saw: " + r);
            }
            return new NamingRule(r, s -> r.substring(PREPEND.length(), r.length() - 1) + s);
        }
        if (r.startsWith(LITERAL)) {
            if (!r.endsWith("/")) {
                throw new IllegalArgumentException("LITERAL must end with /, saw: " + r);
            }
            return new NamingRule(r, s -> r.substring(LITERAL.length(), r.length() - 1));
        }
        if (r.startsWith(REGEXP)) {
            if (!r.endsWith("/")) {
                throw new IllegalArgumentException("REGEXP must end with /, saw: " + r);
            }
            String pr = r.substring(REGEXP.length());

            Pattern prPattern = Pattern.compile("([^/]*)/([^/]*)/");
            Matcher m = prPattern.matcher(pr);
            if (!m.matches()) {
                throw new IllegalArgumentException("REGEXP Bad pattern/replacement section, saw: " + pr);
            }

            String pattern = m.group(1);
            String replacement = m.group(2);

            logger.debug(" REGEXP: {} / {}", pattern, replacement);

            Pattern p = Pattern.compile(pattern);
            return new NamingRule(r, s -> p.matcher(s).replaceAll(replacement));
        }
        throw new IllegalArgumentException("Unknown naming rule: '" + r + "'");
    }
}
