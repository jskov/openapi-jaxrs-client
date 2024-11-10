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
 * RestLogLevel
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestLogLevel {
    public static final String JSON_PROPERTY_LOG_LEVEL = "logLevel";
    @JsonbProperty(JSON_PROPERTY_LOG_LEVEL)
    @Schema(example = "DEBUG")
    private String logLevel;

    public RestLogLevel logLevel(String logLevel) {
        this.logLevel = logLevel;
        return this;
    }

    /**
     * Get logLevel
     *
     * @return logLevel
     **/
    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestLogLevel)) {
            return false;
        }
        RestLogLevel other = (RestLogLevel) o;
        return Objects.equals(this.logLevel, other.logLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(logLevel);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestLogLevel {");
        sb.append("\n    logLevel: ").append(toIndentedString(logLevel));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
