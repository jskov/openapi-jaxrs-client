package dk.mada.jaxrs.generator;

/**
 * Extra templates.
 *
 * These represents extra templates that need to be optionally
 * rendered, based on model and options.
 */
public enum ExtraTemplate {
    /** LocalDate Jackson deserializer template. */
    LOCAL_DATE_JACKSON_DESERIALIZER("_LocalDateJacksonDeserializer"),
    /** LocalDate Jackson serializer template. */
    LOCAL_DATE_JACKSON_SERIALIZER("_LocalDateJacksonSerializer"),
    /** OffetDateTime Jackson deserializer template. */
    OFFSET_DATE_TIME_JACKSON_DESERIALIZER("_OffsetDateTimeJacksonDeserializer"),
    /** OffetDateTime Jackson serializer template. */
    OFFSET_DATE_TIME_JACKSON_SERIALIZER("_OffsetDateTimeJacksonSerializer");

    /** Filename of template. */
    private final String classname;

    ExtraTemplate(String classname) {
        this.classname = classname;
    }

    /** {@return the filename for this template } */
    public String classname() {
        return classname;
    }
}
