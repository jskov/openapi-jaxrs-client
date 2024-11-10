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
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestSingleAddInsightAnnotationRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestSingleAddInsightAnnotationRequest {
    public static final String JSON_PROPERTY_EXTERNAL_ID = "externalId";
    @JsonbProperty(JSON_PROPERTY_EXTERNAL_ID)
    @Schema(example = "message-1")
    private String externalId;

    public static final String JSON_PROPERTY_LINE = "line";
    @JsonbProperty(JSON_PROPERTY_LINE)
    @Schema(example = "4")
    private Integer line;

    public static final String JSON_PROPERTY_LINK = "link";
    @JsonbProperty(JSON_PROPERTY_LINK)
    @Schema(example = "https://link.to.tool/that/produced/annotation/message-1")
    private String link;

    public static final String JSON_PROPERTY_MESSAGE = "message";
    @JsonbProperty(JSON_PROPERTY_MESSAGE)
    @Schema(required = true, example = "This is a bug here because reasons")
    private String message;

    public static final String JSON_PROPERTY_PATH = "path";
    @JsonbProperty(JSON_PROPERTY_PATH)
    @Schema(example = "path/to/file/in/repo")
    private String path;

    public static final String JSON_PROPERTY_SEVERITY = "severity";
    @JsonbProperty(JSON_PROPERTY_SEVERITY)
    @Schema(required = true, example = "MEDIUM")
    private String severity;

    public static final String JSON_PROPERTY_TYPE = "type";
    @JsonbProperty(JSON_PROPERTY_TYPE)
    @Schema(example = "CODE_SMELL")
    private String type;

    public RestSingleAddInsightAnnotationRequest externalId(String externalId) {
        this.externalId = externalId;
        return this;
    }

    /**
     * Get externalId
     *
     * @return externalId
     **/
    @Size(min = 0, max = 450)
    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public RestSingleAddInsightAnnotationRequest line(Integer line) {
        this.line = line;
        return this;
    }

    /**
     * Get line minimum: 0L
     *
     * @return line
     **/
    @Min(0L)
    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public RestSingleAddInsightAnnotationRequest link(String link) {
        this.link = link;
        return this;
    }

    /**
     * Get link
     *
     * @return link
     **/
    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public RestSingleAddInsightAnnotationRequest message(String message) {
        this.message = Objects.requireNonNull(message, "Property message is required, cannot be null");
        return this;
    }

    /**
     * Get message
     *
     * @return message
     **/
    @NotNull @Size(min = 0, max = 2000)
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = Objects.requireNonNull(message, "Property message is required, cannot be null");
    }

    public RestSingleAddInsightAnnotationRequest path(String path) {
        this.path = path;
        return this;
    }

    /**
     * Get path
     *
     * @return path
     **/
    @Size(min = 0, max = 50000)
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public RestSingleAddInsightAnnotationRequest severity(String severity) {
        this.severity = Objects.requireNonNull(severity, "Property severity is required, cannot be null");
        return this;
    }

    /**
     * Get severity
     *
     * @return severity
     **/
    @NotNull @Pattern(regexp = "LOW|MEDIUM|HIGH")
    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = Objects.requireNonNull(severity, "Property severity is required, cannot be null");
    }

    public RestSingleAddInsightAnnotationRequest type(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     **/
    @Pattern(regexp = "VULNERABILITY|CODE_SMELL|BUG")
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
        if (!(o instanceof RestSingleAddInsightAnnotationRequest)) {
            return false;
        }
        RestSingleAddInsightAnnotationRequest other = (RestSingleAddInsightAnnotationRequest) o;
        return Objects.equals(this.externalId, other.externalId) &&
                Objects.equals(this.line, other.line) &&
                Objects.equals(this.link, other.link) &&
                Objects.equals(this.message, other.message) &&
                Objects.equals(this.path, other.path) &&
                Objects.equals(this.severity, other.severity) &&
                Objects.equals(this.type, other.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(externalId, line, link, message, path, severity, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestSingleAddInsightAnnotationRequest {");
        sb.append("\n    externalId: ").append(toIndentedString(externalId));
        sb.append("\n    line: ").append(toIndentedString(line));
        sb.append("\n    link: ").append(toIndentedString(link));
        sb.append("\n    message: ").append(toIndentedString(message));
        sb.append("\n    path: ").append(toIndentedString(path));
        sb.append("\n    severity: ").append(toIndentedString(severity));
        sb.append("\n    type: ").append(toIndentedString(type));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
