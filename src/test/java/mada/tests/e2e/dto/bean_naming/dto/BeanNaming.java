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
  BeanNaming.JSON_PROPERTY_DOWN_BEAN,
  BeanNaming.JSON_PROPERTY_A_CAMEL_BEAN,
  BeanNaming.JSON_PROPERTY_UPPER_BEAN,
  BeanNaming.JSON_PROPERTY_DOWN_INT,
  BeanNaming.JSON_PROPERTY_A_CAMEL_INT,
  BeanNaming.JSON_PROPERTY_UPPER_INT
})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class BeanNaming {
  public static final String JSON_PROPERTY_DOWN_BEAN = "downBean";
  @JsonbProperty(JSON_PROPERTY_DOWN_BEAN)
  private Boolean downBean;

  public static final String JSON_PROPERTY_A_CAMEL_BEAN = "aCamelBean";
  @JsonbProperty(JSON_PROPERTY_A_CAMEL_BEAN)
  private Boolean aCamelBean;

  public static final String JSON_PROPERTY_UPPER_BEAN = "UpperBean";
  @JsonbProperty(JSON_PROPERTY_UPPER_BEAN)
  private Boolean upperBean;

  public static final String JSON_PROPERTY_DOWN_INT = "downInt";
  @JsonbProperty(JSON_PROPERTY_DOWN_INT)
  private Integer downInt;

  public static final String JSON_PROPERTY_A_CAMEL_INT = "aCamelInt";
  @JsonbProperty(JSON_PROPERTY_A_CAMEL_INT)
  private Integer aCamelInt;

  public static final String JSON_PROPERTY_UPPER_INT = "UpperInt";
  @JsonbProperty(JSON_PROPERTY_UPPER_INT)
  private Integer upperInt;

  public BeanNaming downBean(Boolean downBean) {
    this.downBean = downBean;
    return this;
  }

  /**
   * Get downBean
   * @return downBean
   **/
  public Boolean isDownBean() {
    return downBean;
  }

  public void setDownBean(Boolean downBean) {
    this.downBean = downBean;
  }

  public BeanNaming aCamelBean(Boolean aCamelBean) {
    this.aCamelBean = aCamelBean;
    return this;
  }

  /**
   * Get aCamelBean
   * @return aCamelBean
   **/
  public Boolean isaCamelBean() {
    return aCamelBean;
  }

  public void setaCamelBean(Boolean aCamelBean) {
    this.aCamelBean = aCamelBean;
  }

  public BeanNaming upperBean(Boolean upperBean) {
    this.upperBean = upperBean;
    return this;
  }

  /**
   * Get upperBean
   * @return upperBean
   **/
  public Boolean isUpperBean() {
    return upperBean;
  }

  public void setUpperBean(Boolean upperBean) {
    this.upperBean = upperBean;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BeanNaming)) {
      return false;
    }
    BeanNaming other = (BeanNaming) o;
    return Objects.equals(this.downBean, other.downBean) &&
        Objects.equals(this.aCamelBean, other.aCamelBean) &&
        Objects.equals(this.upperBean, other.upperBean) &&
        Objects.equals(this.downInt, other.downInt) &&
        Objects.equals(this.aCamelInt, other.aCamelInt) &&
        Objects.equals(this.upperInt, other.upperInt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(downBean, aCamelBean, upperBean, downInt, aCamelInt, upperInt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BeanNaming {");
    sb.append("\n    downBean: ").append(toIndentedString(downBean));
    sb.append("\n    aCamelBean: ").append(toIndentedString(aCamelBean));
    sb.append("\n    upperBean: ").append(toIndentedString(upperBean));
    sb.append("\n    downInt: ").append(toIndentedString(downInt));
    sb.append("\n    aCamelInt: ").append(toIndentedString(aCamelInt));
    sb.append("\n    upperInt: ").append(toIndentedString(upperInt));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
