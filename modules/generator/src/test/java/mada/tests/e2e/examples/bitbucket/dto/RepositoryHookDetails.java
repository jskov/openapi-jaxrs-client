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
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 * RepositoryHookDetails
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RepositoryHookDetails {
    public static final String JSON_PROPERTY_CONFIG_FORM_KEY = "configFormKey";
    @JsonbProperty(JSON_PROPERTY_CONFIG_FORM_KEY)
    private String configFormKey;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    @JsonbProperty(JSON_PROPERTY_DESCRIPTION)
    private String description;

    public static final String JSON_PROPERTY_KEY = "key";
    @JsonbProperty(JSON_PROPERTY_KEY)
    private String key;

    public static final String JSON_PROPERTY_NAME = "name";
    @JsonbProperty(JSON_PROPERTY_NAME)
    private String name;

    public enum SupportedScopesEnum {
      GLOBAL("GLOBAL"),
      PROJECT("PROJECT"),
      REPOSITORY("REPOSITORY");

      private final String value;

      SupportedScopesEnum(String value) {
        this.value = value;
      }

      public String getValue() {
          return value;
      }

      @Override
      public String toString() {
          return String.valueOf(value);
      }

      public static class SupportedScopesEnumAdapter implements JsonbAdapter<SupportedScopesEnum, JsonString> {
          @Override
          public JsonString adaptToJson(SupportedScopesEnum e) throws Exception {
              return Json.createValue(String.valueOf(e.value));
          }

        @Override
        public SupportedScopesEnum adaptFromJson(JsonString value) throws Exception {
            for (SupportedScopesEnum b : SupportedScopesEnum.values()) {
                if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                    return b;
                }
            }
            throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type SupportedScopesEnum");
          }
      }
  }

    public static final String JSON_PROPERTY_SUPPORTED_SCOPES = "supportedScopes";
    @JsonbProperty(JSON_PROPERTY_SUPPORTED_SCOPES)
    private Set<SupportedScopesEnum> supportedScopes;

    public enum TypeEnum {
      PRE_RECEIVE("PRE_RECEIVE"),
      PRE_PULL_REQUEST_MERGE("PRE_PULL_REQUEST_MERGE"),
      POST_RECEIVE("POST_RECEIVE");

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
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RepositoryHookDetails.TypeEnum.TypeEnumAdapter.class)
    private TypeEnum type;

    public static final String JSON_PROPERTY_VERSION = "version";
    @JsonbProperty(JSON_PROPERTY_VERSION)
    private String version;

    public RepositoryHookDetails configFormKey(String configFormKey) {
        this.configFormKey = configFormKey;
        return this;
    }

    /**
     * Get configFormKey
     *
     * @return configFormKey
     **/
    public String getConfigFormKey() {
        return configFormKey;
    }

    public void setConfigFormKey(String configFormKey) {
        this.configFormKey = configFormKey;
    }

    public RepositoryHookDetails description(String description) {
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

    public RepositoryHookDetails key(String key) {
        this.key = key;
        return this;
    }

    /**
     * Get key
     *
     * @return key
     **/
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public RepositoryHookDetails name(String name) {
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

    public RepositoryHookDetails supportedScopes(Set<SupportedScopesEnum> supportedScopes) {
        this.supportedScopes = supportedScopes;
        return this;
    }

    public RepositoryHookDetails addSupportedScopesItem(SupportedScopesEnum supportedScopesItem) {
        if (this.supportedScopes == null) {
            this.supportedScopes = new LinkedHashSet<>();
        }
        this.supportedScopes.add(supportedScopesItem);
        return this;
    }

    /**
     * Get supportedScopes
     *
     * @return supportedScopes
     **/
    public Set<SupportedScopesEnum> getSupportedScopes() {
        return supportedScopes;
    }

    public void setSupportedScopes(Set<SupportedScopesEnum> supportedScopes) {
        this.supportedScopes = supportedScopes;
    }

    public RepositoryHookDetails type(TypeEnum type) {
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

    public RepositoryHookDetails version(String version) {
        this.version = version;
        return this;
    }

    /**
     * Get version
     *
     * @return version
     **/
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RepositoryHookDetails)) {
            return false;
        }
        RepositoryHookDetails other = (RepositoryHookDetails) o;
        return Objects.equals(this.configFormKey, other.configFormKey) &&
                Objects.equals(this.description, other.description) &&
                Objects.equals(this.key, other.key) &&
                Objects.equals(this.name, other.name) &&
                Objects.equals(this.supportedScopes, other.supportedScopes) &&
                Objects.equals(this.type, other.type) &&
                Objects.equals(this.version, other.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(configFormKey, description, key, name, supportedScopes, type, version);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RepositoryHookDetails {");
        sb.append("\n    configFormKey: ").append(toIndentedString(configFormKey));
        sb.append("\n    description: ").append(toIndentedString(description));
        sb.append("\n    key: ").append(toIndentedString(key));
        sb.append("\n    name: ").append(toIndentedString(name));
        sb.append("\n    supportedScopes: ").append(toIndentedString(supportedScopes));
        sb.append("\n    type: ").append(toIndentedString(type));
        sb.append("\n    version: ").append(toIndentedString(version));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
