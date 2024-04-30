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
 * RestApplySuggestionRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestApplySuggestionRequest {
  public static final String JSON_PROPERTY_COMMENT_VERSION = "commentVersion";
  @JsonbProperty(JSON_PROPERTY_COMMENT_VERSION)
  @Schema(example = "0")
  private RestApplySuggestionRequestCommentVersion commentVersion;

  public static final String JSON_PROPERTY_COMMIT_MESSAGE = "commitMessage";
  @JsonbProperty(JSON_PROPERTY_COMMIT_MESSAGE)
  @Schema(example = "A commit message")
  private String commitMessage;

  public static final String JSON_PROPERTY_PULL_REQUEST_VERSION = "pullRequestVersion";
  @JsonbProperty(JSON_PROPERTY_PULL_REQUEST_VERSION)
  @Schema(example = "1")
  private RestApplySuggestionRequestPullRequestVersion pullRequestVersion;

  public static final String JSON_PROPERTY_SUGGESTION_INDEX = "suggestionIndex";
  @JsonbProperty(JSON_PROPERTY_SUGGESTION_INDEX)
  @Schema(example = "2")
  private RestApplySuggestionRequestSuggestionIndex suggestionIndex;

  public RestApplySuggestionRequest commentVersion(RestApplySuggestionRequestCommentVersion commentVersion) {
    this.commentVersion = commentVersion;
    return this;
  }

  /**
   * Get commentVersion
   * @return commentVersion
   **/
  @Valid
  public RestApplySuggestionRequestCommentVersion getCommentVersion() {
    return commentVersion;
  }

  public void setCommentVersion(RestApplySuggestionRequestCommentVersion commentVersion) {
    this.commentVersion = commentVersion;
  }

  public RestApplySuggestionRequest commitMessage(String commitMessage) {
    this.commitMessage = commitMessage;
    return this;
  }

  /**
   * Get commitMessage
   * @return commitMessage
   **/
  public String getCommitMessage() {
    return commitMessage;
  }

  public void setCommitMessage(String commitMessage) {
    this.commitMessage = commitMessage;
  }

  public RestApplySuggestionRequest pullRequestVersion(RestApplySuggestionRequestPullRequestVersion pullRequestVersion) {
    this.pullRequestVersion = pullRequestVersion;
    return this;
  }

  /**
   * Get pullRequestVersion
   * @return pullRequestVersion
   **/
  @Valid
  public RestApplySuggestionRequestPullRequestVersion getPullRequestVersion() {
    return pullRequestVersion;
  }

  public void setPullRequestVersion(RestApplySuggestionRequestPullRequestVersion pullRequestVersion) {
    this.pullRequestVersion = pullRequestVersion;
  }

  public RestApplySuggestionRequest suggestionIndex(RestApplySuggestionRequestSuggestionIndex suggestionIndex) {
    this.suggestionIndex = suggestionIndex;
    return this;
  }

  /**
   * Get suggestionIndex
   * @return suggestionIndex
   **/
  @Valid
  public RestApplySuggestionRequestSuggestionIndex getSuggestionIndex() {
    return suggestionIndex;
  }

  public void setSuggestionIndex(RestApplySuggestionRequestSuggestionIndex suggestionIndex) {
    this.suggestionIndex = suggestionIndex;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestApplySuggestionRequest)) {
      return false;
    }
    RestApplySuggestionRequest other = (RestApplySuggestionRequest) o;
    return Objects.equals(this.commentVersion, other.commentVersion) &&
        Objects.equals(this.commitMessage, other.commitMessage) &&
        Objects.equals(this.pullRequestVersion, other.pullRequestVersion) &&
        Objects.equals(this.suggestionIndex, other.suggestionIndex);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commentVersion, commitMessage, pullRequestVersion, suggestionIndex);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestApplySuggestionRequest {");
    sb.append("\n    commentVersion: ").append(toIndentedString(commentVersion));
    sb.append("\n    commitMessage: ").append(toIndentedString(commitMessage));
    sb.append("\n    pullRequestVersion: ").append(toIndentedString(pullRequestVersion));
    sb.append("\n    suggestionIndex: ").append(toIndentedString(suggestionIndex));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
