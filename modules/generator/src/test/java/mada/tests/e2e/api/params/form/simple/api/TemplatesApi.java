/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.api.params.form.simple.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.api.params.form.simple.dto.MultipartApiMethodsCreatePost;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/methods/create")
public interface TemplatesApi {

    /**
     * apiMethodsCreatePost.
     *
     * @param dto Synthetic multipart body (not null)
     */
    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @APIResponses({
            @APIResponse(responseCode = "201", description = "Created"),
            @APIResponse(responseCode = "401", description = "Not Authorized"),
            @APIResponse(responseCode = "403", description = "Not Allowed")
    })
    void apiMethodsCreatePost(@MultipartForm @NotNull @Valid MultipartApiMethodsCreatePost dto);
}
