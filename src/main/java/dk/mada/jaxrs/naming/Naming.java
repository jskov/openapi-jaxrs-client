package dk.mada.jaxrs.naming;

import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.naming.NamingRules.NamingRule;

/**
 * Executes naming rules.
 */
public class Naming {
    private static final Logger logger = LoggerFactory.getLogger(Naming.class);
    private final NamingOpts namingOpts;
    private final List<NamingRule> enumNamingRules;
    private final List<NamingRule> typeNamingRules;
    private final List<NamingRule> propertyNamingRules;
    private final List<NamingRule> parameterNamingRules;

    public Naming(Properties props) {
        namingOpts = new NamingOpts(props);

        enumNamingRules = NamingRules.toRules(namingOpts.getEnumNaming());
        typeNamingRules = NamingRules.toRules(namingOpts.getTypeNaming());
        propertyNamingRules = NamingRules.toRules(namingOpts.getPropertyNaming());
        parameterNamingRules = NamingRules.toRules(namingOpts.getParameterNaming());
    }

    public String convertEnumName(String input) {
        return convert(enumNamingRules, input);
    }

    public String convertTypeName(String input) {
        return convert(typeNamingRules, input);
    }

    public String convertPropertyName(String input) {
        return convert(propertyNamingRules, input);
    }

    public String convertParameterName(String input) {
        return convert(parameterNamingRules, input);
    }

    private String convert(List<NamingRule> rules, String input) {
        String result = input;
        logger.trace(" convert '{}'", input);
        for (NamingRule nr : rules) {
            String newResult = nr.converter().apply(result);
            String name = nr.name();
            logger.trace("  {}: '{}' -> '{}'", name, result, newResult);
            result = newResult;
        }
        return result;
    }
}
