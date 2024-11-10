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
 * RestReviewerGroup
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestReviewerGroup {
    public static final String JSON_PROPERTY_AVATAR_URL = "avatarUrl";
    @JsonbProperty(JSON_PROPERTY_AVATAR_URL)
    private String avatarUrl;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    @JsonbProperty(JSON_PROPERTY_DESCRIPTION)
    @Schema(example = "null")
    private String description;

    public static final String JSON_PROPERTY_ID = "id";
    @JsonbProperty(JSON_PROPERTY_ID)
    private Long id;

    public static final String JSON_PROPERTY_NAME = "name";
    @JsonbProperty(JSON_PROPERTY_NAME)
    @Schema(example = "name")
    private String name;

    public static final String JSON_PROPERTY_SCOPE = "scope";
    @JsonbProperty(JSON_PROPERTY_SCOPE)
    private RestReviewerGroupScope scope;

    public static final String JSON_PROPERTY_USERS = "users";
    @JsonbProperty(JSON_PROPERTY_USERS)
    private List<ApplicationUser> users;

    public RestReviewerGroup avatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }

    /**
     * Get avatarUrl
     *
     * @return avatarUrl
     **/
    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public RestReviewerGroup description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     **/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RestReviewerGroup id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RestReviewerGroup name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RestReviewerGroup scope(RestReviewerGroupScope scope) {
        this.scope = scope;
        return this;
    }

    /**
     * Get scope
     *
     * @return scope
     **/
    public @Valid RestReviewerGroupScope getScope() {
        return scope;
    }

    public void setScope(RestReviewerGroupScope scope) {
        this.scope = scope;
    }

    public RestReviewerGroup users(List<ApplicationUser> users) {
        this.users = users;
        return this;
    }

    public RestReviewerGroup addUsersItem(ApplicationUser usersItem) {
        if (this.users == null) {
            this.users = new ArrayList<>();
        }
        this.users.add(usersItem);
        return this;
    }

    /**
     * Get users
     *
     * @return users
     **/
    public @Valid List<ApplicationUser> getUsers() {
        return users;
    }

    public void setUsers(List<ApplicationUser> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestReviewerGroup)) {
            return false;
        }
        RestReviewerGroup other = (RestReviewerGroup) o;
        return Objects.equals(this.avatarUrl, other.avatarUrl) &&
                Objects.equals(this.description, other.description) &&
                Objects.equals(this.id, other.id) &&
                Objects.equals(this.name, other.name) &&
                Objects.equals(this.scope, other.scope) &&
                Objects.equals(this.users, other.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(avatarUrl, description, id, name, scope, users);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestReviewerGroup {");
        sb.append("\n    avatarUrl: ").append(toIndentedString(avatarUrl));
        sb.append("\n    description: ").append(toIndentedString(description));
        sb.append("\n    id: ").append(toIndentedString(id));
        sb.append("\n    name: ").append(toIndentedString(name));
        sb.append("\n    scope: ").append(toIndentedString(scope));
        sb.append("\n    users: ").append(toIndentedString(users));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
