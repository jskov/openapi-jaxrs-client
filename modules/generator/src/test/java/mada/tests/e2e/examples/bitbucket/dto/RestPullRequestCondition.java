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
 * RestPullRequestCondition
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestPullRequestCondition {
    public static final String JSON_PROPERTY_ID = "id";
    @JsonbProperty(JSON_PROPERTY_ID)
    @Schema(readOnly = true, example = "1")
    private Integer id;

    public static final String JSON_PROPERTY_REQUIRED_APPROVALS = "requiredApprovals";
    @JsonbProperty(JSON_PROPERTY_REQUIRED_APPROVALS)
    @Schema(example = "1")
    private Integer requiredApprovals;

    public static final String JSON_PROPERTY_REVIEWERS = "reviewers";
    @JsonbProperty(JSON_PROPERTY_REVIEWERS)
    private List<RestApplicationUser> reviewers;

    public static final String JSON_PROPERTY_SCOPE = "scope";
    @JsonbProperty(JSON_PROPERTY_SCOPE)
    @Schema(readOnly = true)
    private RestPullRequestConditionScope scope;

    public static final String JSON_PROPERTY_SOURCE_REF_MATCHER = "sourceRefMatcher";
    @JsonbProperty(JSON_PROPERTY_SOURCE_REF_MATCHER)
    private RestPullRequestConditionSourceRefMatcher sourceRefMatcher;

    public static final String JSON_PROPERTY_TARGET_REF_MATCHER = "targetRefMatcher";
    @JsonbProperty(JSON_PROPERTY_TARGET_REF_MATCHER)
    private RestPullRequestConditionTargetRefMatcher targetRefMatcher;

    public RestPullRequestCondition id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RestPullRequestCondition requiredApprovals(Integer requiredApprovals) {
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

    public RestPullRequestCondition reviewers(List<RestApplicationUser> reviewers) {
        this.reviewers = reviewers;
        return this;
    }

    public RestPullRequestCondition addReviewersItem(RestApplicationUser reviewersItem) {
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
    public @Valid List<RestApplicationUser> getReviewers() {
        return reviewers;
    }

    public void setReviewers(List<RestApplicationUser> reviewers) {
        this.reviewers = reviewers;
    }

    public RestPullRequestCondition scope(RestPullRequestConditionScope scope) {
        this.scope = scope;
        return this;
    }

    /**
     * Get scope
     *
     * @return scope
     **/
    public @Valid RestPullRequestConditionScope getScope() {
        return scope;
    }

    public void setScope(RestPullRequestConditionScope scope) {
        this.scope = scope;
    }

    public RestPullRequestCondition sourceRefMatcher(RestPullRequestConditionSourceRefMatcher sourceRefMatcher) {
        this.sourceRefMatcher = sourceRefMatcher;
        return this;
    }

    /**
     * Get sourceRefMatcher
     *
     * @return sourceRefMatcher
     **/
    public @Valid RestPullRequestConditionSourceRefMatcher getSourceRefMatcher() {
        return sourceRefMatcher;
    }

    public void setSourceRefMatcher(RestPullRequestConditionSourceRefMatcher sourceRefMatcher) {
        this.sourceRefMatcher = sourceRefMatcher;
    }

    public RestPullRequestCondition targetRefMatcher(RestPullRequestConditionTargetRefMatcher targetRefMatcher) {
        this.targetRefMatcher = targetRefMatcher;
        return this;
    }

    /**
     * Get targetRefMatcher
     *
     * @return targetRefMatcher
     **/
    public @Valid RestPullRequestConditionTargetRefMatcher getTargetRefMatcher() {
        return targetRefMatcher;
    }

    public void setTargetRefMatcher(RestPullRequestConditionTargetRefMatcher targetRefMatcher) {
        this.targetRefMatcher = targetRefMatcher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestPullRequestCondition)) {
            return false;
        }
        RestPullRequestCondition other = (RestPullRequestCondition) o;
        return Objects.equals(this.id, other.id) &&
                Objects.equals(this.requiredApprovals, other.requiredApprovals) &&
                Objects.equals(this.reviewers, other.reviewers) &&
                Objects.equals(this.scope, other.scope) &&
                Objects.equals(this.sourceRefMatcher, other.sourceRefMatcher) &&
                Objects.equals(this.targetRefMatcher, other.targetRefMatcher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, requiredApprovals, reviewers, scope, sourceRefMatcher, targetRefMatcher);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestPullRequestCondition {");
        sb.append("\n    id: ").append(toIndentedString(id));
        sb.append("\n    requiredApprovals: ").append(toIndentedString(requiredApprovals));
        sb.append("\n    reviewers: ").append(toIndentedString(reviewers));
        sb.append("\n    scope: ").append(toIndentedString(scope));
        sb.append("\n    sourceRefMatcher: ").append(toIndentedString(sourceRefMatcher));
        sb.append("\n    targetRefMatcher: ").append(toIndentedString(targetRefMatcher));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
