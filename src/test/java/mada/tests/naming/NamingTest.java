package mada.tests.naming;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Properties;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import dk.mada.jaxrs.naming.Naming;
import dk.mada.jaxrs.naming.NamingOpts;
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

	private Naming makeSut(String rules) {
		Properties props = new Properties();
		props.setProperty(NamingOpts.NAMING_RULES_TYPE, rules);
		return new Naming(props);
	}
}
