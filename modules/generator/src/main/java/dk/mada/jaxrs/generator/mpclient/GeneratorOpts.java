package dk.mada.jaxrs.generator.mpclient;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import dk.mada.jaxrs.generator.mpclient.imports.UserMappedImport;
import dk.mada.jaxrs.model.options.OptionReader;
import dk.mada.jaxrs.model.types.TypeDateTime;
import dk.mada.jaxrs.model.types.TypeDateTime.DateTimeVariant;

/**
 * Generator configuration options.
 *
 * Extracts generator-specific keys from the input properties provided by the user.
 */
public final class GeneratorOpts {
    /** The ID of this generator. */
    private static final String GENERATOR_ID = "dk.mada.jaxrs.Generator";
    /** Generator option for API package. */
    public static final String GENERATOR_API_PACKAGE = "generator-api-package";
    /** Generator option for DTO package. */
    public static final String GENERATOR_DTO_PACKAGE = "generator-dto-package";

    /** Time that the code was generated. */
    private final String generatedAtTime;
    /** User options. */
    private final OptionReader or;

    /** Selects Jackson FasterXml as output format. */
    private final boolean useJacksonFasterxml;
    /** Selects Jsonb as output format (this is the default). */
    private final boolean useJsonb;
    /** Selects use of jakarta over javax for JAX-RS types. */
    private final boolean useJakarta;
    /** Flag for using OffsetDateTime serializer. */
    private final boolean useJacksonOffsetDateTimeSerializer;
    /** Flag for using LocalDateTime serializer. */
    private final boolean useJacksonLocalDateTimeSerializer;
    /** Flag for using LocalDate serializer. */
    private final boolean useJacksonLocalDateSerializer;

    /**
     * Constructs a new instance.
     *
     * @param or               option reader
     * @param leakedParserOpts leaked parser options
     */
    public GeneratorOpts(OptionReader or, LeakedParserOpts leakedParserOpts) {
        this.or = or;

        generatedAtTime = LocalDateTime.now()
                .withNano(0)
                .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        useJacksonFasterxml = or.bool("generator-jackson-fasterxml");
        boolean willUseJsonb = or.bool("generator-jsonb");

        int activatedSerializerApis = 0;
        if (useJacksonFasterxml) {
            activatedSerializerApis++;
        }
        if (willUseJsonb) {
            activatedSerializerApis++;
        }
        if (activatedSerializerApis > 1) {
            throw new IllegalStateException("Only one serializer API can be enabled!");
        }

        // jsonb is the default if nothing else specified
        if (activatedSerializerApis == 0) {
            willUseJsonb = true;
        }
        useJsonb = willUseJsonb;

        useJakarta = or.bool("generator-jakarta");

        useJacksonOffsetDateTimeSerializer = useJacksonFasterxml && leakedParserOpts.isJseOffsetDateTime();
        useJacksonLocalDateTimeSerializer = useJacksonFasterxml && leakedParserOpts.isJseLocalDateTime();
        useJacksonLocalDateSerializer = useJacksonFasterxml && leakedParserOpts.isJseLocalDate();
    }

    /**
     * Parser options leaked into the generator. These should be eventually be removed when possible.
     *
     * @param isJseOffsetDateTime true if the OffsetDateTime DTO is represented by JSE
     * @param isJseLocalDateTime  true if the LocalDateTime DTO is represented by JSE
     * @param isJseLocalDate      true if the LocalDate DTO is represented by JSE
     */
    public record LeakedParserOpts(boolean isJseOffsetDateTime, boolean isJseLocalDateTime, boolean isJseLocalDate) {
    }

    /**
     * {@return the id of this generator}
     *
     * Used in the @Generator annotation in all generated files. Keep "dk.mada.jaxrs.Generator" as long as this is the only
     * generator. (yes, it is the wrong class, but it does not matter much)
     */
    public String generatorId() {
        return GENERATOR_ID;
    }

    /** {@return the package to generate API classes to } */
    public String apiPackage() {
        return or.getRequired(GENERATOR_API_PACKAGE, "apiPackage");
    }

    /** {@return the API package in path-form} */
    public String apiPackageDir() {
        return apiPackage().replace('.', '/');
    }

    /** {@return the package to generate DTO classes to } */
    public String dtoPackage() {
        return or.getRequired(GENERATOR_DTO_PACKAGE, "modelPackage");
    }

    /** {@return the DTO package in path-form} */
    public String dtoPackageDir() {
        return dtoPackage().replace('.', '/');
    }

    /** {@return true if rendering for jackson, otherwise false} */
    public boolean isJackson() {
        return useJacksonFasterxml;
    }

    /** {@return true if rendering for jsonb, otherwise false} */
    public boolean isJsonb() {
        return useJsonb;
    }

    /** {@return true if rendering for jakarta, false if rendering for javax} */
    public boolean isJakarta() {
        return useJakarta;
    }

    /** {@return true if json serializer options should be used} */
    public boolean isUseJsonSerializeOptions() {
        return getJsonSerializeOptions().isPresent();
    }

    /** {@return optional json serialize options} */
    public Optional<String> getJsonSerializeOptions() {
        if (!isJackson()) {
            return Optional.empty();
        }
        return or.get("generator-jackson-json-serialize-options");
    }

    /** {@return true if a jackson date-time serializer should be rendered} */
    public boolean isUseJacksonDateTimeSerializer() {
        return useJacksonOffsetDateTimeSerializer && useJacksonLocalDateTimeSerializer;
    }

    /** {@return true if a jackson LocalDate serializer should be rendered} */
    public boolean isUseJacksonLocalDateSerializer() {
        return useJacksonLocalDateSerializer;
    }

    /** {@return true if a jackson LocalDateTime serializer should be rendered} */
    public boolean isUseJacksonLocalDateTimeSerializer() {
        return useJacksonLocalDateTimeSerializer;
    }

    /** {@return true if a jackson OffsetDateTime serializer should be rendered} */
    public boolean isUseJacksonOffsetDateTimeSerializer() {
        return useJacksonOffsetDateTimeSerializer;
    }

    /** {@return the optional LocalDate wire format for jackson} */
    public Optional<String> getJacksonLocalDateWireFormat() {
        if (!isUseJacksonLocalDateSerializer()) {
            return Optional.empty();
        }
        return or.getOptDefault("generator-jackson-localdate-wire-format", "ISO_LOCAL_DATE");
    }

    /** {@return the optional LocalDateTime wire format for jackson} */
    public Optional<String> getJacksonLocalDateTimeWireFormat() {
        if (!isUseJacksonLocalDateTimeSerializer()) {
            return Optional.empty();
        }
        return or.getOptDefault("generator-jackson-localdatetime-wire-format", "ISO_LOCAL_DATE_TIME");
    }

    /** {@return the optional jackson LocalDate deserializer class name} */
    public Optional<String> getJacksonLocalDateDeserializer() {
        if (!isUseJacksonLocalDateSerializer()) {
            return Optional.empty();
        }
        return or.getOptDefault("generator-jackson-localdate-deserializer",
                ExtraTemplate.LOCAL_DATE_JACKSON_DESERIALIZER.classname());
    }

    /** {@return the optional jackson LocalDate serializer class name} */
    public Optional<String> getJacksonLocalDateSerializer() {
        if (!isUseJacksonLocalDateSerializer()) {
            return Optional.empty();
        }
        return or.getOptDefault("generator-jackson-localdate-serializer",
                ExtraTemplate.LOCAL_DATE_JACKSON_SERIALIZER.classname());
    }

    /** {@return the optional jackson LocalDateTime deserializer class name} */
    public Optional<String> getJacksonLocalDateTimeDeserializer() {
        if (!isUseJacksonLocalDateSerializer()) {
            return Optional.empty();
        }
        return or.getOptDefault("generator-jackson-localdatetime-deserializer",
                ExtraTemplate.LOCAL_DATE_TIME_JACKSON_DESERIALIZER.classname());
    }

    /** {@return the optional jackson LocalDateTime serializer class name} */
    public Optional<String> getJacksonLocalDateTimeSerializer() {
        if (!isUseJacksonLocalDateTimeSerializer()) {
            return Optional.empty();
        }
        return or.getOptDefault("generator-jackson-localdatetime-serializer",
                ExtraTemplate.LOCAL_DATE_TIME_JACKSON_SERIALIZER.classname());
    }

    /** {@return the optional jackson OffsetDateTime deserializer class name} */
    public Optional<String> getJacksonOffsetDateTimeDeserializer() {
        if (!isUseJacksonLocalDateSerializer()) {
            return Optional.empty();
        }
        return or.getOptDefault("generator-jackson-offsetdatetime-deserializer",
                ExtraTemplate.OFFSET_DATE_TIME_JACKSON_DESERIALIZER.classname());
    }

    /** {@return the optional jackson OffsetDateTime serializer class name} */
    public Optional<String> getJacksonOffsetDateTimeSerializer() {
        if (!isUseJacksonLocalDateTimeSerializer()) {
            return Optional.empty();
        }
        return or.getOptDefault("generator-jackson-offsetdatetime-serializer",
                ExtraTemplate.OFFSET_DATE_TIME_JACKSON_SERIALIZER.classname());
    }

    /** {@return the optional OffsetDateTime wire format for jackson} */
    public Optional<String> getJacksonOffsetDateTimeWireFormat() {
        if (!isUseJacksonOffsetDateTimeSerializer()) {
            return Optional.empty();
        }
        return or.getOptDefault("generator-jackson-offsetdatetime-wire-format", "ISO_OFFSET_DATE_TIME");
    }

    /** {@return the optional MP client config key} */
    public Optional<String> getMpClientConfigKey() {
        return or.get("generator-mp-api-register-rest-client");
    }

    /** {@return the MP providers} */
    public List<String> getMpProviders() {
        return or.getListDefault("generator-mp-api-register-providers", "");
    }

    /** {@return the list of DTO classes to skip when generating code} */
    public List<String> getSkippedDtoClasses() {
        return or.getListDefault("generator-dto-skip-types", "");
    }

    /**
     * Returns mapping of external types.
     *
     * Maps a (OpenApi document) type name (key) into its fully-qualified class name (value). The keySet serves as a set of
     * DTOs *not* to generate.
     *
     * @return mapping of types names to external type imports
     **/
    public Map<String, UserMappedImport> getExternalTypeMapping() {
        String s = or.get("generator-map-external-types").orElse("");
        if (s.isBlank()) {
            return Map.of();
        }

        Map<String, UserMappedImport> typeMapping = new HashMap<>();

        for (String mapping : s.split(";", -1)) {
            int index = mapping.indexOf(":");
            if (index == -1 || (index + 1) > mapping.length()) {
                throw new IllegalArgumentException("No package-to-types mapping found in '" + s + "'");
            }
            String pkg = mapping.substring(0, index).trim();
            String types = mapping.substring(index + 1).trim();

            for (String type : types.split(",", -1)) {
                String tt = type.trim();
                typeMapping.put(tt, new UserMappedImport(pkg + "." + tt));
            }
        }

        return typeMapping;
    }

    /** {@return true if the extra-template for a jackson LocalDate deserializer should be added, otherwise false} */
    public boolean isAddJacksonLocalDateDeserializerTemplate() {
        return getJacksonLocalDateDeserializer()
                .map(ExtraTemplate.LOCAL_DATE_JACKSON_DESERIALIZER.classname()::equals)
                .orElse(false);
    }

    /** {@return true if the extra-template for a jackson LocalDate serializer should be added, otherwise false} */
    public boolean isAddJacksonLocalDateSerializerTemplate() {
        return getJacksonLocalDateSerializer()
                .map(ExtraTemplate.LOCAL_DATE_JACKSON_SERIALIZER.classname()::equals)
                .orElse(false);
    }

    /** {@return true if the extra-template for a jackson LocalDateTime deserializer should be added, otherwise false} */
    public boolean isAddJacksonLocalDateTimeDeserializerTemplate() {
        return getJacksonLocalDateTimeDeserializer()
                .map(ExtraTemplate.LOCAL_DATE_TIME_JACKSON_DESERIALIZER.classname()::equals)
                .orElse(false);
    }

    /** {@return true if the extra-template for a jackson LocalDateTime serializer should be added, otherwise false} */
    public boolean isAddJacksonLocalDateTimeSerializerTemplate() {
        return getJacksonLocalDateTimeSerializer()
                .map(ExtraTemplate.LOCAL_DATE_TIME_JACKSON_SERIALIZER.classname()::equals)
                .orElse(false);
    }

    /** {@return true if the extra-template for a jackson OffsetDateTime deserializer should be added, otherwise false} */
    public boolean isAddJacksonOffsetDateTimeDeserializerTemplate() {
        return getJacksonOffsetDateTimeDeserializer()
                .map(ExtraTemplate.OFFSET_DATE_TIME_JACKSON_DESERIALIZER.classname()::equals)
                .orElse(false);
    }

    /** {@return true if the extra-template for a jackson OffsetDateTime serializer should be added, otherwise false} */
    public boolean isAddJacksonOffsetDateTimeSerializerTemplate() {
        return getJacksonOffsetDateTimeSerializer()
                .map(ExtraTemplate.OFFSET_DATE_TIME_JACKSON_SERIALIZER.classname()::equals)
                .orElse(false);
    }

    /** {@return true if bean validation should be used, otherwise false} */
    public boolean isUseBeanValidation() {
        return or.bool("generator-use-bean-validation", true);
    }

    /** {@return true if DTOs should be marked with Serializable, otherwise false} */
    public boolean isUseSerializable() {
        return or.bool("generator-use-serializable", false);
    }

    /** {@return true if BigDecimal should be used for double, otherwise use Double} */
    public boolean isUseBigDecimalForDouble() {
        return or.bool("generator-use-bigdecimal-for-double");
    }

    /** {@return true if collections should be initialized as empty, otherwise will be null} */
    public boolean isUseEmptyCollections() {
        return or.bool("generator-use-empty-collections");
    }

    /** {@return true if date-time should be rendered with ZonedDateTime} */
    public boolean isUseZonedDateTime() {
        return or.bool("generator-use-zoneddatetime");
    }

    /** {@return true if date-time should be rendered with LocalDateTime} */
    public boolean isUseLocalDateTime() {
        return or.bool("generator-use-localdatetime");
    }

    /** {@return true if boolean getters should use 'get' as prefix, otherwise use 'is'} */
    public boolean isUseBooleanGetPrefix() {
        return or.bool("generator-use-boolean-get-prefix");
    }

    /** {@return the time the generation happened if enabled, or null} */
    public Optional<String> getGeneratedAtTime() {
        if (isShowGenerationTimestamp()) {
            return Optional.of(generatedAtTime);
        }
        return Optional.empty();
    }

    /** {@return true if the property order annotation should be rendered} */
    public boolean isUsePropertyOrderAnnotation() {
        return or.bool("generator-use-property-order-annotation", false);
    }

    private boolean isShowGenerationTimestamp() {
        return or.bool("generator-use-generated-timestamp");
    }

    /** {@return the fully-qualified @Generated annotation class} */
    public String getGeneratorAnnotationClass() {
        if (or.bool("generator-use-generated-jdk", true)) {
            return "@javax.annotation.processing.Generated";
        } else {
            return "@javax.annotation.Generated";
        }
    }

    /** {@return the property sorting order to use} */
    public PropertyOrder getPropertyOrder() {
        String order = or.getDefault("generator-use-property-order", PropertyOrder.ALPHABETICAL_NOCASE_ORDER.name());
        return PropertyOrder.from(order);
    }

    /** {@return true if enumerations should deserialize unknown input to 'unknown_default_open_api'} */
    public boolean isUseEnumUnknownDefault() {
        return or.bool("generator-use-enum-unknown-default");
    }

    /**
     * {@return true if wrapped primitives should be used in API parameters}
     *
     * API parameters representing primitives can use the primitives in the API (default) or their wrapper counterparts.
     *
     * @see <a href="https://jakarta.ee/specifications/restful-ws/3.0/jakarta-restful-ws-spec-3.0.html#resources">resources
     *      spec</a>
     * @see <a href=
     *      "https://jakarta.ee/specifications/restful-ws/3.0/apidocs/jakarta/ws/rs/defaultvalue">jakarta.ws.rs.DefaultValue</a>
     */
    public boolean isUseApiWrappedPrimitives() {
        return or.bool("generator-use-api-wrapped-primitives", false);
    }

    /** {@return the default Api resource name} */
    public Optional<String> getDefaultApiName() {
        return or.get("generator-api-default-name");
    }

    /** {@return true if generation of API classes should be skipped.} */
    public boolean isSkipApiClasses() {
        return or.bool("generator-api-skip", false);
    }

    /** {@return list of media types that should be handled as input stream} */
    public List<String> getResponseInputStreamMediaTypes() {
        return or.getListDefault("generator-api-response-inputstream-mediatypes", "");
    }

    /** {@return true if @RegisterForReflection should be added to DTOs} */
    public boolean isUseRegisterForReflection() {
        return or.bool("generator-quarkus-use-register-for-reflection");
    }

    /** {@return true if the destination folder should be kept during testing} */
    public boolean isTestingKeepDestination() {
        return or.bool("generator-testing-keep-destination");
    }

    /**
     * Property sorting order.
     */
    public enum PropertyOrder {
        /** Ordered by appearance in the OpenApi document. */
        DOCUMENT_ORDER,
        /** Ordered alphabetically. */
        ALPHABETICAL_ORDER,
        /** Ordered alphabetically, ignoring upper/lower case. */
        ALPHABETICAL_NOCASE_ORDER;

        /**
         * Converts property value enum value.
         *
         * @param value the input property value
         * @return the matching property order enumeration
         */
        public static PropertyOrder from(String value) {
            String name = value.toUpperCase(Locale.ROOT).replace('-', '_');
            for (var po : PropertyOrder.values()) {
                if (po.name().equals(name)) {
                    return po;
                }
            }
            throw new IllegalArgumentException("Unknown PropertyOrder " + name);
        }
    }

    /** {@return the date-time implementation variant to use} */
    public TypeDateTime.DateTimeVariant getDateTimeVariant() {
        if (isUseZonedDateTime() && isUseLocalDateTime()) {
            throw new IllegalArgumentException("You can only select one date-time implementation!");
        }

        if (isUseZonedDateTime()) {
            return DateTimeVariant.ZONED;
        }
        if (isUseLocalDateTime()) {
            return DateTimeVariant.LOCAL;
        }
        return DateTimeVariant.OFFSET;
    }
}