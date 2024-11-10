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
 * RestTokenBucketSettings
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestTokenBucketSettings {
    public static final String JSON_PROPERTY_CAPACITY = "capacity";
    @JsonbProperty(JSON_PROPERTY_CAPACITY)
    @Schema(example = "60")
    private Integer capacity;

    public static final String JSON_PROPERTY_FILL_RATE = "fillRate";
    @JsonbProperty(JSON_PROPERTY_FILL_RATE)
    @Schema(example = "5")
    private Integer fillRate;

    public RestTokenBucketSettings capacity(Integer capacity) {
        this.capacity = capacity;
        return this;
    }

    /**
     * Get capacity
     *
     * @return capacity
     **/
    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public RestTokenBucketSettings fillRate(Integer fillRate) {
        this.fillRate = fillRate;
        return this;
    }

    /**
     * Get fillRate
     *
     * @return fillRate
     **/
    public Integer getFillRate() {
        return fillRate;
    }

    public void setFillRate(Integer fillRate) {
        this.fillRate = fillRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestTokenBucketSettings)) {
            return false;
        }
        RestTokenBucketSettings other = (RestTokenBucketSettings) o;
        return Objects.equals(this.capacity, other.capacity) &&
                Objects.equals(this.fillRate, other.fillRate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(capacity, fillRate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestTokenBucketSettings {");
        sb.append("\n    capacity: ").append(toIndentedString(capacity));
        sb.append("\n    fillRate: ").append(toIndentedString(fillRate));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
