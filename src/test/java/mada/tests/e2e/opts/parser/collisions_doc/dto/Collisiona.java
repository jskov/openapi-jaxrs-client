/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.opts.parser.collisions_doc.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.validation.Valid;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Make sure this appears before CollisionA in the document
 */
@JsonbPropertyOrder({
  Collisiona.JSON_PROPERTY_A_BOOLEAN,
  Collisiona.JSON_PROPERTY_A_LIST
})
@Schema(description = "Make sure this appears before CollisionA in the document")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class Collisiona {
  public static final String JSON_PROPERTY_A_BOOLEAN = "aBoolean";
  @JsonbProperty(JSON_PROPERTY_A_BOOLEAN)
  private Boolean aBoolean;

  public static final String JSON_PROPERTY_A_LIST = "aList";
  @JsonbProperty(JSON_PROPERTY_A_LIST)
  private List<CollisionAX> aList = null;

  public Collisiona aBoolean(Boolean aBoolean) {
    this.aBoolean = aBoolean;
    return this;
  }

  /**
   * Get aBoolean
   * @return aBoolean
   **/
  public Boolean isABoolean() {
    return aBoolean;
  }

  public void setABoolean(Boolean aBoolean) {
    this.aBoolean = aBoolean;
  }

  public Collisiona aList(List<CollisionAX> aList) {
    this.aList = aList;
    return this;
  }

  public Collisiona addAListItem(CollisionAX aListItem) {
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
  public List<CollisionAX> getAList() {
    return aList;
  }

  public void setAList(List<CollisionAX> aList) {
    this.aList = aList;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Collisiona other = (Collisiona) o;
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
    sb.append("class Collisiona {");
    sb.append("\n    aBoolean: ").append(toIndentedString(aBoolean));
    sb.append("\n    aList: ").append(toIndentedString(aList));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
