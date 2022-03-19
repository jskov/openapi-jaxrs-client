/*
 * Azure Container Registry
 * Metadata API definition for the Azure Container Registry runtime
 *
 * The version of the OpenAPI document: 2019-08-15-preview
 */

package mada.tests.e2e.api.params.form.inline.api;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.api.params.form.inline.dto.Grant_typeEnum;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/oauth2/token")
public interface AcrTokenApi {

  /**
   * Exchange ACR Refresh token for an ACR Access Token
   *
   * @param auth  (required)
   * @param grant_type  (required)
   * @param service  (required)
   * @param scope  (required)
   * @param refresh_token  (required)
   * @return Object
   */
  @POST
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(Object.class)
  Object AccessTokens_Get(@HeaderParam("Authorization") String auth, @NotNull @FormParam("grant_type") Grant_typeEnum grant_type, @NotNull @FormParam("service") String service, @NotNull @FormParam("scope") String scope, @NotNull @FormParam("refresh_token") String refresh_token);
}
