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

import jakarta.json.Json;
import jakarta.json.JsonString;
import jakarta.json.bind.adapter.JsonbAdapter;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTypeAdapter;
import java.time.OffsetDateTime;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestJobMessage
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestJobMessage {
    public static final String JSON_PROPERTY_CREATED_DATE = "createdDate";
    @JsonbProperty(JSON_PROPERTY_CREATED_DATE)
    private OffsetDateTime createdDate;

    public static final String JSON_PROPERTY_ID = "id";
    @JsonbProperty(JSON_PROPERTY_ID)
    @Schema(example = "617")
    private String id;

    public enum SeverityEnum {
        INFO("INFO"),
        WARN("WARN"),
        ERROR("ERROR");

        private final String value;

        SeverityEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static class SeverityEnumAdapter implements JsonbAdapter<SeverityEnum, JsonString> {
            @Override
            public JsonString adaptToJson(SeverityEnum e) throws Exception {
                return Json.createValue(String.valueOf(e.value));
            }

            @Override
            public SeverityEnum adaptFromJson(JsonString value) throws Exception {
                for (SeverityEnum b : SeverityEnum.values()) {
                    if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                        return b;
                    }
                }
                throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type SeverityEnum");
            }
        }
    }

    public static final String JSON_PROPERTY_SEVERITY = "severity";
    @JsonbProperty(JSON_PROPERTY_SEVERITY)
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestJobMessage.SeverityEnum.SeverityEnumAdapter.class)
    private SeverityEnum severity;

    public static final String JSON_PROPERTY_SUBJECT = "subject";
    @JsonbProperty(JSON_PROPERTY_SUBJECT)
    @Schema(example = "job")
    private String subject;

    public static final String JSON_PROPERTY_TEXT = "text";
    @JsonbProperty(JSON_PROPERTY_TEXT)
    @Schema(example = "Something of interest happened")
    private String text;

    public RestJobMessage createdDate(OffsetDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    /**
     * Get createdDate
     *
     * @return createdDate
     **/
    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(OffsetDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public RestJobMessage id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RestJobMessage severity(SeverityEnum severity) {
        this.severity = severity;
        return this;
    }

    /**
     * Get severity
     *
     * @return severity
     **/
    public SeverityEnum getSeverity() {
        return severity;
    }

    public void setSeverity(SeverityEnum severity) {
        this.severity = severity;
    }

    public RestJobMessage subject(String subject) {
        this.subject = subject;
        return this;
    }

    /**
     * Get subject
     *
     * @return subject
     **/
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public RestJobMessage text(String text) {
        this.text = text;
        return this;
    }

    /**
     * Get text
     *
     * @return text
     **/
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestJobMessage)) {
            return false;
        }
        RestJobMessage other = (RestJobMessage) o;
        return Objects.equals(this.createdDate, other.createdDate) &&
                Objects.equals(this.id, other.id) &&
                Objects.equals(this.severity, other.severity) &&
                Objects.equals(this.subject, other.subject) &&
                Objects.equals(this.text, other.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdDate, id, severity, subject, text);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestJobMessage {");
        sb.append("\n    createdDate: ").append(toIndentedString(createdDate));
        sb.append("\n    id: ").append(toIndentedString(id));
        sb.append("\n    severity: ").append(toIndentedString(severity));
        sb.append("\n    subject: ").append(toIndentedString(subject));
        sb.append("\n    text: ").append(toIndentedString(text));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
