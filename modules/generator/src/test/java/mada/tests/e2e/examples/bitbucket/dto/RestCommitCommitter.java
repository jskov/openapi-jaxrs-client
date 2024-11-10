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
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestCommitCommitter
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestCommitCommitter {
    public static final String JSON_PROPERTY_AVATAR_URL = "avatarUrl";
    @JsonbProperty(JSON_PROPERTY_AVATAR_URL)
    private String avatarUrl;

    public static final String JSON_PROPERTY_EMAIL_ADDRESS = "emailAddress";
    @JsonbProperty(JSON_PROPERTY_EMAIL_ADDRESS)
    @Schema(example = "charlie@example.com")
    private String emailAddress;

    public static final String JSON_PROPERTY_NAME = "name";
    @JsonbProperty(JSON_PROPERTY_NAME)
    @Schema(example = "Charlie")
    private String name;

    public RestCommitCommitter avatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }

    /**
     * Get avatarUrl
     *
     * @return avatarUrl
     **/
    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public RestCommitCommitter emailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    /**
     * Get emailAddress
     *
     * @return emailAddress
     **/
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public RestCommitCommitter name(String name) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestCommitCommitter)) {
            return false;
        }
        RestCommitCommitter other = (RestCommitCommitter) o;
        return Objects.equals(this.avatarUrl, other.avatarUrl) &&
                Objects.equals(this.emailAddress, other.emailAddress) &&
                Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(avatarUrl, emailAddress, name);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestCommitCommitter {");
        sb.append("\n    avatarUrl: ").append(toIndentedString(avatarUrl));
        sb.append("\n    emailAddress: ").append(toIndentedString(emailAddress));
        sb.append("\n    name: ").append(toIndentedString(name));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
