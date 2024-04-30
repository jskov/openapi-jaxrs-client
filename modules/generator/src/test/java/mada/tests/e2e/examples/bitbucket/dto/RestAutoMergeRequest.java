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
 * RestAutoMergeRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestAutoMergeRequest {
  public static final String JSON_PROPERTY_AUTO_SUBJECT = "autoSubject";
  @JsonbProperty(JSON_PROPERTY_AUTO_SUBJECT)
  @Schema(example = "true")
  private Boolean autoSubject;

  public static final String JSON_PROPERTY_CREATED_DATE = "createdDate";
  @JsonbProperty(JSON_PROPERTY_CREATED_DATE)
  @Schema(example = "13590759200")
  private Long createdDate;

  public static final String JSON_PROPERTY_FROM_HASH = "fromHash";
  @JsonbProperty(JSON_PROPERTY_FROM_HASH)
  @Schema(example = "babecafebabecafebabecafebabecafebabecafe")
  private String fromHash;

  public static final String JSON_PROPERTY_MESSAGE = "message";
  @JsonbProperty(JSON_PROPERTY_MESSAGE)
  @Schema(example = "(Optional) A descriptive message for the merge commit")
  private String message;

  public static final String JSON_PROPERTY_STRATEGY_ID = "strategyId";
  @JsonbProperty(JSON_PROPERTY_STRATEGY_ID)
  @Schema(example = "(Optional) squash")
  private String strategyId;

  public static final String JSON_PROPERTY_TO_REF_ID = "toRefId";
  @JsonbProperty(JSON_PROPERTY_TO_REF_ID)
  @Schema(example = "refs/heads/feature-ABC-123")
  private String toRefId;

  public RestAutoMergeRequest autoSubject(Boolean autoSubject) {
    this.autoSubject = autoSubject;
    return this;
  }

  /**
   * Get autoSubject
   * @return autoSubject
   **/
  public Boolean isAutoSubject() {
    return autoSubject;
  }

  public void setAutoSubject(Boolean autoSubject) {
    this.autoSubject = autoSubject;
  }

  public RestAutoMergeRequest createdDate(Long createdDate) {
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

  public RestAutoMergeRequest fromHash(String fromHash) {
    this.fromHash = fromHash;
    return this;
  }

  /**
   * Get fromHash
   * @return fromHash
   **/
  public String getFromHash() {
    return fromHash;
  }

  public void setFromHash(String fromHash) {
    this.fromHash = fromHash;
  }

  public RestAutoMergeRequest message(String message) {
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

  public RestAutoMergeRequest strategyId(String strategyId) {
    this.strategyId = strategyId;
    return this;
  }

  /**
   * Get strategyId
   * @return strategyId
   **/
  public String getStrategyId() {
    return strategyId;
  }

  public void setStrategyId(String strategyId) {
    this.strategyId = strategyId;
  }

  public RestAutoMergeRequest toRefId(String toRefId) {
    this.toRefId = toRefId;
    return this;
  }

  /**
   * Get toRefId
   * @return toRefId
   **/
  public String getToRefId() {
    return toRefId;
  }

  public void setToRefId(String toRefId) {
    this.toRefId = toRefId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestAutoMergeRequest)) {
      return false;
    }
    RestAutoMergeRequest other = (RestAutoMergeRequest) o;
    return Objects.equals(this.autoSubject, other.autoSubject) &&
        Objects.equals(this.createdDate, other.createdDate) &&
        Objects.equals(this.fromHash, other.fromHash) &&
        Objects.equals(this.message, other.message) &&
        Objects.equals(this.strategyId, other.strategyId) &&
        Objects.equals(this.toRefId, other.toRefId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(autoSubject, createdDate, fromHash, message, strategyId, toRefId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestAutoMergeRequest {");
    sb.append("\n    autoSubject: ").append(toIndentedString(autoSubject));
    sb.append("\n    createdDate: ").append(toIndentedString(createdDate));
    sb.append("\n    fromHash: ").append(toIndentedString(fromHash));
    sb.append("\n    message: ").append(toIndentedString(message));
    sb.append("\n    strategyId: ").append(toIndentedString(strategyId));
    sb.append("\n    toRefId: ").append(toIndentedString(toRefId));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
