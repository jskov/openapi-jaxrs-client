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

    public boolean isUnwrapByteArrayList() {
        return bool("parser-unwrap-bytearray-list");
    }

    public boolean isJseLocalTime() {
        return bool("parser-localtime-is-jse", true);
    }

    public boolean isJseLocalDate() {
        return bool("parser-localdate-is-jse", true);
    }

    public boolean isJseLocalDateTime() {
        return bool("parser-localdatetime-is-jse", true);
    }

    public boolean isJseOffsetDateTime() {
        return bool("parser-offsetdatetime-is-jse", true);
    }

    public boolean isJseZonedDateTime() {
        return bool("parser-zoneddatetime-is-jse", true);
    }

    public boolean isJseBigDecimal() {
        return bool("parser-bigdecimal-is-jse", true);
    }

    /** {@return true if the SchemaUUID type is to be treated as java.util.UUID, otherwise false} */
    public boolean isJseUUID() {
        return bool("parser-uuid-is-jse", true);
    }

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
