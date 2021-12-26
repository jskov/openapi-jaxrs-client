package dk.mada.jaxrs.model;

import org.immutables.value.Value.Immutable;

@Immutable
public interface Operation {
	String group();
	String path();
}
