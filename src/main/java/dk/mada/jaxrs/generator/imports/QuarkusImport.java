package dk.mada.jaxrs.generator.imports;

/**
 * Quarkus import paths.
 */
public enum QuarkusImport {
    /** RegisterForReflection. */
    REGISTER_FOR_REFLECTION("io.quarkus.runtime.annotations.RegisterForReflection");

    /** The import path for the type. */
    private final String importPath;

    QuarkusImport(String importPath) {
        this.importPath = importPath;
    }

    /** {@return the import path for the type} */
    public String importPath() {
        return importPath;
    }
}
