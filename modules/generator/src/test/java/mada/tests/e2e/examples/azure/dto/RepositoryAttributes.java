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
 * Repository attributes
 */
@Schema(description = "Repository attributes")
@JsonbPropertyOrder({
  RepositoryAttributes.JSON_PROPERTY_REGISTRY,
  RepositoryAttributes.JSON_PROPERTY_IMAGE_NAME,
  RepositoryAttributes.JSON_PROPERTY_CREATED_TIME,
  RepositoryAttributes.JSON_PROPERTY_LAST_UPDATE_TIME,
  RepositoryAttributes.JSON_PROPERTY_MANIFEST_COUNT,
  RepositoryAttributes.JSON_PROPERTY_TAG_COUNT,
  RepositoryAttributes.JSON_PROPERTY_CHANGEABLE_ATTRIBUTES
})
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public class RepositoryAttributes {
  public static final String JSON_PROPERTY_REGISTRY = "registry";
  @JsonbProperty(JSON_PROPERTY_REGISTRY)
  @Schema(description = "Registry name")
  private String registry;

  public static final String JSON_PROPERTY_IMAGE_NAME = "imageName";
  @JsonbProperty(JSON_PROPERTY_IMAGE_NAME)
  @Schema(description = "Image name")
  private String imageName;

  public static final String JSON_PROPERTY_CREATED_TIME = "createdTime";
  @JsonbProperty(JSON_PROPERTY_CREATED_TIME)
  @Schema(description = "Image created time")
  private String createdTime;

  public static final String JSON_PROPERTY_LAST_UPDATE_TIME = "lastUpdateTime";
  @JsonbProperty(JSON_PROPERTY_LAST_UPDATE_TIME)
  @Schema(description = "Image last update time")
  private String lastUpdateTime;

  public static final String JSON_PROPERTY_MANIFEST_COUNT = "manifestCount";
  @JsonbProperty(JSON_PROPERTY_MANIFEST_COUNT)
  @Schema(description = "Number of the manifests")
  private Short manifestCount;

  public static final String JSON_PROPERTY_TAG_COUNT = "tagCount";
  @JsonbProperty(JSON_PROPERTY_TAG_COUNT)
  @Schema(description = "Number of the tags")
  private Short tagCount;

  public static final String JSON_PROPERTY_CHANGEABLE_ATTRIBUTES = "changeableAttributes";
  @JsonbProperty(JSON_PROPERTY_CHANGEABLE_ATTRIBUTES)
  private RepositoryChangeableAttributes changeableAttributes;

  public RepositoryAttributes registry(String registry) {
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

  public RepositoryAttributes imageName(String imageName) {
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

  public RepositoryAttributes createdTime(String createdTime) {
    this.createdTime = createdTime;
    return this;
  }

  /**
   * Image created time.
   *
   * @return createdTime
   **/
  public String getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(String createdTime) {
    this.createdTime = createdTime;
  }

  public RepositoryAttributes lastUpdateTime(String lastUpdateTime) {
    this.lastUpdateTime = lastUpdateTime;
    return this;
  }

  /**
   * Image last update time.
   *
   * @return lastUpdateTime
   **/
  public String getLastUpdateTime() {
    return lastUpdateTime;
  }

  public void setLastUpdateTime(String lastUpdateTime) {
    this.lastUpdateTime = lastUpdateTime;
  }

  public RepositoryAttributes manifestCount(Short manifestCount) {
    this.manifestCount = manifestCount;
    return this;
  }

  /**
   * Number of the manifests.
   *
   * @return manifestCount
   **/
  public Short getManifestCount() {
    return manifestCount;
  }

  public void setManifestCount(Short manifestCount) {
    this.manifestCount = manifestCount;
  }

  public RepositoryAttributes tagCount(Short tagCount) {
    this.tagCount = tagCount;
    return this;
  }

  /**
   * Number of the tags.
   *
   * @return tagCount
   **/
  public Short getTagCount() {
    return tagCount;
  }

  public void setTagCount(Short tagCount) {
    this.tagCount = tagCount;
  }

  public RepositoryAttributes changeableAttributes(RepositoryChangeableAttributes changeableAttributes) {
    this.changeableAttributes = changeableAttributes;
    return this;
  }

  /**
   * Get changeableAttributes
   * @return changeableAttributes
   **/
  @Valid
  public RepositoryChangeableAttributes getChangeableAttributes() {
    return changeableAttributes;
  }

  public void setChangeableAttributes(RepositoryChangeableAttributes changeableAttributes) {
    this.changeableAttributes = changeableAttributes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RepositoryAttributes other = (RepositoryAttributes) o;
    return Objects.equals(this.registry, other.registry) &&
        Objects.equals(this.imageName, other.imageName) &&
        Objects.equals(this.createdTime, other.createdTime) &&
        Objects.equals(this.lastUpdateTime, other.lastUpdateTime) &&
        Objects.equals(this.manifestCount, other.manifestCount) &&
        Objects.equals(this.tagCount, other.tagCount) &&
        Objects.equals(this.changeableAttributes, other.changeableAttributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(registry, imageName, createdTime, lastUpdateTime, manifestCount, tagCount, changeableAttributes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RepositoryAttributes {");
    sb.append("\n    registry: ").append(toIndentedString(registry));
    sb.append("\n    imageName: ").append(toIndentedString(imageName));
    sb.append("\n    createdTime: ").append(toIndentedString(createdTime));
    sb.append("\n    lastUpdateTime: ").append(toIndentedString(lastUpdateTime));
    sb.append("\n    manifestCount: ").append(toIndentedString(manifestCount));
    sb.append("\n    tagCount: ").append(toIndentedString(tagCount));
    sb.append("\n    changeableAttributes: ").append(toIndentedString(changeableAttributes));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
