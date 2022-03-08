package dk.mada.jaxrs.naming;

import java.util.Properties;

/**
 * Definitions of naming options.
 *
 * These can be overridden via options provided by the user.
 */
public class NamingOpts {
    /** Prefix for enumeration number constants. */
    private final String enumNumberPrefixConfig;
    /** Naming configuration for types. */
    private final String typeNamingConfig;
    /** Naming configuration for properties. */
    private final String propertyNamingConfig;
    /** Naming configuration for single-property enumeration types. */
    private final String propertyEnumTypeNamingConfig;
    /** Naming configuration for enumeration constants. */
    private final String enumConstantNamingConfig;
    /** Naming configuration for parameter names. */
    private final String parameterNamingConfig;
    /** Naming configuration for entity parameter. */
    private final String entityNamingConfig;

    /**
     * Constructs new instance.
     *
     * @param options the options provided by the user
     */
    public NamingOpts(Properties options) {
        typeNamingConfig = getDefault(options, "naming-rules-type", "TYPENAME");
        entityNamingConfig = getDefault(options, "naming-rules-entity", "LITERAL/dto/");
        propertyNamingConfig = getDefault(options, "naming-rules-property", "PROPERTYNAME");
        parameterNamingConfig = getDefault(options, "naming-rules-parameter", "PROPERTYNAME");
        enumConstantNamingConfig = getDefault(options, "naming-rules-enum-constant", "REGEXP/-/_/; TYPENAME; UPCASE");
        propertyEnumTypeNamingConfig = getDefault(options, "naming-rules-property-enum-type", "TYPENAME; APPEND/Enum/");

        enumNumberPrefixConfig = getDefault(options, "naming-enum-prefix-number", "NUMBER_");
    }

    /** {@return the prefix for enumeration number constants} */
    public String getEnumNumberPrefix() {
        return enumNumberPrefixConfig;
    }

    /** {@return the naming configuration for entity parameter} */
    public String getEntityNaming() {
        return entityNamingConfig;
    }

    /** {@return the naming configuration for enumeration constants} */
    public String getEnumConstantNaming() {
        return enumConstantNamingConfig;
    }

    /** {@return the naming configuration for single-property enumeration types} */
    public String getPropertyEnumTypeNaming() {
        return propertyEnumTypeNamingConfig;
    }

    /** {@return the naming configuration for properties} */
    public String getPropertyNaming() {
        return propertyNamingConfig;
    }

    /** {@return the naming configuration for parameter names} */
    public String getParameterNaming() {
        return parameterNamingConfig;
    }

    /** {@return the naming configuration for types} */
    public String getTypeNaming() {
        return typeNamingConfig;
    }

    private String getDefault(Properties opts, String name, String defaultValue) {
        String value = opts.getProperty(name);
        if (value == null) {
            return defaultValue;
        }
        return value.trim();
    }
}
