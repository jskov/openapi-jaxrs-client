/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.mp.dto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * MapsDto
 */
@JsonPropertyOrder({
  MapsDto.JSON_PROPERTY_BOOLEANS,
  MapsDto.JSON_PROPERTY_BYTES,
  MapsDto.JSON_PROPERTY_SHORTS,
  MapsDto.JSON_PROPERTY_INTS,
  MapsDto.JSON_PROPERTY_LONGS,
  MapsDto.JSON_PROPERTY_STRINGS,
  MapsDto.JSON_PROPERTY_REFS,
  MapsDto.JSON_PROPERTY_REQUIRED_BOOLEANS,
  MapsDto.JSON_PROPERTY_REQUIRED_BYTES,
  MapsDto.JSON_PROPERTY_REQUIRED_SHORTS,
  MapsDto.JSON_PROPERTY_REQUIRED_INTS,
  MapsDto.JSON_PROPERTY_REQUIRED_LONGS,
  MapsDto.JSON_PROPERTY_REQUIRED_STRINGS,
  MapsDto.JSON_PROPERTY_REQUIRED_REFS,
  MapsDto.JSON_PROPERTY_BOTH_BOOLEANS,
  MapsDto.JSON_PROPERTY_BOTH_BYTES,
  MapsDto.JSON_PROPERTY_BOTH_SHORTS,
  MapsDto.JSON_PROPERTY_BOTH_INTS,
  MapsDto.JSON_PROPERTY_BOTH_LONGS,
  MapsDto.JSON_PROPERTY_BOTH_STRINGS,
  MapsDto.JSON_PROPERTY_BOTH_REFS,
  MapsDto.JSON_PROPERTY_OBJECTS
})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class MapsDto {
  public static final String JSON_PROPERTY_BOOLEANS = "booleans";
  @JsonProperty(JSON_PROPERTY_BOOLEANS)
  private Map<String, Boolean> booleans;

  public static final String JSON_PROPERTY_BYTES = "bytes";
  @JsonProperty(JSON_PROPERTY_BYTES)
  private Map<String, Byte> bytes;

  public static final String JSON_PROPERTY_SHORTS = "shorts";
  @JsonProperty(JSON_PROPERTY_SHORTS)
  private Map<String, Short> shorts;

  public static final String JSON_PROPERTY_INTS = "ints";
  @JsonProperty(JSON_PROPERTY_INTS)
  private Map<String, Integer> ints;

  public static final String JSON_PROPERTY_LONGS = "longs";
  @JsonProperty(JSON_PROPERTY_LONGS)
  private Map<String, Long> longs;

  public static final String JSON_PROPERTY_STRINGS = "strings";
  @JsonProperty(JSON_PROPERTY_STRINGS)
  private Map<String, String> strings;

  public static final String JSON_PROPERTY_REFS = "refs";
  @JsonProperty(JSON_PROPERTY_REFS)
  private Map<String, Simple> refs;

  public static final String JSON_PROPERTY_REQUIRED_BOOLEANS = "requiredBooleans";
  @JsonProperty(JSON_PROPERTY_REQUIRED_BOOLEANS)
  @Schema(required = true)
  private Map<String, Boolean> requiredBooleans = new HashMap<>();

  public static final String JSON_PROPERTY_REQUIRED_BYTES = "requiredBytes";
  @JsonProperty(JSON_PROPERTY_REQUIRED_BYTES)
  @Schema(required = true)
  private Map<String, Byte> requiredBytes = new HashMap<>();

  public static final String JSON_PROPERTY_REQUIRED_SHORTS = "requiredShorts";
  @JsonProperty(JSON_PROPERTY_REQUIRED_SHORTS)
  @Schema(required = true)
  private Map<String, Short> requiredShorts = new HashMap<>();

  public static final String JSON_PROPERTY_REQUIRED_INTS = "requiredInts";
  @JsonProperty(JSON_PROPERTY_REQUIRED_INTS)
  @Schema(required = true)
  private Map<String, Integer> requiredInts = new HashMap<>();

  public static final String JSON_PROPERTY_REQUIRED_LONGS = "requiredLongs";
  @JsonProperty(JSON_PROPERTY_REQUIRED_LONGS)
  @Schema(required = true)
  private Map<String, Long> requiredLongs = new HashMap<>();

  public static final String JSON_PROPERTY_REQUIRED_STRINGS = "requiredStrings";
  @JsonProperty(JSON_PROPERTY_REQUIRED_STRINGS)
  @Schema(required = true)
  private Map<String, String> requiredStrings = new HashMap<>();

  public static final String JSON_PROPERTY_REQUIRED_REFS = "requiredRefs";
  @JsonProperty(JSON_PROPERTY_REQUIRED_REFS)
  @Schema(required = true)
  private Map<String, Simple> requiredRefs = new HashMap<>();

  public static final String JSON_PROPERTY_BOTH_BOOLEANS = "bothBooleans";
  @JsonProperty(JSON_PROPERTY_BOTH_BOOLEANS)
  private Map<String, Boolean> bothBooleans;

  public static final String JSON_PROPERTY_BOTH_BYTES = "bothBytes";
  @JsonProperty(JSON_PROPERTY_BOTH_BYTES)
  private Map<String, Byte> bothBytes;

  public static final String JSON_PROPERTY_BOTH_SHORTS = "bothShorts";
  @JsonProperty(JSON_PROPERTY_BOTH_SHORTS)
  private Map<String, Short> bothShorts;

  public static final String JSON_PROPERTY_BOTH_INTS = "bothInts";
  @JsonProperty(JSON_PROPERTY_BOTH_INTS)
  private Map<String, Integer> bothInts;

  public static final String JSON_PROPERTY_BOTH_LONGS = "bothLongs";
  @JsonProperty(JSON_PROPERTY_BOTH_LONGS)
  private Map<String, Long> bothLongs;

  public static final String JSON_PROPERTY_BOTH_STRINGS = "bothStrings";
  @JsonProperty(JSON_PROPERTY_BOTH_STRINGS)
  private Map<String, String> bothStrings;

  public static final String JSON_PROPERTY_BOTH_REFS = "bothRefs";
  @JsonProperty(JSON_PROPERTY_BOTH_REFS)
  private Map<String, Simple> bothRefs;

  public static final String JSON_PROPERTY_OBJECTS = "objects";
  @JsonProperty(JSON_PROPERTY_OBJECTS)
  private Map<String, Object> objects;

  public MapsDto booleans(Map<String, Boolean> booleans) {
    this.booleans = booleans;
    return this;
  }

  public MapsDto putBooleansItem(String key, boolean booleansItem) {
    if (this.booleans == null) {
      this.booleans = new HashMap<>();
    }
    this.booleans.put(key, booleansItem);
    return this;
  }

  /**
   * Get booleans
   * @return booleans
   **/
  public Map<String, Boolean> getBooleans() {
    return booleans;
  }

  public void setBooleans(Map<String, Boolean> booleans) {
    this.booleans = booleans;
  }

  public MapsDto bytes(Map<String, Byte> bytes) {
    this.bytes = bytes;
    return this;
  }

  public MapsDto putBytesItem(String key, byte bytesItem) {
    if (this.bytes == null) {
      this.bytes = new HashMap<>();
    }
    this.bytes.put(key, bytesItem);
    return this;
  }

  /**
   * Get bytes
   * @return bytes
   **/
  public Map<String, Byte> getBytes() {
    return bytes;
  }

  public void setBytes(Map<String, Byte> bytes) {
    this.bytes = bytes;
  }

  public MapsDto shorts(Map<String, Short> shorts) {
    this.shorts = shorts;
    return this;
  }

  public MapsDto putShortsItem(String key, short shortsItem) {
    if (this.shorts == null) {
      this.shorts = new HashMap<>();
    }
    this.shorts.put(key, shortsItem);
    return this;
  }

  /**
   * Get shorts
   * @return shorts
   **/
  public Map<String, Short> getShorts() {
    return shorts;
  }

  public void setShorts(Map<String, Short> shorts) {
    this.shorts = shorts;
  }

  public MapsDto ints(Map<String, Integer> ints) {
    this.ints = ints;
    return this;
  }

  public MapsDto putIntsItem(String key, int intsItem) {
    if (this.ints == null) {
      this.ints = new HashMap<>();
    }
    this.ints.put(key, intsItem);
    return this;
  }

  /**
   * Get ints
   * @return ints
   **/
  public Map<String, Integer> getInts() {
    return ints;
  }

  public void setInts(Map<String, Integer> ints) {
    this.ints = ints;
  }

  public MapsDto longs(Map<String, Long> longs) {
    this.longs = longs;
    return this;
  }

  public MapsDto putLongsItem(String key, long longsItem) {
    if (this.longs == null) {
      this.longs = new HashMap<>();
    }
    this.longs.put(key, longsItem);
    return this;
  }

  /**
   * Get longs
   * @return longs
   **/
  public Map<String, Long> getLongs() {
    return longs;
  }

  public void setLongs(Map<String, Long> longs) {
    this.longs = longs;
  }

  public MapsDto strings(Map<String, String> strings) {
    this.strings = strings;
    return this;
  }

  public MapsDto putStringsItem(String key, String stringsItem) {
    if (this.strings == null) {
      this.strings = new HashMap<>();
    }
    this.strings.put(key, stringsItem);
    return this;
  }

  /**
   * Get strings
   * @return strings
   **/
  public Map<String, String> getStrings() {
    return strings;
  }

  public void setStrings(Map<String, String> strings) {
    this.strings = strings;
  }

  public MapsDto refs(Map<String, Simple> refs) {
    this.refs = refs;
    return this;
  }

  public MapsDto putRefsItem(String key, Simple refsItem) {
    if (this.refs == null) {
      this.refs = new HashMap<>();
    }
    this.refs.put(key, refsItem);
    return this;
  }

  /**
   * Get refs
   * @return refs
   **/
  @Valid
  public Map<String, Simple> getRefs() {
    return refs;
  }

  public void setRefs(Map<String, Simple> refs) {
    this.refs = refs;
  }

  public MapsDto requiredBooleans(Map<String, Boolean> requiredBooleans) {
    this.requiredBooleans = Objects.requireNonNull(requiredBooleans, "Property requiredBooleans is required, cannot be null");
    return this;
  }

  public MapsDto putRequiredBooleansItem(String key, boolean requiredBooleansItem) {
    this.requiredBooleans.put(key, requiredBooleansItem);
    return this;
  }

  /**
   * Get requiredBooleans
   * @return requiredBooleans
   **/
  @NotNull
  public Map<String, Boolean> getRequiredBooleans() {
    return requiredBooleans;
  }

  public void setRequiredBooleans(Map<String, Boolean> requiredBooleans) {
    this.requiredBooleans = Objects.requireNonNull(requiredBooleans, "Property requiredBooleans is required, cannot be null");
  }

  public MapsDto requiredBytes(Map<String, Byte> requiredBytes) {
    this.requiredBytes = Objects.requireNonNull(requiredBytes, "Property requiredBytes is required, cannot be null");
    return this;
  }

  public MapsDto putRequiredBytesItem(String key, byte requiredBytesItem) {
    this.requiredBytes.put(key, requiredBytesItem);
    return this;
  }

  /**
   * Get requiredBytes
   * @return requiredBytes
   **/
  @NotNull
  public Map<String, Byte> getRequiredBytes() {
    return requiredBytes;
  }

  public void setRequiredBytes(Map<String, Byte> requiredBytes) {
    this.requiredBytes = Objects.requireNonNull(requiredBytes, "Property requiredBytes is required, cannot be null");
  }

  public MapsDto requiredShorts(Map<String, Short> requiredShorts) {
    this.requiredShorts = Objects.requireNonNull(requiredShorts, "Property requiredShorts is required, cannot be null");
    return this;
  }

  public MapsDto putRequiredShortsItem(String key, short requiredShortsItem) {
    this.requiredShorts.put(key, requiredShortsItem);
    return this;
  }

  /**
   * Get requiredShorts
   * @return requiredShorts
   **/
  @NotNull
  public Map<String, Short> getRequiredShorts() {
    return requiredShorts;
  }

  public void setRequiredShorts(Map<String, Short> requiredShorts) {
    this.requiredShorts = Objects.requireNonNull(requiredShorts, "Property requiredShorts is required, cannot be null");
  }

  public MapsDto requiredInts(Map<String, Integer> requiredInts) {
    this.requiredInts = Objects.requireNonNull(requiredInts, "Property requiredInts is required, cannot be null");
    return this;
  }

  public MapsDto putRequiredIntsItem(String key, int requiredIntsItem) {
    this.requiredInts.put(key, requiredIntsItem);
    return this;
  }

  /**
   * Get requiredInts
   * @return requiredInts
   **/
  @NotNull
  public Map<String, Integer> getRequiredInts() {
    return requiredInts;
  }

  public void setRequiredInts(Map<String, Integer> requiredInts) {
    this.requiredInts = Objects.requireNonNull(requiredInts, "Property requiredInts is required, cannot be null");
  }

  public MapsDto requiredLongs(Map<String, Long> requiredLongs) {
    this.requiredLongs = Objects.requireNonNull(requiredLongs, "Property requiredLongs is required, cannot be null");
    return this;
  }

  public MapsDto putRequiredLongsItem(String key, long requiredLongsItem) {
    this.requiredLongs.put(key, requiredLongsItem);
    return this;
  }

  /**
   * Get requiredLongs
   * @return requiredLongs
   **/
  @NotNull
  public Map<String, Long> getRequiredLongs() {
    return requiredLongs;
  }

  public void setRequiredLongs(Map<String, Long> requiredLongs) {
    this.requiredLongs = Objects.requireNonNull(requiredLongs, "Property requiredLongs is required, cannot be null");
  }

  public MapsDto requiredStrings(Map<String, String> requiredStrings) {
    this.requiredStrings = Objects.requireNonNull(requiredStrings, "Property requiredStrings is required, cannot be null");
    return this;
  }

  public MapsDto putRequiredStringsItem(String key, String requiredStringsItem) {
    this.requiredStrings.put(key, requiredStringsItem);
    return this;
  }

  /**
   * Get requiredStrings
   * @return requiredStrings
   **/
  @NotNull
  public Map<String, String> getRequiredStrings() {
    return requiredStrings;
  }

  public void setRequiredStrings(Map<String, String> requiredStrings) {
    this.requiredStrings = Objects.requireNonNull(requiredStrings, "Property requiredStrings is required, cannot be null");
  }

  public MapsDto requiredRefs(Map<String, Simple> requiredRefs) {
    this.requiredRefs = Objects.requireNonNull(requiredRefs, "Property requiredRefs is required, cannot be null");
    return this;
  }

  public MapsDto putRequiredRefsItem(String key, Simple requiredRefsItem) {
    this.requiredRefs.put(key, requiredRefsItem);
    return this;
  }

  /**
   * Get requiredRefs
   * @return requiredRefs
   **/
  @NotNull @Valid
  public Map<String, Simple> getRequiredRefs() {
    return requiredRefs;
  }

  public void setRequiredRefs(Map<String, Simple> requiredRefs) {
    this.requiredRefs = Objects.requireNonNull(requiredRefs, "Property requiredRefs is required, cannot be null");
  }

  public MapsDto bothBooleans(Map<String, Boolean> bothBooleans) {
    this.bothBooleans = bothBooleans;
    return this;
  }

  public MapsDto putBothBooleansItem(String key, boolean bothBooleansItem) {
    if (this.bothBooleans == null) {
      this.bothBooleans = new HashMap<>();
    }
    this.bothBooleans.put(key, bothBooleansItem);
    return this;
  }

  /**
   * Get bothBooleans
   * @return bothBooleans
   **/
  public Map<String, Boolean> getBothBooleans() {
    return bothBooleans;
  }

  public void setBothBooleans(Map<String, Boolean> bothBooleans) {
    this.bothBooleans = bothBooleans;
  }

  public MapsDto bothBytes(Map<String, Byte> bothBytes) {
    this.bothBytes = bothBytes;
    return this;
  }

  public MapsDto putBothBytesItem(String key, byte bothBytesItem) {
    if (this.bothBytes == null) {
      this.bothBytes = new HashMap<>();
    }
    this.bothBytes.put(key, bothBytesItem);
    return this;
  }

  /**
   * Get bothBytes
   * @return bothBytes
   **/
  public Map<String, Byte> getBothBytes() {
    return bothBytes;
  }

  public void setBothBytes(Map<String, Byte> bothBytes) {
    this.bothBytes = bothBytes;
  }

  public MapsDto bothShorts(Map<String, Short> bothShorts) {
    this.bothShorts = bothShorts;
    return this;
  }

  public MapsDto putBothShortsItem(String key, short bothShortsItem) {
    if (this.bothShorts == null) {
      this.bothShorts = new HashMap<>();
    }
    this.bothShorts.put(key, bothShortsItem);
    return this;
  }

  /**
   * Get bothShorts
   * @return bothShorts
   **/
  public Map<String, Short> getBothShorts() {
    return bothShorts;
  }

  public void setBothShorts(Map<String, Short> bothShorts) {
    this.bothShorts = bothShorts;
  }

  public MapsDto bothInts(Map<String, Integer> bothInts) {
    this.bothInts = bothInts;
    return this;
  }

  public MapsDto putBothIntsItem(String key, int bothIntsItem) {
    if (this.bothInts == null) {
      this.bothInts = new HashMap<>();
    }
    this.bothInts.put(key, bothIntsItem);
    return this;
  }

  /**
   * Get bothInts
   * @return bothInts
   **/
  public Map<String, Integer> getBothInts() {
    return bothInts;
  }

  public void setBothInts(Map<String, Integer> bothInts) {
    this.bothInts = bothInts;
  }

  public MapsDto bothLongs(Map<String, Long> bothLongs) {
    this.bothLongs = bothLongs;
    return this;
  }

  public MapsDto putBothLongsItem(String key, long bothLongsItem) {
    if (this.bothLongs == null) {
      this.bothLongs = new HashMap<>();
    }
    this.bothLongs.put(key, bothLongsItem);
    return this;
  }

  /**
   * Get bothLongs
   * @return bothLongs
   **/
  public Map<String, Long> getBothLongs() {
    return bothLongs;
  }

  public void setBothLongs(Map<String, Long> bothLongs) {
    this.bothLongs = bothLongs;
  }

  public MapsDto bothStrings(Map<String, String> bothStrings) {
    this.bothStrings = bothStrings;
    return this;
  }

  public MapsDto putBothStringsItem(String key, String bothStringsItem) {
    if (this.bothStrings == null) {
      this.bothStrings = new HashMap<>();
    }
    this.bothStrings.put(key, bothStringsItem);
    return this;
  }

  /**
   * Get bothStrings
   * @return bothStrings
   **/
  public Map<String, String> getBothStrings() {
    return bothStrings;
  }

  public void setBothStrings(Map<String, String> bothStrings) {
    this.bothStrings = bothStrings;
  }

  public MapsDto bothRefs(Map<String, Simple> bothRefs) {
    this.bothRefs = bothRefs;
    return this;
  }

  public MapsDto putBothRefsItem(String key, Simple bothRefsItem) {
    if (this.bothRefs == null) {
      this.bothRefs = new HashMap<>();
    }
    this.bothRefs.put(key, bothRefsItem);
    return this;
  }

  /**
   * Get bothRefs
   * @return bothRefs
   **/
  @Valid
  public Map<String, Simple> getBothRefs() {
    return bothRefs;
  }

  public void setBothRefs(Map<String, Simple> bothRefs) {
    this.bothRefs = bothRefs;
  }

  public MapsDto objects(Map<String, Object> objects) {
    this.objects = objects;
    return this;
  }

  public MapsDto putObjectsItem(String key, Object objectsItem) {
    if (this.objects == null) {
      this.objects = new HashMap<>();
    }
    this.objects.put(key, objectsItem);
    return this;
  }

  /**
   * Get objects
   * @return objects
   **/
  public Map<String, Object> getObjects() {
    return objects;
  }

  public void setObjects(Map<String, Object> objects) {
    this.objects = objects;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof MapsDto)) {
      return false;
    }
    MapsDto other = (MapsDto) o;
    return Objects.equals(this.booleans, other.booleans) &&
        Objects.equals(this.bytes, other.bytes) &&
        Objects.equals(this.shorts, other.shorts) &&
        Objects.equals(this.ints, other.ints) &&
        Objects.equals(this.longs, other.longs) &&
        Objects.equals(this.strings, other.strings) &&
        Objects.equals(this.refs, other.refs) &&
        Objects.equals(this.requiredBooleans, other.requiredBooleans) &&
        Objects.equals(this.requiredBytes, other.requiredBytes) &&
        Objects.equals(this.requiredShorts, other.requiredShorts) &&
        Objects.equals(this.requiredInts, other.requiredInts) &&
        Objects.equals(this.requiredLongs, other.requiredLongs) &&
        Objects.equals(this.requiredStrings, other.requiredStrings) &&
        Objects.equals(this.requiredRefs, other.requiredRefs) &&
        Objects.equals(this.bothBooleans, other.bothBooleans) &&
        Objects.equals(this.bothBytes, other.bothBytes) &&
        Objects.equals(this.bothShorts, other.bothShorts) &&
        Objects.equals(this.bothInts, other.bothInts) &&
        Objects.equals(this.bothLongs, other.bothLongs) &&
        Objects.equals(this.bothStrings, other.bothStrings) &&
        Objects.equals(this.bothRefs, other.bothRefs) &&
        Objects.equals(this.objects, other.objects);
  }

  @Override
  public int hashCode() {
    return Objects.hash(booleans, bytes, shorts, ints, longs, strings, refs, requiredBooleans, requiredBytes, requiredShorts, requiredInts, requiredLongs, requiredStrings, requiredRefs, bothBooleans, bothBytes, bothShorts, bothInts, bothLongs, bothStrings, bothRefs, objects);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MapsDto {");
    sb.append("\n    booleans: ").append(toIndentedString(booleans));
    sb.append("\n    bytes: ").append(toIndentedString(bytes));
    sb.append("\n    shorts: ").append(toIndentedString(shorts));
    sb.append("\n    ints: ").append(toIndentedString(ints));
    sb.append("\n    longs: ").append(toIndentedString(longs));
    sb.append("\n    strings: ").append(toIndentedString(strings));
    sb.append("\n    refs: ").append(toIndentedString(refs));
    sb.append("\n    requiredBooleans: ").append(toIndentedString(requiredBooleans));
    sb.append("\n    requiredBytes: ").append(toIndentedString(requiredBytes));
    sb.append("\n    requiredShorts: ").append(toIndentedString(requiredShorts));
    sb.append("\n    requiredInts: ").append(toIndentedString(requiredInts));
    sb.append("\n    requiredLongs: ").append(toIndentedString(requiredLongs));
    sb.append("\n    requiredStrings: ").append(toIndentedString(requiredStrings));
    sb.append("\n    requiredRefs: ").append(toIndentedString(requiredRefs));
    sb.append("\n    bothBooleans: ").append(toIndentedString(bothBooleans));
    sb.append("\n    bothBytes: ").append(toIndentedString(bothBytes));
    sb.append("\n    bothShorts: ").append(toIndentedString(bothShorts));
    sb.append("\n    bothInts: ").append(toIndentedString(bothInts));
    sb.append("\n    bothLongs: ").append(toIndentedString(bothLongs));
    sb.append("\n    bothStrings: ").append(toIndentedString(bothStrings));
    sb.append("\n    bothRefs: ").append(toIndentedString(bothRefs));
    sb.append("\n    objects: ").append(toIndentedString(objects));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
