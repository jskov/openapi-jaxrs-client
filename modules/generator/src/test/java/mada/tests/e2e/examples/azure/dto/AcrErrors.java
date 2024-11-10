/*
 * Azure Container Registry
 * Metadata API definition for the Azure Container Registry runtime
 *
 * The version of the OpenAPI document: 2019-08-15-preview
 */

package mada.tests.e2e.examples.azure.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Acr error response describing why the operation failed.
 */
@Schema(description = "Acr error response describing why the operation failed")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class AcrErrors {
    public static final String JSON_PROPERTY_ERRORS = "errors";
    @JsonbProperty(JSON_PROPERTY_ERRORS)
    @Schema(description = "Array of detailed error")
    private List<AcrErrorInfo> errors;

    public AcrErrors errors(List<AcrErrorInfo> errors) {
        this.errors = errors;
        return this;
    }

    public AcrErrors addErrorsItem(AcrErrorInfo errorsItem) {
        if (this.errors == null) {
            this.errors = new ArrayList<>();
        }
        this.errors.add(errorsItem);
        return this;
    }

    /**
     * Array of detailed error.
     * 
     * @return errors
     **/
    @Valid
    public List<AcrErrorInfo> getErrors() {
        return errors;
    }

    public void setErrors(List<AcrErrorInfo> errors) {
        this.errors = errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AcrErrors)) {
            return false;
        }
        AcrErrors other = (AcrErrors) o;
        return Objects.equals(this.errors, other.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AcrErrors {");
        sb.append("\n    errors: ").append(toIndentedString(errors));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
