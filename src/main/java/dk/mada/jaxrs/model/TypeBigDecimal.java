package dk.mada.jaxrs.model;

import java.util.Set;

/**
 * Special type for handing number schema.
 */
public class TypeBigDecimal implements Type {
	private static final TypeBigDecimal object = new TypeBigDecimal();
	
	private TypeBigDecimal() {
	}

	public static TypeBigDecimal get() {
		return object;
	}
	
	@Override
	public String typeName() {
		return "BigDecimal";
	}
	
	@Override
	public Set<String> neededImports() {
		return Set.of("java.math.BigDecimal");
	}
}
