/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.parked.inheritance.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.math.BigDecimal;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * PostDto
 */
@JsonPropertyOrder({
  PostDto.JSON_PROPERTY_POST_TYPE,
  PostDto.JSON_PROPERTY_ENUM_REF,
  PostDto.JSON_PROPERTY_A_SHARED_FIELD
})
@JsonIgnoreProperties(
  value = "postType", // ignore manually set postType, it will be automatically generated by Jackson during serialization
  allowSetters = true // allows the postType to be set during deserialization
)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "postType", visible = true)
@JsonSubTypes({
  @JsonSubTypes.Type(value = PostSubA.class, name = "PostSubA"),
  @JsonSubTypes.Type(value = PostSubB.class, name = "PostSubB"),
})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class PostDto {
  public static final String JSON_PROPERTY_POST_TYPE = "postType";
  @JsonProperty(JSON_PROPERTY_POST_TYPE)
  @Schema(description = "Contains typename")
  private String postType;

  public static final String JSON_PROPERTY_ENUM_REF = "enumRef";
  @JsonProperty(JSON_PROPERTY_ENUM_REF)
  private AnEnum enumRef;

  public static final String JSON_PROPERTY_A_SHARED_FIELD = "aSharedField";
  @JsonProperty(JSON_PROPERTY_A_SHARED_FIELD)
  private BigDecimal aSharedField;

  public PostDto postType(String postType) {
    this.postType = postType;
    return this;
  }

  /**
   * Contains typename.
   *
   * @return postType
   **/
  public String getPostType() {
    return postType;
  }

  public void setPostType(String postType) {
    this.postType = postType;
  }

  public PostDto enumRef(AnEnum enumRef) {
    this.enumRef = enumRef;
    return this;
  }

  /**
   * Get enumRef
   * @return enumRef
   **/
  @Valid
  public AnEnum getEnumRef() {
    return enumRef;
  }

  public void setEnumRef(AnEnum enumRef) {
    this.enumRef = enumRef;
  }

  public PostDto aSharedField(BigDecimal aSharedField) {
    this.aSharedField = aSharedField;
    return this;
  }

  /**
   * Get aSharedField
   * minimum: "0"
   * maximum: "1"
   * @return aSharedField
   **/
  @DecimalMin("0") @DecimalMax("1")
  public BigDecimal getASharedField() {
    return aSharedField;
  }

  public void setASharedField(BigDecimal aSharedField) {
    this.aSharedField = aSharedField;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostDto other = (PostDto) o;
    return Objects.equals(this.postType, other.postType) &&
        Objects.equals(this.enumRef, other.enumRef) &&
        Objects.equals(this.aSharedField, other.aSharedField);
  }

  @Override
  public int hashCode() {
    return Objects.hash(postType, enumRef, aSharedField);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostDto {");
    sb.append("\n    postType: ").append(toIndentedString(postType));
    sb.append("\n    enumRef: ").append(toIndentedString(enumRef));
    sb.append("\n    aSharedField: ").append(toIndentedString(aSharedField));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
