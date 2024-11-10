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

/**
 * RestMigrationRepository
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class RestMigrationRepository {
    public enum MigrationStateEnum {
      QUEUED("QUEUED"),
      STAGING("STAGING"),
      STAGED("STAGED"),
      MIGRATED("MIGRATED"),
      FAILED("FAILED"),
      CANCELED("CANCELED"),
      SKIPPED("SKIPPED");

      private final String value;

      MigrationStateEnum(String value) {
        this.value = value;
      }

      public String getValue() {
          return value;
      }

      @Override
      public String toString() {
          return String.valueOf(value);
      }

      public static class MigrationStateEnumAdapter implements JsonbAdapter<MigrationStateEnum, JsonString> {
          @Override
          public JsonString adaptToJson(MigrationStateEnum e) throws Exception {
              return Json.createValue(String.valueOf(e.value));
          }

        @Override
        public MigrationStateEnum adaptFromJson(JsonString value) throws Exception {
            for (MigrationStateEnum b : MigrationStateEnum.values()) {
                if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                    return b;
                }
            }
            throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type MigrationStateEnum");
          }
      }
  }

    public static final String JSON_PROPERTY_MIGRATION_STATE = "migrationState";
    @JsonbProperty(JSON_PROPERTY_MIGRATION_STATE)
    @JsonbTypeAdapter(mada.tests.e2e.examples.bitbucket.dto.RestMigrationRepository.MigrationStateEnum.MigrationStateEnumAdapter.class)
    private MigrationStateEnum migrationState;

    public static final String JSON_PROPERTY_REPOSITORY = "repository";
    @JsonbProperty(JSON_PROPERTY_REPOSITORY)
    private RestMigrationRepositoryRepository repository;

    public RestMigrationRepository migrationState(MigrationStateEnum migrationState) {
        this.migrationState = migrationState;
        return this;
    }

    /**
     * Get migrationState
     *
     * @return migrationState
     **/
    public MigrationStateEnum getMigrationState() {
        return migrationState;
    }

    public void setMigrationState(MigrationStateEnum migrationState) {
        this.migrationState = migrationState;
    }

    public RestMigrationRepository repository(RestMigrationRepositoryRepository repository) {
        this.repository = repository;
        return this;
    }

    /**
     * Get repository
     *
     * @return repository
     **/
    public @Valid RestMigrationRepositoryRepository getRepository() {
        return repository;
    }

    public void setRepository(RestMigrationRepositoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestMigrationRepository)) {
            return false;
        }
        RestMigrationRepository other = (RestMigrationRepository) o;
        return Objects.equals(this.migrationState, other.migrationState) &&
                Objects.equals(this.repository, other.repository);
    }

    @Override
    public int hashCode() {
        return Objects.hash(migrationState, repository);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RestMigrationRepository {");
        sb.append("\n    migrationState: ").append(toIndentedString(migrationState));
        sb.append("\n    repository: ").append(toIndentedString(repository));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
