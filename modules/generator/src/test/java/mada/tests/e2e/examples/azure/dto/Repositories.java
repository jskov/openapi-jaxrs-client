/*
 * Azure Container Registry
 * Metadata API definition for the Azure Container Registry runtime
 *
 * The version of the OpenAPI document: 2019-08-15-preview
 */

package mada.tests.e2e.examples.azure.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * List of repositories
 */
@Schema(description = "List of repositories")
@JsonbPropertyOrder({
  Repositories.JSON_PROPERTY_REPOSITORIES
})
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public class Repositories {
  public static final String JSON_PROPERTY_REPOSITORIES = "repositories";
  @JsonbProperty(JSON_PROPERTY_REPOSITORIES)
  @Schema(description = "Repository names")
  private List<String> repositories = null;

  public Repositories repositories(List<String> repositories) {
    this.repositories = repositories;
    return this;
  }

  public Repositories addRepositoriesItem(String repositoriesItem) {
    if (this.repositories == null) {
      this.repositories = new ArrayList<>();
    }
    this.repositories.add(repositoriesItem);
    return this;
  }

  /**
   * Repository names.
   *
   * @return repositories
   **/
  public List<String> getRepositories() {
    return repositories;
  }

  public void setRepositories(List<String> repositories) {
    this.repositories = repositories;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Repositories other = (Repositories) o;
    return Objects.equals(this.repositories, other.repositories);
  }

  @Override
  public int hashCode() {
    return Objects.hash(repositories);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Repositories {");
    sb.append("\n    repositories: ").append(toIndentedString(repositories));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
