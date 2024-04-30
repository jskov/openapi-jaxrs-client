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
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestClusterInformationLocalNode
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestClusterInformationLocalNode {
  public static final String JSON_PROPERTY_ADDRESS = "address";
  @JsonbProperty(JSON_PROPERTY_ADDRESS)
  private RestClusterInformationLocalNodeAddress address;

  public static final String JSON_PROPERTY_BUILD_VERSION = "buildVersion";
  @JsonbProperty(JSON_PROPERTY_BUILD_VERSION)
  @Schema(example = "7.0.0")
  private String buildVersion;

  public static final String JSON_PROPERTY_ID = "id";
  @JsonbProperty(JSON_PROPERTY_ID)
  @Schema(example = "d4fde8b1-2504-4998-a0ba-14fbe98edd4d")
  private String id;

  public static final String JSON_PROPERTY_LOCAL = "local";
  @JsonbProperty(JSON_PROPERTY_LOCAL)
  private Boolean local;

  public static final String JSON_PROPERTY_NAME = "name";
  @JsonbProperty(JSON_PROPERTY_NAME)
  @Schema(example = "foo")
  private String name;

  public RestClusterInformationLocalNode address(RestClusterInformationLocalNodeAddress address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
   **/
  @Valid
  public RestClusterInformationLocalNodeAddress getAddress() {
    return address;
  }

  public void setAddress(RestClusterInformationLocalNodeAddress address) {
    this.address = address;
  }

  public RestClusterInformationLocalNode buildVersion(String buildVersion) {
    this.buildVersion = buildVersion;
    return this;
  }

  /**
   * Get buildVersion
   * @return buildVersion
   **/
  public String getBuildVersion() {
    return buildVersion;
  }

  public void setBuildVersion(String buildVersion) {
    this.buildVersion = buildVersion;
  }

  public RestClusterInformationLocalNode id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public RestClusterInformationLocalNode local(Boolean local) {
    this.local = local;
    return this;
  }

  /**
   * Get local
   * @return local
   **/
  public Boolean isLocal() {
    return local;
  }

  public void setLocal(Boolean local) {
    this.local = local;
  }

  public RestClusterInformationLocalNode name(String name) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestClusterInformationLocalNode)) {
      return false;
    }
    RestClusterInformationLocalNode other = (RestClusterInformationLocalNode) o;
    return Objects.equals(this.address, other.address) &&
        Objects.equals(this.buildVersion, other.buildVersion) &&
        Objects.equals(this.id, other.id) &&
        Objects.equals(this.local, other.local) &&
        Objects.equals(this.name, other.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, buildVersion, id, local, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestClusterInformationLocalNode {");
    sb.append("\n    address: ").append(toIndentedString(address));
    sb.append("\n    buildVersion: ").append(toIndentedString(buildVersion));
    sb.append("\n    id: ").append(toIndentedString(id));
    sb.append("\n    local: ").append(toIndentedString(local));
    sb.append("\n    name: ").append(toIndentedString(name));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
