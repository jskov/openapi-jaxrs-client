package dk.mada.jaxrs.generator.dto.tmpl;

import java.util.List;

/**
 * Context passed to Mustache when compiling an enum.
 */
public record CtxEnum(List<CtxEnumEntry> enumVars) {
	
	public record CtxEnumEntry(String name, String value) {}
}
