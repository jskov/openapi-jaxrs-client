/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.specs.v3_0.dto;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * SetsDto
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class SetsDto {
  public static final String JSON_PROPERTY_BOOLEANS = "booleans";
  @JsonbProperty(JSON_PROPERTY_BOOLEANS)
  private Set<Boolean> booleans;

  public static final String JSON_PROPERTY_BYTES = "bytes";
  @JsonbProperty(JSON_PROPERTY_BYTES)
  private Set<Byte> bytes;

  public static final String JSON_PROPERTY_INTS = "ints";
  @JsonbProperty(JSON_PROPERTY_INTS)
  private Set<Integer> ints;

  public static final String JSON_PROPERTY_LONGS = "longs";
  @JsonbProperty(JSON_PROPERTY_LONGS)
  private Set<Long> longs;

  public static final String JSON_PROPERTY_REFS = "refs";
  @JsonbProperty(JSON_PROPERTY_REFS)
  private Set<Simple> refs;

  public static final String JSON_PROPERTY_REQUIRED_BOOLEANS = "requiredBooleans";
  @JsonbProperty(JSON_PROPERTY_REQUIRED_BOOLEANS)
  @Schema(required = true)
  private Set<Boolean> requiredBooleans = new LinkedHashSet<>();

  public static final String JSON_PROPERTY_REQUIRED_BYTES = "requiredBytes";
  @JsonbProperty(JSON_PROPERTY_REQUIRED_BYTES)
  @Schema(required = true)
  private Set<Byte> requiredBytes = new LinkedHashSet<>();

  public static final String JSON_PROPERTY_REQUIRED_INTS = "requiredInts";
  @JsonbProperty(JSON_PROPERTY_REQUIRED_INTS)
  @Schema(required = true)
  private Set<Integer> requiredInts = new LinkedHashSet<>();

  public static final String JSON_PROPERTY_REQUIRED_LONGS = "requiredLongs";
  @JsonbProperty(JSON_PROPERTY_REQUIRED_LONGS)
  @Schema(required = true)
  private Set<Long> requiredLongs = new LinkedHashSet<>();

  public static final String JSON_PROPERTY_REQUIRED_REFS = "requiredRefs";
  @JsonbProperty(JSON_PROPERTY_REQUIRED_REFS)
  @Schema(required = true)
  private Set<Simple> requiredRefs = new LinkedHashSet<>();

  public static final String JSON_PROPERTY_REQUIRED_SHORTS = "requiredShorts";
  @JsonbProperty(JSON_PROPERTY_REQUIRED_SHORTS)
  @Schema(required = true)
  private Set<Short> requiredShorts = new LinkedHashSet<>();

  public static final String JSON_PROPERTY_REQUIRED_STRINGS = "requiredStrings";
  @JsonbProperty(JSON_PROPERTY_REQUIRED_STRINGS)
  @Schema(required = true)
  private Set<String> requiredStrings = new LinkedHashSet<>();

  public static final String JSON_PROPERTY_SHORTS = "shorts";
  @JsonbProperty(JSON_PROPERTY_SHORTS)
  private Set<Short> shorts;

  public static final String JSON_PROPERTY_STRINGS = "strings";
  @JsonbProperty(JSON_PROPERTY_STRINGS)
  private Set<String> strings;

  public SetsDto booleans(Set<Boolean> booleans) {
    this.booleans = booleans;
    return this;
  }

  public SetsDto addBooleansItem(boolean booleansItem) {
    if (this.booleans == null) {
      this.booleans = new LinkedHashSet<>();
    }
    this.booleans.add(booleansItem);
    return this;
  }

  /**
   * Get booleans
   * @return booleans
   **/
  public Set<Boolean> getBooleans() {
    return booleans;
  }

  public void setBooleans(Set<Boolean> booleans) {
    this.booleans = booleans;
  }

  public SetsDto bytes(Set<Byte> bytes) {
    this.bytes = bytes;
    return this;
  }

  public SetsDto addBytesItem(byte bytesItem) {
    if (this.bytes == null) {
      this.bytes = new LinkedHashSet<>();
    }
    this.bytes.add(bytesItem);
    return this;
  }

  /**
   * Get bytes
   * @return bytes
   **/
  public Set<Byte> getBytes() {
    return bytes;
  }

  public void setBytes(Set<Byte> bytes) {
    this.bytes = bytes;
  }

  public SetsDto ints(Set<Integer> ints) {
    this.ints = ints;
    return this;
  }

  public SetsDto addIntsItem(int intsItem) {
    if (this.ints == null) {
      this.ints = new LinkedHashSet<>();
    }
    this.ints.add(intsItem);
    return this;
  }

  /**
   * Get ints
   * @return ints
   **/
  public Set<Integer> getInts() {
    return ints;
  }

  public void setInts(Set<Integer> ints) {
    this.ints = ints;
  }

  public SetsDto longs(Set<Long> longs) {
    this.longs = longs;
    return this;
  }

  public SetsDto addLongsItem(long longsItem) {
    if (this.longs == null) {
      this.longs = new LinkedHashSet<>();
    }
    this.longs.add(longsItem);
    return this;
  }

  /**
   * Get longs
   * @return longs
   **/
  public Set<Long> getLongs() {
    return longs;
  }

  public void setLongs(Set<Long> longs) {
    this.longs = longs;
  }

  public SetsDto refs(Set<Simple> refs) {
    this.refs = refs;
    return this;
  }

  public SetsDto addRefsItem(Simple refsItem) {
    if (this.refs == null) {
      this.refs = new LinkedHashSet<>();
    }
    this.refs.add(refsItem);
    return this;
  }

  /**
   * Get refs
   * @return refs
   **/
  @Valid
  public Set<Simple> getRefs() {
    return refs;
  }

  public void setRefs(Set<Simple> refs) {
    this.refs = refs;
  }

  public SetsDto requiredBooleans(Set<Boolean> requiredBooleans) {
    this.requiredBooleans = Objects.requireNonNull(requiredBooleans, "Property requiredBooleans is required, cannot be null");
    return this;
  }

  public SetsDto addRequiredBooleansItem(boolean requiredBooleansItem) {
    this.requiredBooleans.add(requiredBooleansItem);
    return this;
  }

  /**
   * Get requiredBooleans
   * @return requiredBooleans
   **/
  @NotNull
  public Set<Boolean> getRequiredBooleans() {
    return requiredBooleans;
  }

  public void setRequiredBooleans(Set<Boolean> requiredBooleans) {
    this.requiredBooleans = Objects.requireNonNull(requiredBooleans, "Property requiredBooleans is required, cannot be null");
  }

  public SetsDto requiredBytes(Set<Byte> requiredBytes) {
    this.requiredBytes = Objects.requireNonNull(requiredBytes, "Property requiredBytes is required, cannot be null");
    return this;
  }

  public SetsDto addRequiredBytesItem(byte requiredBytesItem) {
    this.requiredBytes.add(requiredBytesItem);
    return this;
  }

  /**
   * Get requiredBytes
   * @return requiredBytes
   **/
  @NotNull
  public Set<Byte> getRequiredBytes() {
    return requiredBytes;
  }

  public void setRequiredBytes(Set<Byte> requiredBytes) {
    this.requiredBytes = Objects.requireNonNull(requiredBytes, "Property requiredBytes is required, cannot be null");
  }

  public SetsDto requiredInts(Set<Integer> requiredInts) {
    this.requiredInts = Objects.requireNonNull(requiredInts, "Property requiredInts is required, cannot be null");
    return this;
  }

  public SetsDto addRequiredIntsItem(int requiredIntsItem) {
    this.requiredInts.add(requiredIntsItem);
    return this;
  }

  /**
   * Get requiredInts
   * @return requiredInts
   **/
  @NotNull
  public Set<Integer> getRequiredInts() {
    return requiredInts;
  }

  public void setRequiredInts(Set<Integer> requiredInts) {
    this.requiredInts = Objects.requireNonNull(requiredInts, "Property requiredInts is required, cannot be null");
  }

  public SetsDto requiredLongs(Set<Long> requiredLongs) {
    this.requiredLongs = Objects.requireNonNull(requiredLongs, "Property requiredLongs is required, cannot be null");
    return this;
  }

  public SetsDto addRequiredLongsItem(long requiredLongsItem) {
    this.requiredLongs.add(requiredLongsItem);
    return this;
  }

  /**
   * Get requiredLongs
   * @return requiredLongs
   **/
  @NotNull
  public Set<Long> getRequiredLongs() {
    return requiredLongs;
  }

  public void setRequiredLongs(Set<Long> requiredLongs) {
    this.requiredLongs = Objects.requireNonNull(requiredLongs, "Property requiredLongs is required, cannot be null");
  }

  public SetsDto requiredRefs(Set<Simple> requiredRefs) {
    this.requiredRefs = Objects.requireNonNull(requiredRefs, "Property requiredRefs is required, cannot be null");
    return this;
  }

  public SetsDto addRequiredRefsItem(Simple requiredRefsItem) {
    this.requiredRefs.add(requiredRefsItem);
    return this;
  }

  /**
   * Get requiredRefs
   * @return requiredRefs
   **/
  @NotNull @Valid
  public Set<Simple> getRequiredRefs() {
    return requiredRefs;
  }

  public void setRequiredRefs(Set<Simple> requiredRefs) {
    this.requiredRefs = Objects.requireNonNull(requiredRefs, "Property requiredRefs is required, cannot be null");
  }

  public SetsDto requiredShorts(Set<Short> requiredShorts) {
    this.requiredShorts = Objects.requireNonNull(requiredShorts, "Property requiredShorts is required, cannot be null");
    return this;
  }

  public SetsDto addRequiredShortsItem(short requiredShortsItem) {
    this.requiredShorts.add(requiredShortsItem);
    return this;
  }

  /**
   * Get requiredShorts
   * @return requiredShorts
   **/
  @NotNull
  public Set<Short> getRequiredShorts() {
    return requiredShorts;
  }

  public void setRequiredShorts(Set<Short> requiredShorts) {
    this.requiredShorts = Objects.requireNonNull(requiredShorts, "Property requiredShorts is required, cannot be null");
  }

  public SetsDto requiredStrings(Set<String> requiredStrings) {
    this.requiredStrings = Objects.requireNonNull(requiredStrings, "Property requiredStrings is required, cannot be null");
    return this;
  }

  public SetsDto addRequiredStringsItem(String requiredStringsItem) {
    this.requiredStrings.add(requiredStringsItem);
    return this;
  }

  /**
   * Get requiredStrings
   * @return requiredStrings
   **/
  @NotNull
  public Set<String> getRequiredStrings() {
    return requiredStrings;
  }

  public void setRequiredStrings(Set<String> requiredStrings) {
    this.requiredStrings = Objects.requireNonNull(requiredStrings, "Property requiredStrings is required, cannot be null");
  }

  public SetsDto shorts(Set<Short> shorts) {
    this.shorts = shorts;
    return this;
  }

  public SetsDto addShortsItem(short shortsItem) {
    if (this.shorts == null) {
      this.shorts = new LinkedHashSet<>();
    }
    this.shorts.add(shortsItem);
    return this;
  }

  /**
   * Get shorts
   * @return shorts
   **/
  public Set<Short> getShorts() {
    return shorts;
  }

  public void setShorts(Set<Short> shorts) {
    this.shorts = shorts;
  }

  public SetsDto strings(Set<String> strings) {
    this.strings = strings;
    return this;
  }

  public SetsDto addStringsItem(String stringsItem) {
    if (this.strings == null) {
      this.strings = new LinkedHashSet<>();
    }
    this.strings.add(stringsItem);
    return this;
  }

  /**
   * Get strings
   * @return strings
   **/
  public Set<String> getStrings() {
    return strings;
  }

  public void setStrings(Set<String> strings) {
    this.strings = strings;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof SetsDto)) {
      return false;
    }
    SetsDto other = (SetsDto) o;
    return Objects.equals(this.booleans, other.booleans) &&
        Objects.equals(this.bytes, other.bytes) &&
        Objects.equals(this.ints, other.ints) &&
        Objects.equals(this.longs, other.longs) &&
        Objects.equals(this.refs, other.refs) &&
        Objects.equals(this.requiredBooleans, other.requiredBooleans) &&
        Objects.equals(this.requiredBytes, other.requiredBytes) &&
        Objects.equals(this.requiredInts, other.requiredInts) &&
        Objects.equals(this.requiredLongs, other.requiredLongs) &&
        Objects.equals(this.requiredRefs, other.requiredRefs) &&
        Objects.equals(this.requiredShorts, other.requiredShorts) &&
        Objects.equals(this.requiredStrings, other.requiredStrings) &&
        Objects.equals(this.shorts, other.shorts) &&
        Objects.equals(this.strings, other.strings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(booleans, bytes, ints, longs, refs, requiredBooleans, requiredBytes, requiredInts, requiredLongs, requiredRefs, requiredShorts, requiredStrings, shorts, strings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SetsDto {");
    sb.append("\n    booleans: ").append(toIndentedString(booleans));
    sb.append("\n    bytes: ").append(toIndentedString(bytes));
    sb.append("\n    ints: ").append(toIndentedString(ints));
    sb.append("\n    longs: ").append(toIndentedString(longs));
    sb.append("\n    refs: ").append(toIndentedString(refs));
    sb.append("\n    requiredBooleans: ").append(toIndentedString(requiredBooleans));
    sb.append("\n    requiredBytes: ").append(toIndentedString(requiredBytes));
    sb.append("\n    requiredInts: ").append(toIndentedString(requiredInts));
    sb.append("\n    requiredLongs: ").append(toIndentedString(requiredLongs));
    sb.append("\n    requiredRefs: ").append(toIndentedString(requiredRefs));
    sb.append("\n    requiredShorts: ").append(toIndentedString(requiredShorts));
    sb.append("\n    requiredStrings: ").append(toIndentedString(requiredStrings));
    sb.append("\n    shorts: ").append(toIndentedString(shorts));
    sb.append("\n    strings: ").append(toIndentedString(strings));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
