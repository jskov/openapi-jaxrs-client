package dk.mada.jaxrs.model.naming;

import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;

import org.jspecify.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dk.mada.jaxrs.model.naming.NamingOpts.SchemaOrder;
import dk.mada.jaxrs.model.naming.NamingRules.NamingRule;

/**
 * Executes naming rules.
 */
public class Naming {
    private static final Logger logger = LoggerFactory.getLogger(Naming.class);

    /** Prefix DTO names for composite properties. This is only used internally in the parser. */
    public static final String PARSER_INTERNAL_PROPERTIES_NAME_MARKER = "_internal_$_properties_";

    /** Naming rules for API group names. */
    private final List<NamingRule> apiNamingRules;
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
    /** Naming rules for operation names. */
    private final List<NamingRule> operationNamingRules;
    /** Naming rules for operationId names. */
    private final List<NamingRule> operationIdNamingRules;
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

        apiNamingRules = NamingRules.toRules(namingOpts.getApiNaming());
        entityNamingRules = NamingRules.toRules(namingOpts.getEntityNaming());
        enumConstantNamingRules = NamingRules.toRules(namingOpts.getEnumConstantNaming());
        enumNumberConstantNamingRules = NamingRules.toRules(namingOpts.getEnumNumberConstantNaming());
        operationNamingRules = NamingRules.toRules(namingOpts.getOperationNaming());
        operationIdNamingRules = NamingRules.toRules(namingOpts.getOperationIdNaming());
        parameterNamingRules = NamingRules.toRules(namingOpts.getParameterNaming());
        propertyEnumTypeNamingRules = NamingRules.toRules(namingOpts.getPropertyEnumTypeNaming());
        propertyNamingRules = NamingRules.toRules(namingOpts.getPropertyNaming());
        typeNamingRules = NamingRules.toRules(namingOpts.getTypeNaming());
        mpSchemaNamingRules = NamingRules.toRules(namingOpts.getMpSchemaNaming());
        getTypeConflictRenaming = NamingRules.toRules(namingOpts.getTypeConflictRenaming());

        if (logger.isDebugEnabled()) {
            logger.debug("apiNamingRules: {}", makeRuleInfo(apiNamingRules));
            logger.debug("entityNamingRules: {}", makeRuleInfo(entityNamingRules));
            logger.debug("enumConstantNamingRules: {}", makeRuleInfo(enumConstantNamingRules));
            logger.debug("enumNumberConstantNamingRules: {}", makeRuleInfo(enumNumberConstantNamingRules));
            logger.debug("operationNamingRules: {}", makeRuleInfo(operationNamingRules));
            logger.debug("operationIdNamingRules: {}", makeRuleInfo(operationIdNamingRules));
            logger.debug("parameterNamingRules: {}", makeRuleInfo(parameterNamingRules));
            logger.debug("propertyEnumTypeNamingRules: {}", makeRuleInfo(propertyEnumTypeNamingRules));
            logger.debug("propertyNamingRules: {}", makeRuleInfo(propertyNamingRules));
            logger.debug("typeNamingRules: {}", makeRuleInfo(typeNamingRules));
            logger.debug("mpSchemaNamingRules: {}", makeRuleInfo(mpSchemaNamingRules));
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
     * Converts an API group name into a java API class name.
     *
     * @param groupName the OpenApi group name
     * @return the java API class name
     */
    public String convertApiName(String groupName) {
        return convert(apiNamingRules, groupName);
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
     * Converts an operation name to a java method name.
     *
     * The synthetic operation name is created from path-httptype.
     *
     * @param syntheticOperationName the synthetic name
     * @return the java method name
     */
    public String convertOperationName(String syntheticOperationName) {
        return convert(operationNamingRules, syntheticOperationName);
    }

    /**
     * Converts an operationId name to a java method name.
     *
     * This is only used for methods that have a specified operationId.
     *
     * @param operationIdName the operationId name, or null
     * @return the java method name
     */
    public Optional<String> convertOperationIdName(@Nullable String operationIdName) {
        if (operationIdName != null) {
            return Optional.of(convert(operationIdNamingRules, operationIdName));
        } else {
            return Optional.empty();
        }
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
        if (input.startsWith(PARSER_INTERNAL_PROPERTIES_NAME_MARKER)) {
            logger.trace("  ignored, internal naming");
            return input;
        }
        for (NamingRule nr : rules) {
            String newResult = nr.converter().apply(result);
            String name = nr.name();
            logger.trace("  {}: '{}' -> '{}'", name, result, newResult);
            result = newResult;
        }
        return result;
    }
}
