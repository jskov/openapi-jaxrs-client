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
 * RestConflict
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestConflict {
    public static final String JSON_PROPERTY_OUR_CHANGE = "ourChange";
    @JsonbProperty(JSON_PROPERTY_OUR_CHANGE)
    private RestConflictOurChange ourChange;

    public static final String JSON_PROPERTY_THEIR_CHANGE = "theirChange";
    @JsonbProperty(JSON_PROPERTY_THEIR_CHANGE)
    private RestConflictTheirChange theirChange;

    public RestConflict ourChange(RestConflictOurChange ourChange) {
        this.ourChange = ourChange;
        return this;
    }

    /**
     * Get ourChange
     *
     * @return ourChange
     **/
    @Valid
    public RestConflictOurChange getOurChange() {
        return ourChange;
    }

    public void setOurChange(RestConflictOurChange ourChange) {
        this.ourChange = ourChange;
    }

    public RestConflict theirChange(RestConflictTheirChange theirChange) {
        this.theirChange = theirChange;
        return this;
    }

    /**
     * Get theirChange
     *
     * @return theirChange
     **/
    @Valid
    public RestConflictTheirChange getTheirChange() {
        return theirChange;
    }

    public void setTheirChange(RestConflictTheirChange theirChange) {
        this.theirChange = theirChange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestConflict)) {
            return false;
        }
        RestConflict other = (RestConflict) o;
        return Objects.equals(this.ourChange, other.ourChange) &&
                Objects.equals(this.theirChange, other.theirChange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ourChange, theirChange);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestConflict {");
        sb.append("\n    ourChange: ").append(toIndentedString(ourChange));
        sb.append("\n    theirChange: ").append(toIndentedString(theirChange));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
