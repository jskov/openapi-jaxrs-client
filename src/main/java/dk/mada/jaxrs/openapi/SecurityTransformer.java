package dk.mada.jaxrs.openapi;

import java.util.List;

import dk.mada.jaxrs.model.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;

/**
 * Transforms OpenApi security to local model objects.
 */
public class SecurityTransformer {

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
