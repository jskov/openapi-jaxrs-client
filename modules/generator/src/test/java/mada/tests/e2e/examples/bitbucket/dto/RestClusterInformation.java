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
 * RestClusterInformation
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestClusterInformation {
    public static final String JSON_PROPERTY_LOCAL_NODE = "localNode";
    @JsonbProperty(JSON_PROPERTY_LOCAL_NODE)
    private RestClusterInformationLocalNode localNode;

    public static final String JSON_PROPERTY_NODES = "nodes";
    @JsonbProperty(JSON_PROPERTY_NODES)
    private List<RestClusterNode> nodes;

    public static final String JSON_PROPERTY_RUNNING = "running";
    @JsonbProperty(JSON_PROPERTY_RUNNING)
    private Boolean running;

    public RestClusterInformation localNode(RestClusterInformationLocalNode localNode) {
        this.localNode = localNode;
        return this;
    }

    /**
     * Get localNode
     *
     * @return localNode
     **/
    @Valid public RestClusterInformationLocalNode getLocalNode() {
        return localNode;
    }

    public void setLocalNode(RestClusterInformationLocalNode localNode) {
        this.localNode = localNode;
    }

    public RestClusterInformation nodes(List<RestClusterNode> nodes) {
        this.nodes = nodes;
        return this;
    }

    public RestClusterInformation addNodesItem(RestClusterNode nodesItem) {
        if (this.nodes == null) {
            this.nodes = new ArrayList<>();
        }
        this.nodes.add(nodesItem);
        return this;
    }

    /**
     * Get nodes
     *
     * @return nodes
     **/
    @Valid public List<RestClusterNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<RestClusterNode> nodes) {
        this.nodes = nodes;
    }

    public RestClusterInformation running(Boolean running) {
        this.running = running;
        return this;
    }

    /**
     * Get running
     *
     * @return running
     **/
    public Boolean isRunning() {
        return running;
    }

    public void setRunning(Boolean running) {
        this.running = running;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestClusterInformation)) {
            return false;
        }
        RestClusterInformation other = (RestClusterInformation) o;
        return Objects.equals(this.localNode, other.localNode) &&
                Objects.equals(this.nodes, other.nodes) &&
                Objects.equals(this.running, other.running);
    }

    @Override
    public int hashCode() {
        return Objects.hash(localNode, nodes, running);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestClusterInformation {");
        sb.append("\n    localNode: ").append(toIndentedString(localNode));
        sb.append("\n    nodes: ").append(toIndentedString(nodes));
        sb.append("\n    running: ").append(toIndentedString(running));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
