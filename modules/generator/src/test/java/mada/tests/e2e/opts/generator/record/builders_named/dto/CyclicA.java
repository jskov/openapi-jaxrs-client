/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.opts.generator.record.builders_named.dto;

import javax.json.bind.annotation.JsonbProperty;
import javax.validation.Valid;
import org.jspecify.annotations.Nullable;

/**
 * CyclicA
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public record CyclicA(
  @JsonbProperty("b")
  @Valid
  @Nullable
  CyclicB b) {

    public static class Builder {
      private @Nullable CyclicB b;

      public static Builder of() {
        return new Builder();
      }

      public static Builder of(CyclicA from) {
        Builder o = new Builder();
        o.b = from.b();
        return o;
      }

      public Builder b(@Nullable CyclicB b) {
        this.b = b;
        return this;
      }

      public CyclicA build() {
        return new CyclicA(
                 b
               );
      }
    }
}
