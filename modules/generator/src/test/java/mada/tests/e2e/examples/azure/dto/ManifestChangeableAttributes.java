/*
 * Azure Container Registry
 * Metadata API definition for the Azure Container Registry runtime
 *
 * The version of the OpenAPI document: 2019-08-15-preview
 */

package mada.tests.e2e.examples.azure.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Changeable attributes
 */
@Schema(description = "Changeable attributes")
@JsonbPropertyOrder({
  ManifestChangeableAttributes.JSON_PROPERTY_DELETE_ENABLED,
  ManifestChangeableAttributes.JSON_PROPERTY_WRITE_ENABLED,
  ManifestChangeableAttributes.JSON_PROPERTY_LIST_ENABLED,
  ManifestChangeableAttributes.JSON_PROPERTY_READ_ENABLED,
  ManifestChangeableAttributes.JSON_PROPERTY_QUARANTINE_STATE,
  ManifestChangeableAttributes.JSON_PROPERTY_QUARANTINE_DETAILS
})
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public class ManifestChangeableAttributes {
  public static final String JSON_PROPERTY_DELETE_ENABLED = "deleteEnabled";
  @JsonbProperty(JSON_PROPERTY_DELETE_ENABLED)
  @Schema(description = "Delete enabled")
  private Boolean deleteEnabled;

  public static final String JSON_PROPERTY_WRITE_ENABLED = "writeEnabled";
  @JsonbProperty(JSON_PROPERTY_WRITE_ENABLED)
  @Schema(description = "Write enabled")
  private Boolean writeEnabled;

  public static final String JSON_PROPERTY_LIST_ENABLED = "listEnabled";
  @JsonbProperty(JSON_PROPERTY_LIST_ENABLED)
  @Schema(description = "List enabled")
  private Boolean listEnabled;

  public static final String JSON_PROPERTY_READ_ENABLED = "readEnabled";
  @JsonbProperty(JSON_PROPERTY_READ_ENABLED)
  @Schema(description = "Read enabled")
  private Boolean readEnabled;

  public static final String JSON_PROPERTY_QUARANTINE_STATE = "quarantineState";
  @JsonbProperty(JSON_PROPERTY_QUARANTINE_STATE)
  @Schema(description = "Quarantine state")
  private String quarantineState;

  public static final String JSON_PROPERTY_QUARANTINE_DETAILS = "quarantineDetails";
  @JsonbProperty(JSON_PROPERTY_QUARANTINE_DETAILS)
  @Schema(description = "Quarantine details")
  private String quarantineDetails;

  public ManifestChangeableAttributes deleteEnabled(Boolean deleteEnabled) {
    this.deleteEnabled = deleteEnabled;
    return this;
  }

  /**
   * Delete enabled.
   *
   * @return deleteEnabled
   **/
  public Boolean isDeleteEnabled() {
    return deleteEnabled;
  }

  public void setDeleteEnabled(Boolean deleteEnabled) {
    this.deleteEnabled = deleteEnabled;
  }

  public ManifestChangeableAttributes writeEnabled(Boolean writeEnabled) {
    this.writeEnabled = writeEnabled;
    return this;
  }

  /**
   * Write enabled.
   *
   * @return writeEnabled
   **/
  public Boolean isWriteEnabled() {
    return writeEnabled;
  }

  public void setWriteEnabled(Boolean writeEnabled) {
    this.writeEnabled = writeEnabled;
  }

  public ManifestChangeableAttributes listEnabled(Boolean listEnabled) {
    this.listEnabled = listEnabled;
    return this;
  }

  /**
   * List enabled.
   *
   * @return listEnabled
   **/
  public Boolean isListEnabled() {
    return listEnabled;
  }

  public void setListEnabled(Boolean listEnabled) {
    this.listEnabled = listEnabled;
  }

  public ManifestChangeableAttributes readEnabled(Boolean readEnabled) {
    this.readEnabled = readEnabled;
    return this;
  }

  /**
   * Read enabled.
   *
   * @return readEnabled
   **/
  public Boolean isReadEnabled() {
    return readEnabled;
  }

  public void setReadEnabled(Boolean readEnabled) {
    this.readEnabled = readEnabled;
  }

  public ManifestChangeableAttributes quarantineState(String quarantineState) {
    this.quarantineState = quarantineState;
    return this;
  }

  /**
   * Quarantine state.
   *
   * @return quarantineState
   **/
  public String getQuarantineState() {
    return quarantineState;
  }

  public void setQuarantineState(String quarantineState) {
    this.quarantineState = quarantineState;
  }

  public ManifestChangeableAttributes quarantineDetails(String quarantineDetails) {
    this.quarantineDetails = quarantineDetails;
    return this;
  }

  /**
   * Quarantine details.
   *
   * @return quarantineDetails
   **/
  public String getQuarantineDetails() {
    return quarantineDetails;
  }

  public void setQuarantineDetails(String quarantineDetails) {
    this.quarantineDetails = quarantineDetails;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ManifestChangeableAttributes other = (ManifestChangeableAttributes) o;
    return Objects.equals(this.deleteEnabled, other.deleteEnabled) &&
        Objects.equals(this.writeEnabled, other.writeEnabled) &&
        Objects.equals(this.listEnabled, other.listEnabled) &&
        Objects.equals(this.readEnabled, other.readEnabled) &&
        Objects.equals(this.quarantineState, other.quarantineState) &&
        Objects.equals(this.quarantineDetails, other.quarantineDetails);
  }

  @Override
  public int hashCode() {
    return Objects.hash(deleteEnabled, writeEnabled, listEnabled, readEnabled, quarantineState, quarantineDetails);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ManifestChangeableAttributes {");
    sb.append("\n    deleteEnabled: ").append(toIndentedString(deleteEnabled));
    sb.append("\n    writeEnabled: ").append(toIndentedString(writeEnabled));
    sb.append("\n    listEnabled: ").append(toIndentedString(listEnabled));
    sb.append("\n    readEnabled: ").append(toIndentedString(readEnabled));
    sb.append("\n    quarantineState: ").append(toIndentedString(quarantineState));
    sb.append("\n    quarantineDetails: ").append(toIndentedString(quarantineDetails));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
