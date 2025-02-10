package dk.mada.jaxrs.model.naming;

import javax.lang.model.SourceVersion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Make identifiers valid for java.
 *
 * https://docs.oracle.com/javase/specs/jls/se7/html/jls-3.html#jls-3.8
 *
 * A dash causes the following char to be upper-cased (foo-bar becomes fooBar). A group of upper-cased chars will be
 * lower cased (FOOBar becomes fooBar).
 */
public final class Identifiers {
    private static final Logger logger = LoggerFactory.getLogger(Identifiers.class);

    /** Creates new instance. */
    public Identifiers() {
        // empty
    }

    /**
     * Make a valid variable name for java.
     *
     * The initial character is lower-case.
     *
     * Example: FOOBar becomes fOOBar, fooBAR becomes fooBAR
     *
     * @param input the name
     * @return a valid variable name
     */
    public String makeValidVariableName(String input) {
        return makeValid(input, true, false);
    }

    /**
     * Make a valid variable name for java, down-casing on edges.
     *
     * The initial character is lower-case.
     *
     * Example: FOOBar becomes fooBar, fooBAR becomes fooBar
     *
     * @param input the name
     * @return a valid variable name
     */
    public String makeValidEdgeVariableName(String input) {
        return makeValid(input, true, true);
    }

    /**
     * Make a valid type name for java.
     *
     * The initial character is upper-case.
     *
     * Example: FOOBar becomes FOOBar, fooBAR becomes FooBAR
     *
     * @param input the name
     * @return a valid type name
     */
    public String makeValidTypeName(String input) {
        return makeValid(input, false, false);
    }

    /**
     * Make a valid type name for java, down-casing on edges.
     *
     * The initial character is upper-case.
     *
     * Example: FOOBar becomes FooBar, fooBAR becomes FooBar
     *
     * @param input the name
     * @return a valid type name
     */
    public String makeValidEdgeTypeName(String input) {
        return makeValid(input, false, true);
    }

    private String makeValid(String input, boolean initialLowerCase, boolean downcaseOnEdge) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Invalid blank identifier input");
        }

        logger.trace("==== {}", input);

        StringBuilder sb = new StringBuilder();

        // Fix case of first letter
        sb.append(firstLetterCase(input, initialLowerCase));

        boolean upperCaseNext = false;
        for (int i = 1; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '-') {
                upperCaseNext = true;
                continue;
            }

            // Use upper-case state of previous, this, and next to determine
            // edges (switching from upper- to lower-case or the reverse).
            // Keep the upper-case on the edge, but otherwise down-case.
            boolean isCaseEdge = isAtCaseEdge(input, i);
            boolean lowerCaseThis = downcaseOnEdge && !isCaseEdge;
            logger.trace(" {} - edge:{} > up:{} down:{}", c, isCaseEdge, upperCaseNext, lowerCaseThis);

            if (lowerCaseThis) {
                c = Character.toLowerCase(c);
            }
            if (upperCaseNext) {
                upperCaseNext = false;
                c = Character.toUpperCase(c);
            }

            if (Character.isJavaIdentifierPart(c)) {
                sb.append(c);
            } else {
                sb.append('_');
            }
        }

        if (SourceVersion.isKeyword(sb)) {
            sb.append("_");
        }

        String identifier = sb.toString();
        logger.trace(" >>>> {}", identifier);

        return identifier;
    }

    /**
     * Determines first character which is controlled primarily by the property/type flag.
     *
     * @param input            the input identifier
     * @param initialLowerCase true for properties, false for types
     * @return correctly cased first character, or _ if invalid
     */
    private char firstLetterCase(String input, boolean initialLowerCase) {
        char start = input.charAt(0);
        if (Character.isJavaIdentifierStart(start)) {
            if (initialLowerCase && Character.isUpperCase(start)) {
                return Character.toLowerCase(start);
            } else if (!initialLowerCase && Character.isLowerCase(start)) {
                return Character.toUpperCase(start);
            } else {
                return start;
            }
        }
        return '_';
    }

    /**
     * Determines if the index is at a case edge in the input string.
     *
     * Note that this function is only called at index > 1.
     *
     * @param input the input string
     * @param index the index into the input
     * @return true if case switches at the index location
     */
    private boolean isAtCaseEdge(String input, int index) {
        boolean prevWasUpperCase = Character.isUpperCase(input.charAt(index - 1));
        boolean isUpperCase = Character.isUpperCase(input.charAt(index));

        // Need to look forward to handle FOOBar -> fooBar
        boolean nextIsUpperCase = nextIsUpperCase(input, index);

        return (prevWasUpperCase && !isUpperCase)
                || (!prevWasUpperCase && isUpperCase)
                || (isUpperCase && !nextIsUpperCase)
                || (!isUpperCase && nextIsUpperCase);
    }

    private boolean nextIsUpperCase(String input, int index) {
        if (index + 1 >= input.length()) {
            return true;
        }
        return Character.isUpperCase(input.charAt(index + 1));
    }
}
