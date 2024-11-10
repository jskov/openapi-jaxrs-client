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
import java.util.Arrays;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * ExampleCertificateMultipartFormData
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ExampleCertificateMultipartFormData {
    public static final String JSON_PROPERTY_CERTIFICATE = "certificate";
    @JsonbProperty(JSON_PROPERTY_CERTIFICATE)
    @Schema(description = "The X.509 certificate file to upload.")
    private byte[] certificate;

    public ExampleCertificateMultipartFormData certificate(byte[] certificate) {
        this.certificate = certificate;
        return this;
    }

    /**
     * The X.509 certificate file to upload.
     * @return certificate
     **/
    public byte[] getCertificate() {
        return certificate;
    }

    public void setCertificate(byte[] certificate) {
        this.certificate = certificate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ExampleCertificateMultipartFormData)) {
            return false;
        }
        ExampleCertificateMultipartFormData other = (ExampleCertificateMultipartFormData) o;
        return Arrays.equals(this.certificate, other.certificate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(certificate));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ExampleCertificateMultipartFormData {");
        sb.append("\n    certificate: ").append(toIndentedString(certificate));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
