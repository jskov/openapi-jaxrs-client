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
import jakarta.validation.constraints.Pattern;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestInsightReportData
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestInsightReportData {
    public static final String JSON_PROPERTY_TITLE = "title";
    @JsonbProperty(JSON_PROPERTY_TITLE)
    @Schema(example = "data.title")
    private String title;

    public static final String JSON_PROPERTY_TYPE = "type";
    @JsonbProperty(JSON_PROPERTY_TYPE)
    @Schema(example = "NUMBER")
    private String type;

    public static final String JSON_PROPERTY_VALUE = "value";
    @JsonbProperty(JSON_PROPERTY_VALUE)
    @Schema(example = "9")
    private Object value;

    public RestInsightReportData title(String title) {
        this.title = title;
        return this;
    }

    /**
     * Get title
     *
     * @return title
     **/
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public RestInsightReportData type(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     **/
    public @Pattern(regexp = "BOOLEAN|DATE|DURATION|LINK|NUMBER|PERCENTAGE|TEXT") String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public RestInsightReportData value(Object value) {
        this.value = value;
        return this;
    }

    /**
     * Get value
     *
     * @return value
     **/
    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestInsightReportData)) {
            return false;
        }
        RestInsightReportData other = (RestInsightReportData) o;
        return Objects.equals(this.title, other.title) &&
                Objects.equals(this.type, other.type) &&
                Objects.equals(this.value, other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, type, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestInsightReportData {");
        sb.append("\n    title: ").append(toIndentedString(title));
        sb.append("\n    type: ").append(toIndentedString(type));
        sb.append("\n    value: ").append(toIndentedString(value));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
