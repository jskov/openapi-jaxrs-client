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
import java.math.BigDecimal;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestAggregateRejectCounter
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestAggregateRejectCounter {
    public static final String JSON_PROPERTY_LAST_REJECT_TIME = "lastRejectTime";
    @JsonbProperty(JSON_PROPERTY_LAST_REJECT_TIME)
    @Schema(example = "1630041546433")
    private BigDecimal lastRejectTime;

    public static final String JSON_PROPERTY_REJECT_COUNT = "rejectCount";
    @JsonbProperty(JSON_PROPERTY_REJECT_COUNT)
    @Schema(example = "5")
    private Long rejectCount;

    public static final String JSON_PROPERTY_USER = "user";
    @JsonbProperty(JSON_PROPERTY_USER)
    private RestAggregateRejectCounterUser user;

    public RestAggregateRejectCounter lastRejectTime(BigDecimal lastRejectTime) {
        this.lastRejectTime = lastRejectTime;
        return this;
    }

    /**
     * Get lastRejectTime
     *
     * @return lastRejectTime
     **/
    public BigDecimal getLastRejectTime() {
        return lastRejectTime;
    }

    public void setLastRejectTime(BigDecimal lastRejectTime) {
        this.lastRejectTime = lastRejectTime;
    }

    public RestAggregateRejectCounter rejectCount(Long rejectCount) {
        this.rejectCount = rejectCount;
        return this;
    }

    /**
     * Get rejectCount
     *
     * @return rejectCount
     **/
    public Long getRejectCount() {
        return rejectCount;
    }

    public void setRejectCount(Long rejectCount) {
        this.rejectCount = rejectCount;
    }

    public RestAggregateRejectCounter user(RestAggregateRejectCounterUser user) {
        this.user = user;
        return this;
    }

    /**
     * Get user
     *
     * @return user
     **/
    @Valid public RestAggregateRejectCounterUser getUser() {
        return user;
    }

    public void setUser(RestAggregateRejectCounterUser user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestAggregateRejectCounter)) {
            return false;
        }
        RestAggregateRejectCounter other = (RestAggregateRejectCounter) o;
        return Objects.equals(this.lastRejectTime, other.lastRejectTime) &&
                Objects.equals(this.rejectCount, other.rejectCount) &&
                Objects.equals(this.user, other.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastRejectTime, rejectCount, user);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestAggregateRejectCounter {");
        sb.append("\n    lastRejectTime: ").append(toIndentedString(lastRejectTime));
        sb.append("\n    rejectCount: ").append(toIndentedString(rejectCount));
        sb.append("\n    user: ").append(toIndentedString(user));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
