package dk.mada.jaxrs.generator.api.tmpl;

import org.immutables.value.Value.Immutable;

@Immutable
public interface CtxApiParam {
    /** {@return a builder for this type} */
    static ImmutableCtxApiParam.Builder builder() {
        return ImmutableCtxApiParam.builder();
    }

    String baseName();
    String paramName();
    String dataType();
    boolean required();

    boolean isBodyParam();
    boolean isHeaderParam();
    boolean isPathParam();
    boolean isQueryParam();

    CtxApiParamExt madaParam();
}
