/*
 * Azure Container Registry
 * Metadata API definition for the Azure Container Registry runtime
 *
 * The version of the OpenAPI document: 2019-08-15-preview
 */

package mada.tests.e2e.examples.azure.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * The platform object describes the platform which the image in the manifest runs on. A full list of valid operating system and architecture values are listed in the Go language documentation for $GOOS and $GOARCH
 */
@Schema(description = "The platform object describes the platform which the image in the manifest runs on. A full list of valid operating system and architecture values are listed in the Go language documentation for $GOOS and $GOARCH")
@JsonbPropertyOrder({
  Platform.JSON_PROPERTY_ARCHITECTURE,
  Platform.JSON_PROPERTY_OS,
  Platform.JSON_PROPERTY_OS_VERSION,
  Platform.JSON_PROPERTY_OS_FEATURES,
  Platform.JSON_PROPERTY_VARIANT,
  Platform.JSON_PROPERTY_FEATURES
})
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public class Platform {
  public static final String JSON_PROPERTY_ARCHITECTURE = "architecture";
  @JsonbProperty(JSON_PROPERTY_ARCHITECTURE)
  @Schema(description = "Specifies the CPU architecture, for example amd64 or ppc64le.")
  private String architecture;

  public static final String JSON_PROPERTY_OS = "os";
  @JsonbProperty(JSON_PROPERTY_OS)
  @Schema(description = "The os field specifies the operating system, for example linux or windows.")
  private String os;

  public static final String JSON_PROPERTY_OS_VERSION = "os.version";
  @JsonbProperty(JSON_PROPERTY_OS_VERSION)
  @Schema(description = "The optional os.version field specifies the operating system version, for example 10.0.10586.")
  private String os_version;

  public static final String JSON_PROPERTY_OS_FEATURES = "os.features";
  @JsonbProperty(JSON_PROPERTY_OS_FEATURES)
  @Schema(description = "The optional os.features field specifies an array of strings, each listing a required OS feature (for example on Windows win32k")
  private List<String> os_features = null;

  public static final String JSON_PROPERTY_VARIANT = "variant";
  @JsonbProperty(JSON_PROPERTY_VARIANT)
  @Schema(description = "The optional variant field specifies a variant of the CPU, for example armv6l to specify a particular CPU variant of the ARM CPU.")
  private String variant;

  public static final String JSON_PROPERTY_FEATURES = "features";
  @JsonbProperty(JSON_PROPERTY_FEATURES)
  @Schema(description = "The optional features field specifies an array of strings, each listing a required CPU feature (for example sse4 or aes")
  private List<String> features = null;

  public Platform architecture(String architecture) {
    this.architecture = architecture;
    return this;
  }

  /**
   * Specifies the CPU architecture, for example amd64 or ppc64le.
   *
   * @return architecture
   **/
  public String getArchitecture() {
    return architecture;
  }

  public void setArchitecture(String architecture) {
    this.architecture = architecture;
  }

  public Platform os(String os) {
    this.os = os;
    return this;
  }

  /**
   * The os field specifies the operating system, for example linux or windows.
   *
   * @return os
   **/
  public String getOs() {
    return os;
  }

  public void setOs(String os) {
    this.os = os;
  }

  public Platform os_version(String os_version) {
    this.os_version = os_version;
    return this;
  }

  /**
   * The optional os.version field specifies the operating system version, for example 10.0.10586.
   *
   * @return os_version
   **/
  public String getOsVersion() {
    return os_version;
  }

  public void setOsVersion(String os_version) {
    this.os_version = os_version;
  }

  public Platform os_features(List<String> os_features) {
    this.os_features = os_features;
    return this;
  }

  public Platform addOsFeaturesItem(String os_featuresItem) {
    if (this.os_features == null) {
      this.os_features = new ArrayList<>();
    }
    this.os_features.add(os_featuresItem);
    return this;
  }

  /**
   * The optional os.features field specifies an array of strings, each listing a required OS feature (for example on Windows win32k
   *
   * @return os_features
   **/
  public List<String> getOsFeatures() {
    return os_features;
  }

  public void setOsFeatures(List<String> os_features) {
    this.os_features = os_features;
  }

  public Platform variant(String variant) {
    this.variant = variant;
    return this;
  }

  /**
   * The optional variant field specifies a variant of the CPU, for example armv6l to specify a particular CPU variant of the ARM CPU.
   *
   * @return variant
   **/
  public String getVariant() {
    return variant;
  }

  public void setVariant(String variant) {
    this.variant = variant;
  }

  public Platform features(List<String> features) {
    this.features = features;
    return this;
  }

  public Platform addFeaturesItem(String featuresItem) {
    if (this.features == null) {
      this.features = new ArrayList<>();
    }
    this.features.add(featuresItem);
    return this;
  }

  /**
   * The optional features field specifies an array of strings, each listing a required CPU feature (for example sse4 or aes.
   *
   * @return features
   **/
  public List<String> getFeatures() {
    return features;
  }

  public void setFeatures(List<String> features) {
    this.features = features;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Platform other = (Platform) o;
    return Objects.equals(this.architecture, other.architecture) &&
        Objects.equals(this.os, other.os) &&
        Objects.equals(this.os_version, other.os_version) &&
        Objects.equals(this.os_features, other.os_features) &&
        Objects.equals(this.variant, other.variant) &&
        Objects.equals(this.features, other.features);
  }

  @Override
  public int hashCode() {
    return Objects.hash(architecture, os, os_version, os_features, variant, features);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Platform {");
    sb.append("\n    architecture: ").append(toIndentedString(architecture));
    sb.append("\n    os: ").append(toIndentedString(os));
    sb.append("\n    os_version: ").append(toIndentedString(os_version));
    sb.append("\n    os_features: ").append(toIndentedString(os_features));
    sb.append("\n    variant: ").append(toIndentedString(variant));
    sb.append("\n    features: ").append(toIndentedString(features));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
