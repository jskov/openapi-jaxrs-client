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
import java.io.InputStream;
import java.util.Objects;

/**
 * FilePart
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class FilePart {
    public static final String JSON_PROPERTY_CONTENT_TYPE = "contentType";
    @JsonbProperty(JSON_PROPERTY_CONTENT_TYPE)
    private String contentType;

    public static final String JSON_PROPERTY_FORM_FIELD = "formField";
    @JsonbProperty(JSON_PROPERTY_FORM_FIELD)
    private Boolean formField;

    public static final String JSON_PROPERTY_INPUT_STREAM = "inputStream";
    @JsonbProperty(JSON_PROPERTY_INPUT_STREAM)
    private InputStream inputStream;

    public static final String JSON_PROPERTY_NAME = "name";
    @JsonbProperty(JSON_PROPERTY_NAME)
    private String name;

    public static final String JSON_PROPERTY_SIZE = "size";
    @JsonbProperty(JSON_PROPERTY_SIZE)
    private Long size;

    public static final String JSON_PROPERTY_VALUE = "value";
    @JsonbProperty(JSON_PROPERTY_VALUE)
    private String value;

    public FilePart contentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    /**
     * Get contentType
     *
     * @return contentType
     **/
    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public FilePart formField(Boolean formField) {
        this.formField = formField;
        return this;
    }

    /**
     * Get formField
     *
     * @return formField
     **/
    public Boolean isFormField() {
        return formField;
    }

    public void setFormField(Boolean formField) {
        this.formField = formField;
    }

    public FilePart inputStream(InputStream inputStream) {
        this.inputStream = inputStream;
        return this;
    }

    /**
     * Get inputStream
     *
     * @return inputStream
     **/
    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public FilePart name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FilePart size(Long size) {
        this.size = size;
        return this;
    }

    /**
     * Get size
     *
     * @return size
     **/
    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public FilePart value(String value) {
        this.value = value;
        return this;
    }

    /**
     * Get value
     *
     * @return value
     **/
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FilePart)) {
            return false;
        }
        FilePart other = (FilePart) o;
        return Objects.equals(this.contentType, other.contentType) &&
                Objects.equals(this.formField, other.formField) &&
                Objects.equals(this.inputStream, other.inputStream) &&
                Objects.equals(this.name, other.name) &&
                Objects.equals(this.size, other.size) &&
                Objects.equals(this.value, other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contentType, formField, inputStream, name, size, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FilePart {");
        sb.append("\n    contentType: ").append(toIndentedString(contentType));
        sb.append("\n    formField: ").append(toIndentedString(formField));
        sb.append("\n    inputStream: ").append(toIndentedString(inputStream));
        sb.append("\n    name: ").append(toIndentedString(name));
        sb.append("\n    size: ").append(toIndentedString(size));
        sb.append("\n    value: ").append(toIndentedString(value));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
