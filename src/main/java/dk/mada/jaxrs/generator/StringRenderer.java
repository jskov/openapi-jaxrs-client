package dk.mada.jaxrs.generator;

/**
 * Renders text in various forms suitable for
 * use in the templates.
 *
 * Duplicates some of the logic in mustache rendering, but does so
 * to allow for use of simpler templates.
 */
public final class StringRenderer {
    /** System newline. */
    private static final String NL = System.lineSeparator();

    private StringRenderer() {
    }

    /**
     * Make a summary valid for use in the javadoc section.
     *
     * @param textIn the text summary
     * @return a valid summary to render as javadoc, or null
     */
    public static String makeValidJavadocSummary(String textIn) {
        if (textIn == null) {
            return null;
        }

        String text = textIn;

        // Make sure there is sentence
        if (!(text.contains(".")
                || text.contains("!")
                || text.contains("?"))) {
            text = text + ".";
        }

        // Crude - handle carriage return (on Unix, turns to \n, on Windows stays \r\n)
        text = text.replace("\r\n", NL);

        // Crude - but simple - newline handling
        text = text.replace(NL, NL + "   * ");
        text = text.replace(NL + "   * " + NL, NL + "   *" + NL);

        return text;
    }

    /**
     * Encodes text for use in string-input.
     *
     * The text may contain multiple lines, but needs to be represented
     * in the source code as a single string input.
     *
     * Used for descriptions and examples that need to be specified
     * as @Schema inputs.
     *
     * @param text the text to be protected
     * @return a single-line string
     */
    public static String encodeForString(String text) {
        if (text == null) {
            return null;
        }

        return text.replace("\r", "\\r").replace("\n", "\\n");
    }
}
