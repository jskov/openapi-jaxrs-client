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
 * RestPullRequestSettings
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestPullRequestSettings {
    public static final String JSON_PROPERTY_MERGE_CONFIG = "mergeConfig";
    @JsonbProperty(JSON_PROPERTY_MERGE_CONFIG)
    private RestPullRequestSettingsMergeConfig mergeConfig;

    public RestPullRequestSettings mergeConfig(RestPullRequestSettingsMergeConfig mergeConfig) {
        this.mergeConfig = mergeConfig;
        return this;
    }

    /**
     * Get mergeConfig
     *
     * @return mergeConfig
     **/
    @Valid
    public RestPullRequestSettingsMergeConfig getMergeConfig() {
        return mergeConfig;
    }

    public void setMergeConfig(RestPullRequestSettingsMergeConfig mergeConfig) {
        this.mergeConfig = mergeConfig;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestPullRequestSettings)) {
            return false;
        }
        RestPullRequestSettings other = (RestPullRequestSettings) o;
        return Objects.equals(this.mergeConfig, other.mergeConfig);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mergeConfig);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestPullRequestSettings {");
        sb.append("\n    mergeConfig: ").append(toIndentedString(mergeConfig));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
