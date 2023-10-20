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
 * Docker V2 image layer descriptor including config and layers
 */
@Schema(description = "Docker V2 image layer descriptor including config and layers")
@JsonbPropertyOrder({
  Descriptor.JSON_PROPERTY_MEDIA_TYPE,
  Descriptor.JSON_PROPERTY_SIZE,
  Descriptor.JSON_PROPERTY_DIGEST,
  Descriptor.JSON_PROPERTY_URLS,
  Descriptor.JSON_PROPERTY_ANNOTATIONS
})
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public class Descriptor {
  public static final String JSON_PROPERTY_MEDIA_TYPE = "mediaType";
  @JsonbProperty(JSON_PROPERTY_MEDIA_TYPE)
  @Schema(description = "Layer media type")
  private String mediaType;

  public static final String JSON_PROPERTY_SIZE = "size";
  @JsonbProperty(JSON_PROPERTY_SIZE)
  @Schema(description = "Layer size")
  private Long size;

  public static final String JSON_PROPERTY_DIGEST = "digest";
  @JsonbProperty(JSON_PROPERTY_DIGEST)
  @Schema(description = "Layer digest")
  private String digest;

  public static final String JSON_PROPERTY_URLS = "urls";
  @JsonbProperty(JSON_PROPERTY_URLS)
  @Schema(description = "Specifies a list of URIs from which this object may be downloaded.")
  private List<String> urls = null;

  public static final String JSON_PROPERTY_ANNOTATIONS = "annotations";
  @JsonbProperty(JSON_PROPERTY_ANNOTATIONS)
  private Annotations annotations;

  public Descriptor mediaType(String mediaType) {
    this.mediaType = mediaType;
    return this;
  }

  /**
   * Layer media type.
   *
   * @return mediaType
   **/
  public String getMediaType() {
    return mediaType;
  }

  public void setMediaType(String mediaType) {
    this.mediaType = mediaType;
  }

  public Descriptor size(Long size) {
    this.size = size;
    return this;
  }

  /**
   * Layer size.
   *
   * @return size
   **/
  public Long getSize() {
    return size;
  }

  public void setSize(Long size) {
    this.size = size;
  }

  public Descriptor digest(String digest) {
    this.digest = digest;
    return this;
  }

  /**
   * Layer digest.
   *
   * @return digest
   **/
  public String getDigest() {
    return digest;
  }

  public void setDigest(String digest) {
    this.digest = digest;
  }

  public Descriptor urls(List<String> urls) {
    this.urls = urls;
    return this;
  }

  public Descriptor addUrlsItem(String urlsItem) {
    if (this.urls == null) {
      this.urls = new ArrayList<>();
    }
    this.urls.add(urlsItem);
    return this;
  }

  /**
   * Specifies a list of URIs from which this object may be downloaded.
   *
   * @return urls
   **/
  public List<String> getUrls() {
    return urls;
  }

  public void setUrls(List<String> urls) {
    this.urls = urls;
  }

  public Descriptor annotations(Annotations annotations) {
    this.annotations = annotations;
    return this;
  }

  /**
   * Get annotations
   * @return annotations
   **/
  @Valid
  public Annotations getAnnotations() {
    return annotations;
  }

  public void setAnnotations(Annotations annotations) {
    this.annotations = annotations;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Descriptor other = (Descriptor) o;
    return Objects.equals(this.mediaType, other.mediaType) &&
        Objects.equals(this.size, other.size) &&
        Objects.equals(this.digest, other.digest) &&
        Objects.equals(this.urls, other.urls) &&
        Objects.equals(this.annotations, other.annotations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mediaType, size, digest, urls, annotations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Descriptor {");
    sb.append("\n    mediaType: ").append(toIndentedString(mediaType));
    sb.append("\n    size: ").append(toIndentedString(size));
    sb.append("\n    digest: ").append(toIndentedString(digest));
    sb.append("\n    urls: ").append(toIndentedString(urls));
    sb.append("\n    annotations: ").append(toIndentedString(annotations));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
