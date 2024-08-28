/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.dto.validation.example.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import javax.json.bind.annotation.JsonbProperty;
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

  public static final String JSON_PROPERTY_A_NON_NULLABLE_BOOLEAN = "aNonNullableBoolean";
  @JsonbProperty(JSON_PROPERTY_A_NON_NULLABLE_BOOLEAN)
  private Boolean aNonNullableBoolean;

  public static final String JSON_PROPERTY_A_NON_NULLABLE_DATE = "aNonNullableDate";
  @JsonbProperty(JSON_PROPERTY_A_NON_NULLABLE_DATE)
  @Schema(example = "Fri Jul 10 02:00:00 CEST 2020")
  private LocalDate aNonNullableDate;

  public static final String JSON_PROPERTY_A_NON_NULLABLE_NUMBER = "aNonNullableNumber";
  @JsonbProperty(JSON_PROPERTY_A_NON_NULLABLE_NUMBER)
  @Schema(example = "3000")
  private BigDecimal aNonNullableNumber;

  public static final String JSON_PROPERTY_A_NON_NULLABLE_STRING = "aNonNullableString";
  @JsonbProperty(JSON_PROPERTY_A_NON_NULLABLE_STRING)
  private String aNonNullableString;

  public static final String JSON_PROPERTY_A_NON_NULLABLE_UUID = "aNonNullableUUID";
  @JsonbProperty(JSON_PROPERTY_A_NON_NULLABLE_UUID)
  private UUID aNonNullableUUID;

  public static final String JSON_PROPERTY_A_NULLABLE_BOOLEAN = "aNullableBoolean";
  @JsonbProperty(JSON_PROPERTY_A_NULLABLE_BOOLEAN)
  @Schema(nullable = true)
  private Boolean aNullableBoolean;

  public static final String JSON_PROPERTY_A_NULLABLE_DATE = "aNullableDate";
  @JsonbProperty(JSON_PROPERTY_A_NULLABLE_DATE)
  @Schema(nullable = true, example = "Fri Jul 10 02:00:00 CEST 2020")
  private LocalDate aNullableDate;

  public static final String JSON_PROPERTY_A_NULLABLE_NUMBER = "aNullableNumber";
  @JsonbProperty(JSON_PROPERTY_A_NULLABLE_NUMBER)
  @Schema(nullable = true, example = "3000")
  private BigDecimal aNullableNumber;

  public static final String JSON_PROPERTY_A_NULLABLE_STRING = "aNullableString";
  @JsonbProperty(JSON_PROPERTY_A_NULLABLE_STRING)
  @Schema(nullable = true)
  private String aNullableString;

  public static final String JSON_PROPERTY_A_NULLABLE_UUID = "aNullableUUID";
  @JsonbProperty(JSON_PROPERTY_A_NULLABLE_UUID)
  @Schema(nullable = true)
  private UUID aNullableUUID;

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

  public static final String JSON_PROPERTY_PATTERN = "pattern";
  @JsonbProperty(JSON_PROPERTY_PATTERN)
  private String pattern;

  public static final String JSON_PROPERTY_PATTERN_DIGITS = "patternDigits";
  @JsonbProperty(JSON_PROPERTY_PATTERN_DIGITS)
  private String patternDigits;

  public static final String JSON_PROPERTY_PRIMITIVES_SHOULD_NOT_HAVE_VALIDATE = "primitivesShouldNotHaveValidate";
  @JsonbProperty(JSON_PROPERTY_PRIMITIVES_SHOULD_NOT_HAVE_VALIDATE)
  private List<Boolean> primitivesShouldNotHaveValidate;

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

  public ValidationDto aNonNullableBoolean(Boolean aNonNullableBoolean) {
    this.aNonNullableBoolean = aNonNullableBoolean;
    return this;
  }

  /**
   * Get aNonNullableBoolean
   * @return aNonNullableBoolean
   **/
  public Boolean isaNonNullableBoolean() {
    return aNonNullableBoolean;
  }

  public void setaNonNullableBoolean(Boolean aNonNullableBoolean) {
    this.aNonNullableBoolean = aNonNullableBoolean;
  }

  public ValidationDto aNonNullableDate(LocalDate aNonNullableDate) {
    this.aNonNullableDate = aNonNullableDate;
    return this;
  }

  /**
   * Get aNonNullableDate
   * @return aNonNullableDate
   **/
  @NotNull
  public LocalDate getaNonNullableDate() {
    return aNonNullableDate;
  }

  public void setaNonNullableDate(LocalDate aNonNullableDate) {
    this.aNonNullableDate = aNonNullableDate;
  }

  public ValidationDto aNonNullableNumber(BigDecimal aNonNullableNumber) {
    this.aNonNullableNumber = aNonNullableNumber;
    return this;
  }

  /**
   * Get aNonNullableNumber
   * @return aNonNullableNumber
   **/
  @NotNull
  public BigDecimal getaNonNullableNumber() {
    return aNonNullableNumber;
  }

  public void setaNonNullableNumber(BigDecimal aNonNullableNumber) {
    this.aNonNullableNumber = aNonNullableNumber;
  }

  public ValidationDto aNonNullableString(String aNonNullableString) {
    this.aNonNullableString = aNonNullableString;
    return this;
  }

  /**
   * Get aNonNullableString
   * @return aNonNullableString
   **/
  @NotNull
  public String getaNonNullableString() {
    return aNonNullableString;
  }

  public void setaNonNullableString(String aNonNullableString) {
    this.aNonNullableString = aNonNullableString;
  }

  public ValidationDto aNonNullableUUID(UUID aNonNullableUUID) {
    this.aNonNullableUUID = aNonNullableUUID;
    return this;
  }

  /**
   * Get aNonNullableUUID
   * @return aNonNullableUUID
   **/
  @NotNull
  public UUID getaNonNullableUUID() {
    return aNonNullableUUID;
  }

  public void setaNonNullableUUID(UUID aNonNullableUUID) {
    this.aNonNullableUUID = aNonNullableUUID;
  }

  public ValidationDto aNullableBoolean(Boolean aNullableBoolean) {
    this.aNullableBoolean = aNullableBoolean;
    return this;
  }

  /**
   * Get aNullableBoolean
   * @return aNullableBoolean
   **/
  public Boolean isaNullableBoolean() {
    return aNullableBoolean;
  }

  public void setaNullableBoolean(Boolean aNullableBoolean) {
    this.aNullableBoolean = aNullableBoolean;
  }

  public ValidationDto aNullableDate(LocalDate aNullableDate) {
    this.aNullableDate = aNullableDate;
    return this;
  }

  /**
   * Get aNullableDate
   * @return aNullableDate
   **/
  public LocalDate getaNullableDate() {
    return aNullableDate;
  }

  public void setaNullableDate(LocalDate aNullableDate) {
    this.aNullableDate = aNullableDate;
  }

  public ValidationDto aNullableNumber(BigDecimal aNullableNumber) {
    this.aNullableNumber = aNullableNumber;
    return this;
  }

  /**
   * Get aNullableNumber
   * @return aNullableNumber
   **/
  public BigDecimal getaNullableNumber() {
    return aNullableNumber;
  }

  public void setaNullableNumber(BigDecimal aNullableNumber) {
    this.aNullableNumber = aNullableNumber;
  }

  public ValidationDto aNullableString(String aNullableString) {
    this.aNullableString = aNullableString;
    return this;
  }

  /**
   * Get aNullableString
   * @return aNullableString
   **/
  public String getaNullableString() {
    return aNullableString;
  }

  public void setaNullableString(String aNullableString) {
    this.aNullableString = aNullableString;
  }

  public ValidationDto aNullableUUID(UUID aNullableUUID) {
    this.aNullableUUID = aNullableUUID;
    return this;
  }

  /**
   * Get aNullableUUID
   * @return aNullableUUID
   **/
  public UUID getaNullableUUID() {
    return aNullableUUID;
  }

  public void setaNullableUUID(UUID aNullableUUID) {
    this.aNullableUUID = aNullableUUID;
  }

  public ValidationDto badParsingOfRange(Integer badParsingOfRange) {
    this.badParsingOfRange = badParsingOfRange;
    return this;
  }

  /**
   * Get badParsingOfRange
   * minimum: 100L
   * maximum: 99999999L
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
        Objects.equals(this.aNonNullableBoolean, other.aNonNullableBoolean) &&
        Objects.equals(this.aNonNullableDate, other.aNonNullableDate) &&
        Objects.equals(this.aNonNullableNumber, other.aNonNullableNumber) &&
        Objects.equals(this.aNonNullableString, other.aNonNullableString) &&
        Objects.equals(this.aNonNullableUUID, other.aNonNullableUUID) &&
        Objects.equals(this.aNullableBoolean, other.aNullableBoolean) &&
        Objects.equals(this.aNullableDate, other.aNullableDate) &&
        Objects.equals(this.aNullableNumber, other.aNullableNumber) &&
        Objects.equals(this.aNullableString, other.aNullableString) &&
        Objects.equals(this.aNullableUUID, other.aNullableUUID) &&
        Objects.equals(this.badParsingOfRange, other.badParsingOfRange) &&
        Objects.equals(this.intValue, other.intValue) &&
        Objects.equals(this.name, other.name) &&
        Objects.equals(this.pattern, other.pattern) &&
        Objects.equals(this.patternDigits, other.patternDigits) &&
        Objects.equals(this.primitivesShouldNotHaveValidate, other.primitivesShouldNotHaveValidate) &&
        Objects.equals(this.validObjects, other.validObjects) &&
        Objects.equals(this.veryBigLong, other.veryBigLong);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aBigDecimal, aBigDouble, aBigFloat, aNonNullableBoolean, aNonNullableDate, aNonNullableNumber, aNonNullableString, aNonNullableUUID, aNullableBoolean, aNullableDate, aNullableNumber, aNullableString, aNullableUUID, badParsingOfRange, intValue, name, pattern, patternDigits, primitivesShouldNotHaveValidate, validObjects, veryBigLong);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValidationDto {");
    sb.append("\n    aBigDecimal: ").append(toIndentedString(aBigDecimal));
    sb.append("\n    aBigDouble: ").append(toIndentedString(aBigDouble));
    sb.append("\n    aBigFloat: ").append(toIndentedString(aBigFloat));
    sb.append("\n    aNonNullableBoolean: ").append(toIndentedString(aNonNullableBoolean));
    sb.append("\n    aNonNullableDate: ").append(toIndentedString(aNonNullableDate));
    sb.append("\n    aNonNullableNumber: ").append(toIndentedString(aNonNullableNumber));
    sb.append("\n    aNonNullableString: ").append(toIndentedString(aNonNullableString));
    sb.append("\n    aNonNullableUUID: ").append(toIndentedString(aNonNullableUUID));
    sb.append("\n    aNullableBoolean: ").append(toIndentedString(aNullableBoolean));
    sb.append("\n    aNullableDate: ").append(toIndentedString(aNullableDate));
    sb.append("\n    aNullableNumber: ").append(toIndentedString(aNullableNumber));
    sb.append("\n    aNullableString: ").append(toIndentedString(aNullableString));
    sb.append("\n    aNullableUUID: ").append(toIndentedString(aNullableUUID));
    sb.append("\n    badParsingOfRange: ").append(toIndentedString(badParsingOfRange));
    sb.append("\n    intValue: ").append(toIndentedString(intValue));
    sb.append("\n    name: ").append(toIndentedString(name));
    sb.append("\n    pattern: ").append(toIndentedString(pattern));
    sb.append("\n    patternDigits: ").append(toIndentedString(patternDigits));
    sb.append("\n    primitivesShouldNotHaveValidate: ").append(toIndentedString(primitivesShouldNotHaveValidate));
    sb.append("\n    validObjects: ").append(toIndentedString(validObjects));
    sb.append("\n    veryBigLong: ").append(toIndentedString(veryBigLong));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
