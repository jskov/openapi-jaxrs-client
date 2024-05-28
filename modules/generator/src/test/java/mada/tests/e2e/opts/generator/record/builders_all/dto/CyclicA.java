/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.opts.generator.record.builders_all.dto;

import javax.json.bind.annotation.JsonbProperty;
import javax.validation.Valid;

/**
 * CyclicA
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public record CyclicA(
  @JsonbProperty("b")
  @Valid
  CyclicB b) {

    public static class Builder {
      private CyclicB b;

      public Builder of() {
        return new Builder();
      }

      public Builder of(CyclicA from) {
        Builder o = new Builder();
        o.b = from.b();
        return o;
      }

      public Builder b(CyclicB b) {
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
