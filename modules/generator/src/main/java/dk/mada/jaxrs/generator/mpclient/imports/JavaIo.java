package dk.mada.jaxrs.generator.mpclient.imports;

import dk.mada.jaxrs.generator.mpclient.imports.Imports.ImportRenderPrefs;
import java.util.Optional;

/**
 * Java IO import paths.
 */
public enum JavaIo implements TypedImport {
    /** IOException. */
    IO_EXCEPTION("java.io.IOException"),
    /** Serializable. */
    IO_SERIALIZABLE("java.io.Serializable");

    /** The import path for the type. */
    private final String importPath;

    JavaIo(String importPath) {
        this.importPath = importPath;
    }

    @Override
    public Optional<String> path(ImportRenderPrefs irp) {
        return Optional.of(importPath);
    }
}
