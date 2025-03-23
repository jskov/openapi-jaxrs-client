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
import java.util.List;
import mada.tests.e2e.examples.petstore.dto.User;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/user")
public interface UserApi {

  /**
   * Create user.
   * This can only be done by the logged in user.
   *
   * @param dto Created user object (optional)
   * @return User
   */
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "default", description = "Unexpected error"),
    @APIResponse(responseCode = "200", description = "successful operation",
                 content = @Content(schema = @Schema(implementation = User.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Create user.")
  User createUser(@Valid User dto);

  /**
   * Creates list of users with given input array.
   * Creates list of users with given input array.
   *
   * @param dto  (optional)
   * @return User
   */
  @POST
  @Path("/createWithList")
  @Consumes(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "default", description = "Unexpected error"),
    @APIResponse(responseCode = "200", description = "Successful operation",
                 content = @Content(schema = @Schema(implementation = User.class), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Creates list of users with given input array.")
  User createUsersWithListInput(@Valid List<User> dto);

  /**
   * Logs user into the system.
   * Log into the system.
   *
   * @param username The user name for login (optional)
   * @param password The password for login in clear text (optional)
   * @return String
   */
  @GET
  @Path("/login")
  @APIResponses({
    @APIResponse(responseCode = "default", description = "Unexpected error"),
    @APIResponse(responseCode = "200", description = "successful operation",
                 content = @Content(schema = @Schema(implementation = String.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "400", description = "Invalid username/password supplied")
  })
  @Operation(summary = "Logs user into the system.")
  String loginUser(@QueryParam("username") String username, @QueryParam("password") String password);

  /**
   * Logs out current logged in user session.
   * Log user out of the system.
   */
  @GET
  @Path("/logout")
  @APIResponses({
    @APIResponse(responseCode = "default", description = "Unexpected error"),
    @APIResponse(responseCode = "200", description = "successful operation")
  })
  @Operation(summary = "Logs out current logged in user session.")
  void logoutUser();

  /**
   * Get user by user name.
   * Get user detail based on username.
   *
   * @param username The name that needs to be fetched. Use user1 for testing (not null)
   * @return User
   */
  @GET
  @Path("/{username}")
  @APIResponses({
    @APIResponse(responseCode = "default", description = "Unexpected error"),
    @APIResponse(responseCode = "200", description = "successful operation",
                 content = @Content(schema = @Schema(implementation = User.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "400", description = "Invalid username supplied"),
    @APIResponse(responseCode = "404", description = "User not found")
  })
  @Operation(summary = "Get user by user name.")
  User getUserByName(@PathParam("username") @NotNull String username);

  /**
   * Update user resource.
   * This can only be done by the logged in user.
   *
   * @param username name that need to be deleted (not null)
   * @param dto Update an existent user in the store (optional)
   */
  @PUT
  @Path("/{username}")
  @Consumes(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "default", description = "Unexpected error"),
    @APIResponse(responseCode = "200", description = "successful operation"),
    @APIResponse(responseCode = "400", description = "bad request"),
    @APIResponse(responseCode = "404", description = "user not found")
  })
  @Operation(summary = "Update user resource.")
  void updateUser(@PathParam("username") @NotNull String username, @Valid User dto);

  /**
   * Delete user resource.
   * This can only be done by the logged in user.
   *
   * @param username The name that needs to be deleted (not null)
   */
  @DELETE
  @Path("/{username}")
  @APIResponses({
    @APIResponse(responseCode = "default", description = "Unexpected error"),
    @APIResponse(responseCode = "200", description = "User deleted"),
    @APIResponse(responseCode = "400", description = "Invalid username supplied"),
    @APIResponse(responseCode = "404", description = "User not found")
  })
  @Operation(summary = "Delete user resource.")
  void deleteUser(@PathParam("username") @NotNull String username);
}
