# Testing notes

In Eclipse, add build/e2e as a source folder (and exclude **/*.java) to get easy access to test output.

When making changes that affect multiple tests, it can be handy to make a bulk update like this:

    ./gradlew test
    cp -r build/e2e/mada/tests src/test/java/mada/

And then inspect the git diff output.
