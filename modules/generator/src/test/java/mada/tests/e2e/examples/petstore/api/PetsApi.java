/*
 * Swagger Petstore
 *
 * The version of the OpenAPI document: 1.0.0
 */

package mada.tests.e2e.examples.petstore.api;

import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import mada.tests.e2e.examples.petstore.dto.Error;
import mada.tests.e2e.examples.petstore.dto.Pet;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/pets")
public interface PetsApi {

    /**
     * List all pets.
     *
     * @param limit How many items to return at one time (max 100) (optional)
     * @return List<Pet>
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "default",
                    description = "unexpected error",
                    content = @Content(schema = @Schema(implementation = Error.class))),
            @APIResponse(
                    responseCode = "200",
                    description = "A paged array of pets",
                    content = @Content(
                            schema = @Schema(implementation = Pet.class, type = SchemaType.ARRAY)))
    })
    @Operation(summary = "List all pets")
    List<Pet> listPets(@QueryParam("limit") int limit);

    /**
     * Create a pet.
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "default",
                    description = "unexpected error",
                    content = @Content(schema = @Schema(implementation = Error.class))),
            @APIResponse(
                    responseCode = "201",
                    description = "Null response")
    })
    @Operation(summary = "Create a pet")
    void createPets();

    /**
     * Info for a specific pet.
     *
     * @param petId The id of the pet to retrieve (not null)
     * @return Pet
     */
    @GET
    @Path("/{petId}")
    @Produces(MediaType.APPLICATION_JSON)
    @APIResponses({
            @APIResponse(
                    responseCode = "default",
                    description = "unexpected error",
                    content = @Content(schema = @Schema(implementation = Error.class))),
            @APIResponse(
                    responseCode = "200",
                    description = "Expected response to a valid request",
                    content = @Content(schema = @Schema(implementation = Pet.class)))
    })
    @Operation(summary = "Info for a specific pet")
    Pet showPetById(@PathParam("petId") @NotNull String petId);
}
