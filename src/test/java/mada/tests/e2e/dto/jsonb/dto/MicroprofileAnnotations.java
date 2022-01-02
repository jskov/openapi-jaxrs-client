/*
 * openapi-examples API
 * 
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 * 
 *
 * This class was auto generated by openapi-jaxrs-client (https://github.com/jskov/openapi-jaxrs-client).
 * Do not edit the class manually.
 */

package mada.tests.e2e.dto.jsonb.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;

/**
 * MicroprofileAnnotations
 */
@JsonbPropertyOrder({
  MicroprofileAnnotations.JSON_PROPERTY_WITH_DESCRIPTION,
  MicroprofileAnnotations.JSON_PROPERTY_WITH_EXAMPLE
})
@javax.annotation.Generated(value = "dk.mada.jaxrs.generator.DtoGenerator")
public class MicroprofileAnnotations   {
  public static final String JSON_PROPERTY_WITH_DESCRIPTION = "withDescription";
  @JsonbProperty(JSON_PROPERTY_WITH_DESCRIPTION)
  private String withDescription;

  public static final String JSON_PROPERTY_WITH_EXAMPLE = "withExample";
  @JsonbProperty(JSON_PROPERTY_WITH_EXAMPLE)
  private String withExample;

  public MicroprofileAnnotations withDescription(String withDescription) {
    this.withDescription = withDescription;
    return this;
  }

  /**
   * property description
   * @return withDescription
   **/
  @ApiModelProperty(value = "property description")
  public String getWithDescription() {
    return withDescription;
  }

  public void setWithDescription(String withDescription) {
    this.withDescription = withDescription;
  }

  public MicroprofileAnnotations withExample(String withExample) {
    this.withExample = withExample;
    return this;
  }

  /**
   * Get withExample
   * @return withExample
   **/
  @ApiModelProperty(example = "property example", value = "")
  public String getWithExample() {
    return withExample;
  }

  public void setWithExample(String withExample) {
    this.withExample = withExample;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MicroprofileAnnotations other = (MicroprofileAnnotations) o;
    return Objects.equals(this.withDescription, other.withDescription) &&
        Objects.equals(this.withExample, other.withExample);
  }

  @Override
  public int hashCode() {
    return Objects.hash(withDescription, withExample);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MicroprofileAnnotations {");
    sb.append("\n    withDescription: ").append(toIndentedString(withDescription));
    sb.append("\n    withExample: ").append(toIndentedString(withExample));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}

