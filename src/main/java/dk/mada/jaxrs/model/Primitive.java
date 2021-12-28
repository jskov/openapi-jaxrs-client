package dk.mada.jaxrs.model;

import java.util.Objects;

public enum Primitive implements Type {
	BOOLEAN("boolean:", "boolean"),
	BYTE("string:byte", "byte"),
	SHORT("integer:", "short"),
	INT("integer:int32", "int"),
	LONG("integer:int64", "long"),
	STRING("string:", "String");
	
	/** The OpenApi type:format **/
	private String typeFormat;
	/** The Java language primitive name */
	private String javaPrimitive;

	private Primitive(String typeFormat, String javaPrimitive) {
		this.typeFormat = typeFormat;
		this.javaPrimitive = javaPrimitive;
	}
	
	public String typeName() {
		return javaPrimitive;
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
