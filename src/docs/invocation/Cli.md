The generator can be invoked from a [picocli](https://picocli.info/)-based command line, provided by a Shadow jar containing all the dependencies.

The shadow artifact (generator-cli-VERSION-cli.jar) is published to [MavenCentral](https://central.sonatype.com/artifact/dk.mada.jaxrs/generator-cli/versions) with the other artifacts.

Click on the `Browse` link of the latest version and download the shadow artifact and its `.asc` file. Then [verify the signature](./index.md#verify-signing).

Finally, you must run it with a java 21 runtime. The full CLI invocation help is:

```console
$ java -jar generator-cli-VERSION-cli.jar --help
Usage: ojc [-hV] [--debug] [--overwrite] [--skip-api-generation]
           [--skip-dto-generation] [--trace] [--api-package=<apiPackage>]
           [-c=<configuration>] [--dto-package=<dtoPackage>] -i=<inputDocument>
           -o=<outputDir>
Generates API resource (interfaces) and DTO model (classes) from an OpenApi
document. The output is suitable for use with a Micro Profile REST client.
      --api-package=<apiPackage>
                    Package to place the API classes in.
  -c, --config=<configuration>
                    Configuration properties.
                      Default: null
      --debug       Show debug-level log output.
      --dto-package=<dtoPackage>
                    Package to place the DTO classes in.
  -h, --help        Show this help message and exit.
  -i, --input=<inputDocument>
                    OpenApi document input.
  -o, --output-directory=<outputDir>
                    Output directory for the generated classes.
      --overwrite   Write output to existing output directory, delete existing
                      api/dto packages.
      --skip-api-generation
                    Skip generation of API classes.
      --skip-dto-generation
                    Skip generation of DTO classes.
      --trace       Show trace-level log output.
  -V, --version     Print version information and exit.
```

### Example Output

```console
$ cat > petstore.properties <<EOF
parser-api-preferred-request-mediatypes = application/json
parser-api-preferred-response-mediatypes = application/json
EOF

$ $ java -jar generator-cli-0.12.3-cli.jar --api-package foo.bar.api --dto-package foo.bar.dto -i petstore.yaml -o /tmp/output
[2025-04-23 17:23:39] [INFO] Reads OpenApi document from petstore.yaml
[2025-04-23 17:23:39] [INFO] Generates files in /tmp/output
[2025-04-23 17:23:39] [INFO] Reading config from petstore.properties
[2025-04-23 17:23:39] [INFO] Found service dk.mada.jaxrs.generator.mpclient.Generator
[2025-04-23 17:23:39] [INFO] Total 1 services
Generate client
 Context: ClientContext[overwrite=false, logLevel=DEFAULT, skipApi=false, skipDto=false, showParserInfo=false]
 OpenApi doc: petstore.yaml
 Dest dir: /tmp/output
 Options: {generator-dto-package=foo.bar.dto, parser-api-preferred-response-mediatypes=application/json, generator-api-package=foo.bar.api, parser-api-preferred-request-mediatypes=application/json}
[2025-04-23 17:23:39] [INFO] Parsing API path /pet
[2025-04-23 17:23:39] [INFO] Parsing API path /pet/findByStatus
[2025-04-23 17:23:39] [INFO] Parsing API path /pet/findByTags
[2025-04-23 17:23:39] [INFO] Parsing API path /pet/{petId}
[2025-04-23 17:23:39] [INFO] Parsing API path /pet/{petId}/uploadImage
[2025-04-23 17:23:39] [INFO] Parsing API path /store/inventory
[2025-04-23 17:23:39] [INFO] Parsing API path /store/order
[2025-04-23 17:23:39] [INFO] Parsing API path /store/order/{orderId}
[2025-04-23 17:23:39] [INFO] Parsing API path /user
[2025-04-23 17:23:39] [INFO] Parsing API path /user/createWithList
[2025-04-23 17:23:39] [INFO] Parsing API path /user/login
[2025-04-23 17:23:39] [INFO] Parsing API path /user/logout
[2025-04-23 17:23:39] [INFO] Parsing API path /user/{username}
[2025-04-23 17:23:39] [INFO] Parsing DTO ApiResponse
[2025-04-23 17:23:39] [INFO] Parsing DTO Category
[2025-04-23 17:23:39] [INFO] Parsing DTO Order
[2025-04-23 17:23:39] [INFO] Parsing DTO Pet
[2025-04-23 17:23:39] [INFO] Parsing DTO Tag
[2025-04-23 17:23:39] [INFO] Parsing DTO User
[2025-04-23 17:23:39] [INFO] Generating API PetApi
[2025-04-23 17:23:39] [INFO] Generating API StoreApi
[2025-04-23 17:23:39] [INFO] Generating API UserApi
[2025-04-23 17:23:39] [INFO] Generating DTO ApiResponse
[2025-04-23 17:23:39] [INFO] Generating DTO Category
[2025-04-23 17:23:39] [INFO] Generating DTO Order
[2025-04-23 17:23:39] [INFO] Generating DTO Pet
[2025-04-23 17:23:39] [INFO] Generating DTO Tag
[2025-04-23 17:23:39] [INFO] Generating DTO User
...

$ tree /tmp/output/
/tmp/output/
└── foo
    └── bar
        ├── api
        │   ├── PetApi.java
        │   ├── StoreApi.java
        │   └── UserApi.java
        └── dto
            ├── ApiResponse.java
            ├── Category.java
            ├── Order.java
            ├── Pet.java
            ├── Tag.java
            └── User.java

5 directories, 9 files
```

The output looks something like [this (petstore)](https://github.com/jskov/openapi-jaxrs-client/tree/main/modules/generator/src/test/java/mada/tests/e2e/examples/petstore).

