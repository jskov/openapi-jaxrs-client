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
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestExportRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestExportRequest {
    public static final String JSON_PROPERTY_EXPORT_LOCATION = "exportLocation";
    @JsonbProperty(JSON_PROPERTY_EXPORT_LOCATION)
    @Schema(example = "example/sub/directory")
    private String exportLocation;

    public static final String JSON_PROPERTY_REPOSITORIES_REQUEST = "repositoriesRequest";
    @JsonbProperty(JSON_PROPERTY_REPOSITORIES_REQUEST)
    @Schema(required = true)
    private RestExportRequestRepositoriesRequest repositoriesRequest;

    public RestExportRequest exportLocation(String exportLocation) {
        this.exportLocation = exportLocation;
        return this;
    }

    /**
     * Get exportLocation
     *
     * @return exportLocation
     **/
    public String getExportLocation() {
        return exportLocation;
    }

    public void setExportLocation(String exportLocation) {
        this.exportLocation = exportLocation;
    }

    public RestExportRequest repositoriesRequest(RestExportRequestRepositoriesRequest repositoriesRequest) {
        this.repositoriesRequest = Objects.requireNonNull(repositoriesRequest, "Property repositoriesRequest is required, cannot be null");
        return this;
    }

    /**
     * Get repositoriesRequest
     *
     * @return repositoriesRequest
     **/
    public @NotNull @Valid RestExportRequestRepositoriesRequest getRepositoriesRequest() {
        return repositoriesRequest;
    }

    public void setRepositoriesRequest(RestExportRequestRepositoriesRequest repositoriesRequest) {
        this.repositoriesRequest = Objects.requireNonNull(repositoriesRequest, "Property repositoriesRequest is required, cannot be null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestExportRequest)) {
            return false;
        }
        RestExportRequest other = (RestExportRequest) o;
        return Objects.equals(this.exportLocation, other.exportLocation) &&
                Objects.equals(this.repositoriesRequest, other.repositoriesRequest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exportLocation, repositoriesRequest);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestExportRequest {");
        sb.append("\n    exportLocation: ").append(toIndentedString(exportLocation));
        sb.append("\n    repositoriesRequest: ").append(toIndentedString(repositoriesRequest));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
