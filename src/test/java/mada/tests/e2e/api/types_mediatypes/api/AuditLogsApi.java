/*
 * Auditlog API
 * API for accessing the auditlogging
 *
 * The version of the OpenAPI document: 1.0.0
 */

package mada.tests.e2e.api.types_mediatypes.api;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import mada.tests.e2e.api.types_mediatypes.dto.ExceptionInformation;
import mada.tests.e2e.api.types_mediatypes.dto.LogEntry;
import mada.tests.e2e.api.types_mediatypes.dto.LogResult;
import mada.tests.e2e.api.types_mediatypes.dto.ViolationConstraint;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/")
public interface AuditLogsApi {

  /**
   * adds an audit log.
   *
   * @param dto  (optional)
   * @return LogResult
   */
  @POST
  @Path("audit-logs")
  @Consumes("application/vnd.auditlog.entry+json;version=v1")
  @Produces({"application/x.auditlog.error+json;version=v1", "application/x.auditlog.result+json;version=v1", "application/x.auditlog.violations+json;version=v1"})
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Successfully added the log",
                 content = @Content(schema = @Schema(implementation = LogResult.class), mediaType = "application/x.auditlog.result+json;version=v1")),
    @APIResponse(responseCode = "400", description = "Constraints violation",
                 content = @Content(schema = @Schema(implementation = ViolationConstraint.class), mediaType = "application/x.auditlog.violations+json;version=v1")),
    @APIResponse(responseCode = "500", description = "Internal error or backend failure",
                 content = @Content(schema = @Schema(implementation = ExceptionInformation.class), mediaType = "application/x.auditlog.error+json;version=v1"))
  })
  @Operation(summary = "adds an audit log")
  LogResult addEntryV1(@Valid LogEntry dto);

  /**
   * adds an audit log.
   *
   * @param dto  (optional)
   * @return LogResult
   */
  @POST
  @Path("audit-logs-extra-responses")
  @Consumes("application/vnd.auditlog.entry+json;version=v1")
  @Produces({"application/x.auditlog.error+json;version=v1", "application/x.auditlog.result+json;version=v1", "application/x.auditlog.violations+json;version=v1", MediaType.APPLICATION_JSON})
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Successfully added the log",
                 content = @Content(schema = @Schema(implementation = LogResult.class), mediaType = "application/x.auditlog.result+json;version=v1")),
    @APIResponse(responseCode = "400", description = "Constraints violation",
                 content = @Content(schema = @Schema(implementation = ViolationConstraint.class), mediaType = "application/x.auditlog.violations+json;version=v1")),
    @APIResponse(responseCode = "401", description = "unauthorized dummy response with two types",
                 content = @Content(schema = @Schema(implementation = String.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "403", description = "forbidden dummy response with one type",
                 content = @Content(schema = @Schema(implementation = String.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "500", description = "Internal error or backend failure",
                 content = @Content(schema = @Schema(implementation = ExceptionInformation.class), mediaType = "application/x.auditlog.error+json;version=v1"))
  })
  @Operation(summary = "adds an audit log")
  LogResult addEntryMultipleResponses(@Valid LogEntry dto);

  /**
   * adds an audit log.
   *
   * @param dto  (optional)
   * @return LogResult
   */
  @POST
  @Path("multiple-responses")
  @Consumes("application/vnd.auditlog.entry+json;version=v1")
  @Produces({"application/x.auditlog.result+json;version=v1", "application/x.auditlog.result+json;version=v2", "application/x.auditlog.violations+json;version=v1"})
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Successfully added the log",
                 content = @Content(schema = @Schema(implementation = LogResult.class), mediaType = "application/x.auditlog.result+json;version=v1")),
    @APIResponse(responseCode = "400", description = "Constraints violation",
                 content = @Content(schema = @Schema(implementation = ViolationConstraint.class), mediaType = "application/x.auditlog.violations+json;version=v1"))
  })
  @Operation(summary = "adds an audit log")
  LogResult multipleResponsesPost(@Valid LogEntry dto);
}
