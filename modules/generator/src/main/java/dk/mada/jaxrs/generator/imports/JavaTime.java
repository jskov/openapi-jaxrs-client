package dk.mada.jaxrs.generator.imports;

import java.util.Optional;

import dk.mada.jaxrs.generator.imports.Imports.ImportRenderPrefs;

/**
 * Java time import paths.
 */
public enum JavaTime implements TypedImport {
    /** DateTimeFormatter. */
    DATE_TIME_FORMATTER("java.time.format.DateTimeFormatter"),
    /** DateTimeParseException. */
    DATE_TIME_PARSE_EXCEPTION("java.time.format.DateTimeParseException"),
    /** LocalDate. */
    LOCAL_DATE("java.time.LocalDate"),
    /** LocalDateTime. */
    LOCAL_DATE_TIME("java.time.LocalDateTime"),
    /** OffsetDateTime. */
    OFFSET_DATE_TIME("java.time.OffsetDateTime"),
    /** ZoneId. */
    ZONE_ID("java.time.ZoneId");

    /** The import path for the type. */
    private final String importPath;

    JavaTime(String importPath) {
        this.importPath = importPath;
    }

    @Override
    public Optional<String> path(ImportRenderPrefs irp) {
        return Optional.of(importPath);
    }
}
