package dk.mada.jaxrs.model;

import java.util.List;

import dk.mada.jaxrs.model.api.Operations;
import dk.mada.jaxrs.model.types.Types;

/**
 * The transformed model of an OpenApi specification.
 *
 * @param info the API information
 * @param operations the operations in the API
 * @param types the types in the API
 * @param securitySchemes the security schemes in the API
 */
public record Model(Info info, Operations operations, Types types, List<SecurityScheme> securitySchemes) {
}
