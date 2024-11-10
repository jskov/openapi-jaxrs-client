/*
 * Test
 *
 * The version of the OpenAPI document: 1.0.0
 */

package mada.tests.e2e.regression.string_pattern.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * KlarTilBeslutningsGrundlagResponse
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class KlarTilBeslutningsGrundlagResponse {
    public static final String JSON_PROPERTY_SENEST_OPDAT = "senestOpdat";
    @JsonbProperty(JSON_PROPERTY_SENEST_OPDAT)
    @Schema(required = true)
    private String senestOpdat;

    public KlarTilBeslutningsGrundlagResponse senestOpdat(String senestOpdat) {
        this.senestOpdat = Objects.requireNonNull(senestOpdat, "Property senestOpdat is required, cannot be null");
        return this;
    }

    /**
     * Get senestOpdat
     *
     * @return senestOpdat
     **/
    public @NotNull @Pattern(regexp = "^(\\d{4}-\\d{2}-\\d{2}-\\d{2}.\\d{2}.\\d{2}.\\d{6})$") String getSenestOpdat() {
        return senestOpdat;
    }

    public void setSenestOpdat(String senestOpdat) {
        this.senestOpdat = Objects.requireNonNull(senestOpdat, "Property senestOpdat is required, cannot be null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof KlarTilBeslutningsGrundlagResponse)) {
            return false;
        }
        KlarTilBeslutningsGrundlagResponse other = (KlarTilBeslutningsGrundlagResponse) o;
        return Objects.equals(this.senestOpdat, other.senestOpdat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(senestOpdat);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class KlarTilBeslutningsGrundlagResponse {");
        sb.append("\n    senestOpdat: ").append(toIndentedString(senestOpdat));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
