/*
 * openapi API Title
 *
 * The version of the OpenAPI document: 0.0.0+info_version
 */

package mada.tests.e2e.record.bean_naming.dto;

import javax.json.bind.annotation.JsonbProperty;
import org.jspecify.annotations.Nullable;

/**
 * BeanNaming
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public record BeanNaming(
  @JsonbProperty("aCamelBool")
  @Nullable
  Boolean aCamelBool,

  @JsonbProperty("aCamelInt")
  @Nullable
  Integer aCamelInt,

  @JsonbProperty("a_different_camel_bool")
  @Nullable
  Boolean aDifferentCamelBool,

  @JsonbProperty("ALLCAPSBOOL")
  @Nullable
  Boolean aLLCAPSBOOL,

  @JsonbProperty("ALLCAPSINT")
  @Nullable
  Boolean aLLCAPSINT,

  @JsonbProperty("downBool")
  @Nullable
  Boolean downBool,

  @JsonbProperty("downInt")
  @Nullable
  Integer downInt,

  @JsonbProperty("i-number")
  @Nullable
  Short iNumber,

  @JsonbProperty("UpperBool")
  @Nullable
  Boolean upperBool,

  @JsonbProperty("UpperInt")
  @Nullable
  Integer upperInt,

  @JsonbProperty("with-slash")
  @Nullable
  Boolean withSlash,

  @JsonbProperty("with_underscore")
  @Nullable
  Boolean withUnderscore) {

}
