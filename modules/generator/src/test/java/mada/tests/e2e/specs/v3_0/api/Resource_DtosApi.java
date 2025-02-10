/*
 * openapi API Title
 * openapi API description
 *
 * The version of the OpenAPI document: openapi API Version
 * Contact: email@example.com
 */

package mada.tests.e2e.specs.v3_0.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import mada.tests.e2e.specs.v3_0.dto.ArraysDto;
import mada.tests.e2e.specs.v3_0.dto.BeanNaming;
import mada.tests.e2e.specs.v3_0.dto.Collisions;
import mada.tests.e2e.specs.v3_0.dto.CyclicA;
import mada.tests.e2e.specs.v3_0.dto.DtoA;
import mada.tests.e2e.specs.v3_0.dto.EnumsDto;
import mada.tests.e2e.specs.v3_0.dto.MapsDto;
import mada.tests.e2e.specs.v3_0.dto.Primitives;
import mada.tests.e2e.specs.v3_0.dto.References;
import mada.tests.e2e.specs.v3_0.dto.SerializerInfoDto;
import mada.tests.e2e.specs.v3_0.dto.SetsDto;
import mada.tests.e2e.specs.v3_0.dto.SpecialTypes;
import mada.tests.e2e.specs.v3_0.dto.ValidationDto;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;

@javax.annotation.processing.Generated(value = "dk.mada.jaxrs.Generator")
@Path("/dtos")
public interface Resource_DtosApi {

  /**
   * dtosBeanNamingGet.
   *
   * @return BeanNaming
   */
  @GET
  @Path("/bean-naming")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(BeanNaming.class)
  BeanNaming dtosBeanNamingGet();

  /**
   * dtosCollectionsArrayGet.
   *
   * @return ArraysDto
   */
  @GET
  @Path("/collections/array")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(ArraysDto.class)
  ArraysDto dtosCollectionsArrayGet();

  /**
   * dtosCollectionsMapGet.
   *
   * @return MapsDto
   */
  @GET
  @Path("/collections/map")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(MapsDto.class)
  MapsDto dtosCollectionsMapGet();

  /**
   * dtosCollectionsSetGet.
   *
   * @return SetsDto
   */
  @GET
  @Path("/collections/set")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(SetsDto.class)
  SetsDto dtosCollectionsSetGet();

  /**
   * dtosCollisionGet.
   *
   * @return Collisions
   */
  @GET
  @Path("/collision")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(Collisions.class)
  Collisions dtosCollisionGet();

  /**
   * dtosCyclicGet.
   *
   * @return CyclicA
   */
  @GET
  @Path("/cyclic")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(CyclicA.class)
  CyclicA dtosCyclicGet();

  /**
   * dtosEnumsGet.
   *
   * @return EnumsDto
   */
  @GET
  @Path("/enums")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(EnumsDto.class)
  EnumsDto dtosEnumsGet();

  /**
   * dtosPrimitivesGet.
   *
   * @return Primitives
   */
  @GET
  @Path("/primitives")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(Primitives.class)
  Primitives dtosPrimitivesGet();

  /**
   * dtosReferencesGet.
   *
   * @return References
   */
  @GET
  @Path("/references")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(References.class)
  References dtosReferencesGet();

  /**
   * dtosSchemaGet.
   *
   * @return DtoA
   */
  @GET
  @Path("/schema")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(DtoA.class)
  DtoA dtosSchemaGet();

  /**
   * dtosSerializerGet.
   *
   * @return SerializerInfoDto
   */
  @GET
  @Path("/serializer")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(SerializerInfoDto.class)
  SerializerInfoDto dtosSerializerGet();

  /**
   * dtosSpecialTypesGet.
   *
   * @return SpecialTypes
   */
  @GET
  @Path("/special-types")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(SpecialTypes.class)
  SpecialTypes dtosSpecialTypesGet();

  /**
   * dtosValidationGet.
   *
   * @return ValidationDto
   */
  @GET
  @Path("/validation")
  @Produces(MediaType.APPLICATION_JSON)
  @APIResponseSchema(ValidationDto.class)
  ValidationDto dtosValidationGet();
}
