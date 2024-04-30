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
 * RestTag
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestTag {
  public static final String JSON_PROPERTY_DISPLAY_ID = "displayId";
  @JsonbProperty(JSON_PROPERTY_DISPLAY_ID)
  @Schema(example = "master")
  private String displayId;

  public static final String JSON_PROPERTY_HASH = "hash";
  @JsonbProperty(JSON_PROPERTY_HASH)
  @Schema(example = "8d51122def5632836d1cb1026e879069e10a1e13")
  private String hash;

  public static final String JSON_PROPERTY_ID = "id";
  @JsonbProperty(JSON_PROPERTY_ID)
  @Schema(example = "refs/heads/master")
  private String id;

  public static final String JSON_PROPERTY_LATEST_CHANGESET = "latestChangeset";
  @JsonbProperty(JSON_PROPERTY_LATEST_CHANGESET)
  @Schema(readOnly = true, example = "8d51122def5632836d1cb1026e879069e10a1e13")
  private String latestChangeset;

  public static final String JSON_PROPERTY_LATEST_COMMIT = "latestCommit";
  @JsonbProperty(JSON_PROPERTY_LATEST_COMMIT)
  @Schema(readOnly = true, example = "8d51122def5632836d1cb1026e879069e10a1e13")
  private String latestCommit;

  public enum TypeEnum {
    BRANCH("BRANCH"),
    TAG("TAG");

    private final String value;

    TypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static class TypeEnumAdapter implements JsonbAdapter<TypeEnum, JsonString> {
      @Override
      public JsonString adaptToJson(TypeEnum e) throws Exception {
        return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public TypeEnum adaptFromJson(JsonString value) throws Exception {
        for (TypeEnum b : TypeEnum.values()) {
          if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
            return b;
          }
        }
        throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type TypeEnum");
      }
    }
  }

  public static final String JSON_PROPERTY_TYPE = "type";
  @JsonbProperty(JSON_PROPERTY_TYPE)
  @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestTag.TypeEnum.TypeEnumAdapter.class)
  private TypeEnum type;

  public RestTag displayId(String displayId) {
    this.displayId = displayId;
    return this;
  }

  /**
   * Get displayId
   * @return displayId
   **/
  public String getDisplayId() {
    return displayId;
  }

  public void setDisplayId(String displayId) {
    this.displayId = displayId;
  }

  public RestTag hash(String hash) {
    this.hash = hash;
    return this;
  }

  /**
   * Get hash
   * @return hash
   **/
  public String getHash() {
    return hash;
  }

  public void setHash(String hash) {
    this.hash = hash;
  }

  public RestTag id(String id) {
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

  public RestTag latestChangeset(String latestChangeset) {
    this.latestChangeset = latestChangeset;
    return this;
  }

  /**
   * Get latestChangeset
   * @return latestChangeset
   **/
  public String getLatestChangeset() {
    return latestChangeset;
  }

  public void setLatestChangeset(String latestChangeset) {
    this.latestChangeset = latestChangeset;
  }

  public RestTag latestCommit(String latestCommit) {
    this.latestCommit = latestCommit;
    return this;
  }

  /**
   * Get latestCommit
   * @return latestCommit
   **/
  public String getLatestCommit() {
    return latestCommit;
  }

  public void setLatestCommit(String latestCommit) {
    this.latestCommit = latestCommit;
  }

  public RestTag type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   **/
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestTag)) {
      return false;
    }
    RestTag other = (RestTag) o;
    return Objects.equals(this.displayId, other.displayId) &&
        Objects.equals(this.hash, other.hash) &&
        Objects.equals(this.id, other.id) &&
        Objects.equals(this.latestChangeset, other.latestChangeset) &&
        Objects.equals(this.latestCommit, other.latestCommit) &&
        Objects.equals(this.type, other.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(displayId, hash, id, latestChangeset, latestCommit, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestTag {");
    sb.append("\n    displayId: ").append(toIndentedString(displayId));
    sb.append("\n    hash: ").append(toIndentedString(hash));
    sb.append("\n    id: ").append(toIndentedString(id));
    sb.append("\n    latestChangeset: ").append(toIndentedString(latestChangeset));
    sb.append("\n    latestCommit: ").append(toIndentedString(latestCommit));
    sb.append("\n    type: ").append(toIndentedString(type));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
