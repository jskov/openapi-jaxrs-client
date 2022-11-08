/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.quarkus.reflection.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.validation.Valid;

/**
 * ExternedSpecialTypes
 */
@JsonbPropertyOrder({
  ExternedSpecialTypes.JSON_PROPERTY_BIG_DECIMAL,
  ExternedSpecialTypes.JSON_PROPERTY_ZONED_DATE_TIME,
  ExternedSpecialTypes.JSON_PROPERTY_OFFSET_DATE_TIME,
  ExternedSpecialTypes.JSON_PROPERTY_DATE_TIME,
  ExternedSpecialTypes.JSON_PROPERTY_DATE,
  ExternedSpecialTypes.JSON_PROPERTY_AN_ENUM
})
@RegisterForReflection
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ExternedSpecialTypes {
  public static final String JSON_PROPERTY_BIG_DECIMAL = "bigDecimal";
  @JsonbProperty(JSON_PROPERTY_BIG_DECIMAL)
  private BigDecimal bigDecimal;

  public static final String JSON_PROPERTY_ZONED_DATE_TIME = "zonedDateTime";
  @JsonbProperty(JSON_PROPERTY_ZONED_DATE_TIME)
  private OffsetDateTime zonedDateTime;

  public static final String JSON_PROPERTY_OFFSET_DATE_TIME = "offsetDateTime";
  @JsonbProperty(JSON_PROPERTY_OFFSET_DATE_TIME)
  private OffsetDateTime offsetDateTime;

  public static final String JSON_PROPERTY_DATE_TIME = "dateTime";
  @JsonbProperty(JSON_PROPERTY_DATE_TIME)
  private OffsetDateTime dateTime;

  public static final String JSON_PROPERTY_DATE = "date";
  @JsonbProperty(JSON_PROPERTY_DATE)
  private LocalDate date;

  public static final String JSON_PROPERTY_AN_ENUM = "anEnum";
  @JsonbProperty(JSON_PROPERTY_AN_ENUM)
  private SimpleEnum anEnum;

  public ExternedSpecialTypes bigDecimal(BigDecimal bigDecimal) {
    this.bigDecimal = bigDecimal;
    return this;
  }

  /**
   * Get bigDecimal
   * @return bigDecimal
   **/
  public BigDecimal getBigDecimal() {
    return bigDecimal;
  }

  public void setBigDecimal(BigDecimal bigDecimal) {
    this.bigDecimal = bigDecimal;
  }

  public ExternedSpecialTypes zonedDateTime(OffsetDateTime zonedDateTime) {
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

  public ExternedSpecialTypes offsetDateTime(OffsetDateTime offsetDateTime) {
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

  public ExternedSpecialTypes dateTime(OffsetDateTime dateTime) {
    this.dateTime = dateTime;
    return this;
  }

  /**
   * Get dateTime
   * @return dateTime
   **/
  public OffsetDateTime getDateTime() {
    return dateTime;
  }

  public void setDateTime(OffsetDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public ExternedSpecialTypes date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * Get date
   * @return date
   **/
  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public ExternedSpecialTypes anEnum(SimpleEnum anEnum) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ExternedSpecialTypes)) {
      return false;
    }
    ExternedSpecialTypes other = (ExternedSpecialTypes) o;
    return Objects.equals(this.bigDecimal, other.bigDecimal) &&
        Objects.equals(this.zonedDateTime, other.zonedDateTime) &&
        Objects.equals(this.offsetDateTime, other.offsetDateTime) &&
        Objects.equals(this.dateTime, other.dateTime) &&
        Objects.equals(this.date, other.date) &&
        Objects.equals(this.anEnum, other.anEnum);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bigDecimal, zonedDateTime, offsetDateTime, dateTime, date, anEnum);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExternedSpecialTypes {");
    sb.append("\n    bigDecimal: ").append(toIndentedString(bigDecimal));
    sb.append("\n    zonedDateTime: ").append(toIndentedString(zonedDateTime));
    sb.append("\n    offsetDateTime: ").append(toIndentedString(offsetDateTime));
    sb.append("\n    dateTime: ").append(toIndentedString(dateTime));
    sb.append("\n    date: ").append(toIndentedString(date));
    sb.append("\n    anEnum: ").append(toIndentedString(anEnum));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
