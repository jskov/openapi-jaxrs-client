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
 * AdminPasswordUpdate
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class AdminPasswordUpdate {
  public static final String JSON_PROPERTY_NAME = "name";
  @JsonbProperty(JSON_PROPERTY_NAME)
  @Schema(example = "jcitizen")
  private String name;

  public static final String JSON_PROPERTY_PASSWORD = "password";
  @JsonbProperty(JSON_PROPERTY_PASSWORD)
  @Schema(example = "my-secret-password")
  private String password;

  public static final String JSON_PROPERTY_PASSWORD_CONFIRM = "passwordConfirm";
  @JsonbProperty(JSON_PROPERTY_PASSWORD_CONFIRM)
  @Schema(example = "my-secret-password")
  private String passwordConfirm;

  public AdminPasswordUpdate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AdminPasswordUpdate password(String password) {
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

  public AdminPasswordUpdate passwordConfirm(String passwordConfirm) {
    this.passwordConfirm = passwordConfirm;
    return this;
  }

  /**
   * Get passwordConfirm
   * @return passwordConfirm
   **/
  public String getPasswordConfirm() {
    return passwordConfirm;
  }

  public void setPasswordConfirm(String passwordConfirm) {
    this.passwordConfirm = passwordConfirm;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof AdminPasswordUpdate)) {
      return false;
    }
    AdminPasswordUpdate other = (AdminPasswordUpdate) o;
    return Objects.equals(this.name, other.name) &&
        Objects.equals(this.password, other.password) &&
        Objects.equals(this.passwordConfirm, other.passwordConfirm);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, password, passwordConfirm);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AdminPasswordUpdate {");
    sb.append("\n    name: ").append(toIndentedString(name));
    sb.append("\n    password: ").append(toIndentedString(password));
    sb.append("\n    passwordConfirm: ").append(toIndentedString(passwordConfirm));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
