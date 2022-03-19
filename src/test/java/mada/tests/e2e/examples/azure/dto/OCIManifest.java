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
 * Returns the requested OCI Manifest file
 */
@Schema(description = "Returns the requested OCI Manifest file")
@JsonbPropertyOrder({
  OCIManifest.JSON_PROPERTY_CONFIG,
  OCIManifest.JSON_PROPERTY_LAYERS,
  OCIManifest.JSON_PROPERTY_ANNOTATIONS
})
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public class OCIManifest {
  public static final String JSON_PROPERTY_CONFIG = "config";
  @JsonbProperty(JSON_PROPERTY_CONFIG)
  private Descriptor config;

  public static final String JSON_PROPERTY_LAYERS = "layers";
  @JsonbProperty(JSON_PROPERTY_LAYERS)
  @Schema(description = "List of V2 image layer information")
  private List<Descriptor> layers = null;

  public static final String JSON_PROPERTY_ANNOTATIONS = "annotations";
  @JsonbProperty(JSON_PROPERTY_ANNOTATIONS)
  private Annotations annotations;

  public OCIManifest config(Descriptor config) {
    this.config = config;
    return this;
  }

  /**
   * Get config
   * @return config
   **/
  @Valid
  public Descriptor getConfig() {
    return config;
  }

  public void setConfig(Descriptor config) {
    this.config = config;
  }

  public OCIManifest layers(List<Descriptor> layers) {
    this.layers = layers;
    return this;
  }

  public OCIManifest addLayersItem(Descriptor layersItem) {
    if (this.layers == null) {
      this.layers = new ArrayList<>();
    }
    this.layers.add(layersItem);
    return this;
  }

  /**
   * List of V2 image layer information.
   *
   * @return layers
   **/
  @Valid
  public List<Descriptor> getLayers() {
    return layers;
  }

  public void setLayers(List<Descriptor> layers) {
    this.layers = layers;
  }

  public OCIManifest annotations(Annotations annotations) {
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
    OCIManifest other = (OCIManifest) o;
    return Objects.equals(this.config, other.config) &&
        Objects.equals(this.layers, other.layers) &&
        Objects.equals(this.annotations, other.annotations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(config, layers, annotations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OCIManifest {");
    sb.append("\n    config: ").append(toIndentedString(config));
    sb.append("\n    layers: ").append(toIndentedString(layers));
    sb.append("\n    annotations: ").append(toIndentedString(annotations));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
