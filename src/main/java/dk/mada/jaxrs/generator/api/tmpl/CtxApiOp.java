package dk.mada.jaxrs.generator.api.tmpl;

import java.util.List;

import javax.annotation.Nullable;

import org.immutables.value.Value.Immutable;

/**
 * Template data for an API operation.
 */
@Immutable
public interface CtxApiOp {
    /** {@return a builder for this type} */
    static ImmutableCtxApiOp.Builder builder() {
        return ImmutableCtxApiOp.builder();
    }

    /** {@return the operation return type} */
    String returnType();
    /** {@return the operation nickname} */
    String nickname();
    /** {@return the operation http method} */
    String httpMethod();
    /** {@return the operation path} */
    @Nullable
    String path();
    /** {@return the operation summary} */
    @Nullable
    String summary();
    /** {@return the operation notes} */
    @Nullable
    String notes();

    /** {@return all parameters of the operation} */
    List<CtxApiParam> allParams();

    /** {@return all responses of the operation} */
    List<CtxApiResponse> responses();

    /** {@return additional custom template data for the operation} */
    CtxApiOpExt madaOp();
}
