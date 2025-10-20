/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.dto.additional_properties.dto;

import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

/**
 * MultivaluedHashSetStringString
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class MultivaluedHashSetStringString extends HashMap<String, Set<String>> {
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof MultivaluedHashSetStringString)) {
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
    sb.append("class MultivaluedHashSetStringString {");
    sb.append("\n    ").append(toIndentedString(super.toString()));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
