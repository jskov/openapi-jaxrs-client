/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.zoneddatetime.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.validation.Valid;

/**
 * SpecialTypes
 */
@JsonbPropertyOrder({
  SpecialTypes.JSON_PROPERTY_A_BIG_DECIMAL,
  SpecialTypes.JSON_PROPERTY_ZONED_DATE_TIME,
  SpecialTypes.JSON_PROPERTY_OFFSET_DATE_TIME,
  SpecialTypes.JSON_PROPERTY_LOCAL_DATE_TIME,
  SpecialTypes.JSON_PROPERTY_LOCAL_DATE,
  SpecialTypes.JSON_PROPERTY_LOCAL_TIME
})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class SpecialTypes {
  public static final String JSON_PROPERTY_A_BIG_DECIMAL = "aBigDecimal";
  @JsonbProperty(JSON_PROPERTY_A_BIG_DECIMAL)
  private BigDecimal aBigDecimal;

  public static final String JSON_PROPERTY_ZONED_DATE_TIME = "zonedDateTime";
  @JsonbProperty(JSON_PROPERTY_ZONED_DATE_TIME)
  private ZonedDateTime zonedDateTime;

  public static final String JSON_PROPERTY_OFFSET_DATE_TIME = "offsetDateTime";
  @JsonbProperty(JSON_PROPERTY_OFFSET_DATE_TIME)
  private ZonedDateTime offsetDateTime;

  public static final String JSON_PROPERTY_LOCAL_DATE_TIME = "localDateTime";
  @JsonbProperty(JSON_PROPERTY_LOCAL_DATE_TIME)
  private ZonedDateTime localDateTime;

  public static final String JSON_PROPERTY_LOCAL_DATE = "localDate";
  @JsonbProperty(JSON_PROPERTY_LOCAL_DATE)
  private LocalDate localDate;

  public static final String JSON_PROPERTY_LOCAL_TIME = "localTime";
  @JsonbProperty(JSON_PROPERTY_LOCAL_TIME)
  private LocalTime localTime;

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

  public SpecialTypes zonedDateTime(ZonedDateTime zonedDateTime) {
    this.zonedDateTime = zonedDateTime;
    return this;
  }

  /**
   * Get zonedDateTime
   * @return zonedDateTime
   **/
  public ZonedDateTime getZonedDateTime() {
    return zonedDateTime;
  }

  public void setZonedDateTime(ZonedDateTime zonedDateTime) {
    this.zonedDateTime = zonedDateTime;
  }

  public SpecialTypes offsetDateTime(ZonedDateTime offsetDateTime) {
    this.offsetDateTime = offsetDateTime;
    return this;
  }

  /**
   * Get offsetDateTime
   * @return offsetDateTime
   **/
  public ZonedDateTime getOffsetDateTime() {
    return offsetDateTime;
  }

  public void setOffsetDateTime(ZonedDateTime offsetDateTime) {
    this.offsetDateTime = offsetDateTime;
  }

  public SpecialTypes localDateTime(ZonedDateTime localDateTime) {
    this.localDateTime = localDateTime;
    return this;
  }

  /**
   * Get localDateTime
   * @return localDateTime
   **/
  public ZonedDateTime getLocalDateTime() {
    return localDateTime;
  }

  public void setLocalDateTime(ZonedDateTime localDateTime) {
    this.localDateTime = localDateTime;
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

  public SpecialTypes localTime(LocalTime localTime) {
    this.localTime = localTime;
    return this;
  }

  /**
   * Get localTime
   * @return localTime
   **/
  @Valid
  public LocalTime getLocalTime() {
    return localTime;
  }

  public void setLocalTime(LocalTime localTime) {
    this.localTime = localTime;
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
        Objects.equals(this.zonedDateTime, other.zonedDateTime) &&
        Objects.equals(this.offsetDateTime, other.offsetDateTime) &&
        Objects.equals(this.localDateTime, other.localDateTime) &&
        Objects.equals(this.localDate, other.localDate) &&
        Objects.equals(this.localTime, other.localTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aBigDecimal, zonedDateTime, offsetDateTime, localDateTime, localDate, localTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpecialTypes {");
    sb.append("\n    aBigDecimal: ").append(toIndentedString(aBigDecimal));
    sb.append("\n    zonedDateTime: ").append(toIndentedString(zonedDateTime));
    sb.append("\n    offsetDateTime: ").append(toIndentedString(offsetDateTime));
    sb.append("\n    localDateTime: ").append(toIndentedString(localDateTime));
    sb.append("\n    localDate: ").append(toIndentedString(localDate));
    sb.append("\n    localTime: ").append(toIndentedString(localTime));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
