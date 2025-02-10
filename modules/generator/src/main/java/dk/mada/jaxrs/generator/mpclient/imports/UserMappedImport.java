package dk.mada.jaxrs.generator.mpclient.imports;

import dk.mada.jaxrs.generator.mpclient.imports.Imports.ImportRenderPrefs;
import java.util.Optional;

/**
 * A user-mapped import - replacing a given type with a imported class.
 *
 * @param path the import path
 */
public record UserMappedImport(String path) implements TypedImport {
    @Override
    public Optional<String> path(ImportRenderPrefs irp) {
        return Optional.of(path());
    }
}
