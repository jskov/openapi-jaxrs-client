package dk.mada.jaxrs.generator.tmpl.dto;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

/**
 * Custom extensions. In separate (mada.) context so they are
 * easier to spot in the templates.
 */
@Immutable
public interface CtxPropertyExt {
	@Nullable
	String innerDatatypeWithEnum();
	
	boolean isRenderApiModelProperty();
	boolean isUseBigDecimalForDouble();
	
	String getter();
	String setter();
}
