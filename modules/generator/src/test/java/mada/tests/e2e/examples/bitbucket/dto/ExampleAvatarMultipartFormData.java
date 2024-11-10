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
 * ExampleAvatarMultipartFormData
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ExampleAvatarMultipartFormData {
    public static final String JSON_PROPERTY_AVATAR = "avatar";
    @JsonbProperty(JSON_PROPERTY_AVATAR)
    @Schema(description = "The avatar file to upload.")
    private byte[] avatar;

    public ExampleAvatarMultipartFormData avatar(byte[] avatar) {
        this.avatar = avatar;
        return this;
    }

    /**
     * The avatar file to upload.
     * 
     * @return avatar
     **/
    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ExampleAvatarMultipartFormData)) {
            return false;
        }
        ExampleAvatarMultipartFormData other = (ExampleAvatarMultipartFormData) o;
        return Arrays.equals(this.avatar, other.avatar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(avatar));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ExampleAvatarMultipartFormData {");
        sb.append("\n    avatar: ").append(toIndentedString(avatar));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
