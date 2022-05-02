package dk.mada.jaxrs.generator.imports;

import dk.mada.jaxrs.generator.imports.Imports.ImportRenderPrefs;

/**
 * Validation import paths.
 */
public enum ValidationApi implements TypedImport {
    /** NotNull. */
    NOT_NULL("javax.validation.constraints.NotNull");

    /** The import path for the type. */
    private final String importPath;

    ValidationApi(String importPath) {
        this.importPath = importPath;
    }

    @Override
    public String path(ImportRenderPrefs irp) {
        return importPath;
    }
}
