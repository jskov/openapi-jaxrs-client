package dk.mada.jaxrs.openapi;

import java.util.List;

import dk.mada.jaxrs.model.api.ContentSelector;
import dk.mada.jaxrs.model.options.OptionReader;

/**
 * parser-* configuration options.
 */
public final class ParserOpts {
    /** User options. */
    private final OptionReader or;

    /**
     * Constructs a new instance.
     *
     * @param or option reader
     */
    public ParserOpts(OptionReader or) {
        this.or = or;
    }

    /** {@return list of preferred media types selection if there are multiple types for responses} */
    public List<String> getPreferredResponseMediaTypes() {
        return or.getListDefault(ContentSelector.PARSER_API_PREFERRED_RESPONSE_MEDIATYPES, "");
    }

    /** {@return list of preferred media types selection if there are multiple types for requests} */
    public List<String> getPreferredRequestMediaTypes() {
        return or.getListDefault(ContentSelector.PARSER_API_PREFERRED_REQUEST_MEDIATYPES, "");
    }

    /** {@return true if {@literal List<byte[]>} should be unwrapped to {@literal byte[]}} */
    public boolean isUnwrapByteArrayList() {
        return or.bool("parser-unwrap-bytearray-list");
    }

    /** {@return true if the JSE type LocalTime should be used} */
    public boolean isJseLocalTime() {
        return or.bool("parser-localtime-is-jse", true);
    }

    /** {@return true if the JSE type LocalDate should be used} */
    public boolean isJseLocalDate() {
        return or.bool("parser-localdate-is-jse", true);
    }

    /** {@return true if the JSE type LocalDateTime should be used} */
    public boolean isJseLocalDateTime() {
        return or.bool("parser-localdatetime-is-jse", true);
    }

    /** {@return true if the JSE type OffsetDateTime should be used} */
    public boolean isJseOffsetDateTime() {
        return or.bool("parser-offsetdatetime-is-jse", true);
    }

    /** {@return true if the JSE type ZonedDateTime should be used instead of OffsetDateTime} */
    public boolean isJseZonedDateTime() {
        return or.bool("parser-zoneddatetime-is-jse", true);
    }

    /** {@return true if the JSE type BigDecimal should be used} */
    public boolean isJseBigDecimal() {
        return or.bool("parser-bigdecimal-is-jse", true);
    }

    /** {@return true if the SchemaUUID type is to be treated as java.util.UUID, otherwise false} */
    public boolean isJseUUID() {
        return or.bool("parser-uuid-is-jse", true);
    }

    /** {@return true if the InputStream type is to be treated as java.io.InputStream, otherwise false} */
    public boolean isJseInputStream() {
        return or.bool("parser-inputstream-is-jse", true);
    }

    /** {@return true if a void operation returning 200 should be changed to return 204} */
    public boolean isFixupVoid200to204() {
        return or.bool("parser-fixup-void-200-to-204", false);
    }

    /** {@return true if null-type with format date/date-time should be fixed} */
    public boolean isFixupNullTypeDates() {
        return or.bool("parser-fixup-null-type-dates", false);
    }

    /** {@return true if resolver should be abort on unknown types} */
    public boolean isAbortOnResolverFailure() {
        return or.bool("parser-abort-on-resolver-failure", true);
    }
}
