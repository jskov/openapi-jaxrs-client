/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.opts.generator.jspecify.dto_fields.dto;

import java.util.Objects;
import java.util.UUID;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

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
  UUID adresseId) {

    public AdresseIdentifikationDto {
      Objects.requireNonNull(adgangsadresseId, "Property adgangsadresseId is required, cannot be null");
    }
}
