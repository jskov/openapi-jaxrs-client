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

/**
 * _ResponseApiLatestAdminGitMeshNodes_400
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class _ResponseApiLatestAdminGitMeshNodes_400 {
    public static final String JSON_PROPERTY_ERRORS = "errors";
    @JsonbProperty(JSON_PROPERTY_ERRORS)
    private List<RestErrorMessage> errors;

    public _ResponseApiLatestAdminGitMeshNodes_400 errors(List<RestErrorMessage> errors) {
        this.errors = errors;
        return this;
    }

    public _ResponseApiLatestAdminGitMeshNodes_400 addErrorsItem(RestErrorMessage errorsItem) {
        if (this.errors == null) {
            this.errors = new ArrayList<>();
        }
        this.errors.add(errorsItem);
        return this;
    }

    /**
     * Get errors
     *
     * @return errors
     **/
    public @Valid List<RestErrorMessage> getErrors() {
        return errors;
    }

    public void setErrors(List<RestErrorMessage> errors) {
        this.errors = errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof _ResponseApiLatestAdminGitMeshNodes_400)) {
            return false;
        }
        _ResponseApiLatestAdminGitMeshNodes_400 other = (_ResponseApiLatestAdminGitMeshNodes_400) o;
        return Objects.equals(this.errors, other.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class _ResponseApiLatestAdminGitMeshNodes_400 {");
        sb.append("\n    errors: ").append(toIndentedString(errors));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
