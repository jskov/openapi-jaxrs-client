/*
 *
 *
 * The version of the OpenAPI document:
 */

package mada.tests.e2e.record.bean_naming.dto;

import javax.json.bind.annotation.JsonbProperty;

/**
 * BeanNaming
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public record BeanNaming(
  @JsonbProperty("aCamelBool")
  Boolean aCamelBool,

  @JsonbProperty("aCamelInt")
  Integer aCamelInt,

  @JsonbProperty("ALLCAPSBOOL")
  Boolean aLLCAPSBOOL,

  @JsonbProperty("ALLCAPSINT")
  Boolean aLLCAPSINT,

  @JsonbProperty("downBool")
  Boolean downBool,

  @JsonbProperty("downInt")
  Integer downInt,

  @JsonbProperty("UpperBool")
  Boolean upperBool,

  @JsonbProperty("UpperInt")
  Integer upperInt,

  @JsonbProperty("with-slash")
  Boolean withSlash,

  @JsonbProperty("with_underscore")
  Boolean withUnderscore) {
}
