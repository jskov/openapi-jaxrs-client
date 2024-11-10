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
 * RestCommitMessageSuggestion
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestCommitMessageSuggestion {
    public static final String JSON_PROPERTY_BODY = "body";
    @JsonbProperty(JSON_PROPERTY_BODY)
    @Schema(example = "Merge in PROJECT_1/repo_1 from feature/feature-2 to main")
    private String body;

    public static final String JSON_PROPERTY_TITLE = "title";
    @JsonbProperty(JSON_PROPERTY_TITLE)
    @Schema(example = "Pull request #2: add new feature")
    private String title;

    public RestCommitMessageSuggestion body(String body) {
        this.body = body;
        return this;
    }

    /**
     * Get body
     *
     * @return body
     **/
    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public RestCommitMessageSuggestion title(String title) {
        this.title = title;
        return this;
    }

    /**
     * Get title
     *
     * @return title
     **/
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestCommitMessageSuggestion)) {
            return false;
        }
        RestCommitMessageSuggestion other = (RestCommitMessageSuggestion) o;
        return Objects.equals(this.body, other.body) &&
                Objects.equals(this.title, other.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(body, title);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestCommitMessageSuggestion {");
        sb.append("\n    body: ").append(toIndentedString(body));
        sb.append("\n    title: ").append(toIndentedString(title));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
