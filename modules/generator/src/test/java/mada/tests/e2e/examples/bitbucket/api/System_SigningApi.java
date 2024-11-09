/*
 * Bitbucket Data Center
 * This is the reference document for the Atlassian Bitbucket REST API. The REST API is for developers who want to:

 - integrate Bitbucket with other applications;

 - create scripts that interact with Bitbucket; or

 - develop plugins that enhance the Bitbucket UI, using REST to interact with the backend.

 You can read more about developing Bitbucket plugins in the [Bitbucket Developer Documentation](https://developer.atlassian.com/bitbucket/server/docs/latest/).
 *
 * The version of the OpenAPI document: 8.19
 */

package mada.tests.e2e.examples.bitbucket.api;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import mada.tests.e2e.examples.bitbucket.dto.RestSystemSigningConfiguration;
import mada.tests.e2e.examples.bitbucket.dto._RequestApiLatestSystemSigningConfiguration;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestSystemSigningConfiguration_400;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestSystemSigningConfiguration_401;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/latest/system-signing/configuration")
public interface System_SigningApi {

    /**
     * Get system signing configuration.
     *
     * Gets the configuration details for system signing Git objects.
     *
     * @return RestSystemSigningConfiguration
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The configuration details for system signing Git objects",
                    content = @Content(schema = @Schema(implementation = RestSystemSigningConfiguration.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to retrieve the configuration details for system signing Git objects.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestSystemSigningConfiguration_401.class)))
    })
    @Operation(summary = "Get system signing configuration")
    RestSystemSigningConfiguration getSystemSigningConfiguration();

    /**
     * Update system signing configuration.
     *
     * Updates the configuration for system signing Git objects.
     *
     * @param dto (optional)
     * @return RestSystemSigningConfiguration
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "The updated configuration details for system signing Git objects",
                    content = @Content(schema = @Schema(implementation = RestSystemSigningConfiguration.class))),
            @APIResponse(
                    responseCode = "400",
                    description = "The configuration details could not be updated because the provided request was invalid",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestSystemSigningConfiguration_400.class))),
            @APIResponse(
                    responseCode = "401",
                    description = "The currently authenticated user has insufficient permissions to retrieve the configuration details for system signing Git objects.",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestSystemSigningConfiguration_401.class)))
    })
    @Operation(summary = "Update system signing configuration")
    RestSystemSigningConfiguration updateSystemSigningConfiguration(@Valid _RequestApiLatestSystemSigningConfiguration dto);
}
