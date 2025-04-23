The below generator options allow you some control of how the resulting source code is renderd.

## **generator-api-additional-annotations**

Allows you to add annotations to each API resource class.

You can separate lines with the newline escape (\n). If you need to use this in strings, add an extra escape (\\n).

The lines are added before the @Generated line, so could in theory be abused for all sorts of things.
If you get too exotic with this option, and something breaks in a later release, you get to keep both parts.

    default value:


## **generator-api-default-name**

Default name of the API file if not specified via groups in the OpenApi document.

    default value:

## **generator-api-package**

Name of package to generate API classes in.

Required option, but can be set via the CLI argument `--api-package`.

## **generator-api-skip**

Allows you to skip generation of API classes.

    default value: false

## **generator-api-use-authorization-header**

Allows you to control use of @HeaderParam("Authorization") on resource methods.

Possible values are:

 * api: the header is added as specified by the API document (default)
 * on: always add the header
 * off: never add the header

    default value: api

## **generator-api-use-multipartform**

Allows you to bundle @FormParam parameters into a @MultipartForm multipart body.

    default value: false


## **generator-api-void-produces-mediatype**

The MicroProfile Client defaults to "application/json" if no @Produces is provided.

That is not always desirable, so this option allows you to specify the @Produces-media-type for
void resource methods that have no other media-type defined.

    default value:


## **generator-dto-package**

Name of package to generate DTO classes in.

Required option, but can be set via the CLI argument `--dto-package`.


## **generator-dto-pojo-use-requirenonnull**

Allows you to control POJO's use of Objects.requireNonNull in setters.

    default value: true

## **generator-dto-records**

Allows you to generate record DTOs instead of POJO DTOs.

Note: enables `generator-jspecify` per default - if unwanted, you can specify it as `false`.

    default value: false


## **generator-dto-records-use-builder**

Allows you to generate builders for records. These can be handy when you need to create
records with many arguments.

The legal values are:

 * ALL: Builder is created for all records.
 * NAMED:name1,name2,... Builder is created for records with the listed names
 * NONE: No builders are created.

    default value: ALL

## **generator-dto-records-use-requirenonnull**

Allows you to control record's use of canonical constructor with Objects.requireNonNull

    default value: true

## **generator-dto-skip-types**

Allows you to suppress generation of some DTO classes.

The provided value should be a comma-separated list of OpenApi type IDs.

## **generator-dto-use-openapi-schema**

Allows you to disable the OpenApi @Schema annotations that enrich information about properties.

    default value: true

## **generator-jackson-fasterxml**

Use jackson (fasterxml) annotations in generated classes.

    default value: false

## **generator-jackson-json-serialize-options**

Allows you to add (jackson) json serialize options to the DTOs.

These are also appended to custom date serializer annotations (to prevent
them from being disabled).

See [example](https://github.com/jskov/openapi-jaxrs-client/tree/main/modules/generator/src/test/java/mada/tests/e2e/opts/generator/jackson)

    default value:

## **generator-jackson-localdate-deserializer**

Allows you specify a custom LocalDate deserializer class (use a fully qualified class name).

The default value will also cause generation of a generic LocalDate deserializer that uses `generator-jackson-localdate-wire-format`.

    default value: _LocalDateJacksonDeserializer

## **generator-jackson-localdate-serializer**

Allows you specify a custom LocalDate serializer class (use a fully qualified class name).

The default value will also cause generation of a generic LocalDate serializer that uses `generator-jackson-localdate-wire-format`.

    default value: _LocalDateJacksonSerializer

## **generator-jackson-localdate-wire-format**

Allows you specify a LocalDate wire format that is used with a standard de/serializer.

The specified value is used as a constant/factory method on DateTimeFormatter in the de/serializer classes.

See [example](https://github.com/jskov/openapi-jaxrs-client/tree/main/modules/generator/src/test/java/mada/tests/e2e/opts/generator/localdate)

    default value: ISO_LOCAL_DATE

## **generator-jackson-localdatetime-deserializer**

Allows you specify a custom LocalDateTime deserializer class (use a fully qualified class name).

The default value will also cause generation of a generic LocalDateTime deserializer that uses `generator-jackson-localdatetime-wire-format`.

    default value: _LocalDateTimeJacksonDeserializer

## **generator-jackson-localdatetime-serializer**

Allows you specify a custom LocalDateTime serializer class (use a fully qualified class name).

The default value will also cause generation of a generic LocalDateTime serializer that uses `generator-jackson-localdatetime-wire-format`.

    default value: _LocalDateTimeJacksonSerializer

## **generator-jackson-localdatetime-wire-format**

Allows you specify a LocalDateTime wire format that is used with a standard de/serializer.

The specified value is used as a constant/factory method on DateTimeFormatter in the de/serializer classes.

See [example](https://github.com/jskov/openapi-jaxrs-client/tree/main/modules/generator/src/test/java/mada/tests/e2e/opts/generator/localdate)

    default value: ISO_LOCAL_DATE_TIME

## **generator-jackson-offsetdatetime-deserializer**

Allows you specify a custom OffsetDateTime deserializer class (use a fully qualified class name).

The default value will also cause generation of a generic OffsetDateTime deserializer that uses `generator-jackson-offsetdatetime-wire-format`.

    default value: _OffsetDateTimeJacksonDeserializer

## **generator-jackson-offsetdatetime-serializer**

Allows you specify a custom OffsetDateTime serializer class (use a fully qualified class name).

The default value will also cause generation of a generic OffsetDateTime serializer that uses `generator-jackson-offsetdatetime-wire-format`.

    default value: _OffsetDateTimeJacksonSerializer

## **generator-jackson-offsetdatetime-wire-format**

Allows you specify a OffsetDateTime wire format that is used with a standard de/serializer.

The specified value is used as a constant/factory method on DateTimeFormatter in the de/serializer classes.

    default value: ISO_OFFSET_DATE_TIME

## **generator-jakarta**

Use `jakarta.` package instead of `javax.` package.

    default value: false


## **generator-jsonb**

Use jsonb annotations in generated classes.

    default value: false

## **generator-jspecify**

Use [jspecify](https://jspecify.dev/) annotations for improved null checking.

Enabled by default when using `generator-record`.

    default value: false


## **generator-map-external-types**

Allows you to map types in the OpenApi document to other packages, suppressing generation of DTOs for these types.

This can be useful for referencing common types that are distributes by other means.

Format:
  packageA:[typeA, typeB,...]; packageB:[typeC, typeD, ...]


    default value:

## **generator-mp-api-register-providers**

Allows you to add @RegisterProvider to each API resource class.

The provided value should be a comma-separated list of fully-qualified class names.

    default value:

## **generator-mp-api-register-rest-client**

Allows you to add @RegisterRestClient to each API resource class. The provided value is used for the `configKey`.

    default value:

## **generator-quarkus-use-register-for-reflection**

Allows you to add @RegisterForReflection to all DTos.

    default value: false

## **generator-type-no-format-integer**

Allows you to define which type to use for integers that have no explicit format defined.

Historically, this has defaulted to short, but this may change in a later minor release.

    default value: SHORT

## **generator-type-no-format-number**

Allows you to define which type to use for numbers that have no explicit format defined.

Allowed values are BigDecimal, Float, and Decimal.

    default value: BigDecimal

## **generator-use-api-wrapped-primitives**

Allows you to use primitive wrapped as API parameters instead of primitives.

This can be required to determine if a parameter is present.

    default value: false

## **generator-use-bean-validation**

Allows you to disable the rendering of bean validation annotations.

    default value: true

## **generator-use-bigdecimal-for-double**

Allows you to replace double-type properties with `java.math.BigDecimal`.

The normal getter and setter (getFoo/setFoo) are replaced with BigDecimal-typed variants which are ignored by the serializer.
Additional double-typed getter and setter methods are added (getFooDouble/setFooDouble).

See [example](https://github.com/jskov/openapi-jaxrs-client/tree/main/modules/generator/src/test/java/mada/tests/e2e/opts/generator/bigdecimal_double)

    default value: false

## **generator-use-boolean-get-prefix**

Boolean getters are prefixed by 'is' by default. Enable this option to use 'get' instead.

    default value: false


## **generator-use-empty-collections**

Allows you to replace properties with (potential) null collections with empty collections.

The normal getter (getFoo) are will instantiate an empty collection if the property is null.
An additional getter (getFooNullable) is added which returns the property unaltered.

See [example](https://github.com/jskov/openapi-jaxrs-client/tree/main/modules/generator/src/test/java/mada/tests/e2e/opts/generator/collections_empty)

    default value: false

## **generator-use-enum-unknown-default**

Allows you to add a fallback value ('unknown_default_open_api') to enumerations.
This value is used when deserializing unknown input instead of throwing IllegalStateException.

    default value: false

## **generator-use-generated-jdk**

Allows you to use @javax.annotation.Generated annotation instead of the JDK 9+ @javax.annotation.processing.Generated

    default value: true

## **generator-use-generated-timestamp**

Allows you to include a timestamp in the @Generated-annotation in all generated classes.

    default value: false

## **generator-use-line-ending**

Allows you to control the line endings used in templates.


 * auto: use the standard line endings for the current platform.
 * unix: use Unix line endings (LF).
 * windows: use Windows line endings (CRLF).

    default value: auto

## **generator-use-localdatetime**

date-time types are deserialized to OffsetDateTime by default, which matches the information
provided by the [spec](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html).
   
But your remote connection may not provide the offset information, and/or your software runs
in the same time zone.

By enabling this option, the generated DTOs will have LocalDateTime for properties
instead of OffsetDateTime.

    default value: false


## **generator-use-mp-validation-rules**

Use the additional [Bean Validation transformation rules](https://download.eclipse.org/microprofile/microprofile-open-api-3.1.1/microprofile-openapi-spec-3.1.1.html#_jakarta_bean_validation_annotations) defined by MicroProfile.

    default value: true



## **generator-use-property-conflict-resolution**

Allows you to select the resolution to use when there is conflict in the declarations for a property (in allof/subclassing).

This could be the validation settings, the description, or the example.

The legal values are:

 * fail: the code generation is aborted
 * clear: clear the conflicting information
 * first: use the first information found by the parser

	default value: FAIL

## **generator-use-property-order**

Allows you to control the order properties (and thus getters, setters, and enums) are
rendered in.

Since the order of properties in the OpenApi document (by my reading of the spec) is not
important, applying sorting is the only way to be sure your generated code is
stable over time.

 * document-order: in the order the properties are declared in the OpenApi document.
 * alphabetical-order: in alphabetical naming order
 * alphabetical-nocase-order: in alphabetical naming order, ignoring case


    default value: alphabetical-nocase-order

## **generator-use-property-order-annotation**

Allows you to control if the annotation for property order should be rendered.

This is false by default since there are no provisions in the OpenApi specification
for transmitting this information (see [MP issue](https://github.com/eclipse/microprofile-open-api/issues/359)).

    default value: false

## **generator-use-serializable**

Allows you to mark all DTOs with Serializable.

    default value: false

## **generator-use-single-line-tostring**

Allows you to select an alternative toString implementation that will output only a single line.

    default value: false


## **generator-use-zoneddatetime**

date-time types are deserialized to OffsetDateTime by default, which matches the information
provided by the [spec](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html).
	
But your remote connection may provide additional zone info which allows deserialization to
ZonedDateTime (depending on the deserializer implementation).
	
For example, `io.quarkus:quarkus-resteasy-jsonb` will serialize ZonedDateTime to:
	
    `"2022-01-02T12:28:36.639812723+01:00[Europe/Copenhagen]"`
	
By enabling this option, the generated DTOs will have ZonedDateTime for properties
instead of OffsetDateTime.

    default value: false
