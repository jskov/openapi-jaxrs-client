/*
 * jboss-helloworld
 *
 * The version of the OpenAPI document: 1.0
 */

package mada.tests.e2e.dto.allof_dups.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;

/**
 * Omkostninger
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class Omkostninger {
    public static final String JSON_PROPERTY_FGOO = "fgoo";
    @JsonbProperty(JSON_PROPERTY_FGOO)
    private Integer fgoo;

    public Omkostninger fgoo(Integer fgoo) {
        this.fgoo = fgoo;
        return this;
    }

    /**
     * Get fgoo
     *
     * @return fgoo
     **/
    public Integer getFgoo() {
        return fgoo;
    }

    public void setFgoo(Integer fgoo) {
        this.fgoo = fgoo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Omkostninger)) {
            return false;
        }
        Omkostninger other = (Omkostninger) o;
        return Objects.equals(this.fgoo, other.fgoo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fgoo);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Omkostninger {");
        sb.append("\n    fgoo: ").append(toIndentedString(fgoo));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
