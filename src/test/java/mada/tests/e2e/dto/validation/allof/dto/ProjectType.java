/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.dto.validation.allof.dto;

import javax.json.Json;
import javax.json.JsonString;
import javax.json.bind.adapter.JsonbAdapter;
import javax.json.bind.annotation.JsonbTypeAdapter;

/**
 * ProjectType
 */
@JsonbTypeAdapter(mada.tests.e2e.dto.validation.allof.dto.ProjectType.ProjectTypeAdapter.class)
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public enum ProjectType {
  BUSINESS("BUSINESS"),
  INFRASTRUCTURE("INFRASTRUCTURE"),
  PLAYGROUND("PLAYGROUND"),
  SYSTEM("SYSTEM");

  private final String value;

  ProjectType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  public static class ProjectTypeAdapter implements JsonbAdapter<ProjectType, JsonString> {
      @Override
      public JsonString adaptToJson(ProjectType e) throws Exception {
          return Json.createValue(String.valueOf(e.value));
      }

      @Override
      public ProjectType adaptFromJson(JsonString value) throws Exception {
          for (ProjectType b : ProjectType.values()) {
              if (String.valueOf(b.value).equalsIgnoreCase(value.getString())) {
                  return b;
              }
          }
          throw new IllegalStateException("Unable to deserialize '" + value.getString() + "' to type ProjectType");
      }
  }
}
