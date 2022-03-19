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
 * Returns the requested OCI index file
 */
@Schema(description = "Returns the requested OCI index file")
@JsonbPropertyOrder({
  OCIIndex.JSON_PROPERTY_MANIFESTS,
  OCIIndex.JSON_PROPERTY_ANNOTATIONS
})
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public class OCIIndex {
  public static final String JSON_PROPERTY_MANIFESTS = "manifests";
  @JsonbProperty(JSON_PROPERTY_MANIFESTS)
  @Schema(description = "List of OCI image layer information")
  private List<ManifestListAttributes> manifests = null;

  public static final String JSON_PROPERTY_ANNOTATIONS = "annotations";
  @JsonbProperty(JSON_PROPERTY_ANNOTATIONS)
  private Annotations annotations;

  public OCIIndex manifests(List<ManifestListAttributes> manifests) {
    this.manifests = manifests;
    return this;
  }

  public OCIIndex addManifestsItem(ManifestListAttributes manifestsItem) {
    if (this.manifests == null) {
      this.manifests = new ArrayList<>();
    }
    this.manifests.add(manifestsItem);
    return this;
  }

  /**
   * List of OCI image layer information.
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

  public OCIIndex annotations(Annotations annotations) {
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
    OCIIndex other = (OCIIndex) o;
    return Objects.equals(this.manifests, other.manifests) &&
        Objects.equals(this.annotations, other.annotations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(manifests, annotations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OCIIndex {");
    sb.append("\n    manifests: ").append(toIndentedString(manifests));
    sb.append("\n    annotations: ").append(toIndentedString(annotations));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
