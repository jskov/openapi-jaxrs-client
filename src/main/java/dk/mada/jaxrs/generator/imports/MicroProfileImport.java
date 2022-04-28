package dk.mada.jaxrs.generator.imports;

/**
 * MicroProfile import paths.
 */
public enum MicroProfileImport {
    /** APIResponseSchema. */
    API_RESPONSE_SCHEMA("org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema"),
    /** APIResponse. */
    API_RESPONSE("org.eclipse.microprofile.openapi.annotations.responses.APIResponse"),
    /** APIResponses. */
    API_RESPONSES("org.eclipse.microprofile.openapi.annotations.responses.APIResponses"),
    /** Content. */
    CONTENT("org.eclipse.microprofile.openapi.annotations.media.Content"),
    /** Schema. */
    SCHEMA("org.eclipse.microprofile.openapi.annotations.media.Schema");

    /** The import path for the type. */
    private final String importPath;

    MicroProfileImport(String importPath) {
        this.importPath = importPath;
    }

    /** {@return the import path for the type} */
    public String importPath() {
        return importPath;
    }
}
