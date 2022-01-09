package dk.mada.jaxrs.model.types;

import java.util.Objects;

import dk.mada.jaxrs.model.types.TypeNames.TypeName;

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
	private TypeName javaPrimitive;
	/** Java lang wrapper type */
	private TypeName wrapperType;

	private Primitive(String typeFormat, String javaPrimitive, String wrapperType) {
		this.typeFormat = typeFormat;
		this.javaPrimitive = TypeNames.of(javaPrimitive);
		this.wrapperType = TypeNames.of(wrapperType);
	}
	
	public TypeName typeName() {
		return javaPrimitive;
	}
	
	@Override
	public TypeName wrapperTypeName() {
		return wrapperType;
	}
	
	public static Primitive find(TypeName tn) {
		for (var p : Primitive.values()) {
			if (tn.equals(p.javaPrimitive) || tn.equals(p.wrapperType)) {
				return p;
			}
		}
		return null;
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
