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
 * RestChange
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestChange {
    public static final String JSON_PROPERTY_CONFLICT = "conflict";
    @JsonbProperty(JSON_PROPERTY_CONFLICT)
    private RestChangeConflict conflict;

    public static final String JSON_PROPERTY_CONTENT_ID = "contentId";
    @JsonbProperty(JSON_PROPERTY_CONTENT_ID)
    @Schema(example = "abcdef0123abcdef4567abcdef8987abcdef6543")
    private String contentId;

    public static final String JSON_PROPERTY_EXECUTABLE = "executable";
    @JsonbProperty(JSON_PROPERTY_EXECUTABLE)
    private Boolean executable;

    public static final String JSON_PROPERTY_FROM_CONTENT_ID = "fromContentId";
    @JsonbProperty(JSON_PROPERTY_FROM_CONTENT_ID)
    @Schema(example = "bcdef0123abcdef4567abcdef8987abcdef6543a")
    private String fromContentId;

    public static final String JSON_PROPERTY_LINKS = "links";
    @JsonbProperty(JSON_PROPERTY_LINKS)
    private Object links;

    public enum NodeTypeEnum {
      DIRECTORY("DIRECTORY"),
      FILE("FILE"),
      SUBMODULE("SUBMODULE");

      private final String value;

      NodeTypeEnum(String value) {
        this.value = value;
      }

      public String getValue() {
          return value;
      }

      @Override
      public String toString() {
          return String.valueOf(value);
      }

      public static class NodeTypeEnumAdapter implements JsonbAdapter<NodeTypeEnum, JsonString> {
          @Override
          public JsonString adaptToJson(NodeTypeEnum e) throws Exception {
              return Json.createValue(String.valueOf(e.value));
          }

        @Override
        public NodeTypeEnum adaptFromJson(JsonString value) throws Exception {
            for (NodeTypeEnum b : NodeTypeEnum.values()) {
                if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                    return b;
                }
            }
            throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type NodeTypeEnum");
          }
      }
  }

    public static final String JSON_PROPERTY_NODE_TYPE = "nodeType";
    @JsonbProperty(JSON_PROPERTY_NODE_TYPE)
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestChange.NodeTypeEnum.NodeTypeEnumAdapter.class)
    private NodeTypeEnum nodeType;

    public static final String JSON_PROPERTY_PATH = "path";
    @JsonbProperty(JSON_PROPERTY_PATH)
    private RestChangePath path;

    public static final String JSON_PROPERTY_PERCENT_UNCHANGED = "percentUnchanged";
    @JsonbProperty(JSON_PROPERTY_PERCENT_UNCHANGED)
    @Schema(example = "98")
    private Integer percentUnchanged;

    public static final String JSON_PROPERTY_SRC_EXECUTABLE = "srcExecutable";
    @JsonbProperty(JSON_PROPERTY_SRC_EXECUTABLE)
    private Boolean srcExecutable;

    public static final String JSON_PROPERTY_SRC_PATH = "srcPath";
    @JsonbProperty(JSON_PROPERTY_SRC_PATH)
    private RestChangeSrcPath srcPath;

    public enum TypeEnum {
      ADD("ADD"),
      COPY("COPY"),
      DELETE("DELETE"),
      MODIFY("MODIFY"),
      MOVE("MOVE"),
      UNKNOWN("UNKNOWN");

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
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestChange.TypeEnum.TypeEnumAdapter.class)
    private TypeEnum type;

    public RestChange conflict(RestChangeConflict conflict) {
        this.conflict = conflict;
        return this;
    }

    /**
     * Get conflict
     *
     * @return conflict
     **/
    @Valid public RestChangeConflict getConflict() {
        return conflict;
    }

    public void setConflict(RestChangeConflict conflict) {
        this.conflict = conflict;
    }

    public RestChange contentId(String contentId) {
        this.contentId = contentId;
        return this;
    }

    /**
     * Get contentId
     *
     * @return contentId
     **/
    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    public RestChange executable(Boolean executable) {
        this.executable = executable;
        return this;
    }

    /**
     * Get executable
     *
     * @return executable
     **/
    public Boolean isExecutable() {
        return executable;
    }

    public void setExecutable(Boolean executable) {
        this.executable = executable;
    }

    public RestChange fromContentId(String fromContentId) {
        this.fromContentId = fromContentId;
        return this;
    }

    /**
     * Get fromContentId
     *
     * @return fromContentId
     **/
    public String getFromContentId() {
        return fromContentId;
    }

    public void setFromContentId(String fromContentId) {
        this.fromContentId = fromContentId;
    }

    public RestChange links(Object links) {
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

    public RestChange nodeType(NodeTypeEnum nodeType) {
        this.nodeType = nodeType;
        return this;
    }

    /**
     * Get nodeType
     *
     * @return nodeType
     **/
    public NodeTypeEnum getNodeType() {
        return nodeType;
    }

    public void setNodeType(NodeTypeEnum nodeType) {
        this.nodeType = nodeType;
    }

    public RestChange path(RestChangePath path) {
        this.path = path;
        return this;
    }

    /**
     * Get path
     *
     * @return path
     **/
    @Valid public RestChangePath getPath() {
        return path;
    }

    public void setPath(RestChangePath path) {
        this.path = path;
    }

    public RestChange percentUnchanged(Integer percentUnchanged) {
        this.percentUnchanged = percentUnchanged;
        return this;
    }

    /**
     * Get percentUnchanged
     *
     * @return percentUnchanged
     **/
    public Integer getPercentUnchanged() {
        return percentUnchanged;
    }

    public void setPercentUnchanged(Integer percentUnchanged) {
        this.percentUnchanged = percentUnchanged;
    }

    public RestChange srcExecutable(Boolean srcExecutable) {
        this.srcExecutable = srcExecutable;
        return this;
    }

    /**
     * Get srcExecutable
     *
     * @return srcExecutable
     **/
    public Boolean isSrcExecutable() {
        return srcExecutable;
    }

    public void setSrcExecutable(Boolean srcExecutable) {
        this.srcExecutable = srcExecutable;
    }

    public RestChange srcPath(RestChangeSrcPath srcPath) {
        this.srcPath = srcPath;
        return this;
    }

    /**
     * Get srcPath
     *
     * @return srcPath
     **/
    @Valid public RestChangeSrcPath getSrcPath() {
        return srcPath;
    }

    public void setSrcPath(RestChangeSrcPath srcPath) {
        this.srcPath = srcPath;
    }

    public RestChange type(TypeEnum type) {
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
        if (!(o instanceof RestChange)) {
            return false;
        }
        RestChange other = (RestChange) o;
        return Objects.equals(this.conflict, other.conflict) &&
                Objects.equals(this.contentId, other.contentId) &&
                Objects.equals(this.executable, other.executable) &&
                Objects.equals(this.fromContentId, other.fromContentId) &&
                Objects.equals(this.links, other.links) &&
                Objects.equals(this.nodeType, other.nodeType) &&
                Objects.equals(this.path, other.path) &&
                Objects.equals(this.percentUnchanged, other.percentUnchanged) &&
                Objects.equals(this.srcExecutable, other.srcExecutable) &&
                Objects.equals(this.srcPath, other.srcPath) &&
                Objects.equals(this.type, other.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conflict, contentId, executable, fromContentId, links, nodeType, path, percentUnchanged, srcExecutable, srcPath, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestChange {");
        sb.append("\n    conflict: ").append(toIndentedString(conflict));
        sb.append("\n    contentId: ").append(toIndentedString(contentId));
        sb.append("\n    executable: ").append(toIndentedString(executable));
        sb.append("\n    fromContentId: ").append(toIndentedString(fromContentId));
        sb.append("\n    links: ").append(toIndentedString(links));
        sb.append("\n    nodeType: ").append(toIndentedString(nodeType));
        sb.append("\n    path: ").append(toIndentedString(path));
        sb.append("\n    percentUnchanged: ").append(toIndentedString(percentUnchanged));
        sb.append("\n    srcExecutable: ").append(toIndentedString(srcExecutable));
        sb.append("\n    srcPath: ").append(toIndentedString(srcPath));
        sb.append("\n    type: ").append(toIndentedString(type));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
