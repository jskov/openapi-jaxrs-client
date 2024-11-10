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
 * UserPasswordUpdate
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class UserPasswordUpdate {
    public static final String JSON_PROPERTY_OLD_PASSWORD = "oldPassword";
    @JsonbProperty(JSON_PROPERTY_OLD_PASSWORD)
    @Schema(example = "my-old-secret-password")
    private String oldPassword;

    public static final String JSON_PROPERTY_PASSWORD = "password";
    @JsonbProperty(JSON_PROPERTY_PASSWORD)
    @Schema(example = "my-secret-password")
    private String password;

    public static final String JSON_PROPERTY_PASSWORD_CONFIRM = "passwordConfirm";
    @JsonbProperty(JSON_PROPERTY_PASSWORD_CONFIRM)
    @Schema(example = "my-secret-password")
    private String passwordConfirm;

    public UserPasswordUpdate oldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
        return this;
    }

    /**
     * Get oldPassword
     *
     * @return oldPassword
     **/
    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public UserPasswordUpdate password(String password) {
        this.password = password;
        return this;
    }

    /**
     * Get password
     *
     * @return password
     **/
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserPasswordUpdate passwordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
        return this;
    }

    /**
     * Get passwordConfirm
     *
     * @return passwordConfirm
     **/
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserPasswordUpdate)) {
            return false;
        }
        UserPasswordUpdate other = (UserPasswordUpdate) o;
        return Objects.equals(this.oldPassword, other.oldPassword) &&
                Objects.equals(this.password, other.password) &&
                Objects.equals(this.passwordConfirm, other.passwordConfirm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oldPassword, password, passwordConfirm);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UserPasswordUpdate {");
        sb.append("\n    oldPassword: ").append(toIndentedString(oldPassword));
        sb.append("\n    password: ").append(toIndentedString(password));
        sb.append("\n    passwordConfirm: ").append(toIndentedString(passwordConfirm));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
