package dk.mada.jaxrs.generator.imports;

import dk.mada.jaxrs.generator.imports.Imports.ImportRenderPrefs;

/**
 * A user-mapped import - replacing a given type
 * with a imported class.
 *
 * @param path the import path
 */
public record UserMappedImport(String path) implements TypedImport {
    @Override
    public String path(ImportRenderPrefs irp) {
        return path();
    }
}
