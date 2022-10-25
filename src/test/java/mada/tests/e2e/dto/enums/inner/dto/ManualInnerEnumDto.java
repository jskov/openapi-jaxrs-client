/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.dto.enums.inner.dto;

import java.util.Objects;
import javax.json.Json;
import javax.json.JsonString;
import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.json.bind.annotation.JsonbTypeAdapter;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * ManualInnerEnumDto
 */
@JsonbPropertyOrder({
  ManualInnerEnumDto.JSON_PROPERTY_RECEIVER,
  ManualInnerEnumDto.JSON_PROPERTY_STRING_TYPE,
  ManualInnerEnumDto.JSON_PROPERTY_NUMBER_TYPE
})
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ManualInnerEnumDto {
  public static final String JSON_PROPERTY_RECEIVER = "receiver";
  @JsonbProperty(JSON_PROPERTY_RECEIVER)
  private String receiver;

  /**
   * This selects transport form.
   * EMAIL = this is an email
   * SMS : this is an SMS
   */
  public enum StringTypeEnum {
    EMAIL("EMAIL"),
    SMS("SMS");

    private final String value;

    StringTypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static class StringTypeEnumAdapter implements JsonbAdapter<StringTypeEnum, JsonString> {
      @Override
      public JsonString adaptToJson(StringTypeEnum e) throws Exception {
        return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public StringTypeEnum adaptFromJson(JsonString value) throws Exception {
        for (StringTypeEnum b : StringTypeEnum.values()) {
          if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
            return b;
          }
        }
        throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type StringTypeEnum");
      }
    }
  }

  public static final String JSON_PROPERTY_STRING_TYPE = "stringType";
  @JsonbProperty(JSON_PROPERTY_STRING_TYPE)
  @JsonbTypeAdapter(mada.tests.e2e.dto.enums.inner.dto.ManualInnerEnumDto.StringTypeEnum.StringTypeEnumAdapter.class)
  @Schema(description = "This selects transport form.\nEMAIL = this is an email\nSMS : this is an SMS")
  private StringTypeEnum stringType;

  @Schema(enumeration = {"1", "2"}, type = SchemaType.INTEGER, format = "int32")
  public enum NumberTypeEnum {
    NUMBER_1(1),
    NUMBER_2(2);

    private final int value;

    NumberTypeEnum(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static class NumberTypeEnumAdapter implements JsonbAdapter<NumberTypeEnum, JsonString> {
      @Override
      public JsonString adaptToJson(NumberTypeEnum e) throws Exception {
        return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public NumberTypeEnum adaptFromJson(JsonString value) throws Exception {
        for (NumberTypeEnum b : NumberTypeEnum.values()) {
          if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
            return b;
          }
        }
        throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type NumberTypeEnum");
      }
    }
  }

  public static final String JSON_PROPERTY_NUMBER_TYPE = "numberType";
  @JsonbProperty(JSON_PROPERTY_NUMBER_TYPE)
  @JsonbTypeAdapter(mada.tests.e2e.dto.enums.inner.dto.ManualInnerEnumDto.NumberTypeEnum.NumberTypeEnumAdapter.class)
  private NumberTypeEnum numberType;

  public ManualInnerEnumDto receiver(String receiver) {
    this.receiver = receiver;
    return this;
  }

  /**
   * Get receiver
   * @return receiver
   **/
  public String getReceiver() {
    return receiver;
  }

  public void setReceiver(String receiver) {
    this.receiver = receiver;
  }

  public ManualInnerEnumDto stringType(StringTypeEnum stringType) {
    this.stringType = stringType;
    return this;
  }

  /**
   * This selects transport form.
   * EMAIL = this is an email
   * SMS : this is an SMS
   *
   * @return stringType
   **/
  public StringTypeEnum getStringType() {
    return stringType;
  }

  public void setStringType(StringTypeEnum stringType) {
    this.stringType = stringType;
  }

  public ManualInnerEnumDto numberType(NumberTypeEnum numberType) {
    this.numberType = numberType;
    return this;
  }

  /**
   * Get numberType
   * @return numberType
   **/
  public NumberTypeEnum getNumberType() {
    return numberType;
  }

  public void setNumberType(NumberTypeEnum numberType) {
    this.numberType = numberType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ManualInnerEnumDto other = (ManualInnerEnumDto) o;
    return Objects.equals(this.receiver, other.receiver) &&
        Objects.equals(this.stringType, other.stringType) &&
        Objects.equals(this.numberType, other.numberType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(receiver, stringType, numberType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ManualInnerEnumDto {");
    sb.append("\n    receiver: ").append(toIndentedString(receiver));
    sb.append("\n    stringType: ").append(toIndentedString(stringType));
    sb.append("\n    numberType: ").append(toIndentedString(numberType));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
