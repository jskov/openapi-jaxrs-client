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
 * UserUpdate
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class UserUpdate {
  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
  @JsonbProperty(JSON_PROPERTY_DISPLAY_NAME)
  @Schema(example = "Jane Citizen")
  private String displayName;

  public static final String JSON_PROPERTY_EMAIL = "email";
  @JsonbProperty(JSON_PROPERTY_EMAIL)
  @Schema(example = "jane@example.com")
  private String email;

  public static final String JSON_PROPERTY_NAME = "name";
  @JsonbProperty(JSON_PROPERTY_NAME)
  @Schema(example = "jcitizen")
  private String name;

  public UserUpdate displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

  /**
   * Get displayName
   * @return displayName
   **/
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public UserUpdate email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   **/
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public UserUpdate name(String name) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UserUpdate)) {
      return false;
    }
    UserUpdate other = (UserUpdate) o;
    return Objects.equals(this.displayName, other.displayName) &&
        Objects.equals(this.email, other.email) &&
        Objects.equals(this.name, other.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(displayName, email, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserUpdate {");
    sb.append("\n    displayName: ").append(toIndentedString(displayName));
    sb.append("\n    email: ").append(toIndentedString(email));
    sb.append("\n    name: ").append(toIndentedString(name));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
