package dk.mada.jaxrs.naming;

import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.naming.NamingOpts.SchemaOrder;
import dk.mada.jaxrs.naming.NamingRules.NamingRule;

/**
 * Executes naming rules.
 */
public class Naming {
    private static final Logger logger = LoggerFactory.getLogger(Naming.class);

    /** Naming rules for enumeration constants. */
    private final List<NamingRule> enumConstantNamingRules;
    /** Naming rules for enumeration number constants. */
    private final List<NamingRule> enumNumberConstantNamingRules;
    /** Naming rules for type names. */
    private final List<NamingRule> typeNamingRules;
    /** Naming rules for MP @Schema names. */
    private final List<NamingRule> mpSchemaNamingRules;
    /** Renaming rules for type name conflicts. */
    private final List<NamingRule> getTypeConflictRenaming;
    /** Naming rules for property names. */
    private final List<NamingRule> propertyNamingRules;
    /** Naming rules for parameter names. */
    private final List<NamingRule> parameterNamingRules;
    /** Naming rules for entity names. */
    private final List<NamingRule> entityNamingRules;
    /** Naming rules for property enum types. */
    private List<NamingRule> propertyEnumTypeNamingRules;

    /** The naming options. */
    private final NamingOpts namingOpts;

    /**
     * Creates a new instance.
     *
     * The properties allow the user to customize naming rules.
     *
     * @param props the properties with optional user configurations
     * @see NamingOpts
     */
    public Naming(Properties props) {
        namingOpts = new NamingOpts(props);

        entityNamingRules = NamingRules.toRules(namingOpts.getEntityNaming());
        enumConstantNamingRules = NamingRules.toRules(namingOpts.getEnumConstantNaming());
        enumNumberConstantNamingRules = NamingRules.toRules(namingOpts.getEnumNumberConstantNaming());
        parameterNamingRules = NamingRules.toRules(namingOpts.getParameterNaming());
        propertyEnumTypeNamingRules = NamingRules.toRules(namingOpts.getPropertyEnumTypeNaming());
        propertyNamingRules = NamingRules.toRules(namingOpts.getPropertyNaming());
        typeNamingRules = NamingRules.toRules(namingOpts.getTypeNaming());
        mpSchemaNamingRules = NamingRules.toRules(namingOpts.getMpSchemaNaming());
        getTypeConflictRenaming = NamingRules.toRules(namingOpts.getTypeConflictRenaming());

        if (logger.isInfoEnabled()) {
            logger.info("entityNamingRules: {}", makeRuleInfo(entityNamingRules));
            logger.info("enumConstantNamingRules: {}", makeRuleInfo(enumConstantNamingRules));
            logger.info("enumNumberConstantNamingRules: {}", makeRuleInfo(enumNumberConstantNamingRules));
            logger.info("parameterNamingRules: {}", makeRuleInfo(parameterNamingRules));
            logger.info("propertyEnumTypeNamingRules: {}", makeRuleInfo(propertyEnumTypeNamingRules));
            logger.info("propertyNamingRules: {}", makeRuleInfo(propertyNamingRules));
            logger.info("typeNamingRules: {}", makeRuleInfo(typeNamingRules));
            logger.info("mpSchemaNamingRules: {}", makeRuleInfo(mpSchemaNamingRules));
        }
    }

    private String makeRuleInfo(List<NamingRule> rules) {
        return rules.stream()
                .map(NamingRule::name)
                .collect(Collectors.joining(", "));
    }

    /** {@return true if types should be renamed to avoid conflicts on Windows} */
    public boolean isRenameCaseConflicts() {
        return namingOpts.isRenameCaseConflicts();
    }

    /** {@return the schema order used when resolving naming conflicts} */
    public SchemaOrder getRenameCaseConflictSchemaOrder() {
        return namingOpts.getRenameCaseConflictsOrder();
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
     * Converts enumeration entry value into enumeration constant name.
     *
     * @param enumerationEntryName the enumeration entry value
     * @return the enumeration constant name
     */
    public String convertEnumName(String enumerationEntryName) {
        return convert(enumConstantNamingRules, enumerationEntryName);
    }

    /**
     * Converts enumeration number entry value into enumeration constant name.
     *
     * @param enumerationEntryName the enumeration entry value
     * @return the enumeration constant name
     */
    public String convertEnumNumberName(String enumerationEntryName) {
        return convert(enumNumberConstantNamingRules, enumerationEntryName);
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
     * Converts a type OpenApi schema name into its MP @Schema name.
     *
     * @param schemaName OpenApi schema name
     * @return the MP @Schema name
     */
    public String convertMpSchemaName(String schemaName) {
        return convert(mpSchemaNamingRules, schemaName);
    }

    /**
     * Converts a conflicting name to a new name.
     *
     * @param name the name of the type
     * @return the new name for the type
     */
    public String renameConflictingName(String name) {
        return convert(getTypeConflictRenaming, name);
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
