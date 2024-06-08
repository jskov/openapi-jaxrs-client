/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.record.collections.list.dto;

import java.util.List;
import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.jspecify.annotations.Nullable;

/**
 * ArraysDto
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public record ArraysDto(
  @JsonbProperty("booleans")
  @Nullable
  List<Boolean> booleans,

  @JsonbProperty("bytes")
  @Nullable
  byte[] bytes,

  @JsonbProperty("ints")
  @Nullable
  List<Integer> ints,

  @JsonbProperty("longs")
  @Nullable
  List<Long> longs,

  @JsonbProperty("refs")
  @Valid
  @Nullable
  List<Simple> refs,

  @JsonbProperty("requiredBooleans")
  @Schema(required = true)
  @NotNull
  List<Boolean> requiredBooleans,

  @JsonbProperty("requiredBytes")
  @Schema(required = true)
  @NotNull
  byte[] requiredBytes,

  @JsonbProperty("requiredInts")
  @Schema(required = true)
  @NotNull
  List<Integer> requiredInts,

  @JsonbProperty("requiredLongs")
  @Schema(required = true)
  @NotNull
  List<Long> requiredLongs,

  @JsonbProperty("requiredRefs")
  @Schema(required = true)
  @NotNull @Valid
  List<Simple> requiredRefs,

  @JsonbProperty("requiredShorts")
  @Schema(required = true)
  @NotNull
  List<Short> requiredShorts,

  @JsonbProperty("requiredStrings")
  @Schema(required = true)
  @NotNull
  List<String> requiredStrings,

  @JsonbProperty("shorts")
  @Nullable
  List<Short> shorts,

  @JsonbProperty("strings")
  @Nullable
  List<String> strings) {

    public ArraysDto {
      Objects.requireNonNull(requiredBooleans, "Property requiredBooleans is required, cannot be null");
      Objects.requireNonNull(requiredBytes, "Property requiredBytes is required, cannot be null");
      Objects.requireNonNull(requiredInts, "Property requiredInts is required, cannot be null");
      Objects.requireNonNull(requiredLongs, "Property requiredLongs is required, cannot be null");
      Objects.requireNonNull(requiredRefs, "Property requiredRefs is required, cannot be null");
      Objects.requireNonNull(requiredShorts, "Property requiredShorts is required, cannot be null");
      Objects.requireNonNull(requiredStrings, "Property requiredStrings is required, cannot be null");
    }
}
