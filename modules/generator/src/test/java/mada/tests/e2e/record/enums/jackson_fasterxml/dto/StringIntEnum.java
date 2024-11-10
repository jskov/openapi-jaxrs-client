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
 * The values are digits, but the type is string. So will not be handled as integers, but are invalid Java identifiers.
 */
@Schema(
        enumeration = { "1", "2", "-3" },
        type = SchemaType.STRING,
        description = "The values are digits, but the type is string. So will not be handled as integers, but are invalid Java identifiers.")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum StringIntEnum {
    NUMBER_1("1"),
    NUMBER_2("2"),
    NUMBER_NEG_3("-3");

    private final String value;

    StringIntEnum(String value) {
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
    public static StringIntEnum fromValue(String value) {
        for (StringIntEnum b : StringIntEnum.values()) {
            if (Objects.equals(b.value, value)) {
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
