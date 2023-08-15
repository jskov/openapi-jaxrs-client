/*
 * Auditlog API
 * API for accessing the auditlogging
 *
 * The version of the OpenAPI document: 1.0.0
 */

package mada.tests.e2e.api.types_mediatypes.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * LogResult
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class LogResult {
  public static final String JSON_PROPERTY_DURATION_FOR_ADDING_EVENT = "duration-for-adding-event";
  @JsonbProperty(JSON_PROPERTY_DURATION_FOR_ADDING_EVENT)
  private String durationForAddingEvent;

  public static final String JSON_PROPERTY_TIME_OF_EVENT = "time-of-event";
  @JsonbProperty(JSON_PROPERTY_TIME_OF_EVENT)
  private OffsetDateTime timeOfEvent;

  public LogResult durationForAddingEvent(String durationForAddingEvent) {
    this.durationForAddingEvent = durationForAddingEvent;
    return this;
  }

  /**
   * Get durationForAddingEvent
   * @return durationForAddingEvent
   **/
  public String getDurationForAddingEvent() {
    return durationForAddingEvent;
  }

  public void setDurationForAddingEvent(String durationForAddingEvent) {
    this.durationForAddingEvent = durationForAddingEvent;
  }

  public LogResult timeOfEvent(OffsetDateTime timeOfEvent) {
    this.timeOfEvent = timeOfEvent;
    return this;
  }

  /**
   * Get timeOfEvent
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
    if (!(o instanceof LogResult)) {
      return false;
    }
    LogResult other = (LogResult) o;
    return Objects.equals(this.durationForAddingEvent, other.durationForAddingEvent) &&
        Objects.equals(this.timeOfEvent, other.timeOfEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(durationForAddingEvent, timeOfEvent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LogResult {");
    sb.append("\n    durationForAddingEvent: ").append(toIndentedString(durationForAddingEvent));
    sb.append("\n    timeOfEvent: ").append(toIndentedString(timeOfEvent));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
