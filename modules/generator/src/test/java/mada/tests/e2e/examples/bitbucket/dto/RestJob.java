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
 * RestJob
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestJob {
  public static final String JSON_PROPERTY_END_DATE = "endDate";
  @JsonbProperty(JSON_PROPERTY_END_DATE)
  @Schema(example = "1497657603000")
  private Long endDate;

  public static final String JSON_PROPERTY_ID = "id";
  @JsonbProperty(JSON_PROPERTY_ID)
  @Schema(example = "1")
  private Long id;

  public static final String JSON_PROPERTY_INITIATOR = "initiator";
  @JsonbProperty(JSON_PROPERTY_INITIATOR)
  private RestJobInitiator initiator;

  public static final String JSON_PROPERTY_NODE_ID = "nodeId";
  @JsonbProperty(JSON_PROPERTY_NODE_ID)
  @Schema(example = "1bec7499-077a-4b58-b27c-996a9c2187a4")
  private String nodeId;

  public static final String JSON_PROPERTY_PROGRESS = "progress";
  @JsonbProperty(JSON_PROPERTY_PROGRESS)
  private RestJobProgress progress;

  public static final String JSON_PROPERTY_START_DATE = "startDate";
  @JsonbProperty(JSON_PROPERTY_START_DATE)
  @Schema(example = "1497657601000")
  private Long startDate;

  public enum StateEnum {
    INITIALISING("INITIALISING"),
    READY("READY"),
    RUNNING("RUNNING"),
    FINALISING("FINALISING"),
    COMPLETED("COMPLETED"),
    FAILED("FAILED"),
    CANCELING("CANCELING"),
    CANCELED("CANCELED"),
    TIMED_OUT("TIMED_OUT"),
    ABORTED("ABORTED");

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
  @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestJob.StateEnum.StateEnumAdapter.class)
  private StateEnum state;

  public static final String JSON_PROPERTY_TYPE = "type";
  @JsonbProperty(JSON_PROPERTY_TYPE)
  @Schema(example = "com.atlassian.bitbucket.migration.export")
  private String type;

  public static final String JSON_PROPERTY_UPDATED_DATE = "updatedDate";
  @JsonbProperty(JSON_PROPERTY_UPDATED_DATE)
  @Schema(example = "1497657603000")
  private Long updatedDate;

  public RestJob endDate(Long endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Get endDate
   * @return endDate
   **/
  public Long getEndDate() {
    return endDate;
  }

  public void setEndDate(Long endDate) {
    this.endDate = endDate;
  }

  public RestJob id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public RestJob initiator(RestJobInitiator initiator) {
    this.initiator = initiator;
    return this;
  }

  /**
   * Get initiator
   * @return initiator
   **/
  @Valid
  public RestJobInitiator getInitiator() {
    return initiator;
  }

  public void setInitiator(RestJobInitiator initiator) {
    this.initiator = initiator;
  }

  public RestJob nodeId(String nodeId) {
    this.nodeId = nodeId;
    return this;
  }

  /**
   * Get nodeId
   * @return nodeId
   **/
  public String getNodeId() {
    return nodeId;
  }

  public void setNodeId(String nodeId) {
    this.nodeId = nodeId;
  }

  public RestJob progress(RestJobProgress progress) {
    this.progress = progress;
    return this;
  }

  /**
   * Get progress
   * @return progress
   **/
  @Valid
  public RestJobProgress getProgress() {
    return progress;
  }

  public void setProgress(RestJobProgress progress) {
    this.progress = progress;
  }

  public RestJob startDate(Long startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Get startDate
   * @return startDate
   **/
  public Long getStartDate() {
    return startDate;
  }

  public void setStartDate(Long startDate) {
    this.startDate = startDate;
  }

  public RestJob state(StateEnum state) {
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

  public RestJob type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   **/
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public RestJob updatedDate(Long updatedDate) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestJob)) {
      return false;
    }
    RestJob other = (RestJob) o;
    return Objects.equals(this.endDate, other.endDate) &&
        Objects.equals(this.id, other.id) &&
        Objects.equals(this.initiator, other.initiator) &&
        Objects.equals(this.nodeId, other.nodeId) &&
        Objects.equals(this.progress, other.progress) &&
        Objects.equals(this.startDate, other.startDate) &&
        Objects.equals(this.state, other.state) &&
        Objects.equals(this.type, other.type) &&
        Objects.equals(this.updatedDate, other.updatedDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(endDate, id, initiator, nodeId, progress, startDate, state, type, updatedDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestJob {");
    sb.append("\n    endDate: ").append(toIndentedString(endDate));
    sb.append("\n    id: ").append(toIndentedString(id));
    sb.append("\n    initiator: ").append(toIndentedString(initiator));
    sb.append("\n    nodeId: ").append(toIndentedString(nodeId));
    sb.append("\n    progress: ").append(toIndentedString(progress));
    sb.append("\n    startDate: ").append(toIndentedString(startDate));
    sb.append("\n    state: ").append(toIndentedString(state));
    sb.append("\n    type: ").append(toIndentedString(type));
    sb.append("\n    updatedDate: ").append(toIndentedString(updatedDate));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
