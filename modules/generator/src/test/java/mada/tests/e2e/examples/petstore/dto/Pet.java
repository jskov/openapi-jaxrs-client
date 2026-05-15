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

import jakarta.json.Json;
import jakarta.json.JsonString;
import jakarta.json.bind.adapter.JsonbAdapter;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTypeAdapter;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Pet
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class Pet {
  public static final String JSON_PROPERTY_CATEGORY = "category";
  @JsonbProperty(JSON_PROPERTY_CATEGORY)
  private Category category;

  public static final String JSON_PROPERTY_ID = "id";
  @JsonbProperty(JSON_PROPERTY_ID)
  @Schema(example = "10")
  private Long id;

  public static final String JSON_PROPERTY_NAME = "name";
  @JsonbProperty(JSON_PROPERTY_NAME)
  @Schema(required = true, example = "doggie")
  private String name;

  public static final String JSON_PROPERTY_PHOTO_URLS = "photoUrls";
  @JsonbProperty(JSON_PROPERTY_PHOTO_URLS)
  @Schema(required = true)
  private List<String> photoUrls = new ArrayList<>();

  /**
   * pet status in the store.
   */
  @Schema(enumeration = {"available", "pending", "sold"}, type = SchemaType.STRING)
  public enum StatusEnum {
    AVAILABLE("available"),
    PENDING("pending"),
    SOLD("sold");

    private final String value;

    StatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static class StatusEnumAdapter implements JsonbAdapter<StatusEnum, JsonString> {
      @Override
      public JsonString adaptToJson(StatusEnum e) throws Exception {
        return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public StatusEnum adaptFromJson(JsonString value) throws Exception {
        for (StatusEnum b : StatusEnum.values()) {
          if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
            return b;
          }
        }
        throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type StatusEnum");
      }
    }
  }

  public static final String JSON_PROPERTY_STATUS = "status";
  @JsonbProperty(JSON_PROPERTY_STATUS)
  @JsonbTypeAdapter(mada.tests.e2e.examples.petstore.dto.Pet.StatusEnum.StatusEnumAdapter.class)
  @Schema(description = "pet status in the store")
  private StatusEnum status;

  public static final String JSON_PROPERTY_TAGS = "tags";
  @JsonbProperty(JSON_PROPERTY_TAGS)
  private List<Tag> tags;

  public Pet category(Category category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
   **/
  @Valid
  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public Pet id(Long id) {
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

  public Pet name(String name) {
    this.name = Objects.requireNonNull(name, "Property name is required, cannot be null");
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @NotNull
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = Objects.requireNonNull(name, "Property name is required, cannot be null");
  }

  public Pet photoUrls(List<String> photoUrls) {
    this.photoUrls = Objects.requireNonNull(photoUrls, "Property photoUrls is required, cannot be null");
    return this;
  }

  public Pet addPhotoUrlsItem(String photoUrlsItem) {
    this.photoUrls.add(photoUrlsItem);
    return this;
  }

  /**
   * Get photoUrls
   * @return photoUrls
   **/
  @NotNull
  public List<String> getPhotoUrls() {
    return photoUrls;
  }

  public void setPhotoUrls(List<String> photoUrls) {
    this.photoUrls = Objects.requireNonNull(photoUrls, "Property photoUrls is required, cannot be null");
  }

  public Pet status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * pet status in the store.
   *
   * @return status
   **/
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public Pet tags(List<Tag> tags) {
    this.tags = tags;
    return this;
  }

  public Pet addTagsItem(Tag tagsItem) {
    if (this.tags == null) {
      this.tags = new ArrayList<>();
    }
    this.tags.add(tagsItem);
    return this;
  }

  /**
   * Get tags
   * @return tags
   **/
  public List<@Valid Tag> getTags() {
    return tags;
  }

  public void setTags(List<Tag> tags) {
    this.tags = tags;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Pet)) {
      return false;
    }
    Pet other = (Pet) o;
    return Objects.equals(this.category, other.category) &&
        Objects.equals(this.id, other.id) &&
        Objects.equals(this.name, other.name) &&
        Objects.equals(this.photoUrls, other.photoUrls) &&
        Objects.equals(this.status, other.status) &&
        Objects.equals(this.tags, other.tags);
  }

  @Override
  public int hashCode() {
    return Objects.hash(category, id, name, photoUrls, status, tags);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Pet {");
    sb.append("\n    category: ").append(toIndentedString(category));
    sb.append("\n    id: ").append(toIndentedString(id));
    sb.append("\n    name: ").append(toIndentedString(name));
    sb.append("\n    photoUrls: ").append(toIndentedString(photoUrls));
    sb.append("\n    status: ").append(toIndentedString(status));
    sb.append("\n    tags: ").append(toIndentedString(tags));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
