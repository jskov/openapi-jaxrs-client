/*
 * Test
 *
 * The version of the OpenAPI document: 1.0.0
 */

package mada.tests.e2e.regression.alloflookup.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * fixation.
 */
@Schema(description = "fixation")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class InterestRateFixation {
    public static final String JSON_PROPERTY_LOAN_TYPE = "loanType";
    @JsonbProperty(JSON_PROPERTY_LOAN_TYPE)
    private String loanType;

    public InterestRateFixation loanType(String loanType) {
        this.loanType = loanType;
        return this;
    }

    /**
     * Get loanType
     *
     * @return loanType
     **/
    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof InterestRateFixation)) {
            return false;
        }
        InterestRateFixation other = (InterestRateFixation) o;
        return Objects.equals(this.loanType, other.loanType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class InterestRateFixation {");
        sb.append("\n    loanType: ").append(toIndentedString(loanType));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
