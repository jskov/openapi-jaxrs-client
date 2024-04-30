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
 * UserRename
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class UserRename {
  public static final String JSON_PROPERTY_NAME = "name";
  @JsonbProperty(JSON_PROPERTY_NAME)
  @Schema(example = "jcitizen")
  private String name;

  public static final String JSON_PROPERTY_NEW_NAME = "newName";
  @JsonbProperty(JSON_PROPERTY_NEW_NAME)
  @Schema(example = "jcitizen-new")
  private String newName;

  public UserRename name(String name) {
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

  public UserRename newName(String newName) {
    this.newName = newName;
    return this;
  }

  /**
   * Get newName
   * @return newName
   **/
  public String getNewName() {
    return newName;
  }

  public void setNewName(String newName) {
    this.newName = newName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UserRename)) {
      return false;
    }
    UserRename other = (UserRename) o;
    return Objects.equals(this.name, other.name) &&
        Objects.equals(this.newName, other.newName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, newName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserRename {");
    sb.append("\n    name: ").append(toIndentedString(name));
    sb.append("\n    newName: ").append(toIndentedString(newName));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
