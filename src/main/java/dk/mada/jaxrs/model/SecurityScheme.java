package dk.mada.jaxrs.model;

/**
 * Security schemes.
 * 
 * Just collects presence for now.
 * 
 * @see https://swagger.io/specification/#securityRequirementObject
 */
public record SecurityScheme(String name) {}
