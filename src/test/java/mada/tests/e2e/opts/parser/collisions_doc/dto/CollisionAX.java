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
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.validation.Valid;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Note that A sorts alphabetically before a
 */
@JsonbPropertyOrder({
  CollisionAX.JSON_PROPERTY_A_CAPITAL_BOOLEAN,
  CollisionAX.JSON_PROPERTY_A_CAPITAL_SET,
  CollisionAX.JSON_PROPERTY_A_CAPITAL_MAP
})
@Schema(description = "Note that A sorts alphabetically before a")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class CollisionAX {
  public static final String JSON_PROPERTY_A_CAPITAL_BOOLEAN = "aCapitalBoolean";
  @JsonbProperty(JSON_PROPERTY_A_CAPITAL_BOOLEAN)
  private Boolean aCapitalBoolean;

  public static final String JSON_PROPERTY_A_CAPITAL_SET = "aCapitalSet";
  @JsonbProperty(JSON_PROPERTY_A_CAPITAL_SET)
  private Set<Collisiona> aCapitalSet = null;

  public static final String JSON_PROPERTY_A_CAPITAL_MAP = "aCapitalMap";
  @JsonbProperty(JSON_PROPERTY_A_CAPITAL_MAP)
  private Map<String, Collisiona> aCapitalMap = null;

  public CollisionAX aCapitalBoolean(Boolean aCapitalBoolean) {
    this.aCapitalBoolean = aCapitalBoolean;
    return this;
  }

  /**
   * Get aCapitalBoolean
   * @return aCapitalBoolean
   **/
  public Boolean isACapitalBoolean() {
    return aCapitalBoolean;
  }

  public void setACapitalBoolean(Boolean aCapitalBoolean) {
    this.aCapitalBoolean = aCapitalBoolean;
  }

  public CollisionAX aCapitalSet(Set<Collisiona> aCapitalSet) {
    this.aCapitalSet = aCapitalSet;
    return this;
  }

  public CollisionAX addACapitalSetItem(Collisiona aCapitalSetItem) {
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
  public Set<Collisiona> getACapitalSet() {
    return aCapitalSet;
  }

  public void setACapitalSet(Set<Collisiona> aCapitalSet) {
    this.aCapitalSet = aCapitalSet;
  }

  public CollisionAX aCapitalMap(Map<String, Collisiona> aCapitalMap) {
    this.aCapitalMap = aCapitalMap;
    return this;
  }

  public CollisionAX putACapitalMapItem(String key, Collisiona aCapitalMapItem) {
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
  public Map<String, Collisiona> getACapitalMap() {
    return aCapitalMap;
  }

  public void setACapitalMap(Map<String, Collisiona> aCapitalMap) {
    this.aCapitalMap = aCapitalMap;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CollisionAX other = (CollisionAX) o;
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
    sb.append("class CollisionAX {");
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
