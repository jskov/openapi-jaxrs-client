/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.record.validation.jakarta.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.jspecify.annotations.Nullable;

/**
 * LicenseGroup
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public record LicenseGroup(
  @JsonbProperty("licenses")
  @Size(min = 1, max = 4)
  @Nullable
  List<@Valid ZLicense> licenses,

  @JsonbProperty("numbers")
  @Schema(required = true)
  @NotNull @Size(max = 100)
  List<@Min(7L) Integer> numbers,

  @JsonbProperty("requiredLicenses")
  @Schema(required = true)
  @NotNull @Size(min = 1, max = 4)
  List<@Valid ZLicense> requiredLicenses,

  @JsonbProperty("strings")
  @Schema(required = true)
  @NotNull @Size(min = 4, max = 8)
  List<String> strings) {

    public LicenseGroup {
      Objects.requireNonNull(numbers, "Property numbers is required, cannot be null");
      Objects.requireNonNull(requiredLicenses, "Property requiredLicenses is required, cannot be null");
      Objects.requireNonNull(strings, "Property strings is required, cannot be null");
    }
}
