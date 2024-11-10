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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestAutoMergeProcessingResultPullRequestToRefRepositoryOriginProject
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestAutoMergeProcessingResultPullRequestToRefRepositoryOriginProject {
    public static final String JSON_PROPERTY_AVATAR = "avatar";
    @JsonbProperty(JSON_PROPERTY_AVATAR)
    private String avatar;

    public static final String JSON_PROPERTY_AVATAR_URL = "avatarUrl";
    @JsonbProperty(JSON_PROPERTY_AVATAR_URL)
    private String avatarUrl;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    @JsonbProperty(JSON_PROPERTY_DESCRIPTION)
    @Schema(readOnly = true, example = "The description for my cool project")
    private String description;

    public static final String JSON_PROPERTY_ID = "id";
    @JsonbProperty(JSON_PROPERTY_ID)
    @Schema(readOnly = true)
    private Integer id;

    public static final String JSON_PROPERTY_KEY = "key";
    @JsonbProperty(JSON_PROPERTY_KEY)
    @Schema(required = true, example = "PRJ")
    private String key;

    public static final String JSON_PROPERTY_LINKS = "links";
    @JsonbProperty(JSON_PROPERTY_LINKS)
    private Object links;

    public static final String JSON_PROPERTY_NAME = "name";
    @JsonbProperty(JSON_PROPERTY_NAME)
    @Schema(readOnly = true, example = "My Cool Project")
    private String name;

    public static final String JSON_PROPERTY_NAMESPACE = "namespace";
    @JsonbProperty(JSON_PROPERTY_NAMESPACE)
    @Schema(readOnly = true)
    private String namespace;

    public static final String JSON_PROPERTY_PUBLIC = "public";
    @JsonbProperty(JSON_PROPERTY_PUBLIC)
    @Schema(readOnly = true)
    private Boolean public_;

    public static final String JSON_PROPERTY_SCOPE = "scope";
    @JsonbProperty(JSON_PROPERTY_SCOPE)
    @Schema(readOnly = true, example = "PROJECT")
    private String scope;

    public enum TypeEnum {
      NORMAL("NORMAL"),
      PERSONAL("PERSONAL");

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
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestAutoMergeProcessingResultPullRequestToRefRepositoryOriginProject.TypeEnum.TypeEnumAdapter.class)
    @Schema(readOnly = true)
    private TypeEnum type;

    public RestAutoMergeProcessingResultPullRequestToRefRepositoryOriginProject avatar(String avatar) {
        this.avatar = avatar;
        return this;
    }

    /**
     * Get avatar
     *
     * @return avatar
     **/
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public RestAutoMergeProcessingResultPullRequestToRefRepositoryOriginProject avatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
        return this;
    }

    /**
     * Get avatarUrl
     *
     * @return avatarUrl
     **/
    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public RestAutoMergeProcessingResultPullRequestToRefRepositoryOriginProject description(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get description
     *
     * @return description
     **/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RestAutoMergeProcessingResultPullRequestToRefRepositoryOriginProject id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RestAutoMergeProcessingResultPullRequestToRefRepositoryOriginProject key(String key) {
        this.key = Objects.requireNonNull(key, "Property key is required, cannot be null");
        return this;
    }

    /**
     * Get key
     *
     * @return key
     **/
    @NotNull public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = Objects.requireNonNull(key, "Property key is required, cannot be null");
    }

    public RestAutoMergeProcessingResultPullRequestToRefRepositoryOriginProject links(Object links) {
        this.links = links;
        return this;
    }

    /**
     * Get links
     *
     * @return links
     **/
    public Object getLinks() {
        return links;
    }

    public void setLinks(Object links) {
        this.links = links;
    }

    public RestAutoMergeProcessingResultPullRequestToRefRepositoryOriginProject name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    @Pattern(regexp = "^[^~].*") public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RestAutoMergeProcessingResultPullRequestToRefRepositoryOriginProject namespace(String namespace) {
        this.namespace = namespace;
        return this;
    }

    /**
     * Get namespace
     *
     * @return namespace
     **/
    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public RestAutoMergeProcessingResultPullRequestToRefRepositoryOriginProject public_(Boolean public_) {
        this.public_ = public_;
        return this;
    }

    /**
     * Get public_
     *
     * @return public_
     **/
    public Boolean isPublic() {
        return public_;
    }

    public void setPublic(Boolean public_) {
        this.public_ = public_;
    }

    public RestAutoMergeProcessingResultPullRequestToRefRepositoryOriginProject scope(String scope) {
        this.scope = scope;
        return this;
    }

    /**
     * Get scope
     *
     * @return scope
     **/
    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public RestAutoMergeProcessingResultPullRequestToRefRepositoryOriginProject type(TypeEnum type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     *
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
        if (!(o instanceof RestAutoMergeProcessingResultPullRequestToRefRepositoryOriginProject)) {
            return false;
        }
        RestAutoMergeProcessingResultPullRequestToRefRepositoryOriginProject other = (RestAutoMergeProcessingResultPullRequestToRefRepositoryOriginProject) o;
        return Objects.equals(this.avatar, other.avatar) &&
                Objects.equals(this.avatarUrl, other.avatarUrl) &&
                Objects.equals(this.description, other.description) &&
                Objects.equals(this.id, other.id) &&
                Objects.equals(this.key, other.key) &&
                Objects.equals(this.links, other.links) &&
                Objects.equals(this.name, other.name) &&
                Objects.equals(this.namespace, other.namespace) &&
                Objects.equals(this.public_, other.public_) &&
                Objects.equals(this.scope, other.scope) &&
                Objects.equals(this.type, other.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(avatar, avatarUrl, description, id, key, links, name, namespace, public_, scope, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestAutoMergeProcessingResultPullRequestToRefRepositoryOriginProject {");
        sb.append("\n    avatar: ").append(toIndentedString(avatar));
        sb.append("\n    avatarUrl: ").append(toIndentedString(avatarUrl));
        sb.append("\n    description: ").append(toIndentedString(description));
        sb.append("\n    id: ").append(toIndentedString(id));
        sb.append("\n    key: ").append(toIndentedString(key));
        sb.append("\n    links: ").append(toIndentedString(links));
        sb.append("\n    name: ").append(toIndentedString(name));
        sb.append("\n    namespace: ").append(toIndentedString(namespace));
        sb.append("\n    public_: ").append(toIndentedString(public_));
        sb.append("\n    scope: ").append(toIndentedString(scope));
        sb.append("\n    type: ").append(toIndentedString(type));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
