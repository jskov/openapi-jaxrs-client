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
 * ExampleJsonLastModifiedCallbackLatestCommit
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ExampleJsonLastModifiedCallbackLatestCommit {
    public static final String JSON_PROPERTY_AUTHOR = "author";
    @JsonbProperty(JSON_PROPERTY_AUTHOR)
    private ExampleJsonLastModifiedCallbackLatestCommitAuthor author;

    public static final String JSON_PROPERTY_AUTHOR_TIMESTAMP = "authorTimestamp";
    @JsonbProperty(JSON_PROPERTY_AUTHOR_TIMESTAMP)
    @Schema(example = "1359075920")
    private Long authorTimestamp;

    public static final String JSON_PROPERTY_COMMITTER = "committer";
    @JsonbProperty(JSON_PROPERTY_COMMITTER)
    private ExampleJsonLastModifiedCallbackLatestCommitCommitter committer;

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

    public ExampleJsonLastModifiedCallbackLatestCommit author(ExampleJsonLastModifiedCallbackLatestCommitAuthor author) {
        this.author = author;
        return this;
    }

    /**
     * Get author
     *
     * @return author
     **/
    @Valid public ExampleJsonLastModifiedCallbackLatestCommitAuthor getAuthor() {
        return author;
    }

    public void setAuthor(ExampleJsonLastModifiedCallbackLatestCommitAuthor author) {
        this.author = author;
    }

    public ExampleJsonLastModifiedCallbackLatestCommit authorTimestamp(Long authorTimestamp) {
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

    public ExampleJsonLastModifiedCallbackLatestCommit committer(ExampleJsonLastModifiedCallbackLatestCommitCommitter committer) {
        this.committer = committer;
        return this;
    }

    /**
     * Get committer
     *
     * @return committer
     **/
    @Valid public ExampleJsonLastModifiedCallbackLatestCommitCommitter getCommitter() {
        return committer;
    }

    public void setCommitter(ExampleJsonLastModifiedCallbackLatestCommitCommitter committer) {
        this.committer = committer;
    }

    public ExampleJsonLastModifiedCallbackLatestCommit committerTimestamp(Long committerTimestamp) {
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

    public ExampleJsonLastModifiedCallbackLatestCommit displayId(String displayId) {
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

    public ExampleJsonLastModifiedCallbackLatestCommit id(String id) {
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

    public ExampleJsonLastModifiedCallbackLatestCommit message(String message) {
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

    public ExampleJsonLastModifiedCallbackLatestCommit parents(List<RestMinimalCommit> parents) {
        this.parents = parents;
        return this;
    }

    public ExampleJsonLastModifiedCallbackLatestCommit addParentsItem(RestMinimalCommit parentsItem) {
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
    @Valid public List<RestMinimalCommit> getParents() {
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
        if (!(o instanceof ExampleJsonLastModifiedCallbackLatestCommit)) {
            return false;
        }
        ExampleJsonLastModifiedCallbackLatestCommit other = (ExampleJsonLastModifiedCallbackLatestCommit) o;
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
        sb.append("class ExampleJsonLastModifiedCallbackLatestCommit {");
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
