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
 * RestLabelable
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestLabelable {
    public static final String JSON_PROPERTY_ARCHIVED = "archived";
    @JsonbProperty(JSON_PROPERTY_ARCHIVED)
    @Schema(readOnly = true)
    private Boolean archived;

    public static final String JSON_PROPERTY_DEFAULT_BRANCH = "defaultBranch";
    @JsonbProperty(JSON_PROPERTY_DEFAULT_BRANCH)
    @Schema(readOnly = true, example = "main")
    private String defaultBranch;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    @JsonbProperty(JSON_PROPERTY_DESCRIPTION)
    @Schema(readOnly = true, example = "My repo description")
    private String description;

    public static final String JSON_PROPERTY_FORKABLE = "forkable";
    @JsonbProperty(JSON_PROPERTY_FORKABLE)
    @Schema(readOnly = true)
    private Boolean forkable;

    public static final String JSON_PROPERTY_HIERARCHY_ID = "hierarchyId";
    @JsonbProperty(JSON_PROPERTY_HIERARCHY_ID)
    @Schema(readOnly = true, example = "e3c939f9ef4a7fae272e")
    private String hierarchyId;

    public static final String JSON_PROPERTY_ID = "id";
    @JsonbProperty(JSON_PROPERTY_ID)
    @Schema(readOnly = true)
    private Integer id;

    public enum LabelableTypeEnum {
      REPOSITORY("REPOSITORY");

      private final String value;

      LabelableTypeEnum(String value) {
        this.value = value;
      }

      public String getValue() {
          return value;
      }

      @Override
      public String toString() {
          return String.valueOf(value);
      }

      public static class LabelableTypeEnumAdapter implements JsonbAdapter<LabelableTypeEnum, JsonString> {
          @Override
          public JsonString adaptToJson(LabelableTypeEnum e) throws Exception {
              return Json.createValue(String.valueOf(e.value));
          }

        @Override
        public LabelableTypeEnum adaptFromJson(JsonString value) throws Exception {
            for (LabelableTypeEnum b : LabelableTypeEnum.values()) {
                if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                    return b;
                }
            }
            throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type LabelableTypeEnum");
          }
      }
  }

    public static final String JSON_PROPERTY_LABELABLE_TYPE = "labelableType";
    @JsonbProperty(JSON_PROPERTY_LABELABLE_TYPE)
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestLabelable.LabelableTypeEnum.LabelableTypeEnumAdapter.class)
    private LabelableTypeEnum labelableType;

    public static final String JSON_PROPERTY_LINKS = "links";
    @JsonbProperty(JSON_PROPERTY_LINKS)
    private Object links;

    public static final String JSON_PROPERTY_NAME = "name";
    @JsonbProperty(JSON_PROPERTY_NAME)
    @Schema(example = "My repo")
    private String name;

    public static final String JSON_PROPERTY_ORIGIN = "origin";
    @JsonbProperty(JSON_PROPERTY_ORIGIN)
    @Schema(readOnly = true)
    private RestLabelableOrigin origin;

    public static final String JSON_PROPERTY_PARTITION = "partition";
    @JsonbProperty(JSON_PROPERTY_PARTITION)
    @Schema(readOnly = true)
    private Integer partition;

    public static final String JSON_PROPERTY_PROJECT = "project";
    @JsonbProperty(JSON_PROPERTY_PROJECT)
    private RestLabelableProject project;

    public static final String JSON_PROPERTY_PUBLIC = "public";
    @JsonbProperty(JSON_PROPERTY_PUBLIC)
    @Schema(readOnly = true)
    private Boolean public_;

    public static final String JSON_PROPERTY_RELATED_LINKS = "relatedLinks";
    @JsonbProperty(JSON_PROPERTY_RELATED_LINKS)
    @Schema(readOnly = true)
    private Object relatedLinks;

    public static final String JSON_PROPERTY_SCM_ID = "scmId";
    @JsonbProperty(JSON_PROPERTY_SCM_ID)
    @Schema(example = "git")
    private String scmId;

    public static final String JSON_PROPERTY_SCOPE = "scope";
    @JsonbProperty(JSON_PROPERTY_SCOPE)
    @Schema(readOnly = true, example = "REPOSITORY")
    private String scope;

    public static final String JSON_PROPERTY_SLUG = "slug";
    @JsonbProperty(JSON_PROPERTY_SLUG)
    @Schema(example = "my-repo")
    private String slug;

    public enum StateEnum {
      AVAILABLE("AVAILABLE"),
      INITIALISATION_FAILED("INITIALISATION_FAILED"),
      INITIALISING("INITIALISING"),
      OFFLINE("OFFLINE");

      private final String value;

      StateEnum(String value) {
        this.value = value;
      }

      public String getValue() {
          return value;
      }

      @Override
      public String toString() {
          return String.valueOf(value);
      }

      public static class StateEnumAdapter implements JsonbAdapter<StateEnum, JsonString> {
          @Override
          public JsonString adaptToJson(StateEnum e) throws Exception {
              return Json.createValue(String.valueOf(e.value));
          }

        @Override
        public StateEnum adaptFromJson(JsonString value) throws Exception {
            for (StateEnum b : StateEnum.values()) {
                if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                    return b;
                }
            }
            throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type StateEnum");
          }
      }
  }

    public static final String JSON_PROPERTY_STATE = "state";
    @JsonbProperty(JSON_PROPERTY_STATE)
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestLabelable.StateEnum.StateEnumAdapter.class)
    @Schema(readOnly = true)
    private StateEnum state;

    public static final String JSON_PROPERTY_STATUS_MESSAGE = "statusMessage";
    @JsonbProperty(JSON_PROPERTY_STATUS_MESSAGE)
    @Schema(readOnly = true, example = "Available")
    private String statusMessage;

    public RestLabelable archived(Boolean archived) {
        this.archived = archived;
        return this;
    }

    /**
     * Get archived
     *
     * @return archived
     **/
    public Boolean isArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public RestLabelable defaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
        return this;
    }

    /**
     * Get defaultBranch
     *
     * @return defaultBranch
     **/
    public String getDefaultBranch() {
        return defaultBranch;
    }

    public void setDefaultBranch(String defaultBranch) {
        this.defaultBranch = defaultBranch;
    }

    public RestLabelable description(String description) {
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

    public RestLabelable forkable(Boolean forkable) {
        this.forkable = forkable;
        return this;
    }

    /**
     * Get forkable
     *
     * @return forkable
     **/
    public Boolean isForkable() {
        return forkable;
    }

    public void setForkable(Boolean forkable) {
        this.forkable = forkable;
    }

    public RestLabelable hierarchyId(String hierarchyId) {
        this.hierarchyId = hierarchyId;
        return this;
    }

    /**
     * Get hierarchyId
     *
     * @return hierarchyId
     **/
    public String getHierarchyId() {
        return hierarchyId;
    }

    public void setHierarchyId(String hierarchyId) {
        this.hierarchyId = hierarchyId;
    }

    public RestLabelable id(Integer id) {
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

    public RestLabelable labelableType(LabelableTypeEnum labelableType) {
        this.labelableType = labelableType;
        return this;
    }

    /**
     * Get labelableType
     *
     * @return labelableType
     **/
    public LabelableTypeEnum getLabelableType() {
        return labelableType;
    }

    public void setLabelableType(LabelableTypeEnum labelableType) {
        this.labelableType = labelableType;
    }

    public RestLabelable links(Object links) {
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

    public RestLabelable name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RestLabelable origin(RestLabelableOrigin origin) {
        this.origin = origin;
        return this;
    }

    /**
     * Get origin
     *
     * @return origin
     **/
    public @Valid RestLabelableOrigin getOrigin() {
        return origin;
    }

    public void setOrigin(RestLabelableOrigin origin) {
        this.origin = origin;
    }

    public RestLabelable partition(Integer partition) {
        this.partition = partition;
        return this;
    }

    /**
     * Get partition
     *
     * @return partition
     **/
    public Integer getPartition() {
        return partition;
    }

    public void setPartition(Integer partition) {
        this.partition = partition;
    }

    public RestLabelable project(RestLabelableProject project) {
        this.project = project;
        return this;
    }

    /**
     * Get project
     *
     * @return project
     **/
    public @Valid RestLabelableProject getProject() {
        return project;
    }

    public void setProject(RestLabelableProject project) {
        this.project = project;
    }

    public RestLabelable public_(Boolean public_) {
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

    public RestLabelable relatedLinks(Object relatedLinks) {
        this.relatedLinks = relatedLinks;
        return this;
    }

    /**
     * Get relatedLinks
     *
     * @return relatedLinks
     **/
    public Object getRelatedLinks() {
        return relatedLinks;
    }

    public void setRelatedLinks(Object relatedLinks) {
        this.relatedLinks = relatedLinks;
    }

    public RestLabelable scmId(String scmId) {
        this.scmId = scmId;
        return this;
    }

    /**
     * Get scmId
     *
     * @return scmId
     **/
    public String getScmId() {
        return scmId;
    }

    public void setScmId(String scmId) {
        this.scmId = scmId;
    }

    public RestLabelable scope(String scope) {
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

    public RestLabelable slug(String slug) {
        this.slug = slug;
        return this;
    }

    /**
     * Get slug
     *
     * @return slug
     **/
    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public RestLabelable state(StateEnum state) {
        this.state = state;
        return this;
    }

    /**
     * Get state
     *
     * @return state
     **/
    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    public RestLabelable statusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
        return this;
    }

    /**
     * Get statusMessage
     *
     * @return statusMessage
     **/
    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestLabelable)) {
            return false;
        }
        RestLabelable other = (RestLabelable) o;
        return Objects.equals(this.archived, other.archived) &&
                Objects.equals(this.defaultBranch, other.defaultBranch) &&
                Objects.equals(this.description, other.description) &&
                Objects.equals(this.forkable, other.forkable) &&
                Objects.equals(this.hierarchyId, other.hierarchyId) &&
                Objects.equals(this.id, other.id) &&
                Objects.equals(this.labelableType, other.labelableType) &&
                Objects.equals(this.links, other.links) &&
                Objects.equals(this.name, other.name) &&
                Objects.equals(this.origin, other.origin) &&
                Objects.equals(this.partition, other.partition) &&
                Objects.equals(this.project, other.project) &&
                Objects.equals(this.public_, other.public_) &&
                Objects.equals(this.relatedLinks, other.relatedLinks) &&
                Objects.equals(this.scmId, other.scmId) &&
                Objects.equals(this.scope, other.scope) &&
                Objects.equals(this.slug, other.slug) &&
                Objects.equals(this.state, other.state) &&
                Objects.equals(this.statusMessage, other.statusMessage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(archived, defaultBranch, description, forkable, hierarchyId, id, labelableType, links, name, origin, partition, project, public_, relatedLinks, scmId, scope, slug, state, statusMessage);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestLabelable {");
        sb.append("\n    archived: ").append(toIndentedString(archived));
        sb.append("\n    defaultBranch: ").append(toIndentedString(defaultBranch));
        sb.append("\n    description: ").append(toIndentedString(description));
        sb.append("\n    forkable: ").append(toIndentedString(forkable));
        sb.append("\n    hierarchyId: ").append(toIndentedString(hierarchyId));
        sb.append("\n    id: ").append(toIndentedString(id));
        sb.append("\n    labelableType: ").append(toIndentedString(labelableType));
        sb.append("\n    links: ").append(toIndentedString(links));
        sb.append("\n    name: ").append(toIndentedString(name));
        sb.append("\n    origin: ").append(toIndentedString(origin));
        sb.append("\n    partition: ").append(toIndentedString(partition));
        sb.append("\n    project: ").append(toIndentedString(project));
        sb.append("\n    public_: ").append(toIndentedString(public_));
        sb.append("\n    relatedLinks: ").append(toIndentedString(relatedLinks));
        sb.append("\n    scmId: ").append(toIndentedString(scmId));
        sb.append("\n    scope: ").append(toIndentedString(scope));
        sb.append("\n    slug: ").append(toIndentedString(slug));
        sb.append("\n    state: ").append(toIndentedString(state));
        sb.append("\n    statusMessage: ").append(toIndentedString(statusMessage));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
