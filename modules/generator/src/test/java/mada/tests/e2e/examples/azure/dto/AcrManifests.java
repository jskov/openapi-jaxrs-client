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
 * Manifest attributes.
 */
@Schema(description = "Manifest attributes")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class AcrManifests {
  public static final String JSON_PROPERTY_IMAGE_NAME = "imageName";
  @JsonbProperty(JSON_PROPERTY_IMAGE_NAME)
  @Schema(description = "Image name")
  private String imageName;

  public static final String JSON_PROPERTY_MANIFESTS = "manifests";
  @JsonbProperty(JSON_PROPERTY_MANIFESTS)
  @Schema(description = "List of manifests")
  private List<ManifestAttributesBase> manifests;

  public static final String JSON_PROPERTY_REGISTRY = "registry";
  @JsonbProperty(JSON_PROPERTY_REGISTRY)
  @Schema(description = "Registry name")
  private String registry;

  public AcrManifests imageName(String imageName) {
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

  public AcrManifests manifests(List<ManifestAttributesBase> manifests) {
    this.manifests = manifests;
    return this;
  }

  public AcrManifests addManifestsItem(ManifestAttributesBase manifestsItem) {
    if (this.manifests == null) {
      this.manifests = new ArrayList<>();
    }
    this.manifests.add(manifestsItem);
    return this;
  }

  /**
   * List of manifests.
   *
   * @return manifests
   **/
  @Valid
  public List<ManifestAttributesBase> getManifests() {
    return manifests;
  }

  public void setManifests(List<ManifestAttributesBase> manifests) {
    this.manifests = manifests;
  }

  public AcrManifests registry(String registry) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AcrManifests)) {
      return false;
    }
    AcrManifests other = (AcrManifests) o;
    return Objects.equals(this.imageName, other.imageName) &&
        Objects.equals(this.manifests, other.manifests) &&
        Objects.equals(this.registry, other.registry);
  }

  @Override
  public int hashCode() {
    return Objects.hash(imageName, manifests, registry);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AcrManifests {");
    sb.append("\n    imageName: ").append(toIndentedString(imageName));
    sb.append("\n    manifests: ").append(toIndentedString(manifests));
    sb.append("\n    registry: ").append(toIndentedString(registry));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
