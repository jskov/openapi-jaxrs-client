/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.regression.bad_dates.api;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/params/query/dates")
public interface Params_QueryApi {

  /**
   * apiParamsQueryDatesGet.
   *
   * @param date  (optional)
   * @param dateTime  (optional)
   * @param time  (optional)
   * @return String
   */
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @APIResponseSchema(String.class)
  String apiParamsQueryDatesGet(@QueryParam("date") LocalDate date, @QueryParam("date-time") OffsetDateTime dateTime, @QueryParam("time") String time);
}
