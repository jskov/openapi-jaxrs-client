/*
 * Test
 *
 * The version of the OpenAPI document: 1.0.0
 */

package mada.tests.e2e.regression.string_pattern.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * BadPatterns
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class BadPatterns {
  public static final String JSON_PROPERTY_CPE = "cpe";
  @JsonbProperty(JSON_PROPERTY_CPE)
  private String cpe;

  public BadPatterns cpe(String cpe) {
    this.cpe = cpe;
    return this;
  }

  /**
   * Get cpe
   * @return cpe
   **/
  @Pattern(regexp = "(cpe:2\\.3:[aho\\*\\-](:(((\\?*|\\*?)([a-zA-Z0-9\\-\\._]|(\\[\\\\*\\?!\"#$$%&'\\(\\)\\+,/:;<=>@\\[\\]\\^`\\{\\|}~]))+(\\?*|\\*?))|[\\*\\-])){5}(:(([a-zA-Z]{2,3}(-([a-zA-Z]{2}|[0-9]{3}))?)|[\\*\\-]))(:(((\\?*|\\*?)([a-zA-Z0-9\\-\\._]|(\\[\\\\*\\?!\"#$$%&'\\(\\)\\+,/:;<=>@\\[\\]\\^`\\{\\|}~]))+(\\?*|\\*?))|[\\*\\-])){4})|([c][pP][eE]:/[AHOaho]?(:[A-Za-z0-9\\._\\-~%]*){0,6})") @Size(min = 0, max = 255)
  public String getCpe() {
    return cpe;
  }

  public void setCpe(String cpe) {
    this.cpe = cpe;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BadPatterns)) {
      return false;
    }
    BadPatterns other = (BadPatterns) o;
    return Objects.equals(this.cpe, other.cpe);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cpe);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BadPatterns {");
    sb.append("\n    cpe: ").append(toIndentedString(cpe));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
