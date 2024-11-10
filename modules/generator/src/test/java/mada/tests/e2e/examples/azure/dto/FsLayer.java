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
 * Image layer information.
 */
@Schema(description = "Image layer information")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class FsLayer {
    public static final String JSON_PROPERTY_BLOB_SUM = "blobSum";
    @JsonbProperty(JSON_PROPERTY_BLOB_SUM)
    @Schema(description = "SHA of an image layer")
    private String blobSum;

    public FsLayer blobSum(String blobSum) {
        this.blobSum = blobSum;
        return this;
    }

    /**
     * SHA of an image layer.
     * 
     * @return blobSum
     **/
    public String getBlobSum() {
        return blobSum;
    }

    public void setBlobSum(String blobSum) {
        this.blobSum = blobSum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FsLayer)) {
            return false;
        }
        FsLayer other = (FsLayer) o;
        return Objects.equals(this.blobSum, other.blobSum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(blobSum);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FsLayer {");
        sb.append("\n    blobSum: ").append(toIndentedString(blobSum));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
