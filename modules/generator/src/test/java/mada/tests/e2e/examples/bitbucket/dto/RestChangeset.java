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
 * RestChangeset
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestChangeset {
    public static final String JSON_PROPERTY_CHANGES = "changes";
    @JsonbProperty(JSON_PROPERTY_CHANGES)
    private RestChangesetChanges changes;

    public static final String JSON_PROPERTY_FROM_COMMIT = "fromCommit";
    @JsonbProperty(JSON_PROPERTY_FROM_COMMIT)
    private RestChangesetFromCommit fromCommit;

    public static final String JSON_PROPERTY_LINKS = "links";
    @JsonbProperty(JSON_PROPERTY_LINKS)
    private Object links;

    public static final String JSON_PROPERTY_REPOSITORY = "repository";
    @JsonbProperty(JSON_PROPERTY_REPOSITORY)
    private RestChangesetRepository repository;

    public static final String JSON_PROPERTY_TO_COMMIT = "toCommit";
    @JsonbProperty(JSON_PROPERTY_TO_COMMIT)
    private RestChangesetToCommit toCommit;

    public RestChangeset changes(RestChangesetChanges changes) {
        this.changes = changes;
        return this;
    }

    /**
     * Get changes
     *
     * @return changes
     **/
    @Valid
    public RestChangesetChanges getChanges() {
        return changes;
    }

    public void setChanges(RestChangesetChanges changes) {
        this.changes = changes;
    }

    public RestChangeset fromCommit(RestChangesetFromCommit fromCommit) {
        this.fromCommit = fromCommit;
        return this;
    }

    /**
     * Get fromCommit
     *
     * @return fromCommit
     **/
    @Valid
    public RestChangesetFromCommit getFromCommit() {
        return fromCommit;
    }

    public void setFromCommit(RestChangesetFromCommit fromCommit) {
        this.fromCommit = fromCommit;
    }

    public RestChangeset links(Object links) {
        this.links = links;
        return this;
    }

    /**
     * Get links
     *
     * @return links
     **/
    public Object getLinks() {
        return links;
    }

    public void setLinks(Object links) {
        this.links = links;
    }

    public RestChangeset repository(RestChangesetRepository repository) {
        this.repository = repository;
        return this;
    }

    /**
     * Get repository
     *
     * @return repository
     **/
    @Valid
    public RestChangesetRepository getRepository() {
        return repository;
    }

    public void setRepository(RestChangesetRepository repository) {
        this.repository = repository;
    }

    public RestChangeset toCommit(RestChangesetToCommit toCommit) {
        this.toCommit = toCommit;
        return this;
    }

    /**
     * Get toCommit
     *
     * @return toCommit
     **/
    @Valid
    public RestChangesetToCommit getToCommit() {
        return toCommit;
    }

    public void setToCommit(RestChangesetToCommit toCommit) {
        this.toCommit = toCommit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestChangeset)) {
            return false;
        }
        RestChangeset other = (RestChangeset) o;
        return Objects.equals(this.changes, other.changes) &&
                Objects.equals(this.fromCommit, other.fromCommit) &&
                Objects.equals(this.links, other.links) &&
                Objects.equals(this.repository, other.repository) &&
                Objects.equals(this.toCommit, other.toCommit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(changes, fromCommit, links, repository, toCommit);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestChangeset {");
        sb.append("\n    changes: ").append(toIndentedString(changes));
        sb.append("\n    fromCommit: ").append(toIndentedString(fromCommit));
        sb.append("\n    links: ").append(toIndentedString(links));
        sb.append("\n    repository: ").append(toIndentedString(repository));
        sb.append("\n    toCommit: ").append(toIndentedString(toCommit));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
