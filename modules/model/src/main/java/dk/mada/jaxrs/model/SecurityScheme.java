package dk.mada.jaxrs.model;

/**
 * Security schemes.
 *
 * Just collects presence for now.
 *
 * @param name the name of the security scheme
 *
 * @see <a href="https://swagger.io/specification/#securityRequirementObject">securityRequirementObject</a>
 */
public record SecurityScheme(String name) {
}
