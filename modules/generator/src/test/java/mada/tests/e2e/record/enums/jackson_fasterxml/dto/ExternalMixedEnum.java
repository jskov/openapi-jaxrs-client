/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.record.enums.jackson_fasterxml.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * ExternalMixedEnum
 */
@Schema(enumeration = {"low_EXT_a", "low_ext_B"}, type = SchemaType.STRING)
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum ExternalMixedEnum {
    LOW_EXT_A("low_EXT_a"),
    LOW_EXT_B("low_ext_B");

    private final String value;

    ExternalMixedEnum(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @JsonCreator
    public static ExternalMixedEnum fromValue(String value) {
        for (ExternalMixedEnum b : ExternalMixedEnum.values()) {
            if (Objects.equals(b.value, value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
