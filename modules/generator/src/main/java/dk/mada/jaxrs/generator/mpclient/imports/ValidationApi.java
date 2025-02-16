package dk.mada.jaxrs.generator.mpclient.imports;

import dk.mada.jaxrs.generator.mpclient.imports.Imports.ImportRenderPrefs;
import java.util.Optional;

/**
 * Validation import paths.
 */
public enum ValidationApi implements TypedImport {
    /** DecimalMax. */
    DECIMAL_MAX("javax.validation.constraints.DecimalMax"),
    /** Min. */
    DECIMAL_MIN("javax.validation.constraints.DecimalMin"),
    /** Max. */
    MAX("javax.validation.constraints.Max"),
    /** Min. */
    MIN("javax.validation.constraints.Min"),
    /** NotEmpty. */
    NOT_EMPTY("javax.validation.constraints.NotEmpty"),
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
    public Optional<String> path(ImportRenderPrefs irp) {
        return Optional.of(irp.fixJavaxJakartaImportPath(importPath));
    }
}
