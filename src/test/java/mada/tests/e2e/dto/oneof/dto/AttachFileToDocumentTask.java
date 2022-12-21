/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.dto.oneof.dto;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;
import javax.json.Json;
import javax.json.JsonString;
import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * A task that will exist for every document which is not supplementary and does not have a file attached. Will be completed when a contact attaches a file to the document. The assignee will always be CUSTOMER, and the deadlineDate is derived from the document itself. The functionality is DOCUMENTS.
 */
@JsonbPropertyOrder({
  AttachFileToDocumentTask.JSON_PROPERTY_TYPE,
  AttachFileToDocumentTask.JSON_PROPERTY_ASSIGNEE,
  AttachFileToDocumentTask.JSON_PROPERTY_COMPLETED,
  AttachFileToDocumentTask.JSON_PROPERTY_DEADLINE_DATE,
  AttachFileToDocumentTask.JSON_PROPERTY_FUNCTIONALITY,
  AttachFileToDocumentTask.JSON_PROPERTY_ROOM_ID,
  AttachFileToDocumentTask.JSON_PROPERTY_TASK_ID,
  AttachFileToDocumentTask.JSON_PROPERTY_DOCUMENT_ID
})
@Schema(description = "A task that will exist for every document which is not supplementary and does not have a file attached. Will be completed when a contact attaches a file to the document. The assignee will always be CUSTOMER, and the deadlineDate is derived from the document itself. The functionality is DOCUMENTS.")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class AttachFileToDocumentTask {
  public static final String JSON_PROPERTY_ASSIGNEE = "assignee";
  @JsonbProperty(JSON_PROPERTY_ASSIGNEE)
  @Schema(required = true)
  private TaskAssignee assignee;

  public static final String JSON_PROPERTY_COMPLETED = "completed";
  @JsonbProperty(JSON_PROPERTY_COMPLETED)
  @Schema(required = true, description = "Whether the task has been completed. Events will be propagated in the case of completion.")
  private Boolean completed;

  public static final String JSON_PROPERTY_DEADLINE_DATE = "deadlineDate";
  @JsonbProperty(JSON_PROPERTY_DEADLINE_DATE)
  @Schema(nullable = true, description = "The date of deadline until the task must be completed by the assignee.")
  private LocalDate deadlineDate;

  public static final String JSON_PROPERTY_DOCUMENT_ID = "documentId";
  @JsonbProperty(JSON_PROPERTY_DOCUMENT_ID)
  @Schema(description = "UUID of the document where one must attach the file to.", example = "c1685198-7fb2-4322-ac57-d30a15bf5287")
  private UUID documentId;

  public static final String JSON_PROPERTY_FUNCTIONALITY = "functionality";
  @JsonbProperty(JSON_PROPERTY_FUNCTIONALITY)
  private TaskFunctionality functionality;

  public static final String JSON_PROPERTY_ROOM_ID = "roomId";
  @JsonbProperty(JSON_PROPERTY_ROOM_ID)
  @Schema(required = true, readOnly = true, description = "UUID of the room this task exists in.", example = "c1685198-7fb2-4322-ac57-d30a15bf5287")
  private UUID roomId;

  public static final String JSON_PROPERTY_TASK_ID = "taskId";
  @JsonbProperty(JSON_PROPERTY_TASK_ID)
  @Schema(readOnly = true, description = "UUID of this task.", example = "c1685198-7fb2-4322-ac57-d30a15bf5287")
  private UUID taskId;

  public enum TypeEnum {
    ATTACH_FILE_TO_DOCUMENT("ATTACH_FILE_TO_DOCUMENT");

    private final String value;

    TypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static class TypeEnumAdapter implements JsonbAdapter<TypeEnum, JsonString> {
      @Override
      public JsonString adaptToJson(TypeEnum e) throws Exception {
        return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public TypeEnum adaptFromJson(JsonString value) throws Exception {
        for (TypeEnum b : TypeEnum.values()) {
          if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
            return b;
          }
        }
        throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type TypeEnum");
      }
    }
  }

  public static final String JSON_PROPERTY_TYPE = "type";
  @JsonbProperty(JSON_PROPERTY_TYPE)
  @JsonbTypeAdapter(mada.tests.e2e.dto.oneof.dto.AttachFileToDocumentTask.TypeEnum.TypeEnumAdapter.class)
  @Schema(required = true)
  private TypeEnum type;

  public AttachFileToDocumentTask assignee(TaskAssignee assignee) {
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

  public AttachFileToDocumentTask completed(Boolean completed) {
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

  public AttachFileToDocumentTask deadlineDate(LocalDate deadlineDate) {
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

  public AttachFileToDocumentTask documentId(UUID documentId) {
    this.documentId = documentId;
    return this;
  }

  /**
   * UUID of the document where one must attach the file to.
   *
   * @return documentId
   **/
  public UUID getDocumentId() {
    return documentId;
  }

  public void setDocumentId(UUID documentId) {
    this.documentId = documentId;
  }

  public AttachFileToDocumentTask functionality(TaskFunctionality functionality) {
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

  public AttachFileToDocumentTask roomId(UUID roomId) {
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

  public AttachFileToDocumentTask taskId(UUID taskId) {
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

  public AttachFileToDocumentTask type(TypeEnum type) {
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
    if (!(o instanceof AttachFileToDocumentTask)) {
      return false;
    }
    AttachFileToDocumentTask other = (AttachFileToDocumentTask) o;
    return Objects.equals(this.assignee, other.assignee) &&
        Objects.equals(this.completed, other.completed) &&
        Objects.equals(this.deadlineDate, other.deadlineDate) &&
        Objects.equals(this.documentId, other.documentId) &&
        Objects.equals(this.functionality, other.functionality) &&
        Objects.equals(this.roomId, other.roomId) &&
        Objects.equals(this.taskId, other.taskId) &&
        Objects.equals(this.type, other.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(assignee, completed, deadlineDate, documentId, functionality, roomId, taskId, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AttachFileToDocumentTask {");
    sb.append("\n    assignee: ").append(toIndentedString(assignee));
    sb.append("\n    completed: ").append(toIndentedString(completed));
    sb.append("\n    deadlineDate: ").append(toIndentedString(deadlineDate));
    sb.append("\n    documentId: ").append(toIndentedString(documentId));
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
