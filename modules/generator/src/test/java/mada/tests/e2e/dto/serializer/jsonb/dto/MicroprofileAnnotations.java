/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.dto.serializer.jsonb.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.NotNull;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * openapi class description.
 */
@Schema(description = "openapi class description")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class MicroprofileAnnotations {
    public static final String JSON_PROPERTY_DESCRIPTION_AND_EXAMPLE = "descriptionAndExample";
    @JsonbProperty(JSON_PROPERTY_DESCRIPTION_AND_EXAMPLE)
    @Schema(description = "text_description", example = "text_example")
    private String descriptionAndExample;

    public static final String JSON_PROPERTY_IS_READONLY = "isReadonly";
    @JsonbProperty(JSON_PROPERTY_IS_READONLY)
    @Schema(readOnly = true)
    private String isReadonly;

    public static final String JSON_PROPERTY_IS_REQUIRED = "isRequired";
    @JsonbProperty(JSON_PROPERTY_IS_REQUIRED)
    @Schema(required = true)
    private String isRequired;

    public static final String JSON_PROPERTY_READONLY_REQUIRED_AND_DESCRIPTION_AND_EXAMPLE = "readonlyRequiredAndDescriptionAndExample";
    @JsonbProperty(JSON_PROPERTY_READONLY_REQUIRED_AND_DESCRIPTION_AND_EXAMPLE)
    @Schema(required = true, readOnly = true, description = "text_description", example = "text_example")
    private String readonlyRequiredAndDescriptionAndExample;

    public static final String JSON_PROPERTY_REQUIRED_AND_DESCRIPTION = "requiredAndDescription";
    @JsonbProperty(JSON_PROPERTY_REQUIRED_AND_DESCRIPTION)
    @Schema(required = true, description = "text_description")
    private String requiredAndDescription;

    public static final String JSON_PROPERTY_REQUIRED_AND_DESCRIPTION_AND_EXAMPLE = "requiredAndDescriptionAndExample";
    @JsonbProperty(JSON_PROPERTY_REQUIRED_AND_DESCRIPTION_AND_EXAMPLE)
    @Schema(required = true, description = "text_description", example = "text_example")
    private String requiredAndDescriptionAndExample;

    public static final String JSON_PROPERTY_REQUIRED_AND_EXAMPLE = "requiredAndExample";
    @JsonbProperty(JSON_PROPERTY_REQUIRED_AND_EXAMPLE)
    @Schema(required = true, example = "text_example")
    private String requiredAndExample;

    public static final String JSON_PROPERTY_WITH_DESCRIPTION = "withDescription";
    @JsonbProperty(JSON_PROPERTY_WITH_DESCRIPTION)
    @Schema(description = "openapi property description")
    private String withDescription;

    public static final String JSON_PROPERTY_WITH_EXAMPLE = "withExample";
    @JsonbProperty(JSON_PROPERTY_WITH_EXAMPLE)
    @Schema(example = "openapi property example")
    private String withExample;

    public MicroprofileAnnotations descriptionAndExample(String descriptionAndExample) {
        this.descriptionAndExample = descriptionAndExample;
        return this;
    }

    /**
     * text_description.
     * 
     * @return descriptionAndExample
     **/
    public String getDescriptionAndExample() {
        return descriptionAndExample;
    }

    public void setDescriptionAndExample(String descriptionAndExample) {
        this.descriptionAndExample = descriptionAndExample;
    }

    public MicroprofileAnnotations isReadonly(String isReadonly) {
        this.isReadonly = isReadonly;
        return this;
    }

    /**
     * Get isReadonly
     *
     * @return isReadonly
     **/
    public String getIsReadonly() {
        return isReadonly;
    }

    public void setIsReadonly(String isReadonly) {
        this.isReadonly = isReadonly;
    }

    public MicroprofileAnnotations isRequired(String isRequired) {
        this.isRequired = Objects.requireNonNull(isRequired, "Property isRequired is required, cannot be null");
        return this;
    }

    /**
     * Get isRequired
     *
     * @return isRequired
     **/
    @NotNull public String getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(String isRequired) {
        this.isRequired = Objects.requireNonNull(isRequired, "Property isRequired is required, cannot be null");
    }

    public MicroprofileAnnotations readonlyRequiredAndDescriptionAndExample(String readonlyRequiredAndDescriptionAndExample) {
        this.readonlyRequiredAndDescriptionAndExample = Objects.requireNonNull(readonlyRequiredAndDescriptionAndExample,
                "Property readonlyRequiredAndDescriptionAndExample is required, cannot be null");
        return this;
    }

    /**
     * text_description.
     * 
     * @return readonlyRequiredAndDescriptionAndExample
     **/
    @NotNull public String getReadonlyRequiredAndDescriptionAndExample() {
        return readonlyRequiredAndDescriptionAndExample;
    }

    public void setReadonlyRequiredAndDescriptionAndExample(String readonlyRequiredAndDescriptionAndExample) {
        this.readonlyRequiredAndDescriptionAndExample = Objects.requireNonNull(readonlyRequiredAndDescriptionAndExample,
                "Property readonlyRequiredAndDescriptionAndExample is required, cannot be null");
    }

    public MicroprofileAnnotations requiredAndDescription(String requiredAndDescription) {
        this.requiredAndDescription = Objects.requireNonNull(requiredAndDescription,
                "Property requiredAndDescription is required, cannot be null");
        return this;
    }

    /**
     * text_description.
     * 
     * @return requiredAndDescription
     **/
    @NotNull public String getRequiredAndDescription() {
        return requiredAndDescription;
    }

    public void setRequiredAndDescription(String requiredAndDescription) {
        this.requiredAndDescription = Objects.requireNonNull(requiredAndDescription,
                "Property requiredAndDescription is required, cannot be null");
    }

    public MicroprofileAnnotations requiredAndDescriptionAndExample(String requiredAndDescriptionAndExample) {
        this.requiredAndDescriptionAndExample = Objects.requireNonNull(requiredAndDescriptionAndExample,
                "Property requiredAndDescriptionAndExample is required, cannot be null");
        return this;
    }

    /**
     * text_description.
     * 
     * @return requiredAndDescriptionAndExample
     **/
    @NotNull public String getRequiredAndDescriptionAndExample() {
        return requiredAndDescriptionAndExample;
    }

    public void setRequiredAndDescriptionAndExample(String requiredAndDescriptionAndExample) {
        this.requiredAndDescriptionAndExample = Objects.requireNonNull(requiredAndDescriptionAndExample,
                "Property requiredAndDescriptionAndExample is required, cannot be null");
    }

    public MicroprofileAnnotations requiredAndExample(String requiredAndExample) {
        this.requiredAndExample = Objects.requireNonNull(requiredAndExample, "Property requiredAndExample is required, cannot be null");
        return this;
    }

    /**
     * Get requiredAndExample
     *
     * @return requiredAndExample
     **/
    @NotNull public String getRequiredAndExample() {
        return requiredAndExample;
    }

    public void setRequiredAndExample(String requiredAndExample) {
        this.requiredAndExample = Objects.requireNonNull(requiredAndExample, "Property requiredAndExample is required, cannot be null");
    }

    public MicroprofileAnnotations withDescription(String withDescription) {
        this.withDescription = withDescription;
        return this;
    }

    /**
     * openapi property description.
     * 
     * @return withDescription
     **/
    public String getWithDescription() {
        return withDescription;
    }

    public void setWithDescription(String withDescription) {
        this.withDescription = withDescription;
    }

    public MicroprofileAnnotations withExample(String withExample) {
        this.withExample = withExample;
        return this;
    }

    /**
     * Get withExample
     *
     * @return withExample
     **/
    public String getWithExample() {
        return withExample;
    }

    public void setWithExample(String withExample) {
        this.withExample = withExample;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MicroprofileAnnotations)) {
            return false;
        }
        MicroprofileAnnotations other = (MicroprofileAnnotations) o;
        return Objects.equals(this.descriptionAndExample, other.descriptionAndExample) &&
                Objects.equals(this.isReadonly, other.isReadonly) &&
                Objects.equals(this.isRequired, other.isRequired) &&
                Objects.equals(this.readonlyRequiredAndDescriptionAndExample, other.readonlyRequiredAndDescriptionAndExample) &&
                Objects.equals(this.requiredAndDescription, other.requiredAndDescription) &&
                Objects.equals(this.requiredAndDescriptionAndExample, other.requiredAndDescriptionAndExample) &&
                Objects.equals(this.requiredAndExample, other.requiredAndExample) &&
                Objects.equals(this.withDescription, other.withDescription) &&
                Objects.equals(this.withExample, other.withExample);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descriptionAndExample, isReadonly, isRequired, readonlyRequiredAndDescriptionAndExample, requiredAndDescription,
                requiredAndDescriptionAndExample, requiredAndExample, withDescription, withExample);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MicroprofileAnnotations {");
        sb.append("\n    descriptionAndExample: ").append(toIndentedString(descriptionAndExample));
        sb.append("\n    isReadonly: ").append(toIndentedString(isReadonly));
        sb.append("\n    isRequired: ").append(toIndentedString(isRequired));
        sb.append("\n    readonlyRequiredAndDescriptionAndExample: ").append(toIndentedString(readonlyRequiredAndDescriptionAndExample));
        sb.append("\n    requiredAndDescription: ").append(toIndentedString(requiredAndDescription));
        sb.append("\n    requiredAndDescriptionAndExample: ").append(toIndentedString(requiredAndDescriptionAndExample));
        sb.append("\n    requiredAndExample: ").append(toIndentedString(requiredAndExample));
        sb.append("\n    withDescription: ").append(toIndentedString(withDescription));
        sb.append("\n    withExample: ").append(toIndentedString(withExample));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
