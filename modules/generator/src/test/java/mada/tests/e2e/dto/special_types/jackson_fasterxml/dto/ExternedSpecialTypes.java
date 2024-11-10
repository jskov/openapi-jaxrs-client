/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.dto.special_types.jackson_fasterxml.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Objects;

/**
 * ExternedSpecialTypes
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ExternedSpecialTypes {
    public static final String JSON_PROPERTY_BIG_DECIMAL = "bigDecimal";
    @JsonProperty(JSON_PROPERTY_BIG_DECIMAL)
    private BigDecimal bigDecimal;

    public static final String JSON_PROPERTY_DATE = "date";
    @JsonProperty(JSON_PROPERTY_DATE)
    @JsonDeserialize(using = _LocalDateJacksonDeserializer.class)
    @JsonSerialize(using = _LocalDateJacksonSerializer.class)
    private LocalDate date;

    public static final String JSON_PROPERTY_DATE_TIME = "dateTime";
    @JsonProperty(JSON_PROPERTY_DATE_TIME)
    @JsonDeserialize(using = _OffsetDateTimeJacksonDeserializer.class)
    @JsonSerialize(using = _OffsetDateTimeJacksonSerializer.class)
    private OffsetDateTime dateTime;

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

    public ExternedSpecialTypes bigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
        return this;
    }

    /**
     * Get bigDecimal
     *
     * @return bigDecimal
     **/
    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

    public ExternedSpecialTypes date(LocalDate date) {
        this.date = date;
        return this;
    }

    /**
     * Get date
     *
     * @return date
     **/
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ExternedSpecialTypes dateTime(OffsetDateTime dateTime) {
        this.dateTime = dateTime;
        return this;
    }

    /**
     * Get dateTime
     *
     * @return dateTime
     **/
    public OffsetDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(OffsetDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public ExternedSpecialTypes offsetDateTime(OffsetDateTime offsetDateTime) {
        this.offsetDateTime = offsetDateTime;
        return this;
    }

    /**
     * Get offsetDateTime
     *
     * @return offsetDateTime
     **/
    public OffsetDateTime getOffsetDateTime() {
        return offsetDateTime;
    }

    public void setOffsetDateTime(OffsetDateTime offsetDateTime) {
        this.offsetDateTime = offsetDateTime;
    }

    public ExternedSpecialTypes zonedDateTime(OffsetDateTime zonedDateTime) {
        this.zonedDateTime = zonedDateTime;
        return this;
    }

    /**
     * Get zonedDateTime
     *
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
        if (!(o instanceof ExternedSpecialTypes)) {
            return false;
        }
        ExternedSpecialTypes other = (ExternedSpecialTypes) o;
        return Objects.equals(this.bigDecimal, other.bigDecimal) &&
                Objects.equals(this.date, other.date) &&
                Objects.equals(this.dateTime, other.dateTime) &&
                Objects.equals(this.offsetDateTime, other.offsetDateTime) &&
                Objects.equals(this.zonedDateTime, other.zonedDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bigDecimal, date, dateTime, offsetDateTime, zonedDateTime);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ExternedSpecialTypes {");
        sb.append("\n    bigDecimal: ").append(toIndentedString(bigDecimal));
        sb.append("\n    date: ").append(toIndentedString(date));
        sb.append("\n    dateTime: ").append(toIndentedString(dateTime));
        sb.append("\n    offsetDateTime: ").append(toIndentedString(offsetDateTime));
        sb.append("\n    zonedDateTime: ").append(toIndentedString(zonedDateTime));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
