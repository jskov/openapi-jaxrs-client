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
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestNamedLink
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestNamedLink {
    public static final String JSON_PROPERTY_HREF = "href";
    @JsonbProperty(JSON_PROPERTY_HREF)
    @Schema(example = "https://bitbucket.example.com/scm/awesomeproject/awesomerepo.git")
    private String href;

    public static final String JSON_PROPERTY_NAME = "name";
    @JsonbProperty(JSON_PROPERTY_NAME)
    @Schema(example = "http")
    private String name;

    public RestNamedLink href(String href) {
        this.href = href;
        return this;
    }

    /**
     * Get href
     *
     * @return href
     **/
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public RestNamedLink name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestNamedLink)) {
            return false;
        }
        RestNamedLink other = (RestNamedLink) o;
        return Objects.equals(this.href, other.href) &&
                Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(href, name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestNamedLink {");
        sb.append("\n    href: ").append(toIndentedString(href));
        sb.append("\n    name: ").append(toIndentedString(name));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
