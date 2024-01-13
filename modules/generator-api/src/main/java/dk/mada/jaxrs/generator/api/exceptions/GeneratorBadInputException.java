package dk.mada.jaxrs.generator.api.exceptions;

import org.jspecify.annotations.Nullable;

/**
 * Wraps any IllegalArgument exception throw while parsing or generating code.
 *
 * These are user-caused by bad input.
 */
public class GeneratorBadInputException extends GeneratorException {
    private static final long serialVersionUID = -6929398355306690724L;

    /**
     * Creates a new wrapper illegal argument exception.
     *
     * @param message      the exception message
     * @param seeConfigOpt an optional option name that may help fix the problem
     * @param cause        the cause of the exception
     */
    public GeneratorBadInputException(@Nullable String message, @Nullable String seeConfigOpt, @Nullable Throwable cause) {
        super(combinedMessage(message, seeConfigOpt), cause);
    }

    private static @Nullable String combinedMessage(@Nullable String message, @Nullable String seeConfigOpt) {
        if (seeConfigOpt == null) {
            return message;
        }

        String extra = "See option " + seeConfigOpt;
        if (message == null || message.isBlank()) {
            return extra;
        } else if (message.endsWith(".")) {
            return message + " " + extra;
        } else {
            return message + ". " + extra;
        }
    }

    /**
     * Creates a new wrapper illegal argument exception.
     *
     * @param message the exception message
     * @param cause   the cause of the exception
     */
    public GeneratorBadInputException(@Nullable String message, Throwable cause) {
        this(message, null, cause);
    }

    /**
     * Creates a new wrapper illegal argument exception.
     *
     * @param message      the exception message
     * @param seeConfigOpt an optional option name that may help fix the problem
     */
    public static void failBadInput(String message, String seeConfigOpt) {
        throw new GeneratorBadInputException(message, seeConfigOpt, null);
    }
}
