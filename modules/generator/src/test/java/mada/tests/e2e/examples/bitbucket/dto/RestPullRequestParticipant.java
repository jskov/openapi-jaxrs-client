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
 * RestPullRequestParticipant
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestPullRequestParticipant {
  public static final String JSON_PROPERTY_APPROVED = "approved";
  @JsonbProperty(JSON_PROPERTY_APPROVED)
  private Boolean approved;

  public static final String JSON_PROPERTY_LAST_REVIEWED_COMMIT = "lastReviewedCommit";
  @JsonbProperty(JSON_PROPERTY_LAST_REVIEWED_COMMIT)
  @Schema(example = "7549846524f8aed2bd1c0249993ae1bf9d3c9998")
  private String lastReviewedCommit;

  public enum RoleEnum {
    AUTHOR("AUTHOR"),
    REVIEWER("REVIEWER"),
    PARTICIPANT("PARTICIPANT");

    private final String value;

    RoleEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static class RoleEnumAdapter implements JsonbAdapter<RoleEnum, JsonString> {
      @Override
      public JsonString adaptToJson(RoleEnum e) throws Exception {
        return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public RoleEnum adaptFromJson(JsonString value) throws Exception {
        for (RoleEnum b : RoleEnum.values()) {
          if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
            return b;
          }
        }
        throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type RoleEnum");
      }
    }
  }

  public static final String JSON_PROPERTY_ROLE = "role";
  @JsonbProperty(JSON_PROPERTY_ROLE)
  @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestPullRequestParticipant.RoleEnum.RoleEnumAdapter.class)
  private RoleEnum role;

  public enum StatusEnum {
    UNAPPROVED("UNAPPROVED"),
    NEEDS_WORK("NEEDS_WORK"),
    APPROVED("APPROVED");

    private final String value;

    StatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static class StatusEnumAdapter implements JsonbAdapter<StatusEnum, JsonString> {
      @Override
      public JsonString adaptToJson(StatusEnum e) throws Exception {
        return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public StatusEnum adaptFromJson(JsonString value) throws Exception {
        for (StatusEnum b : StatusEnum.values()) {
          if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
            return b;
          }
        }
        throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type StatusEnum");
      }
    }
  }

  public static final String JSON_PROPERTY_STATUS = "status";
  @JsonbProperty(JSON_PROPERTY_STATUS)
  @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestPullRequestParticipant.StatusEnum.StatusEnumAdapter.class)
  private StatusEnum status;

  public static final String JSON_PROPERTY_USER = "user";
  @JsonbProperty(JSON_PROPERTY_USER)
  private RestPullRequestParticipantUser user;

  public RestPullRequestParticipant approved(Boolean approved) {
    this.approved = approved;
    return this;
  }

  /**
   * Get approved
   * @return approved
   **/
  public Boolean isApproved() {
    return approved;
  }

  public void setApproved(Boolean approved) {
    this.approved = approved;
  }

  public RestPullRequestParticipant lastReviewedCommit(String lastReviewedCommit) {
    this.lastReviewedCommit = lastReviewedCommit;
    return this;
  }

  /**
   * Get lastReviewedCommit
   * @return lastReviewedCommit
   **/
  public String getLastReviewedCommit() {
    return lastReviewedCommit;
  }

  public void setLastReviewedCommit(String lastReviewedCommit) {
    this.lastReviewedCommit = lastReviewedCommit;
  }

  public RestPullRequestParticipant role(RoleEnum role) {
    this.role = role;
    return this;
  }

  /**
   * Get role
   * @return role
   **/
  public RoleEnum getRole() {
    return role;
  }

  public void setRole(RoleEnum role) {
    this.role = role;
  }

  public RestPullRequestParticipant status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   **/
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public RestPullRequestParticipant user(RestPullRequestParticipantUser user) {
    this.user = user;
    return this;
  }

  /**
   * Get user
   * @return user
   **/
  @Valid
  public RestPullRequestParticipantUser getUser() {
    return user;
  }

  public void setUser(RestPullRequestParticipantUser user) {
    this.user = user;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestPullRequestParticipant)) {
      return false;
    }
    RestPullRequestParticipant other = (RestPullRequestParticipant) o;
    return Objects.equals(this.approved, other.approved) &&
        Objects.equals(this.lastReviewedCommit, other.lastReviewedCommit) &&
        Objects.equals(this.role, other.role) &&
        Objects.equals(this.status, other.status) &&
        Objects.equals(this.user, other.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(approved, lastReviewedCommit, role, status, user);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestPullRequestParticipant {");
    sb.append("\n    approved: ").append(toIndentedString(approved));
    sb.append("\n    lastReviewedCommit: ").append(toIndentedString(lastReviewedCommit));
    sb.append("\n    role: ").append(toIndentedString(role));
    sb.append("\n    status: ").append(toIndentedString(status));
    sb.append("\n    user: ").append(toIndentedString(user));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
