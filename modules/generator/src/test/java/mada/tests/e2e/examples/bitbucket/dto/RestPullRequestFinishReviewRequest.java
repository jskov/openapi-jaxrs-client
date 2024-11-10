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
 * RestPullRequestFinishReviewRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestPullRequestFinishReviewRequest {
    public static final String JSON_PROPERTY_COMMENT_TEXT = "commentText";
    @JsonbProperty(JSON_PROPERTY_COMMENT_TEXT)
    @Schema(example = "General comment text")
    private String commentText;

    public static final String JSON_PROPERTY_PARTICIPANT_STATUS = "participantStatus";
    @JsonbProperty(JSON_PROPERTY_PARTICIPANT_STATUS)
    @Schema(example = "approved")
    private String participantStatus;

    public RestPullRequestFinishReviewRequest commentText(String commentText) {
        this.commentText = commentText;
        return this;
    }

    /**
     * Get commentText
     *
     * @return commentText
     **/
    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public RestPullRequestFinishReviewRequest participantStatus(String participantStatus) {
        this.participantStatus = participantStatus;
        return this;
    }

    /**
     * Get participantStatus
     *
     * @return participantStatus
     **/
    public String getParticipantStatus() {
        return participantStatus;
    }

    public void setParticipantStatus(String participantStatus) {
        this.participantStatus = participantStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestPullRequestFinishReviewRequest)) {
            return false;
        }
        RestPullRequestFinishReviewRequest other = (RestPullRequestFinishReviewRequest) o;
        return Objects.equals(this.commentText, other.commentText) &&
                Objects.equals(this.participantStatus, other.participantStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentText, participantStatus);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestPullRequestFinishReviewRequest {");
        sb.append("\n    commentText: ").append(toIndentedString(commentText));
        sb.append("\n    participantStatus: ").append(toIndentedString(participantStatus));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
