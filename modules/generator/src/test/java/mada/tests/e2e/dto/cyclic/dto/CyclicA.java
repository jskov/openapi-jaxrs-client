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
 * CyclicA
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class CyclicA {
    public static final String JSON_PROPERTY_B = "b";
    @JsonbProperty(JSON_PROPERTY_B)
    private CyclicB b;

    public CyclicA b(CyclicB b) {
        this.b = b;
        return this;
    }

    /**
     * Get b
     *
     * @return b
     **/
    @Valid
    public CyclicB getB() {
        return b;
    }

    public void setB(CyclicB b) {
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CyclicA)) {
            return false;
        }
        CyclicA other = (CyclicA) o;
        return Objects.equals(this.b, other.b);
    }

    @Override
    public int hashCode() {
        return Objects.hash(b);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CyclicA {");
        sb.append("\n    b: ").append(toIndentedString(b));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
