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
 * RestProjectSettingsRestriction
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestProjectSettingsRestriction {
  public static final String JSON_PROPERTY_COMPONENT_KEY = "componentKey";
  @JsonbProperty(JSON_PROPERTY_COMPONENT_KEY)
  @Schema(example = "my-admin-component")
  private String componentKey;

  public static final String JSON_PROPERTY_FEATURE_KEY = "featureKey";
  @JsonbProperty(JSON_PROPERTY_FEATURE_KEY)
  @Schema(example = "my-admin-feature")
  private String featureKey;

  public static final String JSON_PROPERTY_NAMESPACE = "namespace";
  @JsonbProperty(JSON_PROPERTY_NAMESPACE)
  @Schema(example = "org.featuredeveloper")
  private String namespace;

  public enum ProcessedStateEnum {
    UNPROCESSED("UNPROCESSED"),
    PROCESSED("PROCESSED"),
    FAILED("FAILED"),
    IN_PROGRESS("IN_PROGRESS");

    private final String value;

    ProcessedStateEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static class ProcessedStateEnumAdapter implements JsonbAdapter<ProcessedStateEnum, JsonString> {
      @Override
      public JsonString adaptToJson(ProcessedStateEnum e) throws Exception {
        return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public ProcessedStateEnum adaptFromJson(JsonString value) throws Exception {
        for (ProcessedStateEnum b : ProcessedStateEnum.values()) {
          if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
            return b;
          }
        }
        throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type ProcessedStateEnum");
      }
    }
  }

  public static final String JSON_PROPERTY_PROCESSED_STATE = "processedState";
  @JsonbProperty(JSON_PROPERTY_PROCESSED_STATE)
  @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestProjectSettingsRestriction.ProcessedStateEnum.ProcessedStateEnumAdapter.class)
  @Schema(example = "PROCESSED")
  private ProcessedStateEnum processedState;

  public static final String JSON_PROPERTY_PROJECT = "project";
  @JsonbProperty(JSON_PROPERTY_PROJECT)
  private RestProjectSettingsRestrictionProject project;

  public RestProjectSettingsRestriction componentKey(String componentKey) {
    this.componentKey = componentKey;
    return this;
  }

  /**
   * Get componentKey
   * @return componentKey
   **/
  public String getComponentKey() {
    return componentKey;
  }

  public void setComponentKey(String componentKey) {
    this.componentKey = componentKey;
  }

  public RestProjectSettingsRestriction featureKey(String featureKey) {
    this.featureKey = featureKey;
    return this;
  }

  /**
   * Get featureKey
   * @return featureKey
   **/
  public String getFeatureKey() {
    return featureKey;
  }

  public void setFeatureKey(String featureKey) {
    this.featureKey = featureKey;
  }

  public RestProjectSettingsRestriction namespace(String namespace) {
    this.namespace = namespace;
    return this;
  }

  /**
   * Get namespace
   * @return namespace
   **/
  public String getNamespace() {
    return namespace;
  }

  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }

  public RestProjectSettingsRestriction processedState(ProcessedStateEnum processedState) {
    this.processedState = processedState;
    return this;
  }

  /**
   * Get processedState
   * @return processedState
   **/
  public ProcessedStateEnum getProcessedState() {
    return processedState;
  }

  public void setProcessedState(ProcessedStateEnum processedState) {
    this.processedState = processedState;
  }

  public RestProjectSettingsRestriction project(RestProjectSettingsRestrictionProject project) {
    this.project = project;
    return this;
  }

  /**
   * Get project
   * @return project
   **/
  @Valid
  public RestProjectSettingsRestrictionProject getProject() {
    return project;
  }

  public void setProject(RestProjectSettingsRestrictionProject project) {
    this.project = project;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestProjectSettingsRestriction)) {
      return false;
    }
    RestProjectSettingsRestriction other = (RestProjectSettingsRestriction) o;
    return Objects.equals(this.componentKey, other.componentKey) &&
        Objects.equals(this.featureKey, other.featureKey) &&
        Objects.equals(this.namespace, other.namespace) &&
        Objects.equals(this.processedState, other.processedState) &&
        Objects.equals(this.project, other.project);
  }

  @Override
  public int hashCode() {
    return Objects.hash(componentKey, featureKey, namespace, processedState, project);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestProjectSettingsRestriction {");
    sb.append("\n    componentKey: ").append(toIndentedString(componentKey));
    sb.append("\n    featureKey: ").append(toIndentedString(featureKey));
    sb.append("\n    namespace: ").append(toIndentedString(namespace));
    sb.append("\n    processedState: ").append(toIndentedString(processedState));
    sb.append("\n    project: ").append(toIndentedString(project));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
