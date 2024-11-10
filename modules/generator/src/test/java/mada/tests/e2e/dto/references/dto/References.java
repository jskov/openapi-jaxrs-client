/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.dto.references.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.Valid;

/**
 * References
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class References {
    public static final String JSON_PROPERTY_SIMPLE = "simple";
    @JsonbProperty(JSON_PROPERTY_SIMPLE)
    private Simple simple;

    public References simple(Simple simple) {
        this.simple = simple;
        return this;
    }

    /**
     * Get simple
     *
     * @return simple
     **/
    public @Valid Simple getSimple() {
        return simple;
    }

    public void setSimple(Simple simple) {
        this.simple = simple;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof References)) {
            return false;
        }
        References other = (References) o;
        return Objects.equals(this.simple, other.simple);
    }

    @Override
    public int hashCode() {
        return Objects.hash(simple);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class References {");
        sb.append("\n    simple: ").append(toIndentedString(simple));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
