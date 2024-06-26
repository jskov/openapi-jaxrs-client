/*
 * Azure Container Registry
 * Metadata API definition for the Azure Container Registry runtime
 *
 * The version of the OpenAPI document: 2019-08-15-preview
 */

package mada.tests.e2e.examples.azure.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.Valid;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Signature of a signed manifest.
 */
@Schema(description = "Signature of a signed manifest")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ImageSignature {
  public static final String JSON_PROPERTY_HEADER = "header";
  @JsonbProperty(JSON_PROPERTY_HEADER)
  private JWK header;

  public static final String JSON_PROPERTY_PROTECTED = "protected";
  @JsonbProperty(JSON_PROPERTY_PROTECTED)
  @Schema(description = "The signed protected header")
  private String protected_;

  public static final String JSON_PROPERTY_SIGNATURE = "signature";
  @JsonbProperty(JSON_PROPERTY_SIGNATURE)
  @Schema(description = "A signature for the image manifest, signed by a libtrust private key")
  private String signature;

  public ImageSignature header(JWK header) {
    this.header = header;
    return this;
  }

  /**
   * Get header
   * @return header
   **/
  @Valid
  public JWK getHeader() {
    return header;
  }

  public void setHeader(JWK header) {
    this.header = header;
  }

  public ImageSignature protected_(String protected_) {
    this.protected_ = protected_;
    return this;
  }

  /**
   * The signed protected header.
   *
   * @return protected_
   **/
  public String getProtected() {
    return protected_;
  }

  public void setProtected(String protected_) {
    this.protected_ = protected_;
  }

  public ImageSignature signature(String signature) {
    this.signature = signature;
    return this;
  }

  /**
   * A signature for the image manifest, signed by a libtrust private key.
   *
   * @return signature
   **/
  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ImageSignature)) {
      return false;
    }
    ImageSignature other = (ImageSignature) o;
    return Objects.equals(this.header, other.header) &&
        Objects.equals(this.protected_, other.protected_) &&
        Objects.equals(this.signature, other.signature);
  }

  @Override
  public int hashCode() {
    return Objects.hash(header, protected_, signature);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ImageSignature {");
    sb.append("\n    header: ").append(toIndentedString(header));
    sb.append("\n    protected_: ").append(toIndentedString(protected_));
    sb.append("\n    signature: ").append(toIndentedString(signature));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
