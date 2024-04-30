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
 * Context
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class Context {
  public static final String JSON_PROPERTY_COMMIT_MESSAGE = "commitMessage";
  @JsonbProperty(JSON_PROPERTY_COMMIT_MESSAGE)
  @Schema(example = "Merging in latest from upstream.")
  private String commitMessage;

  public Context commitMessage(String commitMessage) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Context)) {
      return false;
    }
    Context other = (Context) o;
    return Objects.equals(this.commitMessage, other.commitMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(commitMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Context {");
    sb.append("\n    commitMessage: ").append(toIndentedString(commitMessage));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
