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
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestSetInsightReportRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestSetInsightReportRequest {
  public static final String JSON_PROPERTY_COVERAGE_PROVIDER_KEY = "coverageProviderKey";
  @JsonbProperty(JSON_PROPERTY_COVERAGE_PROVIDER_KEY)
  private String coverageProviderKey;

  public static final String JSON_PROPERTY_CREATED_DATE = "createdDate";
  @JsonbProperty(JSON_PROPERTY_CREATED_DATE)
  @Schema(example = "1630041546433")
  private Long createdDate;

  public static final String JSON_PROPERTY_DATA = "data";
  @JsonbProperty(JSON_PROPERTY_DATA)
  @Schema(required = true)
  private List<RestInsightReportData> data = new ArrayList<>();

  public static final String JSON_PROPERTY_DETAILS = "details";
  @JsonbProperty(JSON_PROPERTY_DETAILS)
  @Schema(example = "This is the details of the report, it can be a longer string describing the report.")
  private String details;

  public static final String JSON_PROPERTY_LINK = "link";
  @JsonbProperty(JSON_PROPERTY_LINK)
  @Schema(example = "http://insight.example.com")
  private String link;

  public static final String JSON_PROPERTY_LOGO_URL = "logoUrl";
  @JsonbProperty(JSON_PROPERTY_LOGO_URL)
  @Schema(example = "http://insight.example.com/logo")
  private String logoUrl;

  public static final String JSON_PROPERTY_REPORTER = "reporter";
  @JsonbProperty(JSON_PROPERTY_REPORTER)
  @Schema(example = "Reporter/tool that produced this report")
  private String reporter;

  public static final String JSON_PROPERTY_RESULT = "result";
  @JsonbProperty(JSON_PROPERTY_RESULT)
  @Schema(example = "PASS")
  private String result;

  public static final String JSON_PROPERTY_TITLE = "title";
  @JsonbProperty(JSON_PROPERTY_TITLE)
  @Schema(required = true, example = "report.title")
  private String title;

  public RestSetInsightReportRequest coverageProviderKey(String coverageProviderKey) {
    this.coverageProviderKey = coverageProviderKey;
    return this;
  }

  /**
   * Get coverageProviderKey
   * @return coverageProviderKey
   **/
  public String getCoverageProviderKey() {
    return coverageProviderKey;
  }

  public void setCoverageProviderKey(String coverageProviderKey) {
    this.coverageProviderKey = coverageProviderKey;
  }

  public RestSetInsightReportRequest createdDate(Long createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  /**
   * Get createdDate
   * @return createdDate
   **/
  public Long getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Long createdDate) {
    this.createdDate = createdDate;
  }

  public RestSetInsightReportRequest data(List<RestInsightReportData> data) {
    this.data = Objects.requireNonNull(data, "Property data is required, cannot be null");
    return this;
  }

  public RestSetInsightReportRequest addDataItem(RestInsightReportData dataItem) {
    this.data.add(dataItem);
    return this;
  }

  /**
   * Get data
   * @return data
   **/
  @NotNull @Valid @Size(min = 0, max = 6)
  public List<RestInsightReportData> getData() {
    return data;
  }

  public void setData(List<RestInsightReportData> data) {
    this.data = Objects.requireNonNull(data, "Property data is required, cannot be null");
  }

  public RestSetInsightReportRequest details(String details) {
    this.details = details;
    return this;
  }

  /**
   * Get details
   * @return details
   **/
  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  public RestSetInsightReportRequest link(String link) {
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

  public RestSetInsightReportRequest logoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
    return this;
  }

  /**
   * Get logoUrl
   * @return logoUrl
   **/
  public String getLogoUrl() {
    return logoUrl;
  }

  public void setLogoUrl(String logoUrl) {
    this.logoUrl = logoUrl;
  }

  public RestSetInsightReportRequest reporter(String reporter) {
    this.reporter = reporter;
    return this;
  }

  /**
   * Get reporter
   * @return reporter
   **/
  @Size(min = 0, max = 450)
  public String getReporter() {
    return reporter;
  }

  public void setReporter(String reporter) {
    this.reporter = reporter;
  }

  public RestSetInsightReportRequest result(String result) {
    this.result = result;
    return this;
  }

  /**
   * Get result
   * @return result
   **/
  @Pattern(regexp = "FAIL|PASS")
  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public RestSetInsightReportRequest title(String title) {
    this.title = Objects.requireNonNull(title, "Property title is required, cannot be null");
    return this;
  }

  /**
   * Get title
   * @return title
   **/
  @NotNull @Size(min = 0, max = 450)
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = Objects.requireNonNull(title, "Property title is required, cannot be null");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestSetInsightReportRequest)) {
      return false;
    }
    RestSetInsightReportRequest other = (RestSetInsightReportRequest) o;
    return Objects.equals(this.coverageProviderKey, other.coverageProviderKey) &&
        Objects.equals(this.createdDate, other.createdDate) &&
        Objects.equals(this.data, other.data) &&
        Objects.equals(this.details, other.details) &&
        Objects.equals(this.link, other.link) &&
        Objects.equals(this.logoUrl, other.logoUrl) &&
        Objects.equals(this.reporter, other.reporter) &&
        Objects.equals(this.result, other.result) &&
        Objects.equals(this.title, other.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(coverageProviderKey, createdDate, data, details, link, logoUrl, reporter, result, title);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestSetInsightReportRequest {");
    sb.append("\n    coverageProviderKey: ").append(toIndentedString(coverageProviderKey));
    sb.append("\n    createdDate: ").append(toIndentedString(createdDate));
    sb.append("\n    data: ").append(toIndentedString(data));
    sb.append("\n    details: ").append(toIndentedString(details));
    sb.append("\n    link: ").append(toIndentedString(link));
    sb.append("\n    logoUrl: ").append(toIndentedString(logoUrl));
    sb.append("\n    reporter: ").append(toIndentedString(reporter));
    sb.append("\n    result: ").append(toIndentedString(result));
    sb.append("\n    title: ").append(toIndentedString(title));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
