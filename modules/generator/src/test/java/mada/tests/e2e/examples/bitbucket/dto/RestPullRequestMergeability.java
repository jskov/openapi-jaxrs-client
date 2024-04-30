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

import jakarta.json.Json;
import jakarta.json.JsonString;
import jakarta.json.bind.adapter.JsonbAdapter;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTypeAdapter;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * RestPullRequestMergeability
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestPullRequestMergeability {
  public static final String JSON_PROPERTY_CONFLICTED = "conflicted";
  @JsonbProperty(JSON_PROPERTY_CONFLICTED)
  private Boolean conflicted;

  public enum OutcomeEnum {
    CLEAN("CLEAN"),
    CONFLICTED("CONFLICTED"),
    UNKNOWN("UNKNOWN");

    private final String value;

    OutcomeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static class OutcomeEnumAdapter implements JsonbAdapter<OutcomeEnum, JsonString> {
      @Override
      public JsonString adaptToJson(OutcomeEnum e) throws Exception {
        return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public OutcomeEnum adaptFromJson(JsonString value) throws Exception {
        for (OutcomeEnum b : OutcomeEnum.values()) {
          if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
            return b;
          }
        }
        throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type OutcomeEnum");
      }
    }
  }

  public static final String JSON_PROPERTY_OUTCOME = "outcome";
  @JsonbProperty(JSON_PROPERTY_OUTCOME)
  @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestPullRequestMergeability.OutcomeEnum.OutcomeEnumAdapter.class)
  private OutcomeEnum outcome;

  public static final String JSON_PROPERTY_VETOES = "vetoes";
  @JsonbProperty(JSON_PROPERTY_VETOES)
  private List<RestRepositoryHookVeto> vetoes;

  public RestPullRequestMergeability conflicted(Boolean conflicted) {
    this.conflicted = conflicted;
    return this;
  }

  /**
   * Get conflicted
   * @return conflicted
   **/
  public Boolean isConflicted() {
    return conflicted;
  }

  public void setConflicted(Boolean conflicted) {
    this.conflicted = conflicted;
  }

  public RestPullRequestMergeability outcome(OutcomeEnum outcome) {
    this.outcome = outcome;
    return this;
  }

  /**
   * Get outcome
   * @return outcome
   **/
  public OutcomeEnum getOutcome() {
    return outcome;
  }

  public void setOutcome(OutcomeEnum outcome) {
    this.outcome = outcome;
  }

  public RestPullRequestMergeability vetoes(List<RestRepositoryHookVeto> vetoes) {
    this.vetoes = vetoes;
    return this;
  }

  public RestPullRequestMergeability addVetoesItem(RestRepositoryHookVeto vetoesItem) {
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
    if (!(o instanceof RestPullRequestMergeability)) {
      return false;
    }
    RestPullRequestMergeability other = (RestPullRequestMergeability) o;
    return Objects.equals(this.conflicted, other.conflicted) &&
        Objects.equals(this.outcome, other.outcome) &&
        Objects.equals(this.vetoes, other.vetoes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(conflicted, outcome, vetoes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestPullRequestMergeability {");
    sb.append("\n    conflicted: ").append(toIndentedString(conflicted));
    sb.append("\n    outcome: ").append(toIndentedString(outcome));
    sb.append("\n    vetoes: ").append(toIndentedString(vetoes));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
