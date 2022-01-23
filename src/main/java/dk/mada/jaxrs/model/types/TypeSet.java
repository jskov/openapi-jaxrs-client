package dk.mada.jaxrs.model.types;

import java.util.Set;

import org.immutables.value.Value.Immutable;

import dk.mada.jaxrs.generator.Imports;
import dk.mada.jaxrs.model.types.TypeNames.TypeName;

@Immutable
public interface TypeSet extends Type {
	public static TypeSet of(Type innerType) {
		return ImmutableTypeSet.builder().innerType(innerType).build();
	}

	Type innerType();
	
	@Override
	default TypeName typeName() {
		String innerName = innerType().wrapperTypeName().name();
		return TypeNames.of("Set<" + innerName + ">");
	}
	
	@Override
	default Set<String> neededImports() {
		return Imports.SET_TYPES;
	}
}
