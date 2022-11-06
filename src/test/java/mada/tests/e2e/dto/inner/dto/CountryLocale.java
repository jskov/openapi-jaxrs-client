/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.dto.inner.dto;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;

/**
 * CountryLocale
 */
@JsonbPropertyOrder({
  CountryLocale.JSON_PROPERTY_LANGUAGE,
  CountryLocale.JSON_PROPERTY_SCRIPT,
  CountryLocale.JSON_PROPERTY_COUNTRY,
  CountryLocale.JSON_PROPERTY_VARIANT,
  CountryLocale.JSON_PROPERTY_EXTENSION_KEYS,
  CountryLocale.JSON_PROPERTY_UNICODE_LOCALE_ATTRIBUTES,
  CountryLocale.JSON_PROPERTY_UNICODE_LOCALE_KEYS,
  CountryLocale.JSON_PROPERTY_ISO3_LANGUAGE,
  CountryLocale.JSON_PROPERTY_ISO3_COUNTRY,
  CountryLocale.JSON_PROPERTY_DISPLAY_LANGUAGE,
  CountryLocale.JSON_PROPERTY_DISPLAY_SCRIPT,
  CountryLocale.JSON_PROPERTY_DISPLAY_COUNTRY,
  CountryLocale.JSON_PROPERTY_DISPLAY_VARIANT,
  CountryLocale.JSON_PROPERTY_DISPLAY_NAME
})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class CountryLocale {
  public static final String JSON_PROPERTY_LANGUAGE = "language";
  @JsonbProperty(JSON_PROPERTY_LANGUAGE)
  private String language;

  public static final String JSON_PROPERTY_SCRIPT = "script";
  @JsonbProperty(JSON_PROPERTY_SCRIPT)
  private String script;

  public static final String JSON_PROPERTY_COUNTRY = "country";
  @JsonbProperty(JSON_PROPERTY_COUNTRY)
  private String country;

  public static final String JSON_PROPERTY_VARIANT = "variant";
  @JsonbProperty(JSON_PROPERTY_VARIANT)
  private String variant;

  public static final String JSON_PROPERTY_EXTENSION_KEYS = "extensionKeys";
  @JsonbProperty(JSON_PROPERTY_EXTENSION_KEYS)
  private Set<String> extensionKeys;

  public static final String JSON_PROPERTY_UNICODE_LOCALE_ATTRIBUTES = "unicodeLocaleAttributes";
  @JsonbProperty(JSON_PROPERTY_UNICODE_LOCALE_ATTRIBUTES)
  private Set<String> unicodeLocaleAttributes;

  public static final String JSON_PROPERTY_UNICODE_LOCALE_KEYS = "unicodeLocaleKeys";
  @JsonbProperty(JSON_PROPERTY_UNICODE_LOCALE_KEYS)
  private Set<String> unicodeLocaleKeys;

  public static final String JSON_PROPERTY_ISO3_LANGUAGE = "iso3Language";
  @JsonbProperty(JSON_PROPERTY_ISO3_LANGUAGE)
  private String iso3Language;

  public static final String JSON_PROPERTY_ISO3_COUNTRY = "iso3Country";
  @JsonbProperty(JSON_PROPERTY_ISO3_COUNTRY)
  private String iso3Country;

  public static final String JSON_PROPERTY_DISPLAY_LANGUAGE = "displayLanguage";
  @JsonbProperty(JSON_PROPERTY_DISPLAY_LANGUAGE)
  private String displayLanguage;

  public static final String JSON_PROPERTY_DISPLAY_SCRIPT = "displayScript";
  @JsonbProperty(JSON_PROPERTY_DISPLAY_SCRIPT)
  private String displayScript;

  public static final String JSON_PROPERTY_DISPLAY_COUNTRY = "displayCountry";
  @JsonbProperty(JSON_PROPERTY_DISPLAY_COUNTRY)
  private String displayCountry;

  public static final String JSON_PROPERTY_DISPLAY_VARIANT = "displayVariant";
  @JsonbProperty(JSON_PROPERTY_DISPLAY_VARIANT)
  private String displayVariant;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
  @JsonbProperty(JSON_PROPERTY_DISPLAY_NAME)
  private String displayName;

  public CountryLocale language(String language) {
    this.language = language;
    return this;
  }

  /**
   * Get language
   * @return language
   **/
  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  public CountryLocale script(String script) {
    this.script = script;
    return this;
  }

  /**
   * Get script
   * @return script
   **/
  public String getScript() {
    return script;
  }

  public void setScript(String script) {
    this.script = script;
  }

  public CountryLocale country(String country) {
    this.country = country;
    return this;
  }

  /**
   * Get country
   * @return country
   **/
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public CountryLocale variant(String variant) {
    this.variant = variant;
    return this;
  }

  /**
   * Get variant
   * @return variant
   **/
  public String getVariant() {
    return variant;
  }

  public void setVariant(String variant) {
    this.variant = variant;
  }

  public CountryLocale extensionKeys(Set<String> extensionKeys) {
    this.extensionKeys = extensionKeys;
    return this;
  }

  public CountryLocale addExtensionKeysItem(String extensionKeysItem) {
    if (this.extensionKeys == null) {
      this.extensionKeys = new LinkedHashSet<>();
    }
    this.extensionKeys.add(extensionKeysItem);
    return this;
  }

  /**
   * Get extensionKeys
   * @return extensionKeys
   **/
  public Set<String> getExtensionKeys() {
    return extensionKeys;
  }

  public void setExtensionKeys(Set<String> extensionKeys) {
    this.extensionKeys = extensionKeys;
  }

  public CountryLocale unicodeLocaleAttributes(Set<String> unicodeLocaleAttributes) {
    this.unicodeLocaleAttributes = unicodeLocaleAttributes;
    return this;
  }

  public CountryLocale addUnicodeLocaleAttributesItem(String unicodeLocaleAttributesItem) {
    if (this.unicodeLocaleAttributes == null) {
      this.unicodeLocaleAttributes = new LinkedHashSet<>();
    }
    this.unicodeLocaleAttributes.add(unicodeLocaleAttributesItem);
    return this;
  }

  /**
   * Get unicodeLocaleAttributes
   * @return unicodeLocaleAttributes
   **/
  public Set<String> getUnicodeLocaleAttributes() {
    return unicodeLocaleAttributes;
  }

  public void setUnicodeLocaleAttributes(Set<String> unicodeLocaleAttributes) {
    this.unicodeLocaleAttributes = unicodeLocaleAttributes;
  }

  public CountryLocale unicodeLocaleKeys(Set<String> unicodeLocaleKeys) {
    this.unicodeLocaleKeys = unicodeLocaleKeys;
    return this;
  }

  public CountryLocale addUnicodeLocaleKeysItem(String unicodeLocaleKeysItem) {
    if (this.unicodeLocaleKeys == null) {
      this.unicodeLocaleKeys = new LinkedHashSet<>();
    }
    this.unicodeLocaleKeys.add(unicodeLocaleKeysItem);
    return this;
  }

  /**
   * Get unicodeLocaleKeys
   * @return unicodeLocaleKeys
   **/
  public Set<String> getUnicodeLocaleKeys() {
    return unicodeLocaleKeys;
  }

  public void setUnicodeLocaleKeys(Set<String> unicodeLocaleKeys) {
    this.unicodeLocaleKeys = unicodeLocaleKeys;
  }

  public CountryLocale iso3Language(String iso3Language) {
    this.iso3Language = iso3Language;
    return this;
  }

  /**
   * Get iso3Language
   * @return iso3Language
   **/
  public String getIso3Language() {
    return iso3Language;
  }

  public void setIso3Language(String iso3Language) {
    this.iso3Language = iso3Language;
  }

  public CountryLocale iso3Country(String iso3Country) {
    this.iso3Country = iso3Country;
    return this;
  }

  /**
   * Get iso3Country
   * @return iso3Country
   **/
  public String getIso3Country() {
    return iso3Country;
  }

  public void setIso3Country(String iso3Country) {
    this.iso3Country = iso3Country;
  }

  public CountryLocale displayLanguage(String displayLanguage) {
    this.displayLanguage = displayLanguage;
    return this;
  }

  /**
   * Get displayLanguage
   * @return displayLanguage
   **/
  public String getDisplayLanguage() {
    return displayLanguage;
  }

  public void setDisplayLanguage(String displayLanguage) {
    this.displayLanguage = displayLanguage;
  }

  public CountryLocale displayScript(String displayScript) {
    this.displayScript = displayScript;
    return this;
  }

  /**
   * Get displayScript
   * @return displayScript
   **/
  public String getDisplayScript() {
    return displayScript;
  }

  public void setDisplayScript(String displayScript) {
    this.displayScript = displayScript;
  }

  public CountryLocale displayCountry(String displayCountry) {
    this.displayCountry = displayCountry;
    return this;
  }

  /**
   * Get displayCountry
   * @return displayCountry
   **/
  public String getDisplayCountry() {
    return displayCountry;
  }

  public void setDisplayCountry(String displayCountry) {
    this.displayCountry = displayCountry;
  }

  public CountryLocale displayVariant(String displayVariant) {
    this.displayVariant = displayVariant;
    return this;
  }

  /**
   * Get displayVariant
   * @return displayVariant
   **/
  public String getDisplayVariant() {
    return displayVariant;
  }

  public void setDisplayVariant(String displayVariant) {
    this.displayVariant = displayVariant;
  }

  public CountryLocale displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

  /**
   * Get displayName
   * @return displayName
   **/
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CountryLocale)) {
      return false;
    }
    CountryLocale other = (CountryLocale) o;
    return Objects.equals(this.language, other.language) &&
        Objects.equals(this.script, other.script) &&
        Objects.equals(this.country, other.country) &&
        Objects.equals(this.variant, other.variant) &&
        Objects.equals(this.extensionKeys, other.extensionKeys) &&
        Objects.equals(this.unicodeLocaleAttributes, other.unicodeLocaleAttributes) &&
        Objects.equals(this.unicodeLocaleKeys, other.unicodeLocaleKeys) &&
        Objects.equals(this.iso3Language, other.iso3Language) &&
        Objects.equals(this.iso3Country, other.iso3Country) &&
        Objects.equals(this.displayLanguage, other.displayLanguage) &&
        Objects.equals(this.displayScript, other.displayScript) &&
        Objects.equals(this.displayCountry, other.displayCountry) &&
        Objects.equals(this.displayVariant, other.displayVariant) &&
        Objects.equals(this.displayName, other.displayName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(language, script, country, variant, extensionKeys, unicodeLocaleAttributes, unicodeLocaleKeys, iso3Language, iso3Country, displayLanguage, displayScript, displayCountry, displayVariant, displayName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CountryLocale {");
    sb.append("\n    language: ").append(toIndentedString(language));
    sb.append("\n    script: ").append(toIndentedString(script));
    sb.append("\n    country: ").append(toIndentedString(country));
    sb.append("\n    variant: ").append(toIndentedString(variant));
    sb.append("\n    extensionKeys: ").append(toIndentedString(extensionKeys));
    sb.append("\n    unicodeLocaleAttributes: ").append(toIndentedString(unicodeLocaleAttributes));
    sb.append("\n    unicodeLocaleKeys: ").append(toIndentedString(unicodeLocaleKeys));
    sb.append("\n    iso3Language: ").append(toIndentedString(iso3Language));
    sb.append("\n    iso3Country: ").append(toIndentedString(iso3Country));
    sb.append("\n    displayLanguage: ").append(toIndentedString(displayLanguage));
    sb.append("\n    displayScript: ").append(toIndentedString(displayScript));
    sb.append("\n    displayCountry: ").append(toIndentedString(displayCountry));
    sb.append("\n    displayVariant: ").append(toIndentedString(displayVariant));
    sb.append("\n    displayName: ").append(toIndentedString(displayName));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
