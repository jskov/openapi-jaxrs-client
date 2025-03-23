/*
 * Swagger Petstore - OpenAPI 3.0
 * This is a sample Pet Store Server based on the OpenAPI 3.0 specification.  You can find out more about
Swagger at [https://swagger.io](https://swagger.io). In the third iteration of the pet store, we've switched to the design first approach!
You can now help us improve the API whether it's by making changes to the definition itself or to the code.
That way, with time, we can improve the API in general, and expose some of the new features in OAS3.

Some useful links:
- [The Pet Store repository](https://github.com/swagger-api/swagger-petstore)
- [The source API definition for the Pet Store](https://github.com/swagger-api/swagger-petstore/blob/master/src/main/resources/openapi.yaml)
 *
 * The version of the OpenAPI document: 1.0.27-SNAPSHOT
 * Contact: apiteam@swagger.io
 */

package mada.tests.e2e.examples.petstore.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.io.InputStream;
import java.util.List;
import mada.tests.e2e.examples.petstore.dto.ApiResponse;
import mada.tests.e2e.examples.petstore.dto.Pet;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/pet")
public interface PetApi {

  /**
   * Add a new pet to the store.
   * Add a new pet to the store.
   *
   * @param auth  (not null)
   * @param dto Create a new pet in the store (not null)
   * @return Pet
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "default", description = "Unexpected error"),
    @APIResponse(responseCode = "200", description = "Successful operation",
                 content = @Content(schema = @Schema(implementation = Pet.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "400", description = "Invalid input"),
    @APIResponse(responseCode = "422", description = "Validation exception")
  })
  @Operation(summary = "Add a new pet to the store.")
  Pet addPet(@HeaderParam("Authorization") @NotNull String auth, @NotNull @Valid Pet dto);

  /**
   * Update an existing pet.
   * Update an existing pet by Id.
   *
   * @param auth  (not null)
   * @param dto Update an existent pet in the store (not null)
   * @return Pet
   */
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "default", description = "Unexpected error"),
    @APIResponse(responseCode = "200", description = "Successful operation",
                 content = @Content(schema = @Schema(implementation = Pet.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "400", description = "Invalid ID supplied"),
    @APIResponse(responseCode = "404", description = "Pet not found"),
    @APIResponse(responseCode = "422", description = "Validation exception")
  })
  @Operation(summary = "Update an existing pet.")
  Pet updatePet(@HeaderParam("Authorization") @NotNull String auth, @NotNull @Valid Pet dto);

  /**
   * Finds Pets by status.
   * Multiple status values can be provided with comma separated strings.
   *
   * @param auth  (not null)
   * @param status Status values that need to be considered for filter (optional)
   * @return List<Pet>
   */
  @GET
  @Path("/findByStatus")
  @APIResponses({
    @APIResponse(responseCode = "default", description = "Unexpected error"),
    @APIResponse(responseCode = "200", description = "successful operation",
                 content = @Content(schema = @Schema(implementation = Pet.class, type = SchemaType.ARRAY), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "400", description = "Invalid status value")
  })
  @Operation(summary = "Finds Pets by status.")
  List<Pet> findPetsByStatus(@HeaderParam("Authorization") @NotNull String auth, @QueryParam("status") String status);

  /**
   * Finds Pets by tags.
   * Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
   *
   * @param auth  (not null)
   * @param tags Tags to filter by (optional)
   * @return List<Pet>
   */
  @GET
  @Path("/findByTags")
  @APIResponses({
    @APIResponse(responseCode = "default", description = "Unexpected error"),
    @APIResponse(responseCode = "200", description = "successful operation",
                 content = @Content(schema = @Schema(implementation = Pet.class, type = SchemaType.ARRAY), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "400", description = "Invalid tag value")
  })
  @Operation(summary = "Finds Pets by tags.")
  List<Pet> findPetsByTags(@HeaderParam("Authorization") @NotNull String auth, @QueryParam("tags") List<String> tags);

  /**
   * Find pet by ID.
   * Returns a single pet.
   *
   * @param auth  (not null)
   * @param petId ID of pet to return
   * @return Pet
   */
  @GET
  @Path("/{petId}")
  @APIResponses({
    @APIResponse(responseCode = "default", description = "Unexpected error"),
    @APIResponse(responseCode = "200", description = "successful operation",
                 content = @Content(schema = @Schema(implementation = Pet.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "400", description = "Invalid ID supplied"),
    @APIResponse(responseCode = "404", description = "Pet not found")
  })
  @Operation(summary = "Find pet by ID.")
  Pet getPetById(@HeaderParam("Authorization") @NotNull String auth, @PathParam("petId") long petId);

  /**
   * Updates a pet in the store with form data.
   * Updates a pet resource based on the form data.
   *
   * @param auth  (not null)
   * @param petId ID of pet that needs to be updated
   * @param name Name of pet that needs to be updated (optional)
   * @param status Status of pet that needs to be updated (optional)
   * @return Pet
   */
  @POST
  @Path("/{petId}")
  @APIResponses({
    @APIResponse(responseCode = "default", description = "Unexpected error"),
    @APIResponse(responseCode = "200", description = "successful operation",
                 content = @Content(schema = @Schema(implementation = Pet.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "400", description = "Invalid input")
  })
  @Operation(summary = "Updates a pet in the store with form data.")
  Pet updatePetWithForm(@HeaderParam("Authorization") @NotNull String auth, @PathParam("petId") long petId, @QueryParam("name") String name, @QueryParam("status") String status);

  /**
   * Deletes a pet.
   * Delete a pet.
   *
   * @param auth  (not null)
   * @param apiKey  (optional)
   * @param petId Pet id to delete
   */
  @DELETE
  @Path("/{petId}")
  @APIResponses({
    @APIResponse(responseCode = "default", description = "Unexpected error"),
    @APIResponse(responseCode = "200", description = "Pet deleted"),
    @APIResponse(responseCode = "400", description = "Invalid pet value")
  })
  @Operation(summary = "Deletes a pet.")
  void deletePet(@HeaderParam("Authorization") @NotNull String auth, @HeaderParam("api_key") String apiKey, @PathParam("petId") long petId);

  /**
   * Uploads an image.
   * Upload image of the pet.
   *
   * @param auth  (not null)
   * @param petId ID of pet to update
   * @param additionalMetadata Additional Metadata (optional)
   * @param dto  (optional)
   * @return ApiResponse
   */
  @POST
  @Path("/{petId}/uploadImage")
  @Consumes(MediaType.APPLICATION_OCTET_STREAM)
  @APIResponses({
    @APIResponse(responseCode = "default", description = "Unexpected error"),
    @APIResponse(responseCode = "200", description = "successful operation",
                 content = @Content(schema = @Schema(implementation = ApiResponse.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "400", description = "No file uploaded"),
    @APIResponse(responseCode = "404", description = "Pet not found")
  })
  @Operation(summary = "Uploads an image.")
  ApiResponse uploadFile(@HeaderParam("Authorization") @NotNull String auth, @PathParam("petId") long petId, @QueryParam("additionalMetadata") String additionalMetadata, InputStream dto);
}
