/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.dto.additional_properties.dto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;

/**
 * FreeFormProperties
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class FreeFormProperties {
  public static final String JSON_PROPERTY_FROM_BOOLEAN = "fromBoolean";
  @JsonbProperty(JSON_PROPERTY_FROM_BOOLEAN)
  private Map<String, Object> fromBoolean;

  public static final String JSON_PROPERTY_FROM_TYPELESS = "fromTypeless";
  @JsonbProperty(JSON_PROPERTY_FROM_TYPELESS)
  private Map<String, Object> fromTypeless;

  public FreeFormProperties fromBoolean(Map<String, Object> fromBoolean) {
    this.fromBoolean = fromBoolean;
    return this;
  }

  public FreeFormProperties putFromBooleanItem(String key, Object fromBooleanItem) {
    if (this.fromBoolean == null) {
      this.fromBoolean = new HashMap<>();
    }
    this.fromBoolean.put(key, fromBooleanItem);
    return this;
  }

  /**
   * Get fromBoolean
   * @return fromBoolean
   **/
  public Map<String, Object> getFromBoolean() {
    return fromBoolean;
  }

  public void setFromBoolean(Map<String, Object> fromBoolean) {
    this.fromBoolean = fromBoolean;
  }

  public FreeFormProperties fromTypeless(Map<String, Object> fromTypeless) {
    this.fromTypeless = fromTypeless;
    return this;
  }

  public FreeFormProperties putFromTypelessItem(String key, Object fromTypelessItem) {
    if (this.fromTypeless == null) {
      this.fromTypeless = new HashMap<>();
    }
    this.fromTypeless.put(key, fromTypelessItem);
    return this;
  }

  /**
   * Get fromTypeless
   * @return fromTypeless
   **/
  public Map<String, Object> getFromTypeless() {
    return fromTypeless;
  }

  public void setFromTypeless(Map<String, Object> fromTypeless) {
    this.fromTypeless = fromTypeless;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof FreeFormProperties)) {
      return false;
    }
    FreeFormProperties other = (FreeFormProperties) o;
    return Objects.equals(this.fromBoolean, other.fromBoolean) &&
        Objects.equals(this.fromTypeless, other.fromTypeless);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fromBoolean, fromTypeless);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FreeFormProperties {");
    sb.append("\n    fromBoolean: ").append(toIndentedString(fromBoolean));
    sb.append("\n    fromTypeless: ").append(toIndentedString(fromTypeless));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
