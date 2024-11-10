/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.record.validation.nullable.dto;

import java.util.Objects;
import java.util.UUID;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.jspecify.annotations.Nullable;

/**
 * AdresseIdentifikationDto
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public record AdresseIdentifikationDto(
        @JsonbProperty("adgangsadresseId")
        @Schema(required = true)
        @NotNull
        UUID adgangsadresseId,

        @JsonbProperty("adresseId")
        @Schema(required = true, nullable = true)
        @Nullable
        UUID adresseId) {

    public AdresseIdentifikationDto {
        Objects.requireNonNull(adgangsadresseId, "Property adgangsadresseId is required, cannot be null");
    }
}
