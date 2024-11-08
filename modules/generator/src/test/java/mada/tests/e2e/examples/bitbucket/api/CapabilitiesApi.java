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

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import mada.tests.e2e.examples.bitbucket.dto.RestBuildCapabilities;
import mada.tests.e2e.examples.bitbucket.dto._ResponseApiLatestDeploymentCapabilities_404;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/latest")
public interface CapabilitiesApi {

    /**
     * Get build capabilities. Returns the build capabilities of this instance
     *
     * @return RestBuildCapabilities
     */
    @GET
    @Path("/build/capabilities")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponseSchema(RestBuildCapabilities.class)
    @Operation(summary = "Get build capabilities")
    RestBuildCapabilities getCapabilities();

    /**
     * Get deployment capabilities. Returns the Deployment capabilities of this instance
     */
    @GET
    @Path("/deployment/capabilities")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(responseCode = "200", description = "capabilities"),
            @APIResponse(
                    responseCode = "404",
                    description = "This instance of Bitbucket Data Center does not support deployments (for example, it has been disabled using the property 'plugin.deployment.capability.disabled').",
                    content = @Content(schema = @Schema(implementation = _ResponseApiLatestDeploymentCapabilities_404.class)))
    })
    @Operation(summary = "Get deployment capabilities")
    void getCapabilities_1();
}
