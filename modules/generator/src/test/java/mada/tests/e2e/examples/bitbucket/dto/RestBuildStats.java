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

import jakarta.json.bind.annotation.JsonbProperty;
import java.util.Objects;

/**
 * RestBuildStats
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestBuildStats {
    public static final String JSON_PROPERTY_CANCELLED = "cancelled";
    @JsonbProperty(JSON_PROPERTY_CANCELLED)
    private Integer cancelled;

    public static final String JSON_PROPERTY_FAILED = "failed";
    @JsonbProperty(JSON_PROPERTY_FAILED)
    private Integer failed;

    public static final String JSON_PROPERTY_IN_PROGRESS = "inProgress";
    @JsonbProperty(JSON_PROPERTY_IN_PROGRESS)
    private Integer inProgress;

    public static final String JSON_PROPERTY_SUCCESSFUL = "successful";
    @JsonbProperty(JSON_PROPERTY_SUCCESSFUL)
    private Integer successful;

    public static final String JSON_PROPERTY_UNKNOWN = "unknown";
    @JsonbProperty(JSON_PROPERTY_UNKNOWN)
    private Integer unknown;

    public RestBuildStats cancelled(Integer cancelled) {
        this.cancelled = cancelled;
        return this;
    }

    /**
     * Get cancelled
     *
     * @return cancelled
     **/
    public Integer getCancelled() {
        return cancelled;
    }

    public void setCancelled(Integer cancelled) {
        this.cancelled = cancelled;
    }

    public RestBuildStats failed(Integer failed) {
        this.failed = failed;
        return this;
    }

    /**
     * Get failed
     *
     * @return failed
     **/
    public Integer getFailed() {
        return failed;
    }

    public void setFailed(Integer failed) {
        this.failed = failed;
    }

    public RestBuildStats inProgress(Integer inProgress) {
        this.inProgress = inProgress;
        return this;
    }

    /**
     * Get inProgress
     *
     * @return inProgress
     **/
    public Integer getInProgress() {
        return inProgress;
    }

    public void setInProgress(Integer inProgress) {
        this.inProgress = inProgress;
    }

    public RestBuildStats successful(Integer successful) {
        this.successful = successful;
        return this;
    }

    /**
     * Get successful
     *
     * @return successful
     **/
    public Integer getSuccessful() {
        return successful;
    }

    public void setSuccessful(Integer successful) {
        this.successful = successful;
    }

    public RestBuildStats unknown(Integer unknown) {
        this.unknown = unknown;
        return this;
    }

    /**
     * Get unknown
     *
     * @return unknown
     **/
    public Integer getUnknown() {
        return unknown;
    }

    public void setUnknown(Integer unknown) {
        this.unknown = unknown;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestBuildStats)) {
            return false;
        }
        RestBuildStats other = (RestBuildStats) o;
        return Objects.equals(this.cancelled, other.cancelled) &&
                Objects.equals(this.failed, other.failed) &&
                Objects.equals(this.inProgress, other.inProgress) &&
                Objects.equals(this.successful, other.successful) &&
                Objects.equals(this.unknown, other.unknown);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cancelled, failed, inProgress, successful, unknown);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestBuildStats {");
        sb.append("\n    cancelled: ").append(toIndentedString(cancelled));
        sb.append("\n    failed: ").append(toIndentedString(failed));
        sb.append("\n    inProgress: ").append(toIndentedString(inProgress));
        sb.append("\n    successful: ").append(toIndentedString(successful));
        sb.append("\n    unknown: ").append(toIndentedString(unknown));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
