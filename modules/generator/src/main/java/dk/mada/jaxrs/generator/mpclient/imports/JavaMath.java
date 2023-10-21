package dk.mada.jaxrs.generator.mpclient.imports;

import java.util.Optional;

import dk.mada.jaxrs.generator.mpclient.imports.Imports.ImportRenderPrefs;

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
    public Optional<String> path(ImportRenderPrefs irp) {
        return Optional.of(importPath);
    }
}
