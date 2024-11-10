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
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestMirroredRepository
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestMirroredRepository {
    public static final String JSON_PROPERTY_AVAILABLE = "available";
    @JsonbProperty(JSON_PROPERTY_AVAILABLE)
    private Boolean available;

    public static final String JSON_PROPERTY_CLONE_URLS = "cloneUrls";
    @JsonbProperty(JSON_PROPERTY_CLONE_URLS)
    private List<RestNamedLink> cloneUrls;

    public static final String JSON_PROPERTY_LAST_UPDATED = "lastUpdated";
    @JsonbProperty(JSON_PROPERTY_LAST_UPDATED)
    private OffsetDateTime lastUpdated;

    public static final String JSON_PROPERTY_MIRROR_NAME = "mirrorName";
    @JsonbProperty(JSON_PROPERTY_MIRROR_NAME)
    @Schema(example = "Saigon Mirror")
    private String mirrorName;

    public static final String JSON_PROPERTY_PUSH_URLS = "pushUrls";
    @JsonbProperty(JSON_PROPERTY_PUSH_URLS)
    private List<RestNamedLink> pushUrls;

    public static final String JSON_PROPERTY_REPOSITORY_ID = "repositoryId";
    @JsonbProperty(JSON_PROPERTY_REPOSITORY_ID)
    @Schema(example = "1")
    private String repositoryId;

    public enum StatusEnum {
      NOT_MIRRORED("NOT_MIRRORED"),
      INITIALIZING("INITIALIZING"),
      AVAILABLE("AVAILABLE"),
      ERROR_INITIALIZING("ERROR_INITIALIZING"),
      ERROR_AVAILABLE("ERROR_AVAILABLE");

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
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestMirroredRepository.StatusEnum.StatusEnumAdapter.class)
    private StatusEnum status;

    public RestMirroredRepository available(Boolean available) {
        this.available = available;
        return this;
    }

    /**
     * Get available
     *
     * @return available
     **/
    public Boolean isAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public RestMirroredRepository cloneUrls(List<RestNamedLink> cloneUrls) {
        this.cloneUrls = cloneUrls;
        return this;
    }

    public RestMirroredRepository addCloneUrlsItem(RestNamedLink cloneUrlsItem) {
        if (this.cloneUrls == null) {
            this.cloneUrls = new ArrayList<>();
        }
        this.cloneUrls.add(cloneUrlsItem);
        return this;
    }

    /**
     * Get cloneUrls
     *
     * @return cloneUrls
     **/
    @Valid public List<RestNamedLink> getCloneUrls() {
        return cloneUrls;
    }

    public void setCloneUrls(List<RestNamedLink> cloneUrls) {
        this.cloneUrls = cloneUrls;
    }

    public RestMirroredRepository lastUpdated(OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    /**
     * Get lastUpdated
     *
     * @return lastUpdated
     **/
    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public RestMirroredRepository mirrorName(String mirrorName) {
        this.mirrorName = mirrorName;
        return this;
    }

    /**
     * Get mirrorName
     *
     * @return mirrorName
     **/
    public String getMirrorName() {
        return mirrorName;
    }

    public void setMirrorName(String mirrorName) {
        this.mirrorName = mirrorName;
    }

    public RestMirroredRepository pushUrls(List<RestNamedLink> pushUrls) {
        this.pushUrls = pushUrls;
        return this;
    }

    public RestMirroredRepository addPushUrlsItem(RestNamedLink pushUrlsItem) {
        if (this.pushUrls == null) {
            this.pushUrls = new ArrayList<>();
        }
        this.pushUrls.add(pushUrlsItem);
        return this;
    }

    /**
     * Get pushUrls
     *
     * @return pushUrls
     **/
    @Valid public List<RestNamedLink> getPushUrls() {
        return pushUrls;
    }

    public void setPushUrls(List<RestNamedLink> pushUrls) {
        this.pushUrls = pushUrls;
    }

    public RestMirroredRepository repositoryId(String repositoryId) {
        this.repositoryId = repositoryId;
        return this;
    }

    /**
     * Get repositoryId
     *
     * @return repositoryId
     **/
    public String getRepositoryId() {
        return repositoryId;
    }

    public void setRepositoryId(String repositoryId) {
        this.repositoryId = repositoryId;
    }

    public RestMirroredRepository status(StatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     **/
    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestMirroredRepository)) {
            return false;
        }
        RestMirroredRepository other = (RestMirroredRepository) o;
        return Objects.equals(this.available, other.available) &&
                Objects.equals(this.cloneUrls, other.cloneUrls) &&
                Objects.equals(this.lastUpdated, other.lastUpdated) &&
                Objects.equals(this.mirrorName, other.mirrorName) &&
                Objects.equals(this.pushUrls, other.pushUrls) &&
                Objects.equals(this.repositoryId, other.repositoryId) &&
                Objects.equals(this.status, other.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(available, cloneUrls, lastUpdated, mirrorName, pushUrls, repositoryId, status);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestMirroredRepository {");
        sb.append("\n    available: ").append(toIndentedString(available));
        sb.append("\n    cloneUrls: ").append(toIndentedString(cloneUrls));
        sb.append("\n    lastUpdated: ").append(toIndentedString(lastUpdated));
        sb.append("\n    mirrorName: ").append(toIndentedString(mirrorName));
        sb.append("\n    pushUrls: ").append(toIndentedString(pushUrls));
        sb.append("\n    repositoryId: ").append(toIndentedString(repositoryId));
        sb.append("\n    status: ").append(toIndentedString(status));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
