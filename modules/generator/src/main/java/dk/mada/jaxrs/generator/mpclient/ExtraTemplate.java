package dk.mada.jaxrs.generator.mpclient;

import java.util.Set;

import dk.mada.jaxrs.generator.mpclient.imports.Jackson;
import dk.mada.jaxrs.generator.mpclient.imports.JavaIo;
import dk.mada.jaxrs.generator.mpclient.imports.JavaTime;
import dk.mada.jaxrs.generator.mpclient.imports.TypedImport;

/**
 * Extra templates.
 *
 * These represents extra templates that need to be optionally rendered, based on model and options.
 */
public enum ExtraTemplate {
    /** LocalDate Jackson deserializer template. */
    LOCAL_DATE_JACKSON_DESERIALIZER("_LocalDateJacksonDeserializer", true,
            Set.of(JavaIo.IO_EXCEPTION,
                    JavaTime.DATE_TIME_FORMATTER, JavaTime.LOCAL_DATE,
                    Jackson.JSON_PARSER, Jackson.DESERIALIZATION_CONTEXT, Jackson.JSON_DESERIALIZER)),

    /** LocalDate Jackson serializer template. */
    LOCAL_DATE_JACKSON_SERIALIZER("_LocalDateJacksonSerializer", false,
            Set.of(JavaIo.IO_EXCEPTION,
                    JavaTime.DATE_TIME_FORMATTER, JavaTime.LOCAL_DATE,
                    Jackson.JSON_GENERATOR, Jackson.JSON_PROCESSING_EXCEPTION,
                    Jackson.SERIALIZER_PROVIDER, Jackson.JSON_SERIALIZER)),

    /** LocalDateTime Jackson deserializer template. */
    LOCAL_DATE_TIME_JACKSON_DESERIALIZER("_LocalDateTimeJacksonDeserializer", true,
            Set.of(JavaIo.IO_EXCEPTION,
                    JavaTime.DATE_TIME_FORMATTER, JavaTime.LOCAL_DATE_TIME,
                    Jackson.JSON_PARSER, Jackson.JSON_PROCESSING_EXCEPTION,
                    Jackson.DESERIALIZATION_CONTEXT, Jackson.JSON_DESERIALIZER)),

    /** LocalDateTime Jackson serializer template. */
    LOCAL_DATE_TIME_JACKSON_SERIALIZER("_LocalDateTimeJacksonSerializer", false,
            Set.of(JavaIo.IO_EXCEPTION,
                    JavaTime.DATE_TIME_FORMATTER, JavaTime.LOCAL_DATE_TIME,
                    Jackson.JSON_GENERATOR, Jackson.SERIALIZER_PROVIDER,
                    Jackson.JSON_SERIALIZER, Jackson.JSON_PROCESSING_EXCEPTION)),

    /** OffsetDateTime Jackson deserializer template. */
    OFFSET_DATE_TIME_JACKSON_DESERIALIZER("_OffsetDateTimeJacksonDeserializer", true,
            Set.of(JavaIo.IO_EXCEPTION,
                    JavaTime.DATE_TIME_FORMATTER, JavaTime.DATE_TIME_PARSE_EXCEPTION,
                    JavaTime.LOCAL_DATE_TIME, JavaTime.OFFSET_DATE_TIME, JavaTime.ZONE_ID,
                    Jackson.JSON_PARSER, Jackson.DESERIALIZATION_CONTEXT,
                    Jackson.JSON_DESERIALIZER, Jackson.JSON_PROCESSING_EXCEPTION)),

    /** OffsetDateTime Jackson serializer template. */
    OFFSET_DATE_TIME_JACKSON_SERIALIZER("_OffsetDateTimeJacksonSerializer", false,
            Set.of(JavaIo.IO_EXCEPTION,
                    JavaTime.DATE_TIME_FORMATTER, JavaTime.OFFSET_DATE_TIME,
                    Jackson.JSON_GENERATOR, Jackson.SERIALIZER_PROVIDER,
                    Jackson.JSON_SERIALIZER, Jackson.JSON_PROCESSING_EXCEPTION));

    /** Filename of template. */
    private final String classname;

    /** Flag for deserializer/serializer. */
    private final boolean deserializer;

    /** Imports required by template. */
    private final Set<TypedImport> requiredImports;

    ExtraTemplate(String classname, boolean deserializer, Set<TypedImport> requiredImports) {
        this.classname = classname;
        this.deserializer = deserializer;
        this.requiredImports = requiredImports;
    }

    /** {@return the filename for this template } */
    public String classname() {
        return classname;
    }

    /** {@return true for deserializers} **/
    public boolean isDeserializer() {
        return deserializer;
    }

    /** {@return true if the class handles LocalDate} */
    public boolean isLocalDate() {
        return classname.contains("LocalDateJ");
    }

    /** {@return true if the class handles LocalDateTime} */
    public boolean isLocalDateTime() {
        return classname.contains("LocalDateTime");
    }

    /** {@return true if the class handles OffsetDateTime} */
    public boolean isOffsetDateTime() {
        return classname.contains("OffsetDateTime");
    }

    /** {@return the required imports for this template} */
    public Set<TypedImport> requiredImports() {
        return requiredImports;
    }
}
