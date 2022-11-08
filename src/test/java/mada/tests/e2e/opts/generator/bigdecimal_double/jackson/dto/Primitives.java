/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.bigdecimal_double.jackson.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Primitives
 */
@JsonPropertyOrder({
  Primitives.JSON_PROPERTY_A_BOOLEAN,
  Primitives.JSON_PROPERTY_A_BYTE,
  Primitives.JSON_PROPERTY_A_SHORT,
  Primitives.JSON_PROPERTY_AN_INT,
  Primitives.JSON_PROPERTY_A_LONG,
  Primitives.JSON_PROPERTY_A_FLOAT,
  Primitives.JSON_PROPERTY_A_DOUBLE,
  Primitives.JSON_PROPERTY_A_STRING
})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class Primitives {
  public static final String JSON_PROPERTY_A_BOOLEAN = "aBoolean";
  @JsonProperty(JSON_PROPERTY_A_BOOLEAN)
  private Boolean aBoolean;

  public static final String JSON_PROPERTY_A_BYTE = "aByte";
  @JsonProperty(JSON_PROPERTY_A_BYTE)
  private Byte aByte;

  public static final String JSON_PROPERTY_A_SHORT = "aShort";
  @JsonProperty(JSON_PROPERTY_A_SHORT)
  private Short aShort;

  public static final String JSON_PROPERTY_AN_INT = "anInt";
  @JsonProperty(JSON_PROPERTY_AN_INT)
  private Integer anInt;

  public static final String JSON_PROPERTY_A_LONG = "aLong";
  @JsonProperty(JSON_PROPERTY_A_LONG)
  private Long aLong;

  public static final String JSON_PROPERTY_A_FLOAT = "aFloat";
  @JsonProperty(JSON_PROPERTY_A_FLOAT)
  private Float aFloat;

  public static final String JSON_PROPERTY_A_DOUBLE = "aDouble";
  @JsonProperty(JSON_PROPERTY_A_DOUBLE)
  private Double aDouble;

  public static final String JSON_PROPERTY_A_STRING = "aString";
  @JsonProperty(JSON_PROPERTY_A_STRING)
  private String aString;

  public Primitives aBoolean(Boolean aBoolean) {
    this.aBoolean = aBoolean;
    return this;
  }

  /**
   * Get aBoolean
   * @return aBoolean
   **/
  public Boolean isaBoolean() {
    return aBoolean;
  }

  public void setaBoolean(Boolean aBoolean) {
    this.aBoolean = aBoolean;
  }

  public Primitives aByte(Byte aByte) {
    this.aByte = aByte;
    return this;
  }

  /**
   * Get aByte
   * @return aByte
   **/
  public Byte getaByte() {
    return aByte;
  }

  public void setaByte(Byte aByte) {
    this.aByte = aByte;
  }

  public Primitives aShort(Short aShort) {
    this.aShort = aShort;
    return this;
  }

  /**
   * Get aShort
   * @return aShort
   **/
  public Short getaShort() {
    return aShort;
  }

  public void setaShort(Short aShort) {
    this.aShort = aShort;
  }

  public Primitives anInt(Integer anInt) {
    this.anInt = anInt;
    return this;
  }

  /**
   * Get anInt
   * @return anInt
   **/
  public Integer getAnInt() {
    return anInt;
  }

  public void setAnInt(Integer anInt) {
    this.anInt = anInt;
  }

  public Primitives aLong(Long aLong) {
    this.aLong = aLong;
    return this;
  }

  /**
   * Get aLong
   * @return aLong
   **/
  public Long getaLong() {
    return aLong;
  }

  public void setaLong(Long aLong) {
    this.aLong = aLong;
  }

  public Primitives aFloat(Float aFloat) {
    this.aFloat = aFloat;
    return this;
  }

  /**
   * Get aFloat
   * @return aFloat
   **/
  public Float getaFloat() {
    return aFloat;
  }

  public void setaFloat(Float aFloat) {
    this.aFloat = aFloat;
  }

  public Primitives aDouble(Double aDouble) {
    this.aDouble = aDouble;
    return this;
  }

  public Primitives aDouble(BigDecimal aDouble) {
    this.aDouble = aDouble == null ? null : aDouble.doubleValue();
    return this;
  }

  /**
   * Get aDouble
   * @return aDouble
   **/
  public Double getaDoubleDouble() {
    return aDouble;
  }

  @JsonIgnore
  public BigDecimal getaDouble() {
    return aDouble == null ? null : new BigDecimal(aDouble);
  }

  public void setaDoubleDouble(Double aDouble) {
    this.aDouble = aDouble;
  }

  @JsonIgnore
  public void setaDouble(BigDecimal aDouble) {
    this.aDouble = aDouble == null ? null : aDouble.doubleValue();
  }

  public Primitives aString(String aString) {
    this.aString = aString;
    return this;
  }

  /**
   * Get aString
   * @return aString
   **/
  public String getaString() {
    return aString;
  }

  public void setaString(String aString) {
    this.aString = aString;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Primitives)) {
      return false;
    }
    Primitives other = (Primitives) o;
    return Objects.equals(this.aBoolean, other.aBoolean) &&
        Objects.equals(this.aByte, other.aByte) &&
        Objects.equals(this.aShort, other.aShort) &&
        Objects.equals(this.anInt, other.anInt) &&
        Objects.equals(this.aLong, other.aLong) &&
        Objects.equals(this.aFloat, other.aFloat) &&
        Objects.equals(this.aDouble, other.aDouble) &&
        Objects.equals(this.aString, other.aString);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aBoolean, aByte, aShort, anInt, aLong, aFloat, aDouble, aString);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Primitives {");
    sb.append("\n    aBoolean: ").append(toIndentedString(aBoolean));
    sb.append("\n    aByte: ").append(toIndentedString(aByte));
    sb.append("\n    aShort: ").append(toIndentedString(aShort));
    sb.append("\n    anInt: ").append(toIndentedString(anInt));
    sb.append("\n    aLong: ").append(toIndentedString(aLong));
    sb.append("\n    aFloat: ").append(toIndentedString(aFloat));
    sb.append("\n    aDouble: ").append(toIndentedString(aDouble));
    sb.append("\n    aString: ").append(toIndentedString(aString));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
