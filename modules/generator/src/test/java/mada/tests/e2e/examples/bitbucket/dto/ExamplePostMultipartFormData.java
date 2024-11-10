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
 * ExamplePostMultipartFormData
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ExamplePostMultipartFormData {
    public static final String JSON_PROPERTY_CONTENT = "content";
    @JsonbProperty(JSON_PROPERTY_CONTENT)
    @Schema(description = "The hook script contents.")
    private String content;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    @JsonbProperty(JSON_PROPERTY_DESCRIPTION)
    @Schema(description = "A description of the hook script (useful when querying registered hook scripts).")
    private String description;

    public static final String JSON_PROPERTY_NAME = "name";
    @JsonbProperty(JSON_PROPERTY_NAME)
    @Schema(description = "The name of the hook script (useful when querying registered hook scripts).")
    private String name;

    public static final String JSON_PROPERTY_TYPE = "type";
    @JsonbProperty(JSON_PROPERTY_TYPE)
    @Schema(description = "The type of hook script; supported values are \"PRE\" for pre-receive hooks and \"POST\" for post-receive hooks.")
    private String type;

    public ExamplePostMultipartFormData content(String content) {
        this.content = content;
        return this;
    }

    /**
     * The hook script contents.
     * @return content
     **/
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ExamplePostMultipartFormData description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A description of the hook script (useful when querying registered hook scripts).
     * @return description
     **/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ExamplePostMultipartFormData name(String name) {
        this.name = name;
        return this;
    }

    /**
     * The name of the hook script (useful when querying registered hook scripts).
     * @return name
     **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ExamplePostMultipartFormData type(String type) {
        this.type = type;
        return this;
    }

    /**
     * The type of hook script; supported values are "PRE" for pre-receive hooks and "POST" for post-receive hooks.
     * @return type
     **/
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ExamplePostMultipartFormData)) {
            return false;
        }
        ExamplePostMultipartFormData other = (ExamplePostMultipartFormData) o;
        return Objects.equals(this.content, other.content) &&
                Objects.equals(this.description, other.description) &&
                Objects.equals(this.name, other.name) &&
                Objects.equals(this.type, other.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, description, name, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ExamplePostMultipartFormData {");
        sb.append("\n    content: ").append(toIndentedString(content));
        sb.append("\n    description: ").append(toIndentedString(description));
        sb.append("\n    name: ").append(toIndentedString(name));
        sb.append("\n    type: ").append(toIndentedString(type));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
