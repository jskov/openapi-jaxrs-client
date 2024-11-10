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
 * RestPullRequestAssignStatusRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestPullRequestAssignStatusRequest {
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
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestPullRequestAssignStatusRequest.StatusEnum.StatusEnumAdapter.class)
    private StatusEnum status;

    public RestPullRequestAssignStatusRequest status(StatusEnum status) {
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
        if (!(o instanceof RestPullRequestAssignStatusRequest)) {
            return false;
        }
        RestPullRequestAssignStatusRequest other = (RestPullRequestAssignStatusRequest) o;
        return Objects.equals(this.status, other.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestPullRequestAssignStatusRequest {");
        sb.append("\n    status: ").append(toIndentedString(status));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
