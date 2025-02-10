package dk.mada.jaxrs.generator.mpclient.imports;

import dk.mada.jaxrs.generator.mpclient.imports.Imports.ImportRenderPrefs;
import java.util.Optional;

/**
 * Quarkus import paths.
 */
public enum Quarkus implements TypedImport {
    /** RegisterForReflection. */
    REGISTER_FOR_REFLECTION("io.quarkus.runtime.annotations.RegisterForReflection");

    /** The import path for the type. */
    private final String importPath;

    Quarkus(String importPath) {
        this.importPath = importPath;
    }

    @Override
    public Optional<String> path(ImportRenderPrefs irp) {
        return Optional.of(importPath);
    }
}
