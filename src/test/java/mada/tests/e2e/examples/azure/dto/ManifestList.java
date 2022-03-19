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
 * Returns the requested Docker multi-arch-manifest file
 */
@Schema(description = "Returns the requested Docker multi-arch-manifest file")
@JsonbPropertyOrder({
  ManifestList.JSON_PROPERTY_MEDIA_TYPE,
  ManifestList.JSON_PROPERTY_MANIFESTS
})
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public class ManifestList {
  public static final String JSON_PROPERTY_MEDIA_TYPE = "mediaType";
  @JsonbProperty(JSON_PROPERTY_MEDIA_TYPE)
  @Schema(description = "Media type for this Manifest")
  private String mediaType;

  public static final String JSON_PROPERTY_MANIFESTS = "manifests";
  @JsonbProperty(JSON_PROPERTY_MANIFESTS)
  @Schema(description = "List of V2 image layer information")
  private List<ManifestListAttributes> manifests = null;

  public ManifestList mediaType(String mediaType) {
    this.mediaType = mediaType;
    return this;
  }

  /**
   * Media type for this Manifest.
   *
   * @return mediaType
   **/
  public String getMediaType() {
    return mediaType;
  }

  public void setMediaType(String mediaType) {
    this.mediaType = mediaType;
  }

  public ManifestList manifests(List<ManifestListAttributes> manifests) {
    this.manifests = manifests;
    return this;
  }

  public ManifestList addManifestsItem(ManifestListAttributes manifestsItem) {
    if (this.manifests == null) {
      this.manifests = new ArrayList<>();
    }
    this.manifests.add(manifestsItem);
    return this;
  }

  /**
   * List of V2 image layer information.
   *
   * @return manifests
   **/
  @Valid
  public List<ManifestListAttributes> getManifests() {
    return manifests;
  }

  public void setManifests(List<ManifestListAttributes> manifests) {
    this.manifests = manifests;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ManifestList other = (ManifestList) o;
    return Objects.equals(this.mediaType, other.mediaType) &&
        Objects.equals(this.manifests, other.manifests);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mediaType, manifests);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ManifestList {");
    sb.append("\n    mediaType: ").append(toIndentedString(mediaType));
    sb.append("\n    manifests: ").append(toIndentedString(manifests));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
