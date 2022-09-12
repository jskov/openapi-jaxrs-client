package dk.mada.jaxrs.generator.imports;

import dk.mada.jaxrs.generator.imports.Imports.ImportRenderPrefs;

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
    public String path(ImportRenderPrefs irp) {
        return importPath;
    }
}
