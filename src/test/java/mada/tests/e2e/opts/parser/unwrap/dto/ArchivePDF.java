/*
 * Test
 *
 * The version of the OpenAPI document: 1.0.0
 */

package mada.tests.e2e.opts.parser.unwrap.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;

/**
 * ArchivePDF
 */
@JsonbPropertyOrder({
  ArchivePDF.JSON_PROPERTY_STRING_LIST,
  ArchivePDF.JSON_PROPERTY_BYTE_LIST
})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ArchivePDF {
  public static final String JSON_PROPERTY_STRING_LIST = "stringList";
  @JsonbProperty(JSON_PROPERTY_STRING_LIST)
  private List<String> stringList;

  public static final String JSON_PROPERTY_BYTE_LIST = "byteList";
  @JsonbProperty(JSON_PROPERTY_BYTE_LIST)
  private byte[] byteList;

  public ArchivePDF stringList(List<String> stringList) {
    this.stringList = stringList;
    return this;
  }

  public ArchivePDF addStringListItem(String stringListItem) {
    if (this.stringList == null) {
      this.stringList = new ArrayList<>();
    }
    this.stringList.add(stringListItem);
    return this;
  }

  /**
   * Get stringList
   * @return stringList
   **/
  public List<String> getStringList() {
    return stringList;
  }

  public void setStringList(List<String> stringList) {
    this.stringList = stringList;
  }

  public ArchivePDF byteList(byte[] byteList) {
    this.byteList = byteList;
    return this;
  }

  /**
   * Get byteList
   * @return byteList
   **/
  public byte[] getByteList() {
    return byteList;
  }

  public void setByteList(byte[] byteList) {
    this.byteList = byteList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArchivePDF other = (ArchivePDF) o;
    return Objects.equals(this.stringList, other.stringList) &&
        Arrays.equals(this.byteList, other.byteList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(stringList, Arrays.hashCode(byteList));
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ArchivePDF {");
    sb.append("\n    stringList: ").append(toIndentedString(stringList));
    sb.append("\n    byteList: ").append(toIndentedString(byteList));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
