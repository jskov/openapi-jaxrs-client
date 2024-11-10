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
 * Error information.
 */
@Schema(description = "Error information")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class AcrErrorInfo {
    public static final String JSON_PROPERTY_CODE = "code";
    @JsonbProperty(JSON_PROPERTY_CODE)
    @Schema(description = "Error code")
    private String code;

    public static final String JSON_PROPERTY_DETAIL = "detail";
    @JsonbProperty(JSON_PROPERTY_DETAIL)
    @Schema(description = "Error details")
    private Object detail;

    public static final String JSON_PROPERTY_MESSAGE = "message";
    @JsonbProperty(JSON_PROPERTY_MESSAGE)
    @Schema(description = "Error message")
    private String message;

    public AcrErrorInfo code(String code) {
        this.code = code;
        return this;
    }

    /**
     * Error code.
     * 
     * @return code
     **/
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public AcrErrorInfo detail(Object detail) {
        this.detail = detail;
        return this;
    }

    /**
     * Error details.
     * 
     * @return detail
     **/
    public Object getDetail() {
        return detail;
    }

    public void setDetail(Object detail) {
        this.detail = detail;
    }

    public AcrErrorInfo message(String message) {
        this.message = message;
        return this;
    }

    /**
     * Error message.
     * 
     * @return message
     **/
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AcrErrorInfo)) {
            return false;
        }
        AcrErrorInfo other = (AcrErrorInfo) o;
        return Objects.equals(this.code, other.code) &&
                Objects.equals(this.detail, other.detail) &&
                Objects.equals(this.message, other.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, detail, message);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AcrErrorInfo {");
        sb.append("\n    code: ").append(toIndentedString(code));
        sb.append("\n    detail: ").append(toIndentedString(detail));
        sb.append("\n    message: ").append(toIndentedString(message));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
