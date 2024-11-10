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

/**
 * RestMeshMigrationRequestMaxBytesPerSecond
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestMeshMigrationRequestMaxBytesPerSecond {
    public static final String JSON_PROPERTY_AS_LONG = "asLong";
    @JsonbProperty(JSON_PROPERTY_AS_LONG)
    private Long asLong;

    public static final String JSON_PROPERTY_PRESENT = "present";
    @JsonbProperty(JSON_PROPERTY_PRESENT)
    private Boolean present;

    public RestMeshMigrationRequestMaxBytesPerSecond asLong(Long asLong) {
        this.asLong = asLong;
        return this;
    }

    /**
     * Get asLong
     *
     * @return asLong
     **/
    public Long getAsLong() {
        return asLong;
    }

    public void setAsLong(Long asLong) {
        this.asLong = asLong;
    }

    public RestMeshMigrationRequestMaxBytesPerSecond present(Boolean present) {
        this.present = present;
        return this;
    }

    /**
     * Get present
     *
     * @return present
     **/
    public Boolean isPresent() {
        return present;
    }

    public void setPresent(Boolean present) {
        this.present = present;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestMeshMigrationRequestMaxBytesPerSecond)) {
            return false;
        }
        RestMeshMigrationRequestMaxBytesPerSecond other = (RestMeshMigrationRequestMaxBytesPerSecond) o;
        return Objects.equals(this.asLong, other.asLong) &&
                Objects.equals(this.present, other.present);
    }

    @Override
    public int hashCode() {
        return Objects.hash(asLong, present);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestMeshMigrationRequestMaxBytesPerSecond {");
        sb.append("\n    asLong: ").append(toIndentedString(asLong));
        sb.append("\n    present: ").append(toIndentedString(present));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
