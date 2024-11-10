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
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestMeshMigrationSummary
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestMeshMigrationSummary {
    public static final String JSON_PROPERTY_END_TIME = "endTime";
    @JsonbProperty(JSON_PROPERTY_END_TIME)
    @Schema(example = "1331038800000")
    private Long endTime;

    public static final String JSON_PROPERTY_JOB_ID = "jobId";
    @JsonbProperty(JSON_PROPERTY_JOB_ID)
    private Long jobId;

    public static final String JSON_PROPERTY_MAX_BANDWIDTH = "maxBandwidth";
    @JsonbProperty(JSON_PROPERTY_MAX_BANDWIDTH)
    private Long maxBandwidth;

    public static final String JSON_PROPERTY_PROGRESS = "progress";
    @JsonbProperty(JSON_PROPERTY_PROGRESS)
    @Schema(example = "53")
    private Integer progress;

    public static final String JSON_PROPERTY_QUEUE = "queue";
    @JsonbProperty(JSON_PROPERTY_QUEUE)
    private Object queue;

    public static final String JSON_PROPERTY_START_TIME = "startTime";
    @JsonbProperty(JSON_PROPERTY_START_TIME)
    @Schema(example = "1331038800000")
    private Long startTime;

    public static final String JSON_PROPERTY_STATE = "state";
    @JsonbProperty(JSON_PROPERTY_STATE)
    @Schema(example = "RUNNING")
    private String state;

    public RestMeshMigrationSummary endTime(Long endTime) {
        this.endTime = endTime;
        return this;
    }

    /**
     * Get endTime
     *
     * @return endTime
     **/
    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public RestMeshMigrationSummary jobId(Long jobId) {
        this.jobId = jobId;
        return this;
    }

    /**
     * Get jobId
     *
     * @return jobId
     **/
    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public RestMeshMigrationSummary maxBandwidth(Long maxBandwidth) {
        this.maxBandwidth = maxBandwidth;
        return this;
    }

    /**
     * Get maxBandwidth
     *
     * @return maxBandwidth
     **/
    public Long getMaxBandwidth() {
        return maxBandwidth;
    }

    public void setMaxBandwidth(Long maxBandwidth) {
        this.maxBandwidth = maxBandwidth;
    }

    public RestMeshMigrationSummary progress(Integer progress) {
        this.progress = progress;
        return this;
    }

    /**
     * Get progress
     *
     * @return progress
     **/
    public Integer getProgress() {
        return progress;
    }

    public void setProgress(Integer progress) {
        this.progress = progress;
    }

    public RestMeshMigrationSummary queue(Object queue) {
        this.queue = queue;
        return this;
    }

    /**
     * Get queue
     *
     * @return queue
     **/
    public Object getQueue() {
        return queue;
    }

    public void setQueue(Object queue) {
        this.queue = queue;
    }

    public RestMeshMigrationSummary startTime(Long startTime) {
        this.startTime = startTime;
        return this;
    }

    /**
     * Get startTime
     *
     * @return startTime
     **/
    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public RestMeshMigrationSummary state(String state) {
        this.state = state;
        return this;
    }

    /**
     * Get state
     *
     * @return state
     **/
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestMeshMigrationSummary)) {
            return false;
        }
        RestMeshMigrationSummary other = (RestMeshMigrationSummary) o;
        return Objects.equals(this.endTime, other.endTime) &&
                Objects.equals(this.jobId, other.jobId) &&
                Objects.equals(this.maxBandwidth, other.maxBandwidth) &&
                Objects.equals(this.progress, other.progress) &&
                Objects.equals(this.queue, other.queue) &&
                Objects.equals(this.startTime, other.startTime) &&
                Objects.equals(this.state, other.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(endTime, jobId, maxBandwidth, progress, queue, startTime, state);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestMeshMigrationSummary {");
        sb.append("\n    endTime: ").append(toIndentedString(endTime));
        sb.append("\n    jobId: ").append(toIndentedString(jobId));
        sb.append("\n    maxBandwidth: ").append(toIndentedString(maxBandwidth));
        sb.append("\n    progress: ").append(toIndentedString(progress));
        sb.append("\n    queue: ").append(toIndentedString(queue));
        sb.append("\n    startTime: ").append(toIndentedString(startTime));
        sb.append("\n    state: ").append(toIndentedString(state));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
