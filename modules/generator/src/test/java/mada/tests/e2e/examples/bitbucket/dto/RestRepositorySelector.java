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
 * RestRepositorySelector
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestRepositorySelector {
  public static final String JSON_PROPERTY_PROJECT_KEY = "projectKey";
  @JsonbProperty(JSON_PROPERTY_PROJECT_KEY)
  @Schema(example = "PRJ")
  private String projectKey;

  public static final String JSON_PROPERTY_SLUG = "slug";
  @JsonbProperty(JSON_PROPERTY_SLUG)
  @Schema(example = "my-repo")
  private String slug;

  public RestRepositorySelector projectKey(String projectKey) {
    this.projectKey = projectKey;
    return this;
  }

  /**
   * Get projectKey
   * @return projectKey
   **/
  public String getProjectKey() {
    return projectKey;
  }

  public void setProjectKey(String projectKey) {
    this.projectKey = projectKey;
  }

  public RestRepositorySelector slug(String slug) {
    this.slug = slug;
    return this;
  }

  /**
   * Get slug
   * @return slug
   **/
  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestRepositorySelector)) {
      return false;
    }
    RestRepositorySelector other = (RestRepositorySelector) o;
    return Objects.equals(this.projectKey, other.projectKey) &&
        Objects.equals(this.slug, other.slug);
  }

  @Override
  public int hashCode() {
    return Objects.hash(projectKey, slug);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestRepositorySelector {");
    sb.append("\n    projectKey: ").append(toIndentedString(projectKey));
    sb.append("\n    slug: ").append(toIndentedString(slug));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
