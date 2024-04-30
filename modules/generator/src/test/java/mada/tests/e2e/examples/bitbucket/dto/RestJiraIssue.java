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
 * RestJiraIssue
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestJiraIssue {
  public static final String JSON_PROPERTY_KEY = "key";
  @JsonbProperty(JSON_PROPERTY_KEY)
  @Schema(example = "JRA-9")
  private String key;

  public static final String JSON_PROPERTY_URL = "url";
  @JsonbProperty(JSON_PROPERTY_URL)
  @Schema(example = "https://jira.atlassian.com/browse/JRA-9")
  private String url;

  public RestJiraIssue key(String key) {
    this.key = key;
    return this;
  }

  /**
   * Get key
   * @return key
   **/
  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public RestJiraIssue url(String url) {
    this.url = url;
    return this;
  }

  /**
   * Get url
   * @return url
   **/
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestJiraIssue)) {
      return false;
    }
    RestJiraIssue other = (RestJiraIssue) o;
    return Objects.equals(this.key, other.key) &&
        Objects.equals(this.url, other.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, url);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestJiraIssue {");
    sb.append("\n    key: ").append(toIndentedString(key));
    sb.append("\n    url: ").append(toIndentedString(url));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
