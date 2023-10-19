package dk.mada.jaxrs.model.api;

/**
 * HTTP methods.
 *
 * Ordered as in the RFC.
 *
 * @see <a href="https://datatracker.ietf.org/doc/html/rfc7231#section-4">HTTP RFC</a>
 * @see <a href="https://datatracker.ietf.org/doc/html/rfc5789#section-2">HTTP PATCH RFC</a>
 */
public enum HttpMethod {
    /** Transfer a current representation of the target resource. */
    GET,
    /** Same as GET, but only transfer the status line and header section. */
    HEAD,
    /** Perform resource-specific processing on the request payload. */
    POST,
    /** Replace all current representations of the target resource with the request payload. */
    PUT,
    /** Remove all current representations of the target resource. */
    DELETE,
    /** Establish a tunnel to the server identified by the target resource. */
    CONNECT,
    /** Describe the communication options for the target resource. */
    OPTIONS,
    /** Perform a message loop-back test along the path to the target resource. */
    TRACE,
    /** Apply partial modifications to a resource. */
    PATCH
}
