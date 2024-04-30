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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * RestRefSyncQueue
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestRefSyncQueue {
  public static final String JSON_PROPERTY_VALUES = "values";
  @JsonbProperty(JSON_PROPERTY_VALUES)
  private List<RestFarmSynchronizationRequest> values;

  public RestRefSyncQueue values(List<RestFarmSynchronizationRequest> values) {
    this.values = values;
    return this;
  }

  public RestRefSyncQueue addValuesItem(RestFarmSynchronizationRequest valuesItem) {
    if (this.values == null) {
      this.values = new ArrayList<>();
    }
    this.values.add(valuesItem);
    return this;
  }

  /**
   * Get values
   * @return values
   **/
  @Valid
  public List<RestFarmSynchronizationRequest> getValues() {
    return values;
  }

  public void setValues(List<RestFarmSynchronizationRequest> values) {
    this.values = values;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestRefSyncQueue)) {
      return false;
    }
    RestRefSyncQueue other = (RestRefSyncQueue) o;
    return Objects.equals(this.values, other.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestRefSyncQueue {");
    sb.append("\n    values: ").append(toIndentedString(values));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
