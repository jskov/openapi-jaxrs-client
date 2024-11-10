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
 * RestCommentThreadDiffAnchor
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestCommentThreadDiffAnchor {
    public enum DiffTypeEnum {
      COMMIT("COMMIT"),
      EFFECTIVE("EFFECTIVE"),
      RANGE("RANGE");

      private final String value;

      DiffTypeEnum(String value) {
        this.value = value;
      }

      public String getValue() {
          return value;
      }

      @Override
      public String toString() {
          return String.valueOf(value);
      }

      public static class DiffTypeEnumAdapter implements JsonbAdapter<DiffTypeEnum, JsonString> {
          @Override
          public JsonString adaptToJson(DiffTypeEnum e) throws Exception {
              return Json.createValue(String.valueOf(e.value));
          }

        @Override
        public DiffTypeEnum adaptFromJson(JsonString value) throws Exception {
            for (DiffTypeEnum b : DiffTypeEnum.values()) {
                if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                    return b;
                }
            }
            throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type DiffTypeEnum");
          }
      }
  }

    public static final String JSON_PROPERTY_DIFF_TYPE = "diffType";
    @JsonbProperty(JSON_PROPERTY_DIFF_TYPE)
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestCommentThreadDiffAnchor.DiffTypeEnum.DiffTypeEnumAdapter.class)
    private DiffTypeEnum diffType;

    public enum FileTypeEnum {
      FROM("FROM"),
      TO("TO");

      private final String value;

      FileTypeEnum(String value) {
        this.value = value;
      }

      public String getValue() {
          return value;
      }

      @Override
      public String toString() {
          return String.valueOf(value);
      }

      public static class FileTypeEnumAdapter implements JsonbAdapter<FileTypeEnum, JsonString> {
          @Override
          public JsonString adaptToJson(FileTypeEnum e) throws Exception {
              return Json.createValue(String.valueOf(e.value));
          }

        @Override
        public FileTypeEnum adaptFromJson(JsonString value) throws Exception {
            for (FileTypeEnum b : FileTypeEnum.values()) {
                if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                    return b;
                }
            }
            throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type FileTypeEnum");
          }
      }
  }

    public static final String JSON_PROPERTY_FILE_TYPE = "fileType";
    @JsonbProperty(JSON_PROPERTY_FILE_TYPE)
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestCommentThreadDiffAnchor.FileTypeEnum.FileTypeEnumAdapter.class)
    private FileTypeEnum fileType;

    public static final String JSON_PROPERTY_FROM_HASH = "fromHash";
    @JsonbProperty(JSON_PROPERTY_FROM_HASH)
    @Schema(example = "62a0505e8204115b8b9c8a95bfa264a8c0896a93")
    private String fromHash;

    public static final String JSON_PROPERTY_LINE = "line";
    @JsonbProperty(JSON_PROPERTY_LINE)
    @Schema(example = "98")
    private Integer line;

    public static final String JSON_PROPERTY_LINE_COMMENT = "lineComment";
    @JsonbProperty(JSON_PROPERTY_LINE_COMMENT)
    @Schema(readOnly = true)
    private Boolean lineComment;

    public enum LineTypeEnum {
      ADDED("ADDED"),
      CONTEXT("CONTEXT"),
      REMOVED("REMOVED");

      private final String value;

      LineTypeEnum(String value) {
        this.value = value;
      }

      public String getValue() {
          return value;
      }

      @Override
      public String toString() {
          return String.valueOf(value);
      }

      public static class LineTypeEnumAdapter implements JsonbAdapter<LineTypeEnum, JsonString> {
          @Override
          public JsonString adaptToJson(LineTypeEnum e) throws Exception {
              return Json.createValue(String.valueOf(e.value));
          }

        @Override
        public LineTypeEnum adaptFromJson(JsonString value) throws Exception {
            for (LineTypeEnum b : LineTypeEnum.values()) {
                if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                    return b;
                }
            }
            throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type LineTypeEnum");
          }
      }
  }

    public static final String JSON_PROPERTY_LINE_TYPE = "lineType";
    @JsonbProperty(JSON_PROPERTY_LINE_TYPE)
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestCommentThreadDiffAnchor.LineTypeEnum.LineTypeEnumAdapter.class)
    private LineTypeEnum lineType;

    public static final String JSON_PROPERTY_PATH = "path";
    @JsonbProperty(JSON_PROPERTY_PATH)
    private RestCommentThreadDiffAnchorPath path;

    public static final String JSON_PROPERTY_PULL_REQUEST = "pullRequest";
    @JsonbProperty(JSON_PROPERTY_PULL_REQUEST)
    @Schema(readOnly = true)
    private RestCommentThreadDiffAnchorPullRequest pullRequest;

    public static final String JSON_PROPERTY_SRC_PATH = "srcPath";
    @JsonbProperty(JSON_PROPERTY_SRC_PATH)
    private RestCommentThreadDiffAnchorSrcPath srcPath;

    public static final String JSON_PROPERTY_TO_HASH = "toHash";
    @JsonbProperty(JSON_PROPERTY_TO_HASH)
    @Schema(example = "3cdd5d19178a54d2e51b5098d43b57571241d0ab")
    private String toHash;

    public RestCommentThreadDiffAnchor diffType(DiffTypeEnum diffType) {
        this.diffType = diffType;
        return this;
    }

    /**
     * Get diffType
     *
     * @return diffType
     **/
    public DiffTypeEnum getDiffType() {
        return diffType;
    }

    public void setDiffType(DiffTypeEnum diffType) {
        this.diffType = diffType;
    }

    public RestCommentThreadDiffAnchor fileType(FileTypeEnum fileType) {
        this.fileType = fileType;
        return this;
    }

    /**
     * Get fileType
     *
     * @return fileType
     **/
    public FileTypeEnum getFileType() {
        return fileType;
    }

    public void setFileType(FileTypeEnum fileType) {
        this.fileType = fileType;
    }

    public RestCommentThreadDiffAnchor fromHash(String fromHash) {
        this.fromHash = fromHash;
        return this;
    }

    /**
     * Get fromHash
     *
     * @return fromHash
     **/
    public String getFromHash() {
        return fromHash;
    }

    public void setFromHash(String fromHash) {
        this.fromHash = fromHash;
    }

    public RestCommentThreadDiffAnchor line(Integer line) {
        this.line = line;
        return this;
    }

    /**
     * Get line
     *
     * @return line
     **/
    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public RestCommentThreadDiffAnchor lineComment(Boolean lineComment) {
        this.lineComment = lineComment;
        return this;
    }

    /**
     * Get lineComment
     *
     * @return lineComment
     **/
    public Boolean isLineComment() {
        return lineComment;
    }

    public void setLineComment(Boolean lineComment) {
        this.lineComment = lineComment;
    }

    public RestCommentThreadDiffAnchor lineType(LineTypeEnum lineType) {
        this.lineType = lineType;
        return this;
    }

    /**
     * Get lineType
     *
     * @return lineType
     **/
    public LineTypeEnum getLineType() {
        return lineType;
    }

    public void setLineType(LineTypeEnum lineType) {
        this.lineType = lineType;
    }

    public RestCommentThreadDiffAnchor path(RestCommentThreadDiffAnchorPath path) {
        this.path = path;
        return this;
    }

    /**
     * Get path
     *
     * @return path
     **/
    public @Valid RestCommentThreadDiffAnchorPath getPath() {
        return path;
    }

    public void setPath(RestCommentThreadDiffAnchorPath path) {
        this.path = path;
    }

    public RestCommentThreadDiffAnchor pullRequest(RestCommentThreadDiffAnchorPullRequest pullRequest) {
        this.pullRequest = pullRequest;
        return this;
    }

    /**
     * Get pullRequest
     *
     * @return pullRequest
     **/
    public @Valid RestCommentThreadDiffAnchorPullRequest getPullRequest() {
        return pullRequest;
    }

    public void setPullRequest(RestCommentThreadDiffAnchorPullRequest pullRequest) {
        this.pullRequest = pullRequest;
    }

    public RestCommentThreadDiffAnchor srcPath(RestCommentThreadDiffAnchorSrcPath srcPath) {
        this.srcPath = srcPath;
        return this;
    }

    /**
     * Get srcPath
     *
     * @return srcPath
     **/
    public @Valid RestCommentThreadDiffAnchorSrcPath getSrcPath() {
        return srcPath;
    }

    public void setSrcPath(RestCommentThreadDiffAnchorSrcPath srcPath) {
        this.srcPath = srcPath;
    }

    public RestCommentThreadDiffAnchor toHash(String toHash) {
        this.toHash = toHash;
        return this;
    }

    /**
     * Get toHash
     *
     * @return toHash
     **/
    public String getToHash() {
        return toHash;
    }

    public void setToHash(String toHash) {
        this.toHash = toHash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestCommentThreadDiffAnchor)) {
            return false;
        }
        RestCommentThreadDiffAnchor other = (RestCommentThreadDiffAnchor) o;
        return Objects.equals(this.diffType, other.diffType) &&
                Objects.equals(this.fileType, other.fileType) &&
                Objects.equals(this.fromHash, other.fromHash) &&
                Objects.equals(this.line, other.line) &&
                Objects.equals(this.lineComment, other.lineComment) &&
                Objects.equals(this.lineType, other.lineType) &&
                Objects.equals(this.path, other.path) &&
                Objects.equals(this.pullRequest, other.pullRequest) &&
                Objects.equals(this.srcPath, other.srcPath) &&
                Objects.equals(this.toHash, other.toHash);
    }

    @Override
    public int hashCode() {
        return Objects.hash(diffType, fileType, fromHash, line, lineComment, lineType, path, pullRequest, srcPath, toHash);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestCommentThreadDiffAnchor {");
        sb.append("\n    diffType: ").append(toIndentedString(diffType));
        sb.append("\n    fileType: ").append(toIndentedString(fileType));
        sb.append("\n    fromHash: ").append(toIndentedString(fromHash));
        sb.append("\n    line: ").append(toIndentedString(line));
        sb.append("\n    lineComment: ").append(toIndentedString(lineComment));
        sb.append("\n    lineType: ").append(toIndentedString(lineType));
        sb.append("\n    path: ").append(toIndentedString(path));
        sb.append("\n    pullRequest: ").append(toIndentedString(pullRequest));
        sb.append("\n    srcPath: ").append(toIndentedString(srcPath));
        sb.append("\n    toHash: ").append(toIndentedString(toHash));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
