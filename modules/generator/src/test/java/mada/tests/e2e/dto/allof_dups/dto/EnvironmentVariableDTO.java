/*
 * jboss-helloworld
 *
 * The version of the OpenAPI document: 1.0
 */

package mada.tests.e2e.dto.allof_dups.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * EnvironmentVariableDTO
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class EnvironmentVariableDTO {
  public static final String JSON_PROPERTY_NAME = "name";
  @JsonbProperty(JSON_PROPERTY_NAME)
  @Schema(required = true)
  private String name;

  public static final String JSON_PROPERTY_OMKOSTNINGER = "Omkostninger";
  @JsonbProperty(JSON_PROPERTY_OMKOSTNINGER)
  private Omkostninger omkostninger;

  public static final String JSON_PROPERTY_VALUE = "value";
  @JsonbProperty(JSON_PROPERTY_VALUE)
  @Schema(required = true)
  private String value;

  public EnvironmentVariableDTO name(String name) {
    this.name = Objects.requireNonNull(name, "Property name is required, cannot be null");
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @NotNull @Size(min = 1, max = 300)
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = Objects.requireNonNull(name, "Property name is required, cannot be null");
  }

  public EnvironmentVariableDTO omkostninger(Omkostninger omkostninger) {
    this.omkostninger = omkostninger;
    return this;
  }

  /**
   * Get omkostninger
   * @return omkostninger
   **/
  @Valid
  public Omkostninger getOmkostninger() {
    return omkostninger;
  }

  public void setOmkostninger(Omkostninger omkostninger) {
    this.omkostninger = omkostninger;
  }

  public EnvironmentVariableDTO value(String value) {
    this.value = Objects.requireNonNull(value, "Property value is required, cannot be null");
    return this;
  }

  /**
   * Get value
   * @return value
   **/
  @NotNull @Size(min = 1, max = 300)
  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = Objects.requireNonNull(value, "Property value is required, cannot be null");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof EnvironmentVariableDTO)) {
      return false;
    }
    EnvironmentVariableDTO other = (EnvironmentVariableDTO) o;
    return Objects.equals(this.name, other.name) &&
        Objects.equals(this.omkostninger, other.omkostninger) &&
        Objects.equals(this.value, other.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, omkostninger, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnvironmentVariableDTO {");
    sb.append("\n    name: ").append(toIndentedString(name));
    sb.append("\n    omkostninger: ").append(toIndentedString(omkostninger));
    sb.append("\n    value: ").append(toIndentedString(value));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
