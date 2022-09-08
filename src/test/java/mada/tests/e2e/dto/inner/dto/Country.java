/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.dto.inner.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.validation.Valid;

/**
 * Country
 */
@JsonbPropertyOrder({
  Country.JSON_PROPERTY_TWO_LETTER_CODE,
  Country.JSON_PROPERTY_THREE_LETTER_CODE,
  Country.JSON_PROPERTY_NUMERIC_CODE,
  Country.JSON_PROPERTY_COUNTRY_NAME_DK,
  Country.JSON_PROPERTY_COUNTRY_NAME_GB,
  Country.JSON_PROPERTY_COUNTRY_NAME,
  Country.JSON_PROPERTY_LOCALE,
  Country.JSON_PROPERTY_REGISTERED_AS_BOND_COUNTRY,
  Country.JSON_PROPERTY_REGISTERED_AS_SHARE_COUNTRY
})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class Country {
  public static final String JSON_PROPERTY_TWO_LETTER_CODE = "twoLetterCode";
  @JsonbProperty(JSON_PROPERTY_TWO_LETTER_CODE)
  private String twoLetterCode;

  public static final String JSON_PROPERTY_THREE_LETTER_CODE = "threeLetterCode";
  @JsonbProperty(JSON_PROPERTY_THREE_LETTER_CODE)
  private String threeLetterCode;

  public static final String JSON_PROPERTY_NUMERIC_CODE = "numericCode";
  @JsonbProperty(JSON_PROPERTY_NUMERIC_CODE)
  private Integer numericCode;

  public static final String JSON_PROPERTY_COUNTRY_NAME_DK = "countryNameDK";
  @JsonbProperty(JSON_PROPERTY_COUNTRY_NAME_DK)
  private String countryNameDK;

  public static final String JSON_PROPERTY_COUNTRY_NAME_GB = "countryNameGB";
  @JsonbProperty(JSON_PROPERTY_COUNTRY_NAME_GB)
  private String countryNameGB;

  public static final String JSON_PROPERTY_COUNTRY_NAME = "countryName";
  @JsonbProperty(JSON_PROPERTY_COUNTRY_NAME)
  private String countryName;

  public static final String JSON_PROPERTY_LOCALE = "locale";
  @JsonbProperty(JSON_PROPERTY_LOCALE)
  private CountryLocale locale;

  public static final String JSON_PROPERTY_REGISTERED_AS_BOND_COUNTRY = "registeredAsBondCountry";
  @JsonbProperty(JSON_PROPERTY_REGISTERED_AS_BOND_COUNTRY)
  private Boolean registeredAsBondCountry;

  public static final String JSON_PROPERTY_REGISTERED_AS_SHARE_COUNTRY = "registeredAsShareCountry";
  @JsonbProperty(JSON_PROPERTY_REGISTERED_AS_SHARE_COUNTRY)
  private Boolean registeredAsShareCountry;

  public Country twoLetterCode(String twoLetterCode) {
    this.twoLetterCode = twoLetterCode;
    return this;
  }

  /**
   * Get twoLetterCode
   * @return twoLetterCode
   **/
  public String getTwoLetterCode() {
    return twoLetterCode;
  }

  public void setTwoLetterCode(String twoLetterCode) {
    this.twoLetterCode = twoLetterCode;
  }

  public Country threeLetterCode(String threeLetterCode) {
    this.threeLetterCode = threeLetterCode;
    return this;
  }

  /**
   * Get threeLetterCode
   * @return threeLetterCode
   **/
  public String getThreeLetterCode() {
    return threeLetterCode;
  }

  public void setThreeLetterCode(String threeLetterCode) {
    this.threeLetterCode = threeLetterCode;
  }

  public Country numericCode(Integer numericCode) {
    this.numericCode = numericCode;
    return this;
  }

  /**
   * Get numericCode
   * @return numericCode
   **/
  public Integer getNumericCode() {
    return numericCode;
  }

  public void setNumericCode(Integer numericCode) {
    this.numericCode = numericCode;
  }

  public Country countryNameDK(String countryNameDK) {
    this.countryNameDK = countryNameDK;
    return this;
  }

  /**
   * Get countryNameDK
   * @return countryNameDK
   **/
  public String getCountryNameDK() {
    return countryNameDK;
  }

  public void setCountryNameDK(String countryNameDK) {
    this.countryNameDK = countryNameDK;
  }

  public Country countryNameGB(String countryNameGB) {
    this.countryNameGB = countryNameGB;
    return this;
  }

  /**
   * Get countryNameGB
   * @return countryNameGB
   **/
  public String getCountryNameGB() {
    return countryNameGB;
  }

  public void setCountryNameGB(String countryNameGB) {
    this.countryNameGB = countryNameGB;
  }

  public Country countryName(String countryName) {
    this.countryName = countryName;
    return this;
  }

  /**
   * Get countryName
   * @return countryName
   **/
  public String getCountryName() {
    return countryName;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }

  public Country locale(CountryLocale locale) {
    this.locale = locale;
    return this;
  }

  /**
   * Get locale
   * @return locale
   **/
  @Valid
  public CountryLocale getLocale() {
    return locale;
  }

  public void setLocale(CountryLocale locale) {
    this.locale = locale;
  }

  public Country registeredAsBondCountry(Boolean registeredAsBondCountry) {
    this.registeredAsBondCountry = registeredAsBondCountry;
    return this;
  }

  /**
   * Get registeredAsBondCountry
   * @return registeredAsBondCountry
   **/
  public Boolean isRegisteredAsBondCountry() {
    return registeredAsBondCountry;
  }

  public void setRegisteredAsBondCountry(Boolean registeredAsBondCountry) {
    this.registeredAsBondCountry = registeredAsBondCountry;
  }

  public Country registeredAsShareCountry(Boolean registeredAsShareCountry) {
    this.registeredAsShareCountry = registeredAsShareCountry;
    return this;
  }

  /**
   * Get registeredAsShareCountry
   * @return registeredAsShareCountry
   **/
  public Boolean isRegisteredAsShareCountry() {
    return registeredAsShareCountry;
  }

  public void setRegisteredAsShareCountry(Boolean registeredAsShareCountry) {
    this.registeredAsShareCountry = registeredAsShareCountry;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Country other = (Country) o;
    return Objects.equals(this.twoLetterCode, other.twoLetterCode) &&
        Objects.equals(this.threeLetterCode, other.threeLetterCode) &&
        Objects.equals(this.numericCode, other.numericCode) &&
        Objects.equals(this.countryNameDK, other.countryNameDK) &&
        Objects.equals(this.countryNameGB, other.countryNameGB) &&
        Objects.equals(this.countryName, other.countryName) &&
        Objects.equals(this.locale, other.locale) &&
        Objects.equals(this.registeredAsBondCountry, other.registeredAsBondCountry) &&
        Objects.equals(this.registeredAsShareCountry, other.registeredAsShareCountry);
  }

  @Override
  public int hashCode() {
    return Objects.hash(twoLetterCode, threeLetterCode, numericCode, countryNameDK, countryNameGB, countryName, locale, registeredAsBondCountry, registeredAsShareCountry);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Country {");
    sb.append("\n    twoLetterCode: ").append(toIndentedString(twoLetterCode));
    sb.append("\n    threeLetterCode: ").append(toIndentedString(threeLetterCode));
    sb.append("\n    numericCode: ").append(toIndentedString(numericCode));
    sb.append("\n    countryNameDK: ").append(toIndentedString(countryNameDK));
    sb.append("\n    countryNameGB: ").append(toIndentedString(countryNameGB));
    sb.append("\n    countryName: ").append(toIndentedString(countryName));
    sb.append("\n    locale: ").append(toIndentedString(locale));
    sb.append("\n    registeredAsBondCountry: ").append(toIndentedString(registeredAsBondCountry));
    sb.append("\n    registeredAsShareCountry: ").append(toIndentedString(registeredAsShareCountry));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
