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
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestCommentThreadDiffAnchorPullRequestFromRef
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestCommentThreadDiffAnchorPullRequestFromRef {
  public static final String JSON_PROPERTY_DISPLAY_ID = "displayId";
  @JsonbProperty(JSON_PROPERTY_DISPLAY_ID)
  @Schema(example = "feature-ABC-1233")
  private String displayId;

  public static final String JSON_PROPERTY_ID = "id";
  @JsonbProperty(JSON_PROPERTY_ID)
  @Schema(example = "refs/heads/feature-ABC-123")
  private String id;

  public static final String JSON_PROPERTY_LATEST_COMMIT = "latestCommit";
  @JsonbProperty(JSON_PROPERTY_LATEST_COMMIT)
  @Schema(example = "babecafebabecafebabecafebabecafebabecafe")
  private String latestCommit;

  public static final String JSON_PROPERTY_REPOSITORY = "repository";
  @JsonbProperty(JSON_PROPERTY_REPOSITORY)
  private RestCommentThreadDiffAnchorPullRequestFromRefRepository repository;

  public enum TypeEnum {
    BRANCH("BRANCH"),
    TAG("TAG");

    private final String value;

    TypeEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static class TypeEnumAdapter implements JsonbAdapter<TypeEnum, JsonString> {
      @Override
      public JsonString adaptToJson(TypeEnum e) throws Exception {
        return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public TypeEnum adaptFromJson(JsonString value) throws Exception {
        for (TypeEnum b : TypeEnum.values()) {
          if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
            return b;
          }
        }
        throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type TypeEnum");
      }
    }
  }

  public static final String JSON_PROPERTY_TYPE = "type";
  @JsonbProperty(JSON_PROPERTY_TYPE)
  @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestCommentThreadDiffAnchorPullRequestFromRef.TypeEnum.TypeEnumAdapter.class)
  private TypeEnum type;

  public RestCommentThreadDiffAnchorPullRequestFromRef displayId(String displayId) {
    this.displayId = displayId;
    return this;
  }

  /**
   * Get displayId
   * @return displayId
   **/
  public String getDisplayId() {
    return displayId;
  }

  public void setDisplayId(String displayId) {
    this.displayId = displayId;
  }

  public RestCommentThreadDiffAnchorPullRequestFromRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public RestCommentThreadDiffAnchorPullRequestFromRef latestCommit(String latestCommit) {
    this.latestCommit = latestCommit;
    return this;
  }

  /**
   * Get latestCommit
   * @return latestCommit
   **/
  public String getLatestCommit() {
    return latestCommit;
  }

  public void setLatestCommit(String latestCommit) {
    this.latestCommit = latestCommit;
  }

  public RestCommentThreadDiffAnchorPullRequestFromRef repository(RestCommentThreadDiffAnchorPullRequestFromRefRepository repository) {
    this.repository = repository;
    return this;
  }

  /**
   * Get repository
   * @return repository
   **/
  @Valid
  public RestCommentThreadDiffAnchorPullRequestFromRefRepository getRepository() {
    return repository;
  }

  public void setRepository(RestCommentThreadDiffAnchorPullRequestFromRefRepository repository) {
    this.repository = repository;
  }

  public RestCommentThreadDiffAnchorPullRequestFromRef type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   **/
  public TypeEnum getType() {
    return type;
  }

  public void setType(TypeEnum type) {
    this.type = type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof RestCommentThreadDiffAnchorPullRequestFromRef)) {
      return false;
    }
    RestCommentThreadDiffAnchorPullRequestFromRef other = (RestCommentThreadDiffAnchorPullRequestFromRef) o;
    return Objects.equals(this.displayId, other.displayId) &&
        Objects.equals(this.id, other.id) &&
        Objects.equals(this.latestCommit, other.latestCommit) &&
        Objects.equals(this.repository, other.repository) &&
        Objects.equals(this.type, other.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(displayId, id, latestCommit, repository, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestCommentThreadDiffAnchorPullRequestFromRef {");
    sb.append("\n    displayId: ").append(toIndentedString(displayId));
    sb.append("\n    id: ").append(toIndentedString(id));
    sb.append("\n    latestCommit: ").append(toIndentedString(latestCommit));
    sb.append("\n    repository: ").append(toIndentedString(repository));
    sb.append("\n    type: ").append(toIndentedString(type));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
