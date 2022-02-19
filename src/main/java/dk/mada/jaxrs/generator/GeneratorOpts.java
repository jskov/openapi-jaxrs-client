package dk.mada.jaxrs.generator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import dk.mada.jaxrs.Generator;
import dk.mada.jaxrs.openapi.ParserOpts;

/**
 * Generator configuration options.
 *
 * Extracts generator-specific keys from the
 * input properties provided by the user.
 */
public final class GeneratorOpts {
    /** Generator option for API package. */
    public static final String GENERATOR_API_PACKAGE = "generator-api-package";
    /** Generator option for DTO package. */
    public static final String GENERATOR_DTO_PACKAGE = "generator-dto-package";

    /** Time that the code was generated. */
    private final String generatedAtTime;
    /** Parser options. */
    private final ParserOpts parserOpts;
    /** All user's input options. */
    private final Properties options;

    /** Selects Jackson Codehaus as output format. */
    private final boolean useJacksonCodehaus;
    /** Selects Jackson FasterXml as output format. */
    private final boolean useJacksonFasterxml;
    /** Selects Jsonb as output format (this is the default). */
    private final boolean useJsonb;
    /** Selects use of jakarta over javax for JAX-RS types. */
    private final boolean useJakarta;

    /**
     * Constructs a new instance.
     *
     * @param options user's options
     * @param parserOpts parser options
     */
    public GeneratorOpts(Properties options, ParserOpts parserOpts) {
        this.options = options;
        this.parserOpts = parserOpts;

        generatedAtTime = LocalDateTime.now()
                .withNano(0)
                .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        useJacksonCodehaus = bool("generator-jackson-codehaus");
        useJacksonFasterxml = bool("generator-jackson-fasterxml");
        boolean willUseJsonb = bool("generator-jsonb");

        int activatedSerializerApis = 0;
        if (useJacksonCodehaus) {
            activatedSerializerApis++;
        }
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

        useJakarta = bool("generator-jakarta");
    }

    /**
     * {@return the id of this generator}
     *
     * Used in the @Generator annotation in all generated files.
     */
    public String generatorId() {
        return Generator.class.getName();
    }

    /** {@return the package to generate API classes to } */
    public String apiPackage() {
        return getRequired(GENERATOR_API_PACKAGE, "apiPackage");
    }

    /** {@return the API package in path-form} */
    public String apiPackageDir() {
        return apiPackage().replace('.', '/');
    }

    /** {@return the package to generate DTO classes to } */
    public String dtoPackage() {
        return getRequired(GENERATOR_DTO_PACKAGE, "modelPackage");
    }

    /** {@return the DTO package in path-form} */
    public String dtoPackageDir() {
        return dtoPackage().replace('.', '/');
    }

    /** {@return true if rendering for jackson, otherwise false} */
    public boolean isJackson() {
        return isJacksonCodehaus() || isJacksonFasterxml();
    }

    /** {@return true if rendering for jackson codehaus, otherwise false} */
    public boolean isJacksonCodehaus() {
        return useJacksonCodehaus;
    }

    /** {@return true if rendering for jackson fasterxml, otherwise false} */
    public boolean isJacksonFasterxml() {
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
        return getJsonSerializeOptions() != null;
    }

    /** {@return json serialize options} */
    public String getJsonSerializeOptions() {
        if (!isJackson()) {
            return null;
        }
        return get("generator-jackson-json-serialize-options");
    }

    /** {@return true if a jackson OffsetDateTime serializer should be rendered} */
    public boolean isUseJacksonOffsetDateTimeSerializer() {
        return parserOpts.isJseOffsetDateTime() && isJackson();
    }

    /** {@return true if a jackson LocalDate serializer should be rendered} */
    public boolean isUseJacksonLocalDateSerializer() {
        return parserOpts.isJseLocalDate() && isJackson();
    }

    /** {@return the LocalDate wire format for jackson, or null} */
    public String getJacksonLocalDateWireFormat() {
        if (!isUseJacksonLocalDateSerializer()) {
            return null;
        }
        return getDefault("generator-jackson-localdate-wire-format", "ISO_LOCAL_DATE");
    }

    /** {@return true if bean validation should be used, otherwise fasle} */
    public boolean isUseBeanValidation() {
        return bool("generator-use-bean-validation", true);
    }

    /** {@return true if BigDecimal should be used for double, otherwise use Double} */
    public boolean isUseBigDecimalForDouble() {
        return bool("generator-use-bigdecimal-for-double");
    }

    /** {@return true if collections should be initialized as empty, otherwise will be null} */
    public boolean isUseEmptyCollections() {
        return bool("generator-use-empty-collections");
    }

    /** {@return true if date-time should be rendered with ZonedDateTime, otherwise use OffsetDateTime} */
    public boolean isUseZonedDateTime() {
        return bool("generator-use-zoneddatetime");
    }

    /** {@return true if boolean getters should use 'get' as prefix, otherwise use 'is'} */
    public boolean isUseBooleanGetPrefix() {
        return bool("generator-use-boolean-get-prefix");
    }

    /** {@return the time the generation happened if enabled, or null} */
    public String getGeneratedAtTime() {
        if (isShowGenerationTimestamp()) {
            return generatedAtTime;
        }
        return null;
    }

    private boolean isShowGenerationTimestamp() {
        return bool("generator-use-generated-timestamp");
    }

    /**
     * {@return true if wrapped primitives should be used in API parameters}
     *
     * API parameters representing primitives can use the
     * primitives in the API (default) or their wrapper counterparts.
     *
     * @see <a href="https://jakarta.ee/specifications/restful-ws/3.0/jakarta-restful-ws-spec-3.0.html#resources">resources spec</a>
     * @see <a href="https://jakarta.ee/specifications/restful-ws/3.0/apidocs/jakarta/ws/rs/defaultvalue">jakarta.ws.rs.DefaultValue</a>
     *
     * @return true if wrappers should be used
     */
    public boolean isUseApiWrappedPrimitives() {
        return bool("generator-use-api-wrapped-primitives", false);
    }

    /** {@return the prefix to use for number enumeration constants} */
    public String getEnumNumberPrefix() {
        return getDefault("generator-enum-prefix-number", "NUMBER_");
    }

    private boolean bool(String name) {
        return Boolean.parseBoolean(get(name));
    }

    private boolean bool(String name, boolean defaultValue) {
        return Boolean.parseBoolean(options.getProperty(name, Boolean.toString(defaultValue)));
    }

    private String getRequired(String name, String compatibleOptionName) {
        String compat = options.getProperty(compatibleOptionName);
        String value = options.getProperty(name, compat);
        if (value == null) {
            throw new IllegalArgumentException("The property " + name + " must be specified!");
        }
        return value.trim();
    }

    private String getDefault(String name, String defaultValue) {
        String value = options.getProperty(name);
        if (value == null) {
            return defaultValue;
        }
        return value.trim();
    }

    private String get(String name) {
        String value = options.getProperty(name);
        if (value == null) {
            return null;
        }
        return value.trim();
    }
}
