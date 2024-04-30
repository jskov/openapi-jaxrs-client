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
 * EntityHolderRestPullRequestMergeRequestEntity
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class EntityHolderRestPullRequestMergeRequestEntity {
  public static final String JSON_PROPERTY_AUTO_MERGE = "autoMerge";
  @JsonbProperty(JSON_PROPERTY_AUTO_MERGE)
  @Schema(example = "false")
  private Boolean autoMerge;

  public static final String JSON_PROPERTY_AUTO_SUBJECT = "autoSubject";
  @JsonbProperty(JSON_PROPERTY_AUTO_SUBJECT)
  @Schema(example = "(Optional, 5.7+) true to prepend an auto-generated subject to the message (default), or false to use the message as-is")
  private String autoSubject;

  public static final String JSON_PROPERTY_MESSAGE = "message";
  @JsonbProperty(JSON_PROPERTY_MESSAGE)
  @Schema(example = "(Optional) A descriptive message for the merge commit")
  private String message;

  public static final String JSON_PROPERTY_STRATEGY_ID = "strategyId";
  @JsonbProperty(JSON_PROPERTY_STRATEGY_ID)
  @Schema(example = "(Optional) squash")
  private String strategyId;

  public static final String JSON_PROPERTY_VERSION = "version";
  @JsonbProperty(JSON_PROPERTY_VERSION)
  private Integer version;

  public EntityHolderRestPullRequestMergeRequestEntity autoMerge(Boolean autoMerge) {
    this.autoMerge = autoMerge;
    return this;
  }

  /**
   * Get autoMerge
   * @return autoMerge
   **/
  public Boolean isAutoMerge() {
    return autoMerge;
  }

  public void setAutoMerge(Boolean autoMerge) {
    this.autoMerge = autoMerge;
  }

  public EntityHolderRestPullRequestMergeRequestEntity autoSubject(String autoSubject) {
    this.autoSubject = autoSubject;
    return this;
  }

  /**
   * Get autoSubject
   * @return autoSubject
   **/
  public String getAutoSubject() {
    return autoSubject;
  }

  public void setAutoSubject(String autoSubject) {
    this.autoSubject = autoSubject;
  }

  public EntityHolderRestPullRequestMergeRequestEntity message(String message) {
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

  public EntityHolderRestPullRequestMergeRequestEntity strategyId(String strategyId) {
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

  public EntityHolderRestPullRequestMergeRequestEntity version(Integer version) {
    this.version = version;
    return this;
  }

  /**
   * Get version
   * @return version
   **/
  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof EntityHolderRestPullRequestMergeRequestEntity)) {
      return false;
    }
    EntityHolderRestPullRequestMergeRequestEntity other = (EntityHolderRestPullRequestMergeRequestEntity) o;
    return Objects.equals(this.autoMerge, other.autoMerge) &&
        Objects.equals(this.autoSubject, other.autoSubject) &&
        Objects.equals(this.message, other.message) &&
        Objects.equals(this.strategyId, other.strategyId) &&
        Objects.equals(this.version, other.version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(autoMerge, autoSubject, message, strategyId, version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EntityHolderRestPullRequestMergeRequestEntity {");
    sb.append("\n    autoMerge: ").append(toIndentedString(autoMerge));
    sb.append("\n    autoSubject: ").append(toIndentedString(autoSubject));
    sb.append("\n    message: ").append(toIndentedString(message));
    sb.append("\n    strategyId: ").append(toIndentedString(strategyId));
    sb.append("\n    version: ").append(toIndentedString(version));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
