package dk.mada.jaxrs.model;

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
	public String typeName() {
		return "Object";
	}
}
