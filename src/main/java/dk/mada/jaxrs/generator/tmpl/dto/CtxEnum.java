package dk.mada.jaxrs.generator.tmpl.dto;

import java.util.List;

/**
 * Context passed to Mustache when compiling an enum.
 */
public record CtxEnum(List<CtxEnumEntry> enumVars) {
	
	public record CtxEnumEntry(String name, String value) {}
}
