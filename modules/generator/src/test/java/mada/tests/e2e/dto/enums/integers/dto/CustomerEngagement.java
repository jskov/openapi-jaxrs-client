/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 */

package mada.tests.e2e.dto.enums.integers.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.Valid;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Customer Engagement information.
 *
 */
@Schema(description = "Customer Engagement information.\n")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class CustomerEngagement {
  public static final String JSON_PROPERTY_ROLE_CODE_INT = "roleCodeInt";
  @JsonbProperty(JSON_PROPERTY_ROLE_CODE_INT)
  private RoleCodeInt roleCodeInt;

  public static final String JSON_PROPERTY_ROLE_CODE_LONG = "roleCodeLong";
  @JsonbProperty(JSON_PROPERTY_ROLE_CODE_LONG)
  private RoleCodeLong roleCodeLong;

  public static final String JSON_PROPERTY_ROLE_CODE_SHORT = "roleCodeShort";
  @JsonbProperty(JSON_PROPERTY_ROLE_CODE_SHORT)
  private RoleCodeShort roleCodeShort;

  public CustomerEngagement roleCodeInt(RoleCodeInt roleCodeInt) {
    this.roleCodeInt = roleCodeInt;
    return this;
  }

  /**
   * Get roleCodeInt
   * @return roleCodeInt
   **/
  @Valid
  public RoleCodeInt getRoleCodeInt() {
    return roleCodeInt;
  }

  public void setRoleCodeInt(RoleCodeInt roleCodeInt) {
    this.roleCodeInt = roleCodeInt;
  }

  public CustomerEngagement roleCodeLong(RoleCodeLong roleCodeLong) {
    this.roleCodeLong = roleCodeLong;
    return this;
  }

  /**
   * Get roleCodeLong
   * @return roleCodeLong
   **/
  @Valid
  public RoleCodeLong getRoleCodeLong() {
    return roleCodeLong;
  }

  public void setRoleCodeLong(RoleCodeLong roleCodeLong) {
    this.roleCodeLong = roleCodeLong;
  }

  public CustomerEngagement roleCodeShort(RoleCodeShort roleCodeShort) {
    this.roleCodeShort = roleCodeShort;
    return this;
  }

  /**
   * Get roleCodeShort
   * @return roleCodeShort
   **/
  @Valid
  public RoleCodeShort getRoleCodeShort() {
    return roleCodeShort;
  }

  public void setRoleCodeShort(RoleCodeShort roleCodeShort) {
    this.roleCodeShort = roleCodeShort;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CustomerEngagement)) {
      return false;
    }
    CustomerEngagement other = (CustomerEngagement) o;
    return Objects.equals(this.roleCodeInt, other.roleCodeInt) &&
        Objects.equals(this.roleCodeLong, other.roleCodeLong) &&
        Objects.equals(this.roleCodeShort, other.roleCodeShort);
  }

  @Override
  public int hashCode() {
    return Objects.hash(roleCodeInt, roleCodeLong, roleCodeShort);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerEngagement {");
    sb.append("\n    roleCodeInt: ").append(toIndentedString(roleCodeInt));
    sb.append("\n    roleCodeLong: ").append(toIndentedString(roleCodeLong));
    sb.append("\n    roleCodeShort: ").append(toIndentedString(roleCodeShort));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
