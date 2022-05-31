# An OpenAPI JAX-RS client code generator

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=jskov_openapi-jaxrs-client&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=jskov_openapi-jaxrs-client) [![Javadoc](https://img.shields.io/badge/JavaDoc-Online-green)](https://jskov.github.io/openapi-jaxrs-client/)

Generates code to call REST services.

The API classes are intended for use with the MicroProfile client.

The DTO classes can be generated for use with [JSON Binding](https://javaee.github.io/jsonb-spec/), [Jackson FasterXML](https://github.com/FasterXML/jackson-docs), or [Jackson Codehaus](https://github.com/codehaus/jackson).  
So these can be used in other (older) contexts than with a MicroProfile client.

## Inspiration

Much of the behavior and templates are lifted more or less directly from [openapi-generator](https://github.com/OpenAPITools/openapi-generator).

But the code is implemented from scratch, based on end-to-end tests.

I plan to keep this generator much simpler:

 * it will only generate Java code, primarily intended for the MP client.
 * it will never have as many features as openapi-generator.
 * but its reduced complexity should allow me to acquire the output I desire *and* retain my sanity.

## Invocation

Download the cli-jar release of the generator (and verify its [signature](./src/docs/VerifySigning.md)!).

Then you can run the generator with a Java 17 like this (or see [full CLI usage](./src/docs/Cli.md)):

```console
$ java -jar ojc-x.y.z-cli.jar --api-package foo.bar.api --dto-package foo.bar.dto -i petstore.yaml -o /tmp/output
[2022-02-26 15:08:47] [INFO] Reads OpenApi document from petstore.yaml 
[2022-02-26 15:08:47] [INFO] Generates files in /tmp/output 
[2022-02-26 15:08:47] [INFO] No configuration file found
...

$ tree /tmp/output/
/tmp/output/
└── foo
    └── bar
        ├── api
        │   └── PetsApi.java
        └── dto
            ├── Error.java
            └── Pet.java
```

The output looks something like [this](./src/test/java/mada/tests/e2e/examples/petstore).
The output from many other test OpenApi documents and configuration settings [can be seen in the test folder](./src/test/java/mada/tests/e2e).


### Gradle Invocation

Note: not quite ready yet. Still need to do a new release to Maven Central.

A [Gradle plugin](./src/docs/Gradle.md) allows easy declaration of OpenApi documents and generator options.


## Configuration

The code generation is configured via [options](./src/docs/Configuration.md).

## Roadmap

The current plans for future releases are (note, no time commitments):

**0.9.x**

* Add gradle plugin.
* Split code into modules (converter+model, generator).
* Refactor the methods that have gotten large during 0.8.x.
* More code/package documentation.
* Documentation index with references to the various tests/examples.

**1.0.x ideas**

* For operations with many query parameters, make builder-like flow-pattern call.
* Handling of extensions (e.g. annotation of in-house @LoggedSecrets operations)
* Options for adding @ClientHeaderParam and/or @RegisterClientHeaders
* Custom OffsetDateTime de/serializer options

## Contributing and Consultancy

I am still not entirely sure how I want to manage this project. So this section will change and/or be expanded on.

But I will happily accept bug reports.

Pull requests with accompanying end-to-end tests will probably be accepted - but please reach out to me in advance, so you do not waste your time.

I will offer to implement feature requests as a paid service (pending approval from my employer).

If the above are not agreeable, you are more than welcome to fork the project, and do your own thing.
