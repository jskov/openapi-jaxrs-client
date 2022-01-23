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
public class NamingRules {
    private static final Logger logger = LoggerFactory.getLogger(NamingRules.class);
    private static final String REGEXP = "REGEXP/";
    private static final Identifiers identifiers = new Identifiers();

    record NamingRule(String name, UnaryOperator<String> converter) {}

    public static List<NamingRule> toRules(String rules) {
        return Stream.of(rules.split(";"))
                .map(NamingRules::toRule)
                .toList();
    }

    public static NamingRule toRule(String rIn) {
        String r = rIn.trim();
        if ("PROPERTYNAME".equals(r)) {
            return new NamingRule(r, identifiers::makeValidVariableName);
        }
        if ("TYPENAME".equals(r)) {
            return new NamingRule(r, identifiers::makeValidTypeName);
        }
        if ("UPCASE".equals(r)) {
            return new NamingRule(r, String::toUpperCase);
        }
        if ("DOWNCASE".equals(r)) {
            return new NamingRule(r, String::toLowerCase);
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
