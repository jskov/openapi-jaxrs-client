package dk.mada.jaxrs.openapi;

import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.media.Schema;

/**
 * Methods lifted directly from OpenApi-generator.
 */
public final class OpenapiGeneratorUtils {
    private OpenapiGeneratorUtils() {
    }

    /**
     * Get schemas.
     *
     * From ModelUtils.getSchemas
     *
     * @param openAPI the OpenAPI document
     * @return the schemas mapped by name
     */
    @SuppressWarnings("rawtypes")
    public static Map<String, Schema> getSchemas(OpenAPI openAPI) {
        if (openAPI != null && openAPI.getComponents() != null && openAPI.getComponents().getSchemas() != null) {
            return openAPI.getComponents().getSchemas();
        }
        return Collections.emptyMap();
    }

    /**
     * Camelize name (parameter, property, method, etc) with upper case for first letter
     * copied from Twitter elephant bird.
     * https://github.com/twitter/elephant-bird/blob/master/core/src/main/java/com/twitter/elephantbird/util/Strings.java
     *
     * @param word string to be camelize
     * @return camelized string
     */
    // StringUtils.camelize
    public static String camelize(String word) {
        return camelize(word, false);
    }

    private static Pattern camelizeSlashPattern = Pattern.compile("\\/(.?)");
    private static Pattern camelizeUppercasePattern = Pattern.compile("(\\.?)(\\w)([^\\.]*)$");
    private static Pattern camelizeUnderscorePattern = Pattern.compile("(_)(.)");
    private static Pattern camelizeHyphenPattern = Pattern.compile("(-)(.)");
    private static Pattern camelizeDollarPattern = Pattern.compile("\\$");
    private static Pattern camelizeSimpleUnderscorePattern = Pattern.compile("_");

    /**
     * Camelize name (parameter, property, method, etc).
     *
     * @param word                 string to be camelize
     * @param lowercaseFirstLetter lower case for first letter if set to true
     * @return camelized string
     */
    public static String camelize(String word, boolean lowercaseFirstLetter) {
        // Replace all slashes with dots (package separator)
        Matcher m = camelizeSlashPattern.matcher(word);
        while (m.find()) {
            word = m.replaceFirst("." + m.group(1)/*.toUpperCase()*/);
            m = camelizeSlashPattern.matcher(word);
        }

        // case out dots
        String[] parts = word.split("\\.");
        StringBuilder f = new StringBuilder();
        for (String z : parts) {
            if (z.length() > 0) {
                f.append(Character.toUpperCase(z.charAt(0))).append(z.substring(1));
            }
        }
        word = f.toString();

        m = camelizeSlashPattern.matcher(word);
        while (m.find()) {
            word = m.replaceFirst("" + Character.toUpperCase(m.group(1).charAt(0)) + m.group(1).substring(1)/*.toUpperCase()*/);
            m = camelizeSlashPattern.matcher(word);
        }

        // Uppercase the class name.
        m = camelizeUppercasePattern.matcher(word);
        if (m.find()) {
            String rep = m.group(1) + m.group(2).toUpperCase(Locale.ROOT) + m.group(3);
            rep = camelizeDollarPattern.matcher(rep).replaceAll("\\\\\\$");
            word = m.replaceAll(rep);
        }

        // Remove all underscores (underscore_case to camelCase)
        m = camelizeUnderscorePattern.matcher(word);
        while (m.find()) {
            String original = m.group(2);
            String upperCase = original.toUpperCase(Locale.ROOT);
            if (original.equals(upperCase)) {
                word = camelizeSimpleUnderscorePattern.matcher(word).replaceFirst("");
            } else {
                word = m.replaceFirst(upperCase);
            }
            m = camelizeUnderscorePattern.matcher(word);
        }

        // Remove all hyphens (hyphen-case to camelCase)
        m = camelizeHyphenPattern.matcher(word);
        while (m.find()) {
            word = m.replaceFirst(m.group(2).toUpperCase(Locale.ROOT));
            m = camelizeHyphenPattern.matcher(word);
        }

        if (lowercaseFirstLetter && word.length() > 0) {
            int i = 0;
            char charAt = word.charAt(i);
            while (i + 1 < word.length() && !((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z'))) {
                i = i + 1;
                charAt = word.charAt(i);
            }
            i = i + 1;
            word = word.substring(0, i).toLowerCase(Locale.ROOT) + word.substring(i);
        }

        // remove all underscore
        word = camelizeSimpleUnderscorePattern.matcher(word).replaceAll("");
        return word;
    }

    private static Pattern capitalLetterPattern = Pattern.compile("([A-Z]+)([A-Z][a-z][a-z]+)");
    private static Pattern lowercasePattern = Pattern.compile("([a-z\\d])([A-Z])");
    private static Pattern pkgSeparatorPattern = Pattern.compile("\\.");
    private static Pattern dollarPattern = Pattern.compile("\\$");

    /**
     * Underscore the given word.
     * Copied from Twitter elephant bird
     * https://github.com/twitter/elephant-bird/blob/master/core/src/main/java/com/twitter/elephantbird/util/Strings.java
     *
     * @param word The word
     * @return The underscored version of the word
     */
    // StringUtils.underscore
    public static String underscore(final String word) {
        String result;
        String replacementPattern = "$1_$2";
        // Replace package separator with slash.
        result = pkgSeparatorPattern.matcher(word).replaceAll("/");
        // Replace $ with two underscores for inner classes.
        result = dollarPattern.matcher(result).replaceAll("__");
        // Replace capital letter with _ plus lowercase letter.
        result = capitalLetterPattern.matcher(result).replaceAll(replacementPattern);
        result = lowercasePattern.matcher(result).replaceAll(replacementPattern);
        result = result.replace('-', '_');
        // replace space with underscore
        result = result.replace(' ', '_');
        result = result.toLowerCase(Locale.ROOT);
        return result;
    }
}
