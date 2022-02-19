/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.dto.serializer.jackson_fasterxml.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * SerializerInfoDto
 */
@JsonPropertyOrder({
  SerializerInfoDto.JSON_PROPERTY_BETA,
  SerializerInfoDto.JSON_PROPERTY_ALPHA,
  SerializerInfoDto.JSON_PROPERTY_ZAP_RENAMED,
  SerializerInfoDto.JSON_PROPERTY_UPPER_CASE,
  SerializerInfoDto.JSON_PROPERTY_WITH_DASHES,
  SerializerInfoDto.JSON_PROPERTY_WITH_DIGIT,
  SerializerInfoDto.JSON_PROPERTY_MUST_INCLUDE,
  SerializerInfoDto.JSON_PROPERTY_MUST_INCLUDE_VIA_SCHEMA,
  SerializerInfoDto.JSON_PROPERTY_NOT_NULL,
  SerializerInfoDto.JSON_PROPERTY_NOT_NULL_VIA_SCHEMA,
  SerializerInfoDto.JSON_PROPERTY_IS_NULLABLE,
  SerializerInfoDto.JSON_PROPERTY_IS_NULLABLE_VIA_SCHEMA,
  SerializerInfoDto.JSON_PROPERTY_MP_ANNOTATIONS,
  SerializerInfoDto.JSON_PROPERTY_MP_ANNOTATIONS_PROPS_ONLY
})
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public class SerializerInfoDto   {
  public static final String JSON_PROPERTY_BETA = "beta";
  @JsonProperty(JSON_PROPERTY_BETA)
  private String beta;

  public static final String JSON_PROPERTY_ALPHA = "alpha";
  @JsonProperty(JSON_PROPERTY_ALPHA)
  private String alpha;

  public static final String JSON_PROPERTY_ZAP_RENAMED = "zapRenamed";
  @JsonProperty(JSON_PROPERTY_ZAP_RENAMED)
  private String zapRenamed;

  public static final String JSON_PROPERTY_UPPER_CASE = "UpperCase";
  @JsonProperty(JSON_PROPERTY_UPPER_CASE)
  private String upperCase;

  public static final String JSON_PROPERTY_WITH_DASHES = "with-Dashes-";
  @JsonProperty(JSON_PROPERTY_WITH_DASHES)
  private String withDashes;

  public static final String JSON_PROPERTY_WITH_DIGIT = "0withDigit";
  @JsonProperty(JSON_PROPERTY_WITH_DIGIT)
  private String _withDigit;

  public static final String JSON_PROPERTY_MUST_INCLUDE = "mustInclude";
  @JsonProperty(JSON_PROPERTY_MUST_INCLUDE)
  @Schema(required = true)
  private String mustInclude;

  public static final String JSON_PROPERTY_MUST_INCLUDE_VIA_SCHEMA = "mustIncludeViaSchema";
  @JsonProperty(JSON_PROPERTY_MUST_INCLUDE_VIA_SCHEMA)
  @Schema(required = true)
  private String mustIncludeViaSchema;

  public static final String JSON_PROPERTY_NOT_NULL = "notNull";
  @JsonProperty(JSON_PROPERTY_NOT_NULL)
  @Schema(required = true)
  private String notNull;

  public static final String JSON_PROPERTY_NOT_NULL_VIA_SCHEMA = "notNullViaSchema";
  @JsonProperty(JSON_PROPERTY_NOT_NULL_VIA_SCHEMA)
  private String notNullViaSchema;

  public static final String JSON_PROPERTY_IS_NULLABLE = "isNullable";
  @JsonProperty(JSON_PROPERTY_IS_NULLABLE)
  private String isNullable;

  public static final String JSON_PROPERTY_IS_NULLABLE_VIA_SCHEMA = "isNullableViaSchema";
  @JsonProperty(JSON_PROPERTY_IS_NULLABLE_VIA_SCHEMA)
  @Schema(nullable = true)
  private String isNullableViaSchema;

  public static final String JSON_PROPERTY_MP_ANNOTATIONS = "mpAnnotations";
  @JsonProperty(JSON_PROPERTY_MP_ANNOTATIONS)
  private MicroprofileAnnotations mpAnnotations;

  public static final String JSON_PROPERTY_MP_ANNOTATIONS_PROPS_ONLY = "mpAnnotationsPropsOnly";
  @JsonProperty(JSON_PROPERTY_MP_ANNOTATIONS_PROPS_ONLY)
  private MicroProfileAnnotationsPropsOnly mpAnnotationsPropsOnly;

  public SerializerInfoDto beta(String beta) {
    this.beta = beta;
    return this;
  }

  /**
   * Get beta
   * @return beta
   **/
  public String getBeta() {
    return beta;
  }

  public void setBeta(String beta) {
    this.beta = beta;
  }

  public SerializerInfoDto alpha(String alpha) {
    this.alpha = alpha;
    return this;
  }

  /**
   * Get alpha
   * @return alpha
   **/
  public String getAlpha() {
    return alpha;
  }

  public void setAlpha(String alpha) {
    this.alpha = alpha;
  }

  public SerializerInfoDto zapRenamed(String zapRenamed) {
    this.zapRenamed = zapRenamed;
    return this;
  }

  /**
   * Get zapRenamed
   * @return zapRenamed
   **/
  public String getZapRenamed() {
    return zapRenamed;
  }

  public void setZapRenamed(String zapRenamed) {
    this.zapRenamed = zapRenamed;
  }

  public SerializerInfoDto upperCase(String upperCase) {
    this.upperCase = upperCase;
    return this;
  }

  /**
   * Get upperCase
   * @return upperCase
   **/
  public String getUpperCase() {
    return upperCase;
  }

  public void setUpperCase(String upperCase) {
    this.upperCase = upperCase;
  }

  public SerializerInfoDto withDashes(String withDashes) {
    this.withDashes = withDashes;
    return this;
  }

  /**
   * Get withDashes
   * @return withDashes
   **/
  public String getWithDashes() {
    return withDashes;
  }

  public void setWithDashes(String withDashes) {
    this.withDashes = withDashes;
  }

  public SerializerInfoDto _withDigit(String _withDigit) {
    this._withDigit = _withDigit;
    return this;
  }

  /**
   * Get _withDigit
   * @return _withDigit
   **/
  public String getWithDigit() {
    return _withDigit;
  }

  public void setWithDigit(String _withDigit) {
    this._withDigit = _withDigit;
  }

  public SerializerInfoDto mustInclude(String mustInclude) {
    this.mustInclude = Objects.requireNonNull(mustInclude, "Property mustInclude is required, cannot be null");
    return this;
  }

  /**
   * Get mustInclude
   * @return mustInclude
   **/
  @NotNull
  public String getMustInclude() {
    return mustInclude;
  }

  public void setMustInclude(String mustInclude) {
    this.mustInclude = Objects.requireNonNull(mustInclude, "Property mustInclude is required, cannot be null");
  }

  public SerializerInfoDto mustIncludeViaSchema(String mustIncludeViaSchema) {
    this.mustIncludeViaSchema = Objects.requireNonNull(mustIncludeViaSchema, "Property mustIncludeViaSchema is required, cannot be null");
    return this;
  }

  /**
   * Get mustIncludeViaSchema
   * @return mustIncludeViaSchema
   **/
  @NotNull
  public String getMustIncludeViaSchema() {
    return mustIncludeViaSchema;
  }

  public void setMustIncludeViaSchema(String mustIncludeViaSchema) {
    this.mustIncludeViaSchema = Objects.requireNonNull(mustIncludeViaSchema, "Property mustIncludeViaSchema is required, cannot be null");
  }

  public SerializerInfoDto notNull(String notNull) {
    this.notNull = Objects.requireNonNull(notNull, "Property notNull is required, cannot be null");
    return this;
  }

  /**
   * Get notNull
   * @return notNull
   **/
  @NotNull
  public String getNotNull() {
    return notNull;
  }

  public void setNotNull(String notNull) {
    this.notNull = Objects.requireNonNull(notNull, "Property notNull is required, cannot be null");
  }

  public SerializerInfoDto notNullViaSchema(String notNullViaSchema) {
    this.notNullViaSchema = notNullViaSchema;
    return this;
  }

  /**
   * Get notNullViaSchema
   * @return notNullViaSchema
   **/
  public String getNotNullViaSchema() {
    return notNullViaSchema;
  }

  public void setNotNullViaSchema(String notNullViaSchema) {
    this.notNullViaSchema = notNullViaSchema;
  }

  public SerializerInfoDto isNullable(String isNullable) {
    this.isNullable = isNullable;
    return this;
  }

  /**
   * Get isNullable
   * @return isNullable
   **/
  public String getIsNullable() {
    return isNullable;
  }

  public void setIsNullable(String isNullable) {
    this.isNullable = isNullable;
  }

  public SerializerInfoDto isNullableViaSchema(String isNullableViaSchema) {
    this.isNullableViaSchema = isNullableViaSchema;
    return this;
  }

  /**
   * Get isNullableViaSchema
   * @return isNullableViaSchema
   **/
  public String getIsNullableViaSchema() {
    return isNullableViaSchema;
  }

  public void setIsNullableViaSchema(String isNullableViaSchema) {
    this.isNullableViaSchema = isNullableViaSchema;
  }

  public SerializerInfoDto mpAnnotations(MicroprofileAnnotations mpAnnotations) {
    this.mpAnnotations = mpAnnotations;
    return this;
  }

  /**
   * Get mpAnnotations
   * @return mpAnnotations
   **/
  @Valid
  public MicroprofileAnnotations getMpAnnotations() {
    return mpAnnotations;
  }

  public void setMpAnnotations(MicroprofileAnnotations mpAnnotations) {
    this.mpAnnotations = mpAnnotations;
  }

  public SerializerInfoDto mpAnnotationsPropsOnly(MicroProfileAnnotationsPropsOnly mpAnnotationsPropsOnly) {
    this.mpAnnotationsPropsOnly = mpAnnotationsPropsOnly;
    return this;
  }

  /**
   * Get mpAnnotationsPropsOnly
   * @return mpAnnotationsPropsOnly
   **/
  @Valid
  public MicroProfileAnnotationsPropsOnly getMpAnnotationsPropsOnly() {
    return mpAnnotationsPropsOnly;
  }

  public void setMpAnnotationsPropsOnly(MicroProfileAnnotationsPropsOnly mpAnnotationsPropsOnly) {
    this.mpAnnotationsPropsOnly = mpAnnotationsPropsOnly;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SerializerInfoDto other = (SerializerInfoDto) o;
    return Objects.equals(this.beta, other.beta) &&
        Objects.equals(this.alpha, other.alpha) &&
        Objects.equals(this.zapRenamed, other.zapRenamed) &&
        Objects.equals(this.upperCase, other.upperCase) &&
        Objects.equals(this.withDashes, other.withDashes) &&
        Objects.equals(this._withDigit, other._withDigit) &&
        Objects.equals(this.mustInclude, other.mustInclude) &&
        Objects.equals(this.mustIncludeViaSchema, other.mustIncludeViaSchema) &&
        Objects.equals(this.notNull, other.notNull) &&
        Objects.equals(this.notNullViaSchema, other.notNullViaSchema) &&
        Objects.equals(this.isNullable, other.isNullable) &&
        Objects.equals(this.isNullableViaSchema, other.isNullableViaSchema) &&
        Objects.equals(this.mpAnnotations, other.mpAnnotations) &&
        Objects.equals(this.mpAnnotationsPropsOnly, other.mpAnnotationsPropsOnly);
  }

  @Override
  public int hashCode() {
    return Objects.hash(beta, alpha, zapRenamed, upperCase, withDashes, _withDigit, mustInclude, mustIncludeViaSchema, notNull, notNullViaSchema, isNullable, isNullableViaSchema, mpAnnotations, mpAnnotationsPropsOnly);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SerializerInfoDto {");
    sb.append("\n    beta: ").append(toIndentedString(beta));
    sb.append("\n    alpha: ").append(toIndentedString(alpha));
    sb.append("\n    zapRenamed: ").append(toIndentedString(zapRenamed));
    sb.append("\n    upperCase: ").append(toIndentedString(upperCase));
    sb.append("\n    withDashes: ").append(toIndentedString(withDashes));
    sb.append("\n    _withDigit: ").append(toIndentedString(_withDigit));
    sb.append("\n    mustInclude: ").append(toIndentedString(mustInclude));
    sb.append("\n    mustIncludeViaSchema: ").append(toIndentedString(mustIncludeViaSchema));
    sb.append("\n    notNull: ").append(toIndentedString(notNull));
    sb.append("\n    notNullViaSchema: ").append(toIndentedString(notNullViaSchema));
    sb.append("\n    isNullable: ").append(toIndentedString(isNullable));
    sb.append("\n    isNullableViaSchema: ").append(toIndentedString(isNullableViaSchema));
    sb.append("\n    mpAnnotations: ").append(toIndentedString(mpAnnotations));
    sb.append("\n    mpAnnotationsPropsOnly: ").append(toIndentedString(mpAnnotationsPropsOnly));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
