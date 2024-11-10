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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * RestBuildCapabilities
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestBuildCapabilities {
    public static final String JSON_PROPERTY_BUILD_STATUS = "buildStatus";
    @JsonbProperty(JSON_PROPERTY_BUILD_STATUS)
    private List<String> buildStatus;

    public RestBuildCapabilities buildStatus(List<String> buildStatus) {
        this.buildStatus = buildStatus;
        return this;
    }

    public RestBuildCapabilities addBuildStatusItem(String buildStatusItem) {
        if (this.buildStatus == null) {
            this.buildStatus = new ArrayList<>();
        }
        this.buildStatus.add(buildStatusItem);
        return this;
    }

    /**
     * Get buildStatus
     *
     * @return buildStatus
     **/
    public List<String> getBuildStatus() {
        return buildStatus;
    }

    public void setBuildStatus(List<String> buildStatus) {
        this.buildStatus = buildStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestBuildCapabilities)) {
            return false;
        }
        RestBuildCapabilities other = (RestBuildCapabilities) o;
        return Objects.equals(this.buildStatus, other.buildStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(buildStatus);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestBuildCapabilities {");
        sb.append("\n    buildStatus: ").append(toIndentedString(buildStatus));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
