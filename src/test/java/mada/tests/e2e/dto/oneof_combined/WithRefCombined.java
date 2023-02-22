package mada.tests.e2e.dto.oneof_combined;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WithRefCombined {
    public static final String JSON_PROPERTY_VALUE_BAR_STRING = "valueBarString";
    @JsonProperty(JSON_PROPERTY_VALUE_BAR_STRING)
    private String valueBarString;

    public static final String JSON_PROPERTY_VALUE_FOO_LONG = "valueFooLong";
    @JsonProperty(JSON_PROPERTY_VALUE_FOO_LONG)
    private Long valueFooLong;
}
