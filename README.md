# An OpenAPI JAX-RS client code generator

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=jskov_openapi-jaxrs-client&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=jskov_openapi-jaxrs-client) [![Javadoc](https://img.shields.io/badge/JavaDoc-Online-green)](https://jskov.github.io/openapi-jaxrs-client/)

Generates API classes for use with the MicroProfile client.

DTOs can be generated for use with jsonb, jackson2 (fasterxml), or jackson (codehaus).
So these can be used in other (older) contexts than the MP client.

**This project is still in development - it may be a little rough around the edges!!**

## Inspiration

Much of the behavior and templates are lifted more or less directly from [openapi-generator](https://github.com/OpenAPITools/openapi-generator).

But the code is implemented from scratch, based on end-to-end tests.

I plan to keep this generator much simpler:

 * it will only generate Java code, primarily intended for the MP client.
 * it will never have as many features as openapi-generator.
 * but its reduced complexity should allow me to acquire the output I desire *and* retain my sanity.

## Invocation

Download the cli-jar release of the generator (and verify its [signature](http://keyserver.ubuntu.com/pks/lookup?search=0xF9B879EDFC0AB297588936F49CCE5D89C917DBD4&fingerprint=on&op=index)!).

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

A Gradle plugin will follow at some time. 

## Configuration

The code generation is configured via [options](./src/docs/Configuration.md).


## Contributing and Consultancy

I am still not entirely sure how I want to manage this project. So this section will change and/or be expanded on.

But I will happily accept bug reports.

Pull requests with accompanying end-to-end tests will probably be accepted - but please reach out to me in advance, so you do not waste your time.

I will offer a simple paid service to implement feature requests (pending approval from my employer).

If the above are not agreeable, you are more than welcome to fork the project, and do your own thing.
