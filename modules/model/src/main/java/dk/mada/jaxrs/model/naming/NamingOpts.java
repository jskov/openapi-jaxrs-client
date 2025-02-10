package dk.mada.jaxrs.model.naming;

import dk.mada.jaxrs.model.options.OptionReader;
import java.util.Locale;

/**
 * Definitions of naming options.
 *
 * These can be overridden via options provided by the user.
 */
public class NamingOpts {
    /** Naming configuration for APIs. */
    private final String apiNamingConfig;
    /** Naming configuration for types. */
    private final String typeNamingConfig;
    /** Naming configuration for multipart body types. */
    private final String multipartTypeNamingConfig;
    /** Naming configuration for MP Schema name. */
    private final String mpSchemaNamingConfig;
    /** Naming configuration for renaming of conflicting types. */
    private final String typeConflictRenamingConfig;
    /** Naming configuration for operations. */
    private final String operationNamingConfig;
    /** Naming configuration for operationIds. */
    private final String operationIdNamingConfig;
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
         *
         * @param name the name of the ordering desired
         */
        public static SchemaOrder fromConfigName(String name) {
            String id = name.toUpperCase(Locale.ROOT).replace('-', '_');
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
     * @param or the option reader
     */
    public NamingOpts(OptionReader or) {
        apiNamingConfig = or.getDefault("naming-rules-api", "TYPENAME; REGEXP/Api$//; APPEND/Api/");
        typeNamingConfig = or.getDefault("naming-rules-type", "TYPENAME");
        multipartTypeNamingConfig = or.getDefault("naming-rules-multipart-type", "PREPEND/Multipart-/; TYPENAME");
        mpSchemaNamingConfig = or.getDefault("naming-rules-mp-schema", typeNamingConfig);
        typeConflictRenamingConfig = or.getDefault("naming-rules-type-conflict-renaming", "APPEND/X/");
        entityNamingConfig = or.getDefault("naming-rules-entity", "LITERAL/dto/");
        operationNamingConfig = or.getDefault("naming-rules-operation", "OPERATIONNAME");
        operationIdNamingConfig = or.getDefault("naming-rules-operationid", "");
        propertyNamingConfig = or.getDefault("naming-rules-property", "REGEXP/_/-/; PROPERTYNAME");
        parameterNamingConfig = or.getDefault("naming-rules-parameter", "REGEXP/_/-/; PROPERTYNAME");
        enumConstantNamingConfig = or.getDefault("naming-rules-enum-constant", "REGEXP/-/_/; TYPENAME; UPCASE");
        enumNumberConstantNamingConfig =
                or.getDefault("naming-rules-enum-number-constant", "REGEXP/-/NEG_/; PREPEND/NUMBER_/");
        propertyEnumTypeNamingConfig = or.getDefault("naming-rules-property-enum-type", "TYPENAME; APPEND/Enum/");

        renameCaseConflicts = or.bool("naming-rename-case-conflicts", false);
        renameCaseConflictsOrder =
                SchemaOrder.fromConfigName(or.getDefault("naming-rename-case-conflicts-order", "document-order"));
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

    /** {@return the naming configuration for operations} */
    public String getOperationNaming() {
        return operationNamingConfig;
    }

    /** {@return the naming configuration for operationIds} */
    public String getOperationIdNaming() {
        return operationIdNamingConfig;
    }

    /** {@return the naming configuration for parameter names} */
    public String getParameterNaming() {
        return parameterNamingConfig;
    }

    /** {@return the naming configuration for api groups} */
    public String getApiNaming() {
        return apiNamingConfig;
    }

    /** {@return the naming configuration for types} */
    public String getTypeNaming() {
        return typeNamingConfig;
    }

    /** {@return the naming configuration for multipart types} */
    public String getMultipartTypeNaming() {
        return multipartTypeNamingConfig;
    }

    /** {@return the naming configuration for MP schema name} */
    public String getMpSchemaNaming() {
        return mpSchemaNamingConfig;
    }
}
