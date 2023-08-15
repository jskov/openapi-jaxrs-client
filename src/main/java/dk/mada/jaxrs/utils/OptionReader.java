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
     * @param options    user's options
     */
    public OptionReader(Properties options) {
        this.options = options;
    }

	public List<String> splitByComma(String input) {
        return Stream.of(input.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList();
    }

    public boolean bool(String name) {
        return get(name)
                .map(Boolean::parseBoolean)
                .orElse(false);
    }

    public boolean bool(String name, boolean defaultValue) {
        return Boolean.parseBoolean(options.getProperty(name, Boolean.toString(defaultValue)));
    }

    public String getRequired(String name, String compatibleOptionName) {
        String compat = options.getProperty(compatibleOptionName);
        String value = options.getProperty(name, compat);
        if (value == null) {
            throw new IllegalArgumentException("The property " + name + " must be specified!");
        }
        return value.trim();
    }

    public Optional<String> getOptDefault(String name, String defaultValue) {
        return Optional.of(getDefault(name, defaultValue));
    }

    public String getDefault(String name, String defaultValue) {
        String value = options.getProperty(name);
        if (value == null) {
            return defaultValue;
        }
        return value.trim();
    }

    public Optional<String> get(String name) {
        return Optional.ofNullable(options.getProperty(name))
                .map(String::trim);
    }

}
