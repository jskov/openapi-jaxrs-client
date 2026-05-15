/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.record.validation.jakarta.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import java.util.UUID;
import org.jspecify.annotations.Nullable;

/**
 * ZLicense
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public record ZLicense(
  @JsonbProperty("uuid")
  @Nullable
  UUID uuid) {

}
