/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.specs.v3_0.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * SpecialTypes
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class SpecialTypes {
  public static final String JSON_PROPERTY_A_BIG_DECIMAL = "aBigDecimal";
  @JsonbProperty(JSON_PROPERTY_A_BIG_DECIMAL)
  private BigDecimal aBigDecimal;

  public static final String JSON_PROPERTY_AN_ENUM = "anEnum";
  @JsonbProperty(JSON_PROPERTY_AN_ENUM)
  private SimpleEnum anEnum;

  public static final String JSON_PROPERTY_AN_ENUM_SCHEMA = "anEnumSchema";
  @JsonbProperty(JSON_PROPERTY_AN_ENUM_SCHEMA)
  @Schema(description = "description text field")
  private SimpleEnumSchema anEnumSchema;

  public static final String JSON_PROPERTY_LOCAL_DATE = "localDate";
  @JsonbProperty(JSON_PROPERTY_LOCAL_DATE)
  private LocalDate localDate;

  public static final String JSON_PROPERTY_LOCAL_DATE_DESCRIPTION = "localDateDescription";
  @JsonbProperty(JSON_PROPERTY_LOCAL_DATE_DESCRIPTION)
  @Schema(required = true, description = "description text")
  private LocalDate localDateDescription;

  public static final String JSON_PROPERTY_LOCAL_DATE_TIME = "localDateTime";
  @JsonbProperty(JSON_PROPERTY_LOCAL_DATE_TIME)
  private OffsetDateTime localDateTime;

  public static final String JSON_PROPERTY_LOCAL_TIME = "localTime";
  @JsonbProperty(JSON_PROPERTY_LOCAL_TIME)
  private LocalTime localTime;

  public static final String JSON_PROPERTY_LOCAL_TIME_DESCRIPTION = "localTimeDescription";
  @JsonbProperty(JSON_PROPERTY_LOCAL_TIME_DESCRIPTION)
  @Schema(description = "description text")
  private LocalTime localTimeDescription;

  public static final String JSON_PROPERTY_OFFSET_DATE_TIME = "offsetDateTime";
  @JsonbProperty(JSON_PROPERTY_OFFSET_DATE_TIME)
  private OffsetDateTime offsetDateTime;

  public static final String JSON_PROPERTY_UUID = "uuid";
  @JsonbProperty(JSON_PROPERTY_UUID)
  private UUID uuid;

  public static final String JSON_PROPERTY_ZONED_DATE_TIME = "zonedDateTime";
  @JsonbProperty(JSON_PROPERTY_ZONED_DATE_TIME)
  private OffsetDateTime zonedDateTime;

  public static final String JSON_PROPERTY_ZONED_DATE_TIME_DESCRIPTION = "zonedDateTimeDescription";
  @JsonbProperty(JSON_PROPERTY_ZONED_DATE_TIME_DESCRIPTION)
  @Schema(description = "description text")
  private OffsetDateTime zonedDateTimeDescription;

  public SpecialTypes aBigDecimal(BigDecimal aBigDecimal) {
    this.aBigDecimal = aBigDecimal;
    return this;
  }

  /**
   * Get aBigDecimal
   * @return aBigDecimal
   **/
  public BigDecimal getaBigDecimal() {
    return aBigDecimal;
  }

  public void setaBigDecimal(BigDecimal aBigDecimal) {
    this.aBigDecimal = aBigDecimal;
  }

  public SpecialTypes anEnum(SimpleEnum anEnum) {
    this.anEnum = anEnum;
    return this;
  }

  /**
   * Get anEnum
   * @return anEnum
   **/
  @Valid
  public SimpleEnum getAnEnum() {
    return anEnum;
  }

  public void setAnEnum(SimpleEnum anEnum) {
    this.anEnum = anEnum;
  }

  public SpecialTypes anEnumSchema(SimpleEnumSchema anEnumSchema) {
    this.anEnumSchema = anEnumSchema;
    return this;
  }

  /**
   * description text field.
   *
   * @return anEnumSchema
   **/
  @Valid
  public SimpleEnumSchema getAnEnumSchema() {
    return anEnumSchema;
  }

  public void setAnEnumSchema(SimpleEnumSchema anEnumSchema) {
    this.anEnumSchema = anEnumSchema;
  }

  public SpecialTypes localDate(LocalDate localDate) {
    this.localDate = localDate;
    return this;
  }

  /**
   * Get localDate
   * @return localDate
   **/
  public LocalDate getLocalDate() {
    return localDate;
  }

  public void setLocalDate(LocalDate localDate) {
    this.localDate = localDate;
  }

  public SpecialTypes localDateDescription(LocalDate localDateDescription) {
    this.localDateDescription = Objects.requireNonNull(localDateDescription, "Property localDateDescription is required, cannot be null");
    return this;
  }

  /**
   * description text.
   *
   * @return localDateDescription
   **/
  @NotNull
  public LocalDate getLocalDateDescription() {
    return localDateDescription;
  }

  public void setLocalDateDescription(LocalDate localDateDescription) {
    this.localDateDescription = Objects.requireNonNull(localDateDescription, "Property localDateDescription is required, cannot be null");
  }

  public SpecialTypes localDateTime(OffsetDateTime localDateTime) {
    this.localDateTime = localDateTime;
    return this;
  }

  /**
   * Get localDateTime
   * @return localDateTime
   **/
  public OffsetDateTime getLocalDateTime() {
    return localDateTime;
  }

  public void setLocalDateTime(OffsetDateTime localDateTime) {
    this.localDateTime = localDateTime;
  }

  public SpecialTypes localTime(LocalTime localTime) {
    this.localTime = localTime;
    return this;
  }

  /**
   * Get localTime
   * @return localTime
   **/
  public LocalTime getLocalTime() {
    return localTime;
  }

  public void setLocalTime(LocalTime localTime) {
    this.localTime = localTime;
  }

  public SpecialTypes localTimeDescription(LocalTime localTimeDescription) {
    this.localTimeDescription = localTimeDescription;
    return this;
  }

  /**
   * description text.
   *
   * @return localTimeDescription
   **/
  public LocalTime getLocalTimeDescription() {
    return localTimeDescription;
  }

  public void setLocalTimeDescription(LocalTime localTimeDescription) {
    this.localTimeDescription = localTimeDescription;
  }

  public SpecialTypes offsetDateTime(OffsetDateTime offsetDateTime) {
    this.offsetDateTime = offsetDateTime;
    return this;
  }

  /**
   * Get offsetDateTime
   * @return offsetDateTime
   **/
  public OffsetDateTime getOffsetDateTime() {
    return offsetDateTime;
  }

  public void setOffsetDateTime(OffsetDateTime offsetDateTime) {
    this.offsetDateTime = offsetDateTime;
  }

  public SpecialTypes uuid(UUID uuid) {
    this.uuid = uuid;
    return this;
  }

  /**
   * Get uuid
   * @return uuid
   **/
  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
  }

  public SpecialTypes zonedDateTime(OffsetDateTime zonedDateTime) {
    this.zonedDateTime = zonedDateTime;
    return this;
  }

  /**
   * Get zonedDateTime
   * @return zonedDateTime
   **/
  public OffsetDateTime getZonedDateTime() {
    return zonedDateTime;
  }

  public void setZonedDateTime(OffsetDateTime zonedDateTime) {
    this.zonedDateTime = zonedDateTime;
  }

  public SpecialTypes zonedDateTimeDescription(OffsetDateTime zonedDateTimeDescription) {
    this.zonedDateTimeDescription = zonedDateTimeDescription;
    return this;
  }

  /**
   * description text.
   *
   * @return zonedDateTimeDescription
   **/
  public OffsetDateTime getZonedDateTimeDescription() {
    return zonedDateTimeDescription;
  }

  public void setZonedDateTimeDescription(OffsetDateTime zonedDateTimeDescription) {
    this.zonedDateTimeDescription = zonedDateTimeDescription;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SpecialTypes)) {
      return false;
    }
    SpecialTypes other = (SpecialTypes) o;
    return Objects.equals(this.aBigDecimal, other.aBigDecimal) &&
        Objects.equals(this.anEnum, other.anEnum) &&
        Objects.equals(this.anEnumSchema, other.anEnumSchema) &&
        Objects.equals(this.localDate, other.localDate) &&
        Objects.equals(this.localDateDescription, other.localDateDescription) &&
        Objects.equals(this.localDateTime, other.localDateTime) &&
        Objects.equals(this.localTime, other.localTime) &&
        Objects.equals(this.localTimeDescription, other.localTimeDescription) &&
        Objects.equals(this.offsetDateTime, other.offsetDateTime) &&
        Objects.equals(this.uuid, other.uuid) &&
        Objects.equals(this.zonedDateTime, other.zonedDateTime) &&
        Objects.equals(this.zonedDateTimeDescription, other.zonedDateTimeDescription);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aBigDecimal, anEnum, anEnumSchema, localDate, localDateDescription, localDateTime, localTime, localTimeDescription, offsetDateTime, uuid, zonedDateTime, zonedDateTimeDescription);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpecialTypes {");
    sb.append("\n    aBigDecimal: ").append(toIndentedString(aBigDecimal));
    sb.append("\n    anEnum: ").append(toIndentedString(anEnum));
    sb.append("\n    anEnumSchema: ").append(toIndentedString(anEnumSchema));
    sb.append("\n    localDate: ").append(toIndentedString(localDate));
    sb.append("\n    localDateDescription: ").append(toIndentedString(localDateDescription));
    sb.append("\n    localDateTime: ").append(toIndentedString(localDateTime));
    sb.append("\n    localTime: ").append(toIndentedString(localTime));
    sb.append("\n    localTimeDescription: ").append(toIndentedString(localTimeDescription));
    sb.append("\n    offsetDateTime: ").append(toIndentedString(offsetDateTime));
    sb.append("\n    uuid: ").append(toIndentedString(uuid));
    sb.append("\n    zonedDateTime: ").append(toIndentedString(zonedDateTime));
    sb.append("\n    zonedDateTimeDescription: ").append(toIndentedString(zonedDateTimeDescription));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
