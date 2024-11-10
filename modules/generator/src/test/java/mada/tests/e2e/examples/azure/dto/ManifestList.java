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
 * Returns the requested Docker multi-arch-manifest file.
 */
@Schema(description = "Returns the requested Docker multi-arch-manifest file")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ManifestList {
    public static final String JSON_PROPERTY_MANIFESTS = "manifests";
    @JsonbProperty(JSON_PROPERTY_MANIFESTS)
    @Schema(description = "List of V2 image layer information")
    private List<ManifestListAttributes> manifests;

    public static final String JSON_PROPERTY_MEDIA_TYPE = "mediaType";
    @JsonbProperty(JSON_PROPERTY_MEDIA_TYPE)
    @Schema(description = "Media type for this Manifest")
    private String mediaType;

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
     * @return manifests
     **/
    public @Valid List<ManifestListAttributes> getManifests() {
        return manifests;
    }

    public void setManifests(List<ManifestListAttributes> manifests) {
        this.manifests = manifests;
    }

    public ManifestList mediaType(String mediaType) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ManifestList)) {
            return false;
        }
        ManifestList other = (ManifestList) o;
        return Objects.equals(this.manifests, other.manifests) &&
                Objects.equals(this.mediaType, other.mediaType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manifests, mediaType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ManifestList {");
        sb.append("\n    manifests: ").append(toIndentedString(manifests));
        sb.append("\n    mediaType: ").append(toIndentedString(mediaType));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
