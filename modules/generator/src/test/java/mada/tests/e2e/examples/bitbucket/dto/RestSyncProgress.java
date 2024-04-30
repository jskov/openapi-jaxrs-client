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
 * RestSyncProgress
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestSyncProgress {
  public static final String JSON_PROPERTY_DISCOVERING = "discovering";
  @JsonbProperty(JSON_PROPERTY_DISCOVERING)
  private Boolean discovering;

  public static final String JSON_PROPERTY_SYNCED_REPOS = "syncedRepos";
  @JsonbProperty(JSON_PROPERTY_SYNCED_REPOS)
  private Integer syncedRepos;

  public static final String JSON_PROPERTY_TOTAL_REPOS = "totalRepos";
  @JsonbProperty(JSON_PROPERTY_TOTAL_REPOS)
  private Integer totalRepos;

  public RestSyncProgress discovering(Boolean discovering) {
    this.discovering = discovering;
    return this;
  }

  /**
   * Get discovering
   * @return discovering
   **/
  public Boolean isDiscovering() {
    return discovering;
  }

  public void setDiscovering(Boolean discovering) {
    this.discovering = discovering;
  }

  public RestSyncProgress syncedRepos(Integer syncedRepos) {
    this.syncedRepos = syncedRepos;
    return this;
  }

  /**
   * Get syncedRepos
   * @return syncedRepos
   **/
  public Integer getSyncedRepos() {
    return syncedRepos;
  }

  public void setSyncedRepos(Integer syncedRepos) {
    this.syncedRepos = syncedRepos;
  }

  public RestSyncProgress totalRepos(Integer totalRepos) {
    this.totalRepos = totalRepos;
    return this;
  }

  /**
   * Get totalRepos
   * @return totalRepos
   **/
  public Integer getTotalRepos() {
    return totalRepos;
  }

  public void setTotalRepos(Integer totalRepos) {
    this.totalRepos = totalRepos;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestSyncProgress)) {
      return false;
    }
    RestSyncProgress other = (RestSyncProgress) o;
    return Objects.equals(this.discovering, other.discovering) &&
        Objects.equals(this.syncedRepos, other.syncedRepos) &&
        Objects.equals(this.totalRepos, other.totalRepos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(discovering, syncedRepos, totalRepos);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestSyncProgress {");
    sb.append("\n    discovering: ").append(toIndentedString(discovering));
    sb.append("\n    syncedRepos: ").append(toIndentedString(syncedRepos));
    sb.append("\n    totalRepos: ").append(toIndentedString(totalRepos));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
