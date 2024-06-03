/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.dto.jspecify.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.jspecify.annotations.Nullable;

/**
 * Pet
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public record Pet(
  @JsonbProperty("id")
  @Schema(required = true)
  @NotNull
  Long id,

  @JsonbProperty("name")
  @Schema(required = true)
  @NotNull
  String name,

  @JsonbProperty("tag")
  @Nullable
  String tag) {

    public Pet {
      Objects.requireNonNull(id, "Property id is required, cannot be null");
      Objects.requireNonNull(name, "Property name is required, cannot be null");
    }
}
