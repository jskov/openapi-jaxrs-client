package dk.mada.jaxrs.naming;

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
        char start = input.charAt(0);
        sb.append(firstLetterCase(start, initialLowerCase));

        // Use upper-case state of previous, this, and next to determine
        // edges (switching from upper- to lower-case or the reverse).
        // Keep the upper-case on the edge, but otherwise down-case.
        boolean prevWasUpperCase = Character.isUpperCase(start);
        boolean upperCaseNext = false;
        for (int i = 1; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '-') {
                upperCaseNext = true;
                continue;
            }

            boolean isUpperCase = Character.isUpperCase(c);
            // Need to look forward to handle FOOBar -> fooBar
            boolean nextIsUpperCase = nextIsUpperCase(input, i);
            boolean caseEdge = (prevWasUpperCase && !isUpperCase)
                    || (!prevWasUpperCase && isUpperCase)
                    || (isUpperCase && !nextIsUpperCase)
                    || (!isUpperCase && nextIsUpperCase);

            boolean lowerCaseThis = downcaseOnEdge && !caseEdge;
            logger.trace(" {} - prev:{} this:{} next:{} | edge:{} > up:{} down:{}",
                    c, prevWasUpperCase, isUpperCase, nextIsUpperCase, caseEdge, upperCaseNext, lowerCaseThis);

            prevWasUpperCase = isUpperCase;

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
    
    private char firstLetterCase(char start, boolean initialLowerCase) {
        if (Character.isJavaIdentifierStart(start)) {
            if (initialLowerCase && Character.isUpperCase(start)) {
                return Character.toLowerCase(start);
            } else if (!initialLowerCase && Character.isLowerCase(start)) {
                return Character.toUpperCase(start);
            } else {
                return start;
            }
        } else {
            return '_';
        }
    }
    
    private boolean nextIsUpperCase(String input, int index) {
        if (index + 1 >= input.length()) {
            return true;
        }
        return Character.isUpperCase(input.charAt(index + 1));
    }
}
