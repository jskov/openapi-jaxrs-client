/*
 * Test
 *
 * The version of the OpenAPI document: 1.0.0
 */

package mada.tests.e2e.opts.parser.no_type.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * AendringElement
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class AendringElement {
    public static final String JSON_PROPERTY_AENDRING = "aendring";
    @JsonbProperty(JSON_PROPERTY_AENDRING)
    @Schema(required = true, description = "Ændring som beskrevet i KRO API")
    private String aendring;

    public static final String JSON_PROPERTY_NY = "ny";
    @JsonbProperty(JSON_PROPERTY_NY)
    @Schema(description = "Ønsket værdi")
    private Object ny;

    public static final String JSON_PROPERTY_OPRINDELIG = "oprindelig";
    @JsonbProperty(JSON_PROPERTY_OPRINDELIG)
    @Schema(description = "Oprindelig værdi")
    private Object oprindelig;

    public static final String JSON_PROPERTY_VALUE_TYPE = "valueType";
    @JsonbProperty(JSON_PROPERTY_VALUE_TYPE)
    @Schema(description = "Værdiens tekniske type (JAVA)")
    private String valueType;

    public AendringElement aendring(String aendring) {
        this.aendring = Objects.requireNonNull(aendring, "Property aendring is required, cannot be null");
        return this;
    }

    /**
     * Ændring som beskrevet i KRO API.
     * @return aendring
     **/
    @NotNull public String getAendring() {
        return aendring;
    }

    public void setAendring(String aendring) {
        this.aendring = Objects.requireNonNull(aendring, "Property aendring is required, cannot be null");
    }

    public AendringElement ny(Object ny) {
        this.ny = ny;
        return this;
    }

    /**
     * Ønsket værdi.
     * @return ny
     **/
    public Object getNy() {
        return ny;
    }

    public void setNy(Object ny) {
        this.ny = ny;
    }

    public AendringElement oprindelig(Object oprindelig) {
        this.oprindelig = oprindelig;
        return this;
    }

    /**
     * Oprindelig værdi.
     * @return oprindelig
     **/
    public Object getOprindelig() {
        return oprindelig;
    }

    public void setOprindelig(Object oprindelig) {
        this.oprindelig = oprindelig;
    }

    public AendringElement valueType(String valueType) {
        this.valueType = valueType;
        return this;
    }

    /**
     * Værdiens tekniske type (JAVA).
     * @return valueType
     **/
    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AendringElement)) {
            return false;
        }
        AendringElement other = (AendringElement) o;
        return Objects.equals(this.aendring, other.aendring) &&
                Objects.equals(this.ny, other.ny) &&
                Objects.equals(this.oprindelig, other.oprindelig) &&
                Objects.equals(this.valueType, other.valueType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(aendring, ny, oprindelig, valueType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AendringElement {");
        sb.append("\n    aendring: ").append(toIndentedString(aendring));
        sb.append("\n    ny: ").append(toIndentedString(ny));
        sb.append("\n    oprindelig: ").append(toIndentedString(oprindelig));
        sb.append("\n    valueType: ").append(toIndentedString(valueType));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
