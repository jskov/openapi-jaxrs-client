package dk.mada.jaxrs.model.types;

import dk.mada.jaxrs.model.types.TypeNames.TypeName;

/**
 * Special type for handing void type.
 */
public class TypeVoid implements Type {
	private static final TypeVoid object = new TypeVoid();
	
	private TypeVoid() {
	}

	public static TypeVoid get() {
		return object;
	}
	
	@Override
	public TypeName typeName() {
		return TypeNames.of("void");
	}
}
