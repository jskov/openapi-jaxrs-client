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
import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestRefSyncStatus
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestRefSyncStatus {
  public static final String JSON_PROPERTY_AHEAD_REFS = "aheadRefs";
  @JsonbProperty(JSON_PROPERTY_AHEAD_REFS)
  @Schema(readOnly = true)
  private RestRefSyncStatusAheadRefs aheadRefs;

  public static final String JSON_PROPERTY_AVAILABLE = "available";
  @JsonbProperty(JSON_PROPERTY_AVAILABLE)
  @Schema(readOnly = true)
  private Boolean available;

  public static final String JSON_PROPERTY_DIVERGED_REFS = "divergedRefs";
  @JsonbProperty(JSON_PROPERTY_DIVERGED_REFS)
  @Schema(readOnly = true)
  private RestRefSyncStatusDivergedRefs divergedRefs;

  public static final String JSON_PROPERTY_ENABLED = "enabled";
  @JsonbProperty(JSON_PROPERTY_ENABLED)
  private Boolean enabled;

  public static final String JSON_PROPERTY_LAST_SYNC = "lastSync";
  @JsonbProperty(JSON_PROPERTY_LAST_SYNC)
  @Schema(readOnly = true, example = "1331038800000")
  private BigDecimal lastSync;

  public static final String JSON_PROPERTY_ORPHANED_REFS = "orphanedRefs";
  @JsonbProperty(JSON_PROPERTY_ORPHANED_REFS)
  @Schema(readOnly = true)
  private RestRefSyncStatusOrphanedRefs orphanedRefs;

  public RestRefSyncStatus aheadRefs(RestRefSyncStatusAheadRefs aheadRefs) {
    this.aheadRefs = aheadRefs;
    return this;
  }

  /**
   * Get aheadRefs
   * @return aheadRefs
   **/
  @Valid
  public RestRefSyncStatusAheadRefs getAheadRefs() {
    return aheadRefs;
  }

  public void setAheadRefs(RestRefSyncStatusAheadRefs aheadRefs) {
    this.aheadRefs = aheadRefs;
  }

  public RestRefSyncStatus available(Boolean available) {
    this.available = available;
    return this;
  }

  /**
   * Get available
   * @return available
   **/
  public Boolean isAvailable() {
    return available;
  }

  public void setAvailable(Boolean available) {
    this.available = available;
  }

  public RestRefSyncStatus divergedRefs(RestRefSyncStatusDivergedRefs divergedRefs) {
    this.divergedRefs = divergedRefs;
    return this;
  }

  /**
   * Get divergedRefs
   * @return divergedRefs
   **/
  @Valid
  public RestRefSyncStatusDivergedRefs getDivergedRefs() {
    return divergedRefs;
  }

  public void setDivergedRefs(RestRefSyncStatusDivergedRefs divergedRefs) {
    this.divergedRefs = divergedRefs;
  }

  public RestRefSyncStatus enabled(Boolean enabled) {
    this.enabled = enabled;
    return this;
  }

  /**
   * Get enabled
   * @return enabled
   **/
  public Boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public RestRefSyncStatus lastSync(BigDecimal lastSync) {
    this.lastSync = lastSync;
    return this;
  }

  /**
   * Get lastSync
   * @return lastSync
   **/
  public BigDecimal getLastSync() {
    return lastSync;
  }

  public void setLastSync(BigDecimal lastSync) {
    this.lastSync = lastSync;
  }

  public RestRefSyncStatus orphanedRefs(RestRefSyncStatusOrphanedRefs orphanedRefs) {
    this.orphanedRefs = orphanedRefs;
    return this;
  }

  /**
   * Get orphanedRefs
   * @return orphanedRefs
   **/
  @Valid
  public RestRefSyncStatusOrphanedRefs getOrphanedRefs() {
    return orphanedRefs;
  }

  public void setOrphanedRefs(RestRefSyncStatusOrphanedRefs orphanedRefs) {
    this.orphanedRefs = orphanedRefs;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestRefSyncStatus)) {
      return false;
    }
    RestRefSyncStatus other = (RestRefSyncStatus) o;
    return Objects.equals(this.aheadRefs, other.aheadRefs) &&
        Objects.equals(this.available, other.available) &&
        Objects.equals(this.divergedRefs, other.divergedRefs) &&
        Objects.equals(this.enabled, other.enabled) &&
        Objects.equals(this.lastSync, other.lastSync) &&
        Objects.equals(this.orphanedRefs, other.orphanedRefs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aheadRefs, available, divergedRefs, enabled, lastSync, orphanedRefs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestRefSyncStatus {");
    sb.append("\n    aheadRefs: ").append(toIndentedString(aheadRefs));
    sb.append("\n    available: ").append(toIndentedString(available));
    sb.append("\n    divergedRefs: ").append(toIndentedString(divergedRefs));
    sb.append("\n    enabled: ").append(toIndentedString(enabled));
    sb.append("\n    lastSync: ").append(toIndentedString(lastSync));
    sb.append("\n    orphanedRefs: ").append(toIndentedString(orphanedRefs));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
