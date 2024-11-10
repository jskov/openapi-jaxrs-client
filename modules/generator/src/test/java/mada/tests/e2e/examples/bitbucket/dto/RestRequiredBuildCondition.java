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
 * RestRequiredBuildCondition
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestRequiredBuildCondition {
    public static final String JSON_PROPERTY_BUILD_PARENT_KEYS = "buildParentKeys";
    @JsonbProperty(JSON_PROPERTY_BUILD_PARENT_KEYS)
    @Schema(
            description = "A non-empty list of build parent keys that require green builds for this merge check to pass",
            example = "[\"build-key-1\",\"build-key-2\"]")
    private List<String> buildParentKeys;

    public static final String JSON_PROPERTY_EXEMPT_REF_MATCHER = "exemptRefMatcher";
    @JsonbProperty(JSON_PROPERTY_EXEMPT_REF_MATCHER)
    private RestRequiredBuildConditionExemptRefMatcher exemptRefMatcher;

    public static final String JSON_PROPERTY_ID = "id";
    @JsonbProperty(JSON_PROPERTY_ID)
    @Schema(example = "15")
    private Long id;

    public static final String JSON_PROPERTY_REF_MATCHER = "refMatcher";
    @JsonbProperty(JSON_PROPERTY_REF_MATCHER)
    private RestRequiredBuildConditionRefMatcher refMatcher;

    public RestRequiredBuildCondition buildParentKeys(List<String> buildParentKeys) {
        this.buildParentKeys = buildParentKeys;
        return this;
    }

    public RestRequiredBuildCondition addBuildParentKeysItem(String buildParentKeysItem) {
        if (this.buildParentKeys == null) {
            this.buildParentKeys = new ArrayList<>();
        }
        this.buildParentKeys.add(buildParentKeysItem);
        return this;
    }

    /**
     * A non-empty list of build parent keys that require green builds for this merge check to pass.
     * 
     * @return buildParentKeys
     **/
    public List<String> getBuildParentKeys() {
        return buildParentKeys;
    }

    public void setBuildParentKeys(List<String> buildParentKeys) {
        this.buildParentKeys = buildParentKeys;
    }

    public RestRequiredBuildCondition exemptRefMatcher(RestRequiredBuildConditionExemptRefMatcher exemptRefMatcher) {
        this.exemptRefMatcher = exemptRefMatcher;
        return this;
    }

    /**
     * Get exemptRefMatcher
     *
     * @return exemptRefMatcher
     **/
    @Valid
    public RestRequiredBuildConditionExemptRefMatcher getExemptRefMatcher() {
        return exemptRefMatcher;
    }

    public void setExemptRefMatcher(RestRequiredBuildConditionExemptRefMatcher exemptRefMatcher) {
        this.exemptRefMatcher = exemptRefMatcher;
    }

    public RestRequiredBuildCondition id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RestRequiredBuildCondition refMatcher(RestRequiredBuildConditionRefMatcher refMatcher) {
        this.refMatcher = refMatcher;
        return this;
    }

    /**
     * Get refMatcher
     *
     * @return refMatcher
     **/
    @Valid
    public RestRequiredBuildConditionRefMatcher getRefMatcher() {
        return refMatcher;
    }

    public void setRefMatcher(RestRequiredBuildConditionRefMatcher refMatcher) {
        this.refMatcher = refMatcher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestRequiredBuildCondition)) {
            return false;
        }
        RestRequiredBuildCondition other = (RestRequiredBuildCondition) o;
        return Objects.equals(this.buildParentKeys, other.buildParentKeys) &&
                Objects.equals(this.exemptRefMatcher, other.exemptRefMatcher) &&
                Objects.equals(this.id, other.id) &&
                Objects.equals(this.refMatcher, other.refMatcher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buildParentKeys, exemptRefMatcher, id, refMatcher);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestRequiredBuildCondition {");
        sb.append("\n    buildParentKeys: ").append(toIndentedString(buildParentKeys));
        sb.append("\n    exemptRefMatcher: ").append(toIndentedString(exemptRefMatcher));
        sb.append("\n    id: ").append(toIndentedString(id));
        sb.append("\n    refMatcher: ").append(toIndentedString(refMatcher));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
