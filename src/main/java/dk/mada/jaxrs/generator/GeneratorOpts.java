package dk.mada.jaxrs.generator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class GeneratorOpts {
	private final String generatedAtTime = LocalDateTime.now().withNano(0).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	private final Properties options;
	private int activatedSerializerApis;
	
	public GeneratorOpts(Properties options) {
		this.options = options;

		activatedSerializerApis = 0;
		if (isJacksonCodehaus()) {
			activatedSerializerApis++;
		}
		if (isJacksonFasterxml()) {
			activatedSerializerApis++;
		}
		if (isJsonb()) {
			activatedSerializerApis++;
		}
		if (activatedSerializerApis > 1) {
			throw new IllegalStateException("Only one serializer API can be enabled!");
		}
	}
	
	public String apiPackage() {
		return get("generator-api-package", "apiPackage");
	}

	public String dtoPackage() {
		return get("generator-dto-package", "modelPackage");
	}

	public boolean isJackson() {
		return isJacksonCodehaus() || isJacksonFasterxml();
	}
	
	public boolean isJacksonCodehaus() {
		return bool("generator-jackson-codehaus");
	}

	public boolean isJacksonFasterxml() {
		return bool("generator-jackson-fasterxml");
	}

	public boolean isJsonb() {
		return activatedSerializerApis == 0 || bool("generator-jsonb");
	}

	public boolean isUseJsonSerializeOptions() {
		return getJsonSerializeOptions() != null;
	}
	
	public String getJsonSerializeOptions() {
		if (!isJackson()) {
			return null;
		}
		return get("generator-jackson-json-serialize-options");
	}

	public boolean isUseJacksonLocalDateSerializer() {
		return getJacksonLocalDateWireFormat() != null;
	}

	public String getJacksonLocalDateWireFormat() {
		if (!isJackson()) {
			return null;
		}
		return get("generator-jackson-localdate-wire-format");
	}

	public boolean isUseBigDecimalForDouble() {
		return bool("generator-use-bigdecimal-for-double");
	}
	
	public boolean isUseEmptyCollections() {
		return bool("generator-use-empty-collections");
	}

	public boolean isUseZonedDateTime() {
		return bool("generator-use-zoneddatetime");
	}

	public boolean isUseBooleanGetPrefix() {
		return bool("generator-use-boolean-get-prefix");
	}
	
	public String getGeneratedAtTime() {
		if (isShowGenerationTimestamp()) {
			return generatedAtTime;
		}
		return null;
	}
	
	private boolean isShowGenerationTimestamp() {
		return bool("generator-use-generated-timestamp");
	}

	public String getEnumNumberPrefix() {
		return getDefault("generator-enum-prefix-number", "NUMBER_");
	}

	@SuppressWarnings("unused")
	private boolean bool(String name, String compatOptionName) {
		return Boolean.parseBoolean(get(name, compatOptionName));
	}

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
