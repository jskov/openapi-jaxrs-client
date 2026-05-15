/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.opts.generator.validation.jakarta.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import java.util.Objects;
import java.util.UUID;

/**
 * ZLicense
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ZLicense {
  public static final String JSON_PROPERTY_UUID = "uuid";
  @JsonbProperty(JSON_PROPERTY_UUID)
  private UUID uuid;

  public ZLicense uuid(UUID uuid) {
    this.uuid = uuid;
    return this;
  }

  /**
   * Get uuid
   * @return uuid
   **/
  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ZLicense)) {
      return false;
    }
    ZLicense other = (ZLicense) o;
    return Objects.equals(this.uuid, other.uuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ZLicense {");
    sb.append("\n    uuid: ").append(toIndentedString(uuid));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
