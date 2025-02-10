/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.opts.generator.record.builders_all.dto;

import javax.json.bind.annotation.JsonbProperty;
import javax.validation.Valid;
import org.jspecify.annotations.Nullable;

/**
 * CyclicB
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public record CyclicB(
  @JsonbProperty("a")
  @Valid
  @Nullable
  CyclicA a) {

    public static class Builder {
      private @Nullable CyclicA a;

      public static Builder of() {
        return new Builder();
      }

      public static Builder of(CyclicB from) {
        Builder o = new Builder();
        o.a = from.a();
        return o;
      }

      public Builder a(@Nullable CyclicA a) {
        this.a = a;
        return this;
      }

      public CyclicB build() {
        return new CyclicB(
                 a
               );
      }
    }
}
