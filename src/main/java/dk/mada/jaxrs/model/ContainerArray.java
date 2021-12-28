package dk.mada.jaxrs.model;

import org.immutables.value.Value.Immutable;

@Immutable
public interface ContainerArray extends Type {
	Type innerType();
	
	@Override
	default String typeName() {
		return innerType().typeName()+"[]";
	}
}
