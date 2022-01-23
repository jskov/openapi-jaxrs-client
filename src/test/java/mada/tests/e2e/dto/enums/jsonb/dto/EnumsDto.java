/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.dto.enums.jsonb.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;

/**
 * EnumsDto
 */
@JsonbPropertyOrder({
  EnumsDto.JSON_PROPERTY_INNER,
  EnumsDto.JSON_PROPERTY_EXTERNAL,
  EnumsDto.JSON_PROPERTY_NUMBER
})
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public class EnumsDto   {
  public static final String JSON_PROPERTY_INNER = "inner";
  @JsonbProperty(JSON_PROPERTY_INNER)
  private InnerEnum inner;

  public static final String JSON_PROPERTY_EXTERNAL = "external";
  @JsonbProperty(JSON_PROPERTY_EXTERNAL)
  private ExternalEnum external;

  public static final String JSON_PROPERTY_NUMBER = "number";
  @JsonbProperty(JSON_PROPERTY_NUMBER)
  private NumberEnum number;

  public EnumsDto inner(InnerEnum inner) {
    this.inner = inner;
    return this;
  }

  /**
   * Get inner
   * @return inner
   **/
  public InnerEnum getInner() {
    return inner;
  }

  public void setInner(InnerEnum inner) {
    this.inner = inner;
  }

  public EnumsDto external(ExternalEnum external) {
    this.external = external;
    return this;
  }

  /**
   * Get external
   * @return external
   **/
  public ExternalEnum getExternal() {
    return external;
  }

  public void setExternal(ExternalEnum external) {
    this.external = external;
  }

  public EnumsDto number(NumberEnum number) {
    this.number = number;
    return this;
  }

  /**
   * Get number
   * @return number
   **/
  public NumberEnum getNumber() {
    return number;
  }

  public void setNumber(NumberEnum number) {
    this.number = number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EnumsDto other = (EnumsDto) o;
    return Objects.equals(this.inner, other.inner) &&
        Objects.equals(this.external, other.external) &&
        Objects.equals(this.number, other.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inner, external, number);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnumsDto {");
    sb.append("\n    inner: ").append(toIndentedString(inner));
    sb.append("\n    external: ").append(toIndentedString(external));
    sb.append("\n    number: ").append(toIndentedString(number));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
