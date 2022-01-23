package dk.mada.jaxrs;

/**
 * Wraps any exception throw while parsing or generating code.
 */
public class GeneratorException extends RuntimeException {
    private static final long serialVersionUID = 5823662362805123569L;

    /**
     * Creates a new wrapper exception.
     *
     * @param message
     * @param cause
     */
    public GeneratorException(String message, Throwable cause) {
        super(message, cause);
    }
}
