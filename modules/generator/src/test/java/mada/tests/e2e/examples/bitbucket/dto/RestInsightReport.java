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

import jakarta.json.Json;
import jakarta.json.JsonString;
import jakarta.json.bind.adapter.JsonbAdapter;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTypeAdapter;
import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestInsightReport
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestInsightReport {
  public static final String JSON_PROPERTY_CREATED_DATE = "createdDate";
  @JsonbProperty(JSON_PROPERTY_CREATED_DATE)
  @Schema(example = "1630041546433")
  private BigDecimal createdDate;

  public static final String JSON_PROPERTY_DATA = "data";
  @JsonbProperty(JSON_PROPERTY_DATA)
  private List<RestInsightReportData> data;

  public static final String JSON_PROPERTY_DETAILS = "details";
  @JsonbProperty(JSON_PROPERTY_DETAILS)
  @Schema(example = "This is the details of the report, it can be a longer string describing the report")
  private String details;

  public static final String JSON_PROPERTY_KEY = "key";
  @JsonbProperty(JSON_PROPERTY_KEY)
  @Schema(example = "report.key")
  private String key;

  public static final String JSON_PROPERTY_LINK = "link";
  @JsonbProperty(JSON_PROPERTY_LINK)
  @Schema(example = "http://integration.example.com")
  private String link;

  public static final String JSON_PROPERTY_LOGO_URL = "logoUrl";
  @JsonbProperty(JSON_PROPERTY_LOGO_URL)
  @Schema(example = "http://integration.example.com/logo")
  private String logoUrl;

  public static final String JSON_PROPERTY_REPORTER = "reporter";
  @JsonbProperty(JSON_PROPERTY_REPORTER)
  @Schema(example = "Reporter/tool that produced this report")
  private String reporter;

  public enum ResultEnum {
    FAIL("FAIL"),
    PASS("PASS");

    private final String value;

    ResultEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static class ResultEnumAdapter implements JsonbAdapter<ResultEnum, JsonString> {
      @Override
      public JsonString adaptToJson(ResultEnum e) throws Exception {
        return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public ResultEnum adaptFromJson(JsonString value) throws Exception {
        for (ResultEnum b : ResultEnum.values()) {
          if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
            return b;
          }
        }
        throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type ResultEnum");
      }
    }
  }

  public static final String JSON_PROPERTY_RESULT = "result";
  @JsonbProperty(JSON_PROPERTY_RESULT)
  @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestInsightReport.ResultEnum.ResultEnumAdapter.class)
  @Schema(example = "PASS")
  private ResultEnum result;

  public static final String JSON_PROPERTY_TITLE = "title";
  @JsonbProperty(JSON_PROPERTY_TITLE)
  @Schema(example = "report.title")
  private String title;

  public RestInsightReport createdDate(BigDecimal createdDate) {
    this.createdDate = createdDate;
    return this;
  }

  /**
   * Get createdDate
   * @return createdDate
   **/
  public BigDecimal getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(BigDecimal createdDate) {
    this.createdDate = createdDate;
  }

  public RestInsightReport data(List<RestInsightReportData> data) {
    this.data = data;
    return this;
  }

  public RestInsightReport addDataItem(RestInsightReportData dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<>();
    }
    this.data.add(dataItem);
    return this;
  }

  /**
   * Get data
   * @return data
   **/
  @Valid
  public List<RestInsightReportData> getData() {
    return data;
  }

  public void setData(List<RestInsightReportData> data) {
    this.data = data;
  }

  public RestInsightReport details(String details) {
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

  public RestInsightReport key(String key) {
    this.key = key;
    return this;
  }

  /**
   * Get key
   * @return key
   **/
  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public RestInsightReport link(String link) {
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

  public RestInsightReport logoUrl(String logoUrl) {
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

  public RestInsightReport reporter(String reporter) {
    this.reporter = reporter;
    return this;
  }

  /**
   * Get reporter
   * @return reporter
   **/
  public String getReporter() {
    return reporter;
  }

  public void setReporter(String reporter) {
    this.reporter = reporter;
  }

  public RestInsightReport result(ResultEnum result) {
    this.result = result;
    return this;
  }

  /**
   * Get result
   * @return result
   **/
  public ResultEnum getResult() {
    return result;
  }

  public void setResult(ResultEnum result) {
    this.result = result;
  }

  public RestInsightReport title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Get title
   * @return title
   **/
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestInsightReport)) {
      return false;
    }
    RestInsightReport other = (RestInsightReport) o;
    return Objects.equals(this.createdDate, other.createdDate) &&
        Objects.equals(this.data, other.data) &&
        Objects.equals(this.details, other.details) &&
        Objects.equals(this.key, other.key) &&
        Objects.equals(this.link, other.link) &&
        Objects.equals(this.logoUrl, other.logoUrl) &&
        Objects.equals(this.reporter, other.reporter) &&
        Objects.equals(this.result, other.result) &&
        Objects.equals(this.title, other.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createdDate, data, details, key, link, logoUrl, reporter, result, title);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestInsightReport {");
    sb.append("\n    createdDate: ").append(toIndentedString(createdDate));
    sb.append("\n    data: ").append(toIndentedString(data));
    sb.append("\n    details: ").append(toIndentedString(details));
    sb.append("\n    key: ").append(toIndentedString(key));
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
