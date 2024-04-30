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
 * RestInsightAnnotation
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestInsightAnnotation {
  public static final String JSON_PROPERTY_EXTERNAL_ID = "externalId";
  @JsonbProperty(JSON_PROPERTY_EXTERNAL_ID)
  @Schema(example = "external.id")
  private String externalId;

  public static final String JSON_PROPERTY_LINE = "line";
  @JsonbProperty(JSON_PROPERTY_LINE)
  @Schema(example = "5")
  private Integer line;

  public static final String JSON_PROPERTY_LINK = "link";
  @JsonbProperty(JSON_PROPERTY_LINK)
  @Schema(example = "http://example.com/my/file/analysis?line=5")
  private String link;

  public static final String JSON_PROPERTY_MESSAGE = "message";
  @JsonbProperty(JSON_PROPERTY_MESSAGE)
  @Schema(example = "This is an annotation message")
  private String message;

  public static final String JSON_PROPERTY_PATH = "path";
  @JsonbProperty(JSON_PROPERTY_PATH)
  @Schema(example = "src/some/structure/file.ext")
  private String path;

  public static final String JSON_PROPERTY_REPORT_KEY = "reportKey";
  @JsonbProperty(JSON_PROPERTY_REPORT_KEY)
  @Schema(example = "report.key")
  private String reportKey;

  public static final String JSON_PROPERTY_SEVERITY = "severity";
  @JsonbProperty(JSON_PROPERTY_SEVERITY)
  @Schema(example = "HIGH")
  private String severity;

  public static final String JSON_PROPERTY_TYPE = "type";
  @JsonbProperty(JSON_PROPERTY_TYPE)
  @Schema(example = "BUG")
  private String type;

  public RestInsightAnnotation externalId(String externalId) {
    this.externalId = externalId;
    return this;
  }

  /**
   * Get externalId
   * @return externalId
   **/
  public String getExternalId() {
    return externalId;
  }

  public void setExternalId(String externalId) {
    this.externalId = externalId;
  }

  public RestInsightAnnotation line(Integer line) {
    this.line = line;
    return this;
  }

  /**
   * Get line
   * @return line
   **/
  public Integer getLine() {
    return line;
  }

  public void setLine(Integer line) {
    this.line = line;
  }

  public RestInsightAnnotation link(String link) {
    this.link = link;
    return this;
  }

  /**
   * Get link
   * @return link
   **/
  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public RestInsightAnnotation message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
   **/
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public RestInsightAnnotation path(String path) {
    this.path = path;
    return this;
  }

  /**
   * Get path
   * @return path
   **/
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public RestInsightAnnotation reportKey(String reportKey) {
    this.reportKey = reportKey;
    return this;
  }

  /**
   * Get reportKey
   * @return reportKey
   **/
  public String getReportKey() {
    return reportKey;
  }

  public void setReportKey(String reportKey) {
    this.reportKey = reportKey;
  }

  public RestInsightAnnotation severity(String severity) {
    this.severity = severity;
    return this;
  }

  /**
   * Get severity
   * @return severity
   **/
  public String getSeverity() {
    return severity;
  }

  public void setSeverity(String severity) {
    this.severity = severity;
  }

  public RestInsightAnnotation type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   **/
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestInsightAnnotation)) {
      return false;
    }
    RestInsightAnnotation other = (RestInsightAnnotation) o;
    return Objects.equals(this.externalId, other.externalId) &&
        Objects.equals(this.line, other.line) &&
        Objects.equals(this.link, other.link) &&
        Objects.equals(this.message, other.message) &&
        Objects.equals(this.path, other.path) &&
        Objects.equals(this.reportKey, other.reportKey) &&
        Objects.equals(this.severity, other.severity) &&
        Objects.equals(this.type, other.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(externalId, line, link, message, path, reportKey, severity, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestInsightAnnotation {");
    sb.append("\n    externalId: ").append(toIndentedString(externalId));
    sb.append("\n    line: ").append(toIndentedString(line));
    sb.append("\n    link: ").append(toIndentedString(link));
    sb.append("\n    message: ").append(toIndentedString(message));
    sb.append("\n    path: ").append(toIndentedString(path));
    sb.append("\n    reportKey: ").append(toIndentedString(reportKey));
    sb.append("\n    severity: ").append(toIndentedString(severity));
    sb.append("\n    type: ").append(toIndentedString(type));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
