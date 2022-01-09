package dk.mada.jaxrs.model.types;

import java.util.Set;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.model.types.TypeNames.TypeName;

@Immutable
public interface TypeArray extends Type {
	public static TypeArray of(Type innerType) {
		return ImmutableTypeArray.builder().innerType(innerType).build();
	}
	
	Type innerType();
	
	@Override
	default TypeName typeName() {
		String innerName = innerType().wrapperTypeName().name();
		return TypeNames.of("List<" + innerName + ">");
	}
	
	@Override
	default Set<String> neededImports() {
		return Set.of("java.util.List", "java.util.ArrayList");
	}
}
