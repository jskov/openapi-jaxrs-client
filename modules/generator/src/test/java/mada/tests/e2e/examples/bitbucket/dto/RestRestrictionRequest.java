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
 * RestRestrictionRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestRestrictionRequest {
  public static final String JSON_PROPERTY_ACCESS_KEY_IDS = "accessKeyIds";
  @JsonbProperty(JSON_PROPERTY_ACCESS_KEY_IDS)
  @Schema(example = "[1,2,3]")
  private List<Integer> accessKeyIds;

  public static final String JSON_PROPERTY_ACCESS_KEYS = "accessKeys";
  @JsonbProperty(JSON_PROPERTY_ACCESS_KEYS)
  private List<RestSshAccessKey> accessKeys;

  public static final String JSON_PROPERTY_GROUP_NAMES = "groupNames";
  @JsonbProperty(JSON_PROPERTY_GROUP_NAMES)
  @Schema(example = "[\"bitbucket-developers\"]")
  private List<String> groupNames;

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
  private RestRestrictionRequestMatcher matcher;

  public static final String JSON_PROPERTY_SCOPE = "scope";
  @JsonbProperty(JSON_PROPERTY_SCOPE)
  @Schema(readOnly = true)
  private RestRestrictionRequestScope scope;

  public static final String JSON_PROPERTY_TYPE = "type";
  @JsonbProperty(JSON_PROPERTY_TYPE)
  @Schema(example = "pull-request-only")
  private String type;

  public static final String JSON_PROPERTY_USERS = "users";
  @JsonbProperty(JSON_PROPERTY_USERS)
  private List<RestApplicationUser> users;

  public static final String JSON_PROPERTY_USER_SLUGS = "userSlugs";
  @JsonbProperty(JSON_PROPERTY_USER_SLUGS)
  @Schema(example = "[\"bman\",\"tstark\",\"hulk\"]")
  private List<String> userSlugs;

  public RestRestrictionRequest accessKeyIds(List<Integer> accessKeyIds) {
    this.accessKeyIds = accessKeyIds;
    return this;
  }

  public RestRestrictionRequest addAccessKeyIdsItem(int accessKeyIdsItem) {
    if (this.accessKeyIds == null) {
      this.accessKeyIds = new ArrayList<>();
    }
    this.accessKeyIds.add(accessKeyIdsItem);
    return this;
  }

  /**
   * Get accessKeyIds
   * @return accessKeyIds
   **/
  public List<Integer> getAccessKeyIds() {
    return accessKeyIds;
  }

  public void setAccessKeyIds(List<Integer> accessKeyIds) {
    this.accessKeyIds = accessKeyIds;
  }

  public RestRestrictionRequest accessKeys(List<RestSshAccessKey> accessKeys) {
    this.accessKeys = accessKeys;
    return this;
  }

  public RestRestrictionRequest addAccessKeysItem(RestSshAccessKey accessKeysItem) {
    if (this.accessKeys == null) {
      this.accessKeys = new ArrayList<>();
    }
    this.accessKeys.add(accessKeysItem);
    return this;
  }

  /**
   * Get accessKeys
   * @return accessKeys
   **/
  @Valid
  public List<RestSshAccessKey> getAccessKeys() {
    return accessKeys;
  }

  public void setAccessKeys(List<RestSshAccessKey> accessKeys) {
    this.accessKeys = accessKeys;
  }

  public RestRestrictionRequest groupNames(List<String> groupNames) {
    this.groupNames = groupNames;
    return this;
  }

  public RestRestrictionRequest addGroupNamesItem(String groupNamesItem) {
    if (this.groupNames == null) {
      this.groupNames = new ArrayList<>();
    }
    this.groupNames.add(groupNamesItem);
    return this;
  }

  /**
   * Get groupNames
   * @return groupNames
   **/
  public List<String> getGroupNames() {
    return groupNames;
  }

  public void setGroupNames(List<String> groupNames) {
    this.groupNames = groupNames;
  }

  public RestRestrictionRequest groups(List<String> groups) {
    this.groups = groups;
    return this;
  }

  public RestRestrictionRequest addGroupsItem(String groupsItem) {
    if (this.groups == null) {
      this.groups = new ArrayList<>();
    }
    this.groups.add(groupsItem);
    return this;
  }

  /**
   * Get groups
   * @return groups
   **/
  public List<String> getGroups() {
    return groups;
  }

  public void setGroups(List<String> groups) {
    this.groups = groups;
  }

  public RestRestrictionRequest id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public RestRestrictionRequest matcher(RestRestrictionRequestMatcher matcher) {
    this.matcher = matcher;
    return this;
  }

  /**
   * Get matcher
   * @return matcher
   **/
  @Valid
  public RestRestrictionRequestMatcher getMatcher() {
    return matcher;
  }

  public void setMatcher(RestRestrictionRequestMatcher matcher) {
    this.matcher = matcher;
  }

  public RestRestrictionRequest scope(RestRestrictionRequestScope scope) {
    this.scope = scope;
    return this;
  }

  /**
   * Get scope
   * @return scope
   **/
  @Valid
  public RestRestrictionRequestScope getScope() {
    return scope;
  }

  public void setScope(RestRestrictionRequestScope scope) {
    this.scope = scope;
  }

  public RestRestrictionRequest type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   **/
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public RestRestrictionRequest users(List<RestApplicationUser> users) {
    this.users = users;
    return this;
  }

  public RestRestrictionRequest addUsersItem(RestApplicationUser usersItem) {
    if (this.users == null) {
      this.users = new ArrayList<>();
    }
    this.users.add(usersItem);
    return this;
  }

  /**
   * Get users
   * @return users
   **/
  @Valid
  public List<RestApplicationUser> getUsers() {
    return users;
  }

  public void setUsers(List<RestApplicationUser> users) {
    this.users = users;
  }

  public RestRestrictionRequest userSlugs(List<String> userSlugs) {
    this.userSlugs = userSlugs;
    return this;
  }

  public RestRestrictionRequest addUserSlugsItem(String userSlugsItem) {
    if (this.userSlugs == null) {
      this.userSlugs = new ArrayList<>();
    }
    this.userSlugs.add(userSlugsItem);
    return this;
  }

  /**
   * Get userSlugs
   * @return userSlugs
   **/
  public List<String> getUserSlugs() {
    return userSlugs;
  }

  public void setUserSlugs(List<String> userSlugs) {
    this.userSlugs = userSlugs;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestRestrictionRequest)) {
      return false;
    }
    RestRestrictionRequest other = (RestRestrictionRequest) o;
    return Objects.equals(this.accessKeyIds, other.accessKeyIds) &&
        Objects.equals(this.accessKeys, other.accessKeys) &&
        Objects.equals(this.groupNames, other.groupNames) &&
        Objects.equals(this.groups, other.groups) &&
        Objects.equals(this.id, other.id) &&
        Objects.equals(this.matcher, other.matcher) &&
        Objects.equals(this.scope, other.scope) &&
        Objects.equals(this.type, other.type) &&
        Objects.equals(this.users, other.users) &&
        Objects.equals(this.userSlugs, other.userSlugs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accessKeyIds, accessKeys, groupNames, groups, id, matcher, scope, type, users, userSlugs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestRestrictionRequest {");
    sb.append("\n    accessKeyIds: ").append(toIndentedString(accessKeyIds));
    sb.append("\n    accessKeys: ").append(toIndentedString(accessKeys));
    sb.append("\n    groupNames: ").append(toIndentedString(groupNames));
    sb.append("\n    groups: ").append(toIndentedString(groups));
    sb.append("\n    id: ").append(toIndentedString(id));
    sb.append("\n    matcher: ").append(toIndentedString(matcher));
    sb.append("\n    scope: ").append(toIndentedString(scope));
    sb.append("\n    type: ").append(toIndentedString(type));
    sb.append("\n    users: ").append(toIndentedString(users));
    sb.append("\n    userSlugs: ").append(toIndentedString(userSlugs));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
