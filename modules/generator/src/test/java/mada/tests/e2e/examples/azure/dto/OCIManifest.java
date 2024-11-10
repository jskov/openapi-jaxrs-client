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
 * Returns the requested OCI Manifest file.
 */
@Schema(description = "Returns the requested OCI Manifest file")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class OCIManifest {
    public static final String JSON_PROPERTY_ANNOTATIONS = "annotations";
    @JsonbProperty(JSON_PROPERTY_ANNOTATIONS)
    private Annotations annotations;

    public static final String JSON_PROPERTY_CONFIG = "config";
    @JsonbProperty(JSON_PROPERTY_CONFIG)
    private Descriptor config;

    public static final String JSON_PROPERTY_LAYERS = "layers";
    @JsonbProperty(JSON_PROPERTY_LAYERS)
    @Schema(description = "List of V2 image layer information")
    private List<Descriptor> layers;

    public OCIManifest annotations(Annotations annotations) {
        this.annotations = annotations;
        return this;
    }

    /**
     * Get annotations
     *
     * @return annotations
     **/
    public @Valid Annotations getAnnotations() {
        return annotations;
    }

    public void setAnnotations(Annotations annotations) {
        this.annotations = annotations;
    }

    public OCIManifest config(Descriptor config) {
        this.config = config;
        return this;
    }

    /**
     * Get config
     *
     * @return config
     **/
    public @Valid Descriptor getConfig() {
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
     * @return layers
     **/
    public @Valid List<Descriptor> getLayers() {
        return layers;
    }

    public void setLayers(List<Descriptor> layers) {
        this.layers = layers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OCIManifest)) {
            return false;
        }
        OCIManifest other = (OCIManifest) o;
        return Objects.equals(this.annotations, other.annotations) &&
                Objects.equals(this.config, other.config) &&
                Objects.equals(this.layers, other.layers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(annotations, config, layers);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OCIManifest {");
        sb.append("\n    annotations: ").append(toIndentedString(annotations));
        sb.append("\n    config: ").append(toIndentedString(config));
        sb.append("\n    layers: ").append(toIndentedString(layers));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
