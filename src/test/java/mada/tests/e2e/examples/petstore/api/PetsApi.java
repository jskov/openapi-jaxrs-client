/*
 * Swagger Petstore
 *
 * The version of the OpenAPI document: 1.0.0
 */

package mada.tests.e2e.examples.petstore.api;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.examples.petstore.dto.Error;
import mada.tests.e2e.examples.petstore.dto.Pet;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/pets")
public interface PetsApi {

  /**
   * List all pets.
   *
   * @param limit  (optional)
   * @return List&lt;Pet&gt;
   */
  @GET
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
  @APIResponses({
    @APIResponse(responseCode = "200", description = "A paged array of pets",
                 content = @Content(schema = @Schema(implementation = Pet.class, type = SchemaType.ARRAY))),
    @APIResponse(responseCode = "default", description = "unexpected error",
                 content = @Content(schema = @Schema(implementation = Error.class)))
  })
  @Operation(summary = "List all pets")
  List<Pet> listPets(@QueryParam("limit") int limit);

  /**
   * Create a pet.
   *
   * @return Error
   */
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "201", description = "Null response"),
    @APIResponse(responseCode = "default", description = "unexpected error",
                 content = @Content(schema = @Schema(implementation = Error.class)))
  })
  @Operation(summary = "Create a pet")
  Error createPets();

  /**
   * Info for a specific pet.
   *
   * @param petId  (required)
   * @return Pet
   */
  @GET
  @Path("/{petId}")
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON})
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Expected response to a valid request",
                 content = @Content(schema = @Schema(implementation = Pet.class))),
    @APIResponse(responseCode = "default", description = "unexpected error",
                 content = @Content(schema = @Schema(implementation = Error.class)))
  })
  @Operation(summary = "Info for a specific pet")
  Pet showPetById(@PathParam("petId") String petId);
}
