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
 * CyclicB
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public record CyclicB(
  @JsonbProperty("a")
  @Valid
  CyclicA a) {

    public static class Builder {
      private CyclicA a;

      public Builder of() {
        return new Builder();
      }

      public Builder of(CyclicB from) {
        Builder o = new Builder();
        o.a = from.a();
        return o;
      }

      public Builder a(CyclicA a) {
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
