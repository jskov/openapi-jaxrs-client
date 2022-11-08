/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.opts.parser.collisions_name.dto;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.validation.Valid;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Note that A sorts alphabetically before a.
 */
@JsonbPropertyOrder({
  CollisionA.JSON_PROPERTY_A_CAPITAL_BOOLEAN,
  CollisionA.JSON_PROPERTY_A_CAPITAL_SET,
  CollisionA.JSON_PROPERTY_A_CAPITAL_MAP
})
@Schema(description = "Note that A sorts alphabetically before a")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class CollisionA {
  public static final String JSON_PROPERTY_A_CAPITAL_BOOLEAN = "aCapitalBoolean";
  @JsonbProperty(JSON_PROPERTY_A_CAPITAL_BOOLEAN)
  private Boolean aCapitalBoolean;

  public static final String JSON_PROPERTY_A_CAPITAL_SET = "aCapitalSet";
  @JsonbProperty(JSON_PROPERTY_A_CAPITAL_SET)
  private Set<CollisionaX> aCapitalSet;

  public static final String JSON_PROPERTY_A_CAPITAL_MAP = "aCapitalMap";
  @JsonbProperty(JSON_PROPERTY_A_CAPITAL_MAP)
  private Map<String, CollisionaX> aCapitalMap;

  public CollisionA aCapitalBoolean(Boolean aCapitalBoolean) {
    this.aCapitalBoolean = aCapitalBoolean;
    return this;
  }

  /**
   * Get aCapitalBoolean
   * @return aCapitalBoolean
   **/
  public Boolean isaCapitalBoolean() {
    return aCapitalBoolean;
  }

  public void setaCapitalBoolean(Boolean aCapitalBoolean) {
    this.aCapitalBoolean = aCapitalBoolean;
  }

  public CollisionA aCapitalSet(Set<CollisionaX> aCapitalSet) {
    this.aCapitalSet = aCapitalSet;
    return this;
  }

  public CollisionA addaCapitalSetItem(CollisionaX aCapitalSetItem) {
    if (this.aCapitalSet == null) {
      this.aCapitalSet = new LinkedHashSet<>();
    }
    this.aCapitalSet.add(aCapitalSetItem);
    return this;
  }

  /**
   * Get aCapitalSet
   * @return aCapitalSet
   **/
  @Valid
  public Set<CollisionaX> getaCapitalSet() {
    return aCapitalSet;
  }

  public void setaCapitalSet(Set<CollisionaX> aCapitalSet) {
    this.aCapitalSet = aCapitalSet;
  }

  public CollisionA aCapitalMap(Map<String, CollisionaX> aCapitalMap) {
    this.aCapitalMap = aCapitalMap;
    return this;
  }

  public CollisionA putaCapitalMapItem(String key, CollisionaX aCapitalMapItem) {
    if (this.aCapitalMap == null) {
      this.aCapitalMap = new HashMap<>();
    }
    this.aCapitalMap.put(key, aCapitalMapItem);
    return this;
  }

  /**
   * Get aCapitalMap
   * @return aCapitalMap
   **/
  @Valid
  public Map<String, CollisionaX> getaCapitalMap() {
    return aCapitalMap;
  }

  public void setaCapitalMap(Map<String, CollisionaX> aCapitalMap) {
    this.aCapitalMap = aCapitalMap;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CollisionA)) {
      return false;
    }
    CollisionA other = (CollisionA) o;
    return Objects.equals(this.aCapitalBoolean, other.aCapitalBoolean) &&
        Objects.equals(this.aCapitalSet, other.aCapitalSet) &&
        Objects.equals(this.aCapitalMap, other.aCapitalMap);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aCapitalBoolean, aCapitalSet, aCapitalMap);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CollisionA {");
    sb.append("\n    aCapitalBoolean: ").append(toIndentedString(aCapitalBoolean));
    sb.append("\n    aCapitalSet: ").append(toIndentedString(aCapitalSet));
    sb.append("\n    aCapitalMap: ").append(toIndentedString(aCapitalMap));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
