package dk.mada.logging;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * Controls (JUL) logging backend.
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

    /**
     * Configures logger to show debug level output.
     */
    public static void enableDebugLogOutput() {
        setLogLevel(Level.FINE);
    }

    /**
     * Configures logger to show trace level output.
     */
    public static void enableTraceLogOutput() {
        setLogLevel(Level.ALL);
    }

    private static void setLogLevel(Level level) {
        Logger logger = LogManager.getLogManager().getLogger("dk.mada");
        logger.setLevel(level);
    }
}
