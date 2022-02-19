/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.dto.serializer.jackson_codehaus.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.AccessMode;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

/**
 * MicroprofileAnnotations
 */
@JsonPropertyOrder({
  MicroprofileAnnotations.JSON_PROPERTY_WITH_DESCRIPTION,
  MicroprofileAnnotations.JSON_PROPERTY_WITH_EXAMPLE,
  MicroprofileAnnotations.JSON_PROPERTY_IS_REQUIRED,
  MicroprofileAnnotations.JSON_PROPERTY_REQUIRED_AND_DESCRIPTION_AND_EXAMPLE,
  MicroprofileAnnotations.JSON_PROPERTY_REQUIRED_AND_EXAMPLE,
  MicroprofileAnnotations.JSON_PROPERTY_REQUIRED_AND_DESCRIPTION,
  MicroprofileAnnotations.JSON_PROPERTY_DESCRIPTION_AND_EXAMPLE,
  MicroprofileAnnotations.JSON_PROPERTY_IS_READONLY,
  MicroprofileAnnotations.JSON_PROPERTY_READONLY_REQUIRED_AND_DESCRIPTION_AND_EXAMPLE
})
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public class MicroprofileAnnotations   {
  public static final String JSON_PROPERTY_WITH_DESCRIPTION = "withDescription";
  @JsonProperty(JSON_PROPERTY_WITH_DESCRIPTION)
  @Schema(description = "openapi property description")
  private String withDescription;

  public static final String JSON_PROPERTY_WITH_EXAMPLE = "withExample";
  @JsonProperty(JSON_PROPERTY_WITH_EXAMPLE)
  @Schema(example = "openapi property example")
  private String withExample;

  public static final String JSON_PROPERTY_IS_REQUIRED = "isRequired";
  @JsonProperty(JSON_PROPERTY_IS_REQUIRED)
  @Schema(required = true)
  private String isRequired;

  public static final String JSON_PROPERTY_REQUIRED_AND_DESCRIPTION_AND_EXAMPLE = "requiredAndDescriptionAndExample";
  @JsonProperty(JSON_PROPERTY_REQUIRED_AND_DESCRIPTION_AND_EXAMPLE)
  @Schema(required = true, description = "text_description", example = "text_example")
  private String requiredAndDescriptionAndExample;

  public static final String JSON_PROPERTY_REQUIRED_AND_EXAMPLE = "requiredAndExample";
  @JsonProperty(JSON_PROPERTY_REQUIRED_AND_EXAMPLE)
  @Schema(required = true, example = "text_example")
  private String requiredAndExample;

  public static final String JSON_PROPERTY_REQUIRED_AND_DESCRIPTION = "requiredAndDescription";
  @JsonProperty(JSON_PROPERTY_REQUIRED_AND_DESCRIPTION)
  @Schema(required = true, description = "text_description")
  private String requiredAndDescription;

  public static final String JSON_PROPERTY_DESCRIPTION_AND_EXAMPLE = "descriptionAndExample";
  @JsonProperty(JSON_PROPERTY_DESCRIPTION_AND_EXAMPLE)
  @Schema(description = "text_description", example = "text_example")
  private String descriptionAndExample;

  public static final String JSON_PROPERTY_IS_READONLY = "isReadonly";
  @JsonProperty(JSON_PROPERTY_IS_READONLY)
  @Schema(accessMode = AccessMode.READ_ONLY)
  private String isReadonly;

  public static final String JSON_PROPERTY_READONLY_REQUIRED_AND_DESCRIPTION_AND_EXAMPLE = "readonlyRequiredAndDescriptionAndExample";
  @JsonProperty(JSON_PROPERTY_READONLY_REQUIRED_AND_DESCRIPTION_AND_EXAMPLE)
  @Schema(required = true, accessMode = AccessMode.READ_ONLY, description = "text_description", example = "text_example")
  private String readonlyRequiredAndDescriptionAndExample;

  public MicroprofileAnnotations withDescription(String withDescription) {
    this.withDescription = withDescription;
    return this;
  }

  /**
   * openapi property description
   * @return withDescription
   **/
  public String getWithDescription() {
    return withDescription;
  }

  public void setWithDescription(String withDescription) {
    this.withDescription = withDescription;
  }

  public MicroprofileAnnotations withExample(String withExample) {
    this.withExample = withExample;
    return this;
  }

  /**
   * Get withExample
   * @return withExample
   **/
  public String getWithExample() {
    return withExample;
  }

  public void setWithExample(String withExample) {
    this.withExample = withExample;
  }

  public MicroprofileAnnotations isRequired(String isRequired) {
    this.isRequired = Objects.requireNonNull(isRequired, "Property isRequired is required, cannot be null");
    return this;
  }

  /**
   * Get isRequired
   * @return isRequired
   **/
  @NotNull
  public String getIsRequired() {
    return isRequired;
  }

  public void setIsRequired(String isRequired) {
    this.isRequired = Objects.requireNonNull(isRequired, "Property isRequired is required, cannot be null");
  }

  public MicroprofileAnnotations requiredAndDescriptionAndExample(String requiredAndDescriptionAndExample) {
    this.requiredAndDescriptionAndExample = Objects.requireNonNull(requiredAndDescriptionAndExample, "Property requiredAndDescriptionAndExample is required, cannot be null");
    return this;
  }

  /**
   * text_description
   * @return requiredAndDescriptionAndExample
   **/
  @NotNull
  public String getRequiredAndDescriptionAndExample() {
    return requiredAndDescriptionAndExample;
  }

  public void setRequiredAndDescriptionAndExample(String requiredAndDescriptionAndExample) {
    this.requiredAndDescriptionAndExample = Objects.requireNonNull(requiredAndDescriptionAndExample, "Property requiredAndDescriptionAndExample is required, cannot be null");
  }

  public MicroprofileAnnotations requiredAndExample(String requiredAndExample) {
    this.requiredAndExample = Objects.requireNonNull(requiredAndExample, "Property requiredAndExample is required, cannot be null");
    return this;
  }

  /**
   * Get requiredAndExample
   * @return requiredAndExample
   **/
  @NotNull
  public String getRequiredAndExample() {
    return requiredAndExample;
  }

  public void setRequiredAndExample(String requiredAndExample) {
    this.requiredAndExample = Objects.requireNonNull(requiredAndExample, "Property requiredAndExample is required, cannot be null");
  }

  public MicroprofileAnnotations requiredAndDescription(String requiredAndDescription) {
    this.requiredAndDescription = Objects.requireNonNull(requiredAndDescription, "Property requiredAndDescription is required, cannot be null");
    return this;
  }

  /**
   * text_description
   * @return requiredAndDescription
   **/
  @NotNull
  public String getRequiredAndDescription() {
    return requiredAndDescription;
  }

  public void setRequiredAndDescription(String requiredAndDescription) {
    this.requiredAndDescription = Objects.requireNonNull(requiredAndDescription, "Property requiredAndDescription is required, cannot be null");
  }

  public MicroprofileAnnotations descriptionAndExample(String descriptionAndExample) {
    this.descriptionAndExample = descriptionAndExample;
    return this;
  }

  /**
   * text_description
   * @return descriptionAndExample
   **/
  public String getDescriptionAndExample() {
    return descriptionAndExample;
  }

  public void setDescriptionAndExample(String descriptionAndExample) {
    this.descriptionAndExample = descriptionAndExample;
  }

  public MicroprofileAnnotations isReadonly(String isReadonly) {
    this.isReadonly = isReadonly;
    return this;
  }

  /**
   * Get isReadonly
   * @return isReadonly
   **/
  public String getIsReadonly() {
    return isReadonly;
  }

  public void setIsReadonly(String isReadonly) {
    this.isReadonly = isReadonly;
  }

  public MicroprofileAnnotations readonlyRequiredAndDescriptionAndExample(String readonlyRequiredAndDescriptionAndExample) {
    this.readonlyRequiredAndDescriptionAndExample = Objects.requireNonNull(readonlyRequiredAndDescriptionAndExample, "Property readonlyRequiredAndDescriptionAndExample is required, cannot be null");
    return this;
  }

  /**
   * text_description
   * @return readonlyRequiredAndDescriptionAndExample
   **/
  @NotNull
  public String getReadonlyRequiredAndDescriptionAndExample() {
    return readonlyRequiredAndDescriptionAndExample;
  }

  public void setReadonlyRequiredAndDescriptionAndExample(String readonlyRequiredAndDescriptionAndExample) {
    this.readonlyRequiredAndDescriptionAndExample = Objects.requireNonNull(readonlyRequiredAndDescriptionAndExample, "Property readonlyRequiredAndDescriptionAndExample is required, cannot be null");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MicroprofileAnnotations other = (MicroprofileAnnotations) o;
    return Objects.equals(this.withDescription, other.withDescription) &&
        Objects.equals(this.withExample, other.withExample) &&
        Objects.equals(this.isRequired, other.isRequired) &&
        Objects.equals(this.requiredAndDescriptionAndExample, other.requiredAndDescriptionAndExample) &&
        Objects.equals(this.requiredAndExample, other.requiredAndExample) &&
        Objects.equals(this.requiredAndDescription, other.requiredAndDescription) &&
        Objects.equals(this.descriptionAndExample, other.descriptionAndExample) &&
        Objects.equals(this.isReadonly, other.isReadonly) &&
        Objects.equals(this.readonlyRequiredAndDescriptionAndExample, other.readonlyRequiredAndDescriptionAndExample);
  }

  @Override
  public int hashCode() {
    return Objects.hash(withDescription, withExample, isRequired, requiredAndDescriptionAndExample, requiredAndExample, requiredAndDescription, descriptionAndExample, isReadonly, readonlyRequiredAndDescriptionAndExample);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MicroprofileAnnotations {");
    sb.append("\n    withDescription: ").append(toIndentedString(withDescription));
    sb.append("\n    withExample: ").append(toIndentedString(withExample));
    sb.append("\n    isRequired: ").append(toIndentedString(isRequired));
    sb.append("\n    requiredAndDescriptionAndExample: ").append(toIndentedString(requiredAndDescriptionAndExample));
    sb.append("\n    requiredAndExample: ").append(toIndentedString(requiredAndExample));
    sb.append("\n    requiredAndDescription: ").append(toIndentedString(requiredAndDescription));
    sb.append("\n    descriptionAndExample: ").append(toIndentedString(descriptionAndExample));
    sb.append("\n    isReadonly: ").append(toIndentedString(isReadonly));
    sb.append("\n    readonlyRequiredAndDescriptionAndExample: ").append(toIndentedString(readonlyRequiredAndDescriptionAndExample));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
