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
 * RestRefRestriction
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestRefRestriction {
    public static final String JSON_PROPERTY_ACCESS_KEYS = "accessKeys";
    @JsonbProperty(JSON_PROPERTY_ACCESS_KEYS)
    private List<RestSshAccessKey> accessKeys;

    public static final String JSON_PROPERTY_GROUPS = "groups";
    @JsonbProperty(JSON_PROPERTY_GROUPS)
    @Schema(example = "[\"group_a\",\"group_b\"]")
    private List<String> groups;

    public static final String JSON_PROPERTY_ID = "id";
    @JsonbProperty(JSON_PROPERTY_ID)
    @Schema(readOnly = true, example = "1")
    private Integer id;

    public static final String JSON_PROPERTY_MATCHER = "matcher";
    @JsonbProperty(JSON_PROPERTY_MATCHER)
    private RestRefRestrictionMatcher matcher;

    public static final String JSON_PROPERTY_SCOPE = "scope";
    @JsonbProperty(JSON_PROPERTY_SCOPE)
    @Schema(readOnly = true)
    private RestRefRestrictionScope scope;

    public static final String JSON_PROPERTY_TYPE = "type";
    @JsonbProperty(JSON_PROPERTY_TYPE)
    @Schema(example = "pull-request-only")
    private String type;

    public static final String JSON_PROPERTY_USERS = "users";
    @JsonbProperty(JSON_PROPERTY_USERS)
    private List<RestApplicationUser> users;

    public RestRefRestriction accessKeys(List<RestSshAccessKey> accessKeys) {
        this.accessKeys = accessKeys;
        return this;
    }

    public RestRefRestriction addAccessKeysItem(RestSshAccessKey accessKeysItem) {
        if (this.accessKeys == null) {
            this.accessKeys = new ArrayList<>();
        }
        this.accessKeys.add(accessKeysItem);
        return this;
    }

    /**
     * Get accessKeys
     *
     * @return accessKeys
     **/
    @Valid public List<RestSshAccessKey> getAccessKeys() {
        return accessKeys;
    }

    public void setAccessKeys(List<RestSshAccessKey> accessKeys) {
        this.accessKeys = accessKeys;
    }

    public RestRefRestriction groups(List<String> groups) {
        this.groups = groups;
        return this;
    }

    public RestRefRestriction addGroupsItem(String groupsItem) {
        if (this.groups == null) {
            this.groups = new ArrayList<>();
        }
        this.groups.add(groupsItem);
        return this;
    }

    /**
     * Get groups
     *
     * @return groups
     **/
    public List<String> getGroups() {
        return groups;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    public RestRefRestriction id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RestRefRestriction matcher(RestRefRestrictionMatcher matcher) {
        this.matcher = matcher;
        return this;
    }

    /**
     * Get matcher
     *
     * @return matcher
     **/
    @Valid public RestRefRestrictionMatcher getMatcher() {
        return matcher;
    }

    public void setMatcher(RestRefRestrictionMatcher matcher) {
        this.matcher = matcher;
    }

    public RestRefRestriction scope(RestRefRestrictionScope scope) {
        this.scope = scope;
        return this;
    }

    /**
     * Get scope
     *
     * @return scope
     **/
    @Valid public RestRefRestrictionScope getScope() {
        return scope;
    }

    public void setScope(RestRefRestrictionScope scope) {
        this.scope = scope;
    }

    public RestRefRestriction type(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     **/
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public RestRefRestriction users(List<RestApplicationUser> users) {
        this.users = users;
        return this;
    }

    public RestRefRestriction addUsersItem(RestApplicationUser usersItem) {
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
    @Valid public List<RestApplicationUser> getUsers() {
        return users;
    }

    public void setUsers(List<RestApplicationUser> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestRefRestriction)) {
            return false;
        }
        RestRefRestriction other = (RestRefRestriction) o;
        return Objects.equals(this.accessKeys, other.accessKeys) &&
                Objects.equals(this.groups, other.groups) &&
                Objects.equals(this.id, other.id) &&
                Objects.equals(this.matcher, other.matcher) &&
                Objects.equals(this.scope, other.scope) &&
                Objects.equals(this.type, other.type) &&
                Objects.equals(this.users, other.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessKeys, groups, id, matcher, scope, type, users);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestRefRestriction {");
        sb.append("\n    accessKeys: ").append(toIndentedString(accessKeys));
        sb.append("\n    groups: ").append(toIndentedString(groups));
        sb.append("\n    id: ").append(toIndentedString(id));
        sb.append("\n    matcher: ").append(toIndentedString(matcher));
        sb.append("\n    scope: ").append(toIndentedString(scope));
        sb.append("\n    type: ").append(toIndentedString(type));
        sb.append("\n    users: ").append(toIndentedString(users));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
