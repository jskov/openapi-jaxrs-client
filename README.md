# openapi-jaxrs-client

An OpenAPI JAX-RS client generator.

Generates API classes (only) for use with the MicroProfile client.

DTOs can be generated for use with jsonb, jackson2 (fasterxml), or jackson (codehaus).
So these can be used in other (older) contexts than the MP client.

## Inspiration

Much of the behavior is lifted more or less directly from https://github.com/OpenAPITools/openapi-generator.

But the code is implemented from scratch, based on end-to-end tests.

I plan to keep this generator much simpler. It will only generate Java code, primarily intended for the MP client.
It will never have as many features as openapi-generator.

However, the intention is that the generated code covers the real-world needs I see at work.
And that the generated code can "round trip" via OpenApi to second-hand clients.


## Configuration

**generator-api-package**

>Name of package to generate API classes in. Required argument.
>
	alternative name: apiPackage

**generator-dto-package**

>Name of package to generate DTO classes in. Required argument.
>
	alternative name: modelPackage

**generator-jackson-codehaus**

>Use jackson (codehaus) annotations in generated classes.
>
	default value: false

**generator-jackson-fasterxml**

>Use jackson (fasterxml) annotations in generated classes.
>
	default value: false

**generator-jsonb**

>Use jsonb annotations in generated classes.
>
	default value: false

**generator-jackson-json-serialize-options**

>Allows you to add (jackson) json serialize options to the DTOs.

>See [example](./src/test/java/mada/tests/e2e/opts/generator/jackson)
>
	default value:

**generator-jackson-localdate-wire-format**

>Allows you specify a LocalDate wire format that is used with a standard de/serializer.

>The specified value is used as a constant/factory method on DateTimeFormatter in the de/serializer classes.

>See [example](./src/test/java/mada/tests/e2e/opts/generator/localdate)
>
	default value:

**generator-use-bigdecimal-for-double**

>Allows you to replace double-type properties with `java.math.BigDecimal`.

>The normal getter and setter (getFoo/setFoo) are replaced with BigDecimal-typed variants which are ignored by the serializer.
>Additional double-typed getter and setter methods are added (getFooDouble/setFooDouble).

>See [example](./src/test/java/mada/tests/e2e/opts/generator/bigdecimal_double)

>
	default value: false

**generator-use-boolean-get-prefix**

>Boolean getters are prefixed by 'is' by default. Enable this option to use 'get' instead.

>
	default value: false


**generator-use-empty-collections**

>Allows you to replace properties with (potential) null collections with empty collections.

>The normal getter (getFoo) are will instantiate an empty collection if the property is null.
>An additional getter (getFooNullable) is added which returns the property unaltered.

>See [example](./src/test/java/mada/tests/e2e/opts/generator/collections_empty)

>
	default value: false


**generator-use-zoneddatetime**

>date-time types are deserialized to OffsetDateTime by default, which matches the information
provided by the [spec](https://xml2rfc.tools.ietf.org/public/rfc/html/rfc3339.html).
>	
>But your remote connection may provide additional zone info which allows deserialization to
ZonedDateTime (depending on the deserializer implementation).
>	
>For example, `io.quarkus:quarkus-resteasy-jsonb` will serialize ZonedDateTime to:
>	
	`"2022-01-02T12:28:36.639812723+01:00[Europe/Copenhagen]"`
>	
>By enabling this option, the generated DTOs will have ZonedDateTime for properties
instead of OffsetDateTime.

>
	default value: false

**generator-use-generated-timestamp**

>Allows you to include a timestamp in the @Generated-annotation in all generated classes.

>
	default value: false


**parser-localdate-is-jse**

>This option allows parsing of the component schema `LocalDate` to be treated by the generator as Java SE `java.time.LocalDate`.

>It can be disabled if your remote connection uses the type name `LocalDate` for something bespoke.

>
	default value: true

**parser-localdatetime-is-jse**

>This option allows parsing of the component schema `LocalDateTime` to be treated by the generator as Java SE `java.time.OffsetDateTime`.

>It can be disabled if your remote connection uses the type name `LocalDateTime` for something bespoke.

>
	default value: true

**parser-offsetdatetime-is-jse**

>This option allows parsing of the component schema `OffsetDateTime` to be treated by the generator as Java SE `java.time.OffsetDateTime`.

>It can be disabled if your remote connection uses the type name `OffsetDateTime` for something bespoke.

>
	default value: true

**parser-zoneddatetime-is-jse**

>This option allows parsing of the component schema `ZonedDateTime` to be treated by the generator as Java SE `java.time.OffsetDateTime`.

>It can be disabled if your remote connection uses the type name `ZonedDateTime` for something bespoke.

>
	default value: true


**parser-localtime-is-jse**

>While there is no local-time definition in the [OpenApi spec](https://swagger.io/specification/#data-types),
>the Quarkus open-api extension will output LocalTime types like this:

>
    LocalTime:
      format: local-time
      type: string
      externalDocs:
        description: As defined by 'partial-time' in RFC3339
        url: https://xml2rfc.ietf.org/public/rfc/html/rfc3339.html#anchor14
      example: 13:45.30.123456789

>This option allows parsing of the component schema `LocalTime` to be treated by the generator as Java SE `java.time.LocalTime`.

>It can be disabled if your remote connection uses the type name `LocalTime` for something bespoke.
	
>
	default value: true


## Testing

In Eclipse, add build/e2e as a source folder (and exclude **/*.java) to get easy access to test output.

Bulk update:

	./gradlew test
	cp -r build/e2e/mada/tests src/test/java/mada/
	# Then look at diff
