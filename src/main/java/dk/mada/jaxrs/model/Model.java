package dk.mada.jaxrs.model;

import java.util.List;
import java.util.Set;

import dk.mada.jaxrs.model.api.ContentSelector;
import dk.mada.jaxrs.model.api.Operations;
import dk.mada.jaxrs.model.types.TypeInterface;

/**
 * The transformed model of an OpenApi specification.
 *
 * @param info            the API information
 * @param operations      the operations in the API
 * @param dtos            the DTOs in the API
 * @param interfaces      the interfaces needed by the API
 * @param securitySchemes the security schemes in the API
 * @param contentSelector selector to pick appropriate content
 */
public record Model(Info info, Operations operations, Dtos dtos, Set<TypeInterface> interfaces, List<SecurityScheme> securitySchemes,
        ContentSelector contentSelector) {
}
