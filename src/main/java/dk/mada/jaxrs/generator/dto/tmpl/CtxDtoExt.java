package dk.mada.jaxrs.generator.dto.tmpl;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

/**
 * Custom extensions. In separate (mada.) context so they are
 * easier to spot in the templates.
 */
@Immutable
public interface CtxDtoExt {
	public static ImmutableCtxDtoExt.Builder builder() {
		return ImmutableCtxDtoExt.builder();
	}

	@Nullable
	String jacksonJsonSerializeOptions();

	@Nullable
	String customLocalDateDeserializer();
	@Nullable
	String customLocalDateSerializer();

	@Nullable
	String customOffsetDateTimeDeserializer();
	@Nullable
	String customOffsetDateTimeSerializer();

	boolean jsonb();
}
