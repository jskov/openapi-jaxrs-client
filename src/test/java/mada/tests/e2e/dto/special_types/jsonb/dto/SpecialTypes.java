/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.dto.special_types.jsonb.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;

/**
 * SpecialTypes
 */
@JsonbPropertyOrder({
  SpecialTypes.JSON_PROPERTY_BIG_DECIMAL,
  SpecialTypes.JSON_PROPERTY_ZONED_DATE_TIME,
  SpecialTypes.JSON_PROPERTY_OFFSET_DATE_TIME,
  SpecialTypes.JSON_PROPERTY_LOCAL_DATE_TIME,
  SpecialTypes.JSON_PROPERTY_LOCAL_DATE,
  SpecialTypes.JSON_PROPERTY_LOCAL_TIME,
  SpecialTypes.JSON_PROPERTY_UUID
})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class SpecialTypes {
  public static final String JSON_PROPERTY_BIG_DECIMAL = "bigDecimal";
  @JsonbProperty(JSON_PROPERTY_BIG_DECIMAL)
  private BigDecimal bigDecimal;

  public static final String JSON_PROPERTY_ZONED_DATE_TIME = "zonedDateTime";
  @JsonbProperty(JSON_PROPERTY_ZONED_DATE_TIME)
  private OffsetDateTime zonedDateTime;

  public static final String JSON_PROPERTY_OFFSET_DATE_TIME = "offsetDateTime";
  @JsonbProperty(JSON_PROPERTY_OFFSET_DATE_TIME)
  private OffsetDateTime offsetDateTime;

  public static final String JSON_PROPERTY_LOCAL_DATE_TIME = "localDateTime";
  @JsonbProperty(JSON_PROPERTY_LOCAL_DATE_TIME)
  private OffsetDateTime localDateTime;

  public static final String JSON_PROPERTY_LOCAL_DATE = "localDate";
  @JsonbProperty(JSON_PROPERTY_LOCAL_DATE)
  private LocalDate localDate;

  public static final String JSON_PROPERTY_LOCAL_TIME = "localTime";
  @JsonbProperty(JSON_PROPERTY_LOCAL_TIME)
  private LocalTime localTime;

  public static final String JSON_PROPERTY_UUID = "uuid";
  @JsonbProperty(JSON_PROPERTY_UUID)
  private UUID uuid;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SpecialTypes other = (SpecialTypes) o;
    return Objects.equals(this.bigDecimal, other.bigDecimal) &&
        Objects.equals(this.zonedDateTime, other.zonedDateTime) &&
        Objects.equals(this.offsetDateTime, other.offsetDateTime) &&
        Objects.equals(this.localDateTime, other.localDateTime) &&
        Objects.equals(this.localDate, other.localDate) &&
        Objects.equals(this.localTime, other.localTime) &&
        Objects.equals(this.uuid, other.uuid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bigDecimal, zonedDateTime, offsetDateTime, localDateTime, localDate, localTime, uuid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SpecialTypes {");
    sb.append("\n    bigDecimal: ").append(toIndentedString(bigDecimal));
    sb.append("\n    zonedDateTime: ").append(toIndentedString(zonedDateTime));
    sb.append("\n    offsetDateTime: ").append(toIndentedString(offsetDateTime));
    sb.append("\n    localDateTime: ").append(toIndentedString(localDateTime));
    sb.append("\n    localDate: ").append(toIndentedString(localDate));
    sb.append("\n    localTime: ").append(toIndentedString(localTime));
    sb.append("\n    uuid: ").append(toIndentedString(uuid));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
