
These options control the translation of data from the [swagger-parser](https://github.com/swagger-api/swagger-parser) into the local [model implementation](https://github.com/jskov/openapi-jaxrs-client/tree/main/modules/model/src/main/java/dk/mada/jaxrs/model).

## **parser-abort-on-resolver-failure**

This option allows you to control if the parser should abort if it cannot resolve a type.

This is an openapi-jaxrs-client debugging help. It does not help you if the resolver aborts.

    default value: true

## **parser-api-preferred-request-mediatypes**

This option allows selection of a preferred media-type for requests.

You can specify a comma-separated list of regular expressions that will tried to match available media-types in order.

If a request has multiple media-types and you do not make a selection via this option, parsing will be aborted.

	default value:

## **parser-api-preferred-response-mediatypes**

This option allows selection of a preferred media-type for responses.

You can specify a comma-separated list of regular expressions that will tried to match available media-types in order.

If a response has multiple media-types and you do not make a selection via this option, parsing will be aborted.

	default value:

## **parser-fixup-null-type-dates**

This option allows accepting type=null/format=date (or date-time) as date/date-time types.

    default value: false

## **parser-inputstream-is-jse**

This option allows parsing of the type byte[] (`FileSchema` and `BinarySchema`) to be treated by the generator as Java SE `java.io.InputSteam`.

It can be disabled if your remote connection uses the type name `InputStream` for something bespoke.

    default value: true

## **parser-localdate-is-jse**

This option allows parsing of the component schema `LocalDate` to be treated by the generator as Java SE `java.time.LocalDate`.

It can be disabled if your remote connection uses the type name `LocalDate` for something bespoke.

    default value: true

## **parser-localdatetime-is-jse**

This option allows parsing of the component schema `LocalDateTime` to be treated by the generator as Java SE `java.time.OffsetDateTime`.

It can be disabled if your remote connection uses the type name `LocalDateTime` for something bespoke.

    default value: true


## **parser-localtime-is-jse**

While there is no local-time definition in the [OpenApi spec](https://swagger.io/specification/#data-types),
the Quarkus open-api extension will output LocalTime types like this:

```yaml
LocalTime:
  format: local-time
  type: string
  externalDocs:
    description: As defined by 'partial-time' in RFC3339
    url: https://xml2rfc.ietf.org/public/rfc/html/rfc3339.html#anchor14
  example: 13:45.30.123456789
```

This option allows parsing of the component schema `LocalTime` to be treated by the generator as Java SE `java.time.LocalTime`.

It can be disabled if your remote connection uses the type name `LocalTime` for something bespoke.
    
    default value: true


## **parser-map-simple-dtos-to-object**

Allows you to generate simple DTO types that have no properties. They are mapped to Object by default.

	default value: true

## **parser-offsetdatetime-is-jse**

This option allows parsing of the component schema `OffsetDateTime` to be treated by the generator as Java SE `java.time.OffsetDateTime`.

It can be disabled if your remote connection uses the type name `OffsetDateTime` for something bespoke.

    default value: true

## **parser-uuid-is-jse**

This option allows parsing of the component schema `UUID` to be treated by the generator as Java SE `java.util.UUID`.

It can be disabled if your remote connection uses the type name `UUID` for something bespoke.

    default value: true

## **parser-zoneddatetime-is-jse**

This option allows parsing of the component schema `ZonedDateTime` to be treated by the generator as Java SE `java.time.OffsetDateTime`.

It can be disabled if your remote connection uses the type name `ZonedDateTime` for something bespoke.

    default value: true
