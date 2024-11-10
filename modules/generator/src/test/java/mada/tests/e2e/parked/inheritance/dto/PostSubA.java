/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.parked.inheritance.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/**
 * PostSubA
 */
@JsonPropertyOrder({
})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class PostSubA extends PostDto {
    public static final String JSON_PROPERTY_FIELD_ONLY_IN_SUB_A = "fieldOnlyInSubA";
    @JsonProperty(JSON_PROPERTY_FIELD_ONLY_IN_SUB_A)
    private String fieldOnlyInSubA;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return true // fields
                && super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PostSubA {");
        sb.append(toIndentedString(super.toString()));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
