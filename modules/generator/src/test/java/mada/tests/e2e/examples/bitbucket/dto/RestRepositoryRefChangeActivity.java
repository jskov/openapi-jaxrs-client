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
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestRepositoryRefChangeActivity
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestRepositoryRefChangeActivity {
  public static final String JSON_PROPERTY_CREATED_DATE = "createdDate";
  @JsonbProperty(JSON_PROPERTY_CREATED_DATE)
  @Schema(example = "19990759200")
  private Long createdDate;

  public static final String JSON_PROPERTY_ID = "id";
  @JsonbProperty(JSON_PROPERTY_ID)
  @Schema(example = "1")
  private Long id;

  public static final String JSON_PROPERTY_REF_CHANGE = "refChange";
  @JsonbProperty(JSON_PROPERTY_REF_CHANGE)
  private RestRepositoryRefChangeActivityRefChange refChange;

  public static final String JSON_PROPERTY_REPOSITORY = "repository";
  @JsonbProperty(JSON_PROPERTY_REPOSITORY)
  private RestRepositoryRefChangeActivityRepository repository;

  public static final String JSON_PROPERTY_TRIGGER = "trigger";
  @JsonbProperty(JSON_PROPERTY_TRIGGER)
  @Schema(example = "push")
  private String trigger;

  public static final String JSON_PROPERTY_USER = "user";
  @JsonbProperty(JSON_PROPERTY_USER)
  private RestRepositoryRefChangeActivityUser user;

  public RestRepositoryRefChangeActivity createdDate(Long createdDate) {
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

  public RestRepositoryRefChangeActivity id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public RestRepositoryRefChangeActivity refChange(RestRepositoryRefChangeActivityRefChange refChange) {
    this.refChange = refChange;
    return this;
  }

  /**
   * Get refChange
   * @return refChange
   **/
  @Valid
  public RestRepositoryRefChangeActivityRefChange getRefChange() {
    return refChange;
  }

  public void setRefChange(RestRepositoryRefChangeActivityRefChange refChange) {
    this.refChange = refChange;
  }

  public RestRepositoryRefChangeActivity repository(RestRepositoryRefChangeActivityRepository repository) {
    this.repository = repository;
    return this;
  }

  /**
   * Get repository
   * @return repository
   **/
  @Valid
  public RestRepositoryRefChangeActivityRepository getRepository() {
    return repository;
  }

  public void setRepository(RestRepositoryRefChangeActivityRepository repository) {
    this.repository = repository;
  }

  public RestRepositoryRefChangeActivity trigger(String trigger) {
    this.trigger = trigger;
    return this;
  }

  /**
   * Get trigger
   * @return trigger
   **/
  public String getTrigger() {
    return trigger;
  }

  public void setTrigger(String trigger) {
    this.trigger = trigger;
  }

  public RestRepositoryRefChangeActivity user(RestRepositoryRefChangeActivityUser user) {
    this.user = user;
    return this;
  }

  /**
   * Get user
   * @return user
   **/
  @Valid
  public RestRepositoryRefChangeActivityUser getUser() {
    return user;
  }

  public void setUser(RestRepositoryRefChangeActivityUser user) {
    this.user = user;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestRepositoryRefChangeActivity)) {
      return false;
    }
    RestRepositoryRefChangeActivity other = (RestRepositoryRefChangeActivity) o;
    return Objects.equals(this.createdDate, other.createdDate) &&
        Objects.equals(this.id, other.id) &&
        Objects.equals(this.refChange, other.refChange) &&
        Objects.equals(this.repository, other.repository) &&
        Objects.equals(this.trigger, other.trigger) &&
        Objects.equals(this.user, other.user);
  }

  @Override
  public int hashCode() {
    return Objects.hash(createdDate, id, refChange, repository, trigger, user);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestRepositoryRefChangeActivity {");
    sb.append("\n    createdDate: ").append(toIndentedString(createdDate));
    sb.append("\n    id: ").append(toIndentedString(id));
    sb.append("\n    refChange: ").append(toIndentedString(refChange));
    sb.append("\n    repository: ").append(toIndentedString(repository));
    sb.append("\n    trigger: ").append(toIndentedString(trigger));
    sb.append("\n    user: ").append(toIndentedString(user));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
