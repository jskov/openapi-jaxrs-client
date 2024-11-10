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
 * Returns the requested OCI index file.
 */
@Schema(description = "Returns the requested OCI index file")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class OCIIndex {
    public static final String JSON_PROPERTY_ANNOTATIONS = "annotations";
    @JsonbProperty(JSON_PROPERTY_ANNOTATIONS)
    private Annotations annotations;

    public static final String JSON_PROPERTY_MANIFESTS = "manifests";
    @JsonbProperty(JSON_PROPERTY_MANIFESTS)
    @Schema(description = "List of OCI image layer information")
    private List<ManifestListAttributes> manifests;

    public OCIIndex annotations(Annotations annotations) {
        this.annotations = annotations;
        return this;
    }

    /**
     * Get annotations
     *
     * @return annotations
     **/
    @Valid
    public Annotations getAnnotations() {
        return annotations;
    }

    public void setAnnotations(Annotations annotations) {
        this.annotations = annotations;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OCIIndex)) {
            return false;
        }
        OCIIndex other = (OCIIndex) o;
        return Objects.equals(this.annotations, other.annotations) &&
                Objects.equals(this.manifests, other.manifests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(annotations, manifests);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OCIIndex {");
        sb.append("\n    annotations: ").append(toIndentedString(annotations));
        sb.append("\n    manifests: ").append(toIndentedString(manifests));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
