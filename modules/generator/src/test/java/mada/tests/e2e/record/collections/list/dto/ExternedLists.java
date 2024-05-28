/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.record.collections.list.dto;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.Valid;

/**
 * ExternedLists
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public record ExternedLists(
  @JsonbProperty("listDate")
  List<LocalDate> listDate,

  @JsonbProperty("listDateTime")
  List<OffsetDateTime> listDateTime,

  @JsonbProperty("listInt")
  List<Integer> listInt,

  @JsonbProperty("listSimple")
  @Valid
  List<Simple> listSimple,

  @JsonbProperty("listString")
  List<String> listString) {

}
