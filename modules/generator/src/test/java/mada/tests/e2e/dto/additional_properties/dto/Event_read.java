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
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Content of an event when fetching a single event.
 */
@Schema(description = "Content of an event when fetching a single event")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class Event_read {
  public static final String JSON_PROPERTY_CUSTOM = "custom";
  @JsonbProperty(JSON_PROPERTY_CUSTOM)
  @Schema(nullable = true, description = "This is an object with custom field ids as keys and values as strings or arrays of strings for fields of type \"choice\".", example = "{\"field1\":\"value\",\"choicefield\":[\"a\",\"b\"]}")
  private Map<String, Object> custom;

  public Event_read custom(Map<String, Object> custom) {
    this.custom = custom;
    return this;
  }

  public Event_read putCustomItem(String key, Object customItem) {
    if (this.custom == null) {
      this.custom = new HashMap<>();
    }
    this.custom.put(key, customItem);
    return this;
  }

  /**
   * This is an object with custom field ids as keys and values as strings or arrays of strings for fields of type "choice".
   *
   * @return custom
   **/
  public Map<String, Object> getCustom() {
    return custom;
  }

  public void setCustom(Map<String, Object> custom) {
    this.custom = custom;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Event_read)) {
      return false;
    }
    Event_read other = (Event_read) o;
    return Objects.equals(this.custom, other.custom);
  }

  @Override
  public int hashCode() {
    return Objects.hash(custom);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Event_read {");
    sb.append("\n    custom: ").append(toIndentedString(custom));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
