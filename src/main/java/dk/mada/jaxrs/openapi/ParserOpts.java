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
	
	private boolean bool(String name) {
		return Boolean.parseBoolean(options.getProperty(name));
	}
}
