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
 * RestAutoDeclineSettings
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestAutoDeclineSettings {
    public static final String JSON_PROPERTY_ENABLED = "enabled";
    @JsonbProperty(JSON_PROPERTY_ENABLED)
    @Schema(example = "true")
    private Boolean enabled;

    public static final String JSON_PROPERTY_INACTIVITY_WEEKS = "inactivityWeeks";
    @JsonbProperty(JSON_PROPERTY_INACTIVITY_WEEKS)
    @Schema(example = "4")
    private Integer inactivityWeeks;

    public static final String JSON_PROPERTY_SCOPE = "scope";
    @JsonbProperty(JSON_PROPERTY_SCOPE)
    private RestAutoDeclineSettingsScope scope;

    public RestAutoDeclineSettings enabled(Boolean enabled) {
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

    public RestAutoDeclineSettings inactivityWeeks(Integer inactivityWeeks) {
        this.inactivityWeeks = inactivityWeeks;
        return this;
    }

    /**
     * Get inactivityWeeks
     *
     * @return inactivityWeeks
     **/
    public Integer getInactivityWeeks() {
        return inactivityWeeks;
    }

    public void setInactivityWeeks(Integer inactivityWeeks) {
        this.inactivityWeeks = inactivityWeeks;
    }

    public RestAutoDeclineSettings scope(RestAutoDeclineSettingsScope scope) {
        this.scope = scope;
        return this;
    }

    /**
     * Get scope
     *
     * @return scope
     **/
    @Valid
    public RestAutoDeclineSettingsScope getScope() {
        return scope;
    }

    public void setScope(RestAutoDeclineSettingsScope scope) {
        this.scope = scope;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestAutoDeclineSettings)) {
            return false;
        }
        RestAutoDeclineSettings other = (RestAutoDeclineSettings) o;
        return Objects.equals(this.enabled, other.enabled) &&
                Objects.equals(this.inactivityWeeks, other.inactivityWeeks) &&
                Objects.equals(this.scope, other.scope);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enabled, inactivityWeeks, scope);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestAutoDeclineSettings {");
        sb.append("\n    enabled: ").append(toIndentedString(enabled));
        sb.append("\n    inactivityWeeks: ").append(toIndentedString(inactivityWeeks));
        sb.append("\n    scope: ").append(toIndentedString(scope));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
