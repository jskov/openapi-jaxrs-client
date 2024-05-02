/*
 * Bitbucket Data Center
 * This is the reference document for the Atlassian Bitbucket REST API. The REST API is for developers who want to:

 - integrate Bitbucket with other applications;

 - create scripts that interact with Bitbucket; or

 - develop plugins that enhance the Bitbucket UI, using REST to interact with the backend.

 You can read more about developing Bitbucket plugins in the [Bitbucket Developer Documentation](https://developer.atlassian.com/bitbucket/server/docs/latest/).
 *
 * The version of the OpenAPI document: 8.19
 */

package mada.tests.e2e.examples.bitbucket.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import java.time.OffsetDateTime;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * _RequestSshLatestKeys
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class _RequestSshLatestKeys {
  public static final String JSON_PROPERTY_ALGORITHM_TYPE = "algorithmType";
  @JsonbProperty(JSON_PROPERTY_ALGORITHM_TYPE)
  private String algorithmType;

  public static final String JSON_PROPERTY_BIT_LENGTH = "bitLength";
  @JsonbProperty(JSON_PROPERTY_BIT_LENGTH)
  private Integer bitLength;

  public static final String JSON_PROPERTY_CREATED_DATE = "createdDate";
  @JsonbProperty(JSON_PROPERTY_CREATED_DATE)
  @Schema(readOnly = true)
  private OffsetDateTime createdDate;

  public static final String JSON_PROPERTY_EXPIRY_DAYS = "expiryDays";
  @JsonbProperty(JSON_PROPERTY_EXPIRY_DAYS)
  @Schema(example = "30")
  private Integer expiryDays;

  public static final String JSON_PROPERTY_FINGERPRINT = "fingerprint";
  @JsonbProperty(JSON_PROPERTY_FINGERPRINT)
  @Schema(readOnly = true, example = "Cbg38r+gDCiNHqBk6Y1BKO+EvufFBqhFWIEXh8oq9MI")
  private String fingerprint;

  public static final String JSON_PROPERTY_ID = "id";
  @JsonbProperty(JSON_PROPERTY_ID)
  @Schema(readOnly = true, example = "1")
  private Integer id;

  public static final String JSON_PROPERTY_LABEL = "label";
  @JsonbProperty(JSON_PROPERTY_LABEL)
  @Schema(example = "me@127.0.0.1")
  private String label;

  public static final String JSON_PROPERTY_LAST_AUTHENTICATED = "lastAuthenticated";
  @JsonbProperty(JSON_PROPERTY_LAST_AUTHENTICATED)
  @Schema(readOnly = true, example = "1630041546434")
  private String lastAuthenticated;

  public static final String JSON_PROPERTY_TEXT = "text";
  @JsonbProperty(JSON_PROPERTY_TEXT)
  @Schema(example = "ssh-rsa AAAAB3... me@127.0.0.1")
  private String text;

  public _RequestSshLatestKeys algorithmType(String algorithmType) {
    this.algorithmType = algorithmType;
    return this;
  }

  /**
   * Get algorithmType
   * @return algorithmType
   **/
  public String getAlgorithmType() {
    return algorithmType;
  }

  public void setAlgorithmType(String algorithmType) {
    this.algorithmType = algorithmType;
  }

  public _RequestSshLatestKeys bitLength(Integer bitLength) {
    this.bitLength = bitLength;
    return this;
  }

  /**
   * Get bitLength
   * @return bitLength
   **/
  public Integer getBitLength() {
    return bitLength;
  }

  public void setBitLength(Integer bitLength) {
    this.bitLength = bitLength;
  }

  public _RequestSshLatestKeys createdDate(OffsetDateTime createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  /**
   * Get createdDate
   * @return createdDate
   **/
  public OffsetDateTime getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(OffsetDateTime createdDate) {
    this.createdDate = createdDate;
  }

  public _RequestSshLatestKeys expiryDays(Integer expiryDays) {
    this.expiryDays = expiryDays;
    return this;
  }

  /**
   * Get expiryDays
   * @return expiryDays
   **/
  public Integer getExpiryDays() {
    return expiryDays;
  }

  public void setExpiryDays(Integer expiryDays) {
    this.expiryDays = expiryDays;
  }

  public _RequestSshLatestKeys fingerprint(String fingerprint) {
    this.fingerprint = fingerprint;
    return this;
  }

  /**
   * Get fingerprint
   * @return fingerprint
   **/
  public String getFingerprint() {
    return fingerprint;
  }

  public void setFingerprint(String fingerprint) {
    this.fingerprint = fingerprint;
  }

  public _RequestSshLatestKeys id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public _RequestSshLatestKeys label(String label) {
    this.label = label;
    return this;
  }

  /**
   * Get label
   * @return label
   **/
  public String getLabel() {
    return label;
  }

  public void setLabel(String label) {
    this.label = label;
  }

  public _RequestSshLatestKeys lastAuthenticated(String lastAuthenticated) {
    this.lastAuthenticated = lastAuthenticated;
    return this;
  }

  /**
   * Get lastAuthenticated
   * @return lastAuthenticated
   **/
  public String getLastAuthenticated() {
    return lastAuthenticated;
  }

  public void setLastAuthenticated(String lastAuthenticated) {
    this.lastAuthenticated = lastAuthenticated;
  }

  public _RequestSshLatestKeys text(String text) {
    this.text = text;
    return this;
  }

  /**
   * Get text
   * @return text
   **/
  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof _RequestSshLatestKeys)) {
      return false;
    }
    _RequestSshLatestKeys other = (_RequestSshLatestKeys) o;
    return Objects.equals(this.algorithmType, other.algorithmType) &&
        Objects.equals(this.bitLength, other.bitLength) &&
        Objects.equals(this.createdDate, other.createdDate) &&
        Objects.equals(this.expiryDays, other.expiryDays) &&
        Objects.equals(this.fingerprint, other.fingerprint) &&
        Objects.equals(this.id, other.id) &&
        Objects.equals(this.label, other.label) &&
        Objects.equals(this.lastAuthenticated, other.lastAuthenticated) &&
        Objects.equals(this.text, other.text);
  }

  @Override
  public int hashCode() {
    return Objects.hash(algorithmType, bitLength, createdDate, expiryDays, fingerprint, id, label, lastAuthenticated, text);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class _RequestSshLatestKeys {");
    sb.append("\n    algorithmType: ").append(toIndentedString(algorithmType));
    sb.append("\n    bitLength: ").append(toIndentedString(bitLength));
    sb.append("\n    createdDate: ").append(toIndentedString(createdDate));
    sb.append("\n    expiryDays: ").append(toIndentedString(expiryDays));
    sb.append("\n    fingerprint: ").append(toIndentedString(fingerprint));
    sb.append("\n    id: ").append(toIndentedString(id));
    sb.append("\n    label: ").append(toIndentedString(label));
    sb.append("\n    lastAuthenticated: ").append(toIndentedString(lastAuthenticated));
    sb.append("\n    text: ").append(toIndentedString(text));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
