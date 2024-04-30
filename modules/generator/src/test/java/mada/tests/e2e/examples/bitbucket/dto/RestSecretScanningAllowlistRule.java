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
 * RestSecretScanningAllowlistRule
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestSecretScanningAllowlistRule {
  public static final String JSON_PROPERTY_ID = "id";
  @JsonbProperty(JSON_PROPERTY_ID)
  @Schema(description = "The ID of the rule", example = "7")
  private Long id;

  public static final String JSON_PROPERTY_LINE_REGEX = "lineRegex";
  @JsonbProperty(JSON_PROPERTY_LINE_REGEX)
  @Schema(description = "If present, regular expression for matching a secret on a code line", example = "(BBDC-[a-zA-Z0-9+]{44})")
  private String lineRegex;

  public static final String JSON_PROPERTY_NAME = "name";
  @JsonbProperty(JSON_PROPERTY_NAME)
  @Schema(description = "Human readable name for the rule", example = "Bitbucket DC HTTP access token")
  private String name;

  public static final String JSON_PROPERTY_PATH_REGEX = "pathRegex";
  @JsonbProperty(JSON_PROPERTY_PATH_REGEX)
  @Schema(description = "If present, regular expression matching file names", example = "*.pem")
  private String pathRegex;

  public RestSecretScanningAllowlistRule id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * The ID of the rule.
   *
   * @return id
   **/
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public RestSecretScanningAllowlistRule lineRegex(String lineRegex) {
    this.lineRegex = lineRegex;
    return this;
  }

  /**
   * If present, regular expression for matching a secret on a code line.
   *
   * @return lineRegex
   **/
  public String getLineRegex() {
    return lineRegex;
  }

  public void setLineRegex(String lineRegex) {
    this.lineRegex = lineRegex;
  }

  public RestSecretScanningAllowlistRule name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Human readable name for the rule.
   *
   * @return name
   **/
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public RestSecretScanningAllowlistRule pathRegex(String pathRegex) {
    this.pathRegex = pathRegex;
    return this;
  }

  /**
   * If present, regular expression matching file names.
   *
   * @return pathRegex
   **/
  public String getPathRegex() {
    return pathRegex;
  }

  public void setPathRegex(String pathRegex) {
    this.pathRegex = pathRegex;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestSecretScanningAllowlistRule)) {
      return false;
    }
    RestSecretScanningAllowlistRule other = (RestSecretScanningAllowlistRule) o;
    return Objects.equals(this.id, other.id) &&
        Objects.equals(this.lineRegex, other.lineRegex) &&
        Objects.equals(this.name, other.name) &&
        Objects.equals(this.pathRegex, other.pathRegex);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, lineRegex, name, pathRegex);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestSecretScanningAllowlistRule {");
    sb.append("\n    id: ").append(toIndentedString(id));
    sb.append("\n    lineRegex: ").append(toIndentedString(lineRegex));
    sb.append("\n    name: ").append(toIndentedString(name));
    sb.append("\n    pathRegex: ").append(toIndentedString(pathRegex));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
