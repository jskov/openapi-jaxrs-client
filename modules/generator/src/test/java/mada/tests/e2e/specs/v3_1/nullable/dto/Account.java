/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.specs.v3_1.nullable.dto;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.jspecify.annotations.Nullable;

/**
 * Account
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public record Account(
  @JsonbProperty("array-not-nullable")
  @Schema(required = true)
  @NotNull
  List<String> arrayNotNullable,

  @JsonbProperty("array-nullable")
  @Schema(required = true, nullable = true)
  @Nullable
  List<String> arrayNullable,

  @JsonbProperty("set-not-nullable")
  @Schema(required = true)
  @NotNull
  Set<String> setNotNullable,

  @JsonbProperty("set-nullable")
  @Schema(required = true, nullable = true)
  @Nullable
  Set<String> setNullable,

  @JsonbProperty("string-not-nullable")
  @Schema(required = true, readOnly = true, description = "The id of the account.")
  @NotNull
  String stringNotNullable,

  @JsonbProperty("string-nullable")
  @Schema(required = true, nullable = true, readOnly = true, description = "The id of the account.")
  @Nullable
  String stringNullable,

  @JsonbProperty("string-nullable-not-required")
  @Schema(nullable = true, readOnly = true, description = "The id of the account.")
  @Nullable
  String stringNullableNotRequired) {

    public Account {
      Objects.requireNonNull(arrayNotNullable, "Property arrayNotNullable is required, cannot be null");
      Objects.requireNonNull(setNotNullable, "Property setNotNullable is required, cannot be null");
      Objects.requireNonNull(stringNotNullable, "Property stringNotNullable is required, cannot be null");
    }
}
