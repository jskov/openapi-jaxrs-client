/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.jackson.custom_dates.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

/**
 * SpecialTypes
 */
@JsonSerialize(include = com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion.NON_NULL)
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class SpecialTypes {
  public static final String JSON_PROPERTY_BIG_DECIMAL = "bigDecimal";
  @JsonProperty(JSON_PROPERTY_BIG_DECIMAL)
  private BigDecimal bigDecimal;

  public static final String JSON_PROPERTY_LOCAL_DATE = "localDate";
  @JsonProperty(JSON_PROPERTY_LOCAL_DATE)
  @JsonDeserialize(using = mada.tests.e2e.opts.generator.jackson.custom_dates.CustomLocalDateDeserializer.class)
  @JsonSerialize(using = mada.tests.e2e.opts.generator.jackson.custom_dates.CustomLocalDateSerializer.class, include = com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion.NON_NULL)
  private LocalDate localDate;

  public static final String JSON_PROPERTY_LOCAL_DATE_TIME = "localDateTime";
  @JsonProperty(JSON_PROPERTY_LOCAL_DATE_TIME)
  @JsonDeserialize(using = mada.tests.e2e.opts.generator.jackson.custom_dates.CustomLocalDateTimeDeserializer.class)
  @JsonSerialize(using = mada.tests.e2e.opts.generator.jackson.custom_dates.CustomLocalDateTimeSerializer.class, include = com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion.NON_NULL)
  private LocalDateTime localDateTime;

  public static final String JSON_PROPERTY_LOCAL_TIME = "localTime";
  @JsonProperty(JSON_PROPERTY_LOCAL_TIME)
  private LocalTime localTime;

  public static final String JSON_PROPERTY_OFFSET_DATE_TIME = "offsetDateTime";
  @JsonProperty(JSON_PROPERTY_OFFSET_DATE_TIME)
  @JsonDeserialize(using = mada.tests.e2e.opts.generator.jackson.custom_dates.CustomLocalDateTimeDeserializer.class)
  @JsonSerialize(using = mada.tests.e2e.opts.generator.jackson.custom_dates.CustomLocalDateTimeSerializer.class, include = com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion.NON_NULL)
  private LocalDateTime offsetDateTime;

  public static final String JSON_PROPERTY_ZONED_DATE_TIME = "zonedDateTime";
  @JsonProperty(JSON_PROPERTY_ZONED_DATE_TIME)
  @JsonDeserialize(using = mada.tests.e2e.opts.generator.jackson.custom_dates.CustomLocalDateTimeDeserializer.class)
  @JsonSerialize(using = mada.tests.e2e.opts.generator.jackson.custom_dates.CustomLocalDateTimeSerializer.class, include = com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion.NON_NULL)
  private LocalDateTime zonedDateTime;

  public SpecialTypes bigDecimal(BigDecimal bigDecimal) {
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

  public SpecialTypes localDateTime(LocalDateTime localDateTime) {
    this.localDateTime = localDateTime;
    return this;
  }

  /**
   * Get localDateTime
   * @return localDateTime
   **/
  public LocalDateTime getLocalDateTime() {
    return localDateTime;
  }

  public void setLocalDateTime(LocalDateTime localDateTime) {
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

  public SpecialTypes offsetDateTime(LocalDateTime offsetDateTime) {
    this.offsetDateTime = offsetDateTime;
    return this;
  }

  /**
   * Get offsetDateTime
   * @return offsetDateTime
   **/
  public LocalDateTime getOffsetDateTime() {
    return offsetDateTime;
  }

  public void setOffsetDateTime(LocalDateTime offsetDateTime) {
    this.offsetDateTime = offsetDateTime;
  }

  public SpecialTypes zonedDateTime(LocalDateTime zonedDateTime) {
    this.zonedDateTime = zonedDateTime;
    return this;
  }

  /**
   * Get zonedDateTime
   * @return zonedDateTime
   **/
  public LocalDateTime getZonedDateTime() {
    return zonedDateTime;
  }

  public void setZonedDateTime(LocalDateTime zonedDateTime) {
    this.zonedDateTime = zonedDateTime;
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
    return Objects.equals(this.bigDecimal, other.bigDecimal) &&
        Objects.equals(this.localDate, other.localDate) &&
        Objects.equals(this.localDateTime, other.localDateTime) &&
        Objects.equals(this.localTime, other.localTime) &&
        Objects.equals(this.offsetDateTime, other.offsetDateTime) &&
        Objects.equals(this.zonedDateTime, other.zonedDateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bigDecimal, localDate, localDateTime, localTime, offsetDateTime, zonedDateTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpecialTypes {");
    sb.append("\n    bigDecimal: ").append(toIndentedString(bigDecimal));
    sb.append("\n    localDate: ").append(toIndentedString(localDate));
    sb.append("\n    localDateTime: ").append(toIndentedString(localDateTime));
    sb.append("\n    localTime: ").append(toIndentedString(localTime));
    sb.append("\n    offsetDateTime: ").append(toIndentedString(offsetDateTime));
    sb.append("\n    zonedDateTime: ").append(toIndentedString(zonedDateTime));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
