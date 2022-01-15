package dk.mada.jaxrs.generator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class GeneratorOpts {
	private final String generatedAtTime = LocalDateTime.now().withNano(0).format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
	private final Properties options;
	
	private final boolean useJacksonCodehaus;
	private final boolean useJacksonFasterxml;
	private final boolean useJsonb;
	
	public GeneratorOpts(Properties options) {
		this.options = options;

		useJacksonCodehaus = bool("generator-jackson-codehaus");
		useJacksonFasterxml = bool("generator-jackson-fasterxml");
		boolean willUseJsonb = bool("generator-jsonb");
		
		int activatedSerializerApis = 0;
		if (useJacksonCodehaus) {
			activatedSerializerApis++;
		}
		if (useJacksonFasterxml) {
			activatedSerializerApis++;
		}
		if (willUseJsonb) {
			activatedSerializerApis++;
		}
		if (activatedSerializerApis > 1) {
			throw new IllegalStateException("Only one serializer API can be enabled!");
		}
		
		// jsonb is the default if nothing else specified
		if (activatedSerializerApis == 0) {
			willUseJsonb = true;
		}
		useJsonb = willUseJsonb;
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
		return useJacksonCodehaus;
	}

	public boolean isJacksonFasterxml() {
		return useJacksonFasterxml;
	}

	public boolean isJsonb() {
		return useJsonb;
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
