/*
 *
 *
 * The version of the OpenAPI document:
 */

package mada.tests.e2e.dto.bean_naming.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;

/**
 * BeanNaming
 */
@JsonbPropertyOrder({
  BeanNaming.JSON_PROPERTY_DOWN_BOOL,
  BeanNaming.JSON_PROPERTY_A_CAMEL_BOOL,
  BeanNaming.JSON_PROPERTY_UPPER_BOOL,
  BeanNaming.JSON_PROPERTY_A_LLCAPSBOOL,
  BeanNaming.JSON_PROPERTY_DOWN_INT,
  BeanNaming.JSON_PROPERTY_A_CAMEL_INT,
  BeanNaming.JSON_PROPERTY_UPPER_INT,
  BeanNaming.JSON_PROPERTY_A_LLCAPSINT
})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class BeanNaming {
  public static final String JSON_PROPERTY_DOWN_BOOL = "downBool";
  @JsonbProperty(JSON_PROPERTY_DOWN_BOOL)
  private Boolean downBool;

  public static final String JSON_PROPERTY_A_CAMEL_BOOL = "aCamelBool";
  @JsonbProperty(JSON_PROPERTY_A_CAMEL_BOOL)
  private Boolean aCamelBool;

  public static final String JSON_PROPERTY_UPPER_BOOL = "UpperBool";
  @JsonbProperty(JSON_PROPERTY_UPPER_BOOL)
  private Boolean upperBool;

  public static final String JSON_PROPERTY_A_LLCAPSBOOL = "ALLCAPSBOOL";
  @JsonbProperty(JSON_PROPERTY_A_LLCAPSBOOL)
  private Boolean aLLCAPSBOOL;

  public static final String JSON_PROPERTY_DOWN_INT = "downInt";
  @JsonbProperty(JSON_PROPERTY_DOWN_INT)
  private Integer downInt;

  public static final String JSON_PROPERTY_A_CAMEL_INT = "aCamelInt";
  @JsonbProperty(JSON_PROPERTY_A_CAMEL_INT)
  private Integer aCamelInt;

  public static final String JSON_PROPERTY_UPPER_INT = "UpperInt";
  @JsonbProperty(JSON_PROPERTY_UPPER_INT)
  private Integer upperInt;

  public static final String JSON_PROPERTY_A_LLCAPSINT = "ALLCAPSINT";
  @JsonbProperty(JSON_PROPERTY_A_LLCAPSINT)
  private Boolean aLLCAPSINT;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BeanNaming)) {
      return false;
    }
    BeanNaming other = (BeanNaming) o;
    return Objects.equals(this.downBool, other.downBool) &&
        Objects.equals(this.aCamelBool, other.aCamelBool) &&
        Objects.equals(this.upperBool, other.upperBool) &&
        Objects.equals(this.aLLCAPSBOOL, other.aLLCAPSBOOL) &&
        Objects.equals(this.downInt, other.downInt) &&
        Objects.equals(this.aCamelInt, other.aCamelInt) &&
        Objects.equals(this.upperInt, other.upperInt) &&
        Objects.equals(this.aLLCAPSINT, other.aLLCAPSINT);
  }

  @Override
  public int hashCode() {
    return Objects.hash(downBool, aCamelBool, upperBool, aLLCAPSBOOL, downInt, aCamelInt, upperInt, aLLCAPSINT);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BeanNaming {");
    sb.append("\n    downBool: ").append(toIndentedString(downBool));
    sb.append("\n    aCamelBool: ").append(toIndentedString(aCamelBool));
    sb.append("\n    upperBool: ").append(toIndentedString(upperBool));
    sb.append("\n    aLLCAPSBOOL: ").append(toIndentedString(aLLCAPSBOOL));
    sb.append("\n    downInt: ").append(toIndentedString(downInt));
    sb.append("\n    aCamelInt: ").append(toIndentedString(aCamelInt));
    sb.append("\n    upperInt: ").append(toIndentedString(upperInt));
    sb.append("\n    aLLCAPSINT: ").append(toIndentedString(aLLCAPSINT));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
