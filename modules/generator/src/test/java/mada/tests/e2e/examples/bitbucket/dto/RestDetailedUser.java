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
import java.math.BigDecimal;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * RestDetailedUser
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestDetailedUser {
    public static final String JSON_PROPERTY_ACTIVE = "active";
    @JsonbProperty(JSON_PROPERTY_ACTIVE)
    private Boolean active;

    public static final String JSON_PROPERTY_AVATAR_URL = "avatarUrl";
    @JsonbProperty(JSON_PROPERTY_AVATAR_URL)
    private String avatarUrl;

    public static final String JSON_PROPERTY_DELETABLE = "deletable";
    @JsonbProperty(JSON_PROPERTY_DELETABLE)
    private Boolean deletable;

    public static final String JSON_PROPERTY_DIRECTORY_NAME = "directoryName";
    @JsonbProperty(JSON_PROPERTY_DIRECTORY_NAME)
    @Schema(example = "Bitbucket Internal Directory")
    private String directoryName;

    public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
    @JsonbProperty(JSON_PROPERTY_DISPLAY_NAME)
    @Schema(example = "Jane Citizen")
    private String displayName;

    public static final String JSON_PROPERTY_EMAIL_ADDRESS = "emailAddress";
    @JsonbProperty(JSON_PROPERTY_EMAIL_ADDRESS)
    @Schema(example = "jane@example.com")
    private String emailAddress;

    public static final String JSON_PROPERTY_ID = "id";
    @JsonbProperty(JSON_PROPERTY_ID)
    @Schema(readOnly = true, example = "101")
    private Integer id;

    public static final String JSON_PROPERTY_LAST_AUTHENTICATION_TIMESTAMP = "lastAuthenticationTimestamp";
    @JsonbProperty(JSON_PROPERTY_LAST_AUTHENTICATION_TIMESTAMP)
    @Schema(example = "1368145580548")
    private BigDecimal lastAuthenticationTimestamp;

    public static final String JSON_PROPERTY_LINKS = "links";
    @JsonbProperty(JSON_PROPERTY_LINKS)
    private Object links;

    public static final String JSON_PROPERTY_MUTABLE_DETAILS = "mutableDetails";
    @JsonbProperty(JSON_PROPERTY_MUTABLE_DETAILS)
    private Boolean mutableDetails;

    public static final String JSON_PROPERTY_MUTABLE_GROUPS = "mutableGroups";
    @JsonbProperty(JSON_PROPERTY_MUTABLE_GROUPS)
    private Boolean mutableGroups;

    public static final String JSON_PROPERTY_NAME = "name";
    @JsonbProperty(JSON_PROPERTY_NAME)
    @Schema(example = "jcitizen")
    private String name;

    public static final String JSON_PROPERTY_SLUG = "slug";
    @JsonbProperty(JSON_PROPERTY_SLUG)
    @Schema(example = "jcitizen")
    private String slug;

    public enum TypeEnum {
        NORMAL("NORMAL"),
        SERVICE("SERVICE");

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
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestDetailedUser.TypeEnum.TypeEnumAdapter.class)
    private TypeEnum type;

    public RestDetailedUser active(Boolean active) {
        this.active = active;
        return this;
    }

    /**
     * Get active
     *
     * @return active
     **/
    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public RestDetailedUser avatarUrl(String avatarUrl) {
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

    public RestDetailedUser deletable(Boolean deletable) {
        this.deletable = deletable;
        return this;
    }

    /**
     * Get deletable
     *
     * @return deletable
     **/
    public Boolean isDeletable() {
        return deletable;
    }

    public void setDeletable(Boolean deletable) {
        this.deletable = deletable;
    }

    public RestDetailedUser directoryName(String directoryName) {
        this.directoryName = directoryName;
        return this;
    }

    /**
     * Get directoryName
     *
     * @return directoryName
     **/
    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    public RestDetailedUser displayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get displayName
     *
     * @return displayName
     **/
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public RestDetailedUser emailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    /**
     * Get emailAddress
     *
     * @return emailAddress
     **/
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public RestDetailedUser id(Integer id) {
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

    public RestDetailedUser lastAuthenticationTimestamp(BigDecimal lastAuthenticationTimestamp) {
        this.lastAuthenticationTimestamp = lastAuthenticationTimestamp;
        return this;
    }

    /**
     * Get lastAuthenticationTimestamp
     *
     * @return lastAuthenticationTimestamp
     **/
    public BigDecimal getLastAuthenticationTimestamp() {
        return lastAuthenticationTimestamp;
    }

    public void setLastAuthenticationTimestamp(BigDecimal lastAuthenticationTimestamp) {
        this.lastAuthenticationTimestamp = lastAuthenticationTimestamp;
    }

    public RestDetailedUser links(Object links) {
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

    public RestDetailedUser mutableDetails(Boolean mutableDetails) {
        this.mutableDetails = mutableDetails;
        return this;
    }

    /**
     * Get mutableDetails
     *
     * @return mutableDetails
     **/
    public Boolean isMutableDetails() {
        return mutableDetails;
    }

    public void setMutableDetails(Boolean mutableDetails) {
        this.mutableDetails = mutableDetails;
    }

    public RestDetailedUser mutableGroups(Boolean mutableGroups) {
        this.mutableGroups = mutableGroups;
        return this;
    }

    /**
     * Get mutableGroups
     *
     * @return mutableGroups
     **/
    public Boolean isMutableGroups() {
        return mutableGroups;
    }

    public void setMutableGroups(Boolean mutableGroups) {
        this.mutableGroups = mutableGroups;
    }

    public RestDetailedUser name(String name) {
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

    public RestDetailedUser slug(String slug) {
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

    public RestDetailedUser type(TypeEnum type) {
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
        if (!(o instanceof RestDetailedUser)) {
            return false;
        }
        RestDetailedUser other = (RestDetailedUser) o;
        return Objects.equals(this.active, other.active) &&
                Objects.equals(this.avatarUrl, other.avatarUrl) &&
                Objects.equals(this.deletable, other.deletable) &&
                Objects.equals(this.directoryName, other.directoryName) &&
                Objects.equals(this.displayName, other.displayName) &&
                Objects.equals(this.emailAddress, other.emailAddress) &&
                Objects.equals(this.id, other.id) &&
                Objects.equals(this.lastAuthenticationTimestamp, other.lastAuthenticationTimestamp) &&
                Objects.equals(this.links, other.links) &&
                Objects.equals(this.mutableDetails, other.mutableDetails) &&
                Objects.equals(this.mutableGroups, other.mutableGroups) &&
                Objects.equals(this.name, other.name) &&
                Objects.equals(this.slug, other.slug) &&
                Objects.equals(this.type, other.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(active, avatarUrl, deletable, directoryName, displayName, emailAddress, id, lastAuthenticationTimestamp, links,
                mutableDetails, mutableGroups, name, slug, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestDetailedUser {");
        sb.append("\n    active: ").append(toIndentedString(active));
        sb.append("\n    avatarUrl: ").append(toIndentedString(avatarUrl));
        sb.append("\n    deletable: ").append(toIndentedString(deletable));
        sb.append("\n    directoryName: ").append(toIndentedString(directoryName));
        sb.append("\n    displayName: ").append(toIndentedString(displayName));
        sb.append("\n    emailAddress: ").append(toIndentedString(emailAddress));
        sb.append("\n    id: ").append(toIndentedString(id));
        sb.append("\n    lastAuthenticationTimestamp: ").append(toIndentedString(lastAuthenticationTimestamp));
        sb.append("\n    links: ").append(toIndentedString(links));
        sb.append("\n    mutableDetails: ").append(toIndentedString(mutableDetails));
        sb.append("\n    mutableGroups: ").append(toIndentedString(mutableGroups));
        sb.append("\n    name: ").append(toIndentedString(name));
        sb.append("\n    slug: ").append(toIndentedString(slug));
        sb.append("\n    type: ").append(toIndentedString(type));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
