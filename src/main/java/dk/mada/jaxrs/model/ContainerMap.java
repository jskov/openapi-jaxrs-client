package dk.mada.jaxrs.model;

import java.util.Set;

import org.immutables.value.Value.Immutable;

/**
 * Keys in a map must be a scalar string.
 * 
 * https://swagger.io/specification/#format
 */
@Immutable
public interface ContainerMap extends Type {
	Type innerType();
	
	@Override
	default String typeName() {
		String innerName = innerType().typeName();
		if (innerType() instanceof Primitive p) {
			innerName = p.wrapperType();
		}
		return "Map<String, " + innerName + ">";
	}
	
	@Override
	default Set<String> neededImports() {
		return Set.of("java.util.Map", "java.util.HashMap");
	}
}
