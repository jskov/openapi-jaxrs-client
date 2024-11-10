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
 * Returns the requested manifest file.
 */
@Schema(description = "Returns the requested manifest file")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ManifestWrapper {
    public static final String JSON_PROPERTY_ANNOTATIONS = "annotations";
    @JsonbProperty(JSON_PROPERTY_ANNOTATIONS)
    private Annotations annotations;

    public static final String JSON_PROPERTY_ARCHITECTURE = "architecture";
    @JsonbProperty(JSON_PROPERTY_ARCHITECTURE)
    @Schema(description = "(V1) CPU architecture")
    private String architecture;

    public static final String JSON_PROPERTY_CONFIG = "config";
    @JsonbProperty(JSON_PROPERTY_CONFIG)
    private Descriptor config;

    public static final String JSON_PROPERTY_FS_LAYERS = "fsLayers";
    @JsonbProperty(JSON_PROPERTY_FS_LAYERS)
    @Schema(description = "(V1) List of layer information")
    private List<FsLayer> fsLayers;

    public static final String JSON_PROPERTY_HISTORY = "history";
    @JsonbProperty(JSON_PROPERTY_HISTORY)
    @Schema(description = "(V1) Image history")
    private List<History> history;

    public static final String JSON_PROPERTY_LAYERS = "layers";
    @JsonbProperty(JSON_PROPERTY_LAYERS)
    @Schema(description = "(V2, OCI) List of V2 image layer information")
    private List<Descriptor> layers;

    public static final String JSON_PROPERTY_MANIFESTS = "manifests";
    @JsonbProperty(JSON_PROPERTY_MANIFESTS)
    @Schema(description = "(ManifestList, OCIIndex) List of V2 image layer information")
    private List<ManifestListAttributes> manifests;

    public static final String JSON_PROPERTY_MEDIA_TYPE = "mediaType";
    @JsonbProperty(JSON_PROPERTY_MEDIA_TYPE)
    @Schema(description = "Media type for this Manifest")
    private String mediaType;

    public static final String JSON_PROPERTY_NAME = "name";
    @JsonbProperty(JSON_PROPERTY_NAME)
    @Schema(description = "(V1) Image name")
    private String name;

    public static final String JSON_PROPERTY_SIGNATURES = "signatures";
    @JsonbProperty(JSON_PROPERTY_SIGNATURES)
    @Schema(description = "(V1) Image signature")
    private List<ImageSignature> signatures;

    public static final String JSON_PROPERTY_TAG = "tag";
    @JsonbProperty(JSON_PROPERTY_TAG)
    @Schema(description = "(V1) Image tag")
    private String tag;

    public ManifestWrapper annotations(Annotations annotations) {
        this.annotations = annotations;
        return this;
    }

    /**
     * Get annotations
     *
     * @return annotations
     **/
    @Valid public Annotations getAnnotations() {
        return annotations;
    }

    public void setAnnotations(Annotations annotations) {
        this.annotations = annotations;
    }

    public ManifestWrapper architecture(String architecture) {
        this.architecture = architecture;
        return this;
    }

    /**
     * (V1) CPU architecture.
     * @return architecture
     **/
    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    public ManifestWrapper config(Descriptor config) {
        this.config = config;
        return this;
    }

    /**
     * Get config
     *
     * @return config
     **/
    @Valid public Descriptor getConfig() {
        return config;
    }

    public void setConfig(Descriptor config) {
        this.config = config;
    }

    public ManifestWrapper fsLayers(List<FsLayer> fsLayers) {
        this.fsLayers = fsLayers;
        return this;
    }

    public ManifestWrapper addFsLayersItem(FsLayer fsLayersItem) {
        if (this.fsLayers == null) {
            this.fsLayers = new ArrayList<>();
        }
        this.fsLayers.add(fsLayersItem);
        return this;
    }

    /**
     * (V1) List of layer information.
     * @return fsLayers
     **/
    @Valid public List<FsLayer> getFsLayers() {
        return fsLayers;
    }

    public void setFsLayers(List<FsLayer> fsLayers) {
        this.fsLayers = fsLayers;
    }

    public ManifestWrapper history(List<History> history) {
        this.history = history;
        return this;
    }

    public ManifestWrapper addHistoryItem(History historyItem) {
        if (this.history == null) {
            this.history = new ArrayList<>();
        }
        this.history.add(historyItem);
        return this;
    }

    /**
     * (V1) Image history.
     * @return history
     **/
    @Valid public List<History> getHistory() {
        return history;
    }

    public void setHistory(List<History> history) {
        this.history = history;
    }

    public ManifestWrapper layers(List<Descriptor> layers) {
        this.layers = layers;
        return this;
    }

    public ManifestWrapper addLayersItem(Descriptor layersItem) {
        if (this.layers == null) {
            this.layers = new ArrayList<>();
        }
        this.layers.add(layersItem);
        return this;
    }

    /**
     * (V2, OCI) List of V2 image layer information.
     * @return layers
     **/
    @Valid public List<Descriptor> getLayers() {
        return layers;
    }

    public void setLayers(List<Descriptor> layers) {
        this.layers = layers;
    }

    public ManifestWrapper manifests(List<ManifestListAttributes> manifests) {
        this.manifests = manifests;
        return this;
    }

    public ManifestWrapper addManifestsItem(ManifestListAttributes manifestsItem) {
        if (this.manifests == null) {
            this.manifests = new ArrayList<>();
        }
        this.manifests.add(manifestsItem);
        return this;
    }

    /**
     * (ManifestList, OCIIndex) List of V2 image layer information.
     * @return manifests
     **/
    @Valid public List<ManifestListAttributes> getManifests() {
        return manifests;
    }

    public void setManifests(List<ManifestListAttributes> manifests) {
        this.manifests = manifests;
    }

    public ManifestWrapper mediaType(String mediaType) {
        this.mediaType = mediaType;
        return this;
    }

    /**
     * Media type for this Manifest.
     * @return mediaType
     **/
    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public ManifestWrapper name(String name) {
        this.name = name;
        return this;
    }

    /**
     * (V1) Image name.
     * @return name
     **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ManifestWrapper signatures(List<ImageSignature> signatures) {
        this.signatures = signatures;
        return this;
    }

    public ManifestWrapper addSignaturesItem(ImageSignature signaturesItem) {
        if (this.signatures == null) {
            this.signatures = new ArrayList<>();
        }
        this.signatures.add(signaturesItem);
        return this;
    }

    /**
     * (V1) Image signature.
     * @return signatures
     **/
    @Valid public List<ImageSignature> getSignatures() {
        return signatures;
    }

    public void setSignatures(List<ImageSignature> signatures) {
        this.signatures = signatures;
    }

    public ManifestWrapper tag(String tag) {
        this.tag = tag;
        return this;
    }

    /**
     * (V1) Image tag.
     * @return tag
     **/
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ManifestWrapper)) {
            return false;
        }
        ManifestWrapper other = (ManifestWrapper) o;
        return Objects.equals(this.annotations, other.annotations) &&
                Objects.equals(this.architecture, other.architecture) &&
                Objects.equals(this.config, other.config) &&
                Objects.equals(this.fsLayers, other.fsLayers) &&
                Objects.equals(this.history, other.history) &&
                Objects.equals(this.layers, other.layers) &&
                Objects.equals(this.manifests, other.manifests) &&
                Objects.equals(this.mediaType, other.mediaType) &&
                Objects.equals(this.name, other.name) &&
                Objects.equals(this.signatures, other.signatures) &&
                Objects.equals(this.tag, other.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(annotations, architecture, config, fsLayers, history, layers, manifests, mediaType, name, signatures, tag);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ManifestWrapper {");
        sb.append("\n    annotations: ").append(toIndentedString(annotations));
        sb.append("\n    architecture: ").append(toIndentedString(architecture));
        sb.append("\n    config: ").append(toIndentedString(config));
        sb.append("\n    fsLayers: ").append(toIndentedString(fsLayers));
        sb.append("\n    history: ").append(toIndentedString(history));
        sb.append("\n    layers: ").append(toIndentedString(layers));
        sb.append("\n    manifests: ").append(toIndentedString(manifests));
        sb.append("\n    mediaType: ").append(toIndentedString(mediaType));
        sb.append("\n    name: ").append(toIndentedString(name));
        sb.append("\n    signatures: ").append(toIndentedString(signatures));
        sb.append("\n    tag: ").append(toIndentedString(tag));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
