package dk.mada.jaxrs.generator.imports;

import dk.mada.jaxrs.generator.imports.Imports.ImportRenderPrefs;

/**
 * JAX-RS import paths.
 */
public enum JaxRs implements TypedImport {
    /** All the JaxRs path types. */
    RS_STAR("javax.ws.rs.*"),
    /** MediaType. */
    MEDIA_TYPE("javax.ws.rs.core.MediaType");

    /** The import path for the type. */
    private final String importPath;

    JaxRs(String importPath) {
        this.importPath = importPath;
    }

    @Override
    public String path(ImportRenderPrefs irp) {
        if (irp.isJakarta()) {
            return importPath.replace("javax", "jakarta");
        } else {
            return importPath;
        }
    }
}
