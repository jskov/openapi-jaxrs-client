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
 * EntityHolderRestPullRequestDeclineRequestEntity
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class EntityHolderRestPullRequestDeclineRequestEntity {
    public static final String JSON_PROPERTY_COMMENT = "comment";
    @JsonbProperty(JSON_PROPERTY_COMMENT)
    @Schema(example = "An optional comment explaining why the pull request is being declined")
    private String comment;

    public static final String JSON_PROPERTY_VERSION = "version";
    @JsonbProperty(JSON_PROPERTY_VERSION)
    private Integer version;

    public EntityHolderRestPullRequestDeclineRequestEntity comment(String comment) {
        this.comment = comment;
        return this;
    }

    /**
     * Get comment
     *
     * @return comment
     **/
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public EntityHolderRestPullRequestDeclineRequestEntity version(Integer version) {
        this.version = version;
        return this;
    }

    /**
     * Get version
     *
     * @return version
     **/
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EntityHolderRestPullRequestDeclineRequestEntity)) {
            return false;
        }
        EntityHolderRestPullRequestDeclineRequestEntity other = (EntityHolderRestPullRequestDeclineRequestEntity) o;
        return Objects.equals(this.comment, other.comment) &&
                Objects.equals(this.version, other.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment, version);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EntityHolderRestPullRequestDeclineRequestEntity {");
        sb.append("\n    comment: ").append(toIndentedString(comment));
        sb.append("\n    version: ").append(toIndentedString(version));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
