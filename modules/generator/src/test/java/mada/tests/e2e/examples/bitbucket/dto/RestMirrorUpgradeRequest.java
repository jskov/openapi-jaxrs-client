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
 * RestMirrorUpgradeRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestMirrorUpgradeRequest {
    public static final String JSON_PROPERTY_ADDON_DESCRIPTOR_URI = "addonDescriptorUri";
    @JsonbProperty(JSON_PROPERTY_ADDON_DESCRIPTOR_URI)
    @Schema(example = "https://bitbucket-eu.example.com:7990/bitbucket/rest/mirroring/1.0/descriptor")
    private String addonDescriptorUri;

    public static final String JSON_PROPERTY_BASE_URL = "baseUrl";
    @JsonbProperty(JSON_PROPERTY_BASE_URL)
    @Schema(example = "https://bitbucket-eu.example.com:7990/bitbucket")
    private String baseUrl;

    public static final String JSON_PROPERTY_PRODUCT_TYPE = "productType";
    @JsonbProperty(JSON_PROPERTY_PRODUCT_TYPE)
    @Schema(example = "Bitbucket")
    private String productType;

    public static final String JSON_PROPERTY_PRODUCT_VERSION = "productVersion";
    @JsonbProperty(JSON_PROPERTY_PRODUCT_VERSION)
    @Schema(example = "8.0.0")
    private String productVersion;

    public RestMirrorUpgradeRequest addonDescriptorUri(String addonDescriptorUri) {
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

    public RestMirrorUpgradeRequest baseUrl(String baseUrl) {
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

    public RestMirrorUpgradeRequest productType(String productType) {
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

    public RestMirrorUpgradeRequest productVersion(String productVersion) {
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
        if (!(o instanceof RestMirrorUpgradeRequest)) {
            return false;
        }
        RestMirrorUpgradeRequest other = (RestMirrorUpgradeRequest) o;
        return Objects.equals(this.addonDescriptorUri, other.addonDescriptorUri) &&
                Objects.equals(this.baseUrl, other.baseUrl) &&
                Objects.equals(this.productType, other.productType) &&
                Objects.equals(this.productVersion, other.productVersion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addonDescriptorUri, baseUrl, productType, productVersion);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestMirrorUpgradeRequest {");
        sb.append("\n    addonDescriptorUri: ").append(toIndentedString(addonDescriptorUri));
        sb.append("\n    baseUrl: ").append(toIndentedString(baseUrl));
        sb.append("\n    productType: ").append(toIndentedString(productType));
        sb.append("\n    productVersion: ").append(toIndentedString(productVersion));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
