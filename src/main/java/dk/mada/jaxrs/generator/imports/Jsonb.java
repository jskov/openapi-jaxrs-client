package dk.mada.jaxrs.generator.imports;

import java.util.Optional;

import dk.mada.jaxrs.generator.imports.Imports.ImportRenderPrefs;

/**
 * Json binding import paths.
 */
public enum Jsonb implements TypedImport {
    /** Json. */
    JSON("javax.json.Json"),
    /** JsonString. */
    JSON_STRING("javax.json.JsonString"),
    /** JsonbAdapter. */
    JSONB_ADAPTER("javax.json.bind.adapter.JsonbAdapter"),
    /** JsonbProperty. */
    JSONB_PROPERTY("javax.json.bind.annotation.JsonbProperty"),
    /** JsonbPropertyOrder. */
    JSONB_PROPERTY_ORDER("javax.json.bind.annotation.JsonbPropertyOrder"),
    /** JsonbTypeAdapter. */
    JSONB_TYPE_ADAPTER("javax.json.bind.annotation.JsonbTypeAdapter");

    /** The import path for the type. */
    private final String importPath;

    Jsonb(String importPath) {
        this.importPath = importPath;
    }

    @Override
    public Optional<String> path(ImportRenderPrefs irp) {
        if (!irp.isJsonb()) {
            return Optional.empty();
        }
        return Optional.of(irp.fixJavaxJakartaImportPath(importPath));
    }
}
