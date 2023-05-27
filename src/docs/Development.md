# Development

## IDE setup

To prepare eclipse settings to get eclipse/vscode to work with APT run this task:

    ./gradlew prepCodeGen

## Testing notes

### Running subset of tests from Gradle

This will run whichever tests match `testNameContains` in TestIterator:

    ./gradlew -Drun_all_tests=false :test --tests TestIterator

If the templates are changed, add:

    rm -rf build/classes/java/main/dk/mada/jaxrs/generator


### Updating expected output

In Eclipse, add build/e2e as a source folder (and exclude **/*.java) to get easy access to test output.

When making changes that affect multiple tests, it can be handy to make a bulk update like this:

    ./gradlew test
    cp -r build/e2e/mada/tests src/test/java/mada/

And then inspect the git diff output.

### Java 17

Running the gradle plugin junit tests under Java 17 causes:

    Caused by: java.lang.IllegalAccessException: module java.base does not open java.lang to unnamed module @12405818
    
Add to the test runner vm arguments:

    --add-opens java.base/java.lang=ALL-UNNAMED

## Gradle Plugin

Clone the [examples](https://github.com/jskov/openapi-jaxrs-client-examples) project next to this project.

It will load the generator built from this project via:

    # Run in this project
    ./gradlew publishToMavenLocal
    
    # Run in openapi-jaxrs-client-examples
    ./plugin-dev.sh gen

Changes to the plugin code will be updated automatically.
But changes to the generator need to be published.
