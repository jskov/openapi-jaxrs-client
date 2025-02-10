package dk.mada.jaxrs.generator.mpclient.imports;

import dk.mada.jaxrs.generator.mpclient.imports.Imports.ImportRenderPrefs;
import java.util.Optional;

/**
 * MicroProfile import paths.
 */
public enum MicroProfile implements TypedImport {
    /** APIResponseSchema. */
    API_RESPONSE_SCHEMA("org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema"),
    /** APIResponse. */
    API_RESPONSE("org.eclipse.microprofile.openapi.annotations.responses.APIResponse"),
    /** APIResponses. */
    API_RESPONSES("org.eclipse.microprofile.openapi.annotations.responses.APIResponses"),
    /** Content. */
    CONTENT("org.eclipse.microprofile.openapi.annotations.media.Content"),
    /** Operation. */
    OPERATION("org.eclipse.microprofile.openapi.annotations.Operation"),
    /** RegisterProvider. */
    REGISTER_PROVIDER("org.eclipse.microprofile.rest.client.annotation.RegisterProvider"),
    /** RegisterRestClient. */
    REGISTER_REST_CLIENT("org.eclipse.microprofile.rest.client.inject.RegisterRestClient"),
    /** Schema. */
    SCHEMA("org.eclipse.microprofile.openapi.annotations.media.Schema"),
    /** SchemaType. */
    SCHEMA_TYPE("org.eclipse.microprofile.openapi.annotations.enums.SchemaType");

    /** The import path for the type. */
    private final String importPath;

    MicroProfile(String importPath) {
        this.importPath = importPath;
    }

    @Override
    public Optional<String> path(ImportRenderPrefs irp) {
        return Optional.of(importPath);
    }
}
