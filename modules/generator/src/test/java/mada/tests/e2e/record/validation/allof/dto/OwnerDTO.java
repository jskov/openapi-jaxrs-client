/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.record.validation.allof.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * OwnerDTO
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public record OwnerDTO(
        @JsonbProperty("ad-group")
        @Schema(required = true)
        @NotNull @Size(min = 1, max = 100)
        String adGroup,

        @JsonbProperty("email")
        @Schema(required = true)
        @NotNull @Size(min = 1, max = 100)
        String email) {

    public OwnerDTO {
        Objects.requireNonNull(adGroup, "Property adGroup is required, cannot be null");
        Objects.requireNonNull(email, "Property email is required, cannot be null");
    }
}
