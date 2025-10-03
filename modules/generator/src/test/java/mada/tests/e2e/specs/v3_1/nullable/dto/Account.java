/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.specs.v3_1.nullable.dto;

import javax.json.bind.annotation.JsonbProperty;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.jspecify.annotations.Nullable;

/**
 * Account
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public record Account(
  @JsonbProperty("id")
  @Schema(readOnly = true, description = "The id of the account.")
  @Nullable
  String id) {

}
