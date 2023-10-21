package dk.mada.jaxrs.generator.mpclient.imports;

import java.util.Optional;

import dk.mada.jaxrs.generator.mpclient.imports.Imports.ImportRenderPrefs;

/**
 * Types imports for easier handling in the code.
 *
 * Beats strings.
 */
public interface TypedImport {
    /**
     * {@return the import path suitable for the import type, or null if not applicable}
     *
     * @param irp the import rendering preferences
     */
    Optional<String> path(ImportRenderPrefs irp);
}
