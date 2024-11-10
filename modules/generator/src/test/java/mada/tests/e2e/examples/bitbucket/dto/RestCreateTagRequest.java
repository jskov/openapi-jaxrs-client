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
 * RestCreateTagRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestCreateTagRequest {
    public static final String JSON_PROPERTY_MESSAGE = "message";
    @JsonbProperty(JSON_PROPERTY_MESSAGE)
    @Schema(example = "This is my branch or tag")
    private String message;

    public static final String JSON_PROPERTY_NAME = "name";
    @JsonbProperty(JSON_PROPERTY_NAME)
    @Schema(example = "my-branch-or-tag")
    private String name;

    public static final String JSON_PROPERTY_START_POINT = "startPoint";
    @JsonbProperty(JSON_PROPERTY_START_POINT)
    @Schema(example = "8d351a10fb428c0c1239530256e21cf24f136e73")
    private String startPoint;

    public RestCreateTagRequest message(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get message
     *
     * @return message
     **/
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RestCreateTagRequest name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RestCreateTagRequest startPoint(String startPoint) {
        this.startPoint = startPoint;
        return this;
    }

    /**
     * Get startPoint
     *
     * @return startPoint
     **/
    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestCreateTagRequest)) {
            return false;
        }
        RestCreateTagRequest other = (RestCreateTagRequest) o;
        return Objects.equals(this.message, other.message) &&
                Objects.equals(this.name, other.name) &&
                Objects.equals(this.startPoint, other.startPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, name, startPoint);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestCreateTagRequest {");
        sb.append("\n    message: ").append(toIndentedString(message));
        sb.append("\n    name: ").append(toIndentedString(name));
        sb.append("\n    startPoint: ").append(toIndentedString(startPoint));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
