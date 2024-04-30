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
import java.math.BigDecimal;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestMeshNode
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestMeshNode {
  public static final String JSON_PROPERTY_ID = "id";
  @JsonbProperty(JSON_PROPERTY_ID)
  @Schema(example = "1")
  private String id;

  public static final String JSON_PROPERTY_LAST_SEEN_DATE = "lastSeenDate";
  @JsonbProperty(JSON_PROPERTY_LAST_SEEN_DATE)
  @Schema(example = "1630041546433")
  private BigDecimal lastSeenDate;

  public static final String JSON_PROPERTY_NAME = "name";
  @JsonbProperty(JSON_PROPERTY_NAME)
  @Schema(example = "My node")
  private String name;

  public static final String JSON_PROPERTY_OFFLINE = "offline";
  @JsonbProperty(JSON_PROPERTY_OFFLINE)
  @Schema(example = "false")
  private Boolean offline;

  public static final String JSON_PROPERTY_RPC_ID = "rpcId";
  @JsonbProperty(JSON_PROPERTY_RPC_ID)
  @Schema(example = "1")
  private String rpcId;

  public static final String JSON_PROPERTY_RPC_URL = "rpcUrl";
  @JsonbProperty(JSON_PROPERTY_RPC_URL)
  @Schema(example = "http://127.0.0.1:7999")
  private String rpcUrl;

  public enum StateEnum {
    AVAILABLE("AVAILABLE"),
    DELETING("DELETING"),
    DISABLED("DISABLED"),
    DRAINING("DRAINING"),
    OFFLINE("OFFLINE");

    private final String value;

    StateEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static class StateEnumAdapter implements JsonbAdapter<StateEnum, JsonString> {
      @Override
      public JsonString adaptToJson(StateEnum e) throws Exception {
        return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public StateEnum adaptFromJson(JsonString value) throws Exception {
        for (StateEnum b : StateEnum.values()) {
          if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
            return b;
          }
        }
        throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type StateEnum");
      }
    }
  }

  public static final String JSON_PROPERTY_STATE = "state";
  @JsonbProperty(JSON_PROPERTY_STATE)
  @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestMeshNode.StateEnum.StateEnumAdapter.class)
  @Schema(example = "AVAILABLE")
  private StateEnum state;

  public RestMeshNode id(String id) {
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

  public RestMeshNode lastSeenDate(BigDecimal lastSeenDate) {
    this.lastSeenDate = lastSeenDate;
    return this;
  }

  /**
   * Get lastSeenDate
   * @return lastSeenDate
   **/
  public BigDecimal getLastSeenDate() {
    return lastSeenDate;
  }

  public void setLastSeenDate(BigDecimal lastSeenDate) {
    this.lastSeenDate = lastSeenDate;
  }

  public RestMeshNode name(String name) {
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

  public RestMeshNode offline(Boolean offline) {
    this.offline = offline;
    return this;
  }

  /**
   * Get offline
   * @return offline
   **/
  public Boolean isOffline() {
    return offline;
  }

  public void setOffline(Boolean offline) {
    this.offline = offline;
  }

  public RestMeshNode rpcId(String rpcId) {
    this.rpcId = rpcId;
    return this;
  }

  /**
   * Get rpcId
   * @return rpcId
   **/
  public String getRpcId() {
    return rpcId;
  }

  public void setRpcId(String rpcId) {
    this.rpcId = rpcId;
  }

  public RestMeshNode rpcUrl(String rpcUrl) {
    this.rpcUrl = rpcUrl;
    return this;
  }

  /**
   * Get rpcUrl
   * @return rpcUrl
   **/
  public String getRpcUrl() {
    return rpcUrl;
  }

  public void setRpcUrl(String rpcUrl) {
    this.rpcUrl = rpcUrl;
  }

  public RestMeshNode state(StateEnum state) {
    this.state = state;
    return this;
  }

  /**
   * Get state
   * @return state
   **/
  public StateEnum getState() {
    return state;
  }

  public void setState(StateEnum state) {
    this.state = state;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestMeshNode)) {
      return false;
    }
    RestMeshNode other = (RestMeshNode) o;
    return Objects.equals(this.id, other.id) &&
        Objects.equals(this.lastSeenDate, other.lastSeenDate) &&
        Objects.equals(this.name, other.name) &&
        Objects.equals(this.offline, other.offline) &&
        Objects.equals(this.rpcId, other.rpcId) &&
        Objects.equals(this.rpcUrl, other.rpcUrl) &&
        Objects.equals(this.state, other.state);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, lastSeenDate, name, offline, rpcId, rpcUrl, state);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestMeshNode {");
    sb.append("\n    id: ").append(toIndentedString(id));
    sb.append("\n    lastSeenDate: ").append(toIndentedString(lastSeenDate));
    sb.append("\n    name: ").append(toIndentedString(name));
    sb.append("\n    offline: ").append(toIndentedString(offline));
    sb.append("\n    rpcId: ").append(toIndentedString(rpcId));
    sb.append("\n    rpcUrl: ").append(toIndentedString(rpcUrl));
    sb.append("\n    state: ").append(toIndentedString(state));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
