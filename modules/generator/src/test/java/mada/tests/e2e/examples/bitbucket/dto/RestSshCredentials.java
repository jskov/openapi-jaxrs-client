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
import jakarta.validation.constraints.NotNull;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestSshCredentials
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestSshCredentials {
  public static final String JSON_PROPERTY_ALGORITHM = "algorithm";
  @JsonbProperty(JSON_PROPERTY_ALGORITHM)
  @Schema(description = "The key algorithm, if passing in a legacy X.509 encoded key. Do not specify for OpenSSH encoded keys", example = "RSA")
  private String algorithm;

  public static final String JSON_PROPERTY_PUBLIC_KEY = "publicKey";
  @JsonbProperty(JSON_PROPERTY_PUBLIC_KEY)
  @Schema(required = true, description = "The public key text in the OpenSSH format. The algorithm must be specified in case of the legacy X.509 keys", example = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIKjFjYCLJjrIY/jCXPbJ9wd3drcGospvPkKFNZ1ZcacA test@test.local")
  private String publicKey;

  public static final String JSON_PROPERTY_USERNAME = "username";
  @JsonbProperty(JSON_PROPERTY_USERNAME)
  @Schema(example = "git")
  private String username;

  public RestSshCredentials algorithm(String algorithm) {
    this.algorithm = algorithm;
    return this;
  }

  /**
   * The key algorithm, if passing in a legacy X.509 encoded key. Do not specify for OpenSSH encoded keys
   *
   * @return algorithm
   **/
  public String getAlgorithm() {
    return algorithm;
  }

  public void setAlgorithm(String algorithm) {
    this.algorithm = algorithm;
  }

  public RestSshCredentials publicKey(String publicKey) {
    this.publicKey = Objects.requireNonNull(publicKey, "Property publicKey is required, cannot be null");
    return this;
  }

  /**
   * The public key text in the OpenSSH format. The algorithm must be specified in case of the legacy X.509 keys
   *
   * @return publicKey
   **/
  @NotNull
  public String getPublicKey() {
    return publicKey;
  }

  public void setPublicKey(String publicKey) {
    this.publicKey = Objects.requireNonNull(publicKey, "Property publicKey is required, cannot be null");
  }

  public RestSshCredentials username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
   **/
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestSshCredentials)) {
      return false;
    }
    RestSshCredentials other = (RestSshCredentials) o;
    return Objects.equals(this.algorithm, other.algorithm) &&
        Objects.equals(this.publicKey, other.publicKey) &&
        Objects.equals(this.username, other.username);
  }

  @Override
  public int hashCode() {
    return Objects.hash(algorithm, publicKey, username);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestSshCredentials {");
    sb.append("\n    algorithm: ").append(toIndentedString(algorithm));
    sb.append("\n    publicKey: ").append(toIndentedString(publicKey));
    sb.append("\n    username: ").append(toIndentedString(username));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
