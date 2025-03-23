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

package mada.tests.e2e.examples.petstore.dto;

import jakarta.json.Json;
import jakarta.json.JsonString;
import jakarta.json.bind.adapter.JsonbAdapter;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTypeAdapter;
import java.time.OffsetDateTime;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Order
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class Order {
  public static final String JSON_PROPERTY_COMPLETE = "complete";
  @JsonbProperty(JSON_PROPERTY_COMPLETE)
  private Boolean complete;

  public static final String JSON_PROPERTY_ID = "id";
  @JsonbProperty(JSON_PROPERTY_ID)
  @Schema(example = "10")
  private Long id;

  public static final String JSON_PROPERTY_PET_ID = "petId";
  @JsonbProperty(JSON_PROPERTY_PET_ID)
  @Schema(example = "198772")
  private Long petId;

  public static final String JSON_PROPERTY_QUANTITY = "quantity";
  @JsonbProperty(JSON_PROPERTY_QUANTITY)
  @Schema(example = "7")
  private Integer quantity;

  public static final String JSON_PROPERTY_SHIP_DATE = "shipDate";
  @JsonbProperty(JSON_PROPERTY_SHIP_DATE)
  private OffsetDateTime shipDate;

  /**
   * Order Status.
   */
  @Schema(enumeration = {"placed", "approved", "delivered"}, type = SchemaType.STRING)
  public enum StatusEnum {
    PLACED("placed"),
    APPROVED("approved"),
    DELIVERED("delivered");

    private final String value;

    StatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static class StatusEnumAdapter implements JsonbAdapter<StatusEnum, JsonString> {
      @Override
      public JsonString adaptToJson(StatusEnum e) throws Exception {
        return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public StatusEnum adaptFromJson(JsonString value) throws Exception {
        for (StatusEnum b : StatusEnum.values()) {
          if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
            return b;
          }
        }
        throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type StatusEnum");
      }
    }
  }

  public static final String JSON_PROPERTY_STATUS = "status";
  @JsonbProperty(JSON_PROPERTY_STATUS)
  @JsonbTypeAdapter(mada.tests.e2e.examples.petstore.dto.Order.StatusEnum.StatusEnumAdapter.class)
  @Schema(description = "Order Status", example = "approved")
  private StatusEnum status;

  public Order complete(Boolean complete) {
    this.complete = complete;
    return this;
  }

  /**
   * Get complete
   * @return complete
   **/
  public Boolean isComplete() {
    return complete;
  }

  public void setComplete(Boolean complete) {
    this.complete = complete;
  }

  public Order id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Order petId(Long petId) {
    this.petId = petId;
    return this;
  }

  /**
   * Get petId
   * @return petId
   **/
  public Long getPetId() {
    return petId;
  }

  public void setPetId(Long petId) {
    this.petId = petId;
  }

  public Order quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * @return quantity
   **/
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Order shipDate(OffsetDateTime shipDate) {
    this.shipDate = shipDate;
    return this;
  }

  /**
   * Get shipDate
   * @return shipDate
   **/
  public OffsetDateTime getShipDate() {
    return shipDate;
  }

  public void setShipDate(OffsetDateTime shipDate) {
    this.shipDate = shipDate;
  }

  public Order status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Order Status.
   *
   * @return status
   **/
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Order)) {
      return false;
    }
    Order other = (Order) o;
    return Objects.equals(this.complete, other.complete) &&
        Objects.equals(this.id, other.id) &&
        Objects.equals(this.petId, other.petId) &&
        Objects.equals(this.quantity, other.quantity) &&
        Objects.equals(this.shipDate, other.shipDate) &&
        Objects.equals(this.status, other.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(complete, id, petId, quantity, shipDate, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {");
    sb.append("\n    complete: ").append(toIndentedString(complete));
    sb.append("\n    id: ").append(toIndentedString(id));
    sb.append("\n    petId: ").append(toIndentedString(petId));
    sb.append("\n    quantity: ").append(toIndentedString(quantity));
    sb.append("\n    shipDate: ").append(toIndentedString(shipDate));
    sb.append("\n    status: ").append(toIndentedString(status));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
