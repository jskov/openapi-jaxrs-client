/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.dto.serializer.jsonb.dto;

import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;

/**
 * SerializerInfoDto
 */
@JsonbPropertyOrder({
  SerializerInfoDto.JSON_PROPERTY_BETA,
  SerializerInfoDto.JSON_PROPERTY_ALPHA,
  SerializerInfoDto.JSON_PROPERTY_ZAP_RENAMED,
  SerializerInfoDto.JSON_PROPERTY_UPPER_CASE,
  SerializerInfoDto.JSON_PROPERTY_WITH_DASHES,
  SerializerInfoDto.JSON_PROPERTY_WITH_DIGIT,
  SerializerInfoDto.JSON_PROPERTY_MUST_INCLUDE,
  SerializerInfoDto.JSON_PROPERTY_MP_ANNOTATIONS,
  SerializerInfoDto.JSON_PROPERTY_MP_ANNOTATIONS_PROPS_ONLY
})
@javax.annotation.Generated(value = "dk.mada.jaxrs.generator.DtoGenerator")
public class SerializerInfoDto   {
  public static final String JSON_PROPERTY_BETA = "beta";
  @JsonbProperty(JSON_PROPERTY_BETA)
  private String beta;

  public static final String JSON_PROPERTY_ALPHA = "alpha";
  @JsonbProperty(JSON_PROPERTY_ALPHA)
  private String alpha;

  public static final String JSON_PROPERTY_ZAP_RENAMED = "zapRenamed";
  @JsonbProperty(JSON_PROPERTY_ZAP_RENAMED)
  private String zapRenamed;

  public static final String JSON_PROPERTY_UPPER_CASE = "UpperCase";
  @JsonbProperty(JSON_PROPERTY_UPPER_CASE)
  private String upperCase;

  public static final String JSON_PROPERTY_WITH_DASHES = "with-Dashes-";
  @JsonbProperty(JSON_PROPERTY_WITH_DASHES)
  private String withDashes;

  public static final String JSON_PROPERTY_WITH_DIGIT = "0withDigit";
  @JsonbProperty(JSON_PROPERTY_WITH_DIGIT)
  private String _withDigit;

  public static final String JSON_PROPERTY_MUST_INCLUDE = "mustInclude";
  @JsonbProperty(JSON_PROPERTY_MUST_INCLUDE)
  private String mustInclude;

  public static final String JSON_PROPERTY_MP_ANNOTATIONS = "mpAnnotations";
  @JsonbProperty(JSON_PROPERTY_MP_ANNOTATIONS)
  private MicroprofileAnnotations mpAnnotations;

  public static final String JSON_PROPERTY_MP_ANNOTATIONS_PROPS_ONLY = "mpAnnotationsPropsOnly";
  @JsonbProperty(JSON_PROPERTY_MP_ANNOTATIONS_PROPS_ONLY)
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
  @ApiModelProperty(required = true, value = "")
  public String getMustInclude() {
    return mustInclude;
  }

  public void setMustInclude(String mustInclude) {
    this.mustInclude = Objects.requireNonNull(mustInclude, "Property mustInclude is required, cannot be null");
  }

  public SerializerInfoDto mpAnnotations(MicroprofileAnnotations mpAnnotations) {
    this.mpAnnotations = mpAnnotations;
    return this;
  }

  /**
   * Get mpAnnotations
   * @return mpAnnotations
   **/
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
        Objects.equals(this.mpAnnotations, other.mpAnnotations) &&
        Objects.equals(this.mpAnnotationsPropsOnly, other.mpAnnotationsPropsOnly);
  }

  @Override
  public int hashCode() {
    return Objects.hash(beta, alpha, zapRenamed, upperCase, withDashes, _withDigit, mustInclude, mpAnnotations, mpAnnotationsPropsOnly);
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
    sb.append("\n    mpAnnotations: ").append(toIndentedString(mpAnnotations));
    sb.append("\n    mpAnnotationsPropsOnly: ").append(toIndentedString(mpAnnotationsPropsOnly));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
