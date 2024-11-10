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
import java.util.Objects;

/**
 * SimpleSshKeyFingerprint
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class SimpleSshKeyFingerprint {
    public static final String JSON_PROPERTY_ALGORITHM = "algorithm";
    @JsonbProperty(JSON_PROPERTY_ALGORITHM)
    private String algorithm;

    public static final String JSON_PROPERTY_VALUE = "value";
    @JsonbProperty(JSON_PROPERTY_VALUE)
    private String value;

    public SimpleSshKeyFingerprint algorithm(String algorithm) {
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

    public SimpleSshKeyFingerprint value(String value) {
        this.value = value;
        return this;
    }

    /**
     * Get value
     *
     * @return value
     **/
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SimpleSshKeyFingerprint)) {
            return false;
        }
        SimpleSshKeyFingerprint other = (SimpleSshKeyFingerprint) o;
        return Objects.equals(this.algorithm, other.algorithm) &&
                Objects.equals(this.value, other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(algorithm, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SimpleSshKeyFingerprint {");
        sb.append("\n    algorithm: ").append(toIndentedString(algorithm));
        sb.append("\n    value: ").append(toIndentedString(value));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
