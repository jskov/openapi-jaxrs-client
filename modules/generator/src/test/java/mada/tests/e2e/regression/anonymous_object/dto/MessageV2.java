/*
 * Test
 *
 * The version of the OpenAPI document: 1.0.0
 */

package mada.tests.e2e.regression.anonymous_object.dto;

import java.time.OffsetDateTime;
import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * MessageV2
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class MessageV2 {
    public static final String JSON_PROPERTY_SENT_AT = "sentAt";
    @JsonbProperty(JSON_PROPERTY_SENT_AT)
    @Schema(readOnly = true, description = "Time the message was sent. Automatically generated at POST.")
    private OffsetDateTime sentAt;

    public MessageV2 sentAt(OffsetDateTime sentAt) {
        this.sentAt = sentAt;
        return this;
    }

    /**
     * Time the message was sent. Automatically generated at POST.
     * 
     * @return sentAt
     **/
    public OffsetDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(OffsetDateTime sentAt) {
        this.sentAt = sentAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MessageV2)) {
            return false;
        }
        MessageV2 other = (MessageV2) o;
        return Objects.equals(this.sentAt, other.sentAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentAt);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MessageV2 {");
        sb.append("\n    sentAt: ").append(toIndentedString(sentAt));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
