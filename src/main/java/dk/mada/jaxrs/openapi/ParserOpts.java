package dk.mada.jaxrs.openapi;

import java.util.Properties;

/**
 * parser-* configuration options.
 */
public class ParserOpts {
	private final Properties options;
	
	public ParserOpts(Properties options) {
		this.options = options;
	}

	public boolean isUnwrapByteArrayList() {
		return bool("parser-unwrap-bytearray-list");
	}

	public boolean isJseLocalTime() {
		return bool("parser-localtime-is-jse", true);
	}

	public boolean isJseLocalDate() {
		return bool("parser-localdate-is-jse", true);
	}

	public boolean isJseLocalDateTime() {
		return bool("parser-localdatetime-is-jse", true);
	}

	public boolean isJseOffsetDateTime() {
		return bool("parser-offsetdatetime-is-jse", true);
	}

	public boolean isJseZonedDateTime() {
		return bool("parser-zoneddatetime-is-jse", true);
	}

	public boolean isJseBigDecimal() {
		return bool("parser-bigdecimal-is-jse", true);
	}

	private boolean bool(String name) {
		return bool(name, false);
	}
	
	private boolean bool(String name, boolean defaultValue) {
		return Boolean.parseBoolean(options.getProperty(name, Boolean.toString(defaultValue)));
	}
}
