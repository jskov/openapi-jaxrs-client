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
 * Returns the requested Docker V2 Manifest file.
 */
@Schema(description = "Returns the requested Docker V2 Manifest file")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class V2Manifest {
  public static final String JSON_PROPERTY_CONFIG = "config";
  @JsonbProperty(JSON_PROPERTY_CONFIG)
  private Descriptor config;

  public static final String JSON_PROPERTY_LAYERS = "layers";
  @JsonbProperty(JSON_PROPERTY_LAYERS)
  @Schema(description = "List of V2 image layer information")
  private List<Descriptor> layers;

  public static final String JSON_PROPERTY_MEDIA_TYPE = "mediaType";
  @JsonbProperty(JSON_PROPERTY_MEDIA_TYPE)
  @Schema(description = "Media type for this Manifest")
  private String mediaType;

  public V2Manifest config(Descriptor config) {
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

  public V2Manifest layers(List<Descriptor> layers) {
    this.layers = layers;
    return this;
  }

  public V2Manifest addLayersItem(Descriptor layersItem) {
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

  public V2Manifest mediaType(String mediaType) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof V2Manifest)) {
      return false;
    }
    V2Manifest other = (V2Manifest) o;
    return Objects.equals(this.config, other.config) &&
        Objects.equals(this.layers, other.layers) &&
        Objects.equals(this.mediaType, other.mediaType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(config, layers, mediaType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class V2Manifest {");
    sb.append("\n    config: ").append(toIndentedString(config));
    sb.append("\n    layers: ").append(toIndentedString(layers));
    sb.append("\n    mediaType: ").append(toIndentedString(mediaType));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
