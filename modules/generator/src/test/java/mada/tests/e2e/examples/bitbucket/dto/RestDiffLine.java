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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * RestDiffLine
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestDiffLine {
    public static final String JSON_PROPERTY_COMMENT_IDS = "commentIds";
    @JsonbProperty(JSON_PROPERTY_COMMENT_IDS)
    private List<Long> commentIds;

    public enum ConflictMarkerEnum {
        MARKER("MARKER"),
        OURS("OURS"),
        THEIRS("THEIRS");

        private final String value;

        ConflictMarkerEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static class ConflictMarkerEnumAdapter implements JsonbAdapter<ConflictMarkerEnum, JsonString> {
            @Override
            public JsonString adaptToJson(ConflictMarkerEnum e) throws Exception {
                return Json.createValue(String.valueOf(e.value));
            }

            @Override
            public ConflictMarkerEnum adaptFromJson(JsonString value) throws Exception {
                for (ConflictMarkerEnum b : ConflictMarkerEnum.values()) {
                    if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                        return b;
                    }
                }
                throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type ConflictMarkerEnum");
            }
        }
    }

    public static final String JSON_PROPERTY_CONFLICT_MARKER = "conflictMarker";
    @JsonbProperty(JSON_PROPERTY_CONFLICT_MARKER)
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestDiffLine.ConflictMarkerEnum.ConflictMarkerEnumAdapter.class)
    private ConflictMarkerEnum conflictMarker;

    public static final String JSON_PROPERTY_DESTINATION = "destination";
    @JsonbProperty(JSON_PROPERTY_DESTINATION)
    private Integer destination;

    public static final String JSON_PROPERTY_LINE = "line";
    @JsonbProperty(JSON_PROPERTY_LINE)
    private String line;

    public static final String JSON_PROPERTY_SOURCE = "source";
    @JsonbProperty(JSON_PROPERTY_SOURCE)
    private Integer source;

    public static final String JSON_PROPERTY_TRUNCATED = "truncated";
    @JsonbProperty(JSON_PROPERTY_TRUNCATED)
    private Boolean truncated;

    public RestDiffLine commentIds(List<Long> commentIds) {
        this.commentIds = commentIds;
        return this;
    }

    public RestDiffLine addCommentIdsItem(long commentIdsItem) {
        if (this.commentIds == null) {
            this.commentIds = new ArrayList<>();
        }
        this.commentIds.add(commentIdsItem);
        return this;
    }

    /**
     * Get commentIds
     *
     * @return commentIds
     **/
    public List<Long> getCommentIds() {
        return commentIds;
    }

    public void setCommentIds(List<Long> commentIds) {
        this.commentIds = commentIds;
    }

    public RestDiffLine conflictMarker(ConflictMarkerEnum conflictMarker) {
        this.conflictMarker = conflictMarker;
        return this;
    }

    /**
     * Get conflictMarker
     *
     * @return conflictMarker
     **/
    public ConflictMarkerEnum getConflictMarker() {
        return conflictMarker;
    }

    public void setConflictMarker(ConflictMarkerEnum conflictMarker) {
        this.conflictMarker = conflictMarker;
    }

    public RestDiffLine destination(Integer destination) {
        this.destination = destination;
        return this;
    }

    /**
     * Get destination
     *
     * @return destination
     **/
    public Integer getDestination() {
        return destination;
    }

    public void setDestination(Integer destination) {
        this.destination = destination;
    }

    public RestDiffLine line(String line) {
        this.line = line;
        return this;
    }

    /**
     * Get line
     *
     * @return line
     **/
    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public RestDiffLine source(Integer source) {
        this.source = source;
        return this;
    }

    /**
     * Get source
     *
     * @return source
     **/
    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public RestDiffLine truncated(Boolean truncated) {
        this.truncated = truncated;
        return this;
    }

    /**
     * Get truncated
     *
     * @return truncated
     **/
    public Boolean isTruncated() {
        return truncated;
    }

    public void setTruncated(Boolean truncated) {
        this.truncated = truncated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestDiffLine)) {
            return false;
        }
        RestDiffLine other = (RestDiffLine) o;
        return Objects.equals(this.commentIds, other.commentIds) &&
                Objects.equals(this.conflictMarker, other.conflictMarker) &&
                Objects.equals(this.destination, other.destination) &&
                Objects.equals(this.line, other.line) &&
                Objects.equals(this.source, other.source) &&
                Objects.equals(this.truncated, other.truncated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentIds, conflictMarker, destination, line, source, truncated);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestDiffLine {");
        sb.append("\n    commentIds: ").append(toIndentedString(commentIds));
        sb.append("\n    conflictMarker: ").append(toIndentedString(conflictMarker));
        sb.append("\n    destination: ").append(toIndentedString(destination));
        sb.append("\n    line: ").append(toIndentedString(line));
        sb.append("\n    source: ").append(toIndentedString(source));
        sb.append("\n    truncated: ").append(toIndentedString(truncated));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
