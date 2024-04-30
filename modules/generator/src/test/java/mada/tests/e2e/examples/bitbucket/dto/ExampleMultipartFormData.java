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
 * ExampleMultipartFormData
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ExampleMultipartFormData {
  public static final String JSON_PROPERTY_BRANCH = "branch";
  @JsonbProperty(JSON_PROPERTY_BRANCH)
  @Schema(description = "The branch on which the <code>path</code> should be modified or created.")
  private String branch;

  public static final String JSON_PROPERTY_CONTENT = "content";
  @JsonbProperty(JSON_PROPERTY_CONTENT)
  @Schema(description = "The full content of the file at <code>path</code>.")
  private String content;

  public static final String JSON_PROPERTY_MESSAGE = "message";
  @JsonbProperty(JSON_PROPERTY_MESSAGE)
  @Schema(description = "The message associated with this change, to be used as the commit message. Or null if the default message should be used.")
  private String message;

  public static final String JSON_PROPERTY_SOURCE_BRANCH = "sourceBranch";
  @JsonbProperty(JSON_PROPERTY_SOURCE_BRANCH)
  @Schema(description = "The starting point for <code>branch</code>. If provided and different from <code>branch</code>, <code>branch</code> will be created as a new branch, branching off from <code>sourceBranch</code>.")
  private String sourceBranch;

  public static final String JSON_PROPERTY_SOURCE_COMMIT_ID = "sourceCommitId";
  @JsonbProperty(JSON_PROPERTY_SOURCE_COMMIT_ID)
  @Schema(description = "The commit ID of the file before it was edited, used to identify if content has changed. Or null if this is a new file")
  private String sourceCommitId;

  public ExampleMultipartFormData branch(String branch) {
    this.branch = branch;
    return this;
  }

  /**
   * The branch on which the <code>path</code> should be modified or created.
   *
   * @return branch
   **/
  public String getBranch() {
    return branch;
  }

  public void setBranch(String branch) {
    this.branch = branch;
  }

  public ExampleMultipartFormData content(String content) {
    this.content = content;
    return this;
  }

  /**
   * The full content of the file at <code>path</code>.
   *
   * @return content
   **/
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public ExampleMultipartFormData message(String message) {
    this.message = message;
    return this;
  }

  /**
   * The message associated with this change, to be used as the commit message. Or null if the default message should be used.
   *
   * @return message
   **/
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ExampleMultipartFormData sourceBranch(String sourceBranch) {
    this.sourceBranch = sourceBranch;
    return this;
  }

  /**
   * The starting point for <code>branch</code>. If provided and different from <code>branch</code>, <code>branch</code> will be created as a new branch, branching off from <code>sourceBranch</code>.
   *
   * @return sourceBranch
   **/
  public String getSourceBranch() {
    return sourceBranch;
  }

  public void setSourceBranch(String sourceBranch) {
    this.sourceBranch = sourceBranch;
  }

  public ExampleMultipartFormData sourceCommitId(String sourceCommitId) {
    this.sourceCommitId = sourceCommitId;
    return this;
  }

  /**
   * The commit ID of the file before it was edited, used to identify if content has changed. Or null if this is a new file
   *
   * @return sourceCommitId
   **/
  public String getSourceCommitId() {
    return sourceCommitId;
  }

  public void setSourceCommitId(String sourceCommitId) {
    this.sourceCommitId = sourceCommitId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ExampleMultipartFormData)) {
      return false;
    }
    ExampleMultipartFormData other = (ExampleMultipartFormData) o;
    return Objects.equals(this.branch, other.branch) &&
        Objects.equals(this.content, other.content) &&
        Objects.equals(this.message, other.message) &&
        Objects.equals(this.sourceBranch, other.sourceBranch) &&
        Objects.equals(this.sourceCommitId, other.sourceCommitId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(branch, content, message, sourceBranch, sourceCommitId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExampleMultipartFormData {");
    sb.append("\n    branch: ").append(toIndentedString(branch));
    sb.append("\n    content: ").append(toIndentedString(content));
    sb.append("\n    message: ").append(toIndentedString(message));
    sb.append("\n    sourceBranch: ").append(toIndentedString(sourceBranch));
    sb.append("\n    sourceCommitId: ").append(toIndentedString(sourceCommitId));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
