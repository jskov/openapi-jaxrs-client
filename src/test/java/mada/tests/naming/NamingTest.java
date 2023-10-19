package mada.tests.naming;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import dk.mada.jaxrs.model.naming.Naming;
import dk.mada.logging.LoggerConfig;

class NamingTest {
    static {
        LoggerConfig.loadConfig("/logging-test.properties");
    }

    @Test
    void catchesBadArguments() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> makeSut("REGEXP/TOO/MANY/ARGS/"))
            .withMessageContaining("Bad input for operations with two arguments")
            .withMessageContaining("REGEXP/TOO/MANY/ARGS/");
    }

    @Test
    void catchesBadArgumentTermination() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> makeSut("BAD/ARG"))
            .withMessageContaining("Operations with arguments must end with /")
            .withMessageContaining("BAD/ARG");
    }

    @Test
    void catchesUnknownArgumentOperation() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> makeSut("UNKNOWNYYY/ARG/"))
            .withMessageContaining("Unknown naming rule")
            .withMessageContaining("UNKNOWNYYY");
    }
    
    @Test
    void catchesUnknownSimpleOperation() {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> makeSut("UNKNOWNXXX"))
            .withMessageContaining("Unknown naming rule")
            .withMessageContaining("UNKNOWNXXX");
    }

    @ParameterizedTest
    @CsvSource({
        "Purpose & Scope, PurposeScopeApi",
        "Foo Bar,         FooBarApi"
    })
    void canRenameApis(String input, String expected) {
        Naming sut = makeSut("REGEXP/[ &]/-/; TYPENAME; REGEXP/Api$//; APPEND/Api/");
        assertThat(sut.convertTypeName(input))
            .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "Danske tegn dør, DanskeTegnDr",
        "Brand new api, BrandNewApi"
    })
    void canMakeIdentifiersFromSentence(String input, String expected) {
        Naming sut = makeSut("REGEXP/[æøåÆØÅ()]//; REGEXP/ /-/; TYPENAME-EDGE");
        assertThat(sut.convertTypeName(input))
            .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "foo,        foo",
        "Fo.o,       foo",
        "3.b.a.d,    _bad",
        "tr.ue,      true_"
    })
    void canRemoveDots(String input, String expected) {
        Naming sut = makeSut("REGEXP/\\.//; PROPERTYNAME");
        assertThat(sut.convertTypeName(input))
            .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "foo,        FooEnum",
        "Fo.o,       Fo_oEnum",
        "tr.ue,      Tr_ueEnum"
    })
    void canAppend(String input, String expected) {
        Naming sut = makeSut("TYPENAME; APPEND/Enum/");
        assertThat(sut.convertTypeName(input))
            .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "foo,        NUMBER_Foo",
        "Fo.o,       NUMBER_Fo_o",
        "tr.ue,      NUMBER_Tr_ue"
    })
    void canPrepend(String input, String expected) {
        Naming sut = makeSut("TYPENAME; PREPEND/NUMBER_/");
        assertThat(sut.convertTypeName(input))
            .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
        "FOO,        FOO",
        "Fo.o,       FO_O",
        "foo-bar,    FOO_BAR",
        "FOO_BAR,    FOO_BAR"
    })
    void enumNaming(String input, String expected) {
        Naming sut = makeSut("REGEXP/-/_/; TYPENAME; UPCASE");
        assertThat(sut.convertTypeName(input))
            .isEqualTo(expected);
    }

    private Naming makeSut(String rules) {
        Properties props = new Properties();
        props.setProperty("naming-rules-type", rules);
        return new Naming(props);
    }
}
