/*
 * Test
 *
 * The version of the OpenAPI document: 1.0.0
 */

package mada.tests.e2e.opts.parser.simple_dto.dto;

import java.util.Objects;

/**
 * NoPropsDto
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class NoPropsDto {
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NoPropsDto)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NoPropsDto {");
        sb.append("\n}");
        return sb.toString();
    }
}
