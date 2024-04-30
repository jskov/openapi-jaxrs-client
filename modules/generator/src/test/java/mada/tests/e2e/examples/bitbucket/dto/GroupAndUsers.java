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
import jakarta.validation.constraints.NotNull;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * GroupAndUsers
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class GroupAndUsers {
  public static final String JSON_PROPERTY_GROUP = "group";
  @JsonbProperty(JSON_PROPERTY_GROUP)
  @Schema(example = "group")
  private String group;

  public static final String JSON_PROPERTY_USERS = "users";
  @JsonbProperty(JSON_PROPERTY_USERS)
  @Schema(required = true, example = "[\"user1\",\"user2\"]")
  private Set<String> users = new LinkedHashSet<>();

  public GroupAndUsers group(String group) {
    this.group = group;
    return this;
  }

  /**
   * Get group
   * @return group
   **/
  public String getGroup() {
    return group;
  }

  public void setGroup(String group) {
    this.group = group;
  }

  public GroupAndUsers users(Set<String> users) {
    this.users = Objects.requireNonNull(users, "Property users is required, cannot be null");
    return this;
  }

  public GroupAndUsers addUsersItem(String usersItem) {
    this.users.add(usersItem);
    return this;
  }

  /**
   * Get users
   * @return users
   **/
  @NotNull
  public Set<String> getUsers() {
    return users;
  }

  public void setUsers(Set<String> users) {
    this.users = Objects.requireNonNull(users, "Property users is required, cannot be null");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof GroupAndUsers)) {
      return false;
    }
    GroupAndUsers other = (GroupAndUsers) o;
    return Objects.equals(this.group, other.group) &&
        Objects.equals(this.users, other.users);
  }

  @Override
  public int hashCode() {
    return Objects.hash(group, users);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GroupAndUsers {");
    sb.append("\n    group: ").append(toIndentedString(group));
    sb.append("\n    users: ").append(toIndentedString(users));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
