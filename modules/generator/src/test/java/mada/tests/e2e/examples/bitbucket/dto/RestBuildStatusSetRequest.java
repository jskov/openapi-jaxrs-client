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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestBuildStatusSetRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestBuildStatusSetRequest {
    public static final String JSON_PROPERTY_BUILD_NUMBER = "buildNumber";
    @JsonbProperty(JSON_PROPERTY_BUILD_NUMBER)
    @Schema(example = "3")
    private String buildNumber;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    @JsonbProperty(JSON_PROPERTY_DESCRIPTION)
    @Schema(example = "Unit test build")
    private String description;

    public static final String JSON_PROPERTY_DURATION = "duration";
    @JsonbProperty(JSON_PROPERTY_DURATION)
    @Schema(example = "1500000")
    private Long duration;

    public static final String JSON_PROPERTY_KEY = "key";
    @JsonbProperty(JSON_PROPERTY_KEY)
    @Schema(required = true, example = "TEST-REP123")
    private String key;

    public static final String JSON_PROPERTY_LAST_UPDATED = "lastUpdated";
    @JsonbProperty(JSON_PROPERTY_LAST_UPDATED)
    @Schema(example = "1359075920")
    private Long lastUpdated;

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
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestBuildStatusSetRequest.StateEnum.StateEnumAdapter.class)
    @Schema(required = true)
    private StateEnum state;

    public static final String JSON_PROPERTY_TEST_RESULTS = "testResults";
    @JsonbProperty(JSON_PROPERTY_TEST_RESULTS)
    private RestBuildStatusSetRequestTestResults testResults;

    public static final String JSON_PROPERTY_URL = "url";
    @JsonbProperty(JSON_PROPERTY_URL)
    @Schema(required = true, example = "https://bamboo.example.com/browse/TEST-REP1-3")
    private String url;

    public RestBuildStatusSetRequest buildNumber(String buildNumber) {
        this.buildNumber = buildNumber;
        return this;
    }

    /**
     * Get buildNumber
     *
     * @return buildNumber
     **/
    @Size(min = 0, max = 255) public String getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(String buildNumber) {
        this.buildNumber = buildNumber;
    }

    public RestBuildStatusSetRequest description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     **/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RestBuildStatusSetRequest duration(Long duration) {
        this.duration = duration;
        return this;
    }

    /**
     * Get duration
     *
     * @return duration
     **/
    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public RestBuildStatusSetRequest key(String key) {
        this.key = Objects.requireNonNull(key, "Property key is required, cannot be null");
        return this;
    }

    /**
     * Get key
     *
     * @return key
     **/
    @NotNull @Size(min = 0, max = 255) public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = Objects.requireNonNull(key, "Property key is required, cannot be null");
    }

    public RestBuildStatusSetRequest lastUpdated(Long lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    /**
     * Get lastUpdated
     *
     * @return lastUpdated
     **/
    public Long getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public RestBuildStatusSetRequest name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    @Size(min = 0, max = 255) public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RestBuildStatusSetRequest parent(String parent) {
        this.parent = parent;
        return this;
    }

    /**
     * Get parent
     *
     * @return parent
     **/
    @Size(min = 0, max = 1024) public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public RestBuildStatusSetRequest ref(String ref) {
        this.ref = ref;
        return this;
    }

    /**
     * Get ref
     *
     * @return ref
     **/
    @Pattern(regexp = "^refs\\/.*") @Size(min = 0, max = 1024) public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public RestBuildStatusSetRequest state(StateEnum state) {
        this.state = Objects.requireNonNull(state, "Property state is required, cannot be null");
        return this;
    }

    /**
     * Get state
     *
     * @return state
     **/
    @NotNull public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = Objects.requireNonNull(state, "Property state is required, cannot be null");
    }

    public RestBuildStatusSetRequest testResults(RestBuildStatusSetRequestTestResults testResults) {
        this.testResults = testResults;
        return this;
    }

    /**
     * Get testResults
     *
     * @return testResults
     **/
    @Valid public RestBuildStatusSetRequestTestResults getTestResults() {
        return testResults;
    }

    public void setTestResults(RestBuildStatusSetRequestTestResults testResults) {
        this.testResults = testResults;
    }

    public RestBuildStatusSetRequest url(String url) {
        this.url = Objects.requireNonNull(url, "Property url is required, cannot be null");
        return this;
    }

    /**
     * Get url
     *
     * @return url
     **/
    @NotNull @Size(min = 0, max = 450) public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = Objects.requireNonNull(url, "Property url is required, cannot be null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestBuildStatusSetRequest)) {
            return false;
        }
        RestBuildStatusSetRequest other = (RestBuildStatusSetRequest) o;
        return Objects.equals(this.buildNumber, other.buildNumber) &&
                Objects.equals(this.description, other.description) &&
                Objects.equals(this.duration, other.duration) &&
                Objects.equals(this.key, other.key) &&
                Objects.equals(this.lastUpdated, other.lastUpdated) &&
                Objects.equals(this.name, other.name) &&
                Objects.equals(this.parent, other.parent) &&
                Objects.equals(this.ref, other.ref) &&
                Objects.equals(this.state, other.state) &&
                Objects.equals(this.testResults, other.testResults) &&
                Objects.equals(this.url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buildNumber, description, duration, key, lastUpdated, name, parent, ref, state, testResults, url);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestBuildStatusSetRequest {");
        sb.append("\n    buildNumber: ").append(toIndentedString(buildNumber));
        sb.append("\n    description: ").append(toIndentedString(description));
        sb.append("\n    duration: ").append(toIndentedString(duration));
        sb.append("\n    key: ").append(toIndentedString(key));
        sb.append("\n    lastUpdated: ").append(toIndentedString(lastUpdated));
        sb.append("\n    name: ").append(toIndentedString(name));
        sb.append("\n    parent: ").append(toIndentedString(parent));
        sb.append("\n    ref: ").append(toIndentedString(ref));
        sb.append("\n    state: ").append(toIndentedString(state));
        sb.append("\n    testResults: ").append(toIndentedString(testResults));
        sb.append("\n    url: ").append(toIndentedString(url));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
