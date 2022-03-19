/*
 * Azure Container Registry
 * Metadata API definition for the Azure Container Registry runtime
 *
 * The version of the OpenAPI document: 2019-08-15-preview
 */

package mada.tests.e2e.examples.azure.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.validation.Valid;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * List of manifest attributes
 */
@Schema(description = "List of manifest attributes")
@JsonbPropertyOrder({
  ManifestAttributes_manifest.JSON_PROPERTY_REFERENCES,
  ManifestAttributes_manifest.JSON_PROPERTY_QUARANTINE_TAG
})
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public class ManifestAttributes_manifest {
  public static final String JSON_PROPERTY_REFERENCES = "references";
  @JsonbProperty(JSON_PROPERTY_REFERENCES)
  @Schema(description = "List of manifest attributes details")
  private List<ManifestAttributes_manifest_references> references = null;

  public static final String JSON_PROPERTY_QUARANTINE_TAG = "quarantineTag";
  @JsonbProperty(JSON_PROPERTY_QUARANTINE_TAG)
  @Schema(description = "Quarantine tag name")
  private String quarantineTag;

  public ManifestAttributes_manifest references(List<ManifestAttributes_manifest_references> references) {
    this.references = references;
    return this;
  }

  public ManifestAttributes_manifest addReferencesItem(ManifestAttributes_manifest_references referencesItem) {
    if (this.references == null) {
      this.references = new ArrayList<>();
    }
    this.references.add(referencesItem);
    return this;
  }

  /**
   * List of manifest attributes details.
   *
   * @return references
   **/
  @Valid
  public List<ManifestAttributes_manifest_references> getReferences() {
    return references;
  }

  public void setReferences(List<ManifestAttributes_manifest_references> references) {
    this.references = references;
  }

  public ManifestAttributes_manifest quarantineTag(String quarantineTag) {
    this.quarantineTag = quarantineTag;
    return this;
  }

  /**
   * Quarantine tag name.
   *
   * @return quarantineTag
   **/
  public String getQuarantineTag() {
    return quarantineTag;
  }

  public void setQuarantineTag(String quarantineTag) {
    this.quarantineTag = quarantineTag;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ManifestAttributes_manifest other = (ManifestAttributes_manifest) o;
    return Objects.equals(this.references, other.references) &&
        Objects.equals(this.quarantineTag, other.quarantineTag);
  }

  @Override
  public int hashCode() {
    return Objects.hash(references, quarantineTag);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ManifestAttributes_manifest {");
    sb.append("\n    references: ").append(toIndentedString(references));
    sb.append("\n    quarantineTag: ").append(toIndentedString(quarantineTag));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
