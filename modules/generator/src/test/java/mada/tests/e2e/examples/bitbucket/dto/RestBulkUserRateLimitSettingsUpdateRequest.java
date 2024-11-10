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
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * RestBulkUserRateLimitSettingsUpdateRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestBulkUserRateLimitSettingsUpdateRequest {
    public static final String JSON_PROPERTY_SETTINGS = "settings";
    @JsonbProperty(JSON_PROPERTY_SETTINGS)
    private RestBulkUserRateLimitSettingsUpdateRequestSettings settings;

    public static final String JSON_PROPERTY_USERNAMES = "usernames";
    @JsonbProperty(JSON_PROPERTY_USERNAMES)
    private Set<String> usernames;

    public static final String JSON_PROPERTY_WHITELISTED = "whitelisted";
    @JsonbProperty(JSON_PROPERTY_WHITELISTED)
    private Boolean whitelisted;

    public RestBulkUserRateLimitSettingsUpdateRequest settings(RestBulkUserRateLimitSettingsUpdateRequestSettings settings) {
        this.settings = settings;
        return this;
    }

    /**
     * Get settings
     *
     * @return settings
     **/
    @Valid public RestBulkUserRateLimitSettingsUpdateRequestSettings getSettings() {
        return settings;
    }

    public void setSettings(RestBulkUserRateLimitSettingsUpdateRequestSettings settings) {
        this.settings = settings;
    }

    public RestBulkUserRateLimitSettingsUpdateRequest usernames(Set<String> usernames) {
        this.usernames = usernames;
        return this;
    }

    public RestBulkUserRateLimitSettingsUpdateRequest addUsernamesItem(String usernamesItem) {
        if (this.usernames == null) {
            this.usernames = new LinkedHashSet<>();
        }
        this.usernames.add(usernamesItem);
        return this;
    }

    /**
     * Get usernames
     *
     * @return usernames
     **/
    public Set<String> getUsernames() {
        return usernames;
    }

    public void setUsernames(Set<String> usernames) {
        this.usernames = usernames;
    }

    public RestBulkUserRateLimitSettingsUpdateRequest whitelisted(Boolean whitelisted) {
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
        if (!(o instanceof RestBulkUserRateLimitSettingsUpdateRequest)) {
            return false;
        }
        RestBulkUserRateLimitSettingsUpdateRequest other = (RestBulkUserRateLimitSettingsUpdateRequest) o;
        return Objects.equals(this.settings, other.settings) &&
                Objects.equals(this.usernames, other.usernames) &&
                Objects.equals(this.whitelisted, other.whitelisted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(settings, usernames, whitelisted);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestBulkUserRateLimitSettingsUpdateRequest {");
        sb.append("\n    settings: ").append(toIndentedString(settings));
        sb.append("\n    usernames: ").append(toIndentedString(usernames));
        sb.append("\n    whitelisted: ").append(toIndentedString(whitelisted));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
