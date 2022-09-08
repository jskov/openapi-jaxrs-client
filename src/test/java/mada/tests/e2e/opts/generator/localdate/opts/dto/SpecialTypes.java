/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.localdate.opts.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.Objects;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

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
@JsonSerialize(include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL)
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class SpecialTypes {
  public static final String JSON_PROPERTY_A_BIG_DECIMAL = "aBigDecimal";
  @JsonProperty(JSON_PROPERTY_A_BIG_DECIMAL)
  private BigDecimal aBigDecimal;

  public static final String JSON_PROPERTY_ZONED_DATE_TIME = "zonedDateTime";
  @JsonProperty(JSON_PROPERTY_ZONED_DATE_TIME)
  @JsonDeserialize(using = _OffsetDateTimeJacksonDeserializer.class)
  @JsonSerialize(using = _OffsetDateTimeJacksonSerializer.class, include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL)
  private OffsetDateTime zonedDateTime;

  public static final String JSON_PROPERTY_OFFSET_DATE_TIME = "offsetDateTime";
  @JsonProperty(JSON_PROPERTY_OFFSET_DATE_TIME)
  @JsonDeserialize(using = _OffsetDateTimeJacksonDeserializer.class)
  @JsonSerialize(using = _OffsetDateTimeJacksonSerializer.class, include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL)
  private OffsetDateTime offsetDateTime;

  public static final String JSON_PROPERTY_LOCAL_DATE_TIME = "localDateTime";
  @JsonProperty(JSON_PROPERTY_LOCAL_DATE_TIME)
  @JsonDeserialize(using = _OffsetDateTimeJacksonDeserializer.class)
  @JsonSerialize(using = _OffsetDateTimeJacksonSerializer.class, include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL)
  private OffsetDateTime localDateTime;

  public static final String JSON_PROPERTY_LOCAL_DATE = "localDate";
  @JsonProperty(JSON_PROPERTY_LOCAL_DATE)
  @JsonDeserialize(using = _LocalDateJacksonDeserializer.class)
  @JsonSerialize(using = _LocalDateJacksonSerializer.class, include = org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.NON_NULL)
  private LocalDate localDate;

  public static final String JSON_PROPERTY_LOCAL_TIME = "localTime";
  @JsonProperty(JSON_PROPERTY_LOCAL_TIME)
  private LocalTime localTime;

  public SpecialTypes aBigDecimal(BigDecimal aBigDecimal) {
    this.aBigDecimal = aBigDecimal;
    return this;
  }

  /**
   * Get aBigDecimal
   * @return aBigDecimal
   **/
  public BigDecimal getABigDecimal() {
    return aBigDecimal;
  }

  public void setABigDecimal(BigDecimal aBigDecimal) {
    this.aBigDecimal = aBigDecimal;
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
    if (o == null || getClass() != o.getClass()) {
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
