/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.dto.oneof.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * A task that will exist if the room has the Statement of Truth extension and Statement of Truth exists on the room. Will be completed when a contact has signed Statement of Truth.The assignee will always be CUSTOMER, deadlineDate is set to the deadlineDate of the Statement of Truth. The functionality is STATEMENT_OF_TRUTH.
 */
@JsonPropertyOrder({
  SignStatementOfTruthTask.JSON_PROPERTY_TYPE,
  SignStatementOfTruthTask.JSON_PROPERTY_ASSIGNEE,
  SignStatementOfTruthTask.JSON_PROPERTY_COMPLETED,
  SignStatementOfTruthTask.JSON_PROPERTY_DEADLINE_DATE,
  SignStatementOfTruthTask.JSON_PROPERTY_FUNCTIONALITY,
  SignStatementOfTruthTask.JSON_PROPERTY_ROOM_ID,
  SignStatementOfTruthTask.JSON_PROPERTY_TASK_ID
})
@Schema(description = "A task that will exist if the room has the Statement of Truth extension and Statement of Truth exists on the room. Will be completed when a contact has signed Statement of Truth.The assignee will always be CUSTOMER, deadlineDate is set to the deadlineDate of the Statement of Truth. The functionality is STATEMENT_OF_TRUTH.")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class SignStatementOfTruthTask implements Serializable {
  public static final String JSON_PROPERTY_ASSIGNEE = "assignee";
  @JsonProperty(JSON_PROPERTY_ASSIGNEE)
  @Schema(required = true)
  private TaskAssignee assignee;

  public static final String JSON_PROPERTY_COMPLETED = "completed";
  @JsonProperty(JSON_PROPERTY_COMPLETED)
  @Schema(required = true, description = "Whether the task has been completed. Events will be propagated in the case of completion.")
  private Boolean completed;

  public static final String JSON_PROPERTY_DEADLINE_DATE = "deadlineDate";
  @JsonProperty(JSON_PROPERTY_DEADLINE_DATE)
  @JsonDeserialize(using = mada.tests.e2e.dto.oneof.KunderumLocalDateDeserializer.class)
  @JsonSerialize(using = mada.tests.e2e.dto.oneof.KunderumLocalDateSerializer.class)
  @Schema(nullable = true, description = "The date of deadline until the task must be completed by the assignee.")
  private LocalDate deadlineDate;

  public static final String JSON_PROPERTY_FUNCTIONALITY = "functionality";
  @JsonProperty(JSON_PROPERTY_FUNCTIONALITY)
  private TaskFunctionality functionality;

  public static final String JSON_PROPERTY_ROOM_ID = "roomId";
  @JsonProperty(JSON_PROPERTY_ROOM_ID)
  @Schema(required = true, readOnly = true, description = "UUID of the room this task exists in.", example = "c1685198-7fb2-4322-ac57-d30a15bf5287")
  private UUID roomId;

  public static final String JSON_PROPERTY_TASK_ID = "taskId";
  @JsonProperty(JSON_PROPERTY_TASK_ID)
  @Schema(readOnly = true, description = "UUID of this task.", example = "c1685198-7fb2-4322-ac57-d30a15bf5287")
  private UUID taskId;

  public enum TypeEnum {
    SIGN_STATEMENT_OF_TRUTH("SIGN_STATEMENT_OF_TRUTH");

    private final String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (Objects.equals(b.value, value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_TYPE = "type";
  @JsonProperty(JSON_PROPERTY_TYPE)
  @Schema(required = true)
  private TypeEnum type;

  public SignStatementOfTruthTask assignee(TaskAssignee assignee) {
    this.assignee = Objects.requireNonNull(assignee, "Property assignee is required, cannot be null");
    return this;
  }

  /**
   * Get assignee
   * @return assignee
   **/
  @NotNull @Valid
  public TaskAssignee getAssignee() {
    return assignee;
  }

  public void setAssignee(TaskAssignee assignee) {
    this.assignee = Objects.requireNonNull(assignee, "Property assignee is required, cannot be null");
  }

  public SignStatementOfTruthTask completed(Boolean completed) {
    this.completed = Objects.requireNonNull(completed, "Property completed is required, cannot be null");
    return this;
  }

  /**
   * Whether the task has been completed. Events will be propagated in the case of completion.
   *
   * @return completed
   **/
  @NotNull
  public Boolean isCompleted() {
    return completed;
  }

  public void setCompleted(Boolean completed) {
    this.completed = Objects.requireNonNull(completed, "Property completed is required, cannot be null");
  }

  public SignStatementOfTruthTask deadlineDate(LocalDate deadlineDate) {
    this.deadlineDate = deadlineDate;
    return this;
  }

  /**
   * The date of deadline until the task must be completed by the assignee.
   *
   * @return deadlineDate
   **/
  public LocalDate getDeadlineDate() {
    return deadlineDate;
  }

  public void setDeadlineDate(LocalDate deadlineDate) {
    this.deadlineDate = deadlineDate;
  }

  public SignStatementOfTruthTask functionality(TaskFunctionality functionality) {
    this.functionality = functionality;
    return this;
  }

  /**
   * Get functionality
   * @return functionality
   **/
  @Valid
  public TaskFunctionality getFunctionality() {
    return functionality;
  }

  public void setFunctionality(TaskFunctionality functionality) {
    this.functionality = functionality;
  }

  public SignStatementOfTruthTask roomId(UUID roomId) {
    this.roomId = Objects.requireNonNull(roomId, "Property roomId is required, cannot be null");
    return this;
  }

  /**
   * UUID of the room this task exists in.
   *
   * @return roomId
   **/
  @NotNull
  public UUID getRoomId() {
    return roomId;
  }

  public void setRoomId(UUID roomId) {
    this.roomId = Objects.requireNonNull(roomId, "Property roomId is required, cannot be null");
  }

  public SignStatementOfTruthTask taskId(UUID taskId) {
    this.taskId = taskId;
    return this;
  }

  /**
   * UUID of this task.
   *
   * @return taskId
   **/
  public UUID getTaskId() {
    return taskId;
  }

  public void setTaskId(UUID taskId) {
    this.taskId = taskId;
  }

  public SignStatementOfTruthTask type(TypeEnum type) {
    this.type = Objects.requireNonNull(type, "Property type is required, cannot be null");
    return this;
  }

  /**
   * Get type
   * @return type
   **/
  @NotNull
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = Objects.requireNonNull(type, "Property type is required, cannot be null");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SignStatementOfTruthTask)) {
      return false;
    }
    SignStatementOfTruthTask other = (SignStatementOfTruthTask) o;
    return Objects.equals(this.assignee, other.assignee) &&
        Objects.equals(this.completed, other.completed) &&
        Objects.equals(this.deadlineDate, other.deadlineDate) &&
        Objects.equals(this.functionality, other.functionality) &&
        Objects.equals(this.roomId, other.roomId) &&
        Objects.equals(this.taskId, other.taskId) &&
        Objects.equals(this.type, other.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(assignee, completed, deadlineDate, functionality, roomId, taskId, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SignStatementOfTruthTask {");
    sb.append("\n    assignee: ").append(toIndentedString(assignee));
    sb.append("\n    completed: ").append(toIndentedString(completed));
    sb.append("\n    deadlineDate: ").append(toIndentedString(deadlineDate));
    sb.append("\n    functionality: ").append(toIndentedString(functionality));
    sb.append("\n    roomId: ").append(toIndentedString(roomId));
    sb.append("\n    taskId: ").append(toIndentedString(taskId));
    sb.append("\n    type: ").append(toIndentedString(type));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
