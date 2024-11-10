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
 * _RequestDefaultReviewersLatestProjectsProjectKeyReposRepositorySlugConditionId
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class _RequestDefaultReviewersLatestProjectsProjectKeyReposRepositorySlugConditionId {
    public static final String JSON_PROPERTY_REQUIRED_APPROVALS = "requiredApprovals";
    @JsonbProperty(JSON_PROPERTY_REQUIRED_APPROVALS)
    @Schema(example = "1")
    private Integer requiredApprovals;

    public static final String JSON_PROPERTY_REVIEWERS = "reviewers";
    @JsonbProperty(JSON_PROPERTY_REVIEWERS)
    private List<RestApplicationUser> reviewers;

    public static final String JSON_PROPERTY_SOURCE_MATCHER = "sourceMatcher";
    @JsonbProperty(JSON_PROPERTY_SOURCE_MATCHER)
    private _RequestDefaultReviewersLatestProjectsProjectKeyReposRepositorySlugConditionIdSourceMatcher sourceMatcher;

    public static final String JSON_PROPERTY_TARGET_MATCHER = "targetMatcher";
    @JsonbProperty(JSON_PROPERTY_TARGET_MATCHER)
    private _RequestDefaultReviewersLatestProjectsProjectKeyReposRepositorySlugConditionIdTargetMatcher targetMatcher;

    public _RequestDefaultReviewersLatestProjectsProjectKeyReposRepositorySlugConditionId requiredApprovals(Integer requiredApprovals) {
        this.requiredApprovals = requiredApprovals;
        return this;
    }

    /**
     * Get requiredApprovals
     *
     * @return requiredApprovals
     **/
    public Integer getRequiredApprovals() {
        return requiredApprovals;
    }

    public void setRequiredApprovals(Integer requiredApprovals) {
        this.requiredApprovals = requiredApprovals;
    }

    public _RequestDefaultReviewersLatestProjectsProjectKeyReposRepositorySlugConditionId reviewers(List<RestApplicationUser> reviewers) {
        this.reviewers = reviewers;
        return this;
    }

    public _RequestDefaultReviewersLatestProjectsProjectKeyReposRepositorySlugConditionId addReviewersItem(
            RestApplicationUser reviewersItem) {
        if (this.reviewers == null) {
            this.reviewers = new ArrayList<>();
        }
        this.reviewers.add(reviewersItem);
        return this;
    }

    /**
     * Get reviewers
     *
     * @return reviewers
     **/
    @Valid
    public List<RestApplicationUser> getReviewers() {
        return reviewers;
    }

    public void setReviewers(List<RestApplicationUser> reviewers) {
        this.reviewers = reviewers;
    }

    public _RequestDefaultReviewersLatestProjectsProjectKeyReposRepositorySlugConditionId sourceMatcher(
            _RequestDefaultReviewersLatestProjectsProjectKeyReposRepositorySlugConditionIdSourceMatcher sourceMatcher) {
        this.sourceMatcher = sourceMatcher;
        return this;
    }

    /**
     * Get sourceMatcher
     *
     * @return sourceMatcher
     **/
    @Valid
    public _RequestDefaultReviewersLatestProjectsProjectKeyReposRepositorySlugConditionIdSourceMatcher getSourceMatcher() {
        return sourceMatcher;
    }

    public void setSourceMatcher(
            _RequestDefaultReviewersLatestProjectsProjectKeyReposRepositorySlugConditionIdSourceMatcher sourceMatcher) {
        this.sourceMatcher = sourceMatcher;
    }

    public _RequestDefaultReviewersLatestProjectsProjectKeyReposRepositorySlugConditionId targetMatcher(
            _RequestDefaultReviewersLatestProjectsProjectKeyReposRepositorySlugConditionIdTargetMatcher targetMatcher) {
        this.targetMatcher = targetMatcher;
        return this;
    }

    /**
     * Get targetMatcher
     *
     * @return targetMatcher
     **/
    @Valid
    public _RequestDefaultReviewersLatestProjectsProjectKeyReposRepositorySlugConditionIdTargetMatcher getTargetMatcher() {
        return targetMatcher;
    }

    public void setTargetMatcher(
            _RequestDefaultReviewersLatestProjectsProjectKeyReposRepositorySlugConditionIdTargetMatcher targetMatcher) {
        this.targetMatcher = targetMatcher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof _RequestDefaultReviewersLatestProjectsProjectKeyReposRepositorySlugConditionId)) {
            return false;
        }
        _RequestDefaultReviewersLatestProjectsProjectKeyReposRepositorySlugConditionId other = (_RequestDefaultReviewersLatestProjectsProjectKeyReposRepositorySlugConditionId) o;
        return Objects.equals(this.requiredApprovals, other.requiredApprovals) &&
                Objects.equals(this.reviewers, other.reviewers) &&
                Objects.equals(this.sourceMatcher, other.sourceMatcher) &&
                Objects.equals(this.targetMatcher, other.targetMatcher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requiredApprovals, reviewers, sourceMatcher, targetMatcher);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class _RequestDefaultReviewersLatestProjectsProjectKeyReposRepositorySlugConditionId {");
        sb.append("\n    requiredApprovals: ").append(toIndentedString(requiredApprovals));
        sb.append("\n    reviewers: ").append(toIndentedString(reviewers));
        sb.append("\n    sourceMatcher: ").append(toIndentedString(sourceMatcher));
        sb.append("\n    targetMatcher: ").append(toIndentedString(targetMatcher));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
