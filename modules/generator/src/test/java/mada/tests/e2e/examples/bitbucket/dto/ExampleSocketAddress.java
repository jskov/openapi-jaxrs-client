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
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * ExampleSocketAddress
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ExampleSocketAddress {
  public static final String JSON_PROPERTY_ADDRESS = "address";
  @JsonbProperty(JSON_PROPERTY_ADDRESS)
  @Schema(example = "node.example.com")
  private String address;

  public static final String JSON_PROPERTY_PORT = "port";
  @JsonbProperty(JSON_PROPERTY_PORT)
  @Schema(example = "8230")
  private Integer port;

  public ExampleSocketAddress address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   * @return address
   **/
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public ExampleSocketAddress port(Integer port) {
    this.port = port;
    return this;
  }

  /**
   * Get port
   * @return port
   **/
  public Integer getPort() {
    return port;
  }

  public void setPort(Integer port) {
    this.port = port;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ExampleSocketAddress)) {
      return false;
    }
    ExampleSocketAddress other = (ExampleSocketAddress) o;
    return Objects.equals(this.address, other.address) &&
        Objects.equals(this.port, other.port);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, port);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExampleSocketAddress {");
    sb.append("\n    address: ").append(toIndentedString(address));
    sb.append("\n    port: ").append(toIndentedString(port));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
