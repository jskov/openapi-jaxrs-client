package dk.mada.jaxrs.generator.mpclient;

/**
 * Console provides textual output to the user.
 */
public final class Console {
    private Console() {
        // empty
    }

    /**
     * Prints message to console, appending newline.
     *
     * @param msg the message to print
     */
    public static void println(String msg) {
        System.out.println(msg); // NOSONAR - yes, intentional
    }
}
