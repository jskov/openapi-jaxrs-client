/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.collections_empty.jsonb.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * ArraysDto
 */
@JsonbPropertyOrder({
  ArraysDto.JSON_PROPERTY_BOOLEANS,
  ArraysDto.JSON_PROPERTY_BYTES,
  ArraysDto.JSON_PROPERTY_SHORTS,
  ArraysDto.JSON_PROPERTY_INTS,
  ArraysDto.JSON_PROPERTY_LONGS,
  ArraysDto.JSON_PROPERTY_STRINGS,
  ArraysDto.JSON_PROPERTY_REFS,
  ArraysDto.JSON_PROPERTY_REQUIRED_BOOLEANS,
  ArraysDto.JSON_PROPERTY_REQUIRED_BYTES,
  ArraysDto.JSON_PROPERTY_REQUIRED_SHORTS,
  ArraysDto.JSON_PROPERTY_REQUIRED_INTS,
  ArraysDto.JSON_PROPERTY_REQUIRED_LONGS,
  ArraysDto.JSON_PROPERTY_REQUIRED_STRINGS,
  ArraysDto.JSON_PROPERTY_REQUIRED_REFS
})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ArraysDto {
  public static final String JSON_PROPERTY_BOOLEANS = "booleans";
  @JsonbProperty(JSON_PROPERTY_BOOLEANS)
  private List<Boolean> booleans;

  public static final String JSON_PROPERTY_BYTES = "bytes";
  @JsonbProperty(JSON_PROPERTY_BYTES)
  private byte[] bytes;

  public static final String JSON_PROPERTY_INTS = "ints";
  @JsonbProperty(JSON_PROPERTY_INTS)
  private List<Integer> ints;

  public static final String JSON_PROPERTY_LONGS = "longs";
  @JsonbProperty(JSON_PROPERTY_LONGS)
  private List<Long> longs;

  public static final String JSON_PROPERTY_REFS = "refs";
  @JsonbProperty(JSON_PROPERTY_REFS)
  private List<Simple> refs;

  public static final String JSON_PROPERTY_REQUIRED_BOOLEANS = "requiredBooleans";
  @JsonbProperty(JSON_PROPERTY_REQUIRED_BOOLEANS)
  @Schema(required = true)
  private List<Boolean> requiredBooleans = new ArrayList<>();

  public static final String JSON_PROPERTY_REQUIRED_BYTES = "requiredBytes";
  @JsonbProperty(JSON_PROPERTY_REQUIRED_BYTES)
  @Schema(required = true)
  private byte[] requiredBytes = new byte[] {};

  public static final String JSON_PROPERTY_REQUIRED_INTS = "requiredInts";
  @JsonbProperty(JSON_PROPERTY_REQUIRED_INTS)
  @Schema(required = true)
  private List<Integer> requiredInts = new ArrayList<>();

  public static final String JSON_PROPERTY_REQUIRED_LONGS = "requiredLongs";
  @JsonbProperty(JSON_PROPERTY_REQUIRED_LONGS)
  @Schema(required = true)
  private List<Long> requiredLongs = new ArrayList<>();

  public static final String JSON_PROPERTY_REQUIRED_REFS = "requiredRefs";
  @JsonbProperty(JSON_PROPERTY_REQUIRED_REFS)
  @Schema(required = true)
  private List<Simple> requiredRefs = new ArrayList<>();

  public static final String JSON_PROPERTY_REQUIRED_SHORTS = "requiredShorts";
  @JsonbProperty(JSON_PROPERTY_REQUIRED_SHORTS)
  @Schema(required = true)
  private List<Short> requiredShorts = new ArrayList<>();

  public static final String JSON_PROPERTY_REQUIRED_STRINGS = "requiredStrings";
  @JsonbProperty(JSON_PROPERTY_REQUIRED_STRINGS)
  @Schema(required = true)
  private List<String> requiredStrings = new ArrayList<>();

  public static final String JSON_PROPERTY_SHORTS = "shorts";
  @JsonbProperty(JSON_PROPERTY_SHORTS)
  private List<Short> shorts;

  public static final String JSON_PROPERTY_STRINGS = "strings";
  @JsonbProperty(JSON_PROPERTY_STRINGS)
  private List<String> strings;

  public ArraysDto booleans(List<Boolean> booleans) {
    this.booleans = booleans;
    return this;
  }

  public ArraysDto addBooleansItem(boolean booleansItem) {
    if (this.booleans == null) {
      this.booleans = new ArrayList<>();
    }
    this.booleans.add(booleansItem);
    return this;
  }

  /**
   * Get booleans
   * @return booleans
   **/
  public List<Boolean> getBooleansNullable() {
    return booleans;
  }

  public List<Boolean> getBooleans() {
    if (this.booleans == null) {
      this.booleans = new ArrayList<>();
    }
    return this.booleans;
  }

  public void setBooleans(List<Boolean> booleans) {
    this.booleans = booleans;
  }

  public ArraysDto bytes(byte[] bytes) {
    this.bytes = bytes;
    return this;
  }

  /**
   * Get bytes
   * @return bytes
   **/
  public byte[] getBytes() {
    return bytes;
  }

  public void setBytes(byte[] bytes) {
    this.bytes = bytes;
  }

  public ArraysDto ints(List<Integer> ints) {
    this.ints = ints;
    return this;
  }

  public ArraysDto addIntsItem(int intsItem) {
    if (this.ints == null) {
      this.ints = new ArrayList<>();
    }
    this.ints.add(intsItem);
    return this;
  }

  /**
   * Get ints
   * @return ints
   **/
  public List<Integer> getIntsNullable() {
    return ints;
  }

  public List<Integer> getInts() {
    if (this.ints == null) {
      this.ints = new ArrayList<>();
    }
    return this.ints;
  }

  public void setInts(List<Integer> ints) {
    this.ints = ints;
  }

  public ArraysDto longs(List<Long> longs) {
    this.longs = longs;
    return this;
  }

  public ArraysDto addLongsItem(long longsItem) {
    if (this.longs == null) {
      this.longs = new ArrayList<>();
    }
    this.longs.add(longsItem);
    return this;
  }

  /**
   * Get longs
   * @return longs
   **/
  public List<Long> getLongsNullable() {
    return longs;
  }

  public List<Long> getLongs() {
    if (this.longs == null) {
      this.longs = new ArrayList<>();
    }
    return this.longs;
  }

  public void setLongs(List<Long> longs) {
    this.longs = longs;
  }

  public ArraysDto refs(List<Simple> refs) {
    this.refs = refs;
    return this;
  }

  public ArraysDto addRefsItem(Simple refsItem) {
    if (this.refs == null) {
      this.refs = new ArrayList<>();
    }
    this.refs.add(refsItem);
    return this;
  }

  /**
   * Get refs
   * @return refs
   **/
  @Valid
  public List<Simple> getRefsNullable() {
    return refs;
  }

  @Valid
  public List<Simple> getRefs() {
    if (this.refs == null) {
      this.refs = new ArrayList<>();
    }
    return this.refs;
  }

  public void setRefs(List<Simple> refs) {
    this.refs = refs;
  }

  public ArraysDto requiredBooleans(List<Boolean> requiredBooleans) {
    this.requiredBooleans = Objects.requireNonNull(requiredBooleans, "Property requiredBooleans is required, cannot be null");
    return this;
  }

  public ArraysDto addRequiredBooleansItem(boolean requiredBooleansItem) {
    this.requiredBooleans.add(requiredBooleansItem);
    return this;
  }

  /**
   * Get requiredBooleans
   * @return requiredBooleans
   **/
  @NotNull
  public List<Boolean> getRequiredBooleans() {
    return requiredBooleans;
  }

  public void setRequiredBooleans(List<Boolean> requiredBooleans) {
    this.requiredBooleans = Objects.requireNonNull(requiredBooleans, "Property requiredBooleans is required, cannot be null");
  }

  public ArraysDto requiredBytes(byte[] requiredBytes) {
    this.requiredBytes = Objects.requireNonNull(requiredBytes, "Property requiredBytes is required, cannot be null");
    return this;
  }

  /**
   * Get requiredBytes
   * @return requiredBytes
   **/
  @NotNull
  public byte[] getRequiredBytes() {
    return requiredBytes;
  }

  public void setRequiredBytes(byte[] requiredBytes) {
    this.requiredBytes = Objects.requireNonNull(requiredBytes, "Property requiredBytes is required, cannot be null");
  }

  public ArraysDto requiredInts(List<Integer> requiredInts) {
    this.requiredInts = Objects.requireNonNull(requiredInts, "Property requiredInts is required, cannot be null");
    return this;
  }

  public ArraysDto addRequiredIntsItem(int requiredIntsItem) {
    this.requiredInts.add(requiredIntsItem);
    return this;
  }

  /**
   * Get requiredInts
   * @return requiredInts
   **/
  @NotNull
  public List<Integer> getRequiredInts() {
    return requiredInts;
  }

  public void setRequiredInts(List<Integer> requiredInts) {
    this.requiredInts = Objects.requireNonNull(requiredInts, "Property requiredInts is required, cannot be null");
  }

  public ArraysDto requiredLongs(List<Long> requiredLongs) {
    this.requiredLongs = Objects.requireNonNull(requiredLongs, "Property requiredLongs is required, cannot be null");
    return this;
  }

  public ArraysDto addRequiredLongsItem(long requiredLongsItem) {
    this.requiredLongs.add(requiredLongsItem);
    return this;
  }

  /**
   * Get requiredLongs
   * @return requiredLongs
   **/
  @NotNull
  public List<Long> getRequiredLongs() {
    return requiredLongs;
  }

  public void setRequiredLongs(List<Long> requiredLongs) {
    this.requiredLongs = Objects.requireNonNull(requiredLongs, "Property requiredLongs is required, cannot be null");
  }

  public ArraysDto requiredRefs(List<Simple> requiredRefs) {
    this.requiredRefs = Objects.requireNonNull(requiredRefs, "Property requiredRefs is required, cannot be null");
    return this;
  }

  public ArraysDto addRequiredRefsItem(Simple requiredRefsItem) {
    this.requiredRefs.add(requiredRefsItem);
    return this;
  }

  /**
   * Get requiredRefs
   * @return requiredRefs
   **/
  @NotNull @Valid
  public List<Simple> getRequiredRefs() {
    return requiredRefs;
  }

  public void setRequiredRefs(List<Simple> requiredRefs) {
    this.requiredRefs = Objects.requireNonNull(requiredRefs, "Property requiredRefs is required, cannot be null");
  }

  public ArraysDto requiredShorts(List<Short> requiredShorts) {
    this.requiredShorts = Objects.requireNonNull(requiredShorts, "Property requiredShorts is required, cannot be null");
    return this;
  }

  public ArraysDto addRequiredShortsItem(short requiredShortsItem) {
    this.requiredShorts.add(requiredShortsItem);
    return this;
  }

  /**
   * Get requiredShorts
   * @return requiredShorts
   **/
  @NotNull
  public List<Short> getRequiredShorts() {
    return requiredShorts;
  }

  public void setRequiredShorts(List<Short> requiredShorts) {
    this.requiredShorts = Objects.requireNonNull(requiredShorts, "Property requiredShorts is required, cannot be null");
  }

  public ArraysDto requiredStrings(List<String> requiredStrings) {
    this.requiredStrings = Objects.requireNonNull(requiredStrings, "Property requiredStrings is required, cannot be null");
    return this;
  }

  public ArraysDto addRequiredStringsItem(String requiredStringsItem) {
    this.requiredStrings.add(requiredStringsItem);
    return this;
  }

  /**
   * Get requiredStrings
   * @return requiredStrings
   **/
  @NotNull
  public List<String> getRequiredStrings() {
    return requiredStrings;
  }

  public void setRequiredStrings(List<String> requiredStrings) {
    this.requiredStrings = Objects.requireNonNull(requiredStrings, "Property requiredStrings is required, cannot be null");
  }

  public ArraysDto shorts(List<Short> shorts) {
    this.shorts = shorts;
    return this;
  }

  public ArraysDto addShortsItem(short shortsItem) {
    if (this.shorts == null) {
      this.shorts = new ArrayList<>();
    }
    this.shorts.add(shortsItem);
    return this;
  }

  /**
   * Get shorts
   * @return shorts
   **/
  public List<Short> getShortsNullable() {
    return shorts;
  }

  public List<Short> getShorts() {
    if (this.shorts == null) {
      this.shorts = new ArrayList<>();
    }
    return this.shorts;
  }

  public void setShorts(List<Short> shorts) {
    this.shorts = shorts;
  }

  public ArraysDto strings(List<String> strings) {
    this.strings = strings;
    return this;
  }

  public ArraysDto addStringsItem(String stringsItem) {
    if (this.strings == null) {
      this.strings = new ArrayList<>();
    }
    this.strings.add(stringsItem);
    return this;
  }

  /**
   * Get strings
   * @return strings
   **/
  public List<String> getStringsNullable() {
    return strings;
  }

  public List<String> getStrings() {
    if (this.strings == null) {
      this.strings = new ArrayList<>();
    }
    return this.strings;
  }

  public void setStrings(List<String> strings) {
    this.strings = strings;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ArraysDto)) {
      return false;
    }
    ArraysDto other = (ArraysDto) o;
    return Objects.equals(this.booleans, other.booleans) &&
        Arrays.equals(this.bytes, other.bytes) &&
        Objects.equals(this.ints, other.ints) &&
        Objects.equals(this.longs, other.longs) &&
        Objects.equals(this.refs, other.refs) &&
        Objects.equals(this.requiredBooleans, other.requiredBooleans) &&
        Arrays.equals(this.requiredBytes, other.requiredBytes) &&
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
    return Objects.hash(booleans, Arrays.hashCode(bytes), ints, longs, refs, requiredBooleans, Arrays.hashCode(requiredBytes), requiredInts, requiredLongs, requiredRefs, requiredShorts, requiredStrings, shorts, strings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ArraysDto {");
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
