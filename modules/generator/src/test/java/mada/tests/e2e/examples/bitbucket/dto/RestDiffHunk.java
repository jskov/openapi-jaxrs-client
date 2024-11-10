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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * RestDiffHunk
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestDiffHunk {
    public static final String JSON_PROPERTY_CONTEXT = "context";
    @JsonbProperty(JSON_PROPERTY_CONTEXT)
    private String context;

    public static final String JSON_PROPERTY_DESTINATION_LINE = "destinationLine";
    @JsonbProperty(JSON_PROPERTY_DESTINATION_LINE)
    private Integer destinationLine;

    public static final String JSON_PROPERTY_DESTINATION_SPAN = "destinationSpan";
    @JsonbProperty(JSON_PROPERTY_DESTINATION_SPAN)
    private Integer destinationSpan;

    public static final String JSON_PROPERTY_SEGMENTS = "segments";
    @JsonbProperty(JSON_PROPERTY_SEGMENTS)
    private List<RestDiffSegment> segments;

    public static final String JSON_PROPERTY_SOURCE_LINE = "sourceLine";
    @JsonbProperty(JSON_PROPERTY_SOURCE_LINE)
    private Integer sourceLine;

    public static final String JSON_PROPERTY_SOURCE_SPAN = "sourceSpan";
    @JsonbProperty(JSON_PROPERTY_SOURCE_SPAN)
    private Integer sourceSpan;

    public static final String JSON_PROPERTY_TRUNCATED = "truncated";
    @JsonbProperty(JSON_PROPERTY_TRUNCATED)
    private Boolean truncated;

    public RestDiffHunk context(String context) {
        this.context = context;
        return this;
    }

    /**
     * Get context
     *
     * @return context
     **/
    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public RestDiffHunk destinationLine(Integer destinationLine) {
        this.destinationLine = destinationLine;
        return this;
    }

    /**
     * Get destinationLine
     *
     * @return destinationLine
     **/
    public Integer getDestinationLine() {
        return destinationLine;
    }

    public void setDestinationLine(Integer destinationLine) {
        this.destinationLine = destinationLine;
    }

    public RestDiffHunk destinationSpan(Integer destinationSpan) {
        this.destinationSpan = destinationSpan;
        return this;
    }

    /**
     * Get destinationSpan
     *
     * @return destinationSpan
     **/
    public Integer getDestinationSpan() {
        return destinationSpan;
    }

    public void setDestinationSpan(Integer destinationSpan) {
        this.destinationSpan = destinationSpan;
    }

    public RestDiffHunk segments(List<RestDiffSegment> segments) {
        this.segments = segments;
        return this;
    }

    public RestDiffHunk addSegmentsItem(RestDiffSegment segmentsItem) {
        if (this.segments == null) {
            this.segments = new ArrayList<>();
        }
        this.segments.add(segmentsItem);
        return this;
    }

    /**
     * Get segments
     *
     * @return segments
     **/
    public @Valid List<RestDiffSegment> getSegments() {
        return segments;
    }

    public void setSegments(List<RestDiffSegment> segments) {
        this.segments = segments;
    }

    public RestDiffHunk sourceLine(Integer sourceLine) {
        this.sourceLine = sourceLine;
        return this;
    }

    /**
     * Get sourceLine
     *
     * @return sourceLine
     **/
    public Integer getSourceLine() {
        return sourceLine;
    }

    public void setSourceLine(Integer sourceLine) {
        this.sourceLine = sourceLine;
    }

    public RestDiffHunk sourceSpan(Integer sourceSpan) {
        this.sourceSpan = sourceSpan;
        return this;
    }

    /**
     * Get sourceSpan
     *
     * @return sourceSpan
     **/
    public Integer getSourceSpan() {
        return sourceSpan;
    }

    public void setSourceSpan(Integer sourceSpan) {
        this.sourceSpan = sourceSpan;
    }

    public RestDiffHunk truncated(Boolean truncated) {
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
        if (!(o instanceof RestDiffHunk)) {
            return false;
        }
        RestDiffHunk other = (RestDiffHunk) o;
        return Objects.equals(this.context, other.context) &&
                Objects.equals(this.destinationLine, other.destinationLine) &&
                Objects.equals(this.destinationSpan, other.destinationSpan) &&
                Objects.equals(this.segments, other.segments) &&
                Objects.equals(this.sourceLine, other.sourceLine) &&
                Objects.equals(this.sourceSpan, other.sourceSpan) &&
                Objects.equals(this.truncated, other.truncated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(context, destinationLine, destinationSpan, segments, sourceLine, sourceSpan, truncated);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestDiffHunk {");
        sb.append("\n    context: ").append(toIndentedString(context));
        sb.append("\n    destinationLine: ").append(toIndentedString(destinationLine));
        sb.append("\n    destinationSpan: ").append(toIndentedString(destinationSpan));
        sb.append("\n    segments: ").append(toIndentedString(segments));
        sb.append("\n    sourceLine: ").append(toIndentedString(sourceLine));
        sb.append("\n    sourceSpan: ").append(toIndentedString(sourceSpan));
        sb.append("\n    truncated: ").append(toIndentedString(truncated));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
