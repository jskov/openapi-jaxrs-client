package dk.mada.jaxrs.generator.mpclient.imports;

import dk.mada.jaxrs.generator.mpclient.imports.Imports.ImportRenderPrefs;
import java.util.Optional;

/**
 * RestEasy import paths.
 */
public enum RestEasy implements TypedImport {
    /** MultipartForm. */
    MULTIPART_FORM("org.jboss.resteasy.annotations.providers.multipart.MultipartForm"),
    /** Part type. */
    MULTIPART_PARTTYPE("org.jboss.resteasy.annotations.providers.multipart.PartType");

    /** The import path for the type. */
    private final String importPath;

    RestEasy(String importPath) {
        this.importPath = importPath;
    }

    @Override
    public Optional<String> path(ImportRenderPrefs irp) {
        return Optional.of(importPath);
    }
}
