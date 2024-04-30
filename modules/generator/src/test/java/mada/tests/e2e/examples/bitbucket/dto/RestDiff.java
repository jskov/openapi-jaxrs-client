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
 * RestDiff
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestDiff {
  public static final String JSON_PROPERTY_BINARY = "binary";
  @JsonbProperty(JSON_PROPERTY_BINARY)
  private Boolean binary;

  public static final String JSON_PROPERTY_DESTINATION = "destination";
  @JsonbProperty(JSON_PROPERTY_DESTINATION)
  private RestDiffDestination destination;

  public static final String JSON_PROPERTY_HUNKS = "hunks";
  @JsonbProperty(JSON_PROPERTY_HUNKS)
  private List<RestDiffHunk> hunks;

  public static final String JSON_PROPERTY_LINE_COMMENTS = "lineComments";
  @JsonbProperty(JSON_PROPERTY_LINE_COMMENTS)
  private List<RestComment> lineComments;

  public static final String JSON_PROPERTY_PROPERTIES = "properties";
  @JsonbProperty(JSON_PROPERTY_PROPERTIES)
  private Object properties;

  public static final String JSON_PROPERTY_SOURCE = "source";
  @JsonbProperty(JSON_PROPERTY_SOURCE)
  private RestDiffSource source;

  public static final String JSON_PROPERTY_TRUNCATED = "truncated";
  @JsonbProperty(JSON_PROPERTY_TRUNCATED)
  private Boolean truncated;

  public RestDiff binary(Boolean binary) {
    this.binary = binary;
    return this;
  }

  /**
   * Get binary
   * @return binary
   **/
  public Boolean isBinary() {
    return binary;
  }

  public void setBinary(Boolean binary) {
    this.binary = binary;
  }

  public RestDiff destination(RestDiffDestination destination) {
    this.destination = destination;
    return this;
  }

  /**
   * Get destination
   * @return destination
   **/
  @Valid
  public RestDiffDestination getDestination() {
    return destination;
  }

  public void setDestination(RestDiffDestination destination) {
    this.destination = destination;
  }

  public RestDiff hunks(List<RestDiffHunk> hunks) {
    this.hunks = hunks;
    return this;
  }

  public RestDiff addHunksItem(RestDiffHunk hunksItem) {
    if (this.hunks == null) {
      this.hunks = new ArrayList<>();
    }
    this.hunks.add(hunksItem);
    return this;
  }

  /**
   * Get hunks
   * @return hunks
   **/
  @Valid
  public List<RestDiffHunk> getHunks() {
    return hunks;
  }

  public void setHunks(List<RestDiffHunk> hunks) {
    this.hunks = hunks;
  }

  public RestDiff lineComments(List<RestComment> lineComments) {
    this.lineComments = lineComments;
    return this;
  }

  public RestDiff addLineCommentsItem(RestComment lineCommentsItem) {
    if (this.lineComments == null) {
      this.lineComments = new ArrayList<>();
    }
    this.lineComments.add(lineCommentsItem);
    return this;
  }

  /**
   * Get lineComments
   * @return lineComments
   **/
  @Valid
  public List<RestComment> getLineComments() {
    return lineComments;
  }

  public void setLineComments(List<RestComment> lineComments) {
    this.lineComments = lineComments;
  }

  public RestDiff properties(Object properties) {
    this.properties = properties;
    return this;
  }

  /**
   * Get properties
   * @return properties
   **/
  public Object getProperties() {
    return properties;
  }

  public void setProperties(Object properties) {
    this.properties = properties;
  }

  public RestDiff source(RestDiffSource source) {
    this.source = source;
    return this;
  }

  /**
   * Get source
   * @return source
   **/
  @Valid
  public RestDiffSource getSource() {
    return source;
  }

  public void setSource(RestDiffSource source) {
    this.source = source;
  }

  public RestDiff truncated(Boolean truncated) {
    this.truncated = truncated;
    return this;
  }

  /**
   * Get truncated
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
    if (!(o instanceof RestDiff)) {
      return false;
    }
    RestDiff other = (RestDiff) o;
    return Objects.equals(this.binary, other.binary) &&
        Objects.equals(this.destination, other.destination) &&
        Objects.equals(this.hunks, other.hunks) &&
        Objects.equals(this.lineComments, other.lineComments) &&
        Objects.equals(this.properties, other.properties) &&
        Objects.equals(this.source, other.source) &&
        Objects.equals(this.truncated, other.truncated);
  }

  @Override
  public int hashCode() {
    return Objects.hash(binary, destination, hunks, lineComments, properties, source, truncated);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestDiff {");
    sb.append("\n    binary: ").append(toIndentedString(binary));
    sb.append("\n    destination: ").append(toIndentedString(destination));
    sb.append("\n    hunks: ").append(toIndentedString(hunks));
    sb.append("\n    lineComments: ").append(toIndentedString(lineComments));
    sb.append("\n    properties: ").append(toIndentedString(properties));
    sb.append("\n    source: ").append(toIndentedString(source));
    sb.append("\n    truncated: ").append(toIndentedString(truncated));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
