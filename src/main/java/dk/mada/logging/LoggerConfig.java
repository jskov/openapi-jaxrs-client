package dk.mada.logging;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.logging.LogManager;

/**
 * Loads JUL logging.properties.
 */
public final class LoggerConfig {
    private LoggerConfig() {
    }

    /** Loads default logger configuration. */
    public static void loadConfig() {
        loadConfig("/logging.properties");
    }

    /**
     * Loads specific logger configuration.
     *
     * @param path resource path of logger configuration
     */
    public static void loadConfig(String path) {
        try (InputStream configFile = LoggerConfig.class.getResourceAsStream(path)) {
            LogManager.getLogManager().updateConfiguration(configFile, null);
        } catch (IOException e) {
            throw new UncheckedIOException("Failed to load logging properties", e);
        }
    }
}
