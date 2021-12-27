package dk.mada.logging;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

/**
 * Log formatter that translates the JUL level naming to
 * that used by SLF4J.
 * 
 * For the picky log reader who just cannot adopt...
 */
public class LoggerSlf4NamingFormatter extends SimpleFormatter {
	private static final Map<Level, Level> LEVEL_MAPPING = Map.of(
			Level.SEVERE,  new Slf4jLevel("ERROR", 1000),
			Level.WARNING, new Slf4jLevel("WARN", 900),
			Level.FINE,    new Slf4jLevel("DEBUG", 500),
			Level.FINEST,  new Slf4jLevel("TRACE", 300)
		);
	
	@Override
	public String format(LogRecord lr) {
		Level level = lr.getLevel();
		lr.setLevel(LEVEL_MAPPING.getOrDefault(level, level));
		return super.format(lr);
	}

	static class Slf4jLevel extends Level {
		private static final long serialVersionUID = 6453242617696798389L;

		private Slf4jLevel(String name, int value) {
			super(name, value);
		}
	}
}
