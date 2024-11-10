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
 * RestAutoMergeProcessingResult
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestAutoMergeProcessingResult {
    public enum AutoMergeProcessingStatusEnum {
        CANCELLED("CANCELLED"),
        VETOED("VETOED"),
        STALE("STALE"),
        MERGED("MERGED"),
        LOCK_FAILURE("LOCK_FAILURE"),
        UNKNOWN("UNKNOWN");

        private final String value;

        AutoMergeProcessingStatusEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static class AutoMergeProcessingStatusEnumAdapter implements JsonbAdapter<AutoMergeProcessingStatusEnum, JsonString> {
            @Override
            public JsonString adaptToJson(AutoMergeProcessingStatusEnum e) throws Exception {
                return Json.createValue(String.valueOf(e.value));
            }

            @Override
            public AutoMergeProcessingStatusEnum adaptFromJson(JsonString value) throws Exception {
                for (AutoMergeProcessingStatusEnum b : AutoMergeProcessingStatusEnum.values()) {
                    if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                        return b;
                    }
                }
                throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type AutoMergeProcessingStatusEnum");
            }
        }
    }

    public static final String JSON_PROPERTY_AUTO_MERGE_PROCESSING_STATUS = "autoMergeProcessingStatus";
    @JsonbProperty(JSON_PROPERTY_AUTO_MERGE_PROCESSING_STATUS)
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestAutoMergeProcessingResult.AutoMergeProcessingStatusEnum.AutoMergeProcessingStatusEnumAdapter.class)
    @Schema(example = "CANCELLED")
    private AutoMergeProcessingStatusEnum autoMergeProcessingStatus;

    public static final String JSON_PROPERTY_PULL_REQUEST = "pullRequest";
    @JsonbProperty(JSON_PROPERTY_PULL_REQUEST)
    private RestAutoMergeProcessingResultPullRequest pullRequest;

    public RestAutoMergeProcessingResult autoMergeProcessingStatus(AutoMergeProcessingStatusEnum autoMergeProcessingStatus) {
        this.autoMergeProcessingStatus = autoMergeProcessingStatus;
        return this;
    }

    /**
     * Get autoMergeProcessingStatus
     *
     * @return autoMergeProcessingStatus
     **/
    public AutoMergeProcessingStatusEnum getAutoMergeProcessingStatus() {
        return autoMergeProcessingStatus;
    }

    public void setAutoMergeProcessingStatus(AutoMergeProcessingStatusEnum autoMergeProcessingStatus) {
        this.autoMergeProcessingStatus = autoMergeProcessingStatus;
    }

    public RestAutoMergeProcessingResult pullRequest(RestAutoMergeProcessingResultPullRequest pullRequest) {
        this.pullRequest = pullRequest;
        return this;
    }

    /**
     * Get pullRequest
     *
     * @return pullRequest
     **/
    @Valid
    public RestAutoMergeProcessingResultPullRequest getPullRequest() {
        return pullRequest;
    }

    public void setPullRequest(RestAutoMergeProcessingResultPullRequest pullRequest) {
        this.pullRequest = pullRequest;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestAutoMergeProcessingResult)) {
            return false;
        }
        RestAutoMergeProcessingResult other = (RestAutoMergeProcessingResult) o;
        return Objects.equals(this.autoMergeProcessingStatus, other.autoMergeProcessingStatus) &&
                Objects.equals(this.pullRequest, other.pullRequest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autoMergeProcessingStatus, pullRequest);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestAutoMergeProcessingResult {");
        sb.append("\n    autoMergeProcessingStatus: ").append(toIndentedString(autoMergeProcessingStatus));
        sb.append("\n    pullRequest: ").append(toIndentedString(pullRequest));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
