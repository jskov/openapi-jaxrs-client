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

import jakarta.json.Json;
import jakarta.json.JsonString;
import jakarta.json.bind.adapter.JsonbAdapter;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTypeAdapter;
import java.util.Objects;

/**
 * ApplicationUser
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ApplicationUser {
  public static final String JSON_PROPERTY_ACTIVE = "active";
  @JsonbProperty(JSON_PROPERTY_ACTIVE)
  private Boolean active;

  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
  @JsonbProperty(JSON_PROPERTY_DISPLAY_NAME)
  private String displayName;

  public static final String JSON_PROPERTY_EMAIL_ADDRESS = "emailAddress";
  @JsonbProperty(JSON_PROPERTY_EMAIL_ADDRESS)
  private String emailAddress;

  public static final String JSON_PROPERTY_ID = "id";
  @JsonbProperty(JSON_PROPERTY_ID)
  private Integer id;

  public static final String JSON_PROPERTY_NAME = "name";
  @JsonbProperty(JSON_PROPERTY_NAME)
  private String name;

  public static final String JSON_PROPERTY_SLUG = "slug";
  @JsonbProperty(JSON_PROPERTY_SLUG)
  private String slug;

  public enum TypeEnum {
    NORMAL("NORMAL"),
    SERVICE("SERVICE");

    private final String value;

    TypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static class TypeEnumAdapter implements JsonbAdapter<TypeEnum, JsonString> {
      @Override
      public JsonString adaptToJson(TypeEnum e) throws Exception {
        return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public TypeEnum adaptFromJson(JsonString value) throws Exception {
        for (TypeEnum b : TypeEnum.values()) {
          if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
            return b;
          }
        }
        throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type TypeEnum");
      }
    }
  }

  public static final String JSON_PROPERTY_TYPE = "type";
  @JsonbProperty(JSON_PROPERTY_TYPE)
  @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.ApplicationUser.TypeEnum.TypeEnumAdapter.class)
  private TypeEnum type;

  public ApplicationUser active(Boolean active) {
    this.active = active;
    return this;
  }

  /**
   * Get active
   * @return active
   **/
  public Boolean isActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public ApplicationUser displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }

  /**
   * Get displayName
   * @return displayName
   **/
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  public ApplicationUser emailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
    return this;
  }

  /**
   * Get emailAddress
   * @return emailAddress
   **/
  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public ApplicationUser id(Integer id) {
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

  public ApplicationUser name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ApplicationUser slug(String slug) {
    this.slug = slug;
    return this;
  }

  /**
   * Get slug
   * @return slug
   **/
  public String getSlug() {
    return slug;
  }

  public void setSlug(String slug) {
    this.slug = slug;
  }

  public ApplicationUser type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   **/
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ApplicationUser)) {
      return false;
    }
    ApplicationUser other = (ApplicationUser) o;
    return Objects.equals(this.active, other.active) &&
        Objects.equals(this.displayName, other.displayName) &&
        Objects.equals(this.emailAddress, other.emailAddress) &&
        Objects.equals(this.id, other.id) &&
        Objects.equals(this.name, other.name) &&
        Objects.equals(this.slug, other.slug) &&
        Objects.equals(this.type, other.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(active, displayName, emailAddress, id, name, slug, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApplicationUser {");
    sb.append("\n    active: ").append(toIndentedString(active));
    sb.append("\n    displayName: ").append(toIndentedString(displayName));
    sb.append("\n    emailAddress: ").append(toIndentedString(emailAddress));
    sb.append("\n    id: ").append(toIndentedString(id));
    sb.append("\n    name: ").append(toIndentedString(name));
    sb.append("\n    slug: ").append(toIndentedString(slug));
    sb.append("\n    type: ").append(toIndentedString(type));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
