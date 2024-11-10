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
import jakarta.validation.constraints.NotNull;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestProjectSettingsRestrictionRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestProjectSettingsRestrictionRequest {
    public static final String JSON_PROPERTY_COMPONENT_KEY = "componentKey";
    @JsonbProperty(JSON_PROPERTY_COMPONENT_KEY)
    @Schema(example = "my-admin-component")
    private String componentKey;

    public static final String JSON_PROPERTY_FEATURE_KEY = "featureKey";
    @JsonbProperty(JSON_PROPERTY_FEATURE_KEY)
    @Schema(required = true, example = "my-admin-feature")
    private String featureKey;

    public static final String JSON_PROPERTY_NAMESPACE = "namespace";
    @JsonbProperty(JSON_PROPERTY_NAMESPACE)
    @Schema(required = true, example = "org.featuredeveloper")
    private String namespace;

    public RestProjectSettingsRestrictionRequest componentKey(String componentKey) {
        this.componentKey = componentKey;
        return this;
    }

    /**
     * Get componentKey
     *
     * @return componentKey
     **/
    public String getComponentKey() {
        return componentKey;
    }

    public void setComponentKey(String componentKey) {
        this.componentKey = componentKey;
    }

    public RestProjectSettingsRestrictionRequest featureKey(String featureKey) {
        this.featureKey = Objects.requireNonNull(featureKey, "Property featureKey is required, cannot be null");
        return this;
    }

    /**
     * Get featureKey
     *
     * @return featureKey
     **/
    public @NotNull String getFeatureKey() {
        return featureKey;
    }

    public void setFeatureKey(String featureKey) {
        this.featureKey = Objects.requireNonNull(featureKey, "Property featureKey is required, cannot be null");
    }

    public RestProjectSettingsRestrictionRequest namespace(String namespace) {
        this.namespace = Objects.requireNonNull(namespace, "Property namespace is required, cannot be null");
        return this;
    }

    /**
     * Get namespace
     *
     * @return namespace
     **/
    public @NotNull String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = Objects.requireNonNull(namespace, "Property namespace is required, cannot be null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestProjectSettingsRestrictionRequest)) {
            return false;
        }
        RestProjectSettingsRestrictionRequest other = (RestProjectSettingsRestrictionRequest) o;
        return Objects.equals(this.componentKey, other.componentKey) &&
                Objects.equals(this.featureKey, other.featureKey) &&
                Objects.equals(this.namespace, other.namespace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(componentKey, featureKey, namespace);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestProjectSettingsRestrictionRequest {");
        sb.append("\n    componentKey: ").append(toIndentedString(componentKey));
        sb.append("\n    featureKey: ").append(toIndentedString(featureKey));
        sb.append("\n    namespace: ").append(toIndentedString(namespace));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
