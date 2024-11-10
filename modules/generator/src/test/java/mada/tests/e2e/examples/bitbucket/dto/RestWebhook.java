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
import jakarta.validation.Valid;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * RestWebhook
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestWebhook {
    public static final String JSON_PROPERTY_ACTIVE = "active";
    @JsonbProperty(JSON_PROPERTY_ACTIVE)
    private Boolean active;

    public static final String JSON_PROPERTY_CONFIGURATION = "configuration";
    @JsonbProperty(JSON_PROPERTY_CONFIGURATION)
    private Object configuration;

    public static final String JSON_PROPERTY_CREDENTIALS = "credentials";
    @JsonbProperty(JSON_PROPERTY_CREDENTIALS)
    private RestWebhookCredentials credentials;

    public static final String JSON_PROPERTY_EVENTS = "events";
    @JsonbProperty(JSON_PROPERTY_EVENTS)
    private Set<String> events;

    public static final String JSON_PROPERTY_NAME = "name";
    @JsonbProperty(JSON_PROPERTY_NAME)
    private String name;

    public static final String JSON_PROPERTY_SCOPE_TYPE = "scopeType";
    @JsonbProperty(JSON_PROPERTY_SCOPE_TYPE)
    private String scopeType;

    public static final String JSON_PROPERTY_SSL_VERIFICATION_REQUIRED = "sslVerificationRequired";
    @JsonbProperty(JSON_PROPERTY_SSL_VERIFICATION_REQUIRED)
    private Boolean sslVerificationRequired;

    public static final String JSON_PROPERTY_STATISTICS = "statistics";
    @JsonbProperty(JSON_PROPERTY_STATISTICS)
    private Object statistics;

    public static final String JSON_PROPERTY_URL = "url";
    @JsonbProperty(JSON_PROPERTY_URL)
    private String url;

    public RestWebhook active(Boolean active) {
        this.active = active;
        return this;
    }

    /**
     * Get active
     *
     * @return active
     **/
    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public RestWebhook configuration(Object configuration) {
        this.configuration = configuration;
        return this;
    }

    /**
     * Get configuration
     *
     * @return configuration
     **/
    public Object getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Object configuration) {
        this.configuration = configuration;
    }

    public RestWebhook credentials(RestWebhookCredentials credentials) {
        this.credentials = credentials;
        return this;
    }

    /**
     * Get credentials
     *
     * @return credentials
     **/
    public @Valid RestWebhookCredentials getCredentials() {
        return credentials;
    }

    public void setCredentials(RestWebhookCredentials credentials) {
        this.credentials = credentials;
    }

    public RestWebhook events(Set<String> events) {
        this.events = events;
        return this;
    }

    public RestWebhook addEventsItem(String eventsItem) {
        if (this.events == null) {
            this.events = new LinkedHashSet<>();
        }
        this.events.add(eventsItem);
        return this;
    }

    /**
     * Get events
     *
     * @return events
     **/
    public Set<String> getEvents() {
        return events;
    }

    public void setEvents(Set<String> events) {
        this.events = events;
    }

    public RestWebhook name(String name) {
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

    public RestWebhook scopeType(String scopeType) {
        this.scopeType = scopeType;
        return this;
    }

    /**
     * Get scopeType
     *
     * @return scopeType
     **/
    public String getScopeType() {
        return scopeType;
    }

    public void setScopeType(String scopeType) {
        this.scopeType = scopeType;
    }

    public RestWebhook sslVerificationRequired(Boolean sslVerificationRequired) {
        this.sslVerificationRequired = sslVerificationRequired;
        return this;
    }

    /**
     * Get sslVerificationRequired
     *
     * @return sslVerificationRequired
     **/
    public Boolean isSslVerificationRequired() {
        return sslVerificationRequired;
    }

    public void setSslVerificationRequired(Boolean sslVerificationRequired) {
        this.sslVerificationRequired = sslVerificationRequired;
    }

    public RestWebhook statistics(Object statistics) {
        this.statistics = statistics;
        return this;
    }

    /**
     * Get statistics
     *
     * @return statistics
     **/
    public Object getStatistics() {
        return statistics;
    }

    public void setStatistics(Object statistics) {
        this.statistics = statistics;
    }

    public RestWebhook url(String url) {
        this.url = url;
        return this;
    }

    /**
     * Get url
     *
     * @return url
     **/
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestWebhook)) {
            return false;
        }
        RestWebhook other = (RestWebhook) o;
        return Objects.equals(this.active, other.active) &&
                Objects.equals(this.configuration, other.configuration) &&
                Objects.equals(this.credentials, other.credentials) &&
                Objects.equals(this.events, other.events) &&
                Objects.equals(this.name, other.name) &&
                Objects.equals(this.scopeType, other.scopeType) &&
                Objects.equals(this.sslVerificationRequired, other.sslVerificationRequired) &&
                Objects.equals(this.statistics, other.statistics) &&
                Objects.equals(this.url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(active, configuration, credentials, events, name, scopeType, sslVerificationRequired, statistics, url);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestWebhook {");
        sb.append("\n    active: ").append(toIndentedString(active));
        sb.append("\n    configuration: ").append(toIndentedString(configuration));
        sb.append("\n    credentials: ").append(toIndentedString(credentials));
        sb.append("\n    events: ").append(toIndentedString(events));
        sb.append("\n    name: ").append(toIndentedString(name));
        sb.append("\n    scopeType: ").append(toIndentedString(scopeType));
        sb.append("\n    sslVerificationRequired: ").append(toIndentedString(sslVerificationRequired));
        sb.append("\n    statistics: ").append(toIndentedString(statistics));
        sb.append("\n    url: ").append(toIndentedString(url));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
