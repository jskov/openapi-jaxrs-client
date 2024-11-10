/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.zoneddatetime.dto;

import java.util.Objects;

/**
 * LocalTime
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class LocalTime {
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LocalTime)) {
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
        sb.append("class LocalTime {");
        sb.append("\n}");
        return sb.toString();
    }
}
