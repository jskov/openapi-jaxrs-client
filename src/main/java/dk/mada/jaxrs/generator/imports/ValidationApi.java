package dk.mada.jaxrs.generator.imports;

import dk.mada.jaxrs.generator.imports.Imports.ImportRenderPrefs;

/**
 * Validation import paths.
 */
public enum ValidationApi implements TypedImport {
    /** Max. */
    MAX("javax.validation.constraints.Max"),
    /** Min. */
    MIN("javax.validation.constraints.Min"),
    /** NotNull. */
    NOT_NULL("javax.validation.constraints.NotNull"),
    /** Pattern. */
    PATTERN("javax.validation.constraints.Pattern"),
    /** Size. */
    SIZE("javax.validation.constraints.Size"),
    /** Valid. */
    VALID("javax.validation.Valid");

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
