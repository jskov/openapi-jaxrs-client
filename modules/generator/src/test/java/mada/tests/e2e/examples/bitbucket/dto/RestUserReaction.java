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
import java.util.Objects;

/**
 * RestUserReaction
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestUserReaction {
    public static final String JSON_PROPERTY_COMMENT = "comment";
    @JsonbProperty(JSON_PROPERTY_COMMENT)
    private RestUserReactionComment comment;

    public static final String JSON_PROPERTY_EMOTICON = "emoticon";
    @JsonbProperty(JSON_PROPERTY_EMOTICON)
    private RestUserReactionEmoticon emoticon;

    public static final String JSON_PROPERTY_USER = "user";
    @JsonbProperty(JSON_PROPERTY_USER)
    private RestUserReactionUser user;

    public RestUserReaction comment(RestUserReactionComment comment) {
        this.comment = comment;
        return this;
    }

    /**
     * Get comment
     *
     * @return comment
     **/
    @Valid
    public RestUserReactionComment getComment() {
        return comment;
    }

    public void setComment(RestUserReactionComment comment) {
        this.comment = comment;
    }

    public RestUserReaction emoticon(RestUserReactionEmoticon emoticon) {
        this.emoticon = emoticon;
        return this;
    }

    /**
     * Get emoticon
     *
     * @return emoticon
     **/
    @Valid
    public RestUserReactionEmoticon getEmoticon() {
        return emoticon;
    }

    public void setEmoticon(RestUserReactionEmoticon emoticon) {
        this.emoticon = emoticon;
    }

    public RestUserReaction user(RestUserReactionUser user) {
        this.user = user;
        return this;
    }

    /**
     * Get user
     *
     * @return user
     **/
    @Valid
    public RestUserReactionUser getUser() {
        return user;
    }

    public void setUser(RestUserReactionUser user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestUserReaction)) {
            return false;
        }
        RestUserReaction other = (RestUserReaction) o;
        return Objects.equals(this.comment, other.comment) &&
                Objects.equals(this.emoticon, other.emoticon) &&
                Objects.equals(this.user, other.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment, emoticon, user);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestUserReaction {");
        sb.append("\n    comment: ").append(toIndentedString(comment));
        sb.append("\n    emoticon: ").append(toIndentedString(emoticon));
        sb.append("\n    user: ").append(toIndentedString(user));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
