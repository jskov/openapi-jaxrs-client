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
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * RestHookScriptTriggers
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestHookScriptTriggers {
  public static final String JSON_PROPERTY_TRIGGER_IDS = "triggerIds";
  @JsonbProperty(JSON_PROPERTY_TRIGGER_IDS)
  private Set<String> triggerIds;

  public RestHookScriptTriggers triggerIds(Set<String> triggerIds) {
    this.triggerIds = triggerIds;
    return this;
  }

  public RestHookScriptTriggers addTriggerIdsItem(String triggerIdsItem) {
    if (this.triggerIds == null) {
      this.triggerIds = new LinkedHashSet<>();
    }
    this.triggerIds.add(triggerIdsItem);
    return this;
  }

  /**
   * Get triggerIds
   * @return triggerIds
   **/
  public Set<String> getTriggerIds() {
    return triggerIds;
  }

  public void setTriggerIds(Set<String> triggerIds) {
    this.triggerIds = triggerIds;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestHookScriptTriggers)) {
      return false;
    }
    RestHookScriptTriggers other = (RestHookScriptTriggers) o;
    return Objects.equals(this.triggerIds, other.triggerIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(triggerIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestHookScriptTriggers {");
    sb.append("\n    triggerIds: ").append(toIndentedString(triggerIds));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
