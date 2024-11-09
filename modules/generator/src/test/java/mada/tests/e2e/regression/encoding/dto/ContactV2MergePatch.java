/*
 * Test
 *
 * The version of the OpenAPI document: 1.0.0
 */

package mada.tests.e2e.regression.encoding.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * ContactV2MergePatch
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class ContactV2MergePatch {
  public static final String JSON_PROPERTY_EMAIL = "email";
  @JsonbProperty(JSON_PROPERTY_EMAIL)
  @Schema(description = "Email address of the contact. Must comply with regex '^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$'")
  private String email;

  public ContactV2MergePatch email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Email address of the contact. Must comply with regex
   * '^(?=.{1,64}@)[A-Za-z0-9_-]+(\.[A-Za-z0-9_-]+)*@[A-Za-z0-9-]+(\.[A-Za-z0-9-]+)*(\.[A-Za-z]{2,})$'
   *
   * @return email
   **/
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ContactV2MergePatch)) {
      return false;
    }
    ContactV2MergePatch other = (ContactV2MergePatch) o;
    return Objects.equals(this.email, other.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContactV2MergePatch {");
    sb.append("\n    email: ").append(toIndentedString(email));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
