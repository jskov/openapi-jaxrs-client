/*
 * Azure Container Registry
 * Metadata API definition for the Azure Container Registry runtime
 *
 * The version of the OpenAPI document: 2019-08-15-preview
 */

package mada.tests.e2e.examples.azure.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.Valid;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * ManifestListAttributes
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ManifestListAttributes {
  public static final String JSON_PROPERTY_DIGEST = "digest";
  @JsonbProperty(JSON_PROPERTY_DIGEST)
  @Schema(description = "The digest of the content, as defined by the Registry V2 HTTP API Specification")
  private String digest;

  public static final String JSON_PROPERTY_MEDIA_TYPE = "mediaType";
  @JsonbProperty(JSON_PROPERTY_MEDIA_TYPE)
  @Schema(description = "The MIME type of the referenced object. This will generally be application/vnd.docker.image.manifest.v2+json, but it could also be application/vnd.docker.image.manifest.v1+json")
  private String mediaType;

  public static final String JSON_PROPERTY_PLATFORM = "platform";
  @JsonbProperty(JSON_PROPERTY_PLATFORM)
  private Platform platform;

  public static final String JSON_PROPERTY_SIZE = "size";
  @JsonbProperty(JSON_PROPERTY_SIZE)
  @Schema(description = "The size in bytes of the object")
  private Long size;

  public ManifestListAttributes digest(String digest) {
    this.digest = digest;
    return this;
  }

  /**
   * The digest of the content, as defined by the Registry V2 HTTP API Specification.
   *
   * @return digest
   **/
  public String getDigest() {
    return digest;
  }

  public void setDigest(String digest) {
    this.digest = digest;
  }

  public ManifestListAttributes mediaType(String mediaType) {
    this.mediaType = mediaType;
    return this;
  }

  /**
   * The MIME type of the referenced object. This will generally be application/vnd.docker.image.manifest.v2+json, but it could also be application/vnd.docker.image.manifest.v1+json
   *
   * @return mediaType
   **/
  public String getMediaType() {
    return mediaType;
  }

  public void setMediaType(String mediaType) {
    this.mediaType = mediaType;
  }

  public ManifestListAttributes platform(Platform platform) {
    this.platform = platform;
    return this;
  }

  /**
   * Get platform
   * @return platform
   **/
  @Valid
  public Platform getPlatform() {
    return platform;
  }

  public void setPlatform(Platform platform) {
    this.platform = platform;
  }

  public ManifestListAttributes size(Long size) {
    this.size = size;
    return this;
  }

  /**
   * The size in bytes of the object.
   *
   * @return size
   **/
  public Long getSize() {
    return size;
  }

  public void setSize(Long size) {
    this.size = size;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ManifestListAttributes)) {
      return false;
    }
    ManifestListAttributes other = (ManifestListAttributes) o;
    return Objects.equals(this.digest, other.digest) &&
        Objects.equals(this.mediaType, other.mediaType) &&
        Objects.equals(this.platform, other.platform) &&
        Objects.equals(this.size, other.size);
  }

  @Override
  public int hashCode() {
    return Objects.hash(digest, mediaType, platform, size);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ManifestListAttributes {");
    sb.append("\n    digest: ").append(toIndentedString(digest));
    sb.append("\n    mediaType: ").append(toIndentedString(mediaType));
    sb.append("\n    platform: ").append(toIndentedString(platform));
    sb.append("\n    size: ").append(toIndentedString(size));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
