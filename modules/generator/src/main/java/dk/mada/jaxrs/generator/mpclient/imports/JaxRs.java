package dk.mada.jaxrs.generator.mpclient.imports;

import dk.mada.jaxrs.generator.mpclient.imports.Imports.ImportRenderPrefs;
import java.util.Optional;

/**
 * JAX-RS import paths.
 */
public enum JaxRs implements TypedImport {
    /** All the JaxRs path types. */
    RS_STAR("javax.ws.rs.*"),
    /** FormParam. */
    FORM_PARAM("javax.ws.rs.FormParam"),
    /** MediaType. */
    MEDIA_TYPE("javax.ws.rs.core.MediaType");

    /** The import path for the type. */
    private final String importPath;

    JaxRs(String importPath) {
        this.importPath = importPath;
    }

    @Override
    public Optional<String> path(ImportRenderPrefs irp) {
        return Optional.of(irp.fixJavaxJakartaImportPath(importPath));
    }
}
