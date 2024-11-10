/*
 * Test
 *
 * The version of the OpenAPI document: 1.0.0
 */

package mada.tests.e2e.opts.parser.simple_dto.dto;

import java.util.Objects;

/**
 * SubNoProps
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class SubNoProps extends Super {
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SubNoProps)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SubNoProps {");
        sb.append("\n    ").append(toIndentedString(super.toString()));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
