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
 * Manifest attributes details.
 */
@Schema(description = "Manifest attributes details")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ManifestAttributes_manifest_references {
    public static final String JSON_PROPERTY_ARCHITECTURE = "architecture";
    @JsonbProperty(JSON_PROPERTY_ARCHITECTURE)
    @Schema(description = "CPU architecture")
    private String architecture;

    public static final String JSON_PROPERTY_DIGEST = "digest";
    @JsonbProperty(JSON_PROPERTY_DIGEST)
    @Schema(description = "Manifest digest")
    private String digest;

    public static final String JSON_PROPERTY_OS = "os";
    @JsonbProperty(JSON_PROPERTY_OS)
    @Schema(description = "Operating system")
    private String os;

    public ManifestAttributes_manifest_references architecture(String architecture) {
        this.architecture = architecture;
        return this;
    }

    /**
     * CPU architecture.
     * 
     * @return architecture
     **/
    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    public ManifestAttributes_manifest_references digest(String digest) {
        this.digest = digest;
        return this;
    }

    /**
     * Manifest digest.
     * 
     * @return digest
     **/
    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public ManifestAttributes_manifest_references os(String os) {
        this.os = os;
        return this;
    }

    /**
     * Operating system.
     * 
     * @return os
     **/
    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ManifestAttributes_manifest_references)) {
            return false;
        }
        ManifestAttributes_manifest_references other = (ManifestAttributes_manifest_references) o;
        return Objects.equals(this.architecture, other.architecture) &&
                Objects.equals(this.digest, other.digest) &&
                Objects.equals(this.os, other.os);
    }

    @Override
    public int hashCode() {
        return Objects.hash(architecture, digest, os);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ManifestAttributes_manifest_references {");
        sb.append("\n    architecture: ").append(toIndentedString(architecture));
        sb.append("\n    digest: ").append(toIndentedString(digest));
        sb.append("\n    os: ").append(toIndentedString(os));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
