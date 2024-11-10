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
 * RestCommentJiraIssue
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestCommentJiraIssue {
    public static final String JSON_PROPERTY_COMMENT_ID = "commentId";
    @JsonbProperty(JSON_PROPERTY_COMMENT_ID)
    @Schema(example = "1")
    private Long commentId;

    public static final String JSON_PROPERTY_ISSUE_KEY = "issueKey";
    @JsonbProperty(JSON_PROPERTY_ISSUE_KEY)
    @Schema(example = "TEST-123")
    private String issueKey;

    public RestCommentJiraIssue commentId(Long commentId) {
        this.commentId = commentId;
        return this;
    }

    /**
     * Get commentId
     *
     * @return commentId
     **/
    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public RestCommentJiraIssue issueKey(String issueKey) {
        this.issueKey = issueKey;
        return this;
    }

    /**
     * Get issueKey
     *
     * @return issueKey
     **/
    public String getIssueKey() {
        return issueKey;
    }

    public void setIssueKey(String issueKey) {
        this.issueKey = issueKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestCommentJiraIssue)) {
            return false;
        }
        RestCommentJiraIssue other = (RestCommentJiraIssue) o;
        return Objects.equals(this.commentId, other.commentId) &&
                Objects.equals(this.issueKey, other.issueKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, issueKey);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestCommentJiraIssue {");
        sb.append("\n    commentId: ").append(toIndentedString(commentId));
        sb.append("\n    issueKey: ").append(toIndentedString(issueKey));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
