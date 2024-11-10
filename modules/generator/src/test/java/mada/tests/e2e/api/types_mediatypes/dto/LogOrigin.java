/*
 * Auditlog API
 * API for accessing the auditlogging
 *
 * The version of the OpenAPI document: 1.0.0
 */

package mada.tests.e2e.api.types_mediatypes.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * LogOrigin
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class LogOrigin {
    public static final String JSON_PROPERTY_APPLICATION_HOST_ID = "application-host-id";
    @JsonbProperty(JSON_PROPERTY_APPLICATION_HOST_ID)
    @Schema(required = true)
    private String applicationHostId;

    public static final String JSON_PROPERTY_APPLICATION_NAME = "application-name";
    @JsonbProperty(JSON_PROPERTY_APPLICATION_NAME)
    @Schema(required = true)
    private String applicationName;

    public static final String JSON_PROPERTY_APPLICATION_VERSION = "application-version";
    @JsonbProperty(JSON_PROPERTY_APPLICATION_VERSION)
    @Schema(required = true)
    private String applicationVersion;

    public static final String JSON_PROPERTY_DOMAIN = "domain";
    @JsonbProperty(JSON_PROPERTY_DOMAIN)
    @Schema(required = true)
    private Domain domain;

    public static final String JSON_PROPERTY_ENVIRONMENT = "environment";
    @JsonbProperty(JSON_PROPERTY_ENVIRONMENT)
    @Schema(required = true)
    private String environment;

    public static final String JSON_PROPERTY_PLATFORM = "platform";
    @JsonbProperty(JSON_PROPERTY_PLATFORM)
    @Schema(required = true)
    private RuntimePlatform platform;

    public LogOrigin applicationHostId(String applicationHostId) {
        this.applicationHostId = Objects.requireNonNull(applicationHostId, "Property applicationHostId is required, cannot be null");
        return this;
    }

    /**
     * Get applicationHostId
     *
     * @return applicationHostId
     **/
    @NotNull @Pattern(regexp = "\\S")
    public String getApplicationHostId() {
        return applicationHostId;
    }

    public void setApplicationHostId(String applicationHostId) {
        this.applicationHostId = Objects.requireNonNull(applicationHostId, "Property applicationHostId is required, cannot be null");
    }

    public LogOrigin applicationName(String applicationName) {
        this.applicationName = Objects.requireNonNull(applicationName, "Property applicationName is required, cannot be null");
        return this;
    }

    /**
     * Get applicationName
     *
     * @return applicationName
     **/
    @NotNull @Pattern(regexp = "\\S")
    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = Objects.requireNonNull(applicationName, "Property applicationName is required, cannot be null");
    }

    public LogOrigin applicationVersion(String applicationVersion) {
        this.applicationVersion = Objects.requireNonNull(applicationVersion, "Property applicationVersion is required, cannot be null");
        return this;
    }

    /**
     * Get applicationVersion
     *
     * @return applicationVersion
     **/
    @NotNull @Pattern(regexp = "\\S")
    public String getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = Objects.requireNonNull(applicationVersion, "Property applicationVersion is required, cannot be null");
    }

    public LogOrigin domain(Domain domain) {
        this.domain = Objects.requireNonNull(domain, "Property domain is required, cannot be null");
        return this;
    }

    /**
     * Get domain
     *
     * @return domain
     **/
    @NotNull @Valid
    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = Objects.requireNonNull(domain, "Property domain is required, cannot be null");
    }

    public LogOrigin environment(String environment) {
        this.environment = Objects.requireNonNull(environment, "Property environment is required, cannot be null");
        return this;
    }

    /**
     * Get environment
     *
     * @return environment
     **/
    @NotNull @Pattern(regexp = "\\S")
    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = Objects.requireNonNull(environment, "Property environment is required, cannot be null");
    }

    public LogOrigin platform(RuntimePlatform platform) {
        this.platform = Objects.requireNonNull(platform, "Property platform is required, cannot be null");
        return this;
    }

    /**
     * Get platform
     *
     * @return platform
     **/
    @NotNull @Valid
    public RuntimePlatform getPlatform() {
        return platform;
    }

    public void setPlatform(RuntimePlatform platform) {
        this.platform = Objects.requireNonNull(platform, "Property platform is required, cannot be null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LogOrigin)) {
            return false;
        }
        LogOrigin other = (LogOrigin) o;
        return Objects.equals(this.applicationHostId, other.applicationHostId) &&
                Objects.equals(this.applicationName, other.applicationName) &&
                Objects.equals(this.applicationVersion, other.applicationVersion) &&
                Objects.equals(this.domain, other.domain) &&
                Objects.equals(this.environment, other.environment) &&
                Objects.equals(this.platform, other.platform);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicationHostId, applicationName, applicationVersion, domain, environment, platform);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LogOrigin {");
        sb.append("\n    applicationHostId: ").append(toIndentedString(applicationHostId));
        sb.append("\n    applicationName: ").append(toIndentedString(applicationName));
        sb.append("\n    applicationVersion: ").append(toIndentedString(applicationVersion));
        sb.append("\n    domain: ").append(toIndentedString(domain));
        sb.append("\n    environment: ").append(toIndentedString(environment));
        sb.append("\n    platform: ").append(toIndentedString(platform));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
