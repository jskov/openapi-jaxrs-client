package dk.mada.jaxrs.generator.mpclient.imports;

import dk.mada.jaxrs.generator.mpclient.imports.Imports.ImportRenderPrefs;
import java.util.Optional;

/**
 * JSpecify import paths.
 */
public enum Jspecify implements TypedImport {
    /** NullUnmarked. */
    NULL_UNMARKED("org.jspecify.annotations.NullUnmarked"),
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
