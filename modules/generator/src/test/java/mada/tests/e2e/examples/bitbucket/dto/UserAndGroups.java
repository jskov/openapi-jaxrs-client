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
 * UserAndGroups
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class UserAndGroups {
  public static final String JSON_PROPERTY_GROUPS = "groups";
  @JsonbProperty(JSON_PROPERTY_GROUPS)
  @Schema(required = true, example = "[\"group_a\",\"group_b\"]")
  private Set<String> groups = new LinkedHashSet<>();

  public static final String JSON_PROPERTY_USER = "user";
  @JsonbProperty(JSON_PROPERTY_USER)
  @Schema(example = "user")
  private String user;

  public UserAndGroups groups(Set<String> groups) {
    this.groups = Objects.requireNonNull(groups, "Property groups is required, cannot be null");
    return this;
  }

  public UserAndGroups addGroupsItem(String groupsItem) {
    this.groups.add(groupsItem);
    return this;
  }

  /**
   * Get groups
   * @return groups
   **/
  @NotNull
  public Set<String> getGroups() {
    return groups;
  }

  public void setGroups(Set<String> groups) {
    this.groups = Objects.requireNonNull(groups, "Property groups is required, cannot be null");
  }

  public UserAndGroups user(String user) {
    this.user = user;
    return this;
  }

  /**
   * Get user
   * @return user
   **/
  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof UserAndGroups)) {
      return false;
    }
    UserAndGroups other = (UserAndGroups) o;
    return Objects.equals(this.groups, other.groups) &&
        Objects.equals(this.user, other.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(groups, user);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserAndGroups {");
    sb.append("\n    groups: ").append(toIndentedString(groups));
    sb.append("\n    user: ").append(toIndentedString(user));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
