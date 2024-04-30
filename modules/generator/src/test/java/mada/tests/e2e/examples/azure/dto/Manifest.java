/*
 * Azure Container Registry
 * Metadata API definition for the Azure Container Registry runtime
 *
 * The version of the OpenAPI document: 2019-08-15-preview
 */

package mada.tests.e2e.examples.azure.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Returns the requested manifest file.
 */
@Schema(description = "Returns the requested manifest file")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class Manifest {
  public static final String JSON_PROPERTY_SCHEMA_VERSION = "schemaVersion";
  @JsonbProperty(JSON_PROPERTY_SCHEMA_VERSION)
  @Schema(description = "Schema version")
  private Short schemaVersion;

  public Manifest schemaVersion(Short schemaVersion) {
    this.schemaVersion = schemaVersion;
    return this;
  }

  /**
   * Schema version.
   *
   * @return schemaVersion
   **/
  public Short getSchemaVersion() {
    return schemaVersion;
  }

  public void setSchemaVersion(Short schemaVersion) {
    this.schemaVersion = schemaVersion;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Manifest)) {
      return false;
    }
    Manifest other = (Manifest) o;
    return Objects.equals(this.schemaVersion, other.schemaVersion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(schemaVersion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Manifest {");
    sb.append("\n    schemaVersion: ").append(toIndentedString(schemaVersion));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
