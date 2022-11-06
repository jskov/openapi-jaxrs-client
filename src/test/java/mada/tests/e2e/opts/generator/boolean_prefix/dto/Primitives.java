/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.boolean_prefix.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;

/**
 * Primitives
 */
@JsonbPropertyOrder({
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
  @JsonbProperty(JSON_PROPERTY_A_BOOLEAN)
  private Boolean aBoolean;

  public static final String JSON_PROPERTY_A_BYTE = "aByte";
  @JsonbProperty(JSON_PROPERTY_A_BYTE)
  private Byte aByte;

  public static final String JSON_PROPERTY_A_SHORT = "aShort";
  @JsonbProperty(JSON_PROPERTY_A_SHORT)
  private Short aShort;

  public static final String JSON_PROPERTY_AN_INT = "anInt";
  @JsonbProperty(JSON_PROPERTY_AN_INT)
  private Integer anInt;

  public static final String JSON_PROPERTY_A_LONG = "aLong";
  @JsonbProperty(JSON_PROPERTY_A_LONG)
  private Long aLong;

  public static final String JSON_PROPERTY_A_FLOAT = "aFloat";
  @JsonbProperty(JSON_PROPERTY_A_FLOAT)
  private Float aFloat;

  public static final String JSON_PROPERTY_A_DOUBLE = "aDouble";
  @JsonbProperty(JSON_PROPERTY_A_DOUBLE)
  private Double aDouble;

  public static final String JSON_PROPERTY_A_STRING = "aString";
  @JsonbProperty(JSON_PROPERTY_A_STRING)
  private String aString;

  public Primitives aBoolean(Boolean aBoolean) {
    this.aBoolean = aBoolean;
    return this;
  }

  /**
   * Get aBoolean
   * @return aBoolean
   **/
  public Boolean getABoolean() {
    return aBoolean;
  }

  public void setABoolean(Boolean aBoolean) {
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
  public Byte getAByte() {
    return aByte;
  }

  public void setAByte(Byte aByte) {
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
  public Short getAShort() {
    return aShort;
  }

  public void setAShort(Short aShort) {
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
  public Long getALong() {
    return aLong;
  }

  public void setALong(Long aLong) {
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
  public Float getAFloat() {
    return aFloat;
  }

  public void setAFloat(Float aFloat) {
    this.aFloat = aFloat;
  }

  public Primitives aDouble(Double aDouble) {
    this.aDouble = aDouble;
    return this;
  }

  /**
   * Get aDouble
   * @return aDouble
   **/
  public Double getADouble() {
    return aDouble;
  }

  public void setADouble(Double aDouble) {
    this.aDouble = aDouble;
  }

  public Primitives aString(String aString) {
    this.aString = aString;
    return this;
  }

  /**
   * Get aString
   * @return aString
   **/
  public String getAString() {
    return aString;
  }

  public void setAString(String aString) {
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
