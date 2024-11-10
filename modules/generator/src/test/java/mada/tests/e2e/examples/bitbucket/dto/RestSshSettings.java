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
 * RestSshSettings
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestSshSettings {
    public static final String JSON_PROPERTY_ACCESS_KEYS_ENABLED = "accessKeysEnabled";
    @JsonbProperty(JSON_PROPERTY_ACCESS_KEYS_ENABLED)
    private Boolean accessKeysEnabled;

    public static final String JSON_PROPERTY_BASE_URL = "baseUrl";
    @JsonbProperty(JSON_PROPERTY_BASE_URL)
    @Schema(example = "ssh://example.com")
    private String baseUrl;

    public static final String JSON_PROPERTY_ENABLED = "enabled";
    @JsonbProperty(JSON_PROPERTY_ENABLED)
    @Schema(example = "true")
    private Boolean enabled;

    public static final String JSON_PROPERTY_FINGERPRINT = "fingerprint";
    @JsonbProperty(JSON_PROPERTY_FINGERPRINT)
    private SimpleSshKeyFingerprint fingerprint;

    public static final String JSON_PROPERTY_PORT = "port";
    @JsonbProperty(JSON_PROPERTY_PORT)
    @Schema(example = "7999")
    private Integer port;

    public RestSshSettings accessKeysEnabled(Boolean accessKeysEnabled) {
        this.accessKeysEnabled = accessKeysEnabled;
        return this;
    }

    /**
     * Get accessKeysEnabled
     *
     * @return accessKeysEnabled
     **/
    public Boolean isAccessKeysEnabled() {
        return accessKeysEnabled;
    }

    public void setAccessKeysEnabled(Boolean accessKeysEnabled) {
        this.accessKeysEnabled = accessKeysEnabled;
    }

    public RestSshSettings baseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    /**
     * Get baseUrl
     *
     * @return baseUrl
     **/
    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public RestSshSettings enabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Get enabled
     *
     * @return enabled
     **/
    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public RestSshSettings fingerprint(SimpleSshKeyFingerprint fingerprint) {
        this.fingerprint = fingerprint;
        return this;
    }

    /**
     * Get fingerprint
     *
     * @return fingerprint
     **/
    @Valid
    public SimpleSshKeyFingerprint getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(SimpleSshKeyFingerprint fingerprint) {
        this.fingerprint = fingerprint;
    }

    public RestSshSettings port(Integer port) {
        this.port = port;
        return this;
    }

    /**
     * Get port
     *
     * @return port
     **/
    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestSshSettings)) {
            return false;
        }
        RestSshSettings other = (RestSshSettings) o;
        return Objects.equals(this.accessKeysEnabled, other.accessKeysEnabled) &&
                Objects.equals(this.baseUrl, other.baseUrl) &&
                Objects.equals(this.enabled, other.enabled) &&
                Objects.equals(this.fingerprint, other.fingerprint) &&
                Objects.equals(this.port, other.port);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessKeysEnabled, baseUrl, enabled, fingerprint, port);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestSshSettings {");
        sb.append("\n    accessKeysEnabled: ").append(toIndentedString(accessKeysEnabled));
        sb.append("\n    baseUrl: ").append(toIndentedString(baseUrl));
        sb.append("\n    enabled: ").append(toIndentedString(enabled));
        sb.append("\n    fingerprint: ").append(toIndentedString(fingerprint));
        sb.append("\n    port: ").append(toIndentedString(port));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
