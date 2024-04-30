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
import jakarta.validation.Valid;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestPushRefChange
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestPushRefChange {
  public static final String JSON_PROPERTY_FROM_HASH = "fromHash";
  @JsonbProperty(JSON_PROPERTY_FROM_HASH)
  @Schema(example = "6053a1eaa1c009dd11092d09a72f3c41af1b59ad")
  private String fromHash;

  public static final String JSON_PROPERTY_REF = "ref";
  @JsonbProperty(JSON_PROPERTY_REF)
  private RestPushRefChangeRef ref;

  public static final String JSON_PROPERTY_REF_ID = "refId";
  @JsonbProperty(JSON_PROPERTY_REF_ID)
  @Schema(example = "refs/heads/master")
  private String refId;

  public static final String JSON_PROPERTY_TO_HASH = "toHash";
  @JsonbProperty(JSON_PROPERTY_TO_HASH)
  @Schema(example = "d6edcbf924697ab811a867421dab60d954ccad99")
  private String toHash;

  public enum TypeEnum {
    ADD("ADD"),
    DELETE("DELETE"),
    UPDATE("UPDATE");

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
  @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestPushRefChange.TypeEnum.TypeEnumAdapter.class)
  private TypeEnum type;

  public enum UpdatedTypeEnum {
    UNKNOWN("UNKNOWN"),
    UNRESOLVED("UNRESOLVED"),
    NOT_FORCED("NOT_FORCED"),
    FORCED("FORCED");

    private final String value;

    UpdatedTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static class UpdatedTypeEnumAdapter implements JsonbAdapter<UpdatedTypeEnum, JsonString> {
      @Override
      public JsonString adaptToJson(UpdatedTypeEnum e) throws Exception {
        return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public UpdatedTypeEnum adaptFromJson(JsonString value) throws Exception {
        for (UpdatedTypeEnum b : UpdatedTypeEnum.values()) {
          if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
            return b;
          }
        }
        throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type UpdatedTypeEnum");
      }
    }
  }

  public static final String JSON_PROPERTY_UPDATED_TYPE = "updatedType";
  @JsonbProperty(JSON_PROPERTY_UPDATED_TYPE)
  @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestPushRefChange.UpdatedTypeEnum.UpdatedTypeEnumAdapter.class)
  private UpdatedTypeEnum updatedType;

  public RestPushRefChange fromHash(String fromHash) {
    this.fromHash = fromHash;
    return this;
  }

  /**
   * Get fromHash
   * @return fromHash
   **/
  public String getFromHash() {
    return fromHash;
  }

  public void setFromHash(String fromHash) {
    this.fromHash = fromHash;
  }

  public RestPushRefChange ref(RestPushRefChangeRef ref) {
    this.ref = ref;
    return this;
  }

  /**
   * Get ref
   * @return ref
   **/
  @Valid
  public RestPushRefChangeRef getRef() {
    return ref;
  }

  public void setRef(RestPushRefChangeRef ref) {
    this.ref = ref;
  }

  public RestPushRefChange refId(String refId) {
    this.refId = refId;
    return this;
  }

  /**
   * Get refId
   * @return refId
   **/
  public String getRefId() {
    return refId;
  }

  public void setRefId(String refId) {
    this.refId = refId;
  }

  public RestPushRefChange toHash(String toHash) {
    this.toHash = toHash;
    return this;
  }

  /**
   * Get toHash
   * @return toHash
   **/
  public String getToHash() {
    return toHash;
  }

  public void setToHash(String toHash) {
    this.toHash = toHash;
  }

  public RestPushRefChange type(TypeEnum type) {
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

  public RestPushRefChange updatedType(UpdatedTypeEnum updatedType) {
    this.updatedType = updatedType;
    return this;
  }

  /**
   * Get updatedType
   * @return updatedType
   **/
  public UpdatedTypeEnum getUpdatedType() {
    return updatedType;
  }

  public void setUpdatedType(UpdatedTypeEnum updatedType) {
    this.updatedType = updatedType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestPushRefChange)) {
      return false;
    }
    RestPushRefChange other = (RestPushRefChange) o;
    return Objects.equals(this.fromHash, other.fromHash) &&
        Objects.equals(this.ref, other.ref) &&
        Objects.equals(this.refId, other.refId) &&
        Objects.equals(this.toHash, other.toHash) &&
        Objects.equals(this.type, other.type) &&
        Objects.equals(this.updatedType, other.updatedType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fromHash, ref, refId, toHash, type, updatedType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestPushRefChange {");
    sb.append("\n    fromHash: ").append(toIndentedString(fromHash));
    sb.append("\n    ref: ").append(toIndentedString(ref));
    sb.append("\n    refId: ").append(toIndentedString(refId));
    sb.append("\n    toHash: ").append(toIndentedString(toHash));
    sb.append("\n    type: ").append(toIndentedString(type));
    sb.append("\n    updatedType: ").append(toIndentedString(updatedType));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
