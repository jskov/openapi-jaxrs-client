/*
 * Swagger Petstore - OpenAPI 3.0
 * This is a sample Pet Store Server based on the OpenAPI 3.0 specification.  You can find out more about
Swagger at [https://swagger.io](https://swagger.io). In the third iteration of the pet store, we've switched to the design first approach!
You can now help us improve the API whether it's by making changes to the definition itself or to the code.
That way, with time, we can improve the API in general, and expose some of the new features in OAS3.

Some useful links:
- [The Pet Store repository](https://github.com/swagger-api/swagger-petstore)
- [The source API definition for the Pet Store](https://github.com/swagger-api/swagger-petstore/blob/master/src/main/resources/openapi.yaml)
 *
 * The version of the OpenAPI document: 1.0.27-SNAPSHOT
 * Contact: apiteam@swagger.io
 */

package mada.tests.e2e.examples.petstore.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * User
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class User {
  public static final String JSON_PROPERTY_EMAIL = "email";
  @JsonbProperty(JSON_PROPERTY_EMAIL)
  @Schema(example = "john@email.com")
  private String email;

  public static final String JSON_PROPERTY_FIRST_NAME = "firstName";
  @JsonbProperty(JSON_PROPERTY_FIRST_NAME)
  @Schema(example = "John")
  private String firstName;

  public static final String JSON_PROPERTY_ID = "id";
  @JsonbProperty(JSON_PROPERTY_ID)
  @Schema(example = "10")
  private Long id;

  public static final String JSON_PROPERTY_LAST_NAME = "lastName";
  @JsonbProperty(JSON_PROPERTY_LAST_NAME)
  @Schema(example = "James")
  private String lastName;

  public static final String JSON_PROPERTY_PASSWORD = "password";
  @JsonbProperty(JSON_PROPERTY_PASSWORD)
  @Schema(example = "12345")
  private String password;

  public static final String JSON_PROPERTY_PHONE = "phone";
  @JsonbProperty(JSON_PROPERTY_PHONE)
  @Schema(example = "12345")
  private String phone;

  public static final String JSON_PROPERTY_USERNAME = "username";
  @JsonbProperty(JSON_PROPERTY_USERNAME)
  @Schema(example = "theUser")
  private String username;

  public static final String JSON_PROPERTY_USER_STATUS = "userStatus";
  @JsonbProperty(JSON_PROPERTY_USER_STATUS)
  @Schema(description = "User Status", example = "1")
  private Integer userStatus;

  public User email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   **/
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public User firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * Get firstName
   * @return firstName
   **/
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public User id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Get lastName
   * @return lastName
   **/
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public User password(String password) {
    this.password = password;
    return this;
  }

  /**
   * Get password
   * @return password
   **/
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public User phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Get phone
   * @return phone
   **/
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public User username(String username) {
    this.username = username;
    return this;
  }

  /**
   * Get username
   * @return username
   **/
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public User userStatus(Integer userStatus) {
    this.userStatus = userStatus;
    return this;
  }

  /**
   * User Status.
   *
   * @return userStatus
   **/
  public Integer getUserStatus() {
    return userStatus;
  }

  public void setUserStatus(Integer userStatus) {
    this.userStatus = userStatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof User)) {
      return false;
    }
    User other = (User) o;
    return Objects.equals(this.email, other.email) &&
        Objects.equals(this.firstName, other.firstName) &&
        Objects.equals(this.id, other.id) &&
        Objects.equals(this.lastName, other.lastName) &&
        Objects.equals(this.password, other.password) &&
        Objects.equals(this.phone, other.phone) &&
        Objects.equals(this.username, other.username) &&
        Objects.equals(this.userStatus, other.userStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email, firstName, id, lastName, password, phone, username, userStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {");
    sb.append("\n    email: ").append(toIndentedString(email));
    sb.append("\n    firstName: ").append(toIndentedString(firstName));
    sb.append("\n    id: ").append(toIndentedString(id));
    sb.append("\n    lastName: ").append(toIndentedString(lastName));
    sb.append("\n    password: ").append(toIndentedString(password));
    sb.append("\n    phone: ").append(toIndentedString(phone));
    sb.append("\n    username: ").append(toIndentedString(username));
    sb.append("\n    userStatus: ").append(toIndentedString(userStatus));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
