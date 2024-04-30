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
import java.util.Objects;

/**
 * RestAnnouncementBanner
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestAnnouncementBanner {
  public enum AudienceEnum {
    AUTHENTICATED("AUTHENTICATED"),
    ALL("ALL");

    private final String value;

    AudienceEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static class AudienceEnumAdapter implements JsonbAdapter<AudienceEnum, JsonString> {
      @Override
      public JsonString adaptToJson(AudienceEnum e) throws Exception {
        return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public AudienceEnum adaptFromJson(JsonString value) throws Exception {
        for (AudienceEnum b : AudienceEnum.values()) {
          if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
            return b;
          }
        }
        throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type AudienceEnum");
      }
    }
  }

  public static final String JSON_PROPERTY_AUDIENCE = "audience";
  @JsonbProperty(JSON_PROPERTY_AUDIENCE)
  @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestAnnouncementBanner.AudienceEnum.AudienceEnumAdapter.class)
  private AudienceEnum audience;

  public static final String JSON_PROPERTY_ENABLED = "enabled";
  @JsonbProperty(JSON_PROPERTY_ENABLED)
  private Boolean enabled;

  public static final String JSON_PROPERTY_MESSAGE = "message";
  @JsonbProperty(JSON_PROPERTY_MESSAGE)
  private String message;

  public RestAnnouncementBanner audience(AudienceEnum audience) {
    this.audience = audience;
    return this;
  }

  /**
   * Get audience
   * @return audience
   **/
  public AudienceEnum getAudience() {
    return audience;
  }

  public void setAudience(AudienceEnum audience) {
    this.audience = audience;
  }

  public RestAnnouncementBanner enabled(Boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  /**
   * Get enabled
   * @return enabled
   **/
  public Boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public RestAnnouncementBanner message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
   **/
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestAnnouncementBanner)) {
      return false;
    }
    RestAnnouncementBanner other = (RestAnnouncementBanner) o;
    return Objects.equals(this.audience, other.audience) &&
        Objects.equals(this.enabled, other.enabled) &&
        Objects.equals(this.message, other.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(audience, enabled, message);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestAnnouncementBanner {");
    sb.append("\n    audience: ").append(toIndentedString(audience));
    sb.append("\n    enabled: ").append(toIndentedString(enabled));
    sb.append("\n    message: ").append(toIndentedString(message));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
