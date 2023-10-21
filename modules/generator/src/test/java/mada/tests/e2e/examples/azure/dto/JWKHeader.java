/*
 * Azure Container Registry
 * Metadata API definition for the Azure Container Registry runtime
 *
 * The version of the OpenAPI document: 2019-08-15-preview
 */

package mada.tests.e2e.examples.azure.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * JSON web key parameter
 */
@Schema(description = "JSON web key parameter")
@JsonbPropertyOrder({
  JWKHeader.JSON_PROPERTY_CRV,
  JWKHeader.JSON_PROPERTY_KID,
  JWKHeader.JSON_PROPERTY_KTY,
  JWKHeader.JSON_PROPERTY_X,
  JWKHeader.JSON_PROPERTY_Y
})
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public class JWKHeader {
  public static final String JSON_PROPERTY_CRV = "crv";
  @JsonbProperty(JSON_PROPERTY_CRV)
  @Schema(description = "crv value")
  private String crv;

  public static final String JSON_PROPERTY_KID = "kid";
  @JsonbProperty(JSON_PROPERTY_KID)
  @Schema(description = "kid value")
  private String kid;

  public static final String JSON_PROPERTY_KTY = "kty";
  @JsonbProperty(JSON_PROPERTY_KTY)
  @Schema(description = "kty value")
  private String kty;

  public static final String JSON_PROPERTY_X = "x";
  @JsonbProperty(JSON_PROPERTY_X)
  @Schema(description = "x value")
  private String x;

  public static final String JSON_PROPERTY_Y = "y";
  @JsonbProperty(JSON_PROPERTY_Y)
  @Schema(description = "y value")
  private String y;

  public JWKHeader crv(String crv) {
    this.crv = crv;
    return this;
  }

  /**
   * crv value.
   *
   * @return crv
   **/
  public String getCrv() {
    return crv;
  }

  public void setCrv(String crv) {
    this.crv = crv;
  }

  public JWKHeader kid(String kid) {
    this.kid = kid;
    return this;
  }

  /**
   * kid value.
   *
   * @return kid
   **/
  public String getKid() {
    return kid;
  }

  public void setKid(String kid) {
    this.kid = kid;
  }

  public JWKHeader kty(String kty) {
    this.kty = kty;
    return this;
  }

  /**
   * kty value.
   *
   * @return kty
   **/
  public String getKty() {
    return kty;
  }

  public void setKty(String kty) {
    this.kty = kty;
  }

  public JWKHeader x(String x) {
    this.x = x;
    return this;
  }

  /**
   * x value.
   *
   * @return x
   **/
  public String getX() {
    return x;
  }

  public void setX(String x) {
    this.x = x;
  }

  public JWKHeader y(String y) {
    this.y = y;
    return this;
  }

  /**
   * y value.
   *
   * @return y
   **/
  public String getY() {
    return y;
  }

  public void setY(String y) {
    this.y = y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    JWKHeader other = (JWKHeader) o;
    return Objects.equals(this.crv, other.crv) &&
        Objects.equals(this.kid, other.kid) &&
        Objects.equals(this.kty, other.kty) &&
        Objects.equals(this.x, other.x) &&
        Objects.equals(this.y, other.y);
  }

  @Override
  public int hashCode() {
    return Objects.hash(crv, kid, kty, x, y);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class JWKHeader {");
    sb.append("\n    crv: ").append(toIndentedString(crv));
    sb.append("\n    kid: ").append(toIndentedString(kid));
    sb.append("\n    kty: ").append(toIndentedString(kty));
    sb.append("\n    x: ").append(toIndentedString(x));
    sb.append("\n    y: ").append(toIndentedString(y));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
