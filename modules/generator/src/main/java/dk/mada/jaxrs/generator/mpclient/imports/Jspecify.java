package dk.mada.jaxrs.generator.mpclient.imports;

import java.util.Optional;

import dk.mada.jaxrs.generator.mpclient.imports.Imports.ImportRenderPrefs;

/**
 * JSpecify import paths.
 */
public enum Jspecify implements TypedImport {
    /** NonNullable. */
    NON_NULLABLE("org.jspecify.annotations.NonNullable"),
    /** Nullable. */
    NULLABLE("org.jspecify.annotations.Nullable");

    /** The import path for the type. */
    private final String importPath;

    Jspecify(String importPath) {
        this.importPath = importPath;
    }

    @Override
    public Optional<String> path(ImportRenderPrefs irp) {
        return Optional.of(importPath);
    }
}
