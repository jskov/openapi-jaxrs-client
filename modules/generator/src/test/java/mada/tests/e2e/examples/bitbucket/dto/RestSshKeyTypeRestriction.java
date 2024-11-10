/*
 * Bitbucket Data Center
 * This is the reference document for the Atlassian Bitbucket REST API. The REST API is for developers who want to:

 - integrate Bitbucket with other applications;

 - create scripts that interact with Bitbucket; or

 - develop plugins that enhance the Bitbucket UI, using REST to interact with the backend.

 You can read more about developing Bitbucket plugins in the [Bitbucket Developer Documentation](https://developer.atlassian.com/bitbucket/server/docs/latest/).
 *
 * The version of the OpenAPI document: 8.19
 */

package mada.tests.e2e.examples.bitbucket.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.Valid;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestSshKeyTypeRestriction
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestSshKeyTypeRestriction {
    public static final String JSON_PROPERTY_ALGORITHM = "algorithm";
    @JsonbProperty(JSON_PROPERTY_ALGORITHM)
    @Schema(example = "RSA")
    private String algorithm;

    public static final String JSON_PROPERTY_ALLOWED = "allowed";
    @JsonbProperty(JSON_PROPERTY_ALLOWED)
    @Schema(example = "true")
    private Boolean allowed;

    public static final String JSON_PROPERTY_MIN_KEY_LENGTH = "minKeyLength";
    @JsonbProperty(JSON_PROPERTY_MIN_KEY_LENGTH)
    @Schema(example = "2048")
    private RestSshKeyTypeRestrictionMinKeyLength minKeyLength;

    public RestSshKeyTypeRestriction algorithm(String algorithm) {
        this.algorithm = algorithm;
        return this;
    }

    /**
     * Get algorithm
     *
     * @return algorithm
     **/
    public String getAlgorithm() {
        return algorithm;
    }

    public void setAlgorithm(String algorithm) {
        this.algorithm = algorithm;
    }

    public RestSshKeyTypeRestriction allowed(Boolean allowed) {
        this.allowed = allowed;
        return this;
    }

    /**
     * Get allowed
     *
     * @return allowed
     **/
    public Boolean isAllowed() {
        return allowed;
    }

    public void setAllowed(Boolean allowed) {
        this.allowed = allowed;
    }

    public RestSshKeyTypeRestriction minKeyLength(RestSshKeyTypeRestrictionMinKeyLength minKeyLength) {
        this.minKeyLength = minKeyLength;
        return this;
    }

    /**
     * Get minKeyLength
     *
     * @return minKeyLength
     **/
    @Valid public RestSshKeyTypeRestrictionMinKeyLength getMinKeyLength() {
        return minKeyLength;
    }

    public void setMinKeyLength(RestSshKeyTypeRestrictionMinKeyLength minKeyLength) {
        this.minKeyLength = minKeyLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestSshKeyTypeRestriction)) {
            return false;
        }
        RestSshKeyTypeRestriction other = (RestSshKeyTypeRestriction) o;
        return Objects.equals(this.algorithm, other.algorithm) &&
                Objects.equals(this.allowed, other.allowed) &&
                Objects.equals(this.minKeyLength, other.minKeyLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(algorithm, allowed, minKeyLength);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestSshKeyTypeRestriction {");
        sb.append("\n    algorithm: ").append(toIndentedString(algorithm));
        sb.append("\n    allowed: ").append(toIndentedString(allowed));
        sb.append("\n    minKeyLength: ").append(toIndentedString(minKeyLength));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
