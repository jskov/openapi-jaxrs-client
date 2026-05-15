/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.opts.generator.validation.jakarta.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * LicenseGroup
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class LicenseGroup {
  public static final String JSON_PROPERTY_LICENSES = "licenses";
  @JsonbProperty(JSON_PROPERTY_LICENSES)
  private List<ZLicense> licenses;

  public static final String JSON_PROPERTY_NUMBERS = "numbers";
  @JsonbProperty(JSON_PROPERTY_NUMBERS)
  @Schema(required = true)
  private List<Integer> numbers = new ArrayList<>();

  public static final String JSON_PROPERTY_REQUIRED_LICENSES = "requiredLicenses";
  @JsonbProperty(JSON_PROPERTY_REQUIRED_LICENSES)
  @Schema(required = true)
  private List<ZLicense> requiredLicenses = new ArrayList<>();

  public static final String JSON_PROPERTY_STRINGS = "strings";
  @JsonbProperty(JSON_PROPERTY_STRINGS)
  @Schema(required = true)
  private List<String> strings = new ArrayList<>();

  public LicenseGroup licenses(List<ZLicense> licenses) {
    this.licenses = licenses;
    return this;
  }

  public LicenseGroup addLicensesItem(ZLicense licensesItem) {
    if (this.licenses == null) {
      this.licenses = new ArrayList<>();
    }
    this.licenses.add(licensesItem);
    return this;
  }

  /**
   * Get licenses
   * @return licenses
   **/
  @Size(min = 1, max = 4)
  public List<@Valid ZLicense> getLicenses() {
    return licenses;
  }

  public void setLicenses(List<ZLicense> licenses) {
    this.licenses = licenses;
  }

  public LicenseGroup numbers(List<Integer> numbers) {
    this.numbers = Objects.requireNonNull(numbers, "Property numbers is required, cannot be null");
    return this;
  }

  public LicenseGroup addNumbersItem(int numbersItem) {
    this.numbers.add(numbersItem);
    return this;
  }

  /**
   * Get numbers
   * minimum: 7L
   *
   * @return numbers
   **/
  @NotNull @Size(max = 100)
  public List<@Min(7L) Integer> getNumbers() {
    return numbers;
  }

  public void setNumbers(List<Integer> numbers) {
    this.numbers = Objects.requireNonNull(numbers, "Property numbers is required, cannot be null");
  }

  public LicenseGroup requiredLicenses(List<ZLicense> requiredLicenses) {
    this.requiredLicenses = Objects.requireNonNull(requiredLicenses, "Property requiredLicenses is required, cannot be null");
    return this;
  }

  public LicenseGroup addRequiredLicensesItem(ZLicense requiredLicensesItem) {
    this.requiredLicenses.add(requiredLicensesItem);
    return this;
  }

  /**
   * Get requiredLicenses
   * @return requiredLicenses
   **/
  @NotNull @Size(min = 1, max = 4)
  public List<@Valid ZLicense> getRequiredLicenses() {
    return requiredLicenses;
  }

  public void setRequiredLicenses(List<ZLicense> requiredLicenses) {
    this.requiredLicenses = Objects.requireNonNull(requiredLicenses, "Property requiredLicenses is required, cannot be null");
  }

  public LicenseGroup strings(List<String> strings) {
    this.strings = Objects.requireNonNull(strings, "Property strings is required, cannot be null");
    return this;
  }

  public LicenseGroup addStringsItem(String stringsItem) {
    this.strings.add(stringsItem);
    return this;
  }

  /**
   * Get strings
   * @return strings
   **/
  @NotNull @Size(min = 4, max = 8)
  public List<String> getStrings() {
    return strings;
  }

  public void setStrings(List<String> strings) {
    this.strings = Objects.requireNonNull(strings, "Property strings is required, cannot be null");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof LicenseGroup)) {
      return false;
    }
    LicenseGroup other = (LicenseGroup) o;
    return Objects.equals(this.licenses, other.licenses) &&
        Objects.equals(this.numbers, other.numbers) &&
        Objects.equals(this.requiredLicenses, other.requiredLicenses) &&
        Objects.equals(this.strings, other.strings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(licenses, numbers, requiredLicenses, strings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LicenseGroup {");
    sb.append("\n    licenses: ").append(toIndentedString(licenses));
    sb.append("\n    numbers: ").append(toIndentedString(numbers));
    sb.append("\n    requiredLicenses: ").append(toIndentedString(requiredLicenses));
    sb.append("\n    strings: ").append(toIndentedString(strings));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
