package mada.tests.identifier;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import dk.mada.jaxrs.model.naming.Identifiers;

/**
 * Tests conversion of strings into valid identifiers.
 */
class ValidIdentifiersTest {
    /** System under test. */
    private Identifiers sut = new Identifiers();

    @ParameterizedTest
    @CsvSource({
            "foo,        foo",
            "Foo,        foo",
            "3bad,       _bad",
            "true,       true_",
            "FooBAR,     fooBAR",
            "ID,         iD",
            "iD,         iD",
            "id,         id",
            "Id,         id",
            "FOOBar,     fOOBar",
            "delisH,     delisH",
            "fooBar,     fooBar",
            "foo-bar,    fooBar"
    })
    void variableNamesValid(String input, String expected) {
        assertThat(sut.makeValidVariableName(input))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "foo,        foo",
            "Foo,        foo",
            "3bad,       _bad",
            "true,       true_",
            "FooBAR,     fooBar",
            "ID,         id",
            "iD,         iD",
            "id,         id",
            "Id,         id",
            "FOOBar,     fooBar",
            "delisH,     delisH",
            "fooBar,     fooBar",
            "foo-bar,    fooBar"
    })
    void edgeVariableNamesValid(String input, String expected) {
        assertThat(sut.makeValidEdgeVariableName(input))
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "Foo,        Foo",
            "foo,        Foo",
            "3bad,       _bad",
            "foo-bar,    FooBar",
            "ID,         ID",
            "iD,         ID",
            "id,         Id",
            "Id,         Id",
    })
    void typeNamesValid(String input, String expected) {
        assertThat(sut.makeValidTypeName(input))
                .isEqualTo(expected);
    }
}
