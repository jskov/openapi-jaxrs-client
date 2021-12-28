package dk.mada.jaxrs.model;

import java.util.Set;

import org.immutables.value.Value.Immutable;

@Immutable
public interface ContainerArray extends Type {
	Type innerType();
	
	@Override
	default String typeName() {
		String innerName = innerType().typeName();
		if (innerType() instanceof Primitive p) {
			innerName = p.wrapperType();
		}
		return "List<" + innerName + ">";
	}
	
	@Override
	default Set<String> neededImports() {
		return Set.of("java.util.List", "java.util.ArrayList");
	}
}
