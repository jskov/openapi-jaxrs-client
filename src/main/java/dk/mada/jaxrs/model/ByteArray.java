package dk.mada.jaxrs.model;

/**
 * Special type for handing byte[] type.
 * 
 * In resources this would be treated as a stream, while it
 * it treated as an array in DTOs.
 */
public class ByteArray implements Type {
	/** As used in resource operations */
	private static final ByteArray streamType = new ByteArray();
	/** As used in DTOs */
	private static final ByteArray arrayType = new ByteArray();
	
	private ByteArray() {
	}

	public static ByteArray getArray() {
		return arrayType;
	}

	public static ByteArray getStream() {
		return streamType;
	}

	public boolean isStream() {
		return this == streamType;
	}
	
	public boolean isArray() {
		return this == arrayType;
	}
	
	
	@Override
	public String typeName() {
		return "byte[]";
	}
}
