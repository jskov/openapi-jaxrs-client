/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.dto.additional_properties.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * MultivaluedHashMapStringString
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class MultivaluedHashMapStringString extends HashMap<String, List<String>> {
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof MultivaluedHashMapStringString)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode());
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MultivaluedHashMapStringString {");
    sb.append("\n    ").append(toIndentedString(super.toString()));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
