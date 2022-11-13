/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.opts.generator.property_order.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * ValidationDto
 */
@JsonbPropertyOrder({
  ValidationDto.JSON_PROPERTY_NAME,
  ValidationDto.JSON_PROPERTY_INT_VALUE,
  ValidationDto.JSON_PROPERTY_BAD_PARSING_OF_RANGE,
  ValidationDto.JSON_PROPERTY_A_BIG_DOUBLE,
  ValidationDto.JSON_PROPERTY_A_BIG_FLOAT,
  ValidationDto.JSON_PROPERTY_A_BIG_DECIMAL,
  ValidationDto.JSON_PROPERTY_PATTERN,
  ValidationDto.JSON_PROPERTY_PATTERN_DIGITS,
  ValidationDto.JSON_PROPERTY_VALID_OBJECTS,
  ValidationDto.JSON_PROPERTY_PRIMITIVES_SHOULD_NOT_HAVE_VALIDATE
})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ValidationDto {
  public static final String JSON_PROPERTY_NAME = "name";
  @JsonbProperty(JSON_PROPERTY_NAME)
  @Schema(required = true)
  private String name;

  public static final String JSON_PROPERTY_INT_VALUE = "intValue";
  @JsonbProperty(JSON_PROPERTY_INT_VALUE)
  private Integer intValue;

  public static final String JSON_PROPERTY_BAD_PARSING_OF_RANGE = "badParsingOfRange";
  @JsonbProperty(JSON_PROPERTY_BAD_PARSING_OF_RANGE)
  private Integer badParsingOfRange;

  public static final String JSON_PROPERTY_A_BIG_DOUBLE = "aBigDouble";
  @JsonbProperty(JSON_PROPERTY_A_BIG_DOUBLE)
  @Schema(description = "With a \"quoted\" description")
  private Double aBigDouble;

  public static final String JSON_PROPERTY_A_BIG_FLOAT = "aBigFloat";
  @JsonbProperty(JSON_PROPERTY_A_BIG_FLOAT)
  @Schema(description = "a float")
  private Float aBigFloat;

  public static final String JSON_PROPERTY_A_BIG_DECIMAL = "aBigDecimal";
  @JsonbProperty(JSON_PROPERTY_A_BIG_DECIMAL)
  @Schema(description = "a BigDecimal")
  private BigDecimal aBigDecimal;

  public static final String JSON_PROPERTY_PATTERN = "pattern";
  @JsonbProperty(JSON_PROPERTY_PATTERN)
  private String pattern;

  public static final String JSON_PROPERTY_PATTERN_DIGITS = "patternDigits";
  @JsonbProperty(JSON_PROPERTY_PATTERN_DIGITS)
  private String patternDigits;

  public static final String JSON_PROPERTY_VALID_OBJECTS = "validObjects";
  @JsonbProperty(JSON_PROPERTY_VALID_OBJECTS)
  private List<Environment> validObjects;

  public static final String JSON_PROPERTY_PRIMITIVES_SHOULD_NOT_HAVE_VALIDATE = "primitivesShouldNotHaveValidate";
  @JsonbProperty(JSON_PROPERTY_PRIMITIVES_SHOULD_NOT_HAVE_VALIDATE)
  private List<Boolean> primitivesShouldNotHaveValidate;

  public ValidationDto name(String name) {
    this.name = Objects.requireNonNull(name, "Property name is required, cannot be null");
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @NotNull @Size(min = 1, max = 50)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = Objects.requireNonNull(name, "Property name is required, cannot be null");
  }

  public ValidationDto intValue(Integer intValue) {
    this.intValue = intValue;
    return this;
  }

  /**
   * Get intValue
   * minimum: 10
   * maximum: 20
   * @return intValue
   **/
  @Min(10) @Max(20)
  public Integer getIntValue() {
    return intValue;
  }

  public void setIntValue(Integer intValue) {
    this.intValue = intValue;
  }

  public ValidationDto badParsingOfRange(Integer badParsingOfRange) {
    this.badParsingOfRange = badParsingOfRange;
    return this;
  }

  /**
   * Get badParsingOfRange
   * minimum: 100
   * maximum: 999
   * @return badParsingOfRange
   **/
  @Min(100) @Max(999)
  public Integer getBadParsingOfRange() {
    return badParsingOfRange;
  }

  public void setBadParsingOfRange(Integer badParsingOfRange) {
    this.badParsingOfRange = badParsingOfRange;
  }

  public ValidationDto aBigDouble(Double aBigDouble) {
    this.aBigDouble = aBigDouble;
    return this;
  }

  /**
   * With a &quot;quoted&quot; description.
   * minimum: 0
   * maximum: 99999999
   *
   * @return aBigDouble
   **/
  @Min(0) @Max(99999999)
  public Double getaBigDouble() {
    return aBigDouble;
  }

  public void setaBigDouble(Double aBigDouble) {
    this.aBigDouble = aBigDouble;
  }

  public ValidationDto aBigFloat(Float aBigFloat) {
    this.aBigFloat = aBigFloat;
    return this;
  }

  /**
   * a float.
   * minimum: 0
   * maximum: 1000
   *
   * @return aBigFloat
   **/
  @Min(0) @Max(1000)
  public Float getaBigFloat() {
    return aBigFloat;
  }

  public void setaBigFloat(Float aBigFloat) {
    this.aBigFloat = aBigFloat;
  }

  public ValidationDto aBigDecimal(BigDecimal aBigDecimal) {
    this.aBigDecimal = aBigDecimal;
    return this;
  }

  /**
   * a BigDecimal.
   * minimum: "100"
   * maximum: "1000"
   *
   * @return aBigDecimal
   **/
  @DecimalMin("100") @DecimalMax("1000")
  public BigDecimal getaBigDecimal() {
    return aBigDecimal;
  }

  public void setaBigDecimal(BigDecimal aBigDecimal) {
    this.aBigDecimal = aBigDecimal;
  }

  public ValidationDto pattern(String pattern) {
    this.pattern = pattern;
    return this;
  }

  /**
   * Get pattern
   * @return pattern
   **/
  @Pattern(regexp = "^[a-zA-Z]{0,3}$")
  public String getPattern() {
    return pattern;
  }

  public void setPattern(String pattern) {
    this.pattern = pattern;
  }

  public ValidationDto patternDigits(String patternDigits) {
    this.patternDigits = patternDigits;
    return this;
  }

  /**
   * Get patternDigits
   * @return patternDigits
   **/
  @Pattern(regexp = "^\\d{1,2}$")
  public String getPatternDigits() {
    return patternDigits;
  }

  public void setPatternDigits(String patternDigits) {
    this.patternDigits = patternDigits;
  }

  public ValidationDto validObjects(List<Environment> validObjects) {
    this.validObjects = validObjects;
    return this;
  }

  public ValidationDto addValidObjectsItem(Environment validObjectsItem) {
    if (this.validObjects == null) {
      this.validObjects = new ArrayList<>();
    }
    this.validObjects.add(validObjectsItem);
    return this;
  }

  /**
   * Get validObjects
   * @return validObjects
   **/
  @Valid @Size(min = 1, max = 4)
  public List<Environment> getValidObjects() {
    return validObjects;
  }

  public void setValidObjects(List<Environment> validObjects) {
    this.validObjects = validObjects;
  }

  public ValidationDto primitivesShouldNotHaveValidate(List<Boolean> primitivesShouldNotHaveValidate) {
    this.primitivesShouldNotHaveValidate = primitivesShouldNotHaveValidate;
    return this;
  }

  public ValidationDto addPrimitivesShouldNotHaveValidateItem(boolean primitivesShouldNotHaveValidateItem) {
    if (this.primitivesShouldNotHaveValidate == null) {
      this.primitivesShouldNotHaveValidate = new ArrayList<>();
    }
    this.primitivesShouldNotHaveValidate.add(primitivesShouldNotHaveValidateItem);
    return this;
  }

  /**
   * Get primitivesShouldNotHaveValidate
   * @return primitivesShouldNotHaveValidate
   **/
  public List<Boolean> getPrimitivesShouldNotHaveValidate() {
    return primitivesShouldNotHaveValidate;
  }

  public void setPrimitivesShouldNotHaveValidate(List<Boolean> primitivesShouldNotHaveValidate) {
    this.primitivesShouldNotHaveValidate = primitivesShouldNotHaveValidate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ValidationDto)) {
      return false;
    }
    ValidationDto other = (ValidationDto) o;
    return Objects.equals(this.name, other.name) &&
        Objects.equals(this.intValue, other.intValue) &&
        Objects.equals(this.badParsingOfRange, other.badParsingOfRange) &&
        Objects.equals(this.aBigDouble, other.aBigDouble) &&
        Objects.equals(this.aBigFloat, other.aBigFloat) &&
        Objects.equals(this.aBigDecimal, other.aBigDecimal) &&
        Objects.equals(this.pattern, other.pattern) &&
        Objects.equals(this.patternDigits, other.patternDigits) &&
        Objects.equals(this.validObjects, other.validObjects) &&
        Objects.equals(this.primitivesShouldNotHaveValidate, other.primitivesShouldNotHaveValidate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, intValue, badParsingOfRange, aBigDouble, aBigFloat, aBigDecimal, pattern, patternDigits, validObjects, primitivesShouldNotHaveValidate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValidationDto {");
    sb.append("\n    name: ").append(toIndentedString(name));
    sb.append("\n    intValue: ").append(toIndentedString(intValue));
    sb.append("\n    badParsingOfRange: ").append(toIndentedString(badParsingOfRange));
    sb.append("\n    aBigDouble: ").append(toIndentedString(aBigDouble));
    sb.append("\n    aBigFloat: ").append(toIndentedString(aBigFloat));
    sb.append("\n    aBigDecimal: ").append(toIndentedString(aBigDecimal));
    sb.append("\n    pattern: ").append(toIndentedString(pattern));
    sb.append("\n    patternDigits: ").append(toIndentedString(patternDigits));
    sb.append("\n    validObjects: ").append(toIndentedString(validObjects));
    sb.append("\n    primitivesShouldNotHaveValidate: ").append(toIndentedString(primitivesShouldNotHaveValidate));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
