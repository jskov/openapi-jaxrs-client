package dk.mada.jaxrs.generator;

/**
 * Json binding import paths.
 */
public enum JsonbImport {
    /** Json. */
    JSON("javax.json.Json"),
    /** JsonString. */
    JSON_STRING("javax.json.JsonString"),
    /** JsonbAdapter. */
    JSONB_ADAPTER("javax.json.bind.adapter.JsonbAdapter"),
    /** JsonbProperty. */
    JSONB_PROPERTY("javax.json.bind.annotation.JsonbProperty"),
    /** JsonbPropertyOrder. */
    JSONB_PROPERTY_ORDER("javax.json.bind.annotation.JsonbPropertyOrder"),
    /** JsonbTypeAdapter. */
    JSONB_TYPE_ADAPTER("javax.json.bind.annotation.JsonbTypeAdapter");

    /** The import path for the type. */
    private final String importPath;

    JsonbImport(String importPath) {
        this.importPath = importPath;
    }

    /** {@return the import path for the type} */
    public String importPath() {
        return importPath;
    }
}
