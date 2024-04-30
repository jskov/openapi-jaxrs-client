/*
 * Bitbucket Data Center
 * This is the reference document for the Atlassian Bitbucket REST API. The REST API is for developers who want to:

 - integrate Bitbucket with other applications;

 - create scripts that interact with Bitbucket; or

 - develop plugins that enhance the Bitbucket UI, using REST to interact with the backend.

 You can read more about developing Bitbucket plugins in the [Bitbucket Developer Documentation](https://developer.atlassian.com/bitbucket/server/docs/latest/).
 *
 * The version of the OpenAPI document: 8.19
 */

package mada.tests.e2e.examples.bitbucket.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestX509Certificate
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestX509Certificate {
  public static final String JSON_PROPERTY_FINGERPRINT = "fingerprint";
  @JsonbProperty(JSON_PROPERTY_FINGERPRINT)
  @Schema(description = "The SHA-256 fingerprint of the X.509 certificate", example = "e5e8d632c0b86f5bd5ef9a0d55c58ba1fd7776f6bb7c35ca23d85d23281ce58f")
  private String fingerprint;

  public static final String JSON_PROPERTY_ID = "id";
  @JsonbProperty(JSON_PROPERTY_ID)
  @Schema(description = "The ID of the X.509 certificate", example = "7")
  private Long id;

  public RestX509Certificate fingerprint(String fingerprint) {
    this.fingerprint = fingerprint;
    return this;
  }

  /**
   * The SHA-256 fingerprint of the X.509 certificate
   *
   * @return fingerprint
   **/
  public String getFingerprint() {
    return fingerprint;
  }

  public void setFingerprint(String fingerprint) {
    this.fingerprint = fingerprint;
  }

  public RestX509Certificate id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * The ID of the X.509 certificate
   *
   * @return id
   **/
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestX509Certificate)) {
      return false;
    }
    RestX509Certificate other = (RestX509Certificate) o;
    return Objects.equals(this.fingerprint, other.fingerprint) &&
        Objects.equals(this.id, other.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fingerprint, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestX509Certificate {");
    sb.append("\n    fingerprint: ").append(toIndentedString(fingerprint));
    sb.append("\n    id: ").append(toIndentedString(id));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
