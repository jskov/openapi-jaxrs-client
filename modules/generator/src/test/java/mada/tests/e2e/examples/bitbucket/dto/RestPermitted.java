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
 * RestPermitted
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestPermitted {
    public static final String JSON_PROPERTY_PERMITTED = "permitted";
    @JsonbProperty(JSON_PROPERTY_PERMITTED)
    @Schema(example = "true")
    private Boolean permitted;

    public RestPermitted permitted(Boolean permitted) {
        this.permitted = permitted;
        return this;
    }

    /**
     * Get permitted
     *
     * @return permitted
     **/
    public Boolean isPermitted() {
        return permitted;
    }

    public void setPermitted(Boolean permitted) {
        this.permitted = permitted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestPermitted)) {
            return false;
        }
        RestPermitted other = (RestPermitted) o;
        return Objects.equals(this.permitted, other.permitted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(permitted);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestPermitted {");
        sb.append("\n    permitted: ").append(toIndentedString(permitted));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
