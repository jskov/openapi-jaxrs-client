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
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * _RequestApiLatestMigrationMesh
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class _RequestApiLatestMigrationMesh {
    public static final String JSON_PROPERTY_ALL = "all";
    @JsonbProperty(JSON_PROPERTY_ALL)
    private Boolean all;

    public static final String JSON_PROPERTY_MAX_BYTES_PER_SECOND = "maxBytesPerSecond";
    @JsonbProperty(JSON_PROPERTY_MAX_BYTES_PER_SECOND)
    private _RequestApiLatestMigrationMeshMaxBytesPerSecond maxBytesPerSecond;

    public static final String JSON_PROPERTY_PROJECT_IDS = "projectIds";
    @JsonbProperty(JSON_PROPERTY_PROJECT_IDS)
    private Set<Integer> projectIds;

    public static final String JSON_PROPERTY_REPOSITORY_IDS = "repositoryIds";
    @JsonbProperty(JSON_PROPERTY_REPOSITORY_IDS)
    private Set<Integer> repositoryIds;

    public _RequestApiLatestMigrationMesh all(Boolean all) {
        this.all = all;
        return this;
    }

    /**
     * Get all
     *
     * @return all
     **/
    public Boolean isAll() {
        return all;
    }

    public void setAll(Boolean all) {
        this.all = all;
    }

    public _RequestApiLatestMigrationMesh maxBytesPerSecond(_RequestApiLatestMigrationMeshMaxBytesPerSecond maxBytesPerSecond) {
        this.maxBytesPerSecond = maxBytesPerSecond;
        return this;
    }

    /**
     * Get maxBytesPerSecond
     *
     * @return maxBytesPerSecond
     **/
    public @Valid _RequestApiLatestMigrationMeshMaxBytesPerSecond getMaxBytesPerSecond() {
        return maxBytesPerSecond;
    }

    public void setMaxBytesPerSecond(_RequestApiLatestMigrationMeshMaxBytesPerSecond maxBytesPerSecond) {
        this.maxBytesPerSecond = maxBytesPerSecond;
    }

    public _RequestApiLatestMigrationMesh projectIds(Set<Integer> projectIds) {
        this.projectIds = projectIds;
        return this;
    }

    public _RequestApiLatestMigrationMesh addProjectIdsItem(int projectIdsItem) {
        if (this.projectIds == null) {
            this.projectIds = new LinkedHashSet<>();
        }
        this.projectIds.add(projectIdsItem);
        return this;
    }

    /**
     * Get projectIds
     *
     * @return projectIds
     **/
    public Set<Integer> getProjectIds() {
        return projectIds;
    }

    public void setProjectIds(Set<Integer> projectIds) {
        this.projectIds = projectIds;
    }

    public _RequestApiLatestMigrationMesh repositoryIds(Set<Integer> repositoryIds) {
        this.repositoryIds = repositoryIds;
        return this;
    }

    public _RequestApiLatestMigrationMesh addRepositoryIdsItem(int repositoryIdsItem) {
        if (this.repositoryIds == null) {
            this.repositoryIds = new LinkedHashSet<>();
        }
        this.repositoryIds.add(repositoryIdsItem);
        return this;
    }

    /**
     * Get repositoryIds
     *
     * @return repositoryIds
     **/
    public Set<Integer> getRepositoryIds() {
        return repositoryIds;
    }

    public void setRepositoryIds(Set<Integer> repositoryIds) {
        this.repositoryIds = repositoryIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof _RequestApiLatestMigrationMesh)) {
            return false;
        }
        _RequestApiLatestMigrationMesh other = (_RequestApiLatestMigrationMesh) o;
        return Objects.equals(this.all, other.all) &&
                Objects.equals(this.maxBytesPerSecond, other.maxBytesPerSecond) &&
                Objects.equals(this.projectIds, other.projectIds) &&
                Objects.equals(this.repositoryIds, other.repositoryIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(all, maxBytesPerSecond, projectIds, repositoryIds);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class _RequestApiLatestMigrationMesh {");
        sb.append("\n    all: ").append(toIndentedString(all));
        sb.append("\n    maxBytesPerSecond: ").append(toIndentedString(maxBytesPerSecond));
        sb.append("\n    projectIds: ").append(toIndentedString(projectIds));
        sb.append("\n    repositoryIds: ").append(toIndentedString(repositoryIds));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
