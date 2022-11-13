/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.localdate.jackson_fasterxml.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * SpecialTypes
 */
@JsonPropertyOrder({
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
  @JsonProperty(JSON_PROPERTY_A_BIG_DECIMAL)
  private BigDecimal aBigDecimal;

  public static final String JSON_PROPERTY_LOCAL_DATE = "localDate";
  @JsonProperty(JSON_PROPERTY_LOCAL_DATE)
  @JsonDeserialize(using = _LocalDateJacksonDeserializer.class)
  @JsonSerialize(using = _LocalDateJacksonSerializer.class)
  private LocalDate localDate;

  public static final String JSON_PROPERTY_LOCAL_DATE_TIME = "localDateTime";
  @JsonProperty(JSON_PROPERTY_LOCAL_DATE_TIME)
  @JsonDeserialize(using = _OffsetDateTimeJacksonDeserializer.class)
  @JsonSerialize(using = _OffsetDateTimeJacksonSerializer.class)
  private OffsetDateTime localDateTime;

  public static final String JSON_PROPERTY_LOCAL_TIME = "localTime";
  @JsonProperty(JSON_PROPERTY_LOCAL_TIME)
  private LocalTime localTime;

  public static final String JSON_PROPERTY_OFFSET_DATE_TIME = "offsetDateTime";
  @JsonProperty(JSON_PROPERTY_OFFSET_DATE_TIME)
  @JsonDeserialize(using = _OffsetDateTimeJacksonDeserializer.class)
  @JsonSerialize(using = _OffsetDateTimeJacksonSerializer.class)
  private OffsetDateTime offsetDateTime;

  public static final String JSON_PROPERTY_ZONED_DATE_TIME = "zonedDateTime";
  @JsonProperty(JSON_PROPERTY_ZONED_DATE_TIME)
  @JsonDeserialize(using = _OffsetDateTimeJacksonDeserializer.class)
  @JsonSerialize(using = _OffsetDateTimeJacksonSerializer.class)
  private OffsetDateTime zonedDateTime;

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
        Objects.equals(this.localDate, other.localDate) &&
        Objects.equals(this.localDateTime, other.localDateTime) &&
        Objects.equals(this.localTime, other.localTime) &&
        Objects.equals(this.offsetDateTime, other.offsetDateTime) &&
        Objects.equals(this.zonedDateTime, other.zonedDateTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aBigDecimal, localDate, localDateTime, localTime, offsetDateTime, zonedDateTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpecialTypes {");
    sb.append("\n    aBigDecimal: ").append(toIndentedString(aBigDecimal));
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
