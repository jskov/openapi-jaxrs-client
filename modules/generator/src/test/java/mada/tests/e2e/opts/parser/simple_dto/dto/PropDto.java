/*
 * Test
 *
 * The version of the OpenAPI document: 1.0.0
 */

package mada.tests.e2e.opts.parser.simple_dto.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * PropDto
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class PropDto {
    public static final String JSON_PROPERTY_AENDRING = "aendring";
    @JsonbProperty(JSON_PROPERTY_AENDRING)
    @Schema(required = true, description = "Ændring som beskrevet i KRO API")
    private String aendring;

    public PropDto aendring(String aendring) {
        this.aendring = Objects.requireNonNull(aendring, "Property aendring is required, cannot be null");
        return this;
    }

    /**
     * Ændring som beskrevet i KRO API.
     * @return aendring
     **/
    @NotNull public String getAendring() {
        return aendring;
    }

    public void setAendring(String aendring) {
        this.aendring = Objects.requireNonNull(aendring, "Property aendring is required, cannot be null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PropDto)) {
            return false;
        }
        PropDto other = (PropDto) o;
        return Objects.equals(this.aendring, other.aendring);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aendring);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PropDto {");
        sb.append("\n    aendring: ").append(toIndentedString(aendring));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
