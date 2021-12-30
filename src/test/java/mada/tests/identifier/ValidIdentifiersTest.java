package mada.tests.identifier;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import dk.mada.jaxrs.generator.Identifiers;

public class ValidIdentifiersTest {
	private Identifiers sut = new Identifiers();
	
	@ParameterizedTest
	@CsvSource({
		"foo,        foo",
		"Foo,        foo",
		"3bad,       _bad",
	})
	void variableNamesValid(String input, String expected) {
		assertThat(sut.makeValidVariableName(input))
			.isEqualTo(expected);
	}
}
