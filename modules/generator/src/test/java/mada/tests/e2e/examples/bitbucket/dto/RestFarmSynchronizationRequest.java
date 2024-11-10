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
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestFarmSynchronizationRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestFarmSynchronizationRequest {
    public static final String JSON_PROPERTY_ATTEMPT = "attempt";
    @JsonbProperty(JSON_PROPERTY_ATTEMPT)
    @Schema(example = "1")
    private Integer attempt;

    public static final String JSON_PROPERTY_CREATED_AT = "createdAt";
    @JsonbProperty(JSON_PROPERTY_CREATED_AT)
    @Schema(example = "2022-08-18T02:04:46.435Z")
    private String createdAt;

    public static final String JSON_PROPERTY_EXTERNAL_REPO_ID = "externalRepoId";
    @JsonbProperty(JSON_PROPERTY_EXTERNAL_REPO_ID)
    @Schema(example = "1")
    private String externalRepoId;

    @Schema(enumeration = { "incremental", "snapshot" }, type = SchemaType.STRING)
    public enum TypeEnum {
        INCREMENTAL("incremental"),
        SNAPSHOT("snapshot");

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
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestFarmSynchronizationRequest.TypeEnum.TypeEnumAdapter.class)
    @Schema(example = "INCREMENTAL")
    private TypeEnum type;

    public RestFarmSynchronizationRequest attempt(Integer attempt) {
        this.attempt = attempt;
        return this;
    }

    /**
     * Get attempt
     *
     * @return attempt
     **/
    public Integer getAttempt() {
        return attempt;
    }

    public void setAttempt(Integer attempt) {
        this.attempt = attempt;
    }

    public RestFarmSynchronizationRequest createdAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Get createdAt
     *
     * @return createdAt
     **/
    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public RestFarmSynchronizationRequest externalRepoId(String externalRepoId) {
        this.externalRepoId = externalRepoId;
        return this;
    }

    /**
     * Get externalRepoId
     *
     * @return externalRepoId
     **/
    public String getExternalRepoId() {
        return externalRepoId;
    }

    public void setExternalRepoId(String externalRepoId) {
        this.externalRepoId = externalRepoId;
    }

    public RestFarmSynchronizationRequest type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     **/
    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestFarmSynchronizationRequest)) {
            return false;
        }
        RestFarmSynchronizationRequest other = (RestFarmSynchronizationRequest) o;
        return Objects.equals(this.attempt, other.attempt) &&
                Objects.equals(this.createdAt, other.createdAt) &&
                Objects.equals(this.externalRepoId, other.externalRepoId) &&
                Objects.equals(this.type, other.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attempt, createdAt, externalRepoId, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestFarmSynchronizationRequest {");
        sb.append("\n    attempt: ").append(toIndentedString(attempt));
        sb.append("\n    createdAt: ").append(toIndentedString(createdAt));
        sb.append("\n    externalRepoId: ").append(toIndentedString(externalRepoId));
        sb.append("\n    type: ").append(toIndentedString(type));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
