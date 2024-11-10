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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestCommentThreadDiffAnchorPullRequest
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestCommentThreadDiffAnchorPullRequest {
    public static final String JSON_PROPERTY_CLOSED = "closed";
    @JsonbProperty(JSON_PROPERTY_CLOSED)
    private Boolean closed;

    public static final String JSON_PROPERTY_CLOSED_DATE = "closedDate";
    @JsonbProperty(JSON_PROPERTY_CLOSED_DATE)
    @Schema(example = "19990759200")
    private Long closedDate;

    public static final String JSON_PROPERTY_CREATED_DATE = "createdDate";
    @JsonbProperty(JSON_PROPERTY_CREATED_DATE)
    @Schema(example = "13590759200")
    private Long createdDate;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    @JsonbProperty(JSON_PROPERTY_DESCRIPTION)
    @Schema(example = "It is a kludge, but put the tuple from the database in the cache.")
    private String description;

    public static final String JSON_PROPERTY_DRAFT = "draft";
    @JsonbProperty(JSON_PROPERTY_DRAFT)
    private Boolean draft;

    public static final String JSON_PROPERTY_FROM_REF = "fromRef";
    @JsonbProperty(JSON_PROPERTY_FROM_REF)
    private RestCommentThreadDiffAnchorPullRequestFromRef fromRef;

    public static final String JSON_PROPERTY_HTML_DESCRIPTION = "htmlDescription";
    @JsonbProperty(JSON_PROPERTY_HTML_DESCRIPTION)
    private String htmlDescription;

    public static final String JSON_PROPERTY_ID = "id";
    @JsonbProperty(JSON_PROPERTY_ID)
    @Schema(example = "1")
    private Long id;

    public static final String JSON_PROPERTY_LINKS = "links";
    @JsonbProperty(JSON_PROPERTY_LINKS)
    private Object links;

    public static final String JSON_PROPERTY_LOCKED = "locked";
    @JsonbProperty(JSON_PROPERTY_LOCKED)
    private Boolean locked;

    public static final String JSON_PROPERTY_OPEN = "open";
    @JsonbProperty(JSON_PROPERTY_OPEN)
    private Boolean open;

    public static final String JSON_PROPERTY_PARTICIPANTS = "participants";
    @JsonbProperty(JSON_PROPERTY_PARTICIPANTS)
    private List<RestPullRequestParticipant> participants;

    public static final String JSON_PROPERTY_REVIEWERS = "reviewers";
    @JsonbProperty(JSON_PROPERTY_REVIEWERS)
    private List<RestPullRequestParticipant> reviewers;

    public enum StateEnum {
      DECLINED("DECLINED"),
      MERGED("MERGED"),
      OPEN("OPEN");

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
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestCommentThreadDiffAnchorPullRequest.StateEnum.StateEnumAdapter.class)
    private StateEnum state;

    public static final String JSON_PROPERTY_TITLE = "title";
    @JsonbProperty(JSON_PROPERTY_TITLE)
    @Schema(example = "Talking Nerdy")
    private String title;

    public static final String JSON_PROPERTY_TO_REF = "toRef";
    @JsonbProperty(JSON_PROPERTY_TO_REF)
    private RestCommentThreadDiffAnchorPullRequestToRef toRef;

    public static final String JSON_PROPERTY_UPDATED_DATE = "updatedDate";
    @JsonbProperty(JSON_PROPERTY_UPDATED_DATE)
    @Schema(example = "14490759200")
    private Long updatedDate;

    public static final String JSON_PROPERTY_VERSION = "version";
    @JsonbProperty(JSON_PROPERTY_VERSION)
    private Integer version;

    public RestCommentThreadDiffAnchorPullRequest closed(Boolean closed) {
        this.closed = closed;
        return this;
    }

    /**
     * Get closed
     *
     * @return closed
     **/
    public Boolean isClosed() {
        return closed;
    }

    public void setClosed(Boolean closed) {
        this.closed = closed;
    }

    public RestCommentThreadDiffAnchorPullRequest closedDate(Long closedDate) {
        this.closedDate = closedDate;
        return this;
    }

    /**
     * Get closedDate
     *
     * @return closedDate
     **/
    public Long getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(Long closedDate) {
        this.closedDate = closedDate;
    }

    public RestCommentThreadDiffAnchorPullRequest createdDate(Long createdDate) {
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

    public RestCommentThreadDiffAnchorPullRequest description(String description) {
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

    public RestCommentThreadDiffAnchorPullRequest draft(Boolean draft) {
        this.draft = draft;
        return this;
    }

    /**
     * Get draft
     *
     * @return draft
     **/
    public Boolean isDraft() {
        return draft;
    }

    public void setDraft(Boolean draft) {
        this.draft = draft;
    }

    public RestCommentThreadDiffAnchorPullRequest fromRef(RestCommentThreadDiffAnchorPullRequestFromRef fromRef) {
        this.fromRef = fromRef;
        return this;
    }

    /**
     * Get fromRef
     *
     * @return fromRef
     **/
    public @Valid RestCommentThreadDiffAnchorPullRequestFromRef getFromRef() {
        return fromRef;
    }

    public void setFromRef(RestCommentThreadDiffAnchorPullRequestFromRef fromRef) {
        this.fromRef = fromRef;
    }

    public RestCommentThreadDiffAnchorPullRequest htmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
        return this;
    }

    /**
     * Get htmlDescription
     *
     * @return htmlDescription
     **/
    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    public RestCommentThreadDiffAnchorPullRequest id(Long id) {
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

    public RestCommentThreadDiffAnchorPullRequest links(Object links) {
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

    public RestCommentThreadDiffAnchorPullRequest locked(Boolean locked) {
        this.locked = locked;
        return this;
    }

    /**
     * Get locked
     *
     * @return locked
     **/
    public Boolean isLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public RestCommentThreadDiffAnchorPullRequest open(Boolean open) {
        this.open = open;
        return this;
    }

    /**
     * Get open
     *
     * @return open
     **/
    public Boolean isOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public RestCommentThreadDiffAnchorPullRequest participants(List<RestPullRequestParticipant> participants) {
        this.participants = participants;
        return this;
    }

    public RestCommentThreadDiffAnchorPullRequest addParticipantsItem(RestPullRequestParticipant participantsItem) {
        if (this.participants == null) {
            this.participants = new ArrayList<>();
        }
        this.participants.add(participantsItem);
        return this;
    }

    /**
     * Get participants
     *
     * @return participants
     **/
    public @Valid List<RestPullRequestParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<RestPullRequestParticipant> participants) {
        this.participants = participants;
    }

    public RestCommentThreadDiffAnchorPullRequest reviewers(List<RestPullRequestParticipant> reviewers) {
        this.reviewers = reviewers;
        return this;
    }

    public RestCommentThreadDiffAnchorPullRequest addReviewersItem(RestPullRequestParticipant reviewersItem) {
        if (this.reviewers == null) {
            this.reviewers = new ArrayList<>();
        }
        this.reviewers.add(reviewersItem);
        return this;
    }

    /**
     * Get reviewers
     *
     * @return reviewers
     **/
    public @Valid List<RestPullRequestParticipant> getReviewers() {
        return reviewers;
    }

    public void setReviewers(List<RestPullRequestParticipant> reviewers) {
        this.reviewers = reviewers;
    }

    public RestCommentThreadDiffAnchorPullRequest state(StateEnum state) {
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

    public RestCommentThreadDiffAnchorPullRequest title(String title) {
        this.title = title;
        return this;
    }

    /**
     * Get title
     *
     * @return title
     **/
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public RestCommentThreadDiffAnchorPullRequest toRef(RestCommentThreadDiffAnchorPullRequestToRef toRef) {
        this.toRef = toRef;
        return this;
    }

    /**
     * Get toRef
     *
     * @return toRef
     **/
    public @Valid RestCommentThreadDiffAnchorPullRequestToRef getToRef() {
        return toRef;
    }

    public void setToRef(RestCommentThreadDiffAnchorPullRequestToRef toRef) {
        this.toRef = toRef;
    }

    public RestCommentThreadDiffAnchorPullRequest updatedDate(Long updatedDate) {
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

    public RestCommentThreadDiffAnchorPullRequest version(Integer version) {
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
        if (!(o instanceof RestCommentThreadDiffAnchorPullRequest)) {
            return false;
        }
        RestCommentThreadDiffAnchorPullRequest other = (RestCommentThreadDiffAnchorPullRequest) o;
        return Objects.equals(this.closed, other.closed) &&
                Objects.equals(this.closedDate, other.closedDate) &&
                Objects.equals(this.createdDate, other.createdDate) &&
                Objects.equals(this.description, other.description) &&
                Objects.equals(this.draft, other.draft) &&
                Objects.equals(this.fromRef, other.fromRef) &&
                Objects.equals(this.htmlDescription, other.htmlDescription) &&
                Objects.equals(this.id, other.id) &&
                Objects.equals(this.links, other.links) &&
                Objects.equals(this.locked, other.locked) &&
                Objects.equals(this.open, other.open) &&
                Objects.equals(this.participants, other.participants) &&
                Objects.equals(this.reviewers, other.reviewers) &&
                Objects.equals(this.state, other.state) &&
                Objects.equals(this.title, other.title) &&
                Objects.equals(this.toRef, other.toRef) &&
                Objects.equals(this.updatedDate, other.updatedDate) &&
                Objects.equals(this.version, other.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(closed, closedDate, createdDate, description, draft, fromRef, htmlDescription, id, links, locked, open, participants, reviewers, state, title, toRef, updatedDate, version);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestCommentThreadDiffAnchorPullRequest {");
        sb.append("\n    closed: ").append(toIndentedString(closed));
        sb.append("\n    closedDate: ").append(toIndentedString(closedDate));
        sb.append("\n    createdDate: ").append(toIndentedString(createdDate));
        sb.append("\n    description: ").append(toIndentedString(description));
        sb.append("\n    draft: ").append(toIndentedString(draft));
        sb.append("\n    fromRef: ").append(toIndentedString(fromRef));
        sb.append("\n    htmlDescription: ").append(toIndentedString(htmlDescription));
        sb.append("\n    id: ").append(toIndentedString(id));
        sb.append("\n    links: ").append(toIndentedString(links));
        sb.append("\n    locked: ").append(toIndentedString(locked));
        sb.append("\n    open: ").append(toIndentedString(open));
        sb.append("\n    participants: ").append(toIndentedString(participants));
        sb.append("\n    reviewers: ").append(toIndentedString(reviewers));
        sb.append("\n    state: ").append(toIndentedString(state));
        sb.append("\n    title: ").append(toIndentedString(title));
        sb.append("\n    toRef: ").append(toIndentedString(toRef));
        sb.append("\n    updatedDate: ").append(toIndentedString(updatedDate));
        sb.append("\n    version: ").append(toIndentedString(version));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
