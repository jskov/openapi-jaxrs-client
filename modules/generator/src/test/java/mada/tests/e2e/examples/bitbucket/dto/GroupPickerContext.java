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
 * GroupPickerContext
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class GroupPickerContext {
    public static final String JSON_PROPERTY_CONTEXT = "context";
    @JsonbProperty(JSON_PROPERTY_CONTEXT)
    @Schema(example = "user_a")
    private String context;

    public static final String JSON_PROPERTY_ITEM_NAME = "itemName";
    @JsonbProperty(JSON_PROPERTY_ITEM_NAME)
    @Schema(example = "group_a")
    private String itemName;

    public GroupPickerContext context(String context) {
        this.context = context;
        return this;
    }

    /**
     * Get context
     *
     * @return context
     **/
    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public GroupPickerContext itemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    /**
     * Get itemName
     *
     * @return itemName
     **/
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GroupPickerContext)) {
            return false;
        }
        GroupPickerContext other = (GroupPickerContext) o;
        return Objects.equals(this.context, other.context) &&
                Objects.equals(this.itemName, other.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(context, itemName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GroupPickerContext {");
        sb.append("\n    context: ").append(toIndentedString(context));
        sb.append("\n    itemName: ").append(toIndentedString(itemName));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
