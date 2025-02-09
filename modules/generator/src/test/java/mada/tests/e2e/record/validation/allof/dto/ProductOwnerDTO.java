/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.record.validation.allof.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * ProductOwnerDTO
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public record ProductOwnerDTO(
  @JsonbProperty("email")
  @Schema(required = true)
  @NotNull @Size(min = 1, max = 150)
  String email,

  @JsonbProperty("name")
  @Schema(required = true)
  @NotNull @Size(min = 1, max = 300)
  String name,

  @JsonbProperty("user-id")
  @Schema(required = true)
  @NotNull @Size(min = 1, max = 100)
  String userId) {

    public ProductOwnerDTO {
      Objects.requireNonNull(email, "Property email is required, cannot be null");
      Objects.requireNonNull(name, "Property name is required, cannot be null");
      Objects.requireNonNull(userId, "Property userId is required, cannot be null");
    }
}
