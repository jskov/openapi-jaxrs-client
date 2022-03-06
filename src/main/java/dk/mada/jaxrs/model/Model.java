package dk.mada.jaxrs.model;

import java.util.List;

import dk.mada.jaxrs.model.api.Operations;

/**
 * The transformed model of an OpenApi specification.
 *
 * @param info the API information
 * @param operations the operations in the API
 * @param dtos the DTOss in the API
 * @param securitySchemes the security schemes in the API
 */
public record Model(Info info, Operations operations, Dtos dtos, List<SecurityScheme> securitySchemes) {
}
