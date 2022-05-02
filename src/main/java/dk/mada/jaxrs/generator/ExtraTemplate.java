package dk.mada.jaxrs.generator;

import java.util.Set;

import dk.mada.jaxrs.generator.imports.Jackson;
import dk.mada.jaxrs.generator.imports.JavaIo;
import dk.mada.jaxrs.generator.imports.JavaTime;
import dk.mada.jaxrs.generator.imports.TypedImport;

/**
 * Extra templates.
 *
 * These represents extra templates that need to be optionally
 * rendered, based on model and options.
 */
public enum ExtraTemplate {
    /** LocalDate Jackson deserializer template. */
    LOCAL_DATE_JACKSON_DESERIALIZER("_LocalDateJacksonDeserializer",
        Set.of(JavaIo.IO_EXCEPTION,
               JavaTime.DATE_TIME_FORMATTER, JavaTime.LOCAL_DATE,
               Jackson.JSON_PARSER, Jackson.DESERIALIZATION_CONTEXT, Jackson.JSON_DESERIALIZER)),

    /** LocalDate Jackson serializer template. */
    LOCAL_DATE_JACKSON_SERIALIZER("_LocalDateJacksonSerializer",
        Set.of(JavaIo.IO_EXCEPTION,
               JavaTime.DATE_TIME_FORMATTER, JavaTime.LOCAL_DATE,
               Jackson.JSON_GENERATOR, Jackson.JSON_PROCESSING_EXCEPTION,
               Jackson.SERIALIZER_PROVIDER, Jackson.JSON_SERIALIZER)),

    /** LocalDateTime Jackson deserializer template. */
    LOCAL_DATE_TIME_JACKSON_DESERIALIZER("_LocalDateTimeJacksonDeserializer",
        Set.of(JavaIo.IO_EXCEPTION,
               JavaTime.DATE_TIME_FORMATTER, JavaTime.LOCAL_DATE_TIME,
               Jackson.JSON_PARSER, Jackson.JSON_PROCESSING_EXCEPTION,
               Jackson.DESERIALIZATION_CONTEXT, Jackson.JSON_DESERIALIZER)),

    /** LocalDateTime Jackson serializer template. */
    LOCAL_DATE_TIME_JACKSON_SERIALIZER("_LocalDateTimeJacksonSerializer",
        Set.of(JavaIo.IO_EXCEPTION,
               JavaTime.DATE_TIME_FORMATTER, JavaTime.LOCAL_DATE_TIME,
               Jackson.JSON_GENERATOR, Jackson.SERIALIZER_PROVIDER,
               Jackson.JSON_SERIALIZER, Jackson.JSON_PROCESSING_EXCEPTION)),

    /** OffsetDateTime Jackson deserializer template. */
    OFFSET_DATE_TIME_JACKSON_DESERIALIZER("_OffsetDateTimeJacksonDeserializer",
        Set.of(JavaIo.IO_EXCEPTION,
               JavaTime.DATE_TIME_FORMATTER, JavaTime.DATE_TIME_PARSE_EXCEPTION,
               JavaTime.LOCAL_DATE_TIME, JavaTime.OFFSET_DATE_TIME, JavaTime.ZONE_ID,
               Jackson.JSON_PARSER, Jackson.DESERIALIZATION_CONTEXT,
               Jackson.JSON_DESERIALIZER, Jackson.JSON_PROCESSING_EXCEPTION)),

    /** OffsetDateTime Jackson serializer template. */
    OFFSET_DATE_TIME_JACKSON_SERIALIZER("_OffsetDateTimeJacksonSerializer",
        Set.of(JavaIo.IO_EXCEPTION,
               JavaTime.DATE_TIME_FORMATTER, JavaTime.OFFSET_DATE_TIME,
               Jackson.JSON_GENERATOR, Jackson.SERIALIZER_PROVIDER,
               Jackson.JSON_SERIALIZER, Jackson.JSON_PROCESSING_EXCEPTION));

    /** Filename of template. */
    private final String classname;

    /** Imports required by template. */
    private final Set<TypedImport> requiredImports;

    ExtraTemplate(String classname, Set<TypedImport> requiredImports) {
        this.classname = classname;
        this.requiredImports = requiredImports;
    }

    /** {@return the filename for this template } */
    public String classname() {
        return classname;
    }

    /** {@return the required imports for this template} */
    public Set<TypedImport> requiredImports() {
        return requiredImports;
    }
}
