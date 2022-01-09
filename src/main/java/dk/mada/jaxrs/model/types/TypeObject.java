package dk.mada.jaxrs.model.types;

import dk.mada.jaxrs.model.types.TypeNames.TypeName;

/**
 * Special type for handing object type.
 */
public class TypeObject implements Type {
	private static final TypeObject object = new TypeObject();
	
	private TypeObject() {
	}

	public static TypeObject get() {
		return object;
	}
	
	@Override
	public TypeName typeName() {
		return TypeNames.of("Object");
	}
}
