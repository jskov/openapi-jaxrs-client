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
 * RestPullRequestRebaseability
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestPullRequestRebaseability {
  public static final String JSON_PROPERTY_VETOES = "vetoes";
  @JsonbProperty(JSON_PROPERTY_VETOES)
  private List<RestRepositoryHookVeto> vetoes;

  public RestPullRequestRebaseability vetoes(List<RestRepositoryHookVeto> vetoes) {
    this.vetoes = vetoes;
    return this;
  }

  public RestPullRequestRebaseability addVetoesItem(RestRepositoryHookVeto vetoesItem) {
    if (this.vetoes == null) {
      this.vetoes = new ArrayList<>();
    }
    this.vetoes.add(vetoesItem);
    return this;
  }

  /**
   * Get vetoes
   * @return vetoes
   **/
  @Valid
  public List<RestRepositoryHookVeto> getVetoes() {
    return vetoes;
  }

  public void setVetoes(List<RestRepositoryHookVeto> vetoes) {
    this.vetoes = vetoes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestPullRequestRebaseability)) {
      return false;
    }
    RestPullRequestRebaseability other = (RestPullRequestRebaseability) o;
    return Objects.equals(this.vetoes, other.vetoes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(vetoes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestPullRequestRebaseability {");
    sb.append("\n    vetoes: ").append(toIndentedString(vetoes));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
