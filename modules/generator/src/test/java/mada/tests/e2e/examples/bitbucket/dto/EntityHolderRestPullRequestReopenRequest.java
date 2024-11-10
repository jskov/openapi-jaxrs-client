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
 * EntityHolderRestPullRequestReopenRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class EntityHolderRestPullRequestReopenRequest {
    public static final String JSON_PROPERTY_ENTITY = "entity";
    @JsonbProperty(JSON_PROPERTY_ENTITY)
    private EntityHolderRestPullRequestReopenRequestEntity entity;

    public EntityHolderRestPullRequestReopenRequest entity(EntityHolderRestPullRequestReopenRequestEntity entity) {
        this.entity = entity;
        return this;
    }

    /**
     * Get entity
     *
     * @return entity
     **/
    public @Valid EntityHolderRestPullRequestReopenRequestEntity getEntity() {
        return entity;
    }

    public void setEntity(EntityHolderRestPullRequestReopenRequestEntity entity) {
        this.entity = entity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EntityHolderRestPullRequestReopenRequest)) {
            return false;
        }
        EntityHolderRestPullRequestReopenRequest other = (EntityHolderRestPullRequestReopenRequest) o;
        return Objects.equals(this.entity, other.entity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entity);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EntityHolderRestPullRequestReopenRequest {");
        sb.append("\n    entity: ").append(toIndentedString(entity));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
