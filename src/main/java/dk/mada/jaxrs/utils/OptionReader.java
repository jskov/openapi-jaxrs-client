package dk.mada.jaxrs.utils;

import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Stream;

/**
 * Configuration manipulation helpers.
 */
public class OptionReader {
    /** User options. */
    private final Properties options;

    /**
     * Constructs a new instance.
     *
     * @param options user's options
     */
    public OptionReader(Properties options) {
        this.options = options;
    }

    /**
     * Splits and trims string by comma.
     *
     * @param input the input to split
     * @return the list of trimmed elements
     */
    private List<String> splitByComma(String input) {
        return Stream.of(input.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();
    }

    /**
     * Read boolean property, defaulting to false if missing.
     *
     * @param name the name of the option.
     * @return boolean-value of the option
     */
    public boolean bool(String name) {
        return get(name)
                .map(Boolean::parseBoolean)
                .orElse(false);
    }

    /**
     * Read boolean property, with default value if missing.
     *
     * @param name         the name of the option.
     * @param defaultValue the default value if the option is not specified
     * @return boolean-value of the option
     */
    public boolean bool(String name, boolean defaultValue) {
        return Boolean.parseBoolean(options.getProperty(name, Boolean.toString(defaultValue)));
    }

    /**
     * Read required option.
     *
     * @throws IllegalArgumentException if the property is missin
     *
     * @param name                 the name of the option.
     * @param compatibleOptionName fall-back name if primary name not found
     * @return the property value
     */
    public String getRequired(String name, String compatibleOptionName) {
        String compat = options.getProperty(compatibleOptionName);
        String value = options.getProperty(name, compat);
        if (value == null) {
            throw new IllegalArgumentException("The property " + name + " must be specified!");
        }
        return value.trim();
    }

    /**
     * Read optional option with default value.
     *
     * @param name         the option name
     * @param defaultValue the default value, if the option is not present
     * @return the property value
     */
    public Optional<String> getOptDefault(String name, String defaultValue) {
        return Optional.of(getDefault(name, defaultValue));
    }

    /**
     * Read comma-separated list option with default value.
     *
     * @param name         the option name
     * @param defaultValue the default value, if the option is not present
     * @return the property value
     */
    public List<String> getListDefault(String name, String defaultValue) {
        String value = options.getProperty(name, defaultValue);
        return splitByComma(value.trim());
    }

    /**
     * Read optional option with default value.
     *
     * @param name         the option name
     * @param defaultValue the default value, if the option is not present
     * @return the property value
     */
    public String getDefault(String name, String defaultValue) {
        String value = options.getProperty(name);
        if (value == null) {
            return defaultValue;
        }
        return value.trim();
    }

    /**
     * Read optional option value.
     *
     * @param name the option name
     * @return the trimmed property value if present
     */
    public Optional<String> get(String name) {
        return Optional.ofNullable(options.getProperty(name))
                .map(String::trim);
    }
}
