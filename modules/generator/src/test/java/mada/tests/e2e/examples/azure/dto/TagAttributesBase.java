/*
 * Azure Container Registry
 * Metadata API definition for the Azure Container Registry runtime
 *
 * The version of the OpenAPI document: 2019-08-15-preview
 */

package mada.tests.e2e.examples.azure.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.validation.Valid;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Tag attribute details
 */
@Schema(description = "Tag attribute details")
@JsonbPropertyOrder({
  TagAttributesBase.JSON_PROPERTY_NAME,
  TagAttributesBase.JSON_PROPERTY_DIGEST,
  TagAttributesBase.JSON_PROPERTY_CREATED_TIME,
  TagAttributesBase.JSON_PROPERTY_LAST_UPDATE_TIME,
  TagAttributesBase.JSON_PROPERTY_SIGNED,
  TagAttributesBase.JSON_PROPERTY_CHANGEABLE_ATTRIBUTES
})
@javax.annotation.Generated(value = "dk.mada.jaxrs.Generator")
public class TagAttributesBase {
  public static final String JSON_PROPERTY_NAME = "name";
  @JsonbProperty(JSON_PROPERTY_NAME)
  @Schema(description = "Tag name")
  private String name;

  public static final String JSON_PROPERTY_DIGEST = "digest";
  @JsonbProperty(JSON_PROPERTY_DIGEST)
  @Schema(description = "Tag digest")
  private String digest;

  public static final String JSON_PROPERTY_CREATED_TIME = "createdTime";
  @JsonbProperty(JSON_PROPERTY_CREATED_TIME)
  @Schema(description = "Tag created time")
  private String createdTime;

  public static final String JSON_PROPERTY_LAST_UPDATE_TIME = "lastUpdateTime";
  @JsonbProperty(JSON_PROPERTY_LAST_UPDATE_TIME)
  @Schema(description = "Tag last update time")
  private String lastUpdateTime;

  public static final String JSON_PROPERTY_SIGNED = "signed";
  @JsonbProperty(JSON_PROPERTY_SIGNED)
  @Schema(description = "Is signed")
  private Boolean signed;

  public static final String JSON_PROPERTY_CHANGEABLE_ATTRIBUTES = "changeableAttributes";
  @JsonbProperty(JSON_PROPERTY_CHANGEABLE_ATTRIBUTES)
  private TagChangeableAttributes changeableAttributes;

  public TagAttributesBase name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Tag name.
   *
   * @return name
   **/
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public TagAttributesBase digest(String digest) {
    this.digest = digest;
    return this;
  }

  /**
   * Tag digest.
   *
   * @return digest
   **/
  public String getDigest() {
    return digest;
  }

  public void setDigest(String digest) {
    this.digest = digest;
  }

  public TagAttributesBase createdTime(String createdTime) {
    this.createdTime = createdTime;
    return this;
  }

  /**
   * Tag created time.
   *
   * @return createdTime
   **/
  public String getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(String createdTime) {
    this.createdTime = createdTime;
  }

  public TagAttributesBase lastUpdateTime(String lastUpdateTime) {
    this.lastUpdateTime = lastUpdateTime;
    return this;
  }

  /**
   * Tag last update time.
   *
   * @return lastUpdateTime
   **/
  public String getLastUpdateTime() {
    return lastUpdateTime;
  }

  public void setLastUpdateTime(String lastUpdateTime) {
    this.lastUpdateTime = lastUpdateTime;
  }

  public TagAttributesBase signed(Boolean signed) {
    this.signed = signed;
    return this;
  }

  /**
   * Is signed.
   *
   * @return signed
   **/
  public Boolean isSigned() {
    return signed;
  }

  public void setSigned(Boolean signed) {
    this.signed = signed;
  }

  public TagAttributesBase changeableAttributes(TagChangeableAttributes changeableAttributes) {
    this.changeableAttributes = changeableAttributes;
    return this;
  }

  /**
   * Get changeableAttributes
   * @return changeableAttributes
   **/
  @Valid
  public TagChangeableAttributes getChangeableAttributes() {
    return changeableAttributes;
  }

  public void setChangeableAttributes(TagChangeableAttributes changeableAttributes) {
    this.changeableAttributes = changeableAttributes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TagAttributesBase other = (TagAttributesBase) o;
    return Objects.equals(this.name, other.name) &&
        Objects.equals(this.digest, other.digest) &&
        Objects.equals(this.createdTime, other.createdTime) &&
        Objects.equals(this.lastUpdateTime, other.lastUpdateTime) &&
        Objects.equals(this.signed, other.signed) &&
        Objects.equals(this.changeableAttributes, other.changeableAttributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, digest, createdTime, lastUpdateTime, signed, changeableAttributes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TagAttributesBase {");
    sb.append("\n    name: ").append(toIndentedString(name));
    sb.append("\n    digest: ").append(toIndentedString(digest));
    sb.append("\n    createdTime: ").append(toIndentedString(createdTime));
    sb.append("\n    lastUpdateTime: ").append(toIndentedString(lastUpdateTime));
    sb.append("\n    signed: ").append(toIndentedString(signed));
    sb.append("\n    changeableAttributes: ").append(toIndentedString(changeableAttributes));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
