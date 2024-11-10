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
 * ExampleJsonLastModifiedCallback
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ExampleJsonLastModifiedCallback {
    public static final String JSON_PROPERTY_LATEST_COMMIT = "latestCommit";
    @JsonbProperty(JSON_PROPERTY_LATEST_COMMIT)
    private ExampleJsonLastModifiedCallbackLatestCommit latestCommit;

    public static final String JSON_PROPERTY_POM_XML = "pomXml";
    @JsonbProperty(JSON_PROPERTY_POM_XML)
    private ExampleJsonLastModifiedCallbackPomXml pomXml;

    public static final String JSON_PROPERTY_README_MD = "readmeMd";
    @JsonbProperty(JSON_PROPERTY_README_MD)
    private ExampleJsonLastModifiedCallbackReadmeMd readmeMd;

    public ExampleJsonLastModifiedCallback latestCommit(ExampleJsonLastModifiedCallbackLatestCommit latestCommit) {
        this.latestCommit = latestCommit;
        return this;
    }

    /**
     * Get latestCommit
     *
     * @return latestCommit
     **/
    @Valid public ExampleJsonLastModifiedCallbackLatestCommit getLatestCommit() {
        return latestCommit;
    }

    public void setLatestCommit(ExampleJsonLastModifiedCallbackLatestCommit latestCommit) {
        this.latestCommit = latestCommit;
    }

    public ExampleJsonLastModifiedCallback pomXml(ExampleJsonLastModifiedCallbackPomXml pomXml) {
        this.pomXml = pomXml;
        return this;
    }

    /**
     * Get pomXml
     *
     * @return pomXml
     **/
    @Valid public ExampleJsonLastModifiedCallbackPomXml getPomXml() {
        return pomXml;
    }

    public void setPomXml(ExampleJsonLastModifiedCallbackPomXml pomXml) {
        this.pomXml = pomXml;
    }

    public ExampleJsonLastModifiedCallback readmeMd(ExampleJsonLastModifiedCallbackReadmeMd readmeMd) {
        this.readmeMd = readmeMd;
        return this;
    }

    /**
     * Get readmeMd
     *
     * @return readmeMd
     **/
    @Valid public ExampleJsonLastModifiedCallbackReadmeMd getReadmeMd() {
        return readmeMd;
    }

    public void setReadmeMd(ExampleJsonLastModifiedCallbackReadmeMd readmeMd) {
        this.readmeMd = readmeMd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ExampleJsonLastModifiedCallback)) {
            return false;
        }
        ExampleJsonLastModifiedCallback other = (ExampleJsonLastModifiedCallback) o;
        return Objects.equals(this.latestCommit, other.latestCommit) &&
                Objects.equals(this.pomXml, other.pomXml) &&
                Objects.equals(this.readmeMd, other.readmeMd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(latestCommit, pomXml, readmeMd);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ExampleJsonLastModifiedCallback {");
        sb.append("\n    latestCommit: ").append(toIndentedString(latestCommit));
        sb.append("\n    pomXml: ").append(toIndentedString(pomXml));
        sb.append("\n    readmeMd: ").append(toIndentedString(readmeMd));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
