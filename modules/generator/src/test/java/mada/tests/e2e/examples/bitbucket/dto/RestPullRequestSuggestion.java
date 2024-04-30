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
 * RestPullRequestSuggestion
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestPullRequestSuggestion {
  public static final String JSON_PROPERTY_CHANGE_TME = "changeTme";
  @JsonbProperty(JSON_PROPERTY_CHANGE_TME)
  @Schema(example = "1359075920")
  private Long changeTme;

  public static final String JSON_PROPERTY_FROM_REF = "fromRef";
  @JsonbProperty(JSON_PROPERTY_FROM_REF)
  private RestPullRequestSuggestionFromRef fromRef;

  public static final String JSON_PROPERTY_REF_CHANGE = "refChange";
  @JsonbProperty(JSON_PROPERTY_REF_CHANGE)
  private RestPullRequestSuggestionRefChange refChange;

  public static final String JSON_PROPERTY_REPOSITORY = "repository";
  @JsonbProperty(JSON_PROPERTY_REPOSITORY)
  private RestPullRequestSuggestionRepository repository;

  public static final String JSON_PROPERTY_TO_REF = "toRef";
  @JsonbProperty(JSON_PROPERTY_TO_REF)
  private RestPullRequestSuggestionToRef toRef;

  public RestPullRequestSuggestion changeTme(Long changeTme) {
    this.changeTme = changeTme;
    return this;
  }

  /**
   * Get changeTme
   * @return changeTme
   **/
  public Long getChangeTme() {
    return changeTme;
  }

  public void setChangeTme(Long changeTme) {
    this.changeTme = changeTme;
  }

  public RestPullRequestSuggestion fromRef(RestPullRequestSuggestionFromRef fromRef) {
    this.fromRef = fromRef;
    return this;
  }

  /**
   * Get fromRef
   * @return fromRef
   **/
  @Valid
  public RestPullRequestSuggestionFromRef getFromRef() {
    return fromRef;
  }

  public void setFromRef(RestPullRequestSuggestionFromRef fromRef) {
    this.fromRef = fromRef;
  }

  public RestPullRequestSuggestion refChange(RestPullRequestSuggestionRefChange refChange) {
    this.refChange = refChange;
    return this;
  }

  /**
   * Get refChange
   * @return refChange
   **/
  @Valid
  public RestPullRequestSuggestionRefChange getRefChange() {
    return refChange;
  }

  public void setRefChange(RestPullRequestSuggestionRefChange refChange) {
    this.refChange = refChange;
  }

  public RestPullRequestSuggestion repository(RestPullRequestSuggestionRepository repository) {
    this.repository = repository;
    return this;
  }

  /**
   * Get repository
   * @return repository
   **/
  @Valid
  public RestPullRequestSuggestionRepository getRepository() {
    return repository;
  }

  public void setRepository(RestPullRequestSuggestionRepository repository) {
    this.repository = repository;
  }

  public RestPullRequestSuggestion toRef(RestPullRequestSuggestionToRef toRef) {
    this.toRef = toRef;
    return this;
  }

  /**
   * Get toRef
   * @return toRef
   **/
  @Valid
  public RestPullRequestSuggestionToRef getToRef() {
    return toRef;
  }

  public void setToRef(RestPullRequestSuggestionToRef toRef) {
    this.toRef = toRef;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestPullRequestSuggestion)) {
      return false;
    }
    RestPullRequestSuggestion other = (RestPullRequestSuggestion) o;
    return Objects.equals(this.changeTme, other.changeTme) &&
        Objects.equals(this.fromRef, other.fromRef) &&
        Objects.equals(this.refChange, other.refChange) &&
        Objects.equals(this.repository, other.repository) &&
        Objects.equals(this.toRef, other.toRef);
  }

  @Override
  public int hashCode() {
    return Objects.hash(changeTme, fromRef, refChange, repository, toRef);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestPullRequestSuggestion {");
    sb.append("\n    changeTme: ").append(toIndentedString(changeTme));
    sb.append("\n    fromRef: ").append(toIndentedString(fromRef));
    sb.append("\n    refChange: ").append(toIndentedString(refChange));
    sb.append("\n    repository: ").append(toIndentedString(repository));
    sb.append("\n    toRef: ").append(toIndentedString(toRef));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
