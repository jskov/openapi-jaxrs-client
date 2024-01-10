/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.tostring_flat.dto;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.Valid;

/**
 * ExternedLists
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ExternedLists {
  public static final String JSON_PROPERTY_LIST_DATE = "listDate";
  @JsonbProperty(JSON_PROPERTY_LIST_DATE)
  private List<LocalDate> listDate;

  public static final String JSON_PROPERTY_LIST_DATE_TIME = "listDateTime";
  @JsonbProperty(JSON_PROPERTY_LIST_DATE_TIME)
  private List<OffsetDateTime> listDateTime;

  public static final String JSON_PROPERTY_LIST_INT = "listInt";
  @JsonbProperty(JSON_PROPERTY_LIST_INT)
  private List<Integer> listInt;

  public static final String JSON_PROPERTY_LIST_SIMPLE = "listSimple";
  @JsonbProperty(JSON_PROPERTY_LIST_SIMPLE)
  private List<Simple> listSimple;

  public static final String JSON_PROPERTY_LIST_STRING = "listString";
  @JsonbProperty(JSON_PROPERTY_LIST_STRING)
  private List<String> listString;

  public ExternedLists listDate(List<LocalDate> listDate) {
    this.listDate = listDate;
    return this;
  }

  public ExternedLists addListDateItem(LocalDate listDateItem) {
    if (this.listDate == null) {
      this.listDate = new ArrayList<>();
    }
    this.listDate.add(listDateItem);
    return this;
  }

  /**
   * Get listDate
   * @return listDate
   **/
  public List<LocalDate> getListDate() {
    return listDate;
  }

  public void setListDate(List<LocalDate> listDate) {
    this.listDate = listDate;
  }

  public ExternedLists listDateTime(List<OffsetDateTime> listDateTime) {
    this.listDateTime = listDateTime;
    return this;
  }

  public ExternedLists addListDateTimeItem(OffsetDateTime listDateTimeItem) {
    if (this.listDateTime == null) {
      this.listDateTime = new ArrayList<>();
    }
    this.listDateTime.add(listDateTimeItem);
    return this;
  }

  /**
   * Get listDateTime
   * @return listDateTime
   **/
  public List<OffsetDateTime> getListDateTime() {
    return listDateTime;
  }

  public void setListDateTime(List<OffsetDateTime> listDateTime) {
    this.listDateTime = listDateTime;
  }

  public ExternedLists listInt(List<Integer> listInt) {
    this.listInt = listInt;
    return this;
  }

  public ExternedLists addListIntItem(int listIntItem) {
    if (this.listInt == null) {
      this.listInt = new ArrayList<>();
    }
    this.listInt.add(listIntItem);
    return this;
  }

  /**
   * Get listInt
   * @return listInt
   **/
  public List<Integer> getListInt() {
    return listInt;
  }

  public void setListInt(List<Integer> listInt) {
    this.listInt = listInt;
  }

  public ExternedLists listSimple(List<Simple> listSimple) {
    this.listSimple = listSimple;
    return this;
  }

  public ExternedLists addListSimpleItem(Simple listSimpleItem) {
    if (this.listSimple == null) {
      this.listSimple = new ArrayList<>();
    }
    this.listSimple.add(listSimpleItem);
    return this;
  }

  /**
   * Get listSimple
   * @return listSimple
   **/
  @Valid
  public List<Simple> getListSimple() {
    return listSimple;
  }

  public void setListSimple(List<Simple> listSimple) {
    this.listSimple = listSimple;
  }

  public ExternedLists listString(List<String> listString) {
    this.listString = listString;
    return this;
  }

  public ExternedLists addListStringItem(String listStringItem) {
    if (this.listString == null) {
      this.listString = new ArrayList<>();
    }
    this.listString.add(listStringItem);
    return this;
  }

  /**
   * Get listString
   * @return listString
   **/
  public List<String> getListString() {
    return listString;
  }

  public void setListString(List<String> listString) {
    this.listString = listString;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ExternedLists)) {
      return false;
    }
    ExternedLists other = (ExternedLists) o;
    return Objects.equals(this.listDate, other.listDate) &&
        Objects.equals(this.listDateTime, other.listDateTime) &&
        Objects.equals(this.listInt, other.listInt) &&
        Objects.equals(this.listSimple, other.listSimple) &&
        Objects.equals(this.listString, other.listString);
  }

  @Override
  public int hashCode() {
    return Objects.hash(listDate, listDateTime, listInt, listSimple, listString);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ExternedLists {");
    sb.append("\n    listDate: ").append(toIndentedString(listDate));
    sb.append("\n    listDateTime: ").append(toIndentedString(listDateTime));
    sb.append("\n    listInt: ").append(toIndentedString(listInt));
    sb.append("\n    listSimple: ").append(toIndentedString(listSimple));
    sb.append("\n    listString: ").append(toIndentedString(listString));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
