/*
 * Azure Container Registry
 * Metadata API definition for the Azure Container Registry runtime
 *
 * The version of the OpenAPI document: 2019-08-15-preview
 */

package mada.tests.e2e.examples.azure.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Manifest details.
 */
@Schema(description = "Manifest details")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ManifestAttributesBase {
  public static final String JSON_PROPERTY_ARCHITECTURE = "architecture";
  @JsonbProperty(JSON_PROPERTY_ARCHITECTURE)
  @Schema(description = "CPU architecture")
  private String architecture;

  public static final String JSON_PROPERTY_CHANGEABLE_ATTRIBUTES = "changeableAttributes";
  @JsonbProperty(JSON_PROPERTY_CHANGEABLE_ATTRIBUTES)
  private ManifestChangeableAttributes changeableAttributes;

  public static final String JSON_PROPERTY_CONFIG_MEDIA_TYPE = "configMediaType";
  @JsonbProperty(JSON_PROPERTY_CONFIG_MEDIA_TYPE)
  @Schema(description = "Config blob media type")
  private String configMediaType;

  public static final String JSON_PROPERTY_CREATED_TIME = "createdTime";
  @JsonbProperty(JSON_PROPERTY_CREATED_TIME)
  @Schema(description = "Created time")
  private String createdTime;

  public static final String JSON_PROPERTY_DIGEST = "digest";
  @JsonbProperty(JSON_PROPERTY_DIGEST)
  @Schema(description = "Manifest")
  private String digest;

  public static final String JSON_PROPERTY_IMAGE_SIZE = "imageSize";
  @JsonbProperty(JSON_PROPERTY_IMAGE_SIZE)
  @Schema(description = "Image size")
  private Long imageSize;

  public static final String JSON_PROPERTY_LAST_UPDATE_TIME = "lastUpdateTime";
  @JsonbProperty(JSON_PROPERTY_LAST_UPDATE_TIME)
  @Schema(description = "Last update time")
  private String lastUpdateTime;

  public static final String JSON_PROPERTY_MEDIA_TYPE = "mediaType";
  @JsonbProperty(JSON_PROPERTY_MEDIA_TYPE)
  @Schema(description = "Media type")
  private String mediaType;

  public static final String JSON_PROPERTY_OS = "os";
  @JsonbProperty(JSON_PROPERTY_OS)
  @Schema(description = "Operating system")
  private String os;

  public static final String JSON_PROPERTY_TAGS = "tags";
  @JsonbProperty(JSON_PROPERTY_TAGS)
  @Schema(description = "List of tags")
  private List<String> tags;

  public ManifestAttributesBase architecture(String architecture) {
    this.architecture = architecture;
    return this;
  }

  /**
   * CPU architecture.
   *
   * @return architecture
   **/
  public String getArchitecture() {
    return architecture;
  }

  public void setArchitecture(String architecture) {
    this.architecture = architecture;
  }

  public ManifestAttributesBase changeableAttributes(ManifestChangeableAttributes changeableAttributes) {
    this.changeableAttributes = changeableAttributes;
    return this;
  }

  /**
   * Get changeableAttributes
   * @return changeableAttributes
   **/
  @Valid
  public ManifestChangeableAttributes getChangeableAttributes() {
    return changeableAttributes;
  }

  public void setChangeableAttributes(ManifestChangeableAttributes changeableAttributes) {
    this.changeableAttributes = changeableAttributes;
  }

  public ManifestAttributesBase configMediaType(String configMediaType) {
    this.configMediaType = configMediaType;
    return this;
  }

  /**
   * Config blob media type.
   *
   * @return configMediaType
   **/
  public String getConfigMediaType() {
    return configMediaType;
  }

  public void setConfigMediaType(String configMediaType) {
    this.configMediaType = configMediaType;
  }

  public ManifestAttributesBase createdTime(String createdTime) {
    this.createdTime = createdTime;
    return this;
  }

  /**
   * Created time.
   *
   * @return createdTime
   **/
  public String getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(String createdTime) {
    this.createdTime = createdTime;
  }

  public ManifestAttributesBase digest(String digest) {
    this.digest = digest;
    return this;
  }

  /**
   * Manifest.
   *
   * @return digest
   **/
  public String getDigest() {
    return digest;
  }

  public void setDigest(String digest) {
    this.digest = digest;
  }

  public ManifestAttributesBase imageSize(Long imageSize) {
    this.imageSize = imageSize;
    return this;
  }

  /**
   * Image size.
   *
   * @return imageSize
   **/
  public Long getImageSize() {
    return imageSize;
  }

  public void setImageSize(Long imageSize) {
    this.imageSize = imageSize;
  }

  public ManifestAttributesBase lastUpdateTime(String lastUpdateTime) {
    this.lastUpdateTime = lastUpdateTime;
    return this;
  }

  /**
   * Last update time.
   *
   * @return lastUpdateTime
   **/
  public String getLastUpdateTime() {
    return lastUpdateTime;
  }

  public void setLastUpdateTime(String lastUpdateTime) {
    this.lastUpdateTime = lastUpdateTime;
  }

  public ManifestAttributesBase mediaType(String mediaType) {
    this.mediaType = mediaType;
    return this;
  }

  /**
   * Media type.
   *
   * @return mediaType
   **/
  public String getMediaType() {
    return mediaType;
  }

  public void setMediaType(String mediaType) {
    this.mediaType = mediaType;
  }

  public ManifestAttributesBase os(String os) {
    this.os = os;
    return this;
  }

  /**
   * Operating system.
   *
   * @return os
   **/
  public String getOs() {
    return os;
  }

  public void setOs(String os) {
    this.os = os;
  }

  public ManifestAttributesBase tags(List<String> tags) {
    this.tags = tags;
    return this;
  }

  public ManifestAttributesBase addTagsItem(String tagsItem) {
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
    if (!(o instanceof ManifestAttributesBase)) {
      return false;
    }
    ManifestAttributesBase other = (ManifestAttributesBase) o;
    return Objects.equals(this.architecture, other.architecture) &&
        Objects.equals(this.changeableAttributes, other.changeableAttributes) &&
        Objects.equals(this.configMediaType, other.configMediaType) &&
        Objects.equals(this.createdTime, other.createdTime) &&
        Objects.equals(this.digest, other.digest) &&
        Objects.equals(this.imageSize, other.imageSize) &&
        Objects.equals(this.lastUpdateTime, other.lastUpdateTime) &&
        Objects.equals(this.mediaType, other.mediaType) &&
        Objects.equals(this.os, other.os) &&
        Objects.equals(this.tags, other.tags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(architecture, changeableAttributes, configMediaType, createdTime, digest, imageSize, lastUpdateTime, mediaType, os, tags);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ManifestAttributesBase {");
    sb.append("\n    architecture: ").append(toIndentedString(architecture));
    sb.append("\n    changeableAttributes: ").append(toIndentedString(changeableAttributes));
    sb.append("\n    configMediaType: ").append(toIndentedString(configMediaType));
    sb.append("\n    createdTime: ").append(toIndentedString(createdTime));
    sb.append("\n    digest: ").append(toIndentedString(digest));
    sb.append("\n    imageSize: ").append(toIndentedString(imageSize));
    sb.append("\n    lastUpdateTime: ").append(toIndentedString(lastUpdateTime));
    sb.append("\n    mediaType: ").append(toIndentedString(mediaType));
    sb.append("\n    os: ").append(toIndentedString(os));
    sb.append("\n    tags: ").append(toIndentedString(tags));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
