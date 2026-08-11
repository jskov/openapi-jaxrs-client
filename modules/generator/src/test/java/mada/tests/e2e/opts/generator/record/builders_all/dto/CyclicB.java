/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.opts.generator.record.builders_all.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.jspecify.annotations.Nullable;

/**
 * CyclicB
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public record CyclicB(
  @JsonbProperty("a")
  @Valid
  @Nullable
  CyclicA a,

  @JsonbProperty("fieldIsNotNullable")
  @Schema(required = true)
  @NotNull
  String fieldIsNotNullable,

  @JsonbProperty("fieldIsNullable")
  @Nullable
  String fieldIsNullable) {

    public CyclicB {
      Objects.requireNonNull(fieldIsNotNullable, "Property fieldIsNotNullable is required, cannot be null");
    }
    public static class Builder {
      private @Nullable CyclicA a;
      private @Nullable String fieldIsNotNullable;
      private @Nullable String fieldIsNullable;

      public static Builder of() {
        return new Builder();
      }

      public static Builder of(CyclicB from) {
        Builder o = new Builder();
        o.a = from.a();
        o.fieldIsNotNullable = from.fieldIsNotNullable();
        o.fieldIsNullable = from.fieldIsNullable();
        return o;
      }

      public Builder a(@Nullable CyclicA a) {
        this.a = a;
        return this;
      }

      public Builder fieldIsNotNullable(String fieldIsNotNullable) {
        this.fieldIsNotNullable = fieldIsNotNullable;
        return this;
      }

      public Builder fieldIsNullable(@Nullable String fieldIsNullable) {
        this.fieldIsNullable = fieldIsNullable;
        return this;
      }

      public CyclicB build() {
        return new CyclicB(
                 a,
                 fieldIsNotNullable,
                 fieldIsNullable
               );
      }
    }
}
