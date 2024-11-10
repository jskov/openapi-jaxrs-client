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
import java.util.Objects;

/**
 * RestDetailedInvocation
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestDetailedInvocation {
    public static final String JSON_PROPERTY_DURATION = "duration";
    @JsonbProperty(JSON_PROPERTY_DURATION)
    private Integer duration;

    public static final String JSON_PROPERTY_EVENT = "event";
    @JsonbProperty(JSON_PROPERTY_EVENT)
    private String event;

    public static final String JSON_PROPERTY_EVENT_SCOPE = "eventScope";
    @JsonbProperty(JSON_PROPERTY_EVENT_SCOPE)
    private RestDetailedInvocationEventScope eventScope;

    public static final String JSON_PROPERTY_FINISH = "finish";
    @JsonbProperty(JSON_PROPERTY_FINISH)
    private Integer finish;

    public static final String JSON_PROPERTY_ID = "id";
    @JsonbProperty(JSON_PROPERTY_ID)
    private Integer id;

    public static final String JSON_PROPERTY_REQUEST = "request";
    @JsonbProperty(JSON_PROPERTY_REQUEST)
    private Object request;

    public static final String JSON_PROPERTY_RESULT = "result";
    @JsonbProperty(JSON_PROPERTY_RESULT)
    private Object result;

    public static final String JSON_PROPERTY_START = "start";
    @JsonbProperty(JSON_PROPERTY_START)
    private Integer start;

    public RestDetailedInvocation duration(Integer duration) {
        this.duration = duration;
        return this;
    }

    /**
     * Get duration
     *
     * @return duration
     **/
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public RestDetailedInvocation event(String event) {
        this.event = event;
        return this;
    }

    /**
     * Get event
     *
     * @return event
     **/
    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public RestDetailedInvocation eventScope(RestDetailedInvocationEventScope eventScope) {
        this.eventScope = eventScope;
        return this;
    }

    /**
     * Get eventScope
     *
     * @return eventScope
     **/
    @Valid public RestDetailedInvocationEventScope getEventScope() {
        return eventScope;
    }

    public void setEventScope(RestDetailedInvocationEventScope eventScope) {
        this.eventScope = eventScope;
    }

    public RestDetailedInvocation finish(Integer finish) {
        this.finish = finish;
        return this;
    }

    /**
     * Get finish
     *
     * @return finish
     **/
    public Integer getFinish() {
        return finish;
    }

    public void setFinish(Integer finish) {
        this.finish = finish;
    }

    public RestDetailedInvocation id(Integer id) {
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

    public RestDetailedInvocation request(Object request) {
        this.request = request;
        return this;
    }

    /**
     * Get request
     *
     * @return request
     **/
    public Object getRequest() {
        return request;
    }

    public void setRequest(Object request) {
        this.request = request;
    }

    public RestDetailedInvocation result(Object result) {
        this.result = result;
        return this;
    }

    /**
     * Get result
     *
     * @return result
     **/
    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public RestDetailedInvocation start(Integer start) {
        this.start = start;
        return this;
    }

    /**
     * Get start
     *
     * @return start
     **/
    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestDetailedInvocation)) {
            return false;
        }
        RestDetailedInvocation other = (RestDetailedInvocation) o;
        return Objects.equals(this.duration, other.duration) &&
                Objects.equals(this.event, other.event) &&
                Objects.equals(this.eventScope, other.eventScope) &&
                Objects.equals(this.finish, other.finish) &&
                Objects.equals(this.id, other.id) &&
                Objects.equals(this.request, other.request) &&
                Objects.equals(this.result, other.result) &&
                Objects.equals(this.start, other.start);
    }

    @Override
    public int hashCode() {
        return Objects.hash(duration, event, eventScope, finish, id, request, result, start);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestDetailedInvocation {");
        sb.append("\n    duration: ").append(toIndentedString(duration));
        sb.append("\n    event: ").append(toIndentedString(event));
        sb.append("\n    eventScope: ").append(toIndentedString(eventScope));
        sb.append("\n    finish: ").append(toIndentedString(finish));
        sb.append("\n    id: ").append(toIndentedString(id));
        sb.append("\n    request: ").append(toIndentedString(request));
        sb.append("\n    result: ").append(toIndentedString(result));
        sb.append("\n    start: ").append(toIndentedString(start));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
