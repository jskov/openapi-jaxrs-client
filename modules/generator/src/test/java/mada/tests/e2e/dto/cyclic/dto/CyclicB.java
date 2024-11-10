/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.dto.cyclic.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.Valid;

/**
 * CyclicB
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class CyclicB {
    public static final String JSON_PROPERTY_A = "a";
    @JsonbProperty(JSON_PROPERTY_A)
    private CyclicA a;

    public CyclicB a(CyclicA a) {
        this.a = a;
        return this;
    }

    /**
     * Get a
     *
     * @return a
     **/
    @Valid public CyclicA getA() {
        return a;
    }

    public void setA(CyclicA a) {
        this.a = a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CyclicB)) {
            return false;
        }
        CyclicB other = (CyclicB) o;
        return Objects.equals(this.a, other.a);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CyclicB {");
        sb.append("\n    a: ").append(toIndentedString(a));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
