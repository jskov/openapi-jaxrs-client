/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.dto.inner.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.json.Json;
import javax.json.JsonString;
import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.annotation.JsonbProperty;

/**
 * EnumArrayInner
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class EnumArrayInner {
    public enum MuligeUdbetalingsMetoderEnum {
        HURTIGST_MULIGT("HURTIGST_MULIGT"),
        UKENDT("UKENDT");

        private final String value;

        MuligeUdbetalingsMetoderEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static class MuligeUdbetalingsMetoderEnumAdapter implements JsonbAdapter<MuligeUdbetalingsMetoderEnum, JsonString> {
            @Override
            public JsonString adaptToJson(MuligeUdbetalingsMetoderEnum e) throws Exception {
                return Json.createValue(String.valueOf(e.value));
            }

            @Override
            public MuligeUdbetalingsMetoderEnum adaptFromJson(JsonString value) throws Exception {
                for (MuligeUdbetalingsMetoderEnum b : MuligeUdbetalingsMetoderEnum.values()) {
                    if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                        return b;
                    }
                }
                throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type MuligeUdbetalingsMetoderEnum");
            }
        }
    }

    public static final String JSON_PROPERTY_MULIGE_UDBETALINGS_METODER = "muligeUdbetalingsMetoder";
    @JsonbProperty(JSON_PROPERTY_MULIGE_UDBETALINGS_METODER)
    private List<MuligeUdbetalingsMetoderEnum> muligeUdbetalingsMetoder;

    public EnumArrayInner muligeUdbetalingsMetoder(List<MuligeUdbetalingsMetoderEnum> muligeUdbetalingsMetoder) {
        this.muligeUdbetalingsMetoder = muligeUdbetalingsMetoder;
        return this;
    }

    public EnumArrayInner addMuligeUdbetalingsMetoderItem(MuligeUdbetalingsMetoderEnum muligeUdbetalingsMetoderItem) {
        if (this.muligeUdbetalingsMetoder == null) {
            this.muligeUdbetalingsMetoder = new ArrayList<>();
        }
        this.muligeUdbetalingsMetoder.add(muligeUdbetalingsMetoderItem);
        return this;
    }

    /**
     * Get muligeUdbetalingsMetoder
     *
     * @return muligeUdbetalingsMetoder
     **/
    public List<MuligeUdbetalingsMetoderEnum> getMuligeUdbetalingsMetoder() {
        return muligeUdbetalingsMetoder;
    }

    public void setMuligeUdbetalingsMetoder(List<MuligeUdbetalingsMetoderEnum> muligeUdbetalingsMetoder) {
        this.muligeUdbetalingsMetoder = muligeUdbetalingsMetoder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EnumArrayInner)) {
            return false;
        }
        EnumArrayInner other = (EnumArrayInner) o;
        return Objects.equals(this.muligeUdbetalingsMetoder, other.muligeUdbetalingsMetoder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(muligeUdbetalingsMetoder);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EnumArrayInner {");
        sb.append("\n    muligeUdbetalingsMetoder: ").append(toIndentedString(muligeUdbetalingsMetoder));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
