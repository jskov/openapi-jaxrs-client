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
 * RestMirroredRepositoryDescriptor
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestMirroredRepositoryDescriptor {
    public static final String JSON_PROPERTY_LINKS = "links";
    @JsonbProperty(JSON_PROPERTY_LINKS)
    private Object links;

    public static final String JSON_PROPERTY_MIRROR_SERVER = "mirrorServer";
    @JsonbProperty(JSON_PROPERTY_MIRROR_SERVER)
    private RestMirroredRepositoryDescriptorMirrorServer mirrorServer;

    public RestMirroredRepositoryDescriptor links(Object links) {
        this.links = links;
        return this;
    }

    /**
     * Get links
     *
     * @return links
     **/
    public Object getLinks() {
        return links;
    }

    public void setLinks(Object links) {
        this.links = links;
    }

    public RestMirroredRepositoryDescriptor mirrorServer(RestMirroredRepositoryDescriptorMirrorServer mirrorServer) {
        this.mirrorServer = mirrorServer;
        return this;
    }

    /**
     * Get mirrorServer
     *
     * @return mirrorServer
     **/
    @Valid public RestMirroredRepositoryDescriptorMirrorServer getMirrorServer() {
        return mirrorServer;
    }

    public void setMirrorServer(RestMirroredRepositoryDescriptorMirrorServer mirrorServer) {
        this.mirrorServer = mirrorServer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestMirroredRepositoryDescriptor)) {
            return false;
        }
        RestMirroredRepositoryDescriptor other = (RestMirroredRepositoryDescriptor) o;
        return Objects.equals(this.links, other.links) &&
                Objects.equals(this.mirrorServer, other.mirrorServer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(links, mirrorServer);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestMirroredRepositoryDescriptor {");
        sb.append("\n    links: ").append(toIndentedString(links));
        sb.append("\n    mirrorServer: ").append(toIndentedString(mirrorServer));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
