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

/**
 * _RequestKeysLatestSshKeyId
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class _RequestKeysLatestSshKeyId {
  public static final String JSON_PROPERTY_PROJECTS = "projects";
  @JsonbProperty(JSON_PROPERTY_PROJECTS)
  private RestProject projects;

  public static final String JSON_PROPERTY_REPOSITORIES = "repositories";
  @JsonbProperty(JSON_PROPERTY_REPOSITORIES)
  private RestRepository repositories;

  public _RequestKeysLatestSshKeyId projects(RestProject projects) {
    this.projects = projects;
    return this;
  }

  /**
   * Get projects
   * @return projects
   **/
  @Valid
  public RestProject getProjects() {
    return projects;
  }

  public void setProjects(RestProject projects) {
    this.projects = projects;
  }

  public _RequestKeysLatestSshKeyId repositories(RestRepository repositories) {
    this.repositories = repositories;
    return this;
  }

  /**
   * Get repositories
   * @return repositories
   **/
  @Valid
  public RestRepository getRepositories() {
    return repositories;
  }

  public void setRepositories(RestRepository repositories) {
    this.repositories = repositories;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof _RequestKeysLatestSshKeyId)) {
      return false;
    }
    _RequestKeysLatestSshKeyId other = (_RequestKeysLatestSshKeyId) o;
    return Objects.equals(this.projects, other.projects) &&
        Objects.equals(this.repositories, other.repositories);
  }

  @Override
  public int hashCode() {
    return Objects.hash(projects, repositories);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class _RequestKeysLatestSshKeyId {");
    sb.append("\n    projects: ").append(toIndentedString(projects));
    sb.append("\n    repositories: ").append(toIndentedString(repositories));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
