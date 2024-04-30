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
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * ExampleSettings
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ExampleSettings {
  public static final String JSON_PROPERTY_BOOLEAN_VALUE = "booleanValue";
  @JsonbProperty(JSON_PROPERTY_BOOLEAN_VALUE)
  @Schema(example = "true")
  private Boolean booleanValue;

  public static final String JSON_PROPERTY_DOUBLE_VALUE = "doubleValue";
  @JsonbProperty(JSON_PROPERTY_DOUBLE_VALUE)
  @Schema(example = "1.1")
  private Double doubleValue;

  public static final String JSON_PROPERTY_INTEGER_VALUE = "integerValue";
  @JsonbProperty(JSON_PROPERTY_INTEGER_VALUE)
  @Schema(example = "1")
  private Integer integerValue;

  public static final String JSON_PROPERTY_LONG_VALUE = "longValue";
  @JsonbProperty(JSON_PROPERTY_LONG_VALUE)
  @Schema(example = "-2147483648")
  private Long longValue;

  public static final String JSON_PROPERTY_STRING_VALUE = "stringValue";
  @JsonbProperty(JSON_PROPERTY_STRING_VALUE)
  @Schema(example = "This is an arbitrary string")
  private String stringValue;

  public ExampleSettings booleanValue(Boolean booleanValue) {
    this.booleanValue = booleanValue;
    return this;
  }

  /**
   * Get booleanValue
   * @return booleanValue
   **/
  public Boolean isBooleanValue() {
    return booleanValue;
  }

  public void setBooleanValue(Boolean booleanValue) {
    this.booleanValue = booleanValue;
  }

  public ExampleSettings doubleValue(Double doubleValue) {
    this.doubleValue = doubleValue;
    return this;
  }

  /**
   * Get doubleValue
   * @return doubleValue
   **/
  public Double getDoubleValue() {
    return doubleValue;
  }

  public void setDoubleValue(Double doubleValue) {
    this.doubleValue = doubleValue;
  }

  public ExampleSettings integerValue(Integer integerValue) {
    this.integerValue = integerValue;
    return this;
  }

  /**
   * Get integerValue
   * @return integerValue
   **/
  public Integer getIntegerValue() {
    return integerValue;
  }

  public void setIntegerValue(Integer integerValue) {
    this.integerValue = integerValue;
  }

  public ExampleSettings longValue(Long longValue) {
    this.longValue = longValue;
    return this;
  }

  /**
   * Get longValue
   * @return longValue
   **/
  public Long getLongValue() {
    return longValue;
  }

  public void setLongValue(Long longValue) {
    this.longValue = longValue;
  }

  public ExampleSettings stringValue(String stringValue) {
    this.stringValue = stringValue;
    return this;
  }

  /**
   * Get stringValue
   * @return stringValue
   **/
  public String getStringValue() {
    return stringValue;
  }

  public void setStringValue(String stringValue) {
    this.stringValue = stringValue;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ExampleSettings)) {
      return false;
    }
    ExampleSettings other = (ExampleSettings) o;
    return Objects.equals(this.booleanValue, other.booleanValue) &&
        Objects.equals(this.doubleValue, other.doubleValue) &&
        Objects.equals(this.integerValue, other.integerValue) &&
        Objects.equals(this.longValue, other.longValue) &&
        Objects.equals(this.stringValue, other.stringValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(booleanValue, doubleValue, integerValue, longValue, stringValue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExampleSettings {");
    sb.append("\n    booleanValue: ").append(toIndentedString(booleanValue));
    sb.append("\n    doubleValue: ").append(toIndentedString(doubleValue));
    sb.append("\n    integerValue: ").append(toIndentedString(integerValue));
    sb.append("\n    longValue: ").append(toIndentedString(longValue));
    sb.append("\n    stringValue: ").append(toIndentedString(stringValue));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
