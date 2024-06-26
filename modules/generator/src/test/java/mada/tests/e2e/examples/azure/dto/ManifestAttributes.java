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
 * Manifest attributes details.
 */
@Schema(description = "Manifest attributes details")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ManifestAttributes {
  public static final String JSON_PROPERTY_IMAGE_NAME = "imageName";
  @JsonbProperty(JSON_PROPERTY_IMAGE_NAME)
  @Schema(description = "Image name")
  private String imageName;

  public static final String JSON_PROPERTY_MANIFEST = "manifest";
  @JsonbProperty(JSON_PROPERTY_MANIFEST)
  private ManifestAttributesBase manifest;

  public static final String JSON_PROPERTY_REGISTRY = "registry";
  @JsonbProperty(JSON_PROPERTY_REGISTRY)
  @Schema(description = "Registry name")
  private String registry;

  public ManifestAttributes imageName(String imageName) {
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

  public ManifestAttributes manifest(ManifestAttributesBase manifest) {
    this.manifest = manifest;
    return this;
  }

  /**
   * Get manifest
   * @return manifest
   **/
  @Valid
  public ManifestAttributesBase getManifest() {
    return manifest;
  }

  public void setManifest(ManifestAttributesBase manifest) {
    this.manifest = manifest;
  }

  public ManifestAttributes registry(String registry) {
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
    if (!(o instanceof ManifestAttributes)) {
      return false;
    }
    ManifestAttributes other = (ManifestAttributes) o;
    return Objects.equals(this.imageName, other.imageName) &&
        Objects.equals(this.manifest, other.manifest) &&
        Objects.equals(this.registry, other.registry);
  }

  @Override
  public int hashCode() {
    return Objects.hash(imageName, manifest, registry);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ManifestAttributes {");
    sb.append("\n    imageName: ").append(toIndentedString(imageName));
    sb.append("\n    manifest: ").append(toIndentedString(manifest));
    sb.append("\n    registry: ").append(toIndentedString(registry));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
