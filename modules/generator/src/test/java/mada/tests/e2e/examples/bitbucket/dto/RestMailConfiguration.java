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

import jakarta.json.Json;
import jakarta.json.JsonString;
import jakarta.json.bind.adapter.JsonbAdapter;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTypeAdapter;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestMailConfiguration
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestMailConfiguration {
  public static final String JSON_PROPERTY_HOSTNAME = "hostname";
  @JsonbProperty(JSON_PROPERTY_HOSTNAME)
  @Schema(example = "smtp.example.com")
  private String hostname;

  public static final String JSON_PROPERTY_PASSWORD = "password";
  @JsonbProperty(JSON_PROPERTY_PASSWORD)
  @Schema(example = "password")
  private String password;

  public static final String JSON_PROPERTY_PORT = "port";
  @JsonbProperty(JSON_PROPERTY_PORT)
  @Schema(example = "465")
  private Integer port;

  public enum ProtocolEnum {
    SMTP("SMTP"),
    SMTPS("SMTPS");

    private final String value;

    ProtocolEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static class ProtocolEnumAdapter implements JsonbAdapter<ProtocolEnum, JsonString> {
      @Override
      public JsonString adaptToJson(ProtocolEnum e) throws Exception {
        return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public ProtocolEnum adaptFromJson(JsonString value) throws Exception {
        for (ProtocolEnum b : ProtocolEnum.values()) {
          if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
            return b;
          }
        }
        throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type ProtocolEnum");
      }
    }
  }

  public static final String JSON_PROPERTY_PROTOCOL = "protocol";
  @JsonbProperty(JSON_PROPERTY_PROTOCOL)
  @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestMailConfiguration.ProtocolEnum.ProtocolEnumAdapter.class)
  private ProtocolEnum protocol;

  public static final String JSON_PROPERTY_REQUIRE_START_TLS = "requireStartTls";
  @JsonbProperty(JSON_PROPERTY_REQUIRE_START_TLS)
  private Boolean requireStartTls;

  public static final String JSON_PROPERTY_SENDER_ADDRESS = "senderAddress";
  @JsonbProperty(JSON_PROPERTY_SENDER_ADDRESS)
  @Schema(example = "stash-no-reply@company.com")
  private String senderAddress;

  public static final String JSON_PROPERTY_USERNAME = "username";
  @JsonbProperty(JSON_PROPERTY_USERNAME)
  @Schema(example = "user")
  private String username;

  public static final String JSON_PROPERTY_USE_START_TLS = "useStartTls";
  @JsonbProperty(JSON_PROPERTY_USE_START_TLS)
  private Boolean useStartTls;

  public RestMailConfiguration hostname(String hostname) {
    this.hostname = hostname;
    return this;
  }

  /**
   * Get hostname
   * @return hostname
   **/
  public String getHostname() {
    return hostname;
  }

  public void setHostname(String hostname) {
    this.hostname = hostname;
  }

  public RestMailConfiguration password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
   **/
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public RestMailConfiguration port(Integer port) {
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

  public RestMailConfiguration protocol(ProtocolEnum protocol) {
    this.protocol = protocol;
    return this;
  }

  /**
   * Get protocol
   * @return protocol
   **/
  public ProtocolEnum getProtocol() {
    return protocol;
  }

  public void setProtocol(ProtocolEnum protocol) {
    this.protocol = protocol;
  }

  public RestMailConfiguration requireStartTls(Boolean requireStartTls) {
    this.requireStartTls = requireStartTls;
    return this;
  }

  /**
   * Get requireStartTls
   * @return requireStartTls
   **/
  public Boolean isRequireStartTls() {
    return requireStartTls;
  }

  public void setRequireStartTls(Boolean requireStartTls) {
    this.requireStartTls = requireStartTls;
  }

  public RestMailConfiguration senderAddress(String senderAddress) {
    this.senderAddress = senderAddress;
    return this;
  }

  /**
   * Get senderAddress
   * @return senderAddress
   **/
  public String getSenderAddress() {
    return senderAddress;
  }

  public void setSenderAddress(String senderAddress) {
    this.senderAddress = senderAddress;
  }

  public RestMailConfiguration username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
   **/
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public RestMailConfiguration useStartTls(Boolean useStartTls) {
    this.useStartTls = useStartTls;
    return this;
  }

  /**
   * Get useStartTls
   * @return useStartTls
   **/
  public Boolean isUseStartTls() {
    return useStartTls;
  }

  public void setUseStartTls(Boolean useStartTls) {
    this.useStartTls = useStartTls;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestMailConfiguration)) {
      return false;
    }
    RestMailConfiguration other = (RestMailConfiguration) o;
    return Objects.equals(this.hostname, other.hostname) &&
        Objects.equals(this.password, other.password) &&
        Objects.equals(this.port, other.port) &&
        Objects.equals(this.protocol, other.protocol) &&
        Objects.equals(this.requireStartTls, other.requireStartTls) &&
        Objects.equals(this.senderAddress, other.senderAddress) &&
        Objects.equals(this.username, other.username) &&
        Objects.equals(this.useStartTls, other.useStartTls);
  }

  @Override
  public int hashCode() {
    return Objects.hash(hostname, password, port, protocol, requireStartTls, senderAddress, username, useStartTls);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestMailConfiguration {");
    sb.append("\n    hostname: ").append(toIndentedString(hostname));
    sb.append("\n    password: ").append(toIndentedString(password));
    sb.append("\n    port: ").append(toIndentedString(port));
    sb.append("\n    protocol: ").append(toIndentedString(protocol));
    sb.append("\n    requireStartTls: ").append(toIndentedString(requireStartTls));
    sb.append("\n    senderAddress: ").append(toIndentedString(senderAddress));
    sb.append("\n    username: ").append(toIndentedString(username));
    sb.append("\n    useStartTls: ").append(toIndentedString(useStartTls));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
