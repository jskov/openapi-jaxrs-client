/*
 * Auditlog API
 * API for accessing the auditlogging
 *
 * The version of the OpenAPI document: 1.0.0
 */

package mada.tests.e2e.api.types_mediatypes.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.OffsetDateTime;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * LogEntry
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class LogEntry {
    public static final String JSON_PROPERTY_CORRELATION_ID = "correlation-id";
    @JsonbProperty(JSON_PROPERTY_CORRELATION_ID)
    @Schema(required = true)
    private String correlationId;

    public static final String JSON_PROPERTY_INITIATOR = "initiator";
    @JsonbProperty(JSON_PROPERTY_INITIATOR)
    @Schema(required = true)
    private LogInitiator initiator;

    public static final String JSON_PROPERTY_MESSAGE = "message";
    @JsonbProperty(JSON_PROPERTY_MESSAGE)
    @Schema(required = true)
    private String message;

    public static final String JSON_PROPERTY_OPERATION = "operation";
    @JsonbProperty(JSON_PROPERTY_OPERATION)
    @Schema(required = true)
    private String operation;

    public static final String JSON_PROPERTY_OPERATION_CATEGORY = "operation-category";
    @JsonbProperty(JSON_PROPERTY_OPERATION_CATEGORY)
    @Schema(required = true)
    private OperationCategory operationCategory;

    public static final String JSON_PROPERTY_ORIGIN = "origin";
    @JsonbProperty(JSON_PROPERTY_ORIGIN)
    @Schema(required = true)
    private LogOrigin origin;

    public static final String JSON_PROPERTY_TIME_OF_EVENT = "time-of-event";
    @JsonbProperty(JSON_PROPERTY_TIME_OF_EVENT)
    private OffsetDateTime timeOfEvent;

    public LogEntry correlationId(String correlationId) {
        this.correlationId = Objects.requireNonNull(correlationId, "Property correlationId is required, cannot be null");
        return this;
    }

    /**
     * Get correlationId
     *
     * @return correlationId
     **/
    @NotNull @Size(min = 1, max = 40) public String getCorrelationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = Objects.requireNonNull(correlationId, "Property correlationId is required, cannot be null");
    }

    public LogEntry initiator(LogInitiator initiator) {
        this.initiator = Objects.requireNonNull(initiator, "Property initiator is required, cannot be null");
        return this;
    }

    /**
     * Get initiator
     *
     * @return initiator
     **/
    @NotNull @Valid public LogInitiator getInitiator() {
        return initiator;
    }

    public void setInitiator(LogInitiator initiator) {
        this.initiator = Objects.requireNonNull(initiator, "Property initiator is required, cannot be null");
    }

    public LogEntry message(String message) {
        this.message = Objects.requireNonNull(message, "Property message is required, cannot be null");
        return this;
    }

    /**
     * Get message
     *
     * @return message
     **/
    @NotNull @Pattern(regexp = "\\S") public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = Objects.requireNonNull(message, "Property message is required, cannot be null");
    }

    public LogEntry operation(String operation) {
        this.operation = Objects.requireNonNull(operation, "Property operation is required, cannot be null");
        return this;
    }

    /**
     * Get operation
     *
     * @return operation
     **/
    @NotNull @Pattern(regexp = "\\S") public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = Objects.requireNonNull(operation, "Property operation is required, cannot be null");
    }

    public LogEntry operationCategory(OperationCategory operationCategory) {
        this.operationCategory = Objects.requireNonNull(operationCategory, "Property operationCategory is required, cannot be null");
        return this;
    }

    /**
     * Get operationCategory
     *
     * @return operationCategory
     **/
    @NotNull @Valid public OperationCategory getOperationCategory() {
        return operationCategory;
    }

    public void setOperationCategory(OperationCategory operationCategory) {
        this.operationCategory = Objects.requireNonNull(operationCategory, "Property operationCategory is required, cannot be null");
    }

    public LogEntry origin(LogOrigin origin) {
        this.origin = Objects.requireNonNull(origin, "Property origin is required, cannot be null");
        return this;
    }

    /**
     * Get origin
     *
     * @return origin
     **/
    @NotNull @Valid public LogOrigin getOrigin() {
        return origin;
    }

    public void setOrigin(LogOrigin origin) {
        this.origin = Objects.requireNonNull(origin, "Property origin is required, cannot be null");
    }

    public LogEntry timeOfEvent(OffsetDateTime timeOfEvent) {
        this.timeOfEvent = timeOfEvent;
        return this;
    }

    /**
     * Get timeOfEvent
     *
     * @return timeOfEvent
     **/
    public OffsetDateTime getTimeOfEvent() {
        return timeOfEvent;
    }

    public void setTimeOfEvent(OffsetDateTime timeOfEvent) {
        this.timeOfEvent = timeOfEvent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LogEntry)) {
            return false;
        }
        LogEntry other = (LogEntry) o;
        return Objects.equals(this.correlationId, other.correlationId) &&
                Objects.equals(this.initiator, other.initiator) &&
                Objects.equals(this.message, other.message) &&
                Objects.equals(this.operation, other.operation) &&
                Objects.equals(this.operationCategory, other.operationCategory) &&
                Objects.equals(this.origin, other.origin) &&
                Objects.equals(this.timeOfEvent, other.timeOfEvent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(correlationId, initiator, message, operation, operationCategory, origin, timeOfEvent);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LogEntry {");
        sb.append("\n    correlationId: ").append(toIndentedString(correlationId));
        sb.append("\n    initiator: ").append(toIndentedString(initiator));
        sb.append("\n    message: ").append(toIndentedString(message));
        sb.append("\n    operation: ").append(toIndentedString(operation));
        sb.append("\n    operationCategory: ").append(toIndentedString(operationCategory));
        sb.append("\n    origin: ").append(toIndentedString(origin));
        sb.append("\n    timeOfEvent: ").append(toIndentedString(timeOfEvent));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
