/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.specs.v3_0.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * AbstractType
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public abstract class AbstractType {
  public static final String JSON_PROPERTY_VALUE_ENUM = "valueEnum";
  @JsonbProperty(JSON_PROPERTY_VALUE_ENUM)
  private OtherEnum valueEnum;

  public static final String JSON_PROPERTY_VALUE_INTEGER = "valueInteger";
  @JsonbProperty(JSON_PROPERTY_VALUE_INTEGER)
  @Schema(required = true)
  private Integer valueInteger;

  public static final String JSON_PROPERTY_VALUE_STRING = "valueString";
  @JsonbProperty(JSON_PROPERTY_VALUE_STRING)
  private String valueString;

  public AbstractType valueEnum(OtherEnum valueEnum) {
    this.valueEnum = valueEnum;
    return this;
  }

  /**
   * Get valueEnum
   * @return valueEnum
   **/
  @Valid
  public OtherEnum getValueEnum() {
    return valueEnum;
  }

  public void setValueEnum(OtherEnum valueEnum) {
    this.valueEnum = valueEnum;
  }

  public AbstractType valueInteger(Integer valueInteger) {
    this.valueInteger = Objects.requireNonNull(valueInteger, "Property valueInteger is required, cannot be null");
    return this;
  }

  /**
   * Get valueInteger
   * @return valueInteger
   **/
  @NotNull
  public Integer getValueInteger() {
    return valueInteger;
  }

  public void setValueInteger(Integer valueInteger) {
    this.valueInteger = Objects.requireNonNull(valueInteger, "Property valueInteger is required, cannot be null");
  }

  public AbstractType valueString(String valueString) {
    this.valueString = valueString;
    return this;
  }

  /**
   * Get valueString
   * @return valueString
   **/
  public String getValueString() {
    return valueString;
  }

  public void setValueString(String valueString) {
    this.valueString = valueString;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractType)) {
      return false;
    }
    AbstractType other = (AbstractType) o;
    return Objects.equals(this.valueEnum, other.valueEnum) &&
        Objects.equals(this.valueInteger, other.valueInteger) &&
        Objects.equals(this.valueString, other.valueString);
  }

  @Override
  public int hashCode() {
    return Objects.hash(valueEnum, valueInteger, valueString);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AbstractType {");
    sb.append("\n    valueEnum: ").append(toIndentedString(valueEnum));
    sb.append("\n    valueInteger: ").append(toIndentedString(valueInteger));
    sb.append("\n    valueString: ").append(toIndentedString(valueString));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
