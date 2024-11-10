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
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestRepositoryMirrorEvent
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestRepositoryMirrorEvent {
    public static final String JSON_PROPERTY_MIRROR_REPO_ID = "mirrorRepoId";
    @JsonbProperty(JSON_PROPERTY_MIRROR_REPO_ID)
    @Schema(example = "42")
    private Integer mirrorRepoId;

    public enum TypeEnum {
        SYNCHRONIZED("SYNCHRONIZED"),
        SYNCHRONIZATION_FAILED("SYNCHRONIZATION_FAILED");

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
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestRepositoryMirrorEvent.TypeEnum.TypeEnumAdapter.class)
    private TypeEnum type;

    public static final String JSON_PROPERTY_UPSTREAM_REPO_ID = "upstreamRepoId";
    @JsonbProperty(JSON_PROPERTY_UPSTREAM_REPO_ID)
    @Schema(example = "24")
    private String upstreamRepoId;

    public RestRepositoryMirrorEvent mirrorRepoId(Integer mirrorRepoId) {
        this.mirrorRepoId = mirrorRepoId;
        return this;
    }

    /**
     * Get mirrorRepoId
     *
     * @return mirrorRepoId
     **/
    public Integer getMirrorRepoId() {
        return mirrorRepoId;
    }

    public void setMirrorRepoId(Integer mirrorRepoId) {
        this.mirrorRepoId = mirrorRepoId;
    }

    public RestRepositoryMirrorEvent type(TypeEnum type) {
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

    public RestRepositoryMirrorEvent upstreamRepoId(String upstreamRepoId) {
        this.upstreamRepoId = upstreamRepoId;
        return this;
    }

    /**
     * Get upstreamRepoId
     *
     * @return upstreamRepoId
     **/
    public String getUpstreamRepoId() {
        return upstreamRepoId;
    }

    public void setUpstreamRepoId(String upstreamRepoId) {
        this.upstreamRepoId = upstreamRepoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestRepositoryMirrorEvent)) {
            return false;
        }
        RestRepositoryMirrorEvent other = (RestRepositoryMirrorEvent) o;
        return Objects.equals(this.mirrorRepoId, other.mirrorRepoId) &&
                Objects.equals(this.type, other.type) &&
                Objects.equals(this.upstreamRepoId, other.upstreamRepoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mirrorRepoId, type, upstreamRepoId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestRepositoryMirrorEvent {");
        sb.append("\n    mirrorRepoId: ").append(toIndentedString(mirrorRepoId));
        sb.append("\n    type: ").append(toIndentedString(type));
        sb.append("\n    upstreamRepoId: ").append(toIndentedString(upstreamRepoId));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
