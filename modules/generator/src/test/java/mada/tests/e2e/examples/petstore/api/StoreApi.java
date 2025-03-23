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
import java.util.Map;
import mada.tests.e2e.examples.petstore.dto.Order;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/store")
public interface StoreApi {

  /**
   * Returns pet inventories by status.
   * Returns a map of status codes to quantities.
   *
   * @param auth  (not null)
   * @return Map<String, Integer>
   */
  @GET
  @Path("/inventory")
  @APIResponses({
    @APIResponse(responseCode = "default", description = "Unexpected error"),
    @APIResponse(responseCode = "200", description = "successful operation",
                 content = @Content(schema = @Schema(implementation = Integer.class, type = SchemaType.ARRAY), mediaType = MediaType.APPLICATION_JSON))
  })
  @Operation(summary = "Returns pet inventories by status.")
  Map<String, Integer> getInventory(@HeaderParam("Authorization") @NotNull String auth);

  /**
   * Place an order for a pet.
   * Place a new order in the store.
   *
   * @param dto  (optional)
   * @return Order
   */
  @POST
  @Path("/order")
  @Consumes(MediaType.APPLICATION_JSON)
  @APIResponses({
    @APIResponse(responseCode = "default", description = "Unexpected error"),
    @APIResponse(responseCode = "200", description = "successful operation",
                 content = @Content(schema = @Schema(implementation = Order.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "400", description = "Invalid input"),
    @APIResponse(responseCode = "422", description = "Validation exception")
  })
  @Operation(summary = "Place an order for a pet.")
  Order placeOrder(@Valid Order dto);

  /**
   * Find purchase order by ID.
   * For valid response try integer IDs with value <= 5 or > 10. Other values will generate exceptions.
   *
   * @param orderId ID of order that needs to be fetched
   * @return Order
   */
  @GET
  @Path("/order/{orderId}")
  @APIResponses({
    @APIResponse(responseCode = "default", description = "Unexpected error"),
    @APIResponse(responseCode = "200", description = "successful operation",
                 content = @Content(schema = @Schema(implementation = Order.class), mediaType = MediaType.APPLICATION_JSON)),
    @APIResponse(responseCode = "400", description = "Invalid ID supplied"),
    @APIResponse(responseCode = "404", description = "Order not found")
  })
  @Operation(summary = "Find purchase order by ID.")
  Order getOrderById(@PathParam("orderId") long orderId);

  /**
   * Delete purchase order by identifier.
   * For valid response try integer IDs with value < 1000. Anything above 1000 or non-integers will generate API errors.
   *
   * @param orderId ID of the order that needs to be deleted
   */
  @DELETE
  @Path("/order/{orderId}")
  @APIResponses({
    @APIResponse(responseCode = "default", description = "Unexpected error"),
    @APIResponse(responseCode = "200", description = "order deleted"),
    @APIResponse(responseCode = "400", description = "Invalid ID supplied"),
    @APIResponse(responseCode = "404", description = "Order not found")
  })
  @Operation(summary = "Delete purchase order by identifier.")
  void deleteOrder(@PathParam("orderId") long orderId);
}
