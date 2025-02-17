/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.specs.v3_1.all.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * ValidationDto
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ValidationDto {
  public static final String JSON_PROPERTY_A_BIG_DECIMAL = "aBigDecimal";
  @JsonbProperty(JSON_PROPERTY_A_BIG_DECIMAL)
  @Schema(description = "a BigDecimal")
  private BigDecimal aBigDecimal;

  public static final String JSON_PROPERTY_A_BIG_DOUBLE = "aBigDouble";
  @JsonbProperty(JSON_PROPERTY_A_BIG_DOUBLE)
  @Schema(description = "With a \"quoted\" description")
  private Double aBigDouble;

  public static final String JSON_PROPERTY_A_BIG_FLOAT = "aBigFloat";
  @JsonbProperty(JSON_PROPERTY_A_BIG_FLOAT)
  @Schema(description = "a float")
  private Float aBigFloat;

  public static final String JSON_PROPERTY_BAD_PARSING_OF_RANGE = "badParsingOfRange";
  @JsonbProperty(JSON_PROPERTY_BAD_PARSING_OF_RANGE)
  private Integer badParsingOfRange;

  public static final String JSON_PROPERTY_INT_VALUE = "intValue";
  @JsonbProperty(JSON_PROPERTY_INT_VALUE)
  private Integer intValue;

  public static final String JSON_PROPERTY_NAME = "name";
  @JsonbProperty(JSON_PROPERTY_NAME)
  @Schema(required = true)
  private String name;

  public static final String JSON_PROPERTY_NEGATIVE_BIG_DECIMAL = "negativeBigDecimal";
  @JsonbProperty(JSON_PROPERTY_NEGATIVE_BIG_DECIMAL)
  private BigDecimal negativeBigDecimal;

  public static final String JSON_PROPERTY_NEGATIVE_INT = "negativeInt";
  @JsonbProperty(JSON_PROPERTY_NEGATIVE_INT)
  private Integer negativeInt;

  public static final String JSON_PROPERTY_NEGATIVE_OR_ZERO_BIG_DECIMAL = "negativeOrZeroBigDecimal";
  @JsonbProperty(JSON_PROPERTY_NEGATIVE_OR_ZERO_BIG_DECIMAL)
  private BigDecimal negativeOrZeroBigDecimal;

  public static final String JSON_PROPERTY_NEGATIVE_OR_ZERO_INT = "negativeOrZeroInt";
  @JsonbProperty(JSON_PROPERTY_NEGATIVE_OR_ZERO_INT)
  private Integer negativeOrZeroInt;

  public static final String JSON_PROPERTY_NOT_BLANK_STRING = "notBlankString";
  @JsonbProperty(JSON_PROPERTY_NOT_BLANK_STRING)
  @Schema(required = true)
  private String notBlankString;

  public static final String JSON_PROPERTY_NOT_EMPTY_ARRAY = "notEmptyArray";
  @JsonbProperty(JSON_PROPERTY_NOT_EMPTY_ARRAY)
  @Schema(required = true)
  private List<String> notEmptyArray = new ArrayList<>();

  public static final String JSON_PROPERTY_NOT_EMPTY_DTO = "notEmptyDto";
  @JsonbProperty(JSON_PROPERTY_NOT_EMPTY_DTO)
  private Simple notEmptyDto;

  public static final String JSON_PROPERTY_NOT_EMPTY_STRING = "notEmptyString";
  @JsonbProperty(JSON_PROPERTY_NOT_EMPTY_STRING)
  @Schema(required = true)
  private String notEmptyString;

  public static final String JSON_PROPERTY_PATTERN = "pattern";
  @JsonbProperty(JSON_PROPERTY_PATTERN)
  private String pattern;

  public static final String JSON_PROPERTY_PATTERN_DIGITS = "patternDigits";
  @JsonbProperty(JSON_PROPERTY_PATTERN_DIGITS)
  private String patternDigits;

  public static final String JSON_PROPERTY_POSITIVE_BIG_DECIMAL = "positiveBigDecimal";
  @JsonbProperty(JSON_PROPERTY_POSITIVE_BIG_DECIMAL)
  private BigDecimal positiveBigDecimal;

  public static final String JSON_PROPERTY_POSITIVE_INT = "positiveInt";
  @JsonbProperty(JSON_PROPERTY_POSITIVE_INT)
  private Integer positiveInt;

  public static final String JSON_PROPERTY_POSITIVE_OR_ZERO_BIG_DECIMAL = "positiveOrZeroBigDecimal";
  @JsonbProperty(JSON_PROPERTY_POSITIVE_OR_ZERO_BIG_DECIMAL)
  private BigDecimal positiveOrZeroBigDecimal;

  public static final String JSON_PROPERTY_POSITIVE_OR_ZERO_INT = "positiveOrZeroInt";
  @JsonbProperty(JSON_PROPERTY_POSITIVE_OR_ZERO_INT)
  private Integer positiveOrZeroInt;

  public static final String JSON_PROPERTY_PRIMITIVES_SHOULD_NOT_HAVE_VALIDATE = "primitivesShouldNotHaveValidate";
  @JsonbProperty(JSON_PROPERTY_PRIMITIVES_SHOULD_NOT_HAVE_VALIDATE)
  private List<Boolean> primitivesShouldNotHaveValidate;

  public static final String JSON_PROPERTY_SIZED_ARRAY = "sizedArray";
  @JsonbProperty(JSON_PROPERTY_SIZED_ARRAY)
  private List<String> sizedArray;

  public static final String JSON_PROPERTY_SIZED_OBJECT = "sizedObject";
  @JsonbProperty(JSON_PROPERTY_SIZED_OBJECT)
  private Simple sizedObject;

  public static final String JSON_PROPERTY_SIZED_STRING = "sizedString";
  @JsonbProperty(JSON_PROPERTY_SIZED_STRING)
  private String sizedString;

  public static final String JSON_PROPERTY_VALID_OBJECTS = "validObjects";
  @JsonbProperty(JSON_PROPERTY_VALID_OBJECTS)
  private List<Environment> validObjects;

  public static final String JSON_PROPERTY_VERY_BIG_LONG = "veryBigLong";
  @JsonbProperty(JSON_PROPERTY_VERY_BIG_LONG)
  private Long veryBigLong;

  public ValidationDto aBigDecimal(BigDecimal aBigDecimal) {
    this.aBigDecimal = aBigDecimal;
    return this;
  }

  /**
   * a BigDecimal.
   *
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

  public ValidationDto aBigDouble(Double aBigDouble) {
    this.aBigDouble = aBigDouble;
    return this;
  }

  /**
   * With a "quoted" description.
   *
   * minimum: 0L
   * maximum: 99999999L
   *
   * @return aBigDouble
   **/
  @Min(0L) @Max(99999999L)
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
   *
   * minimum: 0L
   * maximum: 1000L
   *
   * @return aBigFloat
   **/
  @Min(0L) @Max(1000L)
  public Float getaBigFloat() {
    return aBigFloat;
  }

  public void setaBigFloat(Float aBigFloat) {
    this.aBigFloat = aBigFloat;
  }

  public ValidationDto badParsingOfRange(Integer badParsingOfRange) {
    this.badParsingOfRange = badParsingOfRange;
    return this;
  }

  /**
   * Get badParsingOfRange
   * minimum: 100L
   * maximum: 99999999L
   *
   * @return badParsingOfRange
   **/
  @Min(100L) @Max(99999999L)
  public Integer getBadParsingOfRange() {
    return badParsingOfRange;
  }

  public void setBadParsingOfRange(Integer badParsingOfRange) {
    this.badParsingOfRange = badParsingOfRange;
  }

  public ValidationDto intValue(Integer intValue) {
    this.intValue = intValue;
    return this;
  }

  /**
   * Get intValue
   * minimum: 10L
   * maximum: 20L
   *
   * @return intValue
   **/
  @Min(10L) @Max(20L)
  public Integer getIntValue() {
    return intValue;
  }

  public void setIntValue(Integer intValue) {
    this.intValue = intValue;
  }

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

  public ValidationDto negativeBigDecimal(BigDecimal negativeBigDecimal) {
    this.negativeBigDecimal = negativeBigDecimal;
    return this;
  }

  /**
   * Get negativeBigDecimal
   * @return negativeBigDecimal
   **/
  public BigDecimal getNegativeBigDecimal() {
    return negativeBigDecimal;
  }

  public void setNegativeBigDecimal(BigDecimal negativeBigDecimal) {
    this.negativeBigDecimal = negativeBigDecimal;
  }

  public ValidationDto negativeInt(Integer negativeInt) {
    this.negativeInt = negativeInt;
    return this;
  }

  /**
   * Get negativeInt
   * @return negativeInt
   **/
  public Integer getNegativeInt() {
    return negativeInt;
  }

  public void setNegativeInt(Integer negativeInt) {
    this.negativeInt = negativeInt;
  }

  public ValidationDto negativeOrZeroBigDecimal(BigDecimal negativeOrZeroBigDecimal) {
    this.negativeOrZeroBigDecimal = negativeOrZeroBigDecimal;
    return this;
  }

  /**
   * Get negativeOrZeroBigDecimal
   * @return negativeOrZeroBigDecimal
   **/
  @NegativeOrZero
  public BigDecimal getNegativeOrZeroBigDecimal() {
    return negativeOrZeroBigDecimal;
  }

  public void setNegativeOrZeroBigDecimal(BigDecimal negativeOrZeroBigDecimal) {
    this.negativeOrZeroBigDecimal = negativeOrZeroBigDecimal;
  }

  public ValidationDto negativeOrZeroInt(Integer negativeOrZeroInt) {
    this.negativeOrZeroInt = negativeOrZeroInt;
    return this;
  }

  /**
   * Get negativeOrZeroInt
   * @return negativeOrZeroInt
   **/
  @NegativeOrZero
  public Integer getNegativeOrZeroInt() {
    return negativeOrZeroInt;
  }

  public void setNegativeOrZeroInt(Integer negativeOrZeroInt) {
    this.negativeOrZeroInt = negativeOrZeroInt;
  }

  public ValidationDto notBlankString(String notBlankString) {
    this.notBlankString = Objects.requireNonNull(notBlankString, "Property notBlankString is required, cannot be null");
    return this;
  }

  /**
   * Get notBlankString
   * @return notBlankString
   **/
  @NotNull @NotBlank
  public String getNotBlankString() {
    return notBlankString;
  }

  public void setNotBlankString(String notBlankString) {
    this.notBlankString = Objects.requireNonNull(notBlankString, "Property notBlankString is required, cannot be null");
  }

  public ValidationDto notEmptyArray(List<String> notEmptyArray) {
    this.notEmptyArray = Objects.requireNonNull(notEmptyArray, "Property notEmptyArray is required, cannot be null");
    return this;
  }

  public ValidationDto addNotEmptyArrayItem(String notEmptyArrayItem) {
    this.notEmptyArray.add(notEmptyArrayItem);
    return this;
  }

  /**
   * Get notEmptyArray
   * @return notEmptyArray
   **/
  @NotNull @NotEmpty
  public List<String> getNotEmptyArray() {
    return notEmptyArray;
  }

  public void setNotEmptyArray(List<String> notEmptyArray) {
    this.notEmptyArray = Objects.requireNonNull(notEmptyArray, "Property notEmptyArray is required, cannot be null");
  }

  public ValidationDto notEmptyDto(Simple notEmptyDto) {
    this.notEmptyDto = notEmptyDto;
    return this;
  }

  /**
   * Get notEmptyDto
   * @return notEmptyDto
   **/
  @Valid
  public Simple getNotEmptyDto() {
    return notEmptyDto;
  }

  public void setNotEmptyDto(Simple notEmptyDto) {
    this.notEmptyDto = notEmptyDto;
  }

  public ValidationDto notEmptyString(String notEmptyString) {
    this.notEmptyString = Objects.requireNonNull(notEmptyString, "Property notEmptyString is required, cannot be null");
    return this;
  }

  /**
   * Get notEmptyString
   * @return notEmptyString
   **/
  @NotNull @NotEmpty
  public String getNotEmptyString() {
    return notEmptyString;
  }

  public void setNotEmptyString(String notEmptyString) {
    this.notEmptyString = Objects.requireNonNull(notEmptyString, "Property notEmptyString is required, cannot be null");
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

  public ValidationDto positiveBigDecimal(BigDecimal positiveBigDecimal) {
    this.positiveBigDecimal = positiveBigDecimal;
    return this;
  }

  /**
   * Get positiveBigDecimal
   * @return positiveBigDecimal
   **/
  public BigDecimal getPositiveBigDecimal() {
    return positiveBigDecimal;
  }

  public void setPositiveBigDecimal(BigDecimal positiveBigDecimal) {
    this.positiveBigDecimal = positiveBigDecimal;
  }

  public ValidationDto positiveInt(Integer positiveInt) {
    this.positiveInt = positiveInt;
    return this;
  }

  /**
   * Get positiveInt
   * @return positiveInt
   **/
  public Integer getPositiveInt() {
    return positiveInt;
  }

  public void setPositiveInt(Integer positiveInt) {
    this.positiveInt = positiveInt;
  }

  public ValidationDto positiveOrZeroBigDecimal(BigDecimal positiveOrZeroBigDecimal) {
    this.positiveOrZeroBigDecimal = positiveOrZeroBigDecimal;
    return this;
  }

  /**
   * Get positiveOrZeroBigDecimal
   * @return positiveOrZeroBigDecimal
   **/
  @PositiveOrZero
  public BigDecimal getPositiveOrZeroBigDecimal() {
    return positiveOrZeroBigDecimal;
  }

  public void setPositiveOrZeroBigDecimal(BigDecimal positiveOrZeroBigDecimal) {
    this.positiveOrZeroBigDecimal = positiveOrZeroBigDecimal;
  }

  public ValidationDto positiveOrZeroInt(Integer positiveOrZeroInt) {
    this.positiveOrZeroInt = positiveOrZeroInt;
    return this;
  }

  /**
   * Get positiveOrZeroInt
   * @return positiveOrZeroInt
   **/
  @PositiveOrZero
  public Integer getPositiveOrZeroInt() {
    return positiveOrZeroInt;
  }

  public void setPositiveOrZeroInt(Integer positiveOrZeroInt) {
    this.positiveOrZeroInt = positiveOrZeroInt;
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

  public ValidationDto sizedArray(List<String> sizedArray) {
    this.sizedArray = sizedArray;
    return this;
  }

  public ValidationDto addSizedArrayItem(String sizedArrayItem) {
    if (this.sizedArray == null) {
      this.sizedArray = new ArrayList<>();
    }
    this.sizedArray.add(sizedArrayItem);
    return this;
  }

  /**
   * Get sizedArray
   * @return sizedArray
   **/
  @Size(min = 1, max = 50)
  public List<String> getSizedArray() {
    return sizedArray;
  }

  public void setSizedArray(List<String> sizedArray) {
    this.sizedArray = sizedArray;
  }

  public ValidationDto sizedObject(Simple sizedObject) {
    this.sizedObject = sizedObject;
    return this;
  }

  /**
   * Get sizedObject
   * @return sizedObject
   **/
  @Valid
  public Simple getSizedObject() {
    return sizedObject;
  }

  public void setSizedObject(Simple sizedObject) {
    this.sizedObject = sizedObject;
  }

  public ValidationDto sizedString(String sizedString) {
    this.sizedString = sizedString;
    return this;
  }

  /**
   * Get sizedString
   * @return sizedString
   **/
  @Size(min = 1, max = 50)
  public String getSizedString() {
    return sizedString;
  }

  public void setSizedString(String sizedString) {
    this.sizedString = sizedString;
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

  public ValidationDto veryBigLong(Long veryBigLong) {
    this.veryBigLong = veryBigLong;
    return this;
  }

  /**
   * Get veryBigLong
   * minimum: 100L
   * maximum: 9999999999L
   *
   * @return veryBigLong
   **/
  @Min(100L) @Max(9999999999L)
  public Long getVeryBigLong() {
    return veryBigLong;
  }

  public void setVeryBigLong(Long veryBigLong) {
    this.veryBigLong = veryBigLong;
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
    return Objects.equals(this.aBigDecimal, other.aBigDecimal) &&
        Objects.equals(this.aBigDouble, other.aBigDouble) &&
        Objects.equals(this.aBigFloat, other.aBigFloat) &&
        Objects.equals(this.badParsingOfRange, other.badParsingOfRange) &&
        Objects.equals(this.intValue, other.intValue) &&
        Objects.equals(this.name, other.name) &&
        Objects.equals(this.negativeBigDecimal, other.negativeBigDecimal) &&
        Objects.equals(this.negativeInt, other.negativeInt) &&
        Objects.equals(this.negativeOrZeroBigDecimal, other.negativeOrZeroBigDecimal) &&
        Objects.equals(this.negativeOrZeroInt, other.negativeOrZeroInt) &&
        Objects.equals(this.notBlankString, other.notBlankString) &&
        Objects.equals(this.notEmptyArray, other.notEmptyArray) &&
        Objects.equals(this.notEmptyDto, other.notEmptyDto) &&
        Objects.equals(this.notEmptyString, other.notEmptyString) &&
        Objects.equals(this.pattern, other.pattern) &&
        Objects.equals(this.patternDigits, other.patternDigits) &&
        Objects.equals(this.positiveBigDecimal, other.positiveBigDecimal) &&
        Objects.equals(this.positiveInt, other.positiveInt) &&
        Objects.equals(this.positiveOrZeroBigDecimal, other.positiveOrZeroBigDecimal) &&
        Objects.equals(this.positiveOrZeroInt, other.positiveOrZeroInt) &&
        Objects.equals(this.primitivesShouldNotHaveValidate, other.primitivesShouldNotHaveValidate) &&
        Objects.equals(this.sizedArray, other.sizedArray) &&
        Objects.equals(this.sizedObject, other.sizedObject) &&
        Objects.equals(this.sizedString, other.sizedString) &&
        Objects.equals(this.validObjects, other.validObjects) &&
        Objects.equals(this.veryBigLong, other.veryBigLong);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aBigDecimal, aBigDouble, aBigFloat, badParsingOfRange, intValue, name, negativeBigDecimal, negativeInt, negativeOrZeroBigDecimal, negativeOrZeroInt, notBlankString, notEmptyArray, notEmptyDto, notEmptyString, pattern, patternDigits, positiveBigDecimal, positiveInt, positiveOrZeroBigDecimal, positiveOrZeroInt, primitivesShouldNotHaveValidate, sizedArray, sizedObject, sizedString, validObjects, veryBigLong);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValidationDto {");
    sb.append("\n    aBigDecimal: ").append(toIndentedString(aBigDecimal));
    sb.append("\n    aBigDouble: ").append(toIndentedString(aBigDouble));
    sb.append("\n    aBigFloat: ").append(toIndentedString(aBigFloat));
    sb.append("\n    badParsingOfRange: ").append(toIndentedString(badParsingOfRange));
    sb.append("\n    intValue: ").append(toIndentedString(intValue));
    sb.append("\n    name: ").append(toIndentedString(name));
    sb.append("\n    negativeBigDecimal: ").append(toIndentedString(negativeBigDecimal));
    sb.append("\n    negativeInt: ").append(toIndentedString(negativeInt));
    sb.append("\n    negativeOrZeroBigDecimal: ").append(toIndentedString(negativeOrZeroBigDecimal));
    sb.append("\n    negativeOrZeroInt: ").append(toIndentedString(negativeOrZeroInt));
    sb.append("\n    notBlankString: ").append(toIndentedString(notBlankString));
    sb.append("\n    notEmptyArray: ").append(toIndentedString(notEmptyArray));
    sb.append("\n    notEmptyDto: ").append(toIndentedString(notEmptyDto));
    sb.append("\n    notEmptyString: ").append(toIndentedString(notEmptyString));
    sb.append("\n    pattern: ").append(toIndentedString(pattern));
    sb.append("\n    patternDigits: ").append(toIndentedString(patternDigits));
    sb.append("\n    positiveBigDecimal: ").append(toIndentedString(positiveBigDecimal));
    sb.append("\n    positiveInt: ").append(toIndentedString(positiveInt));
    sb.append("\n    positiveOrZeroBigDecimal: ").append(toIndentedString(positiveOrZeroBigDecimal));
    sb.append("\n    positiveOrZeroInt: ").append(toIndentedString(positiveOrZeroInt));
    sb.append("\n    primitivesShouldNotHaveValidate: ").append(toIndentedString(primitivesShouldNotHaveValidate));
    sb.append("\n    sizedArray: ").append(toIndentedString(sizedArray));
    sb.append("\n    sizedObject: ").append(toIndentedString(sizedObject));
    sb.append("\n    sizedString: ").append(toIndentedString(sizedString));
    sb.append("\n    validObjects: ").append(toIndentedString(validObjects));
    sb.append("\n    veryBigLong: ").append(toIndentedString(veryBigLong));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
