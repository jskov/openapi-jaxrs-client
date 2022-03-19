/*
 * Azure Container Registry
 * Metadata API definition for the Azure Container Registry runtime
 *
 * The version of the OpenAPI document: 2019-08-15-preview
 */

package mada.tests.e2e.examples.azure.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.validation.Valid;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Tag attributes
 */
@Schema(description = "Tag attributes")
@JsonbPropertyOrder({
  TagAttributes.JSON_PROPERTY_REGISTRY,
  TagAttributes.JSON_PROPERTY_IMAGE_NAME,
  TagAttributes.JSON_PROPERTY_TAG
})
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public class TagAttributes {
  public static final String JSON_PROPERTY_REGISTRY = "registry";
  @JsonbProperty(JSON_PROPERTY_REGISTRY)
  @Schema(description = "Registry name")
  private String registry;

  public static final String JSON_PROPERTY_IMAGE_NAME = "imageName";
  @JsonbProperty(JSON_PROPERTY_IMAGE_NAME)
  @Schema(description = "Image name")
  private String imageName;

  public static final String JSON_PROPERTY_TAG = "tag";
  @JsonbProperty(JSON_PROPERTY_TAG)
  private TagAttributesBase tag;

  public TagAttributes registry(String registry) {
    this.registry = registry;
    return this;
  }

  /**
   * Registry name.
   *
   * @return registry
   **/
  public String getRegistry() {
    return registry;
  }

  public void setRegistry(String registry) {
    this.registry = registry;
  }

  public TagAttributes imageName(String imageName) {
    this.imageName = imageName;
    return this;
  }

  /**
   * Image name.
   *
   * @return imageName
   **/
  public String getImageName() {
    return imageName;
  }

  public void setImageName(String imageName) {
    this.imageName = imageName;
  }

  public TagAttributes tag(TagAttributesBase tag) {
    this.tag = tag;
    return this;
  }

  /**
   * Get tag
   * @return tag
   **/
  @Valid
  public TagAttributesBase getTag() {
    return tag;
  }

  public void setTag(TagAttributesBase tag) {
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
    TagAttributes other = (TagAttributes) o;
    return Objects.equals(this.registry, other.registry) &&
        Objects.equals(this.imageName, other.imageName) &&
        Objects.equals(this.tag, other.tag);
  }

  @Override
  public int hashCode() {
    return Objects.hash(registry, imageName, tag);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TagAttributes {");
    sb.append("\n    registry: ").append(toIndentedString(registry));
    sb.append("\n    imageName: ").append(toIndentedString(imageName));
    sb.append("\n    tag: ").append(toIndentedString(tag));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
