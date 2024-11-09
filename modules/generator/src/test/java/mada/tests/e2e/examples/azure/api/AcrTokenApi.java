/*
 * Azure Container Registry
 * Metadata API definition for the Azure Container Registry runtime
 *
 * The version of the OpenAPI document: 2019-08-15-preview
 */

package mada.tests.e2e.examples.azure.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import mada.tests.e2e.examples.azure.dto.AccessToken;
import mada.tests.e2e.examples.azure.dto.AcrErrors;
import mada.tests.e2e.examples.azure.dto.RefreshToken;
import mada.tests.e2e.examples.azure.dto._RequestOauth2Exchange;
import mada.tests.e2e.examples.azure.dto._RequestOauth2Token;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/oauth2")
public interface AcrTokenApi {

    /**
     * Exchange AAD tokens for an ACR refresh Token.
     *
     * @param dto (not null)
     * @return RefreshToken
     */
    @POST
    @Path("/exchange")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "default",
                    description = "ACR error response describing why the operation failed.",
                    content = @Content(schema = @Schema(implementation = AcrErrors.class))),
            @APIResponse(
                    responseCode = "200",
                    description = "Refresh token acquired",
                    content = @Content(schema = @Schema(implementation = RefreshToken.class)))
    })
    RefreshToken RefreshTokens_GetFromExchange(@NotNull @Valid _RequestOauth2Exchange dto);

    /**
     * Exchange Username, Password and Scope an ACR Access Token.
     *
     * @param auth    (not null)
     * @param service Indicates the name of your Azure container registry. (not null)
     * @param scope   Expected to be a valid scope, and can be specified more than once for multiple scope requests. You can
     *                obtain this from the Www-Authenticate response header from the challenge. (not null)
     * @return AccessToken
     */
    @GET
    @Path("/token")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "default",
                    description = "ACR error response describing why the operation failed.",
                    content = @Content(schema = @Schema(implementation = AcrErrors.class))),
            @APIResponse(
                    responseCode = "200",
                    description = "Access token acquired",
                    content = @Content(schema = @Schema(implementation = AccessToken.class)))
    })
    AccessToken AccessTokens_GetFromLogin(@HeaderParam("Authorization") String auth, @QueryParam("service") @NotNull String service,
            @QueryParam("scope") @NotNull String scope);

    /**
     * Exchange ACR Refresh token for an ACR Access Token.
     *
     * @param dto (not null)
     * @return AccessToken
     */
    @POST
    @Path("/token")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "default",
                    description = "ACR error response describing why the operation failed.",
                    content = @Content(schema = @Schema(implementation = AcrErrors.class))),
            @APIResponse(
                    responseCode = "200",
                    description = "Access token acquired",
                    content = @Content(schema = @Schema(implementation = AccessToken.class)))
    })
    AccessToken AccessTokens_Get(@NotNull @Valid _RequestOauth2Token dto);
}
