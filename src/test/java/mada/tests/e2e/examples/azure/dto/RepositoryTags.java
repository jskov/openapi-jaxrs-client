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
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Result of the request to list tags of the image
 */
@Schema(description = "Result of the request to list tags of the image")
@JsonbPropertyOrder({
  RepositoryTags.JSON_PROPERTY_NAME,
  RepositoryTags.JSON_PROPERTY_TAGS
})
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public class RepositoryTags {
  public static final String JSON_PROPERTY_NAME = "name";
  @JsonbProperty(JSON_PROPERTY_NAME)
  @Schema(description = "Name of the image")
  private String name;

  public static final String JSON_PROPERTY_TAGS = "tags";
  @JsonbProperty(JSON_PROPERTY_TAGS)
  @Schema(description = "List of tags")
  private List<String> tags = null;

  public RepositoryTags name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the image.
   *
   * @return name
   **/
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public RepositoryTags tags(List<String> tags) {
    this.tags = tags;
    return this;
  }

  public RepositoryTags addTagsItem(String tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<>();
    }
    this.tags.add(tagsItem);
    return this;
  }

  /**
   * List of tags.
   *
   * @return tags
   **/
  public List<String> getTags() {
    return tags;
  }

  public void setTags(List<String> tags) {
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
    RepositoryTags other = (RepositoryTags) o;
    return Objects.equals(this.name, other.name) &&
        Objects.equals(this.tags, other.tags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, tags);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RepositoryTags {");
    sb.append("\n    name: ").append(toIndentedString(name));
    sb.append("\n    tags: ").append(toIndentedString(tags));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
