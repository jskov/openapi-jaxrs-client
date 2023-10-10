package dk.mada.jaxrs;

import org.jspecify.annotations.Nullable;

/**
 * Wraps any IllegalArgument exception throw while parsing or generating code.
 *
 * These are user-caused by bad input.
 */
public class GeneratorBadInputException extends RuntimeException {
    private static final long serialVersionUID = -6929398355306690724L;

    /**
     * Creates a new wrapper illegal argument exception.
     *
     * @param message the exception message
     * @param cause   the cause of the exception
     */
    public GeneratorBadInputException(@Nullable String message, Throwable cause) {
        super(message, cause);
    }
}
