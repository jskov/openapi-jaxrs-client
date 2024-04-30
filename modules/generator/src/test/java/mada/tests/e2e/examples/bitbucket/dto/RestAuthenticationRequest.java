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
import jakarta.validation.constraints.NotNull;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestAuthenticationRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestAuthenticationRequest {
  public static final String JSON_PROPERTY_CREDENTIALS = "credentials";
  @JsonbProperty(JSON_PROPERTY_CREDENTIALS)
  @Schema(required = true)
  private Credentials credentials;

  public static final String JSON_PROPERTY_REPOSITORY_ID = "repositoryId";
  @JsonbProperty(JSON_PROPERTY_REPOSITORY_ID)
  private Integer repositoryId;

  public static final String JSON_PROPERTY_REQUIRED_PERMISSIONS_ONLY = "requiredPermissionsOnly";
  @JsonbProperty(JSON_PROPERTY_REQUIRED_PERMISSIONS_ONLY)
  private Boolean requiredPermissionsOnly;

  public RestAuthenticationRequest credentials(Credentials credentials) {
    this.credentials = Objects.requireNonNull(credentials, "Property credentials is required, cannot be null");
    return this;
  }

  /**
   * Get credentials
   * @return credentials
   **/
  @NotNull @Valid
  public Credentials getCredentials() {
    return credentials;
  }

  public void setCredentials(Credentials credentials) {
    this.credentials = Objects.requireNonNull(credentials, "Property credentials is required, cannot be null");
  }

  public RestAuthenticationRequest repositoryId(Integer repositoryId) {
    this.repositoryId = repositoryId;
    return this;
  }

  /**
   * Get repositoryId
   * @return repositoryId
   **/
  public Integer getRepositoryId() {
    return repositoryId;
  }

  public void setRepositoryId(Integer repositoryId) {
    this.repositoryId = repositoryId;
  }

  public RestAuthenticationRequest requiredPermissionsOnly(Boolean requiredPermissionsOnly) {
    this.requiredPermissionsOnly = requiredPermissionsOnly;
    return this;
  }

  /**
   * Get requiredPermissionsOnly
   * @return requiredPermissionsOnly
   **/
  public Boolean isRequiredPermissionsOnly() {
    return requiredPermissionsOnly;
  }

  public void setRequiredPermissionsOnly(Boolean requiredPermissionsOnly) {
    this.requiredPermissionsOnly = requiredPermissionsOnly;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestAuthenticationRequest)) {
      return false;
    }
    RestAuthenticationRequest other = (RestAuthenticationRequest) o;
    return Objects.equals(this.credentials, other.credentials) &&
        Objects.equals(this.repositoryId, other.repositoryId) &&
        Objects.equals(this.requiredPermissionsOnly, other.requiredPermissionsOnly);
  }

  @Override
  public int hashCode() {
    return Objects.hash(credentials, repositoryId, requiredPermissionsOnly);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestAuthenticationRequest {");
    sb.append("\n    credentials: ").append(toIndentedString(credentials));
    sb.append("\n    repositoryId: ").append(toIndentedString(repositoryId));
    sb.append("\n    requiredPermissionsOnly: ").append(toIndentedString(requiredPermissionsOnly));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
