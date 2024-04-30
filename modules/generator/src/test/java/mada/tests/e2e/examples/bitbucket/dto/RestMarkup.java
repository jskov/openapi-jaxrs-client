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
 * RestMarkup
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestMarkup {
  public static final String JSON_PROPERTY_HTML = "html";
  @JsonbProperty(JSON_PROPERTY_HTML)
  @Schema(example = "<h1>Hello World!</h1>")
  private String html;

  public RestMarkup html(String html) {
    this.html = html;
    return this;
  }

  /**
   * Get html
   * @return html
   **/
  public String getHtml() {
    return html;
  }

  public void setHtml(String html) {
    this.html = html;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestMarkup)) {
      return false;
    }
    RestMarkup other = (RestMarkup) o;
    return Objects.equals(this.html, other.html);
  }

  @Override
  public int hashCode() {
    return Objects.hash(html);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestMarkup {");
    sb.append("\n    html: ").append(toIndentedString(html));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
