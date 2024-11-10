/*
 * Azure Container Registry
 * Metadata API definition for the Azure Container Registry runtime
 *
 * The version of the OpenAPI document: 2019-08-15-preview
 */

package mada.tests.e2e.examples.azure.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.validation.Valid;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * A JSON web signature.
 */
@Schema(description = "A JSON web signature")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class JWK {
    public static final String JSON_PROPERTY_ALG = "alg";
    @JsonbProperty(JSON_PROPERTY_ALG)
    @Schema(description = "The algorithm used to sign or encrypt the JWT")
    private String alg;

    public static final String JSON_PROPERTY_JWK = "jwk";
    @JsonbProperty(JSON_PROPERTY_JWK)
    private JWKHeader jwk;

    public JWK alg(String alg) {
        this.alg = alg;
        return this;
    }

    /**
     * The algorithm used to sign or encrypt the JWT.
     * @return alg
     **/
    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }

    public JWK jwk(JWKHeader jwk) {
        this.jwk = jwk;
        return this;
    }

    /**
     * Get jwk
     *
     * @return jwk
     **/
    public @Valid JWKHeader getJwk() {
        return jwk;
    }

    public void setJwk(JWKHeader jwk) {
        this.jwk = jwk;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof JWK)) {
            return false;
        }
        JWK other = (JWK) o;
        return Objects.equals(this.alg, other.alg) &&
                Objects.equals(this.jwk, other.jwk);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alg, jwk);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class JWK {");
        sb.append("\n    alg: ").append(toIndentedString(alg));
        sb.append("\n    jwk: ").append(toIndentedString(jwk));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
