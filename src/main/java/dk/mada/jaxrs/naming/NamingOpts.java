package dk.mada.jaxrs.naming;

import java.util.Properties;

public class NamingOpts {
	public static final String NAMING_RULES_TYPE = "naming-rules-type";
	private final Properties options;
	
	public NamingOpts(Properties options) {
		this.options = options;
	}
	
	public String getEnumNumberPrefix() {
		return getDefault("naming-enum-prefix-number", "NUMBER_");
	}

	public String getEnumNaming() {
		return getDefault("naming-rules-enum", "TYPENAME; UPCASE");
	}

	public String getPropertyNaming() {
		return getDefault("naming-rules-property", "PROPERTYNAME");
	}

	public String getTypeNaming() {
		return getDefault(NAMING_RULES_TYPE, "TYPENAME");
	}

	@SuppressWarnings("unused")
	private boolean bool(String name, String compatOptionName) {
		return Boolean.parseBoolean(get(name, compatOptionName));
	}

	@SuppressWarnings("unused")
	private boolean bool(String name) {
		return Boolean.parseBoolean(get(name));
	}

	private String get(String name, String compatibleOptionName) {
		String compat = options.getProperty(compatibleOptionName);
		String value = options.getProperty(name, compat);
		if (value == null) {
			return null;
		}
		return value.trim();
	}

	private String getDefault(String name, String defaultValue) {
		String value = options.getProperty(name);
		if (value == null) {
			return defaultValue;
		}
		return value.trim();
	}

	private String get(String name) {
		String value = options.getProperty(name);
		if (value == null) {
			return null;
		}
		return value.trim();
	}
}
