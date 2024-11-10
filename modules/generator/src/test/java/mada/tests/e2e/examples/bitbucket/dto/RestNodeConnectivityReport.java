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
 * RestNodeConnectivityReport
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestNodeConnectivityReport {
    public static final String JSON_PROPERTY_NODE = "node";
    @JsonbProperty(JSON_PROPERTY_NODE)
    private RestNodeConnectivityReportNode node;

    public static final String JSON_PROPERTY_SUMMARIES = "summaries";
    @JsonbProperty(JSON_PROPERTY_SUMMARIES)
    private List<RestNodeConnectivitySummary> summaries;

    public RestNodeConnectivityReport node(RestNodeConnectivityReportNode node) {
        this.node = node;
        return this;
    }

    /**
     * Get node
     *
     * @return node
     **/
    @Valid
    public RestNodeConnectivityReportNode getNode() {
        return node;
    }

    public void setNode(RestNodeConnectivityReportNode node) {
        this.node = node;
    }

    public RestNodeConnectivityReport summaries(List<RestNodeConnectivitySummary> summaries) {
        this.summaries = summaries;
        return this;
    }

    public RestNodeConnectivityReport addSummariesItem(RestNodeConnectivitySummary summariesItem) {
        if (this.summaries == null) {
            this.summaries = new ArrayList<>();
        }
        this.summaries.add(summariesItem);
        return this;
    }

    /**
     * Get summaries
     *
     * @return summaries
     **/
    @Valid
    public List<RestNodeConnectivitySummary> getSummaries() {
        return summaries;
    }

    public void setSummaries(List<RestNodeConnectivitySummary> summaries) {
        this.summaries = summaries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestNodeConnectivityReport)) {
            return false;
        }
        RestNodeConnectivityReport other = (RestNodeConnectivityReport) o;
        return Objects.equals(this.node, other.node) &&
                Objects.equals(this.summaries, other.summaries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(node, summaries);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestNodeConnectivityReport {");
        sb.append("\n    node: ").append(toIndentedString(node));
        sb.append("\n    summaries: ").append(toIndentedString(summaries));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
