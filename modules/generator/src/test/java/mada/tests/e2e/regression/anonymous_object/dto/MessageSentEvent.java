/*
 * Test
 *
 * The version of the OpenAPI document: 1.0.0
 */

package mada.tests.e2e.regression.anonymous_object.dto;

import java.time.OffsetDateTime;
import java.util.Objects;
import javax.json.Json;
import javax.json.JsonString;
import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * MessageSentEvent
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class MessageSentEvent {
    public static final String JSON_PROPERTY_BANK_NUMBER = "bankNumber";
    @JsonbProperty(JSON_PROPERTY_BANK_NUMBER)
    @Schema(readOnly = true, description = "The bank which the event occurred in.", example = "51")
    private Integer bankNumber;

    public static final String JSON_PROPERTY_CORRELATION_ID = "correlationId";
    @JsonbProperty(JSON_PROPERTY_CORRELATION_ID)
    @Schema(description = "Correlation id of the original action which has led to this event.", example = "5c812d49-0d13-44fa-8b9f-97765fc5e1ff")
    private String correlationId;

    public static final String JSON_PROPERTY_ID = "id";
    @JsonbProperty(JSON_PROPERTY_ID)
    @Schema(readOnly = true, description = "Auto-generated id of this event.", example = "5c812d49-0d13-44fa-8b9f-97765fc5e1ff")
    private String id;

    public static final String JSON_PROPERTY_MESSAGE_ID = "messageId";
    @JsonbProperty(JSON_PROPERTY_MESSAGE_ID)
    @Schema(required = true, description = "The UUID of the message.")
    private String messageId;

    public static final String JSON_PROPERTY_OCCURRED_AT = "occurredAt";
    @JsonbProperty(JSON_PROPERTY_OCCURRED_AT)
    @Schema(description = "Time the event was logged determined from the application initiating logging of the event.")
    private OffsetDateTime occurredAt;

    public static final String JSON_PROPERTY_ROOM_ID = "roomId";
    @JsonbProperty(JSON_PROPERTY_ROOM_ID)
    @Schema(required = true, description = "The id of the room which the event occurred in.", example = "5c812d49-0d13-44fa-8b9f-97765fc5e1ff")
    private String roomId;

    public static final String JSON_PROPERTY_SENT_AT = "sentAt";
    @JsonbProperty(JSON_PROPERTY_SENT_AT)
    @Schema(required = true, description = "The timestamp for when the message was sent.")
    private Object sentAt;

    public static final String JSON_PROPERTY_SUB = "sub";
    @JsonbProperty(JSON_PROPERTY_SUB)
    @Schema(description = "Subject claim on the token which was used to perform the action that led to this event.")
    private String sub;

    public enum TypeEnum {
      MESSAGE_SENT("MESSAGE_SENT");

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
    @JsonbTypeAdapter(mada.tests.e2e.regression.anonymous_object.dto.MessageSentEvent.TypeEnum.TypeEnumAdapter.class)
    @Schema(required = true)
    private TypeEnum type;

    public MessageSentEvent bankNumber(Integer bankNumber) {
        this.bankNumber = bankNumber;
        return this;
    }

    /**
     * The bank which the event occurred in.
     * @return bankNumber
     **/
    public Integer getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(Integer bankNumber) {
        this.bankNumber = bankNumber;
    }

    public MessageSentEvent correlationId(String correlationId) {
        this.correlationId = correlationId;
        return this;
    }

    /**
     * Correlation id of the original action which has led to this event.
     * @return correlationId
     **/
    public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public MessageSentEvent id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Auto-generated id of this event.
     * @return id
     **/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MessageSentEvent messageId(String messageId) {
        this.messageId = Objects.requireNonNull(messageId, "Property messageId is required, cannot be null");
        return this;
    }

    /**
     * The UUID of the message.
     * @return messageId
     **/
    @NotNull public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = Objects.requireNonNull(messageId, "Property messageId is required, cannot be null");
    }

    public MessageSentEvent occurredAt(OffsetDateTime occurredAt) {
        this.occurredAt = occurredAt;
        return this;
    }

    /**
     * Time the event was logged determined from the application initiating logging of the event.
     * @return occurredAt
     **/
    public OffsetDateTime getOccurredAt() {
        return occurredAt;
    }

    public void setOccurredAt(OffsetDateTime occurredAt) {
        this.occurredAt = occurredAt;
    }

    public MessageSentEvent roomId(String roomId) {
        this.roomId = Objects.requireNonNull(roomId, "Property roomId is required, cannot be null");
        return this;
    }

    /**
     * The id of the room which the event occurred in.
     * @return roomId
     **/
    @NotNull public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = Objects.requireNonNull(roomId, "Property roomId is required, cannot be null");
    }

    public MessageSentEvent sentAt(Object sentAt) {
        this.sentAt = Objects.requireNonNull(sentAt, "Property sentAt is required, cannot be null");
        return this;
    }

    /**
     * The timestamp for when the message was sent.
     * @return sentAt
     **/
    @NotNull public Object getSentAt() {
        return sentAt;
    }

    public void setSentAt(Object sentAt) {
        this.sentAt = Objects.requireNonNull(sentAt, "Property sentAt is required, cannot be null");
    }

    public MessageSentEvent sub(String sub) {
        this.sub = sub;
        return this;
    }

    /**
     * Subject claim on the token which was used to perform the action that led to this event.
     * @return sub
     **/
    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public MessageSentEvent type(TypeEnum type) {
        this.type = Objects.requireNonNull(type, "Property type is required, cannot be null");
        return this;
    }

    /**
     * Get type
     *
     * @return type
     **/
    @NotNull public TypeEnum getType() {
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
        if (!(o instanceof MessageSentEvent)) {
            return false;
        }
        MessageSentEvent other = (MessageSentEvent) o;
        return Objects.equals(this.bankNumber, other.bankNumber) &&
                Objects.equals(this.correlationId, other.correlationId) &&
                Objects.equals(this.id, other.id) &&
                Objects.equals(this.messageId, other.messageId) &&
                Objects.equals(this.occurredAt, other.occurredAt) &&
                Objects.equals(this.roomId, other.roomId) &&
                Objects.equals(this.sentAt, other.sentAt) &&
                Objects.equals(this.sub, other.sub) &&
                Objects.equals(this.type, other.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankNumber, correlationId, id, messageId, occurredAt, roomId, sentAt, sub, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MessageSentEvent {");
        sb.append("\n    bankNumber: ").append(toIndentedString(bankNumber));
        sb.append("\n    correlationId: ").append(toIndentedString(correlationId));
        sb.append("\n    id: ").append(toIndentedString(id));
        sb.append("\n    messageId: ").append(toIndentedString(messageId));
        sb.append("\n    occurredAt: ").append(toIndentedString(occurredAt));
        sb.append("\n    roomId: ").append(toIndentedString(roomId));
        sb.append("\n    sentAt: ").append(toIndentedString(sentAt));
        sb.append("\n    sub: ").append(toIndentedString(sub));
        sb.append("\n    type: ").append(toIndentedString(type));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
