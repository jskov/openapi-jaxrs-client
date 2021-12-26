package dk.mada.jaxrs.model;

import org.immutables.value.Value.Immutable;

/**
 * Context passed to Mustache when compiling a model.
 */
@Immutable
public interface CtxModel {
	Info info();
	Type type();
}
