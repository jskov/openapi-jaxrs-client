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
 * Returns the requested V1 manifest file.
 */
@Schema(description = "Returns the requested V1 manifest file")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class V1Manifest {
    public static final String JSON_PROPERTY_ARCHITECTURE = "architecture";
    @JsonbProperty(JSON_PROPERTY_ARCHITECTURE)
    @Schema(description = "CPU architecture")
    private String architecture;

    public static final String JSON_PROPERTY_FS_LAYERS = "fsLayers";
    @JsonbProperty(JSON_PROPERTY_FS_LAYERS)
    @Schema(description = "List of layer information")
    private List<FsLayer> fsLayers;

    public static final String JSON_PROPERTY_HISTORY = "history";
    @JsonbProperty(JSON_PROPERTY_HISTORY)
    @Schema(description = "Image history")
    private List<History> history;

    public static final String JSON_PROPERTY_NAME = "name";
    @JsonbProperty(JSON_PROPERTY_NAME)
    @Schema(description = "Image name")
    private String name;

    public static final String JSON_PROPERTY_SIGNATURES = "signatures";
    @JsonbProperty(JSON_PROPERTY_SIGNATURES)
    @Schema(description = "Image signature")
    private List<ImageSignature> signatures;

    public static final String JSON_PROPERTY_TAG = "tag";
    @JsonbProperty(JSON_PROPERTY_TAG)
    @Schema(description = "Image tag")
    private String tag;

    public V1Manifest architecture(String architecture) {
        this.architecture = architecture;
        return this;
    }

    /**
     * CPU architecture.
     * @return architecture
     **/
    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    public V1Manifest fsLayers(List<FsLayer> fsLayers) {
        this.fsLayers = fsLayers;
        return this;
    }

    public V1Manifest addFsLayersItem(FsLayer fsLayersItem) {
        if (this.fsLayers == null) {
            this.fsLayers = new ArrayList<>();
        }
        this.fsLayers.add(fsLayersItem);
        return this;
    }

    /**
     * List of layer information.
     * @return fsLayers
     **/
    @Valid public List<FsLayer> getFsLayers() {
        return fsLayers;
    }

    public void setFsLayers(List<FsLayer> fsLayers) {
        this.fsLayers = fsLayers;
    }

    public V1Manifest history(List<History> history) {
        this.history = history;
        return this;
    }

    public V1Manifest addHistoryItem(History historyItem) {
        if (this.history == null) {
            this.history = new ArrayList<>();
        }
        this.history.add(historyItem);
        return this;
    }

    /**
     * Image history.
     * @return history
     **/
    @Valid public List<History> getHistory() {
        return history;
    }

    public void setHistory(List<History> history) {
        this.history = history;
    }

    public V1Manifest name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Image name.
     * @return name
     **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public V1Manifest signatures(List<ImageSignature> signatures) {
        this.signatures = signatures;
        return this;
    }

    public V1Manifest addSignaturesItem(ImageSignature signaturesItem) {
        if (this.signatures == null) {
            this.signatures = new ArrayList<>();
        }
        this.signatures.add(signaturesItem);
        return this;
    }

    /**
     * Image signature.
     * @return signatures
     **/
    @Valid public List<ImageSignature> getSignatures() {
        return signatures;
    }

    public void setSignatures(List<ImageSignature> signatures) {
        this.signatures = signatures;
    }

    public V1Manifest tag(String tag) {
        this.tag = tag;
        return this;
    }

    /**
     * Image tag.
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
        if (!(o instanceof V1Manifest)) {
            return false;
        }
        V1Manifest other = (V1Manifest) o;
        return Objects.equals(this.architecture, other.architecture) &&
                Objects.equals(this.fsLayers, other.fsLayers) &&
                Objects.equals(this.history, other.history) &&
                Objects.equals(this.name, other.name) &&
                Objects.equals(this.signatures, other.signatures) &&
                Objects.equals(this.tag, other.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(architecture, fsLayers, history, name, signatures, tag);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class V1Manifest {");
        sb.append("\n    architecture: ").append(toIndentedString(architecture));
        sb.append("\n    fsLayers: ").append(toIndentedString(fsLayers));
        sb.append("\n    history: ").append(toIndentedString(history));
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
