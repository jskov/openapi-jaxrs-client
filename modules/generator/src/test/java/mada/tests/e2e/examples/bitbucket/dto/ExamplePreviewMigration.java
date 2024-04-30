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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ExamplePreviewMigration
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ExamplePreviewMigration {
  public static final String JSON_PROPERTY_REPOSITORIES = "repositories";
  @JsonbProperty(JSON_PROPERTY_REPOSITORIES)
  private List<RestRepository> repositories;

  public ExamplePreviewMigration repositories(List<RestRepository> repositories) {
    this.repositories = repositories;
    return this;
  }

  public ExamplePreviewMigration addRepositoriesItem(RestRepository repositoriesItem) {
    if (this.repositories == null) {
      this.repositories = new ArrayList<>();
    }
    this.repositories.add(repositoriesItem);
    return this;
  }

  /**
   * Get repositories
   * @return repositories
   **/
  @Valid
  public List<RestRepository> getRepositories() {
    return repositories;
  }

  public void setRepositories(List<RestRepository> repositories) {
    this.repositories = repositories;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ExamplePreviewMigration)) {
      return false;
    }
    ExamplePreviewMigration other = (ExamplePreviewMigration) o;
    return Objects.equals(this.repositories, other.repositories);
  }

  @Override
  public int hashCode() {
    return Objects.hash(repositories);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExamplePreviewMigration {");
    sb.append("\n    repositories: ").append(toIndentedString(repositories));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
