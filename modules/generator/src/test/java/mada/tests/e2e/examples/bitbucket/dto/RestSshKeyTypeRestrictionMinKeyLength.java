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
 * RestSshKeyTypeRestrictionMinKeyLength
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestSshKeyTypeRestrictionMinKeyLength {
  public static final String JSON_PROPERTY_AS_INT = "asInt";
  @JsonbProperty(JSON_PROPERTY_AS_INT)
  private Integer asInt;

  public static final String JSON_PROPERTY_PRESENT = "present";
  @JsonbProperty(JSON_PROPERTY_PRESENT)
  private Boolean present;

  public RestSshKeyTypeRestrictionMinKeyLength asInt(Integer asInt) {
    this.asInt = asInt;
    return this;
  }

  /**
   * Get asInt
   * @return asInt
   **/
  public Integer getAsInt() {
    return asInt;
  }

  public void setAsInt(Integer asInt) {
    this.asInt = asInt;
  }

  public RestSshKeyTypeRestrictionMinKeyLength present(Boolean present) {
    this.present = present;
    return this;
  }

  /**
   * Get present
   * @return present
   **/
  public Boolean isPresent() {
    return present;
  }

  public void setPresent(Boolean present) {
    this.present = present;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestSshKeyTypeRestrictionMinKeyLength)) {
      return false;
    }
    RestSshKeyTypeRestrictionMinKeyLength other = (RestSshKeyTypeRestrictionMinKeyLength) o;
    return Objects.equals(this.asInt, other.asInt) &&
        Objects.equals(this.present, other.present);
  }

  @Override
  public int hashCode() {
    return Objects.hash(asInt, present);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestSshKeyTypeRestrictionMinKeyLength {");
    sb.append("\n    asInt: ").append(toIndentedString(asInt));
    sb.append("\n    present: ").append(toIndentedString(present));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
