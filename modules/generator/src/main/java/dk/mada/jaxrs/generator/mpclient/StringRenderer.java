package dk.mada.jaxrs.generator.mpclient;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Renders text in various forms suitable for use in the templates.
 *
 * Duplicates some of the logic in mustache rendering, but does so to allow for use of simpler templates.
 */
public final class StringRenderer {
    private static final String JAVADOC_PREFIX = " * ";
    /** Max line length. */
    public static final int MAX_LINE_WIDTH = 120;
    /** Javadoc line break length. */
    private static final int LINE_BREAK_LENGTH = MAX_LINE_WIDTH - JAVADOC_PREFIX.length() - 1;
    /** System newline. */
    private static final String NL = System.lineSeparator();

    private StringRenderer() {
    }

    /**
     * Make a summary valid for use in the API summary javadoc section.
     *
     * @param textIn the text summary
     * @return a valid summary to render as javadoc, or null
     */
    public static Optional<String> makeValidOperationJavadocSummary(String textIn) {
        return makeValidJavadocSummary(textIn, "    ");
    }

    /**
     * Make a summary valid for use in the DTO summary javadoc section.
     *
     * @param textIn the text summary
     * @return a valid summary to render as javadoc, or null
     */
    public static Optional<String> makeValidDtoJavadocSummary(String textIn) {
        return makeValidJavadocSummary(textIn, "");
    }

    /**
     * Make a summary valid for use in the property javadoc section.
     *
     * @param textIn the text summary
     * @return a valid summary to render as javadoc, or null
     */
    public static Optional<String> makeValidPropertyJavadocSummary(String textIn) {
        return makeValidJavadocSummary(textIn, "    ");
    }

    /**
     * Make a summary valid for use in the javadoc section.
     *
     * Make a summary valid for use in the javadoc section. Make a summary valid for use in the javadoc section. Make a
     * summary valid for use in the javadoc section. Make a summary valid for use in the javadoc section.
     *
     * @param textIn        the text summary
     * @param commentIndent the comment indentation
     * @return a valid summary to render as javadoc, or null
     */
    private static Optional<String> makeValidJavadocSummary(String textIn, String commentIndent) {
        if (textIn == null) {
            return Optional.empty();
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

        text = text.lines()
                .map(String::stripTrailing)
                .collect(Collectors.joining(NL));

        text = text
                .replace("<br>", "<br>" + NL + NL)
                .replace("<br/>", "<br/>" + NL + NL);

        // Replaces 2+ newlines with a single space.
        text = text.replaceAll("\n{2,}", "@@NL@@")
                .replace(NL, " ")
                .replace("@@NL@@", NL);

        // Breaks long lines
        int indent = commentIndent.length();
        text = text.lines()
                .map(l -> shorten(l, indent))
                .collect(Collectors.joining(NL));

        // Crude - but simple - newline handling
        text = text.replace(NL, NL + commentIndent + JAVADOC_PREFIX);
//        text = text.replace(NL + commentIndent + " * " + NL, NL + commentIndent + " *" + NL);

        return Optional.of(text);
    }

    private static String shorten(String s, int indent) {
        int currentLineLength = indent;
        StringBuilder sb = new StringBuilder();
        for (String w : s.split(" ", -1)) {
            int length = w.length();
            if (currentLineLength + length > LINE_BREAK_LENGTH) {
                sb.append(NL);
                currentLineLength = indent;
            }
            if (currentLineLength != indent) {
                sb.append(" ");
                currentLineLength += 1;
            }
            currentLineLength += length;
            sb.append(w);
        }
        return sb.toString();
    }

    /**
     * Encodes text for use in string-input.
     *
     * The text may contain multiple lines, but needs to be represented in the source code as a single string input.
     *
     * Used for descriptions and examples that need to be specified as @Schema inputs.
     *
     * @param text the text to be protected
     * @return a single-line string
     */
    public static Optional<String> encodeForString(Optional<String> text) {
        return text.map(StringRenderer::encodeForString);
    }

    /**
     * Encodes text for use in string-input.
     *
     * The text may contain multiple lines, but needs to be represented in the source code as a single string input.
     *
     * Used for descriptions and examples that need to be specified as @Schema inputs.
     *
     * @param text the text to be protected
     * @return a single-line string
     */
    public static String encodeForString(String text) {
        return text.replace("\\", "\\\\").replace("\r", "\\r").replace("\n", "\\n").replace("\"", "\\\"");
    }

    /**
     * Quote text.
     *
     * Wraps a string in quotes. If it contains quotes, escape them.
     *
     * @param text the text to quote
     * @return the quoted text
     */
    public static String quote(String text) {
        String body = text.replace("\"", "\\\"");
        return '"' + body + '"';
    }

    /**
     * Encode regular expression to be used in an annotation argument.
     *
     * Backslashes need to be doubled.
     *
     * @param regexp the regular expression to encode
     * @return the encoded regular expression
     */
    public static String encodeRegexp(String regexp) {
        String doubleHack = "@BACK_SLASHES@";
        return regexp
                .replace("\\\\", doubleHack)
                .replace("\\", "\\\\")
                .replace(doubleHack, "\\\\");
    }

    /**
     * Encodes input text if it is non-blank for consumer.
     *
     * @param txt      the text to be encoded
     * @param consumer the consumer of the text
     */
    public static void consumeNonBlankEncoded(Optional<String> txt, Consumer<String> consumer) {
        txt
                .filter(s -> !s.isBlank())
                .map(StringRenderer::encodeForString)
                .ifPresent(consumer);
    }
}
