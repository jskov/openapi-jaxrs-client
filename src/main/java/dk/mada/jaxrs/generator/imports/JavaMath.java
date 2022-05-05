package dk.mada.jaxrs.generator.imports;

import dk.mada.jaxrs.generator.imports.Imports.ImportRenderPrefs;

/**
 * Java math import paths.
 */
public enum JavaMath implements TypedImport {
    /** BigDecimal. */
    BIG_DECIMAL("java.math.BigDecimal");

    /** The import path for the type. */
    private final String importPath;

    JavaMath(String importPath) {
        this.importPath = importPath;
    }

    @Override
    public String path(ImportRenderPrefs irp) {
        return importPath;
    }
}
