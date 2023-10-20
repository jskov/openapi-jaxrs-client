/*
 * Azure Container Registry
 * Metadata API definition for the Azure Container Registry runtime
 *
 * The version of the OpenAPI document: 2019-08-15-preview
 */

package mada.tests.e2e.examples.azure.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.validation.Valid;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * List of tag details
 */
@Schema(description = "List of tag details")
@JsonbPropertyOrder({
  TagList.JSON_PROPERTY_REGISTRY,
  TagList.JSON_PROPERTY_IMAGE_NAME,
  TagList.JSON_PROPERTY_TAGS
})
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public class TagList {
  public static final String JSON_PROPERTY_REGISTRY = "registry";
  @JsonbProperty(JSON_PROPERTY_REGISTRY)
  @Schema(description = "Registry name")
  private String registry;

  public static final String JSON_PROPERTY_IMAGE_NAME = "imageName";
  @JsonbProperty(JSON_PROPERTY_IMAGE_NAME)
  @Schema(description = "Image name")
  private String imageName;

  public static final String JSON_PROPERTY_TAGS = "tags";
  @JsonbProperty(JSON_PROPERTY_TAGS)
  @Schema(description = "List of tag attribute details")
  private List<TagAttributesBase> tags = null;

  public TagList registry(String registry) {
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

  public TagList imageName(String imageName) {
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

  public TagList tags(List<TagAttributesBase> tags) {
    this.tags = tags;
    return this;
  }

  public TagList addTagsItem(TagAttributesBase tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<>();
    }
    this.tags.add(tagsItem);
    return this;
  }

  /**
   * List of tag attribute details.
   *
   * @return tags
   **/
  @Valid
  public List<TagAttributesBase> getTags() {
    return tags;
  }

  public void setTags(List<TagAttributesBase> tags) {
    this.tags = tags;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TagList other = (TagList) o;
    return Objects.equals(this.registry, other.registry) &&
        Objects.equals(this.imageName, other.imageName) &&
        Objects.equals(this.tags, other.tags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(registry, imageName, tags);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TagList {");
    sb.append("\n    registry: ").append(toIndentedString(registry));
    sb.append("\n    imageName: ").append(toIndentedString(imageName));
    sb.append("\n    tags: ").append(toIndentedString(tags));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
