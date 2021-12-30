package dk.mada.jaxrs.model;

import java.util.Objects;

public enum Primitive implements Type {
	BOOLEAN("boolean:",    "boolean", "Boolean"),
	BYTE("string:byte",    "byte",    "Byte"),
	SHORT("integer:",      "short",   "Short"),
	INT("integer:int32",   "int",     "Integer"),
	LONG("integer:int64",  "long",    "Long"),
	FLOAT("number:float",  "float",   "Float"),
	DOUBLE("number:double","double",  "Double"),
	STRING("string:",      "String",  "String");
	
	/** The OpenApi type:format **/
	private String typeFormat;
	/** The Java language primitive name */
	private String javaPrimitive;
	/** Java lang wrapper type */
	private String wrapperType;

	private Primitive(String typeFormat, String javaPrimitive, String wrapperType) {
		this.typeFormat = typeFormat;
		this.javaPrimitive = javaPrimitive;
		this.wrapperType = wrapperType;
	}
	
	public String typeName() {
		return javaPrimitive;
	}
	
	public String wrapperType() {
		return wrapperType;
	}
	
	public static Primitive find(String type, String format) {
		String typeFormat = type + ":" + Objects.toString(format, "");
		for (var p : Primitive.values()) {
			if (p.typeFormat.equals(typeFormat)) {
				return p;
			}
		}
		return null;
	}
}
