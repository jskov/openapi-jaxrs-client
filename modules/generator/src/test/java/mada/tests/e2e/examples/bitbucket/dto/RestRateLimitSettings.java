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

/**
 * RestRateLimitSettings
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestRateLimitSettings {
    public static final String JSON_PROPERTY_DEFAULT_SETTINGS = "defaultSettings";
    @JsonbProperty(JSON_PROPERTY_DEFAULT_SETTINGS)
    private RestRateLimitSettingsDefaultSettings defaultSettings;

    public static final String JSON_PROPERTY_ENABLED = "enabled";
    @JsonbProperty(JSON_PROPERTY_ENABLED)
    private Boolean enabled;

    public RestRateLimitSettings defaultSettings(RestRateLimitSettingsDefaultSettings defaultSettings) {
        this.defaultSettings = defaultSettings;
        return this;
    }

    /**
     * Get defaultSettings
     *
     * @return defaultSettings
     **/
    @Valid public RestRateLimitSettingsDefaultSettings getDefaultSettings() {
        return defaultSettings;
    }

    public void setDefaultSettings(RestRateLimitSettingsDefaultSettings defaultSettings) {
        this.defaultSettings = defaultSettings;
    }

    public RestRateLimitSettings enabled(Boolean enabled) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestRateLimitSettings)) {
            return false;
        }
        RestRateLimitSettings other = (RestRateLimitSettings) o;
        return Objects.equals(this.defaultSettings, other.defaultSettings) &&
                Objects.equals(this.enabled, other.enabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(defaultSettings, enabled);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestRateLimitSettings {");
        sb.append("\n    defaultSettings: ").append(toIndentedString(defaultSettings));
        sb.append("\n    enabled: ").append(toIndentedString(enabled));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
