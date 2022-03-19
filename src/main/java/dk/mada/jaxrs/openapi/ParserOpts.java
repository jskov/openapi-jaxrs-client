package dk.mada.jaxrs.openapi;

import java.util.Properties;

/**
 * parser-* configuration options.
 */
public final class ParserOpts {
    /** User options. */
    private final Properties options;

    /**
     * Constructs a new instance.
     *
     * @param options the user provided options
     */
    public ParserOpts(Properties options) {
        this.options = options;
    }

    /** {@return true if {@literal List<byte[]>} should be unwrapped to {@literal byte[]}} */
    public boolean isUnwrapByteArrayList() {
        return bool("parser-unwrap-bytearray-list");
    }

    /** {@return true if the JSE type LocalTime should be used} */
    public boolean isJseLocalTime() {
        return bool("parser-localtime-is-jse", true);
    }

    /** {@return true if the JSE type LocalDate should be used} */
    public boolean isJseLocalDate() {
        return bool("parser-localdate-is-jse", true);
    }

    /** {@return true if the JSE type LocalDateTime should be used} */
    public boolean isJseLocalDateTime() {
        return bool("parser-localdatetime-is-jse", true);
    }

    /** {@return true if the JSE type OffsetDateTime should be used} */
    public boolean isJseOffsetDateTime() {
        return bool("parser-offsetdatetime-is-jse", true);
    }

    /** {@return true if the JSE type ZonedDateTime should be used instead of OffsetDateTime} */
    public boolean isJseZonedDateTime() {
        return bool("parser-zoneddatetime-is-jse", true);
    }

    /** {@return true if the JSE type BigDecimal should be used} */
    public boolean isJseBigDecimal() {
        return bool("parser-bigdecimal-is-jse", true);
    }

    /** {@return true if the SchemaUUID type is to be treated as java.util.UUID, otherwise false} */
    public boolean isJseUUID() {
        return bool("parser-uuid-is-jse", true);
    }

    /** {@return true if the InputStream type is to be treated as java.io.InputStream, otherwise false} */
    public boolean isJseInputStream() {
        return bool("parser-inputstream-is-jse", true);
    }

    /** {@return true if a void operation returning 200 should be changed to return 204} */
    public boolean isFixupVoid200to204() {
        return bool("parser-fixup-void-200-to-204", false);
    }

    private boolean bool(String name) {
        return bool(name, false);
    }

    private boolean bool(String name, boolean defaultValue) {
        return Boolean.parseBoolean(options.getProperty(name, Boolean.toString(defaultValue)));
    }
}
