/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.opts.parser.collisions_doc.dto;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.Valid;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Note that A sorts alphabetically before a.
 */
@Schema(description = "Note that A sorts alphabetically before a")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class CollisionAX {
  public static final String JSON_PROPERTY_A_CAPITAL_BOOLEAN = "aCapitalBoolean";
  @JsonbProperty(JSON_PROPERTY_A_CAPITAL_BOOLEAN)
  private Boolean aCapitalBoolean;

  public static final String JSON_PROPERTY_A_CAPITAL_MAP = "aCapitalMap";
  @JsonbProperty(JSON_PROPERTY_A_CAPITAL_MAP)
  private Map<String, Collisiona> aCapitalMap;

  public static final String JSON_PROPERTY_A_CAPITAL_SET = "aCapitalSet";
  @JsonbProperty(JSON_PROPERTY_A_CAPITAL_SET)
  private Set<Collisiona> aCapitalSet;

  public CollisionAX aCapitalBoolean(Boolean aCapitalBoolean) {
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

  public CollisionAX aCapitalMap(Map<String, Collisiona> aCapitalMap) {
    this.aCapitalMap = aCapitalMap;
    return this;
  }

  public CollisionAX putaCapitalMapItem(String key, Collisiona aCapitalMapItem) {
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
  public Map<String, Collisiona> getaCapitalMap() {
    return aCapitalMap;
  }

  public void setaCapitalMap(Map<String, Collisiona> aCapitalMap) {
    this.aCapitalMap = aCapitalMap;
  }

  public CollisionAX aCapitalSet(Set<Collisiona> aCapitalSet) {
    this.aCapitalSet = aCapitalSet;
    return this;
  }

  public CollisionAX addaCapitalSetItem(Collisiona aCapitalSetItem) {
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
  public Set<Collisiona> getaCapitalSet() {
    return aCapitalSet;
  }

  public void setaCapitalSet(Set<Collisiona> aCapitalSet) {
    this.aCapitalSet = aCapitalSet;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof CollisionAX)) {
      return false;
    }
    CollisionAX other = (CollisionAX) o;
    return Objects.equals(this.aCapitalBoolean, other.aCapitalBoolean) &&
        Objects.equals(this.aCapitalMap, other.aCapitalMap) &&
        Objects.equals(this.aCapitalSet, other.aCapitalSet);
  }

  @Override
  public int hashCode() {
    return Objects.hash(aCapitalBoolean, aCapitalMap, aCapitalSet);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CollisionAX {");
    sb.append("\n    aCapitalBoolean: ").append(toIndentedString(aCapitalBoolean));
    sb.append("\n    aCapitalMap: ").append(toIndentedString(aCapitalMap));
    sb.append("\n    aCapitalSet: ").append(toIndentedString(aCapitalSet));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
