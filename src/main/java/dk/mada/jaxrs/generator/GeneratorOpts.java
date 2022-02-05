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
public class GeneratorOpts {
    public static final String GENERATOR_DTO_PACKAGE = "generator-dto-package";
    public static final String GENERATOR_API_PACKAGE = "generator-api-package";

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

    public String apiPackage() {
        return get(GENERATOR_API_PACKAGE, "apiPackage");
    }

    public String apiPackageDir() {
        return apiPackage().replace('.', '/');
    }

    public String dtoPackage() {
        return get(GENERATOR_DTO_PACKAGE, "modelPackage");
    }

    public String dtoPackageDir() {
        return dtoPackage().replace('.', '/');
    }

    public boolean isJackson() {
        return isJacksonCodehaus() || isJacksonFasterxml();
    }

    public boolean isJacksonCodehaus() {
        return useJacksonCodehaus;
    }

    public boolean isJacksonFasterxml() {
        return useJacksonFasterxml;
    }

    public boolean isJsonb() {
        return useJsonb;
    }

    public boolean isJakarta() {
        return useJakarta;
    }

    public boolean isUseJsonSerializeOptions() {
        return getJsonSerializeOptions() != null;
    }

    public String getJsonSerializeOptions() {
        if (!isJackson()) {
            return null;
        }
        return get("generator-jackson-json-serialize-options");
    }

    public boolean isUseJacksonOffsetDateTimeSerializer() {
        return parserOpts.isJseOffsetDateTime() && isJackson();
    }

    public boolean isUseJacksonLocalDateSerializer() {
        return parserOpts.isJseLocalDate() && isJackson();
    }

    public String getJacksonLocalDateWireFormat() {
        if (!isUseJacksonLocalDateSerializer()) {
            return null;
        }
        return getDefault("generator-jackson-localdate-wire-format", "ISO_LOCAL_DATE");
    }

    public boolean isUseBigDecimalForDouble() {
        return bool("generator-use-bigdecimal-for-double");
    }

    public boolean isUseEmptyCollections() {
        return bool("generator-use-empty-collections");
    }

    public boolean isUseZonedDateTime() {
        return bool("generator-use-zoneddatetime");
    }

    public boolean isUseBooleanGetPrefix() {
        return bool("generator-use-boolean-get-prefix");
    }

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

    public String getEnumNumberPrefix() {
        return getDefault("generator-enum-prefix-number", "NUMBER_");
    }

    @SuppressWarnings("unused")
    private boolean bool(String name, String compatOptionName) {
        return Boolean.parseBoolean(get(name, compatOptionName));
    }

    private boolean bool(String name) {
        return Boolean.parseBoolean(get(name));
    }

    private boolean bool(String name, boolean defaultValue) {
        return Boolean.parseBoolean(options.getProperty(name, Boolean.toString(defaultValue)));
    }

    private String get(String name, String compatibleOptionName) {
        String compat = options.getProperty(compatibleOptionName);
        String value = options.getProperty(name, compat);
        if (value == null) {
            return null;
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
