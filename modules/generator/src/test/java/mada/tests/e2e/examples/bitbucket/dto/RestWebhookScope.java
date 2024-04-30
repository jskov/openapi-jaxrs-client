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
 * RestWebhookScope
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestWebhookScope {
  public static final String JSON_PROPERTY_ID = "id";
  @JsonbProperty(JSON_PROPERTY_ID)
  private String id;

  public static final String JSON_PROPERTY_TYPE = "type";
  @JsonbProperty(JSON_PROPERTY_TYPE)
  private String type;

  public RestWebhookScope id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public RestWebhookScope type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   **/
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestWebhookScope)) {
      return false;
    }
    RestWebhookScope other = (RestWebhookScope) o;
    return Objects.equals(this.id, other.id) &&
        Objects.equals(this.type, other.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestWebhookScope {");
    sb.append("\n    id: ").append(toIndentedString(id));
    sb.append("\n    type: ").append(toIndentedString(type));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
