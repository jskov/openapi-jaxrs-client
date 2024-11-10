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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestRepositoryPullRequestSettingsMergeConfig
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestRepositoryPullRequestSettingsMergeConfig {
    public static final String JSON_PROPERTY_COMMIT_MESSAGE_TEMPLATE = "commitMessageTemplate";
    @JsonbProperty(JSON_PROPERTY_COMMIT_MESSAGE_TEMPLATE)
    private RestRepositoryPullRequestSettingsMergeConfigCommitMessageTemplate commitMessageTemplate;

    public static final String JSON_PROPERTY_COMMIT_SUMMARIES = "commitSummaries";
    @JsonbProperty(JSON_PROPERTY_COMMIT_SUMMARIES)
    private Integer commitSummaries;

    public static final String JSON_PROPERTY_DEFAULT_STRATEGY = "defaultStrategy";
    @JsonbProperty(JSON_PROPERTY_DEFAULT_STRATEGY)
    private RestRepositoryPullRequestSettingsMergeConfigDefaultStrategy defaultStrategy;

    public static final String JSON_PROPERTY_STRATEGIES = "strategies";
    @JsonbProperty(JSON_PROPERTY_STRATEGIES)
    private List<RestPullRequestMergeStrategy> strategies;

    public static final String JSON_PROPERTY_TYPE = "type";
    @JsonbProperty(JSON_PROPERTY_TYPE)
    @Schema(readOnly = true, example = "repository")
    private String type;

    public RestRepositoryPullRequestSettingsMergeConfig commitMessageTemplate(RestRepositoryPullRequestSettingsMergeConfigCommitMessageTemplate commitMessageTemplate) {
        this.commitMessageTemplate = commitMessageTemplate;
        return this;
    }

    /**
     * Get commitMessageTemplate
     *
     * @return commitMessageTemplate
     **/
    public @Valid RestRepositoryPullRequestSettingsMergeConfigCommitMessageTemplate getCommitMessageTemplate() {
        return commitMessageTemplate;
    }

    public void setCommitMessageTemplate(RestRepositoryPullRequestSettingsMergeConfigCommitMessageTemplate commitMessageTemplate) {
        this.commitMessageTemplate = commitMessageTemplate;
    }

    public RestRepositoryPullRequestSettingsMergeConfig commitSummaries(Integer commitSummaries) {
        this.commitSummaries = commitSummaries;
        return this;
    }

    /**
     * Get commitSummaries
     *
     * @return commitSummaries
     **/
    public Integer getCommitSummaries() {
        return commitSummaries;
    }

    public void setCommitSummaries(Integer commitSummaries) {
        this.commitSummaries = commitSummaries;
    }

    public RestRepositoryPullRequestSettingsMergeConfig defaultStrategy(RestRepositoryPullRequestSettingsMergeConfigDefaultStrategy defaultStrategy) {
        this.defaultStrategy = defaultStrategy;
        return this;
    }

    /**
     * Get defaultStrategy
     *
     * @return defaultStrategy
     **/
    public @Valid RestRepositoryPullRequestSettingsMergeConfigDefaultStrategy getDefaultStrategy() {
        return defaultStrategy;
    }

    public void setDefaultStrategy(RestRepositoryPullRequestSettingsMergeConfigDefaultStrategy defaultStrategy) {
        this.defaultStrategy = defaultStrategy;
    }

    public RestRepositoryPullRequestSettingsMergeConfig strategies(List<RestPullRequestMergeStrategy> strategies) {
        this.strategies = strategies;
        return this;
    }

    public RestRepositoryPullRequestSettingsMergeConfig addStrategiesItem(RestPullRequestMergeStrategy strategiesItem) {
        if (this.strategies == null) {
            this.strategies = new ArrayList<>();
        }
        this.strategies.add(strategiesItem);
        return this;
    }

    /**
     * Get strategies
     *
     * @return strategies
     **/
    public @Valid List<RestPullRequestMergeStrategy> getStrategies() {
        return strategies;
    }

    public void setStrategies(List<RestPullRequestMergeStrategy> strategies) {
        this.strategies = strategies;
    }

    public RestRepositoryPullRequestSettingsMergeConfig type(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     **/
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestRepositoryPullRequestSettingsMergeConfig)) {
            return false;
        }
        RestRepositoryPullRequestSettingsMergeConfig other = (RestRepositoryPullRequestSettingsMergeConfig) o;
        return Objects.equals(this.commitMessageTemplate, other.commitMessageTemplate) &&
                Objects.equals(this.commitSummaries, other.commitSummaries) &&
                Objects.equals(this.defaultStrategy, other.defaultStrategy) &&
                Objects.equals(this.strategies, other.strategies) &&
                Objects.equals(this.type, other.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commitMessageTemplate, commitSummaries, defaultStrategy, strategies, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestRepositoryPullRequestSettingsMergeConfig {");
        sb.append("\n    commitMessageTemplate: ").append(toIndentedString(commitMessageTemplate));
        sb.append("\n    commitSummaries: ").append(toIndentedString(commitSummaries));
        sb.append("\n    defaultStrategy: ").append(toIndentedString(defaultStrategy));
        sb.append("\n    strategies: ").append(toIndentedString(strategies));
        sb.append("\n    type: ").append(toIndentedString(type));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
