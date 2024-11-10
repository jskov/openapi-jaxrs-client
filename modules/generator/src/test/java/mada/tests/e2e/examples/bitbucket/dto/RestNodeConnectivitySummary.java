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
import java.util.Objects;

/**
 * RestNodeConnectivitySummary
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestNodeConnectivitySummary {
    public static final String JSON_PROPERTY_NODE = "node";
    @JsonbProperty(JSON_PROPERTY_NODE)
    private RestNodeConnectivitySummaryNode node;

    public static final String JSON_PROPERTY_SUMMARY = "summary";
    @JsonbProperty(JSON_PROPERTY_SUMMARY)
    private RestNodeConnectivitySummarySummary summary;

    public RestNodeConnectivitySummary node(RestNodeConnectivitySummaryNode node) {
        this.node = node;
        return this;
    }

    /**
     * Get node
     *
     * @return node
     **/
    @Valid
    public RestNodeConnectivitySummaryNode getNode() {
        return node;
    }

    public void setNode(RestNodeConnectivitySummaryNode node) {
        this.node = node;
    }

    public RestNodeConnectivitySummary summary(RestNodeConnectivitySummarySummary summary) {
        this.summary = summary;
        return this;
    }

    /**
     * Get summary
     *
     * @return summary
     **/
    @Valid
    public RestNodeConnectivitySummarySummary getSummary() {
        return summary;
    }

    public void setSummary(RestNodeConnectivitySummarySummary summary) {
        this.summary = summary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestNodeConnectivitySummary)) {
            return false;
        }
        RestNodeConnectivitySummary other = (RestNodeConnectivitySummary) o;
        return Objects.equals(this.node, other.node) &&
                Objects.equals(this.summary, other.summary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(node, summary);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestNodeConnectivitySummary {");
        sb.append("\n    node: ").append(toIndentedString(node));
        sb.append("\n    summary: ").append(toIndentedString(summary));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
