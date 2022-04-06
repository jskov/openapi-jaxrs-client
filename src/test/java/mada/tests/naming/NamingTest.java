package mada.tests.naming;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Properties;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import dk.mada.jaxrs.naming.Naming;
import dk.mada.logging.LoggerConfig;

class NamingTest {
    static {
        LoggerConfig.loadConfig("/logging-test.properties");
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
