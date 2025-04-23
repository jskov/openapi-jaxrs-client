The intention of this code generator is to provide JAX-RS (or more recently, MicroProfile REST Client) API and DTO classes from OpenApi documents.

Similar to what [openapi-generator](https://github.com/OpenAPITools/openapi-generator) does, but more focused.

The API classes are intended for use with the [MicroProfile client](https://download.eclipse.org/microprofile/microprofile-rest-client-3.0/microprofile-rest-client-spec-3.0.html).  
The DTOs can be generated as records or classes for use with [JSON Binding](https://javaee.github.io/jsonb-spec/) or [Jackson FasterXML](https://github.com/FasterXML/jackson-docs).  

The code generation is configured via 50+ [options](./config/index.md).


## Inspiration

Much of the behavior and templates are lifted more or less directly from [openapi-generator](https://github.com/OpenAPITools/openapi-generator).

But this generator code is implemented from scratch, based on end-to-end tests inspired or based on broken behavior seen on input we had to handle where I work.

And in comparison, I plan to keep this generator much simpler:

 * it will only generate Java code, primarily intended for the MP client.
 * it will never have as many features or use cases as openapi-generator.
 * but its reduced complexity should allow me to acquire the output I desire *and* retain my sanity.


## Example Output

A couple of official APIs are kept as examples: [azure](https://github.com/jskov/openapi-jaxrs-client/tree/main/modules/generator/src/test/java/mada/tests/e2e/examples/azure), [bitbucket](https://github.com/jskov/openapi-jaxrs-client/tree/main/modules/generator/src/test/java/mada/tests/e2e/examples/bitbucket), and [petstore](https://github.com/jskov/openapi-jaxrs-client/tree/main/modules/generator/src/test/java/mada/tests/e2e/examples/petstore).
These should give you an idea of what the generator's output looks like - and they help me evaluate how changes affect the output on larger APIs.

The output from many other test OpenApi documents and configuration settings [can be seen in the test folder](https://github.com/jskov/openapi-jaxrs-client/tree/main/modules/generator/src/test/java/mada/tests/e2e).



## Code Quality and Reproducibility

I strive to keep this repository of good code quality as defined by [SonarQube ![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=jskov_openapi-jaxrs-client&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=jskov_openapi-jaxrs-client).

The code is formatted using the [Palantir java formatter](https://github.com/palantir/palantir-java-format).

There are [end-to-end tests](https://github.com/jskov/openapi-jaxrs-client/tree/main/modules/generator/src/test/java/mada/tests/e2e) for most (if not all) of the configuration options and OpenApi document inputs that I have experienced in practise.

This repository produces [Reproducible Builds](https://reproducible-builds.org/) (as should all infrastructure tooling, IMO).  

You can verify the veracity of the built artifacts at [Reproducible Central ![Reproducible Central](https://img.shields.io/endpoint?url=https://raw.githubusercontent.com/jvm-repo-rebuild/reproducible-central/master/content/dk/mada/jaxrs/openapi-jaxrs-client/badge.json)](https://github.com/jvm-repo-rebuild/reproducible-central/blob/master/content/dk/mada/jaxrs/openapi-jaxrs-client/README.md)



The above are my standards.

There are not guarantees that the code (the implementation or its output) will meet your standards.
If you think that is a problem, the project is fortunately Open Source, and you are welcome to fork it and fix it to your liking.

## Roadmap

The current plans for future releases are (note, no time commitments):

**0.12.x**

* Remaining open generator issues.
* More code/package documentation.
* Documentation index with references to the various tests/examples (use mkdocs).

**0.13.x**

* Tests should get a do-over to ensure smaller (better targed) tests and permutations to cover all inputs (spec versions) and outputs (serializers, DTO classes/records).
* Option renaming to be more consistent.
* Option documentation with examples (and links to simplified tests)
* Switch defaults options (e.g. use records)

**1.0.x ideas**

* For operations with many query parameters, make builder-like flow-pattern call.
* Handling of extensions (e.g. annotation of in-house @LoggedSecrets operations)
* Options for adding @ClientHeaderParam and/or @RegisterClientHeaders
* Maybe add generation of server-side code


## History/Rationale

We generate client code (originally only DTOs) from a lot of different sources at work, and the input OpenApi documents are not all entirely spec-worthy.

So I have spent a lot of hours in the past tweaking [openapi-generator](https://github.com/OpenAPITools/openapi-generator) to generate code of usable quality.
This was not always possible (because of its architecture), and it was always a pain the butt!

To improve my sanity at work, I wrote the bulk of this generator during the Christmas holidays of 2021.

More and more projects at work now use this generator, and many (weird) corner cases have been fixed over time.
This has made it possible to deprecated my old generator, so in my book, this is great!

The project has a lot of tests to help ensure I do not (accidentally) break behavior.

While the code generation output is the primary goal of the project, I also use it as a test bed for use of code quality tooling and Gradle build logic organization.

## Community Collaboration

I like Open Source just as much as the next guy.

This tool provides infrastructure to whomever uses it, so it should be Open Source.  
And it is; the main body of code is covered by the [European Union Public Licence](https://interoperable-europe.ec.europa.eu/collection/eupl/eupl-text-eupl-12).  
Except for the [templates](https://github.com/jskov/openapi-jaxrs-client/tree/mkdocs/modules/generator/src/main/resources/templates) and the single class [OpenapiStringUtils](https://github.com/jskov/openapi-jaxrs-client/blob/main/modules/generator/src/main/java/dk/mada/jaxrs/generator/mpclient/dto/OpenapiStringUtils.java), which are covered by the [Apache License](https://github.com/jskov/openapi-jaxrs-client/blob/main/LICENSE-apache).

But (my definition of) stability and quality of the generator's output is more important to me than being able to accept changes from other parties.  
It is a tool I rely on to provide a difference for colleagues at work.

So while you are welcome to access and fork the source code, I am not as such interested in contributions.  
Unless they just happen to align with my interests, of course.

If you are itching to make some changes, please open an issue first, so we can discuss.  
I do not want you to waste your time!

I welcome bug reports if you use the generator and experience problems.

## Consultancy

The project is Open Source and I am happy for you to use the generator, report bugs and suggest changes.

But while the source code is free, it does not come bundled with promises or guarantees of free work.

I will try to fix reported bugs, but will commit to no time tables.

However, I am willing to implement feature requests as a paid service (1,200DKK/hour) assuming:

* I agree with the suggested feature
* Approval from my employer to work for you (not expected to be a problem, as the context will be this project)
* I have not reached my limit of hours (40 hours - Danish VAT limit is 50,000DKK/running-12-months)

Please reach out to me via email if you would like to make use of this offer.

If the above requirements are not agreeable, you are more than welcome to fork the project and do your own thing.
