/*
 * Swagger Petstore
 *
 * The version of the OpenAPI document: 1.0.0
 */

package mada.tests.e2e.examples.petstore.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Pet
 */
@JsonbPropertyOrder({
  Pet.JSON_PROPERTY_ID,
  Pet.JSON_PROPERTY_NAME,
  Pet.JSON_PROPERTY_TAG
})
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public class Pet {
  public static final String JSON_PROPERTY_ID = "id";
  @JsonbProperty(JSON_PROPERTY_ID)
  @Schema(required = true)
  private Long id;

  public static final String JSON_PROPERTY_NAME = "name";
  @JsonbProperty(JSON_PROPERTY_NAME)
  @Schema(required = true)
  private String name;

  public static final String JSON_PROPERTY_TAG = "tag";
  @JsonbProperty(JSON_PROPERTY_TAG)
  private String tag;

  public Pet id(Long id) {
    this.id = Objects.requireNonNull(id, "Property id is required, cannot be null");
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @NotNull
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = Objects.requireNonNull(id, "Property id is required, cannot be null");
  }

  public Pet name(String name) {
    this.name = Objects.requireNonNull(name, "Property name is required, cannot be null");
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @NotNull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = Objects.requireNonNull(name, "Property name is required, cannot be null");
  }

  public Pet tag(String tag) {
    this.tag = tag;
    return this;
  }

  /**
   * Get tag
   * @return tag
   **/
  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Pet other = (Pet) o;
    return Objects.equals(this.id, other.id) &&
        Objects.equals(this.name, other.name) &&
        Objects.equals(this.tag, other.tag);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, tag);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Pet {");
    sb.append("\n    id: ").append(toIndentedString(id));
    sb.append("\n    name: ").append(toIndentedString(name));
    sb.append("\n    tag: ").append(toIndentedString(tag));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
