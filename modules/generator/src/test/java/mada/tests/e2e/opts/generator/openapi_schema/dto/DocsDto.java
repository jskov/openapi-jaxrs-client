/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.opts.generator.openapi_schema.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;

/**
 * Class description.
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class DocsDto {
    public static final String JSON_PROPERTY_DANISH_PROPERTY = "danishProperty";
    @JsonbProperty(JSON_PROPERTY_DANISH_PROPERTY)
    private String danishProperty;

    public static final String JSON_PROPERTY_DOS_PROPERTY = "dosProperty";
    @JsonbProperty(JSON_PROPERTY_DOS_PROPERTY)
    private String dosProperty;

    public static final String JSON_PROPERTY_PROPERTY = "property";
    @JsonbProperty(JSON_PROPERTY_PROPERTY)
    private String property;

    public DocsDto danishProperty(String danishProperty) {
        this.danishProperty = danishProperty;
        return this;
    }

    /**
     * Danish characters æøåÆØÅ dóh!
     * @return danishProperty
     **/
    public String getDanishProperty() {
        return danishProperty;
    }

    public void setDanishProperty(String danishProperty) {
        this.danishProperty = danishProperty;
    }

    public DocsDto dosProperty(String dosProperty) {
        this.dosProperty = dosProperty;
        return this;
    }

    /**
     * Property description. Property description line 2
   * Last line.
     * @return dosProperty
     **/
    public String getDosProperty() {
        return dosProperty;
    }

    public void setDosProperty(String dosProperty) {
        this.dosProperty = dosProperty;
    }

    public DocsDto property(String property) {
        this.property = property;
        return this;
    }

    /**
     * Property description. Property description line 2
   * Last line.
     * @return property
     **/
    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DocsDto)) {
            return false;
        }
        DocsDto other = (DocsDto) o;
        return Objects.equals(this.danishProperty, other.danishProperty) &&
                Objects.equals(this.dosProperty, other.dosProperty) &&
                Objects.equals(this.property, other.property);
    }

    @Override
    public int hashCode() {
        return Objects.hash(danishProperty, dosProperty, property);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DocsDto {");
        sb.append("\n    danishProperty: ").append(toIndentedString(danishProperty));
        sb.append("\n    dosProperty: ").append(toIndentedString(dosProperty));
        sb.append("\n    property: ").append(toIndentedString(property));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
