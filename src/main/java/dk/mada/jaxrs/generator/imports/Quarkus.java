package dk.mada.jaxrs.generator.imports;

import dk.mada.jaxrs.generator.imports.Imports.ImportRenderPrefs;

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
    public String path(ImportRenderPrefs irp) {
        return importPath;
    }
}
