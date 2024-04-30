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
 * CredentialsNull
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class CredentialsNull {
  public static final String JSON_PROPERTY_ALGORITHM = "algorithm";
  @JsonbProperty(JSON_PROPERTY_ALGORITHM)
  @Schema(nullable = true, description = "The key algorithm, if passing in a legacy X.509 encoded key. Do not specify for OpenSSH encoded keys", example = "RSA")
  private String algorithm;

  public static final String JSON_PROPERTY_PASSWORD = "password";
  @JsonbProperty(JSON_PROPERTY_PASSWORD)
  @Schema(nullable = true, example = "secr3t")
  private String password;

  public static final String JSON_PROPERTY_PUBLIC_KEY = "publicKey";
  @JsonbProperty(JSON_PROPERTY_PUBLIC_KEY)
  @Schema(nullable = true, description = "The public key text in the OpenSSH format. The algorithm must be specified in case of the legacy X.509 keys", example = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIKjFjYCLJjrIY/jCXPbJ9wd3drcGospvPkKFNZ1ZcacA test@test.local")
  private String publicKey;

  public static final String JSON_PROPERTY_TOKEN = "token";
  @JsonbProperty(JSON_PROPERTY_TOKEN)
  @Schema(nullable = true, example = "safe-secret")
  private String token;

  public static final String JSON_PROPERTY_USERNAME = "username";
  @JsonbProperty(JSON_PROPERTY_USERNAME)
  @Schema(nullable = true, example = "user1")
  private String username;

  public CredentialsNull algorithm(String algorithm) {
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

  public CredentialsNull password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
   **/
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public CredentialsNull publicKey(String publicKey) {
    this.publicKey = publicKey;
    return this;
  }

  /**
   * The public key text in the OpenSSH format. The algorithm must be specified in case of the legacy X.509 keys
   *
   * @return publicKey
   **/
  public String getPublicKey() {
    return publicKey;
  }

  public void setPublicKey(String publicKey) {
    this.publicKey = publicKey;
  }

  public CredentialsNull token(String token) {
    this.token = token;
    return this;
  }

  /**
   * Get token
   * @return token
   **/
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public CredentialsNull username(String username) {
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
    if (!(o instanceof CredentialsNull)) {
      return false;
    }
    CredentialsNull other = (CredentialsNull) o;
    return Objects.equals(this.algorithm, other.algorithm) &&
        Objects.equals(this.password, other.password) &&
        Objects.equals(this.publicKey, other.publicKey) &&
        Objects.equals(this.token, other.token) &&
        Objects.equals(this.username, other.username);
  }

  @Override
  public int hashCode() {
    return Objects.hash(algorithm, password, publicKey, token, username);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CredentialsNull {");
    sb.append("\n    algorithm: ").append(toIndentedString(algorithm));
    sb.append("\n    password: ").append(toIndentedString(password));
    sb.append("\n    publicKey: ").append(toIndentedString(publicKey));
    sb.append("\n    token: ").append(toIndentedString(token));
    sb.append("\n    username: ").append(toIndentedString(username));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
