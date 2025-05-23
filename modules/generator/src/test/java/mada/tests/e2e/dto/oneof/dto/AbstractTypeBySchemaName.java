/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.dto.oneof.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * AbstractTypeBySchemaName
 */
@JsonIgnoreProperties(
  value = "implName", // ignore manually set implName, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the implName to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "implName", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = NamedLowercase.class, name = "key-lower-case"),
  @JsonSubTypes.Type(value = TypeNamedBar.class, name = "BAR"),
  @JsonSubTypes.Type(value = TypeNamedFoo.class, name = "FOO"),
})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public abstract class AbstractTypeBySchemaName {
  public static final String JSON_PROPERTY_VALUE_INTEGER = "valueInteger";
  @JsonProperty(JSON_PROPERTY_VALUE_INTEGER)
  @Schema(required = true)
  private Integer valueInteger;

  public AbstractTypeBySchemaName valueInteger(Integer valueInteger) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AbstractTypeBySchemaName)) {
      return false;
    }
    AbstractTypeBySchemaName other = (AbstractTypeBySchemaName) o;
    return Objects.equals(this.valueInteger, other.valueInteger);
  }

  @Override
  public int hashCode() {
    return Objects.hash(valueInteger);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AbstractTypeBySchemaName {");
    sb.append("\n    valueInteger: ").append(toIndentedString(valueInteger));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
