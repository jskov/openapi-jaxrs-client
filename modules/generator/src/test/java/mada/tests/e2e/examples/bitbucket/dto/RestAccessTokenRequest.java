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
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestAccessTokenRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestAccessTokenRequest {
  public static final String JSON_PROPERTY_EXPIRY_DAYS = "expiryDays";
  @JsonbProperty(JSON_PROPERTY_EXPIRY_DAYS)
  private Integer expiryDays;

  public static final String JSON_PROPERTY_NAME = "name";
  @JsonbProperty(JSON_PROPERTY_NAME)
  @Schema(example = "My access token")
  private String name;

  public static final String JSON_PROPERTY_PERMISSIONS = "permissions";
  @JsonbProperty(JSON_PROPERTY_PERMISSIONS)
  @Schema(example = "[\"REPO_ADMIN\",\"PROJECT_READ\"]")
  private Set<String> permissions;

  public RestAccessTokenRequest expiryDays(Integer expiryDays) {
    this.expiryDays = expiryDays;
    return this;
  }

  /**
   * Get expiryDays
   * @return expiryDays
   **/
  public Integer getExpiryDays() {
    return expiryDays;
  }

  public void setExpiryDays(Integer expiryDays) {
    this.expiryDays = expiryDays;
  }

  public RestAccessTokenRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public RestAccessTokenRequest permissions(Set<String> permissions) {
    this.permissions = permissions;
    return this;
  }

  public RestAccessTokenRequest addPermissionsItem(String permissionsItem) {
    if (this.permissions == null) {
      this.permissions = new LinkedHashSet<>();
    }
    this.permissions.add(permissionsItem);
    return this;
  }

  /**
   * Get permissions
   * @return permissions
   **/
  public Set<String> getPermissions() {
    return permissions;
  }

  public void setPermissions(Set<String> permissions) {
    this.permissions = permissions;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestAccessTokenRequest)) {
      return false;
    }
    RestAccessTokenRequest other = (RestAccessTokenRequest) o;
    return Objects.equals(this.expiryDays, other.expiryDays) &&
        Objects.equals(this.name, other.name) &&
        Objects.equals(this.permissions, other.permissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expiryDays, name, permissions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestAccessTokenRequest {");
    sb.append("\n    expiryDays: ").append(toIndentedString(expiryDays));
    sb.append("\n    name: ").append(toIndentedString(name));
    sb.append("\n    permissions: ").append(toIndentedString(permissions));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
