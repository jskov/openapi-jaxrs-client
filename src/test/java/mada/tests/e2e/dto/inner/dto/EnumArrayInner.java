/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.dto.inner.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;

/**
 * EnumArrayInner
 */
@JsonbPropertyOrder({
  EnumArrayInner.JSON_PROPERTY_MULIGE_UDBETALINGS_METODER
})
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public class EnumArrayInner {
  public static final String JSON_PROPERTY_MULIGE_UDBETALINGS_METODER = "muligeUdbetalingsMetoder";
  @JsonbProperty(JSON_PROPERTY_MULIGE_UDBETALINGS_METODER)
  private List<MuligeUdbetalingsMetoderEnum> muligeUdbetalingsMetoder = null;

  public enum MuligeUdbetalingsMetoderEnum {
    HURTIGST_MULIGT
  }

  public EnumArrayInner muligeUdbetalingsMetoder(List<MuligeUdbetalingsMetoderEnum> muligeUdbetalingsMetoder) {
    this.muligeUdbetalingsMetoder = muligeUdbetalingsMetoder;
    return this;
  }

  public EnumArrayInner addMuligeUdbetalingsMetoderItem(MuligeUdbetalingsMetoderEnum muligeUdbetalingsMetoderItem) {
    if (this.muligeUdbetalingsMetoder == null) {
      this.muligeUdbetalingsMetoder = new ArrayList<>();
    }
    this.muligeUdbetalingsMetoder.add(muligeUdbetalingsMetoderItem);
    return this;
  }

  /**
   * Get muligeUdbetalingsMetoder
   * @return muligeUdbetalingsMetoder
   **/
  public List<MuligeUdbetalingsMetoderEnum> getMuligeUdbetalingsMetoder() {
    return muligeUdbetalingsMetoder;
  }

  public void setMuligeUdbetalingsMetoder(List<MuligeUdbetalingsMetoderEnum> muligeUdbetalingsMetoder) {
    this.muligeUdbetalingsMetoder = muligeUdbetalingsMetoder;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EnumArrayInner other = (EnumArrayInner) o;
    return Objects.equals(this.muligeUdbetalingsMetoder, other.muligeUdbetalingsMetoder);
  }

  @Override
  public int hashCode() {
    return Objects.hash(muligeUdbetalingsMetoder);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnumArrayInner {");
    sb.append("\n    muligeUdbetalingsMetoder: ").append(toIndentedString(muligeUdbetalingsMetoder));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
