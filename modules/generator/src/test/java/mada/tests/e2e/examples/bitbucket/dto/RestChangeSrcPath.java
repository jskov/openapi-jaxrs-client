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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestChangeSrcPath
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestChangeSrcPath {
    public static final String JSON_PROPERTY_COMPONENTS = "components";
    @JsonbProperty(JSON_PROPERTY_COMPONENTS)
    @Schema(example = "[\"path\",\"to\",\"file.txt\"]")
    private List<String> components;

    public static final String JSON_PROPERTY_EXTENSION = "extension";
    @JsonbProperty(JSON_PROPERTY_EXTENSION)
    @Schema(example = "txt")
    private String extension;

    public static final String JSON_PROPERTY_NAME = "name";
    @JsonbProperty(JSON_PROPERTY_NAME)
    @Schema(example = "file.txt")
    private String name;

    public static final String JSON_PROPERTY_PARENT = "parent";
    @JsonbProperty(JSON_PROPERTY_PARENT)
    @Schema(example = "path/to")
    private String parent;

    public RestChangeSrcPath components(List<String> components) {
        this.components = components;
        return this;
    }

    public RestChangeSrcPath addComponentsItem(String componentsItem) {
        if (this.components == null) {
            this.components = new ArrayList<>();
        }
        this.components.add(componentsItem);
        return this;
    }

    /**
     * Get components
     *
     * @return components
     **/
    public List<String> getComponents() {
        return components;
    }

    public void setComponents(List<String> components) {
        this.components = components;
    }

    public RestChangeSrcPath extension(String extension) {
        this.extension = extension;
        return this;
    }

    /**
     * Get extension
     *
     * @return extension
     **/
    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public RestChangeSrcPath name(String name) {
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

    public RestChangeSrcPath parent(String parent) {
        this.parent = parent;
        return this;
    }

    /**
     * Get parent
     *
     * @return parent
     **/
    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestChangeSrcPath)) {
            return false;
        }
        RestChangeSrcPath other = (RestChangeSrcPath) o;
        return Objects.equals(this.components, other.components) &&
                Objects.equals(this.extension, other.extension) &&
                Objects.equals(this.name, other.name) &&
                Objects.equals(this.parent, other.parent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(components, extension, name, parent);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestChangeSrcPath {");
        sb.append("\n    components: ").append(toIndentedString(components));
        sb.append("\n    extension: ").append(toIndentedString(extension));
        sb.append("\n    name: ").append(toIndentedString(name));
        sb.append("\n    parent: ").append(toIndentedString(parent));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
