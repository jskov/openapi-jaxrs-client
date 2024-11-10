/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.api.types_special.dto;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;

/**
 * _ResponseApiTypesBitbucketArray_400
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class _ResponseApiTypesBitbucketArray_400 {
    public static final String JSON_PROPERTY_ERRORS = "errors";
    @JsonbProperty(JSON_PROPERTY_ERRORS)
    private List<LocalTime> errors;

    public _ResponseApiTypesBitbucketArray_400 errors(List<LocalTime> errors) {
        this.errors = errors;
        return this;
    }

    public _ResponseApiTypesBitbucketArray_400 addErrorsItem(LocalTime errorsItem) {
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
    public List<LocalTime> getErrors() {
        return errors;
    }

    public void setErrors(List<LocalTime> errors) {
        this.errors = errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof _ResponseApiTypesBitbucketArray_400)) {
            return false;
        }
        _ResponseApiTypesBitbucketArray_400 other = (_ResponseApiTypesBitbucketArray_400) o;
        return Objects.equals(this.errors, other.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class _ResponseApiTypesBitbucketArray_400 {");
        sb.append("\n    errors: ").append(toIndentedString(errors));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
