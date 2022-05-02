package dk.mada.jaxrs.generator.imports;

/**
 * Quarkus import paths.
 */
public enum Quarkus {
    /** RegisterForReflection. */
    REGISTER_FOR_REFLECTION("io.quarkus.runtime.annotations.RegisterForReflection");

    /** The import path for the type. */
    private final String importPath;

    Quarkus(String importPath) {
        this.importPath = importPath;
    }

    /** {@return the import path for the type} */
    public String importPath() {
        return importPath;
    }
}
