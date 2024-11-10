/*
 * Auditlog API
 * API for accessing the auditlogging
 *
 * The version of the OpenAPI document: 1.0.0
 */

package mada.tests.e2e.api.types_mediatypes.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * ViolationConstraint
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ViolationConstraint {
    public static final String JSON_PROPERTY_VIOLATIONS = "violations";
    @JsonbProperty(JSON_PROPERTY_VIOLATIONS)
    private List<Violation> violations;

    public ViolationConstraint violations(List<Violation> violations) {
        this.violations = violations;
        return this;
    }

    public ViolationConstraint addViolationsItem(Violation violationsItem) {
        if (this.violations == null) {
            this.violations = new ArrayList<>();
        }
        this.violations.add(violationsItem);
        return this;
    }

    /**
     * Get violations
     *
     * @return violations
     **/
    @Valid
    public List<Violation> getViolations() {
        return violations;
    }

    public void setViolations(List<Violation> violations) {
        this.violations = violations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ViolationConstraint)) {
            return false;
        }
        ViolationConstraint other = (ViolationConstraint) o;
        return Objects.equals(this.violations, other.violations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(violations);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ViolationConstraint {");
        sb.append("\n    violations: ").append(toIndentedString(violations));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
