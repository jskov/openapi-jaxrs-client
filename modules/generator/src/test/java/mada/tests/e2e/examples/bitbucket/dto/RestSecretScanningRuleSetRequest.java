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
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestSecretScanningRuleSetRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestSecretScanningRuleSetRequest {
    public static final String JSON_PROPERTY_LINE_REGEX = "lineRegex";
    @JsonbProperty(JSON_PROPERTY_LINE_REGEX)
    @Schema(description = "Regular expression for matching a secret on a code line", example = "(BBDC-[a-zA-Z0-9+]{44})")
    private String lineRegex;

    public static final String JSON_PROPERTY_NAME = "name";
    @JsonbProperty(JSON_PROPERTY_NAME)
    @Schema(description = "Human readable name for the rule", example = "Bitbucket DC HTTP access token")
    private String name;

    public static final String JSON_PROPERTY_PATH_REGEX = "pathRegex";
    @JsonbProperty(JSON_PROPERTY_PATH_REGEX)
    @Schema(description = "Regular expression matching file names", example = "*.pem")
    private String pathRegex;

    public RestSecretScanningRuleSetRequest lineRegex(String lineRegex) {
        this.lineRegex = lineRegex;
        return this;
    }

    /**
     * Regular expression for matching a secret on a code line.
     * 
     * @return lineRegex
     **/
    public String getLineRegex() {
        return lineRegex;
    }

    public void setLineRegex(String lineRegex) {
        this.lineRegex = lineRegex;
    }

    public RestSecretScanningRuleSetRequest name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Human readable name for the rule.
     * 
     * @return name
     **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RestSecretScanningRuleSetRequest pathRegex(String pathRegex) {
        this.pathRegex = pathRegex;
        return this;
    }

    /**
     * Regular expression matching file names.
     * 
     * @return pathRegex
     **/
    public String getPathRegex() {
        return pathRegex;
    }

    public void setPathRegex(String pathRegex) {
        this.pathRegex = pathRegex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestSecretScanningRuleSetRequest)) {
            return false;
        }
        RestSecretScanningRuleSetRequest other = (RestSecretScanningRuleSetRequest) o;
        return Objects.equals(this.lineRegex, other.lineRegex) &&
                Objects.equals(this.name, other.name) &&
                Objects.equals(this.pathRegex, other.pathRegex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lineRegex, name, pathRegex);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestSecretScanningRuleSetRequest {");
        sb.append("\n    lineRegex: ").append(toIndentedString(lineRegex));
        sb.append("\n    name: ").append(toIndentedString(name));
        sb.append("\n    pathRegex: ").append(toIndentedString(pathRegex));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
