package dk.mada.jaxrs.generator.tmpl.dto;

import java.util.List;

import org.immutables.value.Value.Immutable;

/**
 * Context passed to Mustache when compiling an enum.
 */
@Immutable
public interface CtxEnum {
	List<CtxEnumEntry> enumVars();
	
	@Immutable
	interface CtxEnumEntry {
		String name();
		String value();
	}
}
