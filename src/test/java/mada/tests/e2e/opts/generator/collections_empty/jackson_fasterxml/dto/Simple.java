/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.collections_empty.jackson_fasterxml.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/**
 * Simple
 */
@JsonPropertyOrder({
  Simple.JSON_PROPERTY_A_BOOLEAN
})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class Simple {
  public static final String JSON_PROPERTY_A_BOOLEAN = "aBoolean";
  @JsonProperty(JSON_PROPERTY_A_BOOLEAN)
  private Boolean aBoolean;

  public Simple aBoolean(Boolean aBoolean) {
    this.aBoolean = aBoolean;
    return this;
  }

  /**
   * Get aBoolean
   * @return aBoolean
   **/
  public Boolean isaBoolean() {
    return aBoolean;
  }

  public void setaBoolean(Boolean aBoolean) {
    this.aBoolean = aBoolean;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Simple)) {
      return false;
    }
    Simple other = (Simple) o;
    return Objects.equals(this.aBoolean, other.aBoolean);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aBoolean);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Simple {");
    sb.append("\n    aBoolean: ").append(toIndentedString(aBoolean));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
