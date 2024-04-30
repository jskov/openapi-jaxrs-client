/*
 * Bitbucket Data Center
 * This is the reference document for the Atlassian Bitbucket REST API. The REST API is for developers who want to:

 - integrate Bitbucket with other applications;

 - create scripts that interact with Bitbucket; or

 - develop plugins that enhance the Bitbucket UI, using REST to interact with the backend.

 You can read more about developing Bitbucket plugins in the [Bitbucket Developer Documentation](https://developer.atlassian.com/bitbucket/server/docs/latest/).
 *
 * The version of the OpenAPI document: 8.19
 */

package mada.tests.e2e.examples.bitbucket.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import java.math.BigDecimal;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * ExampleSettingsMap
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ExampleSettingsMap {
  public static final String JSON_PROPERTY_BOOLEAN_KEY = "boolean key";
  @JsonbProperty(JSON_PROPERTY_BOOLEAN_KEY)
  @Schema(example = "true")
  private Boolean boolean_key;

  public static final String JSON_PROPERTY_LONG_KEY = "long key";
  @JsonbProperty(JSON_PROPERTY_LONG_KEY)
  @Schema(example = "10")
  private BigDecimal long_key;

  public static final String JSON_PROPERTY_STRING_KEY = "string key";
  @JsonbProperty(JSON_PROPERTY_STRING_KEY)
  @Schema(example = "string value")
  private String string_key;

  public ExampleSettingsMap boolean_key(Boolean boolean_key) {
    this.boolean_key = boolean_key;
    return this;
  }

  /**
   * Get boolean_key
   * @return boolean_key
   **/
  public Boolean isBooleanKey() {
    return boolean_key;
  }

  public void setBooleanKey(Boolean boolean_key) {
    this.boolean_key = boolean_key;
  }

  public ExampleSettingsMap long_key(BigDecimal long_key) {
    this.long_key = long_key;
    return this;
  }

  /**
   * Get long_key
   * @return long_key
   **/
  public BigDecimal getLongKey() {
    return long_key;
  }

  public void setLongKey(BigDecimal long_key) {
    this.long_key = long_key;
  }

  public ExampleSettingsMap string_key(String string_key) {
    this.string_key = string_key;
    return this;
  }

  /**
   * Get string_key
   * @return string_key
   **/
  public String getStringKey() {
    return string_key;
  }

  public void setStringKey(String string_key) {
    this.string_key = string_key;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ExampleSettingsMap)) {
      return false;
    }
    ExampleSettingsMap other = (ExampleSettingsMap) o;
    return Objects.equals(this.boolean_key, other.boolean_key) &&
        Objects.equals(this.long_key, other.long_key) &&
        Objects.equals(this.string_key, other.string_key);
  }

  @Override
  public int hashCode() {
    return Objects.hash(boolean_key, long_key, string_key);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExampleSettingsMap {");
    sb.append("\n    boolean_key: ").append(toIndentedString(boolean_key));
    sb.append("\n    long_key: ").append(toIndentedString(long_key));
    sb.append("\n    string_key: ").append(toIndentedString(string_key));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
