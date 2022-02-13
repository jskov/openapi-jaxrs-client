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

    /** Naming rules for enumeration constants. */
    private final List<NamingRule> enumConstantNamingRules;
    /** Naming rules for type names. */
    private final List<NamingRule> typeNamingRules;
    /** Naming rules for property names. */
    private final List<NamingRule> propertyNamingRules;
    /** Naming rules for parameter names. */
    private final List<NamingRule> parameterNamingRules;
    /** Naming rules for entity names. */
    private final List<NamingRule> entityNamingRules;
    /** Naming rules for property enum types. */
    private List<NamingRule> propertyEnumTypeNamingRules;

    /**
     * Creates a new instance.
     *
     * The properties allow the user to customize naming rules.
     *
     * @param props the properties with optional user configurations
     * @see NamingOpts
     */
    public Naming(Properties props) {
        var namingOpts = new NamingOpts(props);

        enumConstantNamingRules = NamingRules.toRules(namingOpts.getEnumConstantNaming());
        typeNamingRules = NamingRules.toRules(namingOpts.getTypeNaming());
        propertyNamingRules = NamingRules.toRules(namingOpts.getPropertyNaming());
        parameterNamingRules = NamingRules.toRules(namingOpts.getParameterNaming());
        entityNamingRules = NamingRules.toRules(namingOpts.getEntityNaming());
        propertyEnumTypeNamingRules = NamingRules.toRules(namingOpts.getPropertyEnumTypeNaming());
    }

    /**
     * Converts entity type name to entity variable name.
     *
     * @param entityTypeName the type name of the entity
     * @return the entity variable name
     */
    public String convertEntityName(String entityTypeName) {
        return convert(entityNamingRules, entityTypeName);
    }

    /**
     * Converts enumeration entry name into enumeration constant name.
     *
     * @param enumerationEntryName the enumeration entry name
     * @return the enumeration constant name
     */
    public String convertEnumName(String enumerationEntryName) {
        return convert(enumConstantNamingRules, enumerationEntryName);
    }

    /**
     * Converts a type OpenApi schema name into a java type name.
     *
     * @param schemaName OpenApi schema name
     * @return the java type name
     */
    public String convertTypeName(String schemaName) {
        return convert(typeNamingRules, schemaName);
    }

    /**
     * Converts a schema field name to a java property name.
     *
     * @param schemaFieldName the OpenApi schema field name
     * @return the java property name
     */
    public String convertPropertyName(String schemaFieldName) {
        return convert(propertyNamingRules, schemaFieldName);
    }

    /**
     * Converts an operation parameter name to a java method argument name.
     *
     * @param schemaParamName the OpenApi schema parameter name
     * @return the java method argument name
     */
    public String convertParameterName(String schemaParamName) {
        return convert(parameterNamingRules, schemaParamName);
    }

    /**
     * Converts a DTO enumeration parameter name to an enumeration type name.
     *
     * @param schemaPropertyName the OpenApi schema property name
     * @return the java enumeration type name
     */
    public String convertPropertyEnumTypeName(String schemaPropertyName) {
        return convert(propertyEnumTypeNamingRules, schemaPropertyName);
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
