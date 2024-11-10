/*
 * Bitbucket Data Center
 * This is the reference document for the Atlassian Bitbucket REST API. The REST API is for developers who want to:

 - integrate Bitbucket with other applications;

 - create scripts that interact with Bitbucket; or

 - develop plugins that enhance the Bitbucket UI, using REST to interact with the backend.

 You can read more about developing Bitbucket plugins in the [Bitbucket Developer Documentation](https://developer.atlassian.com/bitbucket/server/docs/latest/).
 *
 * The version of the OpenAPI document: 8.19
 */

package mada.tests.e2e.examples.bitbucket.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * RestMeshConnectivityReport
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestMeshConnectivityReport {
    public static final String JSON_PROPERTY_REPORTS = "reports";
    @JsonbProperty(JSON_PROPERTY_REPORTS)
    private List<RestNodeConnectivityReport> reports;

    public RestMeshConnectivityReport reports(List<RestNodeConnectivityReport> reports) {
        this.reports = reports;
        return this;
    }

    public RestMeshConnectivityReport addReportsItem(RestNodeConnectivityReport reportsItem) {
        if (this.reports == null) {
            this.reports = new ArrayList<>();
        }
        this.reports.add(reportsItem);
        return this;
    }

    /**
     * Get reports
     *
     * @return reports
     **/
    public @Valid List<RestNodeConnectivityReport> getReports() {
        return reports;
    }

    public void setReports(List<RestNodeConnectivityReport> reports) {
        this.reports = reports;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestMeshConnectivityReport)) {
            return false;
        }
        RestMeshConnectivityReport other = (RestMeshConnectivityReport) o;
        return Objects.equals(this.reports, other.reports);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reports);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestMeshConnectivityReport {");
        sb.append("\n    reports: ").append(toIndentedString(reports));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
