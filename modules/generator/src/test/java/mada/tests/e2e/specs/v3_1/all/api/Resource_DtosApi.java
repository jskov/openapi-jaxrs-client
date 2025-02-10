/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.specs.v3_1.all.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.specs.v3_1.all.dto.ArraysDto;
import mada.tests.e2e.specs.v3_1.all.dto.BeanNaming;
import mada.tests.e2e.specs.v3_1.all.dto.Collisions;
import mada.tests.e2e.specs.v3_1.all.dto.CyclicA;
import mada.tests.e2e.specs.v3_1.all.dto.DtoA;
import mada.tests.e2e.specs.v3_1.all.dto.EnumsDto;
import mada.tests.e2e.specs.v3_1.all.dto.MapsDto;
import mada.tests.e2e.specs.v3_1.all.dto.Primitives;
import mada.tests.e2e.specs.v3_1.all.dto.References;
import mada.tests.e2e.specs.v3_1.all.dto.SerializerInfoDto;
import mada.tests.e2e.specs.v3_1.all.dto.SetsDto;
import mada.tests.e2e.specs.v3_1.all.dto.SpecialTypes;
import mada.tests.e2e.specs.v3_1.all.dto.ValidationDto;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/dtos")
public interface Resource_DtosApi {

  /**
   * Get Bean Naming.
   *
   * @return BeanNaming
   */
  @GET
  @Path("/bean-naming")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(BeanNaming.class)
  @Operation(summary = "Get Bean Naming")
  BeanNaming dtosBeanNamingGet();

  /**
   * Get Arrays.
   *
   * @return ArraysDto
   */
  @GET
  @Path("/collections/array")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(ArraysDto.class)
  @Operation(summary = "Get Arrays")
  ArraysDto dtosCollectionsArrayGet();

  /**
   * Get Maps.
   *
   * @return MapsDto
   */
  @GET
  @Path("/collections/map")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(MapsDto.class)
  @Operation(summary = "Get Maps")
  MapsDto dtosCollectionsMapGet();

  /**
   * Get Sets.
   *
   * @return SetsDto
   */
  @GET
  @Path("/collections/set")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(SetsDto.class)
  @Operation(summary = "Get Sets")
  SetsDto dtosCollectionsSetGet();

  /**
   * Get Collisions.
   *
   * @return Collisions
   */
  @GET
  @Path("/collision")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(Collisions.class)
  @Operation(summary = "Get Collisions")
  Collisions dtosCollisionGet();

  /**
   * Get Cyclic.
   *
   * @return CyclicA
   */
  @GET
  @Path("/cyclic")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(CyclicA.class)
  @Operation(summary = "Get Cyclic")
  CyclicA dtosCyclicGet();

  /**
   * Get Enums.
   *
   * @return EnumsDto
   */
  @GET
  @Path("/enums")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(EnumsDto.class)
  @Operation(summary = "Get Enums")
  EnumsDto dtosEnumsGet();

  /**
   * Get Primitives Dto.
   *
   * @return Primitives
   */
  @GET
  @Path("/primitives")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(Primitives.class)
  @Operation(summary = "Get Primitives Dto")
  Primitives dtosPrimitivesGet();

  /**
   * Get References Dto.
   *
   * @return References
   */
  @GET
  @Path("/references")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(References.class)
  @Operation(summary = "Get References Dto")
  References dtosReferencesGet();

  /**
   * Get Schema.
   *
   * @return DtoA
   */
  @GET
  @Path("/schema")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(DtoA.class)
  @Operation(summary = "Get Schema")
  DtoA dtosSchemaGet();

  /**
   * Get Serializer.
   *
   * @return SerializerInfoDto
   */
  @GET
  @Path("/serializer")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(SerializerInfoDto.class)
  @Operation(summary = "Get Serializer")
  SerializerInfoDto dtosSerializerGet();

  /**
   * Get Special Types.
   *
   * @return SpecialTypes
   */
  @GET
  @Path("/special-types")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(SpecialTypes.class)
  @Operation(summary = "Get Special Types")
  SpecialTypes dtosSpecialTypesGet();

  /**
   * Get Validation.
   *
   * @return ValidationDto
   */
  @GET
  @Path("/validation")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(ValidationDto.class)
  @Operation(summary = "Get Validation")
  ValidationDto dtosValidationGet();
}
