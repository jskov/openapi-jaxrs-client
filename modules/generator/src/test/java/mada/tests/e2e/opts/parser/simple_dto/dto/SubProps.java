/*
 * Test
 *
 * The version of the OpenAPI document: 1.0.0
 */

package mada.tests.e2e.opts.parser.simple_dto.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;

/**
 * SubProps
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class SubProps extends Super {
    public static final String JSON_PROPERTY_FOO = "foo";
    @JsonbProperty(JSON_PROPERTY_FOO)
    private Integer foo;

    public SubProps foo(Integer foo) {
        this.foo = foo;
        return this;
    }

    /**
     * Get foo
     *
     * @return foo
     **/
    public Integer getFoo() {
        return foo;
    }

    public void setFoo(Integer foo) {
        this.foo = foo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SubProps)) {
            return false;
        }
        SubProps other = (SubProps) o;
        return Objects.equals(this.foo, other.foo) &&
              super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foo, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SubProps {");
        sb.append("\n    ").append(toIndentedString(super.toString()));
        sb.append("\n    foo: ").append(toIndentedString(foo));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
