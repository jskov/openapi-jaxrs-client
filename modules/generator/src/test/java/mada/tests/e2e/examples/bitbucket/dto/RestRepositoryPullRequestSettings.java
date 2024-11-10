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
import java.util.Objects;

/**
 * RestRepositoryPullRequestSettings
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestRepositoryPullRequestSettings {
    public static final String JSON_PROPERTY_MERGE_CONFIG = "mergeConfig";
    @JsonbProperty(JSON_PROPERTY_MERGE_CONFIG)
    private RestRepositoryPullRequestSettingsMergeConfig mergeConfig;

    public static final String JSON_PROPERTY_REQUIRED_ALL_APPROVERS = "requiredAllApprovers";
    @JsonbProperty(JSON_PROPERTY_REQUIRED_ALL_APPROVERS)
    private Boolean requiredAllApprovers;

    public static final String JSON_PROPERTY_REQUIRED_ALL_TASKS_COMPLETE = "requiredAllTasksComplete";
    @JsonbProperty(JSON_PROPERTY_REQUIRED_ALL_TASKS_COMPLETE)
    private Boolean requiredAllTasksComplete;

    public static final String JSON_PROPERTY_REQUIRED_APPROVERS = "requiredApprovers";
    @JsonbProperty(JSON_PROPERTY_REQUIRED_APPROVERS)
    private RestRepositoryPullRequestSettingsRequiredApprovers requiredApprovers;

    public static final String JSON_PROPERTY_REQUIRED_APPROVERS_DEPRECATED = "requiredApproversDeprecated";
    @JsonbProperty(JSON_PROPERTY_REQUIRED_APPROVERS_DEPRECATED)
    private Integer requiredApproversDeprecated;

    public static final String JSON_PROPERTY_REQUIRED_SUCCESSFUL_BUILDS = "requiredSuccessfulBuilds";
    @JsonbProperty(JSON_PROPERTY_REQUIRED_SUCCESSFUL_BUILDS)
    private RestRepositoryPullRequestSettingsRequiredSuccessfulBuilds requiredSuccessfulBuilds;

    public static final String JSON_PROPERTY_REQUIRED_SUCCESSFUL_BUILDS_DEPRECATED = "requiredSuccessfulBuildsDeprecated";
    @JsonbProperty(JSON_PROPERTY_REQUIRED_SUCCESSFUL_BUILDS_DEPRECATED)
    private Integer requiredSuccessfulBuildsDeprecated;

    public RestRepositoryPullRequestSettings mergeConfig(RestRepositoryPullRequestSettingsMergeConfig mergeConfig) {
        this.mergeConfig = mergeConfig;
        return this;
    }

    /**
     * Get mergeConfig
     *
     * @return mergeConfig
     **/
    @Valid public RestRepositoryPullRequestSettingsMergeConfig getMergeConfig() {
        return mergeConfig;
    }

    public void setMergeConfig(RestRepositoryPullRequestSettingsMergeConfig mergeConfig) {
        this.mergeConfig = mergeConfig;
    }

    public RestRepositoryPullRequestSettings requiredAllApprovers(Boolean requiredAllApprovers) {
        this.requiredAllApprovers = requiredAllApprovers;
        return this;
    }

    /**
     * Get requiredAllApprovers
     *
     * @return requiredAllApprovers
     **/
    public Boolean isRequiredAllApprovers() {
        return requiredAllApprovers;
    }

    public void setRequiredAllApprovers(Boolean requiredAllApprovers) {
        this.requiredAllApprovers = requiredAllApprovers;
    }

    public RestRepositoryPullRequestSettings requiredAllTasksComplete(Boolean requiredAllTasksComplete) {
        this.requiredAllTasksComplete = requiredAllTasksComplete;
        return this;
    }

    /**
     * Get requiredAllTasksComplete
     *
     * @return requiredAllTasksComplete
     **/
    public Boolean isRequiredAllTasksComplete() {
        return requiredAllTasksComplete;
    }

    public void setRequiredAllTasksComplete(Boolean requiredAllTasksComplete) {
        this.requiredAllTasksComplete = requiredAllTasksComplete;
    }

    public RestRepositoryPullRequestSettings requiredApprovers(RestRepositoryPullRequestSettingsRequiredApprovers requiredApprovers) {
        this.requiredApprovers = requiredApprovers;
        return this;
    }

    /**
     * Get requiredApprovers
     *
     * @return requiredApprovers
     **/
    @Valid public RestRepositoryPullRequestSettingsRequiredApprovers getRequiredApprovers() {
        return requiredApprovers;
    }

    public void setRequiredApprovers(RestRepositoryPullRequestSettingsRequiredApprovers requiredApprovers) {
        this.requiredApprovers = requiredApprovers;
    }

    public RestRepositoryPullRequestSettings requiredApproversDeprecated(Integer requiredApproversDeprecated) {
        this.requiredApproversDeprecated = requiredApproversDeprecated;
        return this;
    }

    /**
     * Get requiredApproversDeprecated
     *
     * @return requiredApproversDeprecated
     **/
    public Integer getRequiredApproversDeprecated() {
        return requiredApproversDeprecated;
    }

    public void setRequiredApproversDeprecated(Integer requiredApproversDeprecated) {
        this.requiredApproversDeprecated = requiredApproversDeprecated;
    }

    public RestRepositoryPullRequestSettings requiredSuccessfulBuilds(RestRepositoryPullRequestSettingsRequiredSuccessfulBuilds requiredSuccessfulBuilds) {
        this.requiredSuccessfulBuilds = requiredSuccessfulBuilds;
        return this;
    }

    /**
     * Get requiredSuccessfulBuilds
     *
     * @return requiredSuccessfulBuilds
     **/
    @Valid public RestRepositoryPullRequestSettingsRequiredSuccessfulBuilds getRequiredSuccessfulBuilds() {
        return requiredSuccessfulBuilds;
    }

    public void setRequiredSuccessfulBuilds(RestRepositoryPullRequestSettingsRequiredSuccessfulBuilds requiredSuccessfulBuilds) {
        this.requiredSuccessfulBuilds = requiredSuccessfulBuilds;
    }

    public RestRepositoryPullRequestSettings requiredSuccessfulBuildsDeprecated(Integer requiredSuccessfulBuildsDeprecated) {
        this.requiredSuccessfulBuildsDeprecated = requiredSuccessfulBuildsDeprecated;
        return this;
    }

    /**
     * Get requiredSuccessfulBuildsDeprecated
     *
     * @return requiredSuccessfulBuildsDeprecated
     **/
    public Integer getRequiredSuccessfulBuildsDeprecated() {
        return requiredSuccessfulBuildsDeprecated;
    }

    public void setRequiredSuccessfulBuildsDeprecated(Integer requiredSuccessfulBuildsDeprecated) {
        this.requiredSuccessfulBuildsDeprecated = requiredSuccessfulBuildsDeprecated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestRepositoryPullRequestSettings)) {
            return false;
        }
        RestRepositoryPullRequestSettings other = (RestRepositoryPullRequestSettings) o;
        return Objects.equals(this.mergeConfig, other.mergeConfig) &&
                Objects.equals(this.requiredAllApprovers, other.requiredAllApprovers) &&
                Objects.equals(this.requiredAllTasksComplete, other.requiredAllTasksComplete) &&
                Objects.equals(this.requiredApprovers, other.requiredApprovers) &&
                Objects.equals(this.requiredApproversDeprecated, other.requiredApproversDeprecated) &&
                Objects.equals(this.requiredSuccessfulBuilds, other.requiredSuccessfulBuilds) &&
                Objects.equals(this.requiredSuccessfulBuildsDeprecated, other.requiredSuccessfulBuildsDeprecated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mergeConfig, requiredAllApprovers, requiredAllTasksComplete, requiredApprovers, requiredApproversDeprecated, requiredSuccessfulBuilds, requiredSuccessfulBuildsDeprecated);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestRepositoryPullRequestSettings {");
        sb.append("\n    mergeConfig: ").append(toIndentedString(mergeConfig));
        sb.append("\n    requiredAllApprovers: ").append(toIndentedString(requiredAllApprovers));
        sb.append("\n    requiredAllTasksComplete: ").append(toIndentedString(requiredAllTasksComplete));
        sb.append("\n    requiredApprovers: ").append(toIndentedString(requiredApprovers));
        sb.append("\n    requiredApproversDeprecated: ").append(toIndentedString(requiredApproversDeprecated));
        sb.append("\n    requiredSuccessfulBuilds: ").append(toIndentedString(requiredSuccessfulBuilds));
        sb.append("\n    requiredSuccessfulBuildsDeprecated: ").append(toIndentedString(requiredSuccessfulBuildsDeprecated));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
