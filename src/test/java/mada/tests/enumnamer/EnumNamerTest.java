package mada.tests.enumnamer;

import static java.util.stream.Collectors.joining;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import dk.mada.jaxrs.GeneratorException;
import dk.mada.jaxrs.generator.EnumNamer;
import dk.mada.jaxrs.generator.EnumNamer.EnumNameValue;
import dk.mada.jaxrs.model.Primitive;
import dk.mada.jaxrs.model.TypeObject;

public class EnumNamerTest {
	@Test
	void usesNumerPrefixForNumberTypes() {
		var sut = new EnumNamer(Primitive.INT, List.of("1", "3", "2"));
		
		assertThat(str(sut.getEntries()))
				.isEqualTo("NUMBER_1:1, NUMBER_3:3, NUMBER_2:2");
	}

	@Test
	void useSuffixCaseOnConflicts1() {
		var sut = new EnumNamer(TypeObject.get(), List.of("aaa", "Aaa", "aaA"));
		
		assertThat(str(sut.getEntries()))
				.isEqualTo("AAA_aaa:aaa, AAA_Aaa:Aaa, AAA_aaA:aaA");
	}

	@Test
	void useSuffixCaseOnConflicts2() {
		var sut = new EnumNamer(TypeObject.get(), List.of("aaa?", "Aaa!"));
		
		assertThat(str(sut.getEntries()))
				.isEqualTo("AAA__aaa_:aaa?, AAA__Aaa_:Aaa!");
	}

	/**
	 * If the suffix-case has failed to resolve conflicts,
	 * add a counter.
	 */
	@Test
	void useSuffixNumbersOnOtherConflicts1() {
		var sut = new EnumNamer(TypeObject.get(), List.of("bad?", "bad!", "badAA"));
		
		assertThat(str(sut.getEntries()))
				.isEqualTo("BAD__1:bad?, BAD__2:bad!, BADAA:badAA");
	}

	/**
	 * Need some other fallback mechanism. But would like to see some
	 * relevant input first - instead of these very contrived ones.
	 */
	@Test
	void cannotBeHandledAtPresent() {
		assertThrows(GeneratorException.class, () -> new EnumNamer(TypeObject.get(), List.of("bad?", "bad!", "ok", "bad__1")));
	}

	private String str(List<EnumNameValue> entries) {
		return entries.stream()
			.map(e -> e.name() + ":" + e.value())
			.collect(joining(", "));
	}
}
