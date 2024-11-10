/*
 * Azure Container Registry
 * Metadata API definition for the Azure Container Registry runtime
 *
 * The version of the OpenAPI document: 2019-08-15-preview
 */

package mada.tests.e2e.examples.azure.api;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.io.InputStream;
import mada.tests.e2e.examples.azure.dto.AcrErrors;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/")
public interface LayerApi {

    /**
     * Mount a blob identified by the `mount` parameter from another repository.
     *
     * @param auth  (not null)
     * @param name  Name of the image (including the namespace) (not null)
     * @param from  Name of the source repository. (not null)
     * @param mount Digest of blob to mount from the source repository. (not null)
     */
    @POST
    @Path("v2/{name}/blobs/uploads/")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "default",
                    description = "ACR error response describing why the operation failed.",
                    content = @Content(schema = @Schema(implementation = AcrErrors.class))),
            @APIResponse(
                    responseCode = "201",
                    description = "The blob has been created in the registry and is available at the provided location.")
    })
    void Blob_Mount(@HeaderParam("Authorization") String auth, @PathParam("name") @NotNull String name, @QueryParam("from") @NotNull String from,
            @QueryParam("mount") @NotNull String mount);

    /**
     * Retrieve the blob from the registry identified by digest.
     *
     * @param auth   (not null)
     * @param name   Name of the image (including the namespace) (not null)
     * @param digest Digest of a BLOB (not null)
     * @return InputStream
     */
    @GET
    @Path("v2/{name}/blobs/{digest}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @APIResponses({
            @APIResponse(
                    responseCode = "default",
                    description = "ACR error response describing why the operation failed.",
                    content = @Content(schema = @Schema(implementation = AcrErrors.class))),
            @APIResponse(
                    responseCode = "200",
                    description = "The blob identified by digest is available. The blob content will be present in the body of the response.",
                    content = @Content(schema = @Schema(implementation = InputStream.class))),
            @APIResponse(
                    responseCode = "307",
                    description = "The blob identified by digest is available at the provided location.")
    })
    InputStream Blob_Get(@HeaderParam("Authorization") String auth, @PathParam("name") @NotNull String name, @PathParam("digest") @NotNull String digest);

    /**
     * Same as GET, except only the headers are returned.
     *
     * @param auth   (not null)
     * @param name   Name of the image (including the namespace) (not null)
     * @param digest Digest of a BLOB (not null)
     * @return AcrErrors
     */
    @HEAD
    @Path("v2/{name}/blobs/{digest}")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "default",
                    description = "ACR error response describing why the operation failed.",
                    content = @Content(schema = @Schema(implementation = AcrErrors.class))),
            @APIResponse(
                    responseCode = "200",
                    description = "The blob identified by digest is available. The blob content will be present in the body of the response."),
            @APIResponse(
                    responseCode = "307",
                    description = "The blob identified by digest is available at the provided location.")
    })
    AcrErrors Blob_Check(@HeaderParam("Authorization") String auth, @PathParam("name") @NotNull String name, @PathParam("digest") @NotNull String digest);

    /**
     * Removes an already uploaded blob.
     *
     * @param auth   (not null)
     * @param name   Name of the image (including the namespace) (not null)
     * @param digest Digest of a BLOB (not null)
     * @return AcrErrors
     */
    @DELETE
    @Path("v2/{name}/blobs/{digest}")
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @APIResponses({
            @APIResponse(
                    responseCode = "default",
                    description = "ACR error response describing why the operation failed.",
                    content = @Content(schema = @Schema(implementation = AcrErrors.class))),
            @APIResponse(
                    responseCode = "202",
                    description = "The blob identified by digest is available. The blob content will be present in the body of the response.",
                    content = @Content(schema = @Schema(implementation = InputStream.class)))
    })
    AcrErrors Blob_Delete(@HeaderParam("Authorization") String auth, @PathParam("name") @NotNull String name, @PathParam("digest") @NotNull String digest);

    /**
     * Retrieve status of upload identified by uuid. The primary purpose of this endpoint is to resolve the current
     * status of a resumable upload.
     *
     * @param auth             (not null)
     * @param nextBlobUuidLink Link acquired from upload start or previous chunk. Note, do not include initial / (must do substring(1) ) (not null)
     * @return AcrErrors
     */
    @GET
    @Path("{nextBlobUuidLink}")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "default",
                    description = "ACR error response describing why the operation failed.",
                    content = @Content(schema = @Schema(implementation = AcrErrors.class))),
            @APIResponse(
                    responseCode = "204",
                    description = "The upload is known and in progress. The last received offset is available in the Range header.")
    })
    AcrErrors Blob_GetStatus(@HeaderParam("Authorization") String auth, @PathParam("nextBlobUuidLink") @NotNull String nextBlobUuidLink);

    /**
     * Complete the upload, providing all the data in the body, if necessary. A request without a body will just
     * complete the upload with previously uploaded content.
     *
     * @param auth             (not null)
     * @param digest           Digest of a BLOB (not null)
     * @param nextBlobUuidLink Link acquired from upload start or previous chunk. Note, do not include initial / (must do substring(1) ) (not null)
     * @param dto              Optional raw data of blob (optional)
     */
    @PUT
    @Path("{nextBlobUuidLink}")
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "default",
                    description = "ACR error response describing why the operation failed.",
                    content = @Content(schema = @Schema(implementation = AcrErrors.class))),
            @APIResponse(
                    responseCode = "201",
                    description = "The upload has been completed and accepted by the registry.")
    })
    void Blob_EndUpload(@HeaderParam("Authorization") String auth, @QueryParam("digest") @NotNull String digest, @PathParam("nextBlobUuidLink") @NotNull String nextBlobUuidLink, Object dto);

    /**
     * Cancel outstanding upload processes, releasing associated resources. If this is not called, the unfinished
     * uploads will eventually timeout.
     *
     * @param auth             (not null)
     * @param nextBlobUuidLink Link acquired from upload start or previous chunk. Note, do not include initial / (must do substring(1) ) (not null)
     * @return AcrErrors
     */
    @DELETE
    @Path("{nextBlobUuidLink}")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "default",
                    description = "ACR error response describing why the operation failed.",
                    content = @Content(schema = @Schema(implementation = AcrErrors.class))),
            @APIResponse(
                    responseCode = "204",
                    description = "The upload has been successfully deleted.")
    })
    AcrErrors Blob_CancelUpload(@HeaderParam("Authorization") String auth, @PathParam("nextBlobUuidLink") @NotNull String nextBlobUuidLink);

    /**
     * Upload a stream of data without completing the upload.
     *
     * @param auth             (not null)
     * @param nextBlobUuidLink Link acquired from upload start or previous chunk. Note, do not include initial / (must do substring(1) ) (not null)
     * @param dto              Raw data of blob (not null)
     * @return AcrErrors
     */
    @PATCH
    @Path("{nextBlobUuidLink}")
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "default",
                    description = "ACR error response describing why the operation failed.",
                    content = @Content(schema = @Schema(implementation = AcrErrors.class))),
            @APIResponse(
                    responseCode = "202",
                    description = "The stream of data has been accepted and the current progress is available in the range header. The updated upload location is available in the Location header.")
    })
    AcrErrors Blob_Upload(@HeaderParam("Authorization") String auth, @PathParam("nextBlobUuidLink") @NotNull String nextBlobUuidLink, @NotNull Object dto);
}
