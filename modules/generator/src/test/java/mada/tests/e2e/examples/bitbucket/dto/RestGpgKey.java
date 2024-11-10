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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestGpgKey
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestGpgKey {
    public static final String JSON_PROPERTY_EMAIL_ADDRESS = "emailAddress";
    @JsonbProperty(JSON_PROPERTY_EMAIL_ADDRESS)
    @Schema(readOnly = true, example = "bitbucket@example.com")
    private String emailAddress;

    public static final String JSON_PROPERTY_EXPIRY_DATE = "expiryDate";
    @JsonbProperty(JSON_PROPERTY_EXPIRY_DATE)
    @Schema(readOnly = true, example = "61550496000000")
    private Long expiryDate;

    public static final String JSON_PROPERTY_FINGERPRINT = "fingerprint";
    @JsonbProperty(JSON_PROPERTY_FINGERPRINT)
    @Schema(readOnly = true, example = "43:51:43:a1:b5:fc:8b:b7:0a:3a:a9:b1:0f:66:73:a8")
    private String fingerprint;

    public static final String JSON_PROPERTY_ID = "id";
    @JsonbProperty(JSON_PROPERTY_ID)
    @Schema(readOnly = true, example = "00000000000004d2")
    private String id;

    public static final String JSON_PROPERTY_SUB_KEYS = "subKeys";
    @JsonbProperty(JSON_PROPERTY_SUB_KEYS)
    @Schema(readOnly = true, example = "[]")
    private List<RestGpgSubKey> subKeys;

    public static final String JSON_PROPERTY_TEXT = "text";
    @JsonbProperty(JSON_PROPERTY_TEXT)
    @Schema(example = "-----BEGIN PGP SIGNATURE-----\n\niQEzBAABCAAdFiEEM8MrWnoxlp3K1lFY5BMGiWNefn4FAlkqKE4ACgkQ5BMGiWNe\nfn6/kggAyzKhDDqdVb3Rq02hiSqeqKa1JuKRqDmzIpa6Pxa+1CpCnxwaIVrGgIii\nvj0ZNJzL1Bm2xm0JasotJDiZq5pFKi0FfQ0WmskuhsW1VY/f08TltHpHvK2kHVRr\nGEMVDUb0nj0I7Duc8XTipiYoDGS1GvydNR/bu3SsFTcZyapXirQcTCRT6/Sn0/IP\npUeIwQo1qK4e8gTOhWhfWEiVig39lQhiZFtm5S/vfAY72/Rgp68zMYmwasMSnBgF\n/LLFW6lXAqZIoAP8AnmsMRjCH6mS98+/lxKq2+K71+2YUUIAnNEeO09Lufo3B3Da\nPbs7BpD28w4lKlzb2EQ0n0C9rrxdPA==\n=VZpm\n-----END PGP SIGNATURE-----\n")
    private String text;

    public RestGpgKey emailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    /**
     * Get emailAddress
     *
     * @return emailAddress
     **/
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public RestGpgKey expiryDate(Long expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }

    /**
     * Get expiryDate
     *
     * @return expiryDate
     **/
    public Long getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Long expiryDate) {
        this.expiryDate = expiryDate;
    }

    public RestGpgKey fingerprint(String fingerprint) {
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

    public RestGpgKey id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RestGpgKey subKeys(List<RestGpgSubKey> subKeys) {
        this.subKeys = subKeys;
        return this;
    }

    public RestGpgKey addSubKeysItem(RestGpgSubKey subKeysItem) {
        if (this.subKeys == null) {
            this.subKeys = new ArrayList<>();
        }
        this.subKeys.add(subKeysItem);
        return this;
    }

    /**
     * Get subKeys
     *
     * @return subKeys
     **/
    @Valid public List<RestGpgSubKey> getSubKeys() {
        return subKeys;
    }

    public void setSubKeys(List<RestGpgSubKey> subKeys) {
        this.subKeys = subKeys;
    }

    public RestGpgKey text(String text) {
        this.text = text;
        return this;
    }

    /**
     * Get text
     *
     * @return text
     **/
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestGpgKey)) {
            return false;
        }
        RestGpgKey other = (RestGpgKey) o;
        return Objects.equals(this.emailAddress, other.emailAddress) &&
                Objects.equals(this.expiryDate, other.expiryDate) &&
                Objects.equals(this.fingerprint, other.fingerprint) &&
                Objects.equals(this.id, other.id) &&
                Objects.equals(this.subKeys, other.subKeys) &&
                Objects.equals(this.text, other.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailAddress, expiryDate, fingerprint, id, subKeys, text);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestGpgKey {");
        sb.append("\n    emailAddress: ").append(toIndentedString(emailAddress));
        sb.append("\n    expiryDate: ").append(toIndentedString(expiryDate));
        sb.append("\n    fingerprint: ").append(toIndentedString(fingerprint));
        sb.append("\n    id: ").append(toIndentedString(id));
        sb.append("\n    subKeys: ").append(toIndentedString(subKeys));
        sb.append("\n    text: ").append(toIndentedString(text));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
