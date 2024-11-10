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
 * RestPullRequestConditionTargetRefMatcher
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestPullRequestConditionTargetRefMatcher {
    public static final String JSON_PROPERTY_DISPLAY_ID = "displayId";
    @JsonbProperty(JSON_PROPERTY_DISPLAY_ID)
    @Schema(example = "main")
    private String displayId;

    public static final String JSON_PROPERTY_ID = "id";
    @JsonbProperty(JSON_PROPERTY_ID)
    @Schema(example = "refs/heads/main")
    private String id;

    public static final String JSON_PROPERTY_TYPE = "type";
    @JsonbProperty(JSON_PROPERTY_TYPE)
    private RestPullRequestConditionTargetRefMatcherType type;

    public RestPullRequestConditionTargetRefMatcher displayId(String displayId) {
        this.displayId = displayId;
        return this;
    }

    /**
     * Get displayId
     *
     * @return displayId
     **/
    public String getDisplayId() {
        return displayId;
    }

    public void setDisplayId(String displayId) {
        this.displayId = displayId;
    }

    public RestPullRequestConditionTargetRefMatcher id(String id) {
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

    public RestPullRequestConditionTargetRefMatcher type(RestPullRequestConditionTargetRefMatcherType type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     **/
    @Valid public RestPullRequestConditionTargetRefMatcherType getType() {
        return type;
    }

    public void setType(RestPullRequestConditionTargetRefMatcherType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestPullRequestConditionTargetRefMatcher)) {
            return false;
        }
        RestPullRequestConditionTargetRefMatcher other = (RestPullRequestConditionTargetRefMatcher) o;
        return Objects.equals(this.displayId, other.displayId) &&
                Objects.equals(this.id, other.id) &&
                Objects.equals(this.type, other.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayId, id, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestPullRequestConditionTargetRefMatcher {");
        sb.append("\n    displayId: ").append(toIndentedString(displayId));
        sb.append("\n    id: ").append(toIndentedString(id));
        sb.append("\n    type: ").append(toIndentedString(type));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
