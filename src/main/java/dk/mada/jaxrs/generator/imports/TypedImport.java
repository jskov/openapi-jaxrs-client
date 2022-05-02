package dk.mada.jaxrs.generator.imports;

import dk.mada.jaxrs.generator.imports.Imports.ImportRenderPrefs;

/**
 * Types imports for easier handling in the code.
 *
 * Beats strings.
 */
public interface TypedImport {
    /**
     * {@return the import path suitable for the import type}
     *
     * @param irp the import rendering preferences
     */
    String path(ImportRenderPrefs irp);
}
