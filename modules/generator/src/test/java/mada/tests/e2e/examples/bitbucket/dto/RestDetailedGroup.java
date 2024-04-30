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
 * RestDetailedGroup
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestDetailedGroup {
  public static final String JSON_PROPERTY_DELETABLE = "deletable";
  @JsonbProperty(JSON_PROPERTY_DELETABLE)
  private Boolean deletable;

  public static final String JSON_PROPERTY_NAME = "name";
  @JsonbProperty(JSON_PROPERTY_NAME)
  @Schema(example = "group-a")
  private String name;

  public RestDetailedGroup deletable(Boolean deletable) {
    this.deletable = deletable;
    return this;
  }

  /**
   * Get deletable
   * @return deletable
   **/
  public Boolean isDeletable() {
    return deletable;
  }

  public void setDeletable(Boolean deletable) {
    this.deletable = deletable;
  }

  public RestDetailedGroup name(String name) {
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
    if (!(o instanceof RestDetailedGroup)) {
      return false;
    }
    RestDetailedGroup other = (RestDetailedGroup) o;
    return Objects.equals(this.deletable, other.deletable) &&
        Objects.equals(this.name, other.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deletable, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestDetailedGroup {");
    sb.append("\n    deletable: ").append(toIndentedString(deletable));
    sb.append("\n    name: ").append(toIndentedString(name));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
