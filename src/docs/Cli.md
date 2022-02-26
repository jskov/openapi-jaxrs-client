# CLI Usage

The full CLI invocation help is:

```console
$ java -jar ojc-x.y.z-cli.jar --help
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
