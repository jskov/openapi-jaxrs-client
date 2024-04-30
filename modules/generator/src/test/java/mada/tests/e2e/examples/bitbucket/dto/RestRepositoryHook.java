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
import java.util.Objects;

/**
 * RestRepositoryHook
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestRepositoryHook {
  public static final String JSON_PROPERTY_CONFIGURED = "configured";
  @JsonbProperty(JSON_PROPERTY_CONFIGURED)
  private Boolean configured;

  public static final String JSON_PROPERTY_DETAILS = "details";
  @JsonbProperty(JSON_PROPERTY_DETAILS)
  private RepositoryHookDetails details;

  public static final String JSON_PROPERTY_ENABLED = "enabled";
  @JsonbProperty(JSON_PROPERTY_ENABLED)
  private Boolean enabled;

  public static final String JSON_PROPERTY_SCOPE = "scope";
  @JsonbProperty(JSON_PROPERTY_SCOPE)
  private RestRepositoryHookScope scope;

  public RestRepositoryHook configured(Boolean configured) {
    this.configured = configured;
    return this;
  }

  /**
   * Get configured
   * @return configured
   **/
  public Boolean isConfigured() {
    return configured;
  }

  public void setConfigured(Boolean configured) {
    this.configured = configured;
  }

  public RestRepositoryHook details(RepositoryHookDetails details) {
    this.details = details;
    return this;
  }

  /**
   * Get details
   * @return details
   **/
  @Valid
  public RepositoryHookDetails getDetails() {
    return details;
  }

  public void setDetails(RepositoryHookDetails details) {
    this.details = details;
  }

  public RestRepositoryHook enabled(Boolean enabled) {
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

  public RestRepositoryHook scope(RestRepositoryHookScope scope) {
    this.scope = scope;
    return this;
  }

  /**
   * Get scope
   * @return scope
   **/
  @Valid
  public RestRepositoryHookScope getScope() {
    return scope;
  }

  public void setScope(RestRepositoryHookScope scope) {
    this.scope = scope;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestRepositoryHook)) {
      return false;
    }
    RestRepositoryHook other = (RestRepositoryHook) o;
    return Objects.equals(this.configured, other.configured) &&
        Objects.equals(this.details, other.details) &&
        Objects.equals(this.enabled, other.enabled) &&
        Objects.equals(this.scope, other.scope);
  }

  @Override
  public int hashCode() {
    return Objects.hash(configured, details, enabled, scope);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestRepositoryHook {");
    sb.append("\n    configured: ").append(toIndentedString(configured));
    sb.append("\n    details: ").append(toIndentedString(details));
    sb.append("\n    enabled: ").append(toIndentedString(enabled));
    sb.append("\n    scope: ").append(toIndentedString(scope));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
