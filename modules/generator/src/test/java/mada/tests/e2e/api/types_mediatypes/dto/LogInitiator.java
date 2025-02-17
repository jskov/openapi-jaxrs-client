/*
 * Auditlog API
 * API for accessing the auditlogging
 *
 * The version of the OpenAPI document: 1.0.0
 */

package mada.tests.e2e.api.types_mediatypes.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * LogInitiator
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class LogInitiator {
  public static final String JSON_PROPERTY_INITIATOR = "initiator";
  @JsonbProperty(JSON_PROPERTY_INITIATOR)
  @Schema(required = true)
  private String initiator;

  public static final String JSON_PROPERTY_REMOTE_HOST_ID = "remote-host-id";
  @JsonbProperty(JSON_PROPERTY_REMOTE_HOST_ID)
  private String remoteHostId;

  public static final String JSON_PROPERTY_REMOTE_IP = "remote-ip";
  @JsonbProperty(JSON_PROPERTY_REMOTE_IP)
  private String remoteIp;

  public static final String JSON_PROPERTY_TYPE = "type";
  @JsonbProperty(JSON_PROPERTY_TYPE)
  @Schema(required = true)
  private InitiatorType type;

  public LogInitiator initiator(String initiator) {
    this.initiator = Objects.requireNonNull(initiator, "Property initiator is required, cannot be null");
    return this;
  }

  /**
   * Get initiator
   * @return initiator
   **/
  @NotNull @NotBlank
  public String getInitiator() {
    return initiator;
  }

  public void setInitiator(String initiator) {
    this.initiator = Objects.requireNonNull(initiator, "Property initiator is required, cannot be null");
  }

  public LogInitiator remoteHostId(String remoteHostId) {
    this.remoteHostId = remoteHostId;
    return this;
  }

  /**
   * Get remoteHostId
   * @return remoteHostId
   **/
  public String getRemoteHostId() {
    return remoteHostId;
  }

  public void setRemoteHostId(String remoteHostId) {
    this.remoteHostId = remoteHostId;
  }

  public LogInitiator remoteIp(String remoteIp) {
    this.remoteIp = remoteIp;
    return this;
  }

  /**
   * Get remoteIp
   * @return remoteIp
   **/
  public String getRemoteIp() {
    return remoteIp;
  }

  public void setRemoteIp(String remoteIp) {
    this.remoteIp = remoteIp;
  }

  public LogInitiator type(InitiatorType type) {
    this.type = Objects.requireNonNull(type, "Property type is required, cannot be null");
    return this;
  }

  /**
   * Get type
   * @return type
   **/
  @NotNull @Valid
  public InitiatorType getType() {
    return type;
  }

  public void setType(InitiatorType type) {
    this.type = Objects.requireNonNull(type, "Property type is required, cannot be null");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof LogInitiator)) {
      return false;
    }
    LogInitiator other = (LogInitiator) o;
    return Objects.equals(this.initiator, other.initiator) &&
        Objects.equals(this.remoteHostId, other.remoteHostId) &&
        Objects.equals(this.remoteIp, other.remoteIp) &&
        Objects.equals(this.type, other.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(initiator, remoteHostId, remoteIp, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LogInitiator {");
    sb.append("\n    initiator: ").append(toIndentedString(initiator));
    sb.append("\n    remoteHostId: ").append(toIndentedString(remoteHostId));
    sb.append("\n    remoteIp: ").append(toIndentedString(remoteIp));
    sb.append("\n    type: ").append(toIndentedString(type));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
