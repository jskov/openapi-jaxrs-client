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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestDeploymentSetRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestDeploymentSetRequest {
    public static final String JSON_PROPERTY_DEPLOYMENT_SEQUENCE_NUMBER = "deploymentSequenceNumber";
    @JsonbProperty(JSON_PROPERTY_DEPLOYMENT_SEQUENCE_NUMBER)
    @Schema(required = true, example = "2")
    private Long deploymentSequenceNumber;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    @JsonbProperty(JSON_PROPERTY_DESCRIPTION)
    @Schema(required = true, example = "2nd deployment of commit 44bca31f4be to US East production")
    private String description;

    public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
    @JsonbProperty(JSON_PROPERTY_DISPLAY_NAME)
    @Schema(required = true, example = "US East marketing website production")
    private String displayName;

    public static final String JSON_PROPERTY_ENVIRONMENT = "environment";
    @JsonbProperty(JSON_PROPERTY_ENVIRONMENT)
    @Schema(required = true)
    private RestDeploymentEnvironment environment;

    public static final String JSON_PROPERTY_KEY = "key";
    @JsonbProperty(JSON_PROPERTY_KEY)
    @Schema(required = true, example = "marketing-us-prod")
    private String key;

    public static final String JSON_PROPERTY_LAST_UPDATED = "lastUpdated";
    @JsonbProperty(JSON_PROPERTY_LAST_UPDATED)
    @Schema(example = "1359075920")
    private Long lastUpdated;

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
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestDeploymentSetRequest.StateEnum.StateEnumAdapter.class)
    @Schema(required = true, example = "SUCCESSFUL")
    private StateEnum state;

    public static final String JSON_PROPERTY_URL = "url";
    @JsonbProperty(JSON_PROPERTY_URL)
    @Schema(required = true, example = "https://my-dep-tool/marketing-us-prod/2")
    private String url;

    public RestDeploymentSetRequest deploymentSequenceNumber(Long deploymentSequenceNumber) {
        this.deploymentSequenceNumber = Objects.requireNonNull(deploymentSequenceNumber, "Property deploymentSequenceNumber is required, cannot be null");
        return this;
    }

    /**
     * Get deploymentSequenceNumber
     *
     * @return deploymentSequenceNumber
     **/
    public @NotNull Long getDeploymentSequenceNumber() {
        return deploymentSequenceNumber;
    }

    public void setDeploymentSequenceNumber(Long deploymentSequenceNumber) {
        this.deploymentSequenceNumber = Objects.requireNonNull(deploymentSequenceNumber, "Property deploymentSequenceNumber is required, cannot be null");
    }

    public RestDeploymentSetRequest description(String description) {
        this.description = Objects.requireNonNull(description, "Property description is required, cannot be null");
        return this;
    }

    /**
     * Get description
     *
     * @return description
     **/
    public @NotNull @Size(min = 0, max = 255) String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = Objects.requireNonNull(description, "Property description is required, cannot be null");
    }

    public RestDeploymentSetRequest displayName(String displayName) {
        this.displayName = Objects.requireNonNull(displayName, "Property displayName is required, cannot be null");
        return this;
    }

    /**
     * Get displayName
     *
     * @return displayName
     **/
    public @NotNull @Size(min = 0, max = 255) String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = Objects.requireNonNull(displayName, "Property displayName is required, cannot be null");
    }

    public RestDeploymentSetRequest environment(RestDeploymentEnvironment environment) {
        this.environment = Objects.requireNonNull(environment, "Property environment is required, cannot be null");
        return this;
    }

    /**
     * Get environment
     *
     * @return environment
     **/
    public @NotNull @Valid RestDeploymentEnvironment getEnvironment() {
        return environment;
    }

    public void setEnvironment(RestDeploymentEnvironment environment) {
        this.environment = Objects.requireNonNull(environment, "Property environment is required, cannot be null");
    }

    public RestDeploymentSetRequest key(String key) {
        this.key = Objects.requireNonNull(key, "Property key is required, cannot be null");
        return this;
    }

    /**
     * Get key
     *
     * @return key
     **/
    public @NotNull @Size(min = 0, max = 255) String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = Objects.requireNonNull(key, "Property key is required, cannot be null");
    }

    public RestDeploymentSetRequest lastUpdated(Long lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    /**
     * Get lastUpdated
     * minimum: 0L
     *
     * @return lastUpdated
     **/
    public @Min(0L) Long getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Long lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public RestDeploymentSetRequest state(StateEnum state) {
        this.state = Objects.requireNonNull(state, "Property state is required, cannot be null");
        return this;
    }

    /**
     * Get state
     *
     * @return state
     **/
    public @NotNull StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = Objects.requireNonNull(state, "Property state is required, cannot be null");
    }

    public RestDeploymentSetRequest url(String url) {
        this.url = Objects.requireNonNull(url, "Property url is required, cannot be null");
        return this;
    }

    /**
     * Get url
     *
     * @return url
     **/
    public @NotNull @Size(min = 0, max = 1024) String getUrl() {
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
        if (!(o instanceof RestDeploymentSetRequest)) {
            return false;
        }
        RestDeploymentSetRequest other = (RestDeploymentSetRequest) o;
        return Objects.equals(this.deploymentSequenceNumber, other.deploymentSequenceNumber) &&
                Objects.equals(this.description, other.description) &&
                Objects.equals(this.displayName, other.displayName) &&
                Objects.equals(this.environment, other.environment) &&
                Objects.equals(this.key, other.key) &&
                Objects.equals(this.lastUpdated, other.lastUpdated) &&
                Objects.equals(this.state, other.state) &&
                Objects.equals(this.url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deploymentSequenceNumber, description, displayName, environment, key, lastUpdated, state, url);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestDeploymentSetRequest {");
        sb.append("\n    deploymentSequenceNumber: ").append(toIndentedString(deploymentSequenceNumber));
        sb.append("\n    description: ").append(toIndentedString(description));
        sb.append("\n    displayName: ").append(toIndentedString(displayName));
        sb.append("\n    environment: ").append(toIndentedString(environment));
        sb.append("\n    key: ").append(toIndentedString(key));
        sb.append("\n    lastUpdated: ").append(toIndentedString(lastUpdated));
        sb.append("\n    state: ").append(toIndentedString(state));
        sb.append("\n    url: ").append(toIndentedString(url));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
