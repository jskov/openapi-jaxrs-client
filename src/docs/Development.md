# Development

## IDE setup

To prepare eclipse settings to get eclipse/vscode to work with APT run this task:

    ./gradlew prepCodeGen

## Testing notes

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

Via its `settings.gradle` it will build the gradle plugin in this project and use it when you run:

    ./gradlew gen
