/*
 * Azure Container Registry
 * Metadata API definition for the Azure Container Registry runtime
 *
 * The version of the OpenAPI document: 2019-08-15-preview
 */

package mada.tests.e2e.examples.azure.api;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.examples.azure.dto.AcrErrors;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/")
public interface LayerApi {

  /**
   * Mount a blob identified by the &#x60;mount&#x60; parameter from another repository.
   *
   * @param auth  (required)
   * @param name  (required)
   * @param from  (required)
   * @param mount  (required)
   * @return AcrErrors
   */
  @POST
  @Path("v2/{name}/blobs/uploads/")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "default", description = "ACR error response describing why the operation failed.",
                 content = @Content(schema = @Schema(implementation = AcrErrors.class))),
    @APIResponse(responseCode = "201", description = "The blob has been created in the registry and is available at the provided location.")
  })
  AcrErrors Blob_Mount(@HeaderParam("Authorization") String auth, @PathParam("name") @NotNull String name, @QueryParam("from") @NotNull String from, @QueryParam("mount") @NotNull String mount);

  /**
   * Retrieve the blob from the registry identified by digest.
   *
   * @param auth  (required)
   * @param name  (required)
   * @param digest  (required)
   * @return byte[]
   */
  @GET
  @Path("v2/{name}/blobs/{digest}")
  @Produces("application/octet-stream")
  @APIResponses({
    @APIResponse(responseCode = "default", description = "ACR error response describing why the operation failed.",
                 content = @Content(schema = @Schema(implementation = AcrErrors.class))),
    @APIResponse(responseCode = "200", description = "The blob identified by digest is available. The blob content will be present in the body of the response.",
                 content = @Content(schema = @Schema(implementation = byte[].class))),
    @APIResponse(responseCode = "307", description = "The blob identified by digest is available at the provided location.")
  })
  byte[] Blob_Get(@HeaderParam("Authorization") String auth, @PathParam("name") @NotNull String name, @PathParam("digest") @NotNull String digest);

  /**
   * Same as GET, except only the headers are returned.
   *
   * @param auth  (required)
   * @param name  (required)
   * @param digest  (required)
   */
  @HEAD
  @Path("v2/{name}/blobs/{digest}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "default", description = "ACR error response describing why the operation failed.",
                 content = @Content(schema = @Schema(implementation = AcrErrors.class))),
    @APIResponse(responseCode = "200", description = "The blob identified by digest is available. The blob content will be present in the body of the response."),
    @APIResponse(responseCode = "307", description = "The blob identified by digest is available at the provided location.")
  })
  void Blob_Check(@HeaderParam("Authorization") String auth, @PathParam("name") @NotNull String name, @PathParam("digest") @NotNull String digest);

  /**
   * Removes an already uploaded blob.
   *
   * @param auth  (required)
   * @param name  (required)
   * @param digest  (required)
   * @return AcrErrors
   */
  @DELETE
  @Path("v2/{name}/blobs/{digest}")
  @Produces("application/octet-stream")
  @APIResponses({
    @APIResponse(responseCode = "default", description = "ACR error response describing why the operation failed.",
                 content = @Content(schema = @Schema(implementation = AcrErrors.class))),
    @APIResponse(responseCode = "202", description = "The blob identified by digest is available. The blob content will be present in the body of the response.",
                 content = @Content(schema = @Schema(implementation = byte[].class)))
  })
  AcrErrors Blob_Delete(@HeaderParam("Authorization") String auth, @PathParam("name") @NotNull String name, @PathParam("digest") @NotNull String digest);

  /**
   * Retrieve status of upload identified by uuid. The primary purpose of this endpoint is to resolve the current status of a resumable upload.
   *
   * @param auth  (required)
   * @param nextBlobUuidLink  (required)
   * @return AcrErrors
   */
  @GET
  @Path("{nextBlobUuidLink}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "default", description = "ACR error response describing why the operation failed.",
                 content = @Content(schema = @Schema(implementation = AcrErrors.class))),
    @APIResponse(responseCode = "204", description = "The upload is known and in progress. The last received offset is available in the Range header.")
  })
  AcrErrors Blob_GetStatus(@HeaderParam("Authorization") String auth, @PathParam("nextBlobUuidLink") @NotNull String nextBlobUuidLink);

  /**
   * Complete the upload, providing all the data in the body, if necessary. A request without a body will just complete the upload with previously uploaded content.
   *
   * @param auth  (required)
   * @param digest  (required)
   * @param nextBlobUuidLink  (required)
   * @param dto  (optional)
   * @return AcrErrors
   */
  @PUT
  @Path("{nextBlobUuidLink}")
  @Consumes("application/octet-stream")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "default", description = "ACR error response describing why the operation failed.",
                 content = @Content(schema = @Schema(implementation = AcrErrors.class))),
    @APIResponse(responseCode = "201", description = "The upload has been completed and accepted by the registry.")
  })
  AcrErrors Blob_EndUpload(@HeaderParam("Authorization") String auth, @QueryParam("digest") @NotNull String digest, @PathParam("nextBlobUuidLink") @NotNull String nextBlobUuidLink, Object dto);

  /**
   * Cancel outstanding upload processes, releasing associated resources. If this is not called, the unfinished uploads will eventually timeout.
   *
   * @param auth  (required)
   * @param nextBlobUuidLink  (required)
   * @return AcrErrors
   */
  @DELETE
  @Path("{nextBlobUuidLink}")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "default", description = "ACR error response describing why the operation failed.",
                 content = @Content(schema = @Schema(implementation = AcrErrors.class))),
    @APIResponse(responseCode = "204", description = "The upload has been successfully deleted.")
  })
  AcrErrors Blob_CancelUpload(@HeaderParam("Authorization") String auth, @PathParam("nextBlobUuidLink") @NotNull String nextBlobUuidLink);

  /**
   * Upload a stream of data without completing the upload.
   *
   * @param auth  (required)
   * @param nextBlobUuidLink  (required)
   * @param dto  (required)
   * @return AcrErrors
   */
  @PATCH
  @Path("{nextBlobUuidLink}")
  @Consumes("application/octet-stream")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "default", description = "ACR error response describing why the operation failed.",
                 content = @Content(schema = @Schema(implementation = AcrErrors.class))),
    @APIResponse(responseCode = "202", description = "The stream of data has been accepted and the current progress is available in the range header. The updated upload location is available in the Location header.")
  })
  AcrErrors Blob_Upload(@HeaderParam("Authorization") String auth, @PathParam("nextBlobUuidLink") @NotNull String nextBlobUuidLink, @NotNull Object dto);
}
