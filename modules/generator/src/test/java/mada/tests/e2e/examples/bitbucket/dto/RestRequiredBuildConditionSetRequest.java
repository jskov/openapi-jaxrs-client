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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestRequiredBuildConditionSetRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestRequiredBuildConditionSetRequest {
    public static final String JSON_PROPERTY_BUILD_PARENT_KEYS = "buildParentKeys";
    @JsonbProperty(JSON_PROPERTY_BUILD_PARENT_KEYS)
    @Schema(required = true, description = "A non-empty list of build parent keys that require green builds for this merge check to pass", example = "[\"build-key-1\",\"build-key-2\"]")
    private List<String> buildParentKeys = new ArrayList<>();

    public static final String JSON_PROPERTY_EXEMPT_REF_MATCHER = "exemptRefMatcher";
    @JsonbProperty(JSON_PROPERTY_EXEMPT_REF_MATCHER)
    private RestRefMatcher exemptRefMatcher;

    public static final String JSON_PROPERTY_REF_MATCHER = "refMatcher";
    @JsonbProperty(JSON_PROPERTY_REF_MATCHER)
    @Schema(required = true)
    private RestRequiredBuildConditionSetRequestRefMatcher refMatcher;

    public RestRequiredBuildConditionSetRequest buildParentKeys(List<String> buildParentKeys) {
        this.buildParentKeys = Objects.requireNonNull(buildParentKeys, "Property buildParentKeys is required, cannot be null");
        return this;
    }

    public RestRequiredBuildConditionSetRequest addBuildParentKeysItem(String buildParentKeysItem) {
        this.buildParentKeys.add(buildParentKeysItem);
        return this;
    }

    /**
     * A non-empty list of build parent keys that require green builds for this merge check to pass.
     * @return buildParentKeys
     **/
    public @NotNull @Size(min = 0, max = 100) List<String> getBuildParentKeys() {
        return buildParentKeys;
    }

    public void setBuildParentKeys(List<String> buildParentKeys) {
        this.buildParentKeys = Objects.requireNonNull(buildParentKeys, "Property buildParentKeys is required, cannot be null");
    }

    public RestRequiredBuildConditionSetRequest exemptRefMatcher(RestRefMatcher exemptRefMatcher) {
        this.exemptRefMatcher = exemptRefMatcher;
        return this;
    }

    /**
     * Get exemptRefMatcher
     *
     * @return exemptRefMatcher
     **/
    public @Valid RestRefMatcher getExemptRefMatcher() {
        return exemptRefMatcher;
    }

    public void setExemptRefMatcher(RestRefMatcher exemptRefMatcher) {
        this.exemptRefMatcher = exemptRefMatcher;
    }

    public RestRequiredBuildConditionSetRequest refMatcher(RestRequiredBuildConditionSetRequestRefMatcher refMatcher) {
        this.refMatcher = Objects.requireNonNull(refMatcher, "Property refMatcher is required, cannot be null");
        return this;
    }

    /**
     * Get refMatcher
     *
     * @return refMatcher
     **/
    public @NotNull @Valid RestRequiredBuildConditionSetRequestRefMatcher getRefMatcher() {
        return refMatcher;
    }

    public void setRefMatcher(RestRequiredBuildConditionSetRequestRefMatcher refMatcher) {
        this.refMatcher = Objects.requireNonNull(refMatcher, "Property refMatcher is required, cannot be null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestRequiredBuildConditionSetRequest)) {
            return false;
        }
        RestRequiredBuildConditionSetRequest other = (RestRequiredBuildConditionSetRequest) o;
        return Objects.equals(this.buildParentKeys, other.buildParentKeys) &&
                Objects.equals(this.exemptRefMatcher, other.exemptRefMatcher) &&
                Objects.equals(this.refMatcher, other.refMatcher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buildParentKeys, exemptRefMatcher, refMatcher);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestRequiredBuildConditionSetRequest {");
        sb.append("\n    buildParentKeys: ").append(toIndentedString(buildParentKeys));
        sb.append("\n    exemptRefMatcher: ").append(toIndentedString(exemptRefMatcher));
        sb.append("\n    refMatcher: ").append(toIndentedString(refMatcher));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
