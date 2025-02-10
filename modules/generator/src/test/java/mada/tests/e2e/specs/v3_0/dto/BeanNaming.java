/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.specs.v3_0.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;

/**
 * BeanNaming
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class BeanNaming {
  public static final String JSON_PROPERTY_A_CAMEL_BOOL = "aCamelBool";
  @JsonbProperty(JSON_PROPERTY_A_CAMEL_BOOL)
  private Boolean aCamelBool;

  public static final String JSON_PROPERTY_A_CAMEL_INT = "aCamelInt";
  @JsonbProperty(JSON_PROPERTY_A_CAMEL_INT)
  private Integer aCamelInt;

  public static final String JSON_PROPERTY_ALLCAPSBOOL = "ALLCAPSBOOL";
  @JsonbProperty(JSON_PROPERTY_ALLCAPSBOOL)
  private Boolean aLLCAPSBOOL;

  public static final String JSON_PROPERTY_ALLCAPSINT = "ALLCAPSINT";
  @JsonbProperty(JSON_PROPERTY_ALLCAPSINT)
  private Boolean aLLCAPSINT;

  public static final String JSON_PROPERTY_DOWN_BOOL = "downBool";
  @JsonbProperty(JSON_PROPERTY_DOWN_BOOL)
  private Boolean downBool;

  public static final String JSON_PROPERTY_DOWN_INT = "downInt";
  @JsonbProperty(JSON_PROPERTY_DOWN_INT)
  private Integer downInt;

  public static final String JSON_PROPERTY_UPPER_BOOL = "UpperBool";
  @JsonbProperty(JSON_PROPERTY_UPPER_BOOL)
  private Boolean upperBool;

  public static final String JSON_PROPERTY_UPPER_INT = "UpperInt";
  @JsonbProperty(JSON_PROPERTY_UPPER_INT)
  private Integer upperInt;

  public BeanNaming aCamelBool(Boolean aCamelBool) {
    this.aCamelBool = aCamelBool;
    return this;
  }

  /**
   * Get aCamelBool
   * @return aCamelBool
   **/
  public Boolean isaCamelBool() {
    return aCamelBool;
  }

  public void setaCamelBool(Boolean aCamelBool) {
    this.aCamelBool = aCamelBool;
  }

  public BeanNaming aCamelInt(Integer aCamelInt) {
    this.aCamelInt = aCamelInt;
    return this;
  }

  /**
   * Get aCamelInt
   * @return aCamelInt
   **/
  public Integer getaCamelInt() {
    return aCamelInt;
  }

  public void setaCamelInt(Integer aCamelInt) {
    this.aCamelInt = aCamelInt;
  }

  public BeanNaming aLLCAPSBOOL(Boolean aLLCAPSBOOL) {
    this.aLLCAPSBOOL = aLLCAPSBOOL;
    return this;
  }

  /**
   * Get aLLCAPSBOOL
   * @return aLLCAPSBOOL
   **/
  public Boolean isaLLCAPSBOOL() {
    return aLLCAPSBOOL;
  }

  public void setaLLCAPSBOOL(Boolean aLLCAPSBOOL) {
    this.aLLCAPSBOOL = aLLCAPSBOOL;
  }

  public BeanNaming aLLCAPSINT(Boolean aLLCAPSINT) {
    this.aLLCAPSINT = aLLCAPSINT;
    return this;
  }

  /**
   * Get aLLCAPSINT
   * @return aLLCAPSINT
   **/
  public Boolean isaLLCAPSINT() {
    return aLLCAPSINT;
  }

  public void setaLLCAPSINT(Boolean aLLCAPSINT) {
    this.aLLCAPSINT = aLLCAPSINT;
  }

  public BeanNaming downBool(Boolean downBool) {
    this.downBool = downBool;
    return this;
  }

  /**
   * Get downBool
   * @return downBool
   **/
  public Boolean isDownBool() {
    return downBool;
  }

  public void setDownBool(Boolean downBool) {
    this.downBool = downBool;
  }

  public BeanNaming downInt(Integer downInt) {
    this.downInt = downInt;
    return this;
  }

  /**
   * Get downInt
   * @return downInt
   **/
  public Integer getDownInt() {
    return downInt;
  }

  public void setDownInt(Integer downInt) {
    this.downInt = downInt;
  }

  public BeanNaming upperBool(Boolean upperBool) {
    this.upperBool = upperBool;
    return this;
  }

  /**
   * Get upperBool
   * @return upperBool
   **/
  public Boolean isUpperBool() {
    return upperBool;
  }

  public void setUpperBool(Boolean upperBool) {
    this.upperBool = upperBool;
  }

  public BeanNaming upperInt(Integer upperInt) {
    this.upperInt = upperInt;
    return this;
  }

  /**
   * Get upperInt
   * @return upperInt
   **/
  public Integer getUpperInt() {
    return upperInt;
  }

  public void setUpperInt(Integer upperInt) {
    this.upperInt = upperInt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BeanNaming)) {
      return false;
    }
    BeanNaming other = (BeanNaming) o;
    return Objects.equals(this.aCamelBool, other.aCamelBool) &&
        Objects.equals(this.aCamelInt, other.aCamelInt) &&
        Objects.equals(this.aLLCAPSBOOL, other.aLLCAPSBOOL) &&
        Objects.equals(this.aLLCAPSINT, other.aLLCAPSINT) &&
        Objects.equals(this.downBool, other.downBool) &&
        Objects.equals(this.downInt, other.downInt) &&
        Objects.equals(this.upperBool, other.upperBool) &&
        Objects.equals(this.upperInt, other.upperInt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aCamelBool, aCamelInt, aLLCAPSBOOL, aLLCAPSINT, downBool, downInt, upperBool, upperInt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BeanNaming {");
    sb.append("\n    aCamelBool: ").append(toIndentedString(aCamelBool));
    sb.append("\n    aCamelInt: ").append(toIndentedString(aCamelInt));
    sb.append("\n    aLLCAPSBOOL: ").append(toIndentedString(aLLCAPSBOOL));
    sb.append("\n    aLLCAPSINT: ").append(toIndentedString(aLLCAPSINT));
    sb.append("\n    downBool: ").append(toIndentedString(downBool));
    sb.append("\n    downInt: ").append(toIndentedString(downInt));
    sb.append("\n    upperBool: ").append(toIndentedString(upperBool));
    sb.append("\n    upperInt: ").append(toIndentedString(upperInt));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
