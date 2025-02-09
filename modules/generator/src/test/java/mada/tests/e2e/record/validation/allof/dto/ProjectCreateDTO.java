/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.record.validation.allof.dto;

import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * ProjectCreateDTO
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public record ProjectCreateDTO(
  @JsonbProperty("cluster")
  @Schema(required = true)
  @NotNull @Size(min = 1, max = 10)
  String cluster,

  @JsonbProperty("description")
  @Schema(required = true)
  @NotNull @Size(min = 1, max = 300)
  String description,

  @JsonbProperty("display-name")
  @Schema(required = true)
  @NotNull @Size(min = 1, max = 100)
  String displayName,

  @JsonbProperty("name")
  @Schema(required = true)
  @NotNull @Size(min = 1, max = 100)
  String name,

  @JsonbProperty("owner")
  @Schema(required = true)
  @NotNull @Valid
  OwnerDTO owner,

  @JsonbProperty("product-owner")
  @Schema(required = true)
  @NotNull @Valid
  ProductOwnerDTO productOwner,

  @JsonbProperty("type")
  @Schema(required = true)
  @NotNull @Valid
  ProjectType type) {

    public ProjectCreateDTO {
      Objects.requireNonNull(cluster, "Property cluster is required, cannot be null");
      Objects.requireNonNull(description, "Property description is required, cannot be null");
      Objects.requireNonNull(displayName, "Property displayName is required, cannot be null");
      Objects.requireNonNull(name, "Property name is required, cannot be null");
      Objects.requireNonNull(owner, "Property owner is required, cannot be null");
      Objects.requireNonNull(productOwner, "Property productOwner is required, cannot be null");
      Objects.requireNonNull(type, "Property type is required, cannot be null");
    }
}
