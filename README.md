# openapi-jaxrs-client

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=jskov_openapi-jaxrs-client&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=jskov_openapi-jaxrs-client) [![Javadoc](https://img.shields.io/badge/JavaDoc-Online-green)](https://jskov.github.io/openapi-jaxrs-client/)

An OpenAPI JAX-RS client generator.

Generates API classes for use with the MicroProfile client.

DTOs can be generated for use with jsonb, jackson2 (fasterxml), or jackson (codehaus).
So these can be used in other (older) contexts than the MP client.

## Inspiration

Much of the behavior is lifted more or less directly from https://github.com/OpenAPITools/openapi-generator.

But the code is implemented from scratch, based on end-to-end tests.

I plan to keep this generator much simpler. It will only generate Java code, primarily intended for the MP client.
It will never have as many features as openapi-generator.

However, the intention is that the generated code covers the real-world needs I see at work.
And that the generated code can "round trip" via OpenApi to second-hand clients.

## Still in development

This project is still in development, not suitable for use by anyone.


## Configuration

The code generation is configured via property settings.


### Generator options

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
	default value: ISO_LOCAL_DATE

**generator-use-api-wrapped-primitives**

>Allows you to use primitive wrapped as API parameters instead of primitives.

>This can be required to determine if a parameter is present.

>
    default value: false

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

### Naming options

The naming of types, properties and enumeration entries can be (partly) controlled via some operators.

`TYPENAME` and `PROPERTYNAME` are based on the [Java spec for identifiers](https://docs.oracle.com/javase/specs/jls/se7/html/jls-3.html#jls-3.8). They will convert any non-identifier character to '_'. A hyphen ('-') will be removed and the next character upper-cased.

	UPCASE: Converts the input to upper case.
	DOWNCASE: Converts the input to lower case.
	LITERAL/value/: Returns the provided value.
	TYPENAME: Converts the input to a valid java identifier (first letter upper case)
      PARAMETERNAME: Converts the input to a valid java identifier (first letter lower case)
	PROPERTYNAME: (alias for PARAMETERNAME)
	REGEXP/pattern/replacement/: Will match input against pattern and substitute all matches with replacement.

You can specify a number of operators, separated by ';'. They will be applied left-to-right.

**naming-enum-prefix-number**

>Allows you to replace the prefix used in enum naming of numbers.
>This one overrules naming-rules-enum

>
	default value: NUMBER_


**naming-rules-enum**

>Allows you to control the naming of enumeration entries using the operators described above.

>The type name is given as input.

>
	default value: TYPENAME; UPCASE

**naming-rules-entity**

>Allows you to control the naming of the entity parameter in APIs using the operators described above.

>The type name is given as input.

>
    default value: LITERAL/dto/

**naming-rules-parameter**

>Allows you to control the naming of parameters using the operators described above.

>The parameter name is given as input.

>
	default value: PARAMETERNAME

**naming-rules-property**

>Allows you to control the naming of properties using the operators described above.

>The property name is given as input.

>
	default value: PROPERTYNAME

**naming-rules-type**

>Allows you to control the naming of types using the operators described above.

>The type name is given as input.

>
	default value: TYPENAME

### Parser options

**parser-fixup-void-200-to-204**

>This option allows changing a 200-response that has no declared return type to a 204-response.

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
