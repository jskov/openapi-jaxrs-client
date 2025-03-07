/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.opts.parser.collisions_name.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.Valid;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Make sure this appears before CollisionA in the document.
 */
@Schema(description = "Make sure this appears before CollisionA in the document")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class CollisionaX {
  public static final String JSON_PROPERTY_A_BOOLEAN = "aBoolean";
  @JsonbProperty(JSON_PROPERTY_A_BOOLEAN)
  private Boolean aBoolean;

  public static final String JSON_PROPERTY_A_LIST = "aList";
  @JsonbProperty(JSON_PROPERTY_A_LIST)
  private List<CollisionA> aList;

  public CollisionaX aBoolean(Boolean aBoolean) {
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

  public CollisionaX aList(List<CollisionA> aList) {
    this.aList = aList;
    return this;
  }

  public CollisionaX addaListItem(CollisionA aListItem) {
    if (this.aList == null) {
      this.aList = new ArrayList<>();
    }
    this.aList.add(aListItem);
    return this;
  }

  /**
   * Get aList
   * @return aList
   **/
  @Valid
  public List<CollisionA> getaList() {
    return aList;
  }

  public void setaList(List<CollisionA> aList) {
    this.aList = aList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CollisionaX)) {
      return false;
    }
    CollisionaX other = (CollisionaX) o;
    return Objects.equals(this.aBoolean, other.aBoolean) &&
        Objects.equals(this.aList, other.aList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aBoolean, aList);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CollisionaX {");
    sb.append("\n    aBoolean: ").append(toIndentedString(aBoolean));
    sb.append("\n    aList: ").append(toIndentedString(aList));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
