/*
 * openapi-examples API
 *
 * The version of the OpenAPI document: 1.0.0-SNAPSHOT
 */

package mada.tests.e2e.opts.generator.validation.no_requirenonnull.jsonb.dto;

import java.util.Objects;
import java.util.UUID;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * AdresseIdentifikationDto
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class AdresseIdentifikationDto {
    public static final String JSON_PROPERTY_ADGANGSADRESSE_ID = "adgangsadresseId";
    @JsonbProperty(JSON_PROPERTY_ADGANGSADRESSE_ID)
    @Schema(required = true)
    private UUID adgangsadresseId;

    public static final String JSON_PROPERTY_ADRESSE_ID = "adresseId";
    @JsonbProperty(JSON_PROPERTY_ADRESSE_ID)
    @Schema(required = true, nullable = true)
    private UUID adresseId;

    public AdresseIdentifikationDto adgangsadresseId(UUID adgangsadresseId) {
        this.adgangsadresseId = adgangsadresseId;
        return this;
    }

    /**
     * Get adgangsadresseId
     *
     * @return adgangsadresseId
     **/
    @NotNull public UUID getAdgangsadresseId() {
        return adgangsadresseId;
    }

    public void setAdgangsadresseId(UUID adgangsadresseId) {
        this.adgangsadresseId = adgangsadresseId;
    }

    public AdresseIdentifikationDto adresseId(UUID adresseId) {
        this.adresseId = adresseId;
        return this;
    }

    /**
     * Get adresseId
     *
     * @return adresseId
     **/
    public UUID getAdresseId() {
        return adresseId;
    }

    public void setAdresseId(UUID adresseId) {
        this.adresseId = adresseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AdresseIdentifikationDto)) {
            return false;
        }
        AdresseIdentifikationDto other = (AdresseIdentifikationDto) o;
        return Objects.equals(this.adgangsadresseId, other.adgangsadresseId) &&
                Objects.equals(this.adresseId, other.adresseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adgangsadresseId, adresseId);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AdresseIdentifikationDto {");
        sb.append("\n    adgangsadresseId: ").append(toIndentedString(adgangsadresseId));
        sb.append("\n    adresseId: ").append(toIndentedString(adresseId));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
