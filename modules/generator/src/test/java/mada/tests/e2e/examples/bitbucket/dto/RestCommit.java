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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestCommit
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestCommit {
    public static final String JSON_PROPERTY_AUTHOR = "author";
    @JsonbProperty(JSON_PROPERTY_AUTHOR)
    private RestCommitAuthor author;

    public static final String JSON_PROPERTY_AUTHOR_TIMESTAMP = "authorTimestamp";
    @JsonbProperty(JSON_PROPERTY_AUTHOR_TIMESTAMP)
    @Schema(example = "1359075920")
    private Long authorTimestamp;

    public static final String JSON_PROPERTY_COMMITTER = "committer";
    @JsonbProperty(JSON_PROPERTY_COMMITTER)
    private RestCommitCommitter committer;

    public static final String JSON_PROPERTY_COMMITTER_TIMESTAMP = "committerTimestamp";
    @JsonbProperty(JSON_PROPERTY_COMMITTER_TIMESTAMP)
    @Schema(example = "1449075830")
    private Long committerTimestamp;

    public static final String JSON_PROPERTY_DISPLAY_ID = "displayId";
    @JsonbProperty(JSON_PROPERTY_DISPLAY_ID)
    @Schema(example = "abcdef0")
    private String displayId;

    public static final String JSON_PROPERTY_ID = "id";
    @JsonbProperty(JSON_PROPERTY_ID)
    @Schema(example = "abcdef0123abcdef4567abcdef8987abcdef6543")
    private String id;

    public static final String JSON_PROPERTY_MESSAGE = "message";
    @JsonbProperty(JSON_PROPERTY_MESSAGE)
    @Schema(example = "More work on feature 1")
    private String message;

    public static final String JSON_PROPERTY_PARENTS = "parents";
    @JsonbProperty(JSON_PROPERTY_PARENTS)
    private List<RestMinimalCommit> parents;

    public RestCommit author(RestCommitAuthor author) {
        this.author = author;
        return this;
    }

    /**
     * Get author
     *
     * @return author
     **/
    public @Valid RestCommitAuthor getAuthor() {
        return author;
    }

    public void setAuthor(RestCommitAuthor author) {
        this.author = author;
    }

    public RestCommit authorTimestamp(Long authorTimestamp) {
        this.authorTimestamp = authorTimestamp;
        return this;
    }

    /**
     * Get authorTimestamp
     *
     * @return authorTimestamp
     **/
    public Long getAuthorTimestamp() {
        return authorTimestamp;
    }

    public void setAuthorTimestamp(Long authorTimestamp) {
        this.authorTimestamp = authorTimestamp;
    }

    public RestCommit committer(RestCommitCommitter committer) {
        this.committer = committer;
        return this;
    }

    /**
     * Get committer
     *
     * @return committer
     **/
    public @Valid RestCommitCommitter getCommitter() {
        return committer;
    }

    public void setCommitter(RestCommitCommitter committer) {
        this.committer = committer;
    }

    public RestCommit committerTimestamp(Long committerTimestamp) {
        this.committerTimestamp = committerTimestamp;
        return this;
    }

    /**
     * Get committerTimestamp
     *
     * @return committerTimestamp
     **/
    public Long getCommitterTimestamp() {
        return committerTimestamp;
    }

    public void setCommitterTimestamp(Long committerTimestamp) {
        this.committerTimestamp = committerTimestamp;
    }

    public RestCommit displayId(String displayId) {
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

    public RestCommit id(String id) {
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

    public RestCommit message(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get message
     *
     * @return message
     **/
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RestCommit parents(List<RestMinimalCommit> parents) {
        this.parents = parents;
        return this;
    }

    public RestCommit addParentsItem(RestMinimalCommit parentsItem) {
        if (this.parents == null) {
            this.parents = new ArrayList<>();
        }
        this.parents.add(parentsItem);
        return this;
    }

    /**
     * Get parents
     *
     * @return parents
     **/
    public @Valid List<RestMinimalCommit> getParents() {
        return parents;
    }

    public void setParents(List<RestMinimalCommit> parents) {
        this.parents = parents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestCommit)) {
            return false;
        }
        RestCommit other = (RestCommit) o;
        return Objects.equals(this.author, other.author) &&
                Objects.equals(this.authorTimestamp, other.authorTimestamp) &&
                Objects.equals(this.committer, other.committer) &&
                Objects.equals(this.committerTimestamp, other.committerTimestamp) &&
                Objects.equals(this.displayId, other.displayId) &&
                Objects.equals(this.id, other.id) &&
                Objects.equals(this.message, other.message) &&
                Objects.equals(this.parents, other.parents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, authorTimestamp, committer, committerTimestamp, displayId, id, message, parents);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestCommit {");
        sb.append("\n    author: ").append(toIndentedString(author));
        sb.append("\n    authorTimestamp: ").append(toIndentedString(authorTimestamp));
        sb.append("\n    committer: ").append(toIndentedString(committer));
        sb.append("\n    committerTimestamp: ").append(toIndentedString(committerTimestamp));
        sb.append("\n    displayId: ").append(toIndentedString(displayId));
        sb.append("\n    id: ").append(toIndentedString(id));
        sb.append("\n    message: ").append(toIndentedString(message));
        sb.append("\n    parents: ").append(toIndentedString(parents));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
