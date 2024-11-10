/*
 * KFA-KRO
 *
 * The version of the OpenAPI document: 1.1.1
 */

package mada.tests.e2e.dto.allof_composite.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * EjendomMini
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class EjendomMini {
    public static final String JSON_PROPERTY_HUSNR = "husnr";
    @JsonProperty(JSON_PROPERTY_HUSNR)
    @Schema(required = true, description = "Husnummeret på ejendommen.<br>Format: String(10)")
    private String husnr;

    public EjendomMini husnr(String husnr) {
        this.husnr = Objects.requireNonNull(husnr, "Property husnr is required, cannot be null");
        return this;
    }

    /**
     * Husnummeret på ejendommen.<br>
     * Format: String(10)
     * 
     * @return husnr
     **/
    @NotNull @Size(min = 0, max = 10)
    public String getHusnr() {
        return husnr;
    }

    public void setHusnr(String husnr) {
        this.husnr = Objects.requireNonNull(husnr, "Property husnr is required, cannot be null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EjendomMini)) {
            return false;
        }
        EjendomMini other = (EjendomMini) o;
        return Objects.equals(this.husnr, other.husnr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(husnr);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class EjendomMini {");
        sb.append("\n    husnr: ").append(toIndentedString(husnr));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
