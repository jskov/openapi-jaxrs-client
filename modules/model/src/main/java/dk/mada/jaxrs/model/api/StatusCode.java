package dk.mada.jaxrs.model.api;

/**
 * HTTP status codes.
 *
 * The HttpURLConnection constants in enumeration-form. And then some from
 * https://developer.mozilla.org/en-US/docs/Web/HTTP/Status and
 * https://www.iana.org/assignments/http-status-codes/http-status-codes.xhtml
 */
public enum StatusCode {
    /**
     * Special code to hold the state for the OpenApi default entry.
     *
     * @see <a href="https://swagger.io/specification/#responsesObject">OpenApi response definition</a>
     */
    HTTP_DEFAULT(0),

    /** Continue. */
    HTTP_CONTINUE(100),
    /** Switching Protocols. */
    HTTP_SWITCHING_PROTOCOLS(101),
    /** Processing. */
    HTTP_PROCESSING(102),
    /** Early hints. */
    HTTP_EARLY_HINTS(103),

    /** OK. */
    HTTP_OK(200),
    /** Created. */
    HTTP_CREATED(201),
    /** Accepted. */
    HTTP_ACCEPTED(202),
    /** Non-Authoritative Information. */
    HTTP_NOT_AUTHORITATIVE(203),
    /** No Content. */
    HTTP_NO_CONTENT(204),
    /** Reset Content. */
    HTTP_RESET(205),
    /** Partial Content. */
    HTTP_PARTIAL(206),
    /** Multi-Status. */
    HTTP_MULTI_STATUS(207),
    /** Already Reported. */
    HTTP_ALREADY_REPORTED(208),
    /** IM Used. */
    HTTP_IM_USED(226),

    /** Multiple Choices. */
    HTTP_MULT_CHOICE(300),
    /** Moved Permanently. */
    HTTP_MOVED_PERM(301),
    /** Temporary Redirect. */
    HTTP_MOVED_TEMP(302),
    /** See Other. */
    HTTP_SEE_OTHER(303),
    /** Not Modified. */
    HTTP_NOT_MODIFIED(304),
    /** Use Proxy. */
    HTTP_USE_PROXY(305),
    /** Unused, reserved. */
    HTTP_UNUSED(306),
    /** Temporary Redirect. */
    HTTP_TEMPORARY_REDIRECT(307),
    /** Permanent Redirect. */
    HTTP_PERMANENT_REDIRECT(308),

    /** Bad Request. */
    HTTP_BAD_REQUEST(400),
    /** Unauthorized. */
    HTTP_UNAUTHORIZED(401),
    /** Payment Required. */
    HTTP_PAYMENT_REQUIRED(402),
    /** Forbidden. */
    HTTP_FORBIDDEN(403),
    /** Not Found. */
    HTTP_NOT_FOUND(404),
    /** Method Not Allowed. */
    HTTP_BAD_METHOD(405),
    /** Not Acceptable. */
    HTTP_NOT_ACCEPTABLE(406),
    /** Proxy Authentication Required. */
    HTTP_PROXY_AUTH(407),
    /** Request Time-Out. */
    HTTP_CLIENT_TIMEOUT(408),
    /** Conflict. */
    HTTP_CONFLICT(409),
    /** Gone. */
    HTTP_GONE(410),
    /** Length Required. */
    HTTP_LENGTH_REQUIRED(411),
    /** Precondition Failed. */
    HTTP_PRECON_FAILED(412),
    /** Request Entity Too Large. */
    HTTP_ENTITY_TOO_LARGE(413),
    /** Request-URI Too Large. */
    HTTP_REQ_TOO_LONG(414),
    /** Unsupported Media Type. */
    HTTP_UNSUPPORTED_TYPE(415),
    /** Range Not Satisfiable. */
    HTTP_RANGE_NOT_SATISFIABLE(416),
    /** Expectation Failed. */
    HTTP_EXPECTATION_FAILED(417),
    /** I'm a teapot. */
    HTTP_IM_A_TEAPOT(418),
    /** Misdirected Request. */
    HTTP_MISDIRECTED_REQUEST(421),
    /** Unprocessable Entity. */
    HTTP_UNPROCESSABLE_ENTITY(422),
    /** Locked. */
    HTTP_LOCKED(423),
    /** Failed dependency. */
    HTTP_FAILED_DEPENDENCY(424),
    /** Too early. */
    HTTP_TOO_EARLY(425),
    /** Upgrade Required. */
    HTTP_UPGRADE_REQUIRED(426),
    /** Precondition Required. */
    HTTP_PRECONDITION_REQUIRED(428),
    /** Too Many Requests. */
    HTTP_TOO_MANY_REQUESTS(429),
    /** Request Header Fields Too Large. */
    HTTP_REQUEST_HEADER_FIELDS_TOO_LARGE(431),
    /** Unavailable For Legal Reasons. */
    HTTP_UNAVAILABLE_FOR_LEGAL_REASONS(451),

    /** Internal Server Error. */
    HTTP_INTERNAL_ERROR(500),
    /** Not Implemented. */
    HTTP_NOT_IMPLEMENTED(501),
    /** Bad Gateway. */
    HTTP_BAD_GATEWAY(502),
    /** Service Unavailable. */
    HTTP_UNAVAILABLE(503),
    /** Gateway Timeout. */
    HTTP_GATEWAY_TIMEOUT(504),
    /** HTTP Version Not Supported. */
    HTTP_VERSION(505),
    /** Variant Also Negotiates. */
    HTTP_VARIANT_ALSO_NEGOTIATES(506),
    /** Insufficient Storage. */
    HTTP_INSUFFICIENT_STORAGE(507),
    /** Loop Detected. */
    HTTP_LOOP_DETECTED(508),
    /** Not Extended. */
    HTTP_NOT_EXTENDED(510),
    /** Network Authentication Required. */
    HTTP_NETWORK_AUTHENTICATION_REQUIRED(511);

    /** Status code. */
    private final int code;

    StatusCode(int code) {
        this.code = code;
    }

    /** {@return the status code value} */
    public int code() {
        return code;
    }

    /**
     * Returns the code in the same form as expected by OpenApi.
     *
     * This means that HTTP_DEFAULT is returned as "default", others as their status code in string form.
     *
     * @return the OpenApi status code
     */
    public String asOpenApiStatus() {
        return this == HTTP_DEFAULT ? "default" : Integer.toString(code);
    }

    /**
     * Convert OpenApi wire status code a model StatusCode.
     *
     * Note the special handling of "default".
     *
     * @param code the OpenApi wire-form of a status code
     * @return the matching status code
     */
    public static StatusCode of(String code) {
        if ("default".equalsIgnoreCase(code)) {
            return HTTP_DEFAULT;
        }
        int intValue = Integer.parseInt(code);
        for (StatusCode sc : values()) {
            if (sc.code == intValue) {
                return sc;
            }
        }
        throw new IllegalArgumentException("Unknown HTTP status code: '" + code + "'");
    }
}
