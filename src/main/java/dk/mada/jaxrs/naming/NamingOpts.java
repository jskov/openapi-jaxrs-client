package dk.mada.jaxrs.naming;

import java.util.Properties;

/**
 * Definitions of naming options.
 *
 * These can be overridden via options provided by the user.
 */
public class NamingOpts {
    /** Naming configuration for types. */
    private final String typeNamingConfig;
    /** Naming configuration for renaming of conflicting types. */
    private final String typeConflictRenamingConfig;
    /** Naming configuration for properties. */
    private final String propertyNamingConfig;
    /** Naming configuration for single-property enumeration types. */
    private final String propertyEnumTypeNamingConfig;
    /** Naming configuration for enumeration constants. */
    private final String enumConstantNamingConfig;
    /** Naming configuration for enumeration number constants. */
    private final String enumNumberConstantNamingConfig;
    /** Naming configuration for parameter names. */
    private final String parameterNamingConfig;
    /** Naming configuration for entity parameter. */
    private final String entityNamingConfig;

    /** Flag to enable renaming types that would conflict on Windows. */
    private final boolean renameCaseConflicts;
    /** Ordering used when resolving conflicts. */
    private final SchemaOrder renameCaseConflictsOrder;
    
    /** Ordering preference when renaming due to name conflicts. */
    public enum SchemaOrder {
        /** Follow OpenApi document declaration order of schemas. */
        DOCUMENT_ORDER,
        /** Follow naming order of schemas. */ 
        NAME_ORDER;

        /**
         * {@return the matching schema ordering}
         * @param name the name of the ordering desired
         * @return the ordering type
         */
        public static SchemaOrder fromConfigName(String name) {
            String id = name.toUpperCase().replace('-', '_');
            for (var o : SchemaOrder.values()) {
                if (o.name().equals(id)) {
                    return o;
                }
            }
            throw new IllegalArgumentException("Unknown case conflict ordering value: " + name);
        }
    }

    /**
     * Constructs new instance.
     *
     * @param options the options provided by the user
     */
    public NamingOpts(Properties options) {
        typeNamingConfig = getDefault(options, "naming-rules-type", "TYPENAME");
        typeConflictRenamingConfig = getDefault(options, "naming-rules-type-conflict-renaming", "APPEND/X/");
        entityNamingConfig = getDefault(options, "naming-rules-entity", "LITERAL/dto/");
        propertyNamingConfig = getDefault(options, "naming-rules-property", "PROPERTYNAME");
        parameterNamingConfig = getDefault(options, "naming-rules-parameter", "PROPERTYNAME");
        enumConstantNamingConfig = getDefault(options, "naming-rules-enum-constant", "REGEXP/-/_/; TYPENAME; UPCASE");
        enumNumberConstantNamingConfig = getDefault(options, "naming-rules-enum-number-constant", "REGEXP/-/NEG_/; PREPEND/NUMBER_/");
        propertyEnumTypeNamingConfig = getDefault(options, "naming-rules-property-enum-type", "TYPENAME; APPEND/Enum/");

        renameCaseConflicts = Boolean.parseBoolean(options.getProperty("naming-rename-case-conflicts"));
        renameCaseConflictsOrder = SchemaOrder.fromConfigName(getDefault(options, "naming-rename-case-conflicts-order", "document-order"));
    }

    /** {@return true if types should be renamed to avoid conflicts on Windows} */
    public boolean isRenameCaseConflicts() {
        return renameCaseConflicts;
    }

    /** {@return the order by which name conflicts should be resolved} */ 
    public SchemaOrder getRenameCaseConflictsOrder() {
        return renameCaseConflictsOrder;
    }

    /** {@return the renaming configuration for a conflicting type name} */
    public String getTypeConflictRenaming() {
        return typeConflictRenamingConfig;
    }

    /** {@return the naming configuration for entity parameter} */
    public String getEntityNaming() {
        return entityNamingConfig;
    }

    /** {@return the naming configuration for enumeration constants} */
    public String getEnumConstantNaming() {
        return enumConstantNamingConfig;
    }

    /** {@return the naming configuration for enumeration number constants} */
    public String getEnumNumberConstantNaming() {
        return enumNumberConstantNamingConfig;
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
