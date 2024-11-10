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
import org.jspecify.annotations.Nullable;

/**
 * ExternedLists
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public record ExternedLists(
        @JsonbProperty("listDate") @Nullable List<LocalDate> listDate,

        @JsonbProperty("listDateTime") @Nullable List<OffsetDateTime> listDateTime,

        @JsonbProperty("listInt") @Nullable List<Integer> listInt,

        @JsonbProperty("listSimple") @Valid @Nullable List<Simple> listSimple,

        @JsonbProperty("listString") @Nullable List<String> listString) {

}
