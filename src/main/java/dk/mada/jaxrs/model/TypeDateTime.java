package dk.mada.jaxrs.model;

import java.util.Set;

import dk.mada.jaxrs.generator.GeneratorOpts;

/**
 * Special type for handing date-time schema.
 */
public class TypeDateTime implements Type {
	private static final TypeDateTime instanceOffset = new TypeDateTime("OffsetDateTime", "java.time.OffsetDateTime");
	private static final TypeDateTime instanceZoned = new TypeDateTime("ZonedDateTime", "java.time.ZonedDateTime");
	
	private final String typeName;
	private final Set<String> neededImports;

	public TypeDateTime(String typeName, String importName) {
		this.typeName = typeName;
		this.neededImports = Set.of(importName);
	}

	public static TypeDateTime get(GeneratorOpts opts) {
		return opts.isUseZonedDateTime() ? instanceZoned : instanceOffset;
	}
	
	@Override
	public String typeName() {
		return typeName;
	}
	
	@Override
	public Set<String> neededImports() {
		return neededImports;
	}
	
	@Override
	public boolean isDateTime() {
		return true;
	}
}
