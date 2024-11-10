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
 * RestGitTagCreateRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestGitTagCreateRequest {
    public static final String JSON_PROPERTY_FORCE = "force";
    @JsonbProperty(JSON_PROPERTY_FORCE)
    private Boolean force;

    public static final String JSON_PROPERTY_MESSAGE = "message";
    @JsonbProperty(JSON_PROPERTY_MESSAGE)
    @Schema(example = "A new release tag")
    private String message;

    public static final String JSON_PROPERTY_NAME = "name";
    @JsonbProperty(JSON_PROPERTY_NAME)
    @Schema(example = "release-tag")
    private String name;

    public static final String JSON_PROPERTY_START_POINT = "startPoint";
    @JsonbProperty(JSON_PROPERTY_START_POINT)
    @Schema(example = "refs/heads/master")
    private String startPoint;

    public enum TypeEnum {
        ANNOTATED("ANNOTATED"),
        LIGHTWEIGHT("LIGHTWEIGHT");

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
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestGitTagCreateRequest.TypeEnum.TypeEnumAdapter.class)
    private TypeEnum type;

    public RestGitTagCreateRequest force(Boolean force) {
        this.force = force;
        return this;
    }

    /**
     * Get force
     *
     * @return force
     **/
    public Boolean isForce() {
        return force;
    }

    public void setForce(Boolean force) {
        this.force = force;
    }

    public RestGitTagCreateRequest message(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get message
     *
     * @return message
     **/
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RestGitTagCreateRequest name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RestGitTagCreateRequest startPoint(String startPoint) {
        this.startPoint = startPoint;
        return this;
    }

    /**
     * Get startPoint
     *
     * @return startPoint
     **/
    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public RestGitTagCreateRequest type(TypeEnum type) {
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
        if (!(o instanceof RestGitTagCreateRequest)) {
            return false;
        }
        RestGitTagCreateRequest other = (RestGitTagCreateRequest) o;
        return Objects.equals(this.force, other.force) &&
                Objects.equals(this.message, other.message) &&
                Objects.equals(this.name, other.name) &&
                Objects.equals(this.startPoint, other.startPoint) &&
                Objects.equals(this.type, other.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(force, message, name, startPoint, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestGitTagCreateRequest {");
        sb.append("\n    force: ").append(toIndentedString(force));
        sb.append("\n    message: ").append(toIndentedString(message));
        sb.append("\n    name: ").append(toIndentedString(name));
        sb.append("\n    startPoint: ").append(toIndentedString(startPoint));
        sb.append("\n    type: ").append(toIndentedString(type));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
