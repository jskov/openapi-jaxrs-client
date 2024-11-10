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
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestDeploymentEnvironment
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestDeploymentEnvironment {
    public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
    @JsonbProperty(JSON_PROPERTY_DISPLAY_NAME)
    @Schema(example = "US East Mirror")
    private String displayName;

    public static final String JSON_PROPERTY_KEY = "key";
    @JsonbProperty(JSON_PROPERTY_KEY)
    @Schema(example = "us-east-mirror")
    private String key;

    public static final String JSON_PROPERTY_TYPE = "type";
    @JsonbProperty(JSON_PROPERTY_TYPE)
    @Schema(example = "production")
    private String type;

    public static final String JSON_PROPERTY_URL = "url";
    @JsonbProperty(JSON_PROPERTY_URL)
    @Schema(example = "https://foo-bar.production/us-east")
    private String url;

    public RestDeploymentEnvironment displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get displayName
     *
     * @return displayName
     **/
    public @Size(min = 0, max = 255) String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public RestDeploymentEnvironment key(String key) {
        this.key = key;
        return this;
    }

    /**
     * Get key
     *
     * @return key
     **/
    public @Size(min = 0, max = 255) String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public RestDeploymentEnvironment type(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     **/
    public @Pattern(regexp = "DEVELOPMENT|TESTING|STAGING|PRODUCTION") String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public RestDeploymentEnvironment url(String url) {
        this.url = url;
        return this;
    }

    /**
     * Get url
     *
     * @return url
     **/
    public @Size(min = 0, max = 1024) String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestDeploymentEnvironment)) {
            return false;
        }
        RestDeploymentEnvironment other = (RestDeploymentEnvironment) o;
        return Objects.equals(this.displayName, other.displayName) &&
                Objects.equals(this.key, other.key) &&
                Objects.equals(this.type, other.type) &&
                Objects.equals(this.url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayName, key, type, url);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestDeploymentEnvironment {");
        sb.append("\n    displayName: ").append(toIndentedString(displayName));
        sb.append("\n    key: ").append(toIndentedString(key));
        sb.append("\n    type: ").append(toIndentedString(type));
        sb.append("\n    url: ").append(toIndentedString(url));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
