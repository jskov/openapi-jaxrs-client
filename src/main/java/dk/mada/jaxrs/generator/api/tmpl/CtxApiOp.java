package dk.mada.jaxrs.generator.api.tmpl;

import java.util.List;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

@Immutable
public interface CtxApiOp {
    static ImmutableCtxApiOp.Builder builder() {
        return ImmutableCtxApiOp.builder();
    }

    String returnType();
    String nickname();
    String httpMethod();
    @Nullable
    String path();

    List<CtxApiParam> allParams();

    List<CtxApiResponse> responses();

    CtxApiOpExt madaOp();
}
