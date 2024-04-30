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
 * RestBuildStatus
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestBuildStatus {
  public static final String JSON_PROPERTY_BUILD_NUMBER = "buildNumber";
  @JsonbProperty(JSON_PROPERTY_BUILD_NUMBER)
  @Schema(example = "3")
  private String buildNumber;

  public static final String JSON_PROPERTY_CREATED_DATE = "createdDate";
  @JsonbProperty(JSON_PROPERTY_CREATED_DATE)
  @Schema(example = "1587533099278")
  private Long createdDate;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  @JsonbProperty(JSON_PROPERTY_DESCRIPTION)
  @Schema(example = "A description of the build goes here")
  private String description;

  public static final String JSON_PROPERTY_DURATION = "duration";
  @JsonbProperty(JSON_PROPERTY_DURATION)
  private Long duration;

  public static final String JSON_PROPERTY_KEY = "key";
  @JsonbProperty(JSON_PROPERTY_KEY)
  @Schema(example = "TEST-REP3")
  private String key;

  public static final String JSON_PROPERTY_NAME = "name";
  @JsonbProperty(JSON_PROPERTY_NAME)
  @Schema(example = "Database Matrix Tests")
  private String name;

  public static final String JSON_PROPERTY_PARENT = "parent";
  @JsonbProperty(JSON_PROPERTY_PARENT)
  @Schema(example = "TEST-REP")
  private String parent;

  public static final String JSON_PROPERTY_REF = "ref";
  @JsonbProperty(JSON_PROPERTY_REF)
  @Schema(example = "refs/heads/master")
  private String ref;

  public enum StateEnum {
    CANCELLED("CANCELLED"),
    FAILED("FAILED"),
    INPROGRESS("INPROGRESS"),
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
  @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestBuildStatus.StateEnum.StateEnumAdapter.class)
  private StateEnum state;

  public static final String JSON_PROPERTY_TEST_RESULTS = "testResults";
  @JsonbProperty(JSON_PROPERTY_TEST_RESULTS)
  private RestBuildStatusTestResults testResults;

  public static final String JSON_PROPERTY_UPDATED_DATE = "updatedDate";
  @JsonbProperty(JSON_PROPERTY_UPDATED_DATE)
  @Schema(example = "1587533699278")
  private Long updatedDate;

  public static final String JSON_PROPERTY_URL = "url";
  @JsonbProperty(JSON_PROPERTY_URL)
  @Schema(example = "https://bamboo.example.com/browse/TEST-REP3")
  private String url;

  public RestBuildStatus buildNumber(String buildNumber) {
    this.buildNumber = buildNumber;
    return this;
  }

  /**
   * Get buildNumber
   * @return buildNumber
   **/
  public String getBuildNumber() {
    return buildNumber;
  }

  public void setBuildNumber(String buildNumber) {
    this.buildNumber = buildNumber;
  }

  public RestBuildStatus createdDate(Long createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  /**
   * Get createdDate
   * @return createdDate
   **/
  public Long getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Long createdDate) {
    this.createdDate = createdDate;
  }

  public RestBuildStatus description(String description) {
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

  public RestBuildStatus duration(Long duration) {
    this.duration = duration;
    return this;
  }

  /**
   * Get duration
   * @return duration
   **/
  public Long getDuration() {
    return duration;
  }

  public void setDuration(Long duration) {
    this.duration = duration;
  }

  public RestBuildStatus key(String key) {
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

  public RestBuildStatus name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public RestBuildStatus parent(String parent) {
    this.parent = parent;
    return this;
  }

  /**
   * Get parent
   * @return parent
   **/
  public String getParent() {
    return parent;
  }

  public void setParent(String parent) {
    this.parent = parent;
  }

  public RestBuildStatus ref(String ref) {
    this.ref = ref;
    return this;
  }

  /**
   * Get ref
   * @return ref
   **/
  public String getRef() {
    return ref;
  }

  public void setRef(String ref) {
    this.ref = ref;
  }

  public RestBuildStatus state(StateEnum state) {
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

  public RestBuildStatus testResults(RestBuildStatusTestResults testResults) {
    this.testResults = testResults;
    return this;
  }

  /**
   * Get testResults
   * @return testResults
   **/
  @Valid
  public RestBuildStatusTestResults getTestResults() {
    return testResults;
  }

  public void setTestResults(RestBuildStatusTestResults testResults) {
    this.testResults = testResults;
  }

  public RestBuildStatus updatedDate(Long updatedDate) {
    this.updatedDate = updatedDate;
    return this;
  }

  /**
   * Get updatedDate
   * @return updatedDate
   **/
  public Long getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(Long updatedDate) {
    this.updatedDate = updatedDate;
  }

  public RestBuildStatus url(String url) {
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
    if (!(o instanceof RestBuildStatus)) {
      return false;
    }
    RestBuildStatus other = (RestBuildStatus) o;
    return Objects.equals(this.buildNumber, other.buildNumber) &&
        Objects.equals(this.createdDate, other.createdDate) &&
        Objects.equals(this.description, other.description) &&
        Objects.equals(this.duration, other.duration) &&
        Objects.equals(this.key, other.key) &&
        Objects.equals(this.name, other.name) &&
        Objects.equals(this.parent, other.parent) &&
        Objects.equals(this.ref, other.ref) &&
        Objects.equals(this.state, other.state) &&
        Objects.equals(this.testResults, other.testResults) &&
        Objects.equals(this.updatedDate, other.updatedDate) &&
        Objects.equals(this.url, other.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(buildNumber, createdDate, description, duration, key, name, parent, ref, state, testResults, updatedDate, url);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestBuildStatus {");
    sb.append("\n    buildNumber: ").append(toIndentedString(buildNumber));
    sb.append("\n    createdDate: ").append(toIndentedString(createdDate));
    sb.append("\n    description: ").append(toIndentedString(description));
    sb.append("\n    duration: ").append(toIndentedString(duration));
    sb.append("\n    key: ").append(toIndentedString(key));
    sb.append("\n    name: ").append(toIndentedString(name));
    sb.append("\n    parent: ").append(toIndentedString(parent));
    sb.append("\n    ref: ").append(toIndentedString(ref));
    sb.append("\n    state: ").append(toIndentedString(state));
    sb.append("\n    testResults: ").append(toIndentedString(testResults));
    sb.append("\n    updatedDate: ").append(toIndentedString(updatedDate));
    sb.append("\n    url: ").append(toIndentedString(url));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
