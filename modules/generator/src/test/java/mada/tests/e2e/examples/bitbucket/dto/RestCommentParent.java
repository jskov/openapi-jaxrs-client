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
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestCommentParent
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestCommentParent {
    public static final String JSON_PROPERTY_ANCHOR = "anchor";
    @JsonbProperty(JSON_PROPERTY_ANCHOR)
    @Schema(readOnly = true)
    private RestCommentParentAnchor anchor;

    public static final String JSON_PROPERTY_ANCHORED = "anchored";
    @JsonbProperty(JSON_PROPERTY_ANCHORED)
    @Schema(readOnly = true)
    private Boolean anchored;

    public static final String JSON_PROPERTY_AUTHOR = "author";
    @JsonbProperty(JSON_PROPERTY_AUTHOR)
    @Schema(readOnly = true)
    private RestCommentParentAuthor author;

    public static final String JSON_PROPERTY_COMMENTS = "comments";
    @JsonbProperty(JSON_PROPERTY_COMMENTS)
    @Schema(readOnly = true)
    private List<RestComment> comments;

    public static final String JSON_PROPERTY_CREATED_DATE = "createdDate";
    @JsonbProperty(JSON_PROPERTY_CREATED_DATE)
    @Schema(readOnly = true, example = "1359075920")
    private Long createdDate;

    public static final String JSON_PROPERTY_HTML = "html";
    @JsonbProperty(JSON_PROPERTY_HTML)
    @Schema(readOnly = true)
    private String html;

    public static final String JSON_PROPERTY_ID = "id";
    @JsonbProperty(JSON_PROPERTY_ID)
    @Schema(example = "1")
    private Long id;

    public static final String JSON_PROPERTY_PENDING = "pending";
    @JsonbProperty(JSON_PROPERTY_PENDING)
    @Schema(readOnly = true)
    private Boolean pending;

    public static final String JSON_PROPERTY_PROPERTIES = "properties";
    @JsonbProperty(JSON_PROPERTY_PROPERTIES)
    private Object properties;

    public static final String JSON_PROPERTY_REPLY = "reply";
    @JsonbProperty(JSON_PROPERTY_REPLY)
    @Schema(readOnly = true)
    private Boolean reply;

    public static final String JSON_PROPERTY_RESOLVED_DATE = "resolvedDate";
    @JsonbProperty(JSON_PROPERTY_RESOLVED_DATE)
    @Schema(readOnly = true, example = "1239075920")
    private Long resolvedDate;

    public static final String JSON_PROPERTY_RESOLVER = "resolver";
    @JsonbProperty(JSON_PROPERTY_RESOLVER)
    @Schema(readOnly = true)
    private RestCommentParentResolver resolver;

    public static final String JSON_PROPERTY_SEVERITY = "severity";
    @JsonbProperty(JSON_PROPERTY_SEVERITY)
    @Schema(example = "NORMAL")
    private String severity;

    public static final String JSON_PROPERTY_STATE = "state";
    @JsonbProperty(JSON_PROPERTY_STATE)
    @Schema(example = "OPEN")
    private String state;

    public static final String JSON_PROPERTY_TEXT = "text";
    @JsonbProperty(JSON_PROPERTY_TEXT)
    @Schema(example = "An insightful comment.")
    private String text;

    public static final String JSON_PROPERTY_THREAD_RESOLVED = "threadResolved";
    @JsonbProperty(JSON_PROPERTY_THREAD_RESOLVED)
    @Schema(description = "Indicates if this comment thread has been marked as resolved or not")
    private Boolean threadResolved;

    public static final String JSON_PROPERTY_THREAD_RESOLVED_DATE = "threadResolvedDate";
    @JsonbProperty(JSON_PROPERTY_THREAD_RESOLVED_DATE)
    @Schema(readOnly = true, example = "1569075920")
    private Long threadResolvedDate;

    public static final String JSON_PROPERTY_THREAD_RESOLVER = "threadResolver";
    @JsonbProperty(JSON_PROPERTY_THREAD_RESOLVER)
    @Schema(readOnly = true)
    private RestCommentParentThreadResolver threadResolver;

    public static final String JSON_PROPERTY_UPDATED_DATE = "updatedDate";
    @JsonbProperty(JSON_PROPERTY_UPDATED_DATE)
    @Schema(readOnly = true, example = "1449075920")
    private Long updatedDate;

    public static final String JSON_PROPERTY_VERSION = "version";
    @JsonbProperty(JSON_PROPERTY_VERSION)
    @Schema(example = "1")
    private Integer version;

    public RestCommentParent anchor(RestCommentParentAnchor anchor) {
        this.anchor = anchor;
        return this;
    }

    /**
     * Get anchor
     *
     * @return anchor
     **/
    @Valid
    public RestCommentParentAnchor getAnchor() {
        return anchor;
    }

    public void setAnchor(RestCommentParentAnchor anchor) {
        this.anchor = anchor;
    }

    public RestCommentParent anchored(Boolean anchored) {
        this.anchored = anchored;
        return this;
    }

    /**
     * Get anchored
     *
     * @return anchored
     **/
    public Boolean isAnchored() {
        return anchored;
    }

    public void setAnchored(Boolean anchored) {
        this.anchored = anchored;
    }

    public RestCommentParent author(RestCommentParentAuthor author) {
        this.author = author;
        return this;
    }

    /**
     * Get author
     *
     * @return author
     **/
    @Valid
    public RestCommentParentAuthor getAuthor() {
        return author;
    }

    public void setAuthor(RestCommentParentAuthor author) {
        this.author = author;
    }

    public RestCommentParent comments(List<RestComment> comments) {
        this.comments = comments;
        return this;
    }

    public RestCommentParent addCommentsItem(RestComment commentsItem) {
        if (this.comments == null) {
            this.comments = new ArrayList<>();
        }
        this.comments.add(commentsItem);
        return this;
    }

    /**
     * Get comments
     *
     * @return comments
     **/
    @Valid
    public List<RestComment> getComments() {
        return comments;
    }

    public void setComments(List<RestComment> comments) {
        this.comments = comments;
    }

    public RestCommentParent createdDate(Long createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    /**
     * Get createdDate
     *
     * @return createdDate
     **/
    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public RestCommentParent html(String html) {
        this.html = html;
        return this;
    }

    /**
     * Get html
     *
     * @return html
     **/
    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public RestCommentParent id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RestCommentParent pending(Boolean pending) {
        this.pending = pending;
        return this;
    }

    /**
     * Get pending
     *
     * @return pending
     **/
    public Boolean isPending() {
        return pending;
    }

    public void setPending(Boolean pending) {
        this.pending = pending;
    }

    public RestCommentParent properties(Object properties) {
        this.properties = properties;
        return this;
    }

    /**
     * Get properties
     *
     * @return properties
     **/
    public Object getProperties() {
        return properties;
    }

    public void setProperties(Object properties) {
        this.properties = properties;
    }

    public RestCommentParent reply(Boolean reply) {
        this.reply = reply;
        return this;
    }

    /**
     * Get reply
     *
     * @return reply
     **/
    public Boolean isReply() {
        return reply;
    }

    public void setReply(Boolean reply) {
        this.reply = reply;
    }

    public RestCommentParent resolvedDate(Long resolvedDate) {
        this.resolvedDate = resolvedDate;
        return this;
    }

    /**
     * Get resolvedDate
     *
     * @return resolvedDate
     **/
    public Long getResolvedDate() {
        return resolvedDate;
    }

    public void setResolvedDate(Long resolvedDate) {
        this.resolvedDate = resolvedDate;
    }

    public RestCommentParent resolver(RestCommentParentResolver resolver) {
        this.resolver = resolver;
        return this;
    }

    /**
     * Get resolver
     *
     * @return resolver
     **/
    @Valid
    public RestCommentParentResolver getResolver() {
        return resolver;
    }

    public void setResolver(RestCommentParentResolver resolver) {
        this.resolver = resolver;
    }

    public RestCommentParent severity(String severity) {
        this.severity = severity;
        return this;
    }

    /**
     * Get severity
     *
     * @return severity
     **/
    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public RestCommentParent state(String state) {
        this.state = state;
        return this;
    }

    /**
     * Get state
     *
     * @return state
     **/
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public RestCommentParent text(String text) {
        this.text = text;
        return this;
    }

    /**
     * Get text
     *
     * @return text
     **/
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public RestCommentParent threadResolved(Boolean threadResolved) {
        this.threadResolved = threadResolved;
        return this;
    }

    /**
     * Indicates if this comment thread has been marked as resolved or not.
     * 
     * @return threadResolved
     **/
    public Boolean isThreadResolved() {
        return threadResolved;
    }

    public void setThreadResolved(Boolean threadResolved) {
        this.threadResolved = threadResolved;
    }

    public RestCommentParent threadResolvedDate(Long threadResolvedDate) {
        this.threadResolvedDate = threadResolvedDate;
        return this;
    }

    /**
     * Get threadResolvedDate
     *
     * @return threadResolvedDate
     **/
    public Long getThreadResolvedDate() {
        return threadResolvedDate;
    }

    public void setThreadResolvedDate(Long threadResolvedDate) {
        this.threadResolvedDate = threadResolvedDate;
    }

    public RestCommentParent threadResolver(RestCommentParentThreadResolver threadResolver) {
        this.threadResolver = threadResolver;
        return this;
    }

    /**
     * Get threadResolver
     *
     * @return threadResolver
     **/
    @Valid
    public RestCommentParentThreadResolver getThreadResolver() {
        return threadResolver;
    }

    public void setThreadResolver(RestCommentParentThreadResolver threadResolver) {
        this.threadResolver = threadResolver;
    }

    public RestCommentParent updatedDate(Long updatedDate) {
        this.updatedDate = updatedDate;
        return this;
    }

    /**
     * Get updatedDate
     *
     * @return updatedDate
     **/
    public Long getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Long updatedDate) {
        this.updatedDate = updatedDate;
    }

    public RestCommentParent version(Integer version) {
        this.version = version;
        return this;
    }

    /**
     * Get version
     *
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
        if (!(o instanceof RestCommentParent)) {
            return false;
        }
        RestCommentParent other = (RestCommentParent) o;
        return Objects.equals(this.anchor, other.anchor) &&
                Objects.equals(this.anchored, other.anchored) &&
                Objects.equals(this.author, other.author) &&
                Objects.equals(this.comments, other.comments) &&
                Objects.equals(this.createdDate, other.createdDate) &&
                Objects.equals(this.html, other.html) &&
                Objects.equals(this.id, other.id) &&
                Objects.equals(this.pending, other.pending) &&
                Objects.equals(this.properties, other.properties) &&
                Objects.equals(this.reply, other.reply) &&
                Objects.equals(this.resolvedDate, other.resolvedDate) &&
                Objects.equals(this.resolver, other.resolver) &&
                Objects.equals(this.severity, other.severity) &&
                Objects.equals(this.state, other.state) &&
                Objects.equals(this.text, other.text) &&
                Objects.equals(this.threadResolved, other.threadResolved) &&
                Objects.equals(this.threadResolvedDate, other.threadResolvedDate) &&
                Objects.equals(this.threadResolver, other.threadResolver) &&
                Objects.equals(this.updatedDate, other.updatedDate) &&
                Objects.equals(this.version, other.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(anchor, anchored, author, comments, createdDate, html, id, pending, properties, reply, resolvedDate, resolver,
                severity, state, text, threadResolved, threadResolvedDate, threadResolver, updatedDate, version);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestCommentParent {");
        sb.append("\n    anchor: ").append(toIndentedString(anchor));
        sb.append("\n    anchored: ").append(toIndentedString(anchored));
        sb.append("\n    author: ").append(toIndentedString(author));
        sb.append("\n    comments: ").append(toIndentedString(comments));
        sb.append("\n    createdDate: ").append(toIndentedString(createdDate));
        sb.append("\n    html: ").append(toIndentedString(html));
        sb.append("\n    id: ").append(toIndentedString(id));
        sb.append("\n    pending: ").append(toIndentedString(pending));
        sb.append("\n    properties: ").append(toIndentedString(properties));
        sb.append("\n    reply: ").append(toIndentedString(reply));
        sb.append("\n    resolvedDate: ").append(toIndentedString(resolvedDate));
        sb.append("\n    resolver: ").append(toIndentedString(resolver));
        sb.append("\n    severity: ").append(toIndentedString(severity));
        sb.append("\n    state: ").append(toIndentedString(state));
        sb.append("\n    text: ").append(toIndentedString(text));
        sb.append("\n    threadResolved: ").append(toIndentedString(threadResolved));
        sb.append("\n    threadResolvedDate: ").append(toIndentedString(threadResolvedDate));
        sb.append("\n    threadResolver: ").append(toIndentedString(threadResolver));
        sb.append("\n    updatedDate: ").append(toIndentedString(updatedDate));
        sb.append("\n    version: ").append(toIndentedString(version));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
