package dk.mada.jaxrs.generator.mpclient;

import dk.mada.jaxrs.generator.mpclient.imports.UserMappedImport;
import dk.mada.jaxrs.model.options.OptionReader;
import dk.mada.jaxrs.model.types.Primitive;
import dk.mada.jaxrs.model.types.TypeDateTime;
import dk.mada.jaxrs.model.types.TypeDateTime.DateTimeVariant;
import dk.mada.jaxrs.model.types.TypeName;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Generator configuration options.
 *
 * Extracts generator-specific keys from the input properties provided by the user.
 */
public final class GeneratorOpts {
    private static final Logger logger = LoggerFactory.getLogger(GeneratorOpts.class);
    /** The ID of this generator. */
    private static final String GENERATOR_ID = "dk.mada.jaxrs.Generator";
    /** Generator option for API package. */
    public static final String GENERATOR_API_PACKAGE = "generator-api-package";
    /** Generator option for DTO package. */
    public static final String GENERATOR_DTO_PACKAGE = "generator-dto-package";
    /** Generator option for property conflict resolution. */
    public static final String GENERATOR_USE_PROPERTY_CONFLICT_RESOLUTION =
            "generator-use-property-conflict-resolution";
    /** Generator option for no-format number */
    public static final String GENERATOR_TYPE_NO_FORMAT_NUMBER = "generator-type-no-format-number";

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
    /** Flag for using jspecify nullable annotations. */
    private final boolean useJspecify;
    /** Flag for rendering DTOs as records. */
    private final boolean useRecords;
    /** Flag for using OffsetDateTime serializer. */
    private final boolean useJacksonOffsetDateTimeSerializer;
    /** Flag for using LocalDateTime serializer. */
    private final boolean useJacksonLocalDateTimeSerializer;
    /** Flag for using LocalDate serializer. */
    private final boolean useJacksonLocalDateSerializer;
    /** Predicate for record builders to create. */
    private final Predicate<TypeName> recordBuilderPredicate;

    /**
     * Constructs a new instance.
     *
     * @param or               option reader
     * @param leakedParserOpts leaked parser options
     */
    public GeneratorOpts(OptionReader or, LeakedParserOpts leakedParserOpts) {
        this.or = or;

        generatedAtTime = LocalDateTime.now().withNano(0).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

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
        useRecords = or.bool("generator-dto-records", false);
        useJspecify = or.bool("generator-jspecify", useRecords);

        useJacksonOffsetDateTimeSerializer = useJacksonFasterxml && leakedParserOpts.isJseOffsetDateTime();
        useJacksonLocalDateTimeSerializer = useJacksonFasterxml && leakedParserOpts.isJseLocalDateTime();
        useJacksonLocalDateSerializer = useJacksonFasterxml && leakedParserOpts.isJseLocalDate();

        String value = or.getDefault("generator-dto-records-use-builder", "none");
        RecordBuilderControl control = RecordBuilderControl.from(value);
        recordBuilderPredicate = switch (control) {
            case ALL -> tn -> true;
            case NONE -> tn -> false;
            case NAMED -> predicateFromNamed(value);
        };
    }

    /**
     * Parser options leaked into the generator. These should be eventually be removed when possible.
     *
     * @param isJseOffsetDateTime true if the OffsetDateTime DTO is represented by JSE
     * @param isJseLocalDateTime  true if the LocalDateTime DTO is represented by JSE
     * @param isJseLocalDate      true if the LocalDate DTO is represented by JSE
     */
    public record LeakedParserOpts(boolean isJseOffsetDateTime, boolean isJseLocalDateTime, boolean isJseLocalDate) {}

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

    /** {@return true if rendering with jspecify annotations} */
    public boolean isJspecify() {
        return useJspecify;
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
        return or.getOptDefault(
                "generator-jackson-localdate-deserializer", ExtraTemplate.LOCAL_DATE_JACKSON_DESERIALIZER.classname());
    }

    /** {@return the optional jackson LocalDate serializer class name} */
    public Optional<String> getJacksonLocalDateSerializer() {
        if (!isUseJacksonLocalDateSerializer()) {
            return Optional.empty();
        }
        return or.getOptDefault(
                "generator-jackson-localdate-serializer", ExtraTemplate.LOCAL_DATE_JACKSON_SERIALIZER.classname());
    }

    /** {@return the optional jackson LocalDateTime deserializer class name} */
    public Optional<String> getJacksonLocalDateTimeDeserializer() {
        if (!isUseJacksonLocalDateSerializer()) {
            return Optional.empty();
        }
        return or.getOptDefault(
                "generator-jackson-localdatetime-deserializer",
                ExtraTemplate.LOCAL_DATE_TIME_JACKSON_DESERIALIZER.classname());
    }

    /** {@return the optional jackson LocalDateTime serializer class name} */
    public Optional<String> getJacksonLocalDateTimeSerializer() {
        if (!isUseJacksonLocalDateTimeSerializer()) {
            return Optional.empty();
        }
        return or.getOptDefault(
                "generator-jackson-localdatetime-serializer",
                ExtraTemplate.LOCAL_DATE_TIME_JACKSON_SERIALIZER.classname());
    }

    /** {@return the optional jackson OffsetDateTime deserializer class name} */
    public Optional<String> getJacksonOffsetDateTimeDeserializer() {
        if (!isUseJacksonLocalDateSerializer()) {
            return Optional.empty();
        }
        return or.getOptDefault(
                "generator-jackson-offsetdatetime-deserializer",
                ExtraTemplate.OFFSET_DATE_TIME_JACKSON_DESERIALIZER.classname());
    }

    /** {@return the optional jackson OffsetDateTime serializer class name} */
    public Optional<String> getJacksonOffsetDateTimeSerializer() {
        if (!isUseJacksonLocalDateTimeSerializer()) {
            return Optional.empty();
        }
        return or.getOptDefault(
                "generator-jackson-offsetdatetime-serializer",
                ExtraTemplate.OFFSET_DATE_TIME_JACKSON_SERIALIZER.classname());
    }

    /** {@return the optional OffsetDateTime wire format for jackson} */
    public Optional<String> getJacksonOffsetDateTimeWireFormat() {
        if (!isUseJacksonOffsetDateTimeSerializer()) {
            return Optional.empty();
        }
        return or.getOptDefault("generator-jackson-offsetdatetime-wire-format", "ISO_OFFSET_DATE_TIME");
    }

    /** {@return the extra MP validation rules} */
    public boolean isUseMpValidationRules() {
        return or.bool("generator-use-mp-validation-rules", true);
    }

    /** {@return the optional additional API annotations} */
    public List<String> getApiAdditionalAnnotations() {
        return or.getListNewlineDefault("generator-api-additional-annotations", "");
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

    /** {@return true if OpenApi @Schema annotations should be added} */
    public boolean getUseOpenapiSchema() {
        return or.bool("generator-dto-use-openapi-schema", true);
    }

    /** {@return true if DTOs should be generated as records instead of POJOs} */
    public boolean isDtoRecords() {
        return useRecords;
    }

    /** {@return true if record DTOs should include null-checks} */
    public boolean isUseRecordsRequireNull() {
        return or.bool("generator-dto-records-use-requirenonnull", true);
    }

    /** {@return true if POJO DTOs should include null guards} */
    public boolean isUsePojoRequireNonNull() {
        return or.bool("generator-dto-pojo-use-requirenonnull", true);
    }

    /** {@return a predicate which will define which records to generate builders for} */
    public Predicate<TypeName> getRecordBuilderPredicate() {
        return recordBuilderPredicate;
    }

    private Predicate<TypeName> predicateFromNamed(String namedOpt) {
        int ix = namedOpt.indexOf(':');
        int splitIx = ix + 1;
        if (ix == -1 || splitIx > namedOpt.length()) {
            throw new IllegalArgumentException("Expected list of type names: '" + namedOpt + "'");
        }
        List<String> names = OptionReader.splitByComma(namedOpt.substring(splitIx));
        logger.debug("Will generate record builders for records named: {}", names);
        return tn -> names.contains(tn.name());
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

    /** {@return true if DTOs should use create a toString generating single-line output} */
    public boolean isUseSingleLineToString() {
        return or.bool("generator-use-single-line-tostring", false);
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

    /** {@return the line ending to use} */
    public LineEnding getLineEnding() {
        String le = or.getDefault("generator-use-line-ending", LineEnding.AUTO.name());
        return LineEnding.from(le);
    }

    /** {@return the selection of how to render authorization header argument in resources} */
    public AuthHeader getAuthHeaderSelection() {
        String le = or.getDefault("generator-api-use-authorization-header", AuthHeader.API.name());
        return AuthHeader.from(le);
    }

    /** {@return the property sorting order to use} */
    public PropertyOrder getPropertyOrder() {
        String order = or.getDefault("generator-use-property-order", PropertyOrder.ALPHABETICAL_NOCASE_ORDER.name());
        return PropertyOrder.from(order);
    }

    /** {@return the property conflict resolution to use} */
    public PropertyConflictResolution getPropertyConflictResolution() {
        String resolution =
                or.getDefault(GENERATOR_USE_PROPERTY_CONFLICT_RESOLUTION, PropertyConflictResolution.FAIL.name());
        return PropertyConflictResolution.from(resolution);
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

    /** {@return the primitive type to use for integers without format} */
    public String getNoFormatIntegerType() {
        return or.get("generator-type-no-format-integer").orElse(Primitive.SHORT.name());
    }

    /** {@return the primitive type to use for numbers without format} */
    public String getNoFormatNumberType() {
        return or.get(GENERATOR_TYPE_NO_FORMAT_NUMBER).orElse(BigDecimal.class.getSimpleName());
    }

    /** {@return true if generation of API classes should use multipart bodies.} */
    public boolean isApiUseMultipartForm() {
        return or.bool("generator-api-use-multipartform", false);
    }

    /** {@return true if generation of API classes should be skipped.} */
    public boolean isSkipApiClasses() {
        return or.bool("generator-api-skip", false);
    }

    /** {@return the @Produces media type to use for void methods} */
    public Optional<String> getVoidProducesMediaType() {
        return or.get("generator-api-void-produces-mediatype");
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
         * Converts property value to enumeration value.
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

    /**
     * Line endings.
     */
    public enum LineEnding {
        /** Auto - the platform's default. */
        AUTO(System.lineSeparator()),
        /** Unix line endings, LF. */
        UNIX("\n"),
        /** Windows line endings, CRLF. */
        WINDOWS("\r\n");

        /** The line ending's line break sequence. */
        final String lineBreak;

        LineEnding(String string) {
            this.lineBreak = string;
        }

        /** {@return the active line break sequence} */
        public String lineBreak() {
            return lineBreak;
        }

        /**
         * Converts property value to enumeration value.
         *
         * @param value the input property value
         * @return the matching line ending enumeration
         */
        public static LineEnding from(String value) {
            String name = value.toUpperCase(Locale.ROOT);
            for (var po : LineEnding.values()) {
                if (po.name().equals(name)) {
                    return po;
                }
            }
            throw new IllegalArgumentException("Unknown LineEnding " + name);
        }
    }

    /**
     * Authorization header control.
     */
    public enum AuthHeader {
        /** API - use what is dictated by the API (this is the default). */
        API,
        /** Enable on all resource methods. */
        ON,
        /** Disable. */
        OFF;

        /**
         * Converts property value to enumeration value.
         *
         * @param value the input property value
         * @return the matching authorization header selection
         */
        public static AuthHeader from(String value) {
            return AuthHeader.valueOf(value.toUpperCase(Locale.ROOT));
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

    /**
     * The resolution to use when a property has conflicting declarations.
     */
    public enum PropertyConflictResolution {
        /** Fails the code generator. */
        FAIL,
        /** Clears the conflicting information. */
        CLEAR,
        /** Uses the first declaration information. */
        FIRST;
        // LEAST_RESTRICTIVE
        // MOST_RESTRICTIVE

        /**
         * Converts property value enum value.
         *
         * @param value the input property value
         * @return the matching property order enumeration
         */
        public static PropertyConflictResolution from(String value) {
            String name = value.toUpperCase(Locale.ROOT).replace('-', '_');
            for (var po : PropertyConflictResolution.values()) {
                if (po.name().equals(name)) {
                    return po;
                }
            }
            throw new IllegalArgumentException("Unknown PropertyConflictResolution " + name);
        }
    }

    /**
     * Control of builders in records.
     */
    public enum RecordBuilderControl {
        /** Create builder in all records. */
        ALL,
        /** Create builder in named records only. */
        NAMED,
        /** No builders created. */
        NONE;

        /**
         * Converts enum value.
         *
         * @param value the input configuration value
         * @return the matching record builder control
         */
        public static RecordBuilderControl from(String value) {
            String name = value.toUpperCase(Locale.ROOT).replace('-', '_').replaceAll(":.*", "");
            for (var po : RecordBuilderControl.values()) {
                if (po.name().equals(name)) {
                    return po;
                }
            }
            throw new IllegalArgumentException("Unknown RecordBuilderControl " + name);
        }
    }
}
