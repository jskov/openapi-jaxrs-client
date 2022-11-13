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

  public static final String JSON_PROPERTY_A_DOUBLE = "aDouble";
  @JsonbProperty(JSON_PROPERTY_A_DOUBLE)
  private Double aDouble;

  public static final String JSON_PROPERTY_A_FLOAT = "aFloat";
  @JsonbProperty(JSON_PROPERTY_A_FLOAT)
  private Float aFloat;

  public static final String JSON_PROPERTY_A_LONG = "aLong";
  @JsonbProperty(JSON_PROPERTY_A_LONG)
  private Long aLong;

  public static final String JSON_PROPERTY_AN_INT = "anInt";
  @JsonbProperty(JSON_PROPERTY_AN_INT)
  private Integer anInt;

  public static final String JSON_PROPERTY_A_SHORT = "aShort";
  @JsonbProperty(JSON_PROPERTY_A_SHORT)
  private Short aShort;

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
  public Boolean getaBoolean() {
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

  public Primitives aDouble(Double aDouble) {
    this.aDouble = aDouble;
    return this;
  }

  /**
   * Get aDouble
   * @return aDouble
   **/
  public Double getaDouble() {
    return aDouble;
  }

  public void setaDouble(Double aDouble) {
    this.aDouble = aDouble;
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
        Objects.equals(this.aDouble, other.aDouble) &&
        Objects.equals(this.aFloat, other.aFloat) &&
        Objects.equals(this.aLong, other.aLong) &&
        Objects.equals(this.anInt, other.anInt) &&
        Objects.equals(this.aShort, other.aShort) &&
        Objects.equals(this.aString, other.aString);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aBoolean, aByte, aDouble, aFloat, aLong, anInt, aShort, aString);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Primitives {");
    sb.append("\n    aBoolean: ").append(toIndentedString(aBoolean));
    sb.append("\n    aByte: ").append(toIndentedString(aByte));
    sb.append("\n    aDouble: ").append(toIndentedString(aDouble));
    sb.append("\n    aFloat: ").append(toIndentedString(aFloat));
    sb.append("\n    aLong: ").append(toIndentedString(aLong));
    sb.append("\n    anInt: ").append(toIndentedString(anInt));
    sb.append("\n    aShort: ").append(toIndentedString(aShort));
    sb.append("\n    aString: ").append(toIndentedString(aString));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
