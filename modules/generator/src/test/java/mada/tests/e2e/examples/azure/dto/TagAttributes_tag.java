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
 * Tag.
 */
@Schema(description = "Tag")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class TagAttributes_tag {
    public static final String JSON_PROPERTY_SIGNATURE_RECORD = "signatureRecord";
    @JsonbProperty(JSON_PROPERTY_SIGNATURE_RECORD)
    @Schema(description = "SignatureRecord value")
    private String signatureRecord;

    public TagAttributes_tag signatureRecord(String signatureRecord) {
        this.signatureRecord = signatureRecord;
        return this;
    }

    /**
     * SignatureRecord value.
     * @return signatureRecord
     **/
    public String getSignatureRecord() {
        return signatureRecord;
    }

    public void setSignatureRecord(String signatureRecord) {
        this.signatureRecord = signatureRecord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TagAttributes_tag)) {
            return false;
        }
        TagAttributes_tag other = (TagAttributes_tag) o;
        return Objects.equals(this.signatureRecord, other.signatureRecord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(signatureRecord);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TagAttributes_tag {");
        sb.append("\n    signatureRecord: ").append(toIndentedString(signatureRecord));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
