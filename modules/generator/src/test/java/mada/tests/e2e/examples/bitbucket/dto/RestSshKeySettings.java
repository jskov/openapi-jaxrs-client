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
 * RestSshKeySettings
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestSshKeySettings {
  public static final String JSON_PROPERTY_KEY_TYPE_RESTRICTIONS = "keyTypeRestrictions";
  @JsonbProperty(JSON_PROPERTY_KEY_TYPE_RESTRICTIONS)
  private List<RestSshKeyTypeRestriction> keyTypeRestrictions;

  public static final String JSON_PROPERTY_MAX_EXPIRY_DAYS = "maxExpiryDays";
  @JsonbProperty(JSON_PROPERTY_MAX_EXPIRY_DAYS)
  private RestSshKeySettingsMaxExpiryDays maxExpiryDays;

  public RestSshKeySettings keyTypeRestrictions(List<RestSshKeyTypeRestriction> keyTypeRestrictions) {
    this.keyTypeRestrictions = keyTypeRestrictions;
    return this;
  }

  public RestSshKeySettings addKeyTypeRestrictionsItem(RestSshKeyTypeRestriction keyTypeRestrictionsItem) {
    if (this.keyTypeRestrictions == null) {
      this.keyTypeRestrictions = new ArrayList<>();
    }
    this.keyTypeRestrictions.add(keyTypeRestrictionsItem);
    return this;
  }

  /**
   * Get keyTypeRestrictions
   * @return keyTypeRestrictions
   **/
  @Valid
  public List<RestSshKeyTypeRestriction> getKeyTypeRestrictions() {
    return keyTypeRestrictions;
  }

  public void setKeyTypeRestrictions(List<RestSshKeyTypeRestriction> keyTypeRestrictions) {
    this.keyTypeRestrictions = keyTypeRestrictions;
  }

  public RestSshKeySettings maxExpiryDays(RestSshKeySettingsMaxExpiryDays maxExpiryDays) {
    this.maxExpiryDays = maxExpiryDays;
    return this;
  }

  /**
   * Get maxExpiryDays
   * @return maxExpiryDays
   **/
  @Valid
  public RestSshKeySettingsMaxExpiryDays getMaxExpiryDays() {
    return maxExpiryDays;
  }

  public void setMaxExpiryDays(RestSshKeySettingsMaxExpiryDays maxExpiryDays) {
    this.maxExpiryDays = maxExpiryDays;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestSshKeySettings)) {
      return false;
    }
    RestSshKeySettings other = (RestSshKeySettings) o;
    return Objects.equals(this.keyTypeRestrictions, other.keyTypeRestrictions) &&
        Objects.equals(this.maxExpiryDays, other.maxExpiryDays);
  }

  @Override
  public int hashCode() {
    return Objects.hash(keyTypeRestrictions, maxExpiryDays);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestSshKeySettings {");
    sb.append("\n    keyTypeRestrictions: ").append(toIndentedString(keyTypeRestrictions));
    sb.append("\n    maxExpiryDays: ").append(toIndentedString(maxExpiryDays));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
