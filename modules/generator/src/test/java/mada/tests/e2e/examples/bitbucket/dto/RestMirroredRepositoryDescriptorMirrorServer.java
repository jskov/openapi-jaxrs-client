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
import jakarta.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestMirroredRepositoryDescriptorMirrorServer
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestMirroredRepositoryDescriptorMirrorServer {
    public static final String JSON_PROPERTY_BASE_URL = "baseUrl";
    @JsonbProperty(JSON_PROPERTY_BASE_URL)
    @Schema(example = "http://vietnam.example.com")
    private String baseUrl;

    public static final String JSON_PROPERTY_ENABLED = "enabled";
    @JsonbProperty(JSON_PROPERTY_ENABLED)
    private Boolean enabled;

    public static final String JSON_PROPERTY_ID = "id";
    @JsonbProperty(JSON_PROPERTY_ID)
    @Schema(example = "B0F5-CS21-45C2-CCK3")
    private String id;

    public static final String JSON_PROPERTY_LAST_SEEN_DATE = "lastSeenDate";
    @JsonbProperty(JSON_PROPERTY_LAST_SEEN_DATE)
    @Schema(required = true)
    private OffsetDateTime lastSeenDate;

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
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestMirroredRepositoryDescriptorMirrorServer.MirrorTypeEnum.MirrorTypeEnumAdapter.class)
    private MirrorTypeEnum mirrorType;

    public static final String JSON_PROPERTY_NAME = "name";
    @JsonbProperty(JSON_PROPERTY_NAME)
    @Schema(example = "Mirror")
    private String name;

    public static final String JSON_PROPERTY_PRODUCT_TYPE = "productType";
    @JsonbProperty(JSON_PROPERTY_PRODUCT_TYPE)
    @Schema(example = "Bitbucket")
    private String productType;

    public static final String JSON_PROPERTY_PRODUCT_VERSION = "productVersion";
    @JsonbProperty(JSON_PROPERTY_PRODUCT_VERSION)
    @Schema(example = "8.0.0")
    private String productVersion;

    public RestMirroredRepositoryDescriptorMirrorServer baseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    /**
     * Get baseUrl
     *
     * @return baseUrl
     **/
    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public RestMirroredRepositoryDescriptorMirrorServer enabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * Get enabled
     *
     * @return enabled
     **/
    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public RestMirroredRepositoryDescriptorMirrorServer id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RestMirroredRepositoryDescriptorMirrorServer lastSeenDate(OffsetDateTime lastSeenDate) {
        this.lastSeenDate = Objects.requireNonNull(lastSeenDate, "Property lastSeenDate is required, cannot be null");
        return this;
    }

    /**
     * Get lastSeenDate
     *
     * @return lastSeenDate
     **/
    @NotNull public OffsetDateTime getLastSeenDate() {
        return lastSeenDate;
    }

    public void setLastSeenDate(OffsetDateTime lastSeenDate) {
        this.lastSeenDate = Objects.requireNonNull(lastSeenDate, "Property lastSeenDate is required, cannot be null");
    }

    public RestMirroredRepositoryDescriptorMirrorServer mirrorType(MirrorTypeEnum mirrorType) {
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

    public RestMirroredRepositoryDescriptorMirrorServer name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RestMirroredRepositoryDescriptorMirrorServer productType(String productType) {
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

    public RestMirroredRepositoryDescriptorMirrorServer productVersion(String productVersion) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestMirroredRepositoryDescriptorMirrorServer)) {
            return false;
        }
        RestMirroredRepositoryDescriptorMirrorServer other = (RestMirroredRepositoryDescriptorMirrorServer) o;
        return Objects.equals(this.baseUrl, other.baseUrl) &&
                Objects.equals(this.enabled, other.enabled) &&
                Objects.equals(this.id, other.id) &&
                Objects.equals(this.lastSeenDate, other.lastSeenDate) &&
                Objects.equals(this.mirrorType, other.mirrorType) &&
                Objects.equals(this.name, other.name) &&
                Objects.equals(this.productType, other.productType) &&
                Objects.equals(this.productVersion, other.productVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseUrl, enabled, id, lastSeenDate, mirrorType, name, productType, productVersion);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestMirroredRepositoryDescriptorMirrorServer {");
        sb.append("\n    baseUrl: ").append(toIndentedString(baseUrl));
        sb.append("\n    enabled: ").append(toIndentedString(enabled));
        sb.append("\n    id: ").append(toIndentedString(id));
        sb.append("\n    lastSeenDate: ").append(toIndentedString(lastSeenDate));
        sb.append("\n    mirrorType: ").append(toIndentedString(mirrorType));
        sb.append("\n    name: ").append(toIndentedString(name));
        sb.append("\n    productType: ").append(toIndentedString(productType));
        sb.append("\n    productVersion: ").append(toIndentedString(productVersion));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
