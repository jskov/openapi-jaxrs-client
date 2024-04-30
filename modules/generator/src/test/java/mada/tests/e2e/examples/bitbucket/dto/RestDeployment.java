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
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestDeployment
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestDeployment {
  public static final String JSON_PROPERTY_DEPLOYMENT_SEQUENCE_NUMBER = "deploymentSequenceNumber";
  @JsonbProperty(JSON_PROPERTY_DEPLOYMENT_SEQUENCE_NUMBER)
  @Schema(example = "5")
  private Long deploymentSequenceNumber;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  @JsonbProperty(JSON_PROPERTY_DESCRIPTION)
  @Schema(example = "Production and mirror environments")
  private String description;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
  @JsonbProperty(JSON_PROPERTY_DISPLAY_NAME)
  @Schema(example = "US East Mirror")
  private String displayName;

  public static final String JSON_PROPERTY_ENVIRONMENT = "environment";
  @JsonbProperty(JSON_PROPERTY_ENVIRONMENT)
  private RestDeploymentEnvironment environment;

  public static final String JSON_PROPERTY_FROM_COMMIT = "fromCommit";
  @JsonbProperty(JSON_PROPERTY_FROM_COMMIT)
  private RestDeploymentFromCommit fromCommit;

  public static final String JSON_PROPERTY_KEY = "key";
  @JsonbProperty(JSON_PROPERTY_KEY)
  @Schema(example = "PROD-MIR")
  private String key;

  public static final String JSON_PROPERTY_LAST_UPDATED = "lastUpdated";
  @JsonbProperty(JSON_PROPERTY_LAST_UPDATED)
  @Schema(example = "1449075920")
  private Long lastUpdated;

  public static final String JSON_PROPERTY_REPOSITORY = "repository";
  @JsonbProperty(JSON_PROPERTY_REPOSITORY)
  private RestDeploymentRepository repository;

  public enum StateEnum {
    PENDING("PENDING"),
    IN_PROGRESS("IN_PROGRESS"),
    CANCELLED("CANCELLED"),
    FAILED("FAILED"),
    ROLLED_BACK("ROLLED_BACK"),
    SUCCESSFUL("SUCCESSFUL"),
    UNKNOWN("UNKNOWN");

    private final String value;

    StateEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static class StateEnumAdapter implements JsonbAdapter<StateEnum, JsonString> {
      @Override
      public JsonString adaptToJson(StateEnum e) throws Exception {
        return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public StateEnum adaptFromJson(JsonString value) throws Exception {
        for (StateEnum b : StateEnum.values()) {
          if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
            return b;
          }
        }
        throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type StateEnum");
      }
    }
  }

  public static final String JSON_PROPERTY_STATE = "state";
  @JsonbProperty(JSON_PROPERTY_STATE)
  @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestDeployment.StateEnum.StateEnumAdapter.class)
  private StateEnum state;

  public static final String JSON_PROPERTY_TO_COMMIT = "toCommit";
  @JsonbProperty(JSON_PROPERTY_TO_COMMIT)
  private RestDeploymentToCommit toCommit;

  public static final String JSON_PROPERTY_URL = "url";
  @JsonbProperty(JSON_PROPERTY_URL)
  @Schema(example = "http://example.ci.org/projects/PROJ/deploy/mirror-deploy/100")
  private String url;

  public RestDeployment deploymentSequenceNumber(Long deploymentSequenceNumber) {
    this.deploymentSequenceNumber = deploymentSequenceNumber;
    return this;
  }

  /**
   * Get deploymentSequenceNumber
   * @return deploymentSequenceNumber
   **/
  public Long getDeploymentSequenceNumber() {
    return deploymentSequenceNumber;
  }

  public void setDeploymentSequenceNumber(Long deploymentSequenceNumber) {
    this.deploymentSequenceNumber = deploymentSequenceNumber;
  }

  public RestDeployment description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   **/
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public RestDeployment displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

  /**
   * Get displayName
   * @return displayName
   **/
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public RestDeployment environment(RestDeploymentEnvironment environment) {
    this.environment = environment;
    return this;
  }

  /**
   * Get environment
   * @return environment
   **/
  @Valid
  public RestDeploymentEnvironment getEnvironment() {
    return environment;
  }

  public void setEnvironment(RestDeploymentEnvironment environment) {
    this.environment = environment;
  }

  public RestDeployment fromCommit(RestDeploymentFromCommit fromCommit) {
    this.fromCommit = fromCommit;
    return this;
  }

  /**
   * Get fromCommit
   * @return fromCommit
   **/
  @Valid
  public RestDeploymentFromCommit getFromCommit() {
    return fromCommit;
  }

  public void setFromCommit(RestDeploymentFromCommit fromCommit) {
    this.fromCommit = fromCommit;
  }

  public RestDeployment key(String key) {
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

  public RestDeployment lastUpdated(Long lastUpdated) {
    this.lastUpdated = lastUpdated;
    return this;
  }

  /**
   * Get lastUpdated
   * @return lastUpdated
   **/
  public Long getLastUpdated() {
    return lastUpdated;
  }

  public void setLastUpdated(Long lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public RestDeployment repository(RestDeploymentRepository repository) {
    this.repository = repository;
    return this;
  }

  /**
   * Get repository
   * @return repository
   **/
  @Valid
  public RestDeploymentRepository getRepository() {
    return repository;
  }

  public void setRepository(RestDeploymentRepository repository) {
    this.repository = repository;
  }

  public RestDeployment state(StateEnum state) {
    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
   **/
  public StateEnum getState() {
    return state;
  }

  public void setState(StateEnum state) {
    this.state = state;
  }

  public RestDeployment toCommit(RestDeploymentToCommit toCommit) {
    this.toCommit = toCommit;
    return this;
  }

  /**
   * Get toCommit
   * @return toCommit
   **/
  @Valid
  public RestDeploymentToCommit getToCommit() {
    return toCommit;
  }

  public void setToCommit(RestDeploymentToCommit toCommit) {
    this.toCommit = toCommit;
  }

  public RestDeployment url(String url) {
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
    if (!(o instanceof RestDeployment)) {
      return false;
    }
    RestDeployment other = (RestDeployment) o;
    return Objects.equals(this.deploymentSequenceNumber, other.deploymentSequenceNumber) &&
        Objects.equals(this.description, other.description) &&
        Objects.equals(this.displayName, other.displayName) &&
        Objects.equals(this.environment, other.environment) &&
        Objects.equals(this.fromCommit, other.fromCommit) &&
        Objects.equals(this.key, other.key) &&
        Objects.equals(this.lastUpdated, other.lastUpdated) &&
        Objects.equals(this.repository, other.repository) &&
        Objects.equals(this.state, other.state) &&
        Objects.equals(this.toCommit, other.toCommit) &&
        Objects.equals(this.url, other.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deploymentSequenceNumber, description, displayName, environment, fromCommit, key, lastUpdated, repository, state, toCommit, url);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestDeployment {");
    sb.append("\n    deploymentSequenceNumber: ").append(toIndentedString(deploymentSequenceNumber));
    sb.append("\n    description: ").append(toIndentedString(description));
    sb.append("\n    displayName: ").append(toIndentedString(displayName));
    sb.append("\n    environment: ").append(toIndentedString(environment));
    sb.append("\n    fromCommit: ").append(toIndentedString(fromCommit));
    sb.append("\n    key: ").append(toIndentedString(key));
    sb.append("\n    lastUpdated: ").append(toIndentedString(lastUpdated));
    sb.append("\n    repository: ").append(toIndentedString(repository));
    sb.append("\n    state: ").append(toIndentedString(state));
    sb.append("\n    toCommit: ").append(toIndentedString(toCommit));
    sb.append("\n    url: ").append(toIndentedString(url));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
