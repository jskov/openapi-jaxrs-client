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
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestRepositoriesExportRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestRepositoriesExportRequest {
    public static final String JSON_PROPERTY_INCLUDES = "includes";
    @JsonbProperty(JSON_PROPERTY_INCLUDES)
    @Schema(required = true)
    private Set<RestRepositorySelector> includes = new LinkedHashSet<>();

    public RestRepositoriesExportRequest includes(Set<RestRepositorySelector> includes) {
        this.includes = Objects.requireNonNull(includes, "Property includes is required, cannot be null");
        return this;
    }

    public RestRepositoriesExportRequest addIncludesItem(RestRepositorySelector includesItem) {
        this.includes.add(includesItem);
        return this;
    }

    /**
     * Get includes
     *
     * @return includes
     **/
    @NotNull @Valid public Set<RestRepositorySelector> getIncludes() {
        return includes;
    }

    public void setIncludes(Set<RestRepositorySelector> includes) {
        this.includes = Objects.requireNonNull(includes, "Property includes is required, cannot be null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestRepositoriesExportRequest)) {
            return false;
        }
        RestRepositoriesExportRequest other = (RestRepositoriesExportRequest) o;
        return Objects.equals(this.includes, other.includes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(includes);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestRepositoriesExportRequest {");
        sb.append("\n    includes: ").append(toIndentedString(includes));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
