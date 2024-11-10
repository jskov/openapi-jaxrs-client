/*
 * Azure Container Registry
 * Metadata API definition for the Azure Container Registry runtime
 *
 * The version of the OpenAPI document: 2019-08-15-preview
 */

package mada.tests.e2e.examples.azure.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * TagChangeableAttributes
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class TagChangeableAttributes {
    public static final String JSON_PROPERTY_DELETE_ENABLED = "deleteEnabled";
    @JsonbProperty(JSON_PROPERTY_DELETE_ENABLED)
    @Schema(description = "Delete enabled")
    private Boolean deleteEnabled;

    public static final String JSON_PROPERTY_LIST_ENABLED = "listEnabled";
    @JsonbProperty(JSON_PROPERTY_LIST_ENABLED)
    @Schema(description = "List enabled")
    private Boolean listEnabled;

    public static final String JSON_PROPERTY_READ_ENABLED = "readEnabled";
    @JsonbProperty(JSON_PROPERTY_READ_ENABLED)
    @Schema(description = "Read enabled")
    private Boolean readEnabled;

    public static final String JSON_PROPERTY_WRITE_ENABLED = "writeEnabled";
    @JsonbProperty(JSON_PROPERTY_WRITE_ENABLED)
    @Schema(description = "Write enabled")
    private Boolean writeEnabled;

    public TagChangeableAttributes deleteEnabled(Boolean deleteEnabled) {
        this.deleteEnabled = deleteEnabled;
        return this;
    }

    /**
     * Delete enabled.
     * 
     * @return deleteEnabled
     **/
    public Boolean isDeleteEnabled() {
        return deleteEnabled;
    }

    public void setDeleteEnabled(Boolean deleteEnabled) {
        this.deleteEnabled = deleteEnabled;
    }

    public TagChangeableAttributes listEnabled(Boolean listEnabled) {
        this.listEnabled = listEnabled;
        return this;
    }

    /**
     * List enabled.
     * 
     * @return listEnabled
     **/
    public Boolean isListEnabled() {
        return listEnabled;
    }

    public void setListEnabled(Boolean listEnabled) {
        this.listEnabled = listEnabled;
    }

    public TagChangeableAttributes readEnabled(Boolean readEnabled) {
        this.readEnabled = readEnabled;
        return this;
    }

    /**
     * Read enabled.
     * 
     * @return readEnabled
     **/
    public Boolean isReadEnabled() {
        return readEnabled;
    }

    public void setReadEnabled(Boolean readEnabled) {
        this.readEnabled = readEnabled;
    }

    public TagChangeableAttributes writeEnabled(Boolean writeEnabled) {
        this.writeEnabled = writeEnabled;
        return this;
    }

    /**
     * Write enabled.
     * 
     * @return writeEnabled
     **/
    public Boolean isWriteEnabled() {
        return writeEnabled;
    }

    public void setWriteEnabled(Boolean writeEnabled) {
        this.writeEnabled = writeEnabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TagChangeableAttributes)) {
            return false;
        }
        TagChangeableAttributes other = (TagChangeableAttributes) o;
        return Objects.equals(this.deleteEnabled, other.deleteEnabled) &&
                Objects.equals(this.listEnabled, other.listEnabled) &&
                Objects.equals(this.readEnabled, other.readEnabled) &&
                Objects.equals(this.writeEnabled, other.writeEnabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deleteEnabled, listEnabled, readEnabled, writeEnabled);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TagChangeableAttributes {");
        sb.append("\n    deleteEnabled: ").append(toIndentedString(deleteEnabled));
        sb.append("\n    listEnabled: ").append(toIndentedString(listEnabled));
        sb.append("\n    readEnabled: ").append(toIndentedString(readEnabled));
        sb.append("\n    writeEnabled: ").append(toIndentedString(writeEnabled));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
