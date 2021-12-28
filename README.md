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


## Testing

In Eclipse, add build/e2e as a source folder (and exclude **/*.java) to get easy access to test output.
