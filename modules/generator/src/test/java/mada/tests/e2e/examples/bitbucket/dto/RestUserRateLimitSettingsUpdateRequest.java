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
 * RestUserRateLimitSettingsUpdateRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestUserRateLimitSettingsUpdateRequest {
    public static final String JSON_PROPERTY_SETTINGS = "settings";
    @JsonbProperty(JSON_PROPERTY_SETTINGS)
    private RestUserRateLimitSettingsUpdateRequestSettings settings;

    public static final String JSON_PROPERTY_WHITELISTED = "whitelisted";
    @JsonbProperty(JSON_PROPERTY_WHITELISTED)
    private Boolean whitelisted;

    public RestUserRateLimitSettingsUpdateRequest settings(RestUserRateLimitSettingsUpdateRequestSettings settings) {
        this.settings = settings;
        return this;
    }

    /**
     * Get settings
     *
     * @return settings
     **/
    @Valid public RestUserRateLimitSettingsUpdateRequestSettings getSettings() {
        return settings;
    }

    public void setSettings(RestUserRateLimitSettingsUpdateRequestSettings settings) {
        this.settings = settings;
    }

    public RestUserRateLimitSettingsUpdateRequest whitelisted(Boolean whitelisted) {
        this.whitelisted = whitelisted;
        return this;
    }

    /**
     * Get whitelisted
     *
     * @return whitelisted
     **/
    public Boolean isWhitelisted() {
        return whitelisted;
    }

    public void setWhitelisted(Boolean whitelisted) {
        this.whitelisted = whitelisted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestUserRateLimitSettingsUpdateRequest)) {
            return false;
        }
        RestUserRateLimitSettingsUpdateRequest other = (RestUserRateLimitSettingsUpdateRequest) o;
        return Objects.equals(this.settings, other.settings) &&
                Objects.equals(this.whitelisted, other.whitelisted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(settings, whitelisted);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestUserRateLimitSettingsUpdateRequest {");
        sb.append("\n    settings: ").append(toIndentedString(settings));
        sb.append("\n    whitelisted: ").append(toIndentedString(whitelisted));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
