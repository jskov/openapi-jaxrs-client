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
import java.util.Objects;

/**
 * RestUserReactionEmoticon
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestUserReactionEmoticon {
    public static final String JSON_PROPERTY_SHORTCUT = "shortcut";
    @JsonbProperty(JSON_PROPERTY_SHORTCUT)
    private String shortcut;

    public static final String JSON_PROPERTY_URL = "url";
    @JsonbProperty(JSON_PROPERTY_URL)
    private String url;

    public static final String JSON_PROPERTY_VALUE = "value";
    @JsonbProperty(JSON_PROPERTY_VALUE)
    private String value;

    public RestUserReactionEmoticon shortcut(String shortcut) {
        this.shortcut = shortcut;
        return this;
    }

    /**
     * Get shortcut
     *
     * @return shortcut
     **/
    public String getShortcut() {
        return shortcut;
    }

    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }

    public RestUserReactionEmoticon url(String url) {
        this.url = url;
        return this;
    }

    /**
     * Get url
     *
     * @return url
     **/
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public RestUserReactionEmoticon value(String value) {
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
        if (!(o instanceof RestUserReactionEmoticon)) {
            return false;
        }
        RestUserReactionEmoticon other = (RestUserReactionEmoticon) o;
        return Objects.equals(this.shortcut, other.shortcut) &&
                Objects.equals(this.url, other.url) &&
                Objects.equals(this.value, other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shortcut, url, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestUserReactionEmoticon {");
        sb.append("\n    shortcut: ").append(toIndentedString(shortcut));
        sb.append("\n    url: ").append(toIndentedString(url));
        sb.append("\n    value: ").append(toIndentedString(value));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
