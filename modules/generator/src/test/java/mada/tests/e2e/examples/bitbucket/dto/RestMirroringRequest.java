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
 * RestMirroringRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestMirroringRequest {
    public static final String JSON_PROPERTY_ADDON_DESCRIPTOR_URI = "addonDescriptorUri";
    @JsonbProperty(JSON_PROPERTY_ADDON_DESCRIPTOR_URI)
    @Schema(example = "https://bitbucket-eu.example.com:7990/bitbucket/rest/mirroring/1.0/descriptor")
    private String addonDescriptorUri;

    public static final String JSON_PROPERTY_ID = "id";
    @JsonbProperty(JSON_PROPERTY_ID)
    @Schema(readOnly = true)
    private Integer id;

    public static final String JSON_PROPERTY_MIRROR_BASE_URL = "mirrorBaseUrl";
    @JsonbProperty(JSON_PROPERTY_MIRROR_BASE_URL)
    @Schema(example = "https://bitbucket-eu.example.com:7990/bitbucket")
    private String mirrorBaseUrl;

    public static final String JSON_PROPERTY_MIRROR_ID = "mirrorId";
    @JsonbProperty(JSON_PROPERTY_MIRROR_ID)
    @Schema(example = "4f0eb5fc-67fc-48f8-b4a7-87981f026c6a")
    private String mirrorId;

    public static final String JSON_PROPERTY_MIRROR_NAME = "mirrorName";
    @JsonbProperty(JSON_PROPERTY_MIRROR_NAME)
    @Schema(example = "Bitbucket Mirror")
    private String mirrorName;

    public enum MirrorTypeEnum {
      SINGLE("SINGLE"),
      FARM("FARM");

      private final String value;

      MirrorTypeEnum(String value) {
        this.value = value;
      }

      public String getValue() {
          return value;
      }

      @Override
      public String toString() {
          return String.valueOf(value);
      }

      public static class MirrorTypeEnumAdapter implements JsonbAdapter<MirrorTypeEnum, JsonString> {
          @Override
          public JsonString adaptToJson(MirrorTypeEnum e) throws Exception {
              return Json.createValue(String.valueOf(e.value));
          }

        @Override
        public MirrorTypeEnum adaptFromJson(JsonString value) throws Exception {
            for (MirrorTypeEnum b : MirrorTypeEnum.values()) {
                if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                    return b;
                }
            }
            throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type MirrorTypeEnum");
          }
      }
  }

    public static final String JSON_PROPERTY_MIRROR_TYPE = "mirrorType";
    @JsonbProperty(JSON_PROPERTY_MIRROR_TYPE)
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestMirroringRequest.MirrorTypeEnum.MirrorTypeEnumAdapter.class)
    private MirrorTypeEnum mirrorType;

    public static final String JSON_PROPERTY_PRODUCT_TYPE = "productType";
    @JsonbProperty(JSON_PROPERTY_PRODUCT_TYPE)
    @Schema(example = "Bitbucket")
    private String productType;

    public static final String JSON_PROPERTY_PRODUCT_VERSION = "productVersion";
    @JsonbProperty(JSON_PROPERTY_PRODUCT_VERSION)
    @Schema(example = "8.0.0")
    private String productVersion;

    public enum StateEnum {
      PENDING("PENDING"),
      ACCEPTED("ACCEPTED"),
      REJECTED("REJECTED");

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
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestMirroringRequest.StateEnum.StateEnumAdapter.class)
    private StateEnum state;

    public RestMirroringRequest addonDescriptorUri(String addonDescriptorUri) {
        this.addonDescriptorUri = addonDescriptorUri;
        return this;
    }

    /**
     * Get addonDescriptorUri
     *
     * @return addonDescriptorUri
     **/
    public String getAddonDescriptorUri() {
        return addonDescriptorUri;
    }

    public void setAddonDescriptorUri(String addonDescriptorUri) {
        this.addonDescriptorUri = addonDescriptorUri;
    }

    public RestMirroringRequest id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RestMirroringRequest mirrorBaseUrl(String mirrorBaseUrl) {
        this.mirrorBaseUrl = mirrorBaseUrl;
        return this;
    }

    /**
     * Get mirrorBaseUrl
     *
     * @return mirrorBaseUrl
     **/
    public String getMirrorBaseUrl() {
        return mirrorBaseUrl;
    }

    public void setMirrorBaseUrl(String mirrorBaseUrl) {
        this.mirrorBaseUrl = mirrorBaseUrl;
    }

    public RestMirroringRequest mirrorId(String mirrorId) {
        this.mirrorId = mirrorId;
        return this;
    }

    /**
     * Get mirrorId
     *
     * @return mirrorId
     **/
    public String getMirrorId() {
        return mirrorId;
    }

    public void setMirrorId(String mirrorId) {
        this.mirrorId = mirrorId;
    }

    public RestMirroringRequest mirrorName(String mirrorName) {
        this.mirrorName = mirrorName;
        return this;
    }

    /**
     * Get mirrorName
     *
     * @return mirrorName
     **/
    public String getMirrorName() {
        return mirrorName;
    }

    public void setMirrorName(String mirrorName) {
        this.mirrorName = mirrorName;
    }

    public RestMirroringRequest mirrorType(MirrorTypeEnum mirrorType) {
        this.mirrorType = mirrorType;
        return this;
    }

    /**
     * Get mirrorType
     *
     * @return mirrorType
     **/
    public MirrorTypeEnum getMirrorType() {
        return mirrorType;
    }

    public void setMirrorType(MirrorTypeEnum mirrorType) {
        this.mirrorType = mirrorType;
    }

    public RestMirroringRequest productType(String productType) {
        this.productType = productType;
        return this;
    }

    /**
     * Get productType
     *
     * @return productType
     **/
    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public RestMirroringRequest productVersion(String productVersion) {
        this.productVersion = productVersion;
        return this;
    }

    /**
     * Get productVersion
     *
     * @return productVersion
     **/
    public String getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }

    public RestMirroringRequest state(StateEnum state) {
        this.state = state;
        return this;
    }

    /**
     * Get state
     *
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
        if (!(o instanceof RestMirroringRequest)) {
            return false;
        }
        RestMirroringRequest other = (RestMirroringRequest) o;
        return Objects.equals(this.addonDescriptorUri, other.addonDescriptorUri) &&
                Objects.equals(this.id, other.id) &&
                Objects.equals(this.mirrorBaseUrl, other.mirrorBaseUrl) &&
                Objects.equals(this.mirrorId, other.mirrorId) &&
                Objects.equals(this.mirrorName, other.mirrorName) &&
                Objects.equals(this.mirrorType, other.mirrorType) &&
                Objects.equals(this.productType, other.productType) &&
                Objects.equals(this.productVersion, other.productVersion) &&
                Objects.equals(this.state, other.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addonDescriptorUri, id, mirrorBaseUrl, mirrorId, mirrorName, mirrorType, productType, productVersion, state);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestMirroringRequest {");
        sb.append("\n    addonDescriptorUri: ").append(toIndentedString(addonDescriptorUri));
        sb.append("\n    id: ").append(toIndentedString(id));
        sb.append("\n    mirrorBaseUrl: ").append(toIndentedString(mirrorBaseUrl));
        sb.append("\n    mirrorId: ").append(toIndentedString(mirrorId));
        sb.append("\n    mirrorName: ").append(toIndentedString(mirrorName));
        sb.append("\n    mirrorType: ").append(toIndentedString(mirrorType));
        sb.append("\n    productType: ").append(toIndentedString(productType));
        sb.append("\n    productVersion: ").append(toIndentedString(productVersion));
        sb.append("\n    state: ").append(toIndentedString(state));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
