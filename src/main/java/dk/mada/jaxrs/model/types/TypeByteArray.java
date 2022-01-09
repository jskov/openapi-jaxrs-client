package dk.mada.jaxrs.model.types;

import dk.mada.jaxrs.model.types.TypeNames.TypeName;

/**
 * Special type for handing byte[] type.
 * 
 * In resources this would be treated as a stream, while it
 * it treated as an array in DTOs.
 */
public class TypeByteArray implements Type {
	/** As used in resource operations */
	private static final TypeByteArray streamType = new TypeByteArray();
	/** As used in DTOs */
	private static final TypeByteArray arrayType = new TypeByteArray();
	
	private TypeByteArray() {
	}

	public static TypeByteArray getArray() {
		return arrayType;
	}

	public static TypeByteArray getStream() {
		return streamType;
	}

	public boolean isStream() {
		return this == streamType;
	}
	
	public boolean isArray() {
		return this == arrayType;
	}
	
	
	@Override
	public TypeName typeName() {
		return TypeNames.of("byte[]");
	}

	@Override
	public String toString() {
		return isArray() ? "ByteArray[]" : "Stream";
	}
}
