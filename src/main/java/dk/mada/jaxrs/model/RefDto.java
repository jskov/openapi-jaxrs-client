package dk.mada.jaxrs.model;

import org.immutables.value.Value.Immutable;

/**
 * A reference to a sibling DTO.
 * 
 * The sibling may not have been processed yet,
 * hence this type which acts as a lazy delegation.
 */
@Immutable
public interface RefDto extends Type {
	String openapiName();
	Dtos dtos();

	default Dto dereference() {
		return dtos().dereference(this);
	}
	
	@Override
	default String typeName() {
		return dereference().openapiName();
	}
}
