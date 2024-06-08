/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.record.collections.list.dto;

import javax.json.bind.annotation.JsonbProperty;
import org.jspecify.annotations.Nullable;

/**
 * Simple
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public record Simple(
  @JsonbProperty("aBoolean")
  @Nullable
  Boolean aBoolean) {

}
