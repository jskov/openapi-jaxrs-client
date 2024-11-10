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
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestBranch
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestBranch {
    public static final String JSON_PROPERTY_DEFAULT = "default";
    @JsonbProperty(JSON_PROPERTY_DEFAULT)
    @Schema(readOnly = true)
    private Boolean default_;

    public static final String JSON_PROPERTY_DISPLAY_ID = "displayId";
    @JsonbProperty(JSON_PROPERTY_DISPLAY_ID)
    @Schema(readOnly = true)
    private String displayId;

    public static final String JSON_PROPERTY_ID = "id";
    @JsonbProperty(JSON_PROPERTY_ID)
    @Schema(example = "refs/heads/master")
    private String id;

    public static final String JSON_PROPERTY_LATEST_CHANGESET = "latestChangeset";
    @JsonbProperty(JSON_PROPERTY_LATEST_CHANGESET)
    @Schema(readOnly = true, example = "8d51122def5632836d1cb1026e879069e10a1e13")
    private String latestChangeset;

    public static final String JSON_PROPERTY_LATEST_COMMIT = "latestCommit";
    @JsonbProperty(JSON_PROPERTY_LATEST_COMMIT)
    @Schema(readOnly = true, example = "8d51122def5632836d1cb1026e879069e10a1e13")
    private String latestCommit;

    public static final String JSON_PROPERTY_TYPE = "type";
    @JsonbProperty(JSON_PROPERTY_TYPE)
    private RefType type;

    public RestBranch default_(Boolean default_) {
        this.default_ = default_;
        return this;
    }

    /**
     * Get default_
     *
     * @return default_
     **/
    public Boolean isDefault() {
        return default_;
    }

    public void setDefault(Boolean default_) {
        this.default_ = default_;
    }

    public RestBranch displayId(String displayId) {
        this.displayId = displayId;
        return this;
    }

    /**
     * Get displayId
     *
     * @return displayId
     **/
    public String getDisplayId() {
        return displayId;
    }

    public void setDisplayId(String displayId) {
        this.displayId = displayId;
    }

    public RestBranch id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RestBranch latestChangeset(String latestChangeset) {
        this.latestChangeset = latestChangeset;
        return this;
    }

    /**
     * Get latestChangeset
     *
     * @return latestChangeset
     **/
    public String getLatestChangeset() {
        return latestChangeset;
    }

    public void setLatestChangeset(String latestChangeset) {
        this.latestChangeset = latestChangeset;
    }

    public RestBranch latestCommit(String latestCommit) {
        this.latestCommit = latestCommit;
        return this;
    }

    /**
     * Get latestCommit
     *
     * @return latestCommit
     **/
    public String getLatestCommit() {
        return latestCommit;
    }

    public void setLatestCommit(String latestCommit) {
        this.latestCommit = latestCommit;
    }

    public RestBranch type(RefType type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     **/
    public @Valid RefType getType() {
        return type;
    }

    public void setType(RefType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestBranch)) {
            return false;
        }
        RestBranch other = (RestBranch) o;
        return Objects.equals(this.default_, other.default_) &&
                Objects.equals(this.displayId, other.displayId) &&
                Objects.equals(this.id, other.id) &&
                Objects.equals(this.latestChangeset, other.latestChangeset) &&
                Objects.equals(this.latestCommit, other.latestCommit) &&
                Objects.equals(this.type, other.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(default_, displayId, id, latestChangeset, latestCommit, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestBranch {");
        sb.append("\n    default_: ").append(toIndentedString(default_));
        sb.append("\n    displayId: ").append(toIndentedString(displayId));
        sb.append("\n    id: ").append(toIndentedString(id));
        sb.append("\n    latestChangeset: ").append(toIndentedString(latestChangeset));
        sb.append("\n    latestCommit: ").append(toIndentedString(latestCommit));
        sb.append("\n    type: ").append(toIndentedString(type));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
