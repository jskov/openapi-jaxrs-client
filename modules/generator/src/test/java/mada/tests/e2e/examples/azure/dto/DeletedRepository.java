/*
 * Azure Container Registry
 * Metadata API definition for the Azure Container Registry runtime
 *
 * The version of the OpenAPI document: 2019-08-15-preview
 */

package mada.tests.e2e.examples.azure.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Deleted repository.
 */
@Schema(description = "Deleted repository")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class DeletedRepository {
  public static final String JSON_PROPERTY_MANIFESTS_DELETED = "manifestsDeleted";
  @JsonbProperty(JSON_PROPERTY_MANIFESTS_DELETED)
  @Schema(description = "SHA of the deleted image")
  private List<String> manifestsDeleted;

  public static final String JSON_PROPERTY_TAGS_DELETED = "tagsDeleted";
  @JsonbProperty(JSON_PROPERTY_TAGS_DELETED)
  @Schema(description = "Tag of the deleted image")
  private List<String> tagsDeleted;

  public DeletedRepository manifestsDeleted(List<String> manifestsDeleted) {
    this.manifestsDeleted = manifestsDeleted;
    return this;
  }

  public DeletedRepository addManifestsDeletedItem(String manifestsDeletedItem) {
    if (this.manifestsDeleted == null) {
      this.manifestsDeleted = new ArrayList<>();
    }
    this.manifestsDeleted.add(manifestsDeletedItem);
    return this;
  }

  /**
   * SHA of the deleted image.
   *
   * @return manifestsDeleted
   **/
  public List<String> getManifestsDeleted() {
    return manifestsDeleted;
  }

  public void setManifestsDeleted(List<String> manifestsDeleted) {
    this.manifestsDeleted = manifestsDeleted;
  }

  public DeletedRepository tagsDeleted(List<String> tagsDeleted) {
    this.tagsDeleted = tagsDeleted;
    return this;
  }

  public DeletedRepository addTagsDeletedItem(String tagsDeletedItem) {
    if (this.tagsDeleted == null) {
      this.tagsDeleted = new ArrayList<>();
    }
    this.tagsDeleted.add(tagsDeletedItem);
    return this;
  }

  /**
   * Tag of the deleted image.
   *
   * @return tagsDeleted
   **/
  public List<String> getTagsDeleted() {
    return tagsDeleted;
  }

  public void setTagsDeleted(List<String> tagsDeleted) {
    this.tagsDeleted = tagsDeleted;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof DeletedRepository)) {
      return false;
    }
    DeletedRepository other = (DeletedRepository) o;
    return Objects.equals(this.manifestsDeleted, other.manifestsDeleted) &&
        Objects.equals(this.tagsDeleted, other.tagsDeleted);
  }

  @Override
  public int hashCode() {
    return Objects.hash(manifestsDeleted, tagsDeleted);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DeletedRepository {");
    sb.append("\n    manifestsDeleted: ").append(toIndentedString(manifestsDeleted));
    sb.append("\n    tagsDeleted: ").append(toIndentedString(tagsDeleted));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
