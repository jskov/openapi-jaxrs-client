/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: openapi API contact email
 */

package mada.tests.e2e.api.params.form.simple.api;

import java.io.InputStream;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;
import org.jboss.resteasy.annotations.providers.multipart.PartType;
import mada.tests.e2e.api.params.form.simple.dto.TemplateDTO;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/api/methods/create")
public interface TemplatesApi {

  /**
   * apiMethodsCreatePost.
   *
   * @param multipartBody  Synthetic multipart body
   */
  @POST
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  @APIResponses({
    @APIResponse(responseCode = "201", description = "Created"),
    @APIResponse(responseCode = "401", description = "Not Authorized"),
    @APIResponse(responseCode = "403", description = "Not Allowed")
  })
  void apiMethodsCreatePost(@MultipartForm ApiMethodsCreatePostMultiPartBody multipartBody);

  /** Synthetic multipart body for apiMethodsCreatePost. */
  public static class ApiMethodsCreatePostMultiPartBody {
    @FormParam("metadata")
    @PartType(MediaType.APPLICATION_JSON)
    @Valid
    public final TemplateDTO metada;

    @FormParam("template-jar")
    @PartType(MediaType.APPLICATION_OCTET_STREAM)
    @NotNull
    public final InputStream templateJar;
  
    @NotNull
    @FormParam("jar-size")
    @PartType(MediaType.APPLICATION_JSON)
    public final long jarSize;

    private ApiMethodsCreatePostMultiPartBody(TemplateDTO metadata, InputStream templateJar, long jarSize) {
      this.metada = metadata;
      this.templateJar = Objects.requireNonNull(templateJar, "Property templateJar is required, cannot be null");;
      this.jarSize = jarSize;
    }

    @Override
    public String toString() {
      return "ApiMethodsCreatePostMultiPartBody [metadata=" + metada + ", template-jar=" + templateJar + ", jar-size=" + jarSize + "]";
    }

    public static Builder builder() {
      return new Builder();
    }

    public static class Builder {
      private TemplateDTO metadata;
      private InputStream templateJar;
      private long jarSize;

      public Builder metadata(TemplateDTO metadata) {
          this.metadata = metadata;
          return this;
      }

      public Builder templateJar(InputStream templateJar) {
          this.templateJar = templateJar;
          return this;
      }

      public Builder jarSize(long jarSize) {
          this.jarSize = jarSize;
          return this;
      }

      public ApiMethodsCreatePostMultiPartBody build() {
        return new ApiMethodsCreatePostMultiPartBody(metadata, templateJar, jarSize);
      }
    }
  }
}
