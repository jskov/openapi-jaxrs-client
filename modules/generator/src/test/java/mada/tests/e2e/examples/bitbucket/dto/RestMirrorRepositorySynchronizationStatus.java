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
import jakarta.validation.Valid;
import java.time.OffsetDateTime;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestMirrorRepositorySynchronizationStatus
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestMirrorRepositorySynchronizationStatus {
    public static final String JSON_PROPERTY_EXTERNAL_REPO_ID = "externalRepoId";
    @JsonbProperty(JSON_PROPERTY_EXTERNAL_REPO_ID)
    @Schema(example = "1")
    private String externalRepoId;

    public static final String JSON_PROPERTY_FAILED_SYNC_COUNT = "failedSyncCount";
    @JsonbProperty(JSON_PROPERTY_FAILED_SYNC_COUNT)
    @Schema(example = "1")
    private Integer failedSyncCount;

    public static final String JSON_PROPERTY_HASHES = "hashes";
    @JsonbProperty(JSON_PROPERTY_HASHES)
    private RestMirrorRepositorySynchronizationStatusHashes hashes;

    public static final String JSON_PROPERTY_INITIAL_SYNC_DATE = "initialSyncDate";
    @JsonbProperty(JSON_PROPERTY_INITIAL_SYNC_DATE)
    private OffsetDateTime initialSyncDate;

    public static final String JSON_PROPERTY_LAST_SYNC_DATE = "lastSyncDate";
    @JsonbProperty(JSON_PROPERTY_LAST_SYNC_DATE)
    private OffsetDateTime lastSyncDate;

    public static final String JSON_PROPERTY_LOCAL_PROJECT_ID = "localProjectId";
    @JsonbProperty(JSON_PROPERTY_LOCAL_PROJECT_ID)
    @Schema(example = "1")
    private Integer localProjectId;

    public static final String JSON_PROPERTY_LOCAL_REPO_ID = "localRepoId";
    @JsonbProperty(JSON_PROPERTY_LOCAL_REPO_ID)
    @Schema(example = "1")
    private Integer localRepoId;

    public static final String JSON_PROPERTY_UPSTREAM_ID = "upstreamId";
    @JsonbProperty(JSON_PROPERTY_UPSTREAM_ID)
    @Schema(example = "148728f5-df0f-3f3e-af11-5ca16be3725f")
    private String upstreamId;

    public RestMirrorRepositorySynchronizationStatus externalRepoId(String externalRepoId) {
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

    public RestMirrorRepositorySynchronizationStatus failedSyncCount(Integer failedSyncCount) {
        this.failedSyncCount = failedSyncCount;
        return this;
    }

    /**
     * Get failedSyncCount
     *
     * @return failedSyncCount
     **/
    public Integer getFailedSyncCount() {
        return failedSyncCount;
    }

    public void setFailedSyncCount(Integer failedSyncCount) {
        this.failedSyncCount = failedSyncCount;
    }

    public RestMirrorRepositorySynchronizationStatus hashes(RestMirrorRepositorySynchronizationStatusHashes hashes) {
        this.hashes = hashes;
        return this;
    }

    /**
     * Get hashes
     *
     * @return hashes
     **/
    @Valid
    public RestMirrorRepositorySynchronizationStatusHashes getHashes() {
        return hashes;
    }

    public void setHashes(RestMirrorRepositorySynchronizationStatusHashes hashes) {
        this.hashes = hashes;
    }

    public RestMirrorRepositorySynchronizationStatus initialSyncDate(OffsetDateTime initialSyncDate) {
        this.initialSyncDate = initialSyncDate;
        return this;
    }

    /**
     * Get initialSyncDate
     *
     * @return initialSyncDate
     **/
    public OffsetDateTime getInitialSyncDate() {
        return initialSyncDate;
    }

    public void setInitialSyncDate(OffsetDateTime initialSyncDate) {
        this.initialSyncDate = initialSyncDate;
    }

    public RestMirrorRepositorySynchronizationStatus lastSyncDate(OffsetDateTime lastSyncDate) {
        this.lastSyncDate = lastSyncDate;
        return this;
    }

    /**
     * Get lastSyncDate
     *
     * @return lastSyncDate
     **/
    public OffsetDateTime getLastSyncDate() {
        return lastSyncDate;
    }

    public void setLastSyncDate(OffsetDateTime lastSyncDate) {
        this.lastSyncDate = lastSyncDate;
    }

    public RestMirrorRepositorySynchronizationStatus localProjectId(Integer localProjectId) {
        this.localProjectId = localProjectId;
        return this;
    }

    /**
     * Get localProjectId
     *
     * @return localProjectId
     **/
    public Integer getLocalProjectId() {
        return localProjectId;
    }

    public void setLocalProjectId(Integer localProjectId) {
        this.localProjectId = localProjectId;
    }

    public RestMirrorRepositorySynchronizationStatus localRepoId(Integer localRepoId) {
        this.localRepoId = localRepoId;
        return this;
    }

    /**
     * Get localRepoId
     *
     * @return localRepoId
     **/
    public Integer getLocalRepoId() {
        return localRepoId;
    }

    public void setLocalRepoId(Integer localRepoId) {
        this.localRepoId = localRepoId;
    }

    public RestMirrorRepositorySynchronizationStatus upstreamId(String upstreamId) {
        this.upstreamId = upstreamId;
        return this;
    }

    /**
     * Get upstreamId
     *
     * @return upstreamId
     **/
    public String getUpstreamId() {
        return upstreamId;
    }

    public void setUpstreamId(String upstreamId) {
        this.upstreamId = upstreamId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestMirrorRepositorySynchronizationStatus)) {
            return false;
        }
        RestMirrorRepositorySynchronizationStatus other = (RestMirrorRepositorySynchronizationStatus) o;
        return Objects.equals(this.externalRepoId, other.externalRepoId) &&
                Objects.equals(this.failedSyncCount, other.failedSyncCount) &&
                Objects.equals(this.hashes, other.hashes) &&
                Objects.equals(this.initialSyncDate, other.initialSyncDate) &&
                Objects.equals(this.lastSyncDate, other.lastSyncDate) &&
                Objects.equals(this.localProjectId, other.localProjectId) &&
                Objects.equals(this.localRepoId, other.localRepoId) &&
                Objects.equals(this.upstreamId, other.upstreamId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(externalRepoId, failedSyncCount, hashes, initialSyncDate, lastSyncDate, localProjectId, localRepoId,
                upstreamId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestMirrorRepositorySynchronizationStatus {");
        sb.append("\n    externalRepoId: ").append(toIndentedString(externalRepoId));
        sb.append("\n    failedSyncCount: ").append(toIndentedString(failedSyncCount));
        sb.append("\n    hashes: ").append(toIndentedString(hashes));
        sb.append("\n    initialSyncDate: ").append(toIndentedString(initialSyncDate));
        sb.append("\n    lastSyncDate: ").append(toIndentedString(lastSyncDate));
        sb.append("\n    localProjectId: ").append(toIndentedString(localProjectId));
        sb.append("\n    localRepoId: ").append(toIndentedString(localRepoId));
        sb.append("\n    upstreamId: ").append(toIndentedString(upstreamId));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
