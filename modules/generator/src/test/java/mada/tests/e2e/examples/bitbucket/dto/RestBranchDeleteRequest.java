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
import jakarta.validation.constraints.Size;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestBranchDeleteRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestBranchDeleteRequest {
    public static final String JSON_PROPERTY_DRY_RUN = "dryRun";
    @JsonbProperty(JSON_PROPERTY_DRY_RUN)
    @Schema(description = "Don't actually delete the ref name, just do a dry run")
    private Boolean dryRun;

    public static final String JSON_PROPERTY_END_POINT = "endPoint";
    @JsonbProperty(JSON_PROPERTY_END_POINT)
    @Schema(description = "Commit ID that the provided ref name is expected to point to")
    private String endPoint;

    public static final String JSON_PROPERTY_NAME = "name";
    @JsonbProperty(JSON_PROPERTY_NAME)
    @Schema(description = "Name of the ref to be deleted")
    private String name;

    public RestBranchDeleteRequest dryRun(Boolean dryRun) {
        this.dryRun = dryRun;
        return this;
    }

    /**
     * Don't actually delete the ref name, just do a dry run.
     * 
     * @return dryRun
     **/
    public Boolean isDryRun() {
        return dryRun;
    }

    public void setDryRun(Boolean dryRun) {
        this.dryRun = dryRun;
    }

    public RestBranchDeleteRequest endPoint(String endPoint) {
        this.endPoint = endPoint;
        return this;
    }

    /**
     * Commit ID that the provided ref name is expected to point to.
     * 
     * @return endPoint
     **/
    @Size(max = 40)
    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public RestBranchDeleteRequest name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Name of the ref to be deleted.
     * 
     * @return name
     **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestBranchDeleteRequest)) {
            return false;
        }
        RestBranchDeleteRequest other = (RestBranchDeleteRequest) o;
        return Objects.equals(this.dryRun, other.dryRun) &&
                Objects.equals(this.endPoint, other.endPoint) &&
                Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dryRun, endPoint, name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestBranchDeleteRequest {");
        sb.append("\n    dryRun: ").append(toIndentedString(dryRun));
        sb.append("\n    endPoint: ").append(toIndentedString(endPoint));
        sb.append("\n    name: ").append(toIndentedString(name));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
