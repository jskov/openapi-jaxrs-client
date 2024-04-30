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

/**
 * RestWebhookCredentials
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestWebhookCredentials {
  public static final String JSON_PROPERTY_PASSWORD = "password";
  @JsonbProperty(JSON_PROPERTY_PASSWORD)
  private String password;

  public static final String JSON_PROPERTY_USERNAME = "username";
  @JsonbProperty(JSON_PROPERTY_USERNAME)
  private String username;

  public RestWebhookCredentials password(String password) {
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

  public RestWebhookCredentials username(String username) {
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
    if (!(o instanceof RestWebhookCredentials)) {
      return false;
    }
    RestWebhookCredentials other = (RestWebhookCredentials) o;
    return Objects.equals(this.password, other.password) &&
        Objects.equals(this.username, other.username);
  }

  @Override
  public int hashCode() {
    return Objects.hash(password, username);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestWebhookCredentials {");
    sb.append("\n    password: ").append(toIndentedString(password));
    sb.append("\n    username: ").append(toIndentedString(username));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
