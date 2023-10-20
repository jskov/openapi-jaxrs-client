package mada.tests;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

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
        logger.setLevel(level); // NOSONAR - intentionally under user's control
    }
    
    /**
     * Log formatter that translates the JUL level naming to that used by SLF4J.
     *
     * For the picky log reader who just cannot adopt...
     */
    public static final class LoggerSlf4NamingFormatter extends SimpleFormatter {
        /** Log level bridging between JUL and slf4j. */
        private static final Map<Level, Level> LEVEL_MAPPING = Map.of(
                Level.SEVERE, new Slf4jLevel("ERROR", 1000),
                Level.WARNING, new Slf4jLevel("WARN", 900),
                Level.FINE, new Slf4jLevel("DEBUG", 500),
                Level.FINEST, new Slf4jLevel("TRACE", 300));

        @Override
        public String format(LogRecord lr) {
            Level level = lr.getLevel();
            lr.setLevel(LEVEL_MAPPING.getOrDefault(level, level));
            return super.format(lr);
        }

        static final class Slf4jLevel extends Level {
            private static final long serialVersionUID = 6453242617696798389L;

            private Slf4jLevel(String name, int value) {
                super(name, value);
            }
        }
    }
}
