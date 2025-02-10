package dk.mada.jaxrs.model;

import dk.mada.jaxrs.model.api.ContentSelector;
import dk.mada.jaxrs.model.api.Operations;
import dk.mada.jaxrs.model.naming.Naming;
import dk.mada.jaxrs.model.types.TypeInterface;
import java.util.List;
import java.util.Set;

/**
 * The transformed model of an OpenApi specification.
 *
 * @param naming          the naming rules
 * @param info            the API information
 * @param operations      the operations in the API
 * @param dtos            the DTOs in the API
 * @param interfaces      the interfaces needed by the API
 * @param securitySchemes the security schemes in the API
 * @param contentSelector selector to pick appropriate content
 */
public record Model(
        Naming naming,
        Info info,
        Operations operations,
        Dtos dtos,
        Set<TypeInterface> interfaces,
        List<SecurityScheme> securitySchemes,
        ContentSelector contentSelector) {}
