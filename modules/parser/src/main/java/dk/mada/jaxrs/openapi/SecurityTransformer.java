package dk.mada.jaxrs.openapi;

import dk.mada.jaxrs.model.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import java.util.List;

/**
 * Transforms OpenApi security to local model objects.
 */
public final class SecurityTransformer {
    /** Creates new instance. */
    public SecurityTransformer() {
        super();
    }

    /**
     * Transforms OpenApi security to local model objects.
     *
     * @param specification the OpenApi specification to transform
     * @return a local model defining the security
     */
    public List<SecurityScheme> transform(OpenAPI specification) {
        List<SecurityRequirement> security = specification.getSecurity();

        if (security == null) {
            return List.of();
        }

        return security.stream()
                .flatMap(sr -> sr.keySet().stream())
                .map(SecurityScheme::new)
                .toList();
    }
}
