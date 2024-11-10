/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.dto.validation.allof.dto;

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
public class ProjectCreateDTO {
    public static final String JSON_PROPERTY_CLUSTER = "cluster";
    @JsonbProperty(JSON_PROPERTY_CLUSTER)
    @Schema(required = true)
    private String cluster;

    public static final String JSON_PROPERTY_DESCRIPTION = "description";
    @JsonbProperty(JSON_PROPERTY_DESCRIPTION)
    @Schema(required = true)
    private String description;

    public static final String JSON_PROPERTY_DISPLAY_NAME = "display-name";
    @JsonbProperty(JSON_PROPERTY_DISPLAY_NAME)
    @Schema(required = true)
    private String displayName;

    public static final String JSON_PROPERTY_NAME = "name";
    @JsonbProperty(JSON_PROPERTY_NAME)
    @Schema(required = true)
    private String name;

    public static final String JSON_PROPERTY_OWNER = "owner";
    @JsonbProperty(JSON_PROPERTY_OWNER)
    @Schema(required = true)
    private OwnerDTO owner;

    public static final String JSON_PROPERTY_PRODUCT_OWNER = "product-owner";
    @JsonbProperty(JSON_PROPERTY_PRODUCT_OWNER)
    @Schema(required = true)
    private ProductOwnerDTO productOwner;

    public static final String JSON_PROPERTY_TYPE = "type";
    @JsonbProperty(JSON_PROPERTY_TYPE)
    @Schema(required = true)
    private ProjectType type;

    public ProjectCreateDTO cluster(String cluster) {
        this.cluster = Objects.requireNonNull(cluster, "Property cluster is required, cannot be null");
        return this;
    }

    /**
     * Get cluster
     *
     * @return cluster
     **/
    public @NotNull @Size(min = 1, max = 10) String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = Objects.requireNonNull(cluster, "Property cluster is required, cannot be null");
    }

    public ProjectCreateDTO description(String description) {
        this.description = Objects.requireNonNull(description, "Property description is required, cannot be null");
        return this;
    }

    /**
     * Get description
     *
     * @return description
     **/
    public @NotNull @Size(min = 1, max = 300) String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = Objects.requireNonNull(description, "Property description is required, cannot be null");
    }

    public ProjectCreateDTO displayName(String displayName) {
        this.displayName = Objects.requireNonNull(displayName, "Property displayName is required, cannot be null");
        return this;
    }

    /**
     * Get displayName
     *
     * @return displayName
     **/
    public @NotNull @Size(min = 1, max = 100) String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = Objects.requireNonNull(displayName, "Property displayName is required, cannot be null");
    }

    public ProjectCreateDTO name(String name) {
        this.name = Objects.requireNonNull(name, "Property name is required, cannot be null");
        return this;
    }

    /**
     * Get name
     *
     * @return name
     **/
    public @NotNull @Size(min = 1, max = 100) String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "Property name is required, cannot be null");
    }

    public ProjectCreateDTO owner(OwnerDTO owner) {
        this.owner = Objects.requireNonNull(owner, "Property owner is required, cannot be null");
        return this;
    }

    /**
     * Get owner
     *
     * @return owner
     **/
    public @NotNull @Valid OwnerDTO getOwner() {
        return owner;
    }

    public void setOwner(OwnerDTO owner) {
        this.owner = Objects.requireNonNull(owner, "Property owner is required, cannot be null");
    }

    public ProjectCreateDTO productOwner(ProductOwnerDTO productOwner) {
        this.productOwner = Objects.requireNonNull(productOwner, "Property productOwner is required, cannot be null");
        return this;
    }

    /**
     * Get productOwner
     *
     * @return productOwner
     **/
    public @NotNull @Valid ProductOwnerDTO getProductOwner() {
        return productOwner;
    }

    public void setProductOwner(ProductOwnerDTO productOwner) {
        this.productOwner = Objects.requireNonNull(productOwner, "Property productOwner is required, cannot be null");
    }

    public ProjectCreateDTO type(ProjectType type) {
        this.type = Objects.requireNonNull(type, "Property type is required, cannot be null");
        return this;
    }

    /**
     * Get type
     *
     * @return type
     **/
    public @NotNull @Valid ProjectType getType() {
        return type;
    }

    public void setType(ProjectType type) {
        this.type = Objects.requireNonNull(type, "Property type is required, cannot be null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProjectCreateDTO)) {
            return false;
        }
        ProjectCreateDTO other = (ProjectCreateDTO) o;
        return Objects.equals(this.cluster, other.cluster) &&
                Objects.equals(this.description, other.description) &&
                Objects.equals(this.displayName, other.displayName) &&
                Objects.equals(this.name, other.name) &&
                Objects.equals(this.owner, other.owner) &&
                Objects.equals(this.productOwner, other.productOwner) &&
                Objects.equals(this.type, other.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cluster, description, displayName, name, owner, productOwner, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ProjectCreateDTO {");
        sb.append("\n    cluster: ").append(toIndentedString(cluster));
        sb.append("\n    description: ").append(toIndentedString(description));
        sb.append("\n    displayName: ").append(toIndentedString(displayName));
        sb.append("\n    name: ").append(toIndentedString(name));
        sb.append("\n    owner: ").append(toIndentedString(owner));
        sb.append("\n    productOwner: ").append(toIndentedString(productOwner));
        sb.append("\n    type: ").append(toIndentedString(type));
        sb.append("\n}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        return Objects.toString(o).replace("\n", "\n    ");
    }
}
