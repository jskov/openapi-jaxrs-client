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
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * RestGpgSubKey
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestGpgSubKey {
    public static final String JSON_PROPERTY_EXPIRY_DATE = "expiryDate";
    @JsonbProperty(JSON_PROPERTY_EXPIRY_DATE)
    private OffsetDateTime expiryDate;

    public static final String JSON_PROPERTY_FINGERPRINT = "fingerprint";
    @JsonbProperty(JSON_PROPERTY_FINGERPRINT)
    private String fingerprint;

    public RestGpgSubKey expiryDate(OffsetDateTime expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }

    /**
     * Get expiryDate
     *
     * @return expiryDate
     **/
    public OffsetDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(OffsetDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public RestGpgSubKey fingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
        return this;
    }

    /**
     * Get fingerprint
     *
     * @return fingerprint
     **/
    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestGpgSubKey)) {
            return false;
        }
        RestGpgSubKey other = (RestGpgSubKey) o;
        return Objects.equals(this.expiryDate, other.expiryDate) &&
                Objects.equals(this.fingerprint, other.fingerprint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(expiryDate, fingerprint);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestGpgSubKey {");
        sb.append("\n    expiryDate: ").append(toIndentedString(expiryDate));
        sb.append("\n    fingerprint: ").append(toIndentedString(fingerprint));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
