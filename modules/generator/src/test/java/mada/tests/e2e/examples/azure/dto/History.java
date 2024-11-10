/*
 * Azure Container Registry
 * Metadata API definition for the Azure Container Registry runtime
 *
 * The version of the OpenAPI document: 2019-08-15-preview
 */

package mada.tests.e2e.examples.azure.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * A list of unstructured historical data for v1 compatibility.
 */
@Schema(description = "A list of unstructured historical data for v1 compatibility")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class History {
    public static final String JSON_PROPERTY_V1_COMPATIBILITY = "v1Compatibility";
    @JsonbProperty(JSON_PROPERTY_V1_COMPATIBILITY)
    @Schema(description = "The raw v1 compatibility information")
    private String v1Compatibility;

    public History v1Compatibility(String v1Compatibility) {
        this.v1Compatibility = v1Compatibility;
        return this;
    }

    /**
     * The raw v1 compatibility information.
     * @return v1Compatibility
     **/
    public String getV1Compatibility() {
        return v1Compatibility;
    }

    public void setV1Compatibility(String v1Compatibility) {
        this.v1Compatibility = v1Compatibility;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof History)) {
            return false;
        }
        History other = (History) o;
        return Objects.equals(this.v1Compatibility, other.v1Compatibility);
    }

    @Override
    public int hashCode() {
        return Objects.hash(v1Compatibility);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class History {");
        sb.append("\n    v1Compatibility: ").append(toIndentedString(v1Compatibility));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
