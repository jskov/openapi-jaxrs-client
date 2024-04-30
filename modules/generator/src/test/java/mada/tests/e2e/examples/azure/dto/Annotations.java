/*
 * Azure Container Registry
 * Metadata API definition for the Azure Container Registry runtime
 *
 * The version of the OpenAPI document: 2019-08-15-preview
 */

package mada.tests.e2e.examples.azure.dto;

import jakarta.json.bind.annotation.JsonbProperty;
import java.time.OffsetDateTime;
import java.util.Objects;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Additional information provided through arbitrary metadata.
 */
@Schema(description = "Additional information provided through arbitrary metadata.")
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class Annotations {
  public static final String JSON_PROPERTY_ORG_OPENCONTAINERS_IMAGE_AUTHORS = "org.opencontainers.image.authors";
  @JsonbProperty(JSON_PROPERTY_ORG_OPENCONTAINERS_IMAGE_AUTHORS)
  @Schema(description = "Contact details of the people or organization responsible for the image.")
  private String org_opencontainers_image_authors;

  public static final String JSON_PROPERTY_ORG_OPENCONTAINERS_IMAGE_CREATED = "org.opencontainers.image.created";
  @JsonbProperty(JSON_PROPERTY_ORG_OPENCONTAINERS_IMAGE_CREATED)
  @Schema(description = "Date and time on which the image was built (string, date-time as defined by https://tools.ietf.org/html/rfc3339#section-5.6)")
  private OffsetDateTime org_opencontainers_image_created;

  public static final String JSON_PROPERTY_ORG_OPENCONTAINERS_IMAGE_DESCRIPTION = "org.opencontainers.image.description";
  @JsonbProperty(JSON_PROPERTY_ORG_OPENCONTAINERS_IMAGE_DESCRIPTION)
  @Schema(description = "Human-readable description of the software packaged in the image")
  private String org_opencontainers_image_description;

  public static final String JSON_PROPERTY_ORG_OPENCONTAINERS_IMAGE_DOCUMENTATION = "org.opencontainers.image.documentation";
  @JsonbProperty(JSON_PROPERTY_ORG_OPENCONTAINERS_IMAGE_DOCUMENTATION)
  @Schema(description = "URL to get documentation on the image.")
  private String org_opencontainers_image_documentation;

  public static final String JSON_PROPERTY_ORG_OPENCONTAINERS_IMAGE_LICENSES = "org.opencontainers.image.licenses";
  @JsonbProperty(JSON_PROPERTY_ORG_OPENCONTAINERS_IMAGE_LICENSES)
  @Schema(description = "License(s) under which contained software is distributed as an SPDX License Expression.")
  private String org_opencontainers_image_licenses;

  public static final String JSON_PROPERTY_ORG_OPENCONTAINERS_IMAGE_REF_NAME = "org.opencontainers.image.ref.name";
  @JsonbProperty(JSON_PROPERTY_ORG_OPENCONTAINERS_IMAGE_REF_NAME)
  @Schema(description = "Name of the reference for a target.")
  private String org_opencontainers_image_ref_name;

  public static final String JSON_PROPERTY_ORG_OPENCONTAINERS_IMAGE_REVISION = "org.opencontainers.image.revision";
  @JsonbProperty(JSON_PROPERTY_ORG_OPENCONTAINERS_IMAGE_REVISION)
  @Schema(description = "Source control revision identifier for the packaged software.")
  private String org_opencontainers_image_revision;

  public static final String JSON_PROPERTY_ORG_OPENCONTAINERS_IMAGE_SOURCE = "org.opencontainers.image.source";
  @JsonbProperty(JSON_PROPERTY_ORG_OPENCONTAINERS_IMAGE_SOURCE)
  @Schema(description = "URL to get source code for building the image.")
  private String org_opencontainers_image_source;

  public static final String JSON_PROPERTY_ORG_OPENCONTAINERS_IMAGE_TITLE = "org.opencontainers.image.title";
  @JsonbProperty(JSON_PROPERTY_ORG_OPENCONTAINERS_IMAGE_TITLE)
  @Schema(description = "Human-readable title of the image")
  private String org_opencontainers_image_title;

  public static final String JSON_PROPERTY_ORG_OPENCONTAINERS_IMAGE_URL = "org.opencontainers.image.url";
  @JsonbProperty(JSON_PROPERTY_ORG_OPENCONTAINERS_IMAGE_URL)
  @Schema(description = "URL to find more information on the image.")
  private String org_opencontainers_image_url;

  public static final String JSON_PROPERTY_ORG_OPENCONTAINERS_IMAGE_VENDOR = "org.opencontainers.image.vendor";
  @JsonbProperty(JSON_PROPERTY_ORG_OPENCONTAINERS_IMAGE_VENDOR)
  @Schema(description = "Name of the distributing entity, organization or individual.")
  private String org_opencontainers_image_vendor;

  public static final String JSON_PROPERTY_ORG_OPENCONTAINERS_IMAGE_VERSION = "org.opencontainers.image.version";
  @JsonbProperty(JSON_PROPERTY_ORG_OPENCONTAINERS_IMAGE_VERSION)
  @Schema(description = "Version of the packaged software. The version MAY match a label or tag in the source code repository, may also be Semantic versioning-compatible")
  private String org_opencontainers_image_version;

  public Annotations org_opencontainers_image_authors(String org_opencontainers_image_authors) {
    this.org_opencontainers_image_authors = org_opencontainers_image_authors;
    return this;
  }

  /**
   * Contact details of the people or organization responsible for the image.
   *
   * @return org_opencontainers_image_authors
   **/
  public String getOrgOpencontainersImageAuthors() {
    return org_opencontainers_image_authors;
  }

  public void setOrgOpencontainersImageAuthors(String org_opencontainers_image_authors) {
    this.org_opencontainers_image_authors = org_opencontainers_image_authors;
  }

  public Annotations org_opencontainers_image_created(OffsetDateTime org_opencontainers_image_created) {
    this.org_opencontainers_image_created = org_opencontainers_image_created;
    return this;
  }

  /**
   * Date and time on which the image was built (string, date-time as defined by https://tools.ietf.org/html/rfc3339#section-5.6)
   *
   * @return org_opencontainers_image_created
   **/
  public OffsetDateTime getOrgOpencontainersImageCreated() {
    return org_opencontainers_image_created;
  }

  public void setOrgOpencontainersImageCreated(OffsetDateTime org_opencontainers_image_created) {
    this.org_opencontainers_image_created = org_opencontainers_image_created;
  }

  public Annotations org_opencontainers_image_description(String org_opencontainers_image_description) {
    this.org_opencontainers_image_description = org_opencontainers_image_description;
    return this;
  }

  /**
   * Human-readable description of the software packaged in the image.
   *
   * @return org_opencontainers_image_description
   **/
  public String getOrgOpencontainersImageDescription() {
    return org_opencontainers_image_description;
  }

  public void setOrgOpencontainersImageDescription(String org_opencontainers_image_description) {
    this.org_opencontainers_image_description = org_opencontainers_image_description;
  }

  public Annotations org_opencontainers_image_documentation(String org_opencontainers_image_documentation) {
    this.org_opencontainers_image_documentation = org_opencontainers_image_documentation;
    return this;
  }

  /**
   * URL to get documentation on the image.
   *
   * @return org_opencontainers_image_documentation
   **/
  public String getOrgOpencontainersImageDocumentation() {
    return org_opencontainers_image_documentation;
  }

  public void setOrgOpencontainersImageDocumentation(String org_opencontainers_image_documentation) {
    this.org_opencontainers_image_documentation = org_opencontainers_image_documentation;
  }

  public Annotations org_opencontainers_image_licenses(String org_opencontainers_image_licenses) {
    this.org_opencontainers_image_licenses = org_opencontainers_image_licenses;
    return this;
  }

  /**
   * License(s) under which contained software is distributed as an SPDX License Expression.
   *
   * @return org_opencontainers_image_licenses
   **/
  public String getOrgOpencontainersImageLicenses() {
    return org_opencontainers_image_licenses;
  }

  public void setOrgOpencontainersImageLicenses(String org_opencontainers_image_licenses) {
    this.org_opencontainers_image_licenses = org_opencontainers_image_licenses;
  }

  public Annotations org_opencontainers_image_ref_name(String org_opencontainers_image_ref_name) {
    this.org_opencontainers_image_ref_name = org_opencontainers_image_ref_name;
    return this;
  }

  /**
   * Name of the reference for a target.
   *
   * @return org_opencontainers_image_ref_name
   **/
  public String getOrgOpencontainersImageRefName() {
    return org_opencontainers_image_ref_name;
  }

  public void setOrgOpencontainersImageRefName(String org_opencontainers_image_ref_name) {
    this.org_opencontainers_image_ref_name = org_opencontainers_image_ref_name;
  }

  public Annotations org_opencontainers_image_revision(String org_opencontainers_image_revision) {
    this.org_opencontainers_image_revision = org_opencontainers_image_revision;
    return this;
  }

  /**
   * Source control revision identifier for the packaged software.
   *
   * @return org_opencontainers_image_revision
   **/
  public String getOrgOpencontainersImageRevision() {
    return org_opencontainers_image_revision;
  }

  public void setOrgOpencontainersImageRevision(String org_opencontainers_image_revision) {
    this.org_opencontainers_image_revision = org_opencontainers_image_revision;
  }

  public Annotations org_opencontainers_image_source(String org_opencontainers_image_source) {
    this.org_opencontainers_image_source = org_opencontainers_image_source;
    return this;
  }

  /**
   * URL to get source code for building the image.
   *
   * @return org_opencontainers_image_source
   **/
  public String getOrgOpencontainersImageSource() {
    return org_opencontainers_image_source;
  }

  public void setOrgOpencontainersImageSource(String org_opencontainers_image_source) {
    this.org_opencontainers_image_source = org_opencontainers_image_source;
  }

  public Annotations org_opencontainers_image_title(String org_opencontainers_image_title) {
    this.org_opencontainers_image_title = org_opencontainers_image_title;
    return this;
  }

  /**
   * Human-readable title of the image.
   *
   * @return org_opencontainers_image_title
   **/
  public String getOrgOpencontainersImageTitle() {
    return org_opencontainers_image_title;
  }

  public void setOrgOpencontainersImageTitle(String org_opencontainers_image_title) {
    this.org_opencontainers_image_title = org_opencontainers_image_title;
  }

  public Annotations org_opencontainers_image_url(String org_opencontainers_image_url) {
    this.org_opencontainers_image_url = org_opencontainers_image_url;
    return this;
  }

  /**
   * URL to find more information on the image.
   *
   * @return org_opencontainers_image_url
   **/
  public String getOrgOpencontainersImageUrl() {
    return org_opencontainers_image_url;
  }

  public void setOrgOpencontainersImageUrl(String org_opencontainers_image_url) {
    this.org_opencontainers_image_url = org_opencontainers_image_url;
  }

  public Annotations org_opencontainers_image_vendor(String org_opencontainers_image_vendor) {
    this.org_opencontainers_image_vendor = org_opencontainers_image_vendor;
    return this;
  }

  /**
   * Name of the distributing entity, organization or individual.
   *
   * @return org_opencontainers_image_vendor
   **/
  public String getOrgOpencontainersImageVendor() {
    return org_opencontainers_image_vendor;
  }

  public void setOrgOpencontainersImageVendor(String org_opencontainers_image_vendor) {
    this.org_opencontainers_image_vendor = org_opencontainers_image_vendor;
  }

  public Annotations org_opencontainers_image_version(String org_opencontainers_image_version) {
    this.org_opencontainers_image_version = org_opencontainers_image_version;
    return this;
  }

  /**
   * Version of the packaged software. The version MAY match a label or tag in the source code repository, may also be Semantic versioning-compatible
   *
   * @return org_opencontainers_image_version
   **/
  public String getOrgOpencontainersImageVersion() {
    return org_opencontainers_image_version;
  }

  public void setOrgOpencontainersImageVersion(String org_opencontainers_image_version) {
    this.org_opencontainers_image_version = org_opencontainers_image_version;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Annotations)) {
      return false;
    }
    Annotations other = (Annotations) o;
    return Objects.equals(this.org_opencontainers_image_authors, other.org_opencontainers_image_authors) &&
        Objects.equals(this.org_opencontainers_image_created, other.org_opencontainers_image_created) &&
        Objects.equals(this.org_opencontainers_image_description, other.org_opencontainers_image_description) &&
        Objects.equals(this.org_opencontainers_image_documentation, other.org_opencontainers_image_documentation) &&
        Objects.equals(this.org_opencontainers_image_licenses, other.org_opencontainers_image_licenses) &&
        Objects.equals(this.org_opencontainers_image_ref_name, other.org_opencontainers_image_ref_name) &&
        Objects.equals(this.org_opencontainers_image_revision, other.org_opencontainers_image_revision) &&
        Objects.equals(this.org_opencontainers_image_source, other.org_opencontainers_image_source) &&
        Objects.equals(this.org_opencontainers_image_title, other.org_opencontainers_image_title) &&
        Objects.equals(this.org_opencontainers_image_url, other.org_opencontainers_image_url) &&
        Objects.equals(this.org_opencontainers_image_vendor, other.org_opencontainers_image_vendor) &&
        Objects.equals(this.org_opencontainers_image_version, other.org_opencontainers_image_version);
  }

  @Override
  public int hashCode() {
    return Objects.hash(org_opencontainers_image_authors, org_opencontainers_image_created, org_opencontainers_image_description, org_opencontainers_image_documentation, org_opencontainers_image_licenses, org_opencontainers_image_ref_name, org_opencontainers_image_revision, org_opencontainers_image_source, org_opencontainers_image_title, org_opencontainers_image_url, org_opencontainers_image_vendor, org_opencontainers_image_version);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Annotations {");
    sb.append("\n    org_opencontainers_image_authors: ").append(toIndentedString(org_opencontainers_image_authors));
    sb.append("\n    org_opencontainers_image_created: ").append(toIndentedString(org_opencontainers_image_created));
    sb.append("\n    org_opencontainers_image_description: ").append(toIndentedString(org_opencontainers_image_description));
    sb.append("\n    org_opencontainers_image_documentation: ").append(toIndentedString(org_opencontainers_image_documentation));
    sb.append("\n    org_opencontainers_image_licenses: ").append(toIndentedString(org_opencontainers_image_licenses));
    sb.append("\n    org_opencontainers_image_ref_name: ").append(toIndentedString(org_opencontainers_image_ref_name));
    sb.append("\n    org_opencontainers_image_revision: ").append(toIndentedString(org_opencontainers_image_revision));
    sb.append("\n    org_opencontainers_image_source: ").append(toIndentedString(org_opencontainers_image_source));
    sb.append("\n    org_opencontainers_image_title: ").append(toIndentedString(org_opencontainers_image_title));
    sb.append("\n    org_opencontainers_image_url: ").append(toIndentedString(org_opencontainers_image_url));
    sb.append("\n    org_opencontainers_image_vendor: ").append(toIndentedString(org_opencontainers_image_vendor));
    sb.append("\n    org_opencontainers_image_version: ").append(toIndentedString(org_opencontainers_image_version));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
