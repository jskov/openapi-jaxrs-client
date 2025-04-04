/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.api.params.form.simple.dto;

import java.io.InputStream;
import java.util.Objects;
import javax.json.bind.annotation.JsonbProperty;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.jboss.resteasy.annotations.providers.multipart.PartType;

/**
 * MultipartApiMethodsCreatePost
 */
@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
public class MultipartApiMethodsCreatePost {
  public static final String JSON_PROPERTY_JAR_SIZE = "jar-size";
  @JsonbProperty(JSON_PROPERTY_JAR_SIZE)
  @Schema(required = true)
  @FormParam(JSON_PROPERTY_JAR_SIZE)
  @PartType(MediaType.APPLICATION_JSON)
  private Long jarSize;

  public static final String JSON_PROPERTY_METADATA = "metadata";
  @JsonbProperty(JSON_PROPERTY_METADATA)
  @FormParam(JSON_PROPERTY_METADATA)
  @PartType(MediaType.APPLICATION_JSON)
  private TemplateDTO metadata;

  public static final String JSON_PROPERTY_TEMPLATE_JAR = "template-jar";
  @JsonbProperty(JSON_PROPERTY_TEMPLATE_JAR)
  @Schema(required = true)
  @FormParam(JSON_PROPERTY_TEMPLATE_JAR)
  @PartType(MediaType.APPLICATION_OCTET_STREAM)
  private InputStream templateJar;

  public MultipartApiMethodsCreatePost jarSize(Long jarSize) {
    this.jarSize = Objects.requireNonNull(jarSize, "Property jarSize is required, cannot be null");
    return this;
  }

  /**
   * Get jarSize
   * @return jarSize
   **/
  @NotNull
  public Long getJarSize() {
    return jarSize;
  }

  public void setJarSize(Long jarSize) {
    this.jarSize = Objects.requireNonNull(jarSize, "Property jarSize is required, cannot be null");
  }

  public MultipartApiMethodsCreatePost metadata(TemplateDTO metadata) {
    this.metadata = metadata;
    return this;
  }

  /**
   * Get metadata
   * @return metadata
   **/
  @Valid
  public TemplateDTO getMetadata() {
    return metadata;
  }

  public void setMetadata(TemplateDTO metadata) {
    this.metadata = metadata;
  }

  public MultipartApiMethodsCreatePost templateJar(InputStream templateJar) {
    this.templateJar = Objects.requireNonNull(templateJar, "Property templateJar is required, cannot be null");
    return this;
  }

  /**
   * Get templateJar
   * @return templateJar
   **/
  @NotNull
  public InputStream getTemplateJar() {
    return templateJar;
  }

  public void setTemplateJar(InputStream templateJar) {
    this.templateJar = Objects.requireNonNull(templateJar, "Property templateJar is required, cannot be null");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof MultipartApiMethodsCreatePost)) {
      return false;
    }
    MultipartApiMethodsCreatePost other = (MultipartApiMethodsCreatePost) o;
    return Objects.equals(this.jarSize, other.jarSize) &&
        Objects.equals(this.metadata, other.metadata) &&
        Objects.equals(this.templateJar, other.templateJar);
  }

  @Override
  public int hashCode() {
    return Objects.hash(jarSize, metadata, templateJar);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class MultipartApiMethodsCreatePost {");
    sb.append("\n    jarSize: ").append(toIndentedString(jarSize));
    sb.append("\n    metadata: ").append(toIndentedString(metadata));
    sb.append("\n    templateJar: ").append(toIndentedString(templateJar));
    sb.append("\n}");
    return sb.toString();
  }

  private String toIndentedString(Object o) {
    return Objects.toString(o).replace("\n", "\n    ");
  }
}
